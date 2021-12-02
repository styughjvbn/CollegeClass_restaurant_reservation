package github;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.table.DefaultTableModel;

public class reservation extends JPanel {
	private JTable table;
	private JTable table_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private DAO_reservation DAO=new DAO_reservation();
	public DTO_customer cnt_user;
	private CardLayout card=new CardLayout(0, 0);
	JPanel panel_2;
	JPanel panel;
	/**
	 * Create the panel.
	 */
	void init(String id) {
		ArrayList<String[]> cnt_reservation=DAO.get_reservation_cnt(id);
		DefaultTableModel temp=(DefaultTableModel)table.getModel();
		int num=temp.getRowCount();
		for(int i=0; i<num;i++) {
			temp.removeRow(0);
		}
		for(int i=0; i<cnt_reservation.size();i++) {
			temp.addRow(cnt_reservation.get(i));
		}
	}
	void init2(String id) {
		ArrayList<String[]> old_reservation=DAO.get_reservation_old(id);
		DefaultTableModel temp=(DefaultTableModel)table_1.getModel();
		int num=temp.getRowCount();
		for(int i=0; i<num;i++) {
			temp.removeRow(0);
		}
		for(int i=0; i<old_reservation.size();i++) {
			temp.addRow(old_reservation.get(i));
		}
	}
	void nextcard(int i) {
		if(i==1)
		card.show(panel.getParent(), "update");
		else
			card.show(panel.getParent(), "check");
	}
	public reservation() {
		setLayout(card);
		
		panel = new JPanel();
		panel.setBackground(new Color(226,221,215));
		add(panel, "check");
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uBC29\uBB38\uC608\uC57D \uC810\uD3EC");
		lblNewLabel.setFont(new Font("세방고딕 굵게", Font.BOLD, 15));
		lblNewLabel.setBounds(51, 102, 212, 21);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 133, 600, 150);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("세방고딕 보통", Font.PLAIN, 15));
		table.setBorder(null);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"식당", "인원수", "예약시간", "예약날짜", "예약금", "예약메뉴", "예약테이블", "예약한시간"
			}
		));
		table.setBackground(new Color(226,221,215));
		scrollPane.setViewportView(table);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(52, 365, 700, 150);
		panel.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setFont(new Font("세방고딕 보통", Font.PLAIN, 15));
		table_1.setBorder(null);
		table_1.setModel(new DefaultTableModel(
				
			new Object[][] {
			},
			new String[] {
				"식당", "예약시간", "예약날짜", "인원수", "예약금", "예약메뉴"
			}
		));
		table_1.setBackground(new Color(226,221,215));
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uBC29\uBB38\uD55C \uC810\uD3EC");
		lblNewLabel_1.setFont(new Font("세방고딕 굵게", Font.BOLD, 15));
		lblNewLabel_1.setBounds(51, 334, 199, 21);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("\uC608\uC57D\r\n\uCDE8\uC18C");
		btnNewButton_1.setFont(new Font("세방고딕 굵게", Font.BOLD, 14));
		btnNewButton_1.setBorder(new LineBorder(new Color(200, 184, 164), 2, true));
		btnNewButton_1.setBackground(new Color(200, 184, 164));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel temp=(DefaultTableModel)table.getModel();
				try {
					String shop=(String)temp.getValueAt(table.getSelectedRow(), 0);
					String time=(String)temp.getValueAt(table.getSelectedRow(), 7);
					DAO.delete_reservation(cnt_user.get_ID(),shop,time);
					temp.removeRow(table.getSelectedRow());
				}catch(Exception me){
					   System.out.println(me.getMessage());
				  }
			}
		});
		btnNewButton_1.setBounds(677, 133, 75, 150);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(226,221,215));
		add(panel_1, "update");
		panel_1.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(139, 84, 455, 35);
		panel_1.add(passwordField);

		passwordField.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		passwordField.setText("Password를 입력해주세요.");
		passwordField.setFont(new Font("SEBANG Gothic", Font.PLAIN, 20));
		passwordField.setForeground(Color.LIGHT_GRAY);
		passwordField.setBackground(Color.WHITE);
		passwordField.setEchoChar((char) 0);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (passwordField.getText().equals("Password를 입력해주세요.")) {
					passwordField.setText("");
					passwordField.setEchoChar('*');
					passwordField.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (passwordField.getText().equals("")) {
					passwordField.setEchoChar((char) 0);
					passwordField.setForeground(Color.LIGHT_GRAY);
					passwordField.setText("Password를 입력해주세요.");
				}
			}
		});
		
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.setBounds(606, 84, 97, 32);
		btnNewButton.setFont(new Font("세방고딕 굵게", Font.BOLD, 14));
		btnNewButton.setBorder(new LineBorder(new Color(200, 184, 164), 2, true));
		btnNewButton.setBackground(new Color(200, 184, 164));
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("\uD604\uC7AC \uBE44\uBC00\uBC88\uD638");
		lblNewLabel_2.setFont(new Font("세방고딕 굵게", Font.BOLD, 15));
		lblNewLabel_2.setBounds(139, 75, 212, 21);
		lblNewLabel_2.setBounds(139, 48, 121, 15);
		panel_1.add(lblNewLabel_2);
		
		panel_2 = new JPanel();
		panel_2.setVisible(false);
		panel_2.setBackground(new Color(226,221,215));
		panel_2.setBounds(105, 150, 603, 256);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(36, 83, 455, 35);
		panel_2.add(passwordField_1);
		passwordField_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		passwordField_1.setText("Password를 입력해주세요.");
		passwordField_1.setFont(new Font("SEBANG Gothic", Font.PLAIN, 20));
		passwordField_1.setForeground(Color.LIGHT_GRAY);
		passwordField_1.setBackground(Color.WHITE);
		passwordField_1.setEchoChar((char) 0);
		passwordField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (passwordField_1.getText().equals("Password를 입력해주세요.")) {
					passwordField_1.setText("");
					passwordField_1.setEchoChar('*');
					passwordField_1.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (passwordField_1.getText().equals("")) {
					passwordField_1.setEchoChar((char) 0);
					passwordField_1.setForeground(Color.LIGHT_GRAY);
					passwordField_1.setText("Password를 입력해주세요.");
				}
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("\uC0C8\uB85C\uC6B4 \uBE44\uBC00\uBC88\uD638");
		lblNewLabel_3.setFont(new Font("세방고딕 굵게", Font.BOLD, 15));
		lblNewLabel_3.setBounds(36, 52, 212, 21);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uC0C8\uB85C\uC6B4 \uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		lblNewLabel_4.setFont(new Font("세방고딕 굵게", Font.BOLD, 15));
		lblNewLabel_4.setBounds(36, 128, 200, 15);
		panel_2.add(lblNewLabel_4);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(36, 153, 455, 35);
		panel_2.add(passwordField_2);
		passwordField_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		passwordField_2.setText("Password를 입력해주세요.");
		passwordField_2.setFont(new Font("SEBANG Gothic", Font.PLAIN, 20));
		passwordField_2.setForeground(Color.LIGHT_GRAY);
		passwordField_2.setBackground(Color.WHITE);
		passwordField_2.setEchoChar((char) 0);
		passwordField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (passwordField_2.getText().equals("Password를 입력해주세요.")) {
					passwordField_2.setText("");
					passwordField_2.setEchoChar('*');
					passwordField_2.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (passwordField_2.getText().equals("")) {
					passwordField_2.setEchoChar((char) 0);
					passwordField_2.setForeground(Color.LIGHT_GRAY);
					passwordField_2.setText("Password를 입력해주세요.");
				}
			}
		});
		
		JButton btnNewButton_2 = new JButton("\uBCC0\uACBD");
		btnNewButton_2.setFont(new Font("세방고딕 굵게", Font.BOLD, 14));
		btnNewButton_2.setBorder(new LineBorder(new Color(200, 184, 164), 2, true));
		btnNewButton_2.setBackground(new Color(200, 184, 164));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwordField_1.getText().toString().equals(passwordField_2.getText().toString())) {
					DAO.update_pw(cnt_user.get_ID(),passwordField_1.getText().toString());
					System.out.println("바뀜");
				}
			}
		});
		btnNewButton_2.setBounds(503, 153, 90, 35);
		panel_2.add(btnNewButton_2);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pw=cnt_user.get_PW();
				if(passwordField.getText().toString().equals(pw)) {
					panel_2.setVisible(true);
				}
			}
		});
	}
	void set_(){
		passwordField_2.setText("Password를 입력해주세요.");
		passwordField_2.setForeground(Color.LIGHT_GRAY);
		passwordField_2.setEchoChar((char) 0);
		passwordField_1.setText("Password를 입력해주세요.");
		passwordField_1.setForeground(Color.LIGHT_GRAY);
		passwordField_1.setEchoChar((char) 0);
		passwordField.setText("Password를 입력해주세요.");
		passwordField.setForeground(Color.LIGHT_GRAY);
		passwordField.setEchoChar((char) 0);
		panel_2.setVisible(false);
		DefaultTableModel temp=(DefaultTableModel)table.getModel();
		int num=temp.getRowCount();
		for(int i=0; i<num;i++) {
			temp.removeRow(0);
		}
		DefaultTableModel tmp=(DefaultTableModel)table_1.getModel();
		num=tmp.getRowCount();
		for(int i=0; i<num;i++) {
			tmp.removeRow(0);
		}
		setVisible(false);
	}
}

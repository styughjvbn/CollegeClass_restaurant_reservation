package github;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Color;
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
		lblNewLabel.setBounds(51, 108, 76, 15);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 133, 600, 150);
		panel.add(scrollPane);
		
		table = new JTable();
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
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"식당", "예약시간", "예약날짜", "인원수", "예약금", "예약메뉴"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uBC29\uBB38\uD55C \uC810\uD3EC");
		lblNewLabel_1.setBounds(50, 334, 199, 21);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("\uC608\uC57D\uCDE8\uC18C");
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
		passwordField.setBounds(179, 114, 355, 21);
		panel_1.add(passwordField);
		
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.setBounds(606, 113, 97, 23);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("\uD604\uC7AC \uBE44\uBC00\uBC88\uD638");
		lblNewLabel_2.setBounds(179, 89, 121, 15);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setVisible(false);
		panel_2.setBackground(new Color(226,221,215));
		panel_2.setBounds(139, 169, 565, 190);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(36, 39, 350, 21);
		panel_2.add(passwordField_1);
		
		JLabel lblNewLabel_3 = new JLabel("\uC0C8\uB85C\uC6B4 \uBE44\uBC00\uBC88\uD638");
		lblNewLabel_3.setBounds(29, 14, 122, 15);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uC0C8\uB85C\uC6B4 \uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		lblNewLabel_4.setBounds(36, 90, 143, 15);
		panel_2.add(lblNewLabel_4);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(36, 115, 355, 21);
		panel_2.add(passwordField_2);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwordField_1.getText().toString().equals(passwordField_2.getText().toString())) {
					DAO.update_pw(cnt_user.get_ID(),passwordField_1.getText().toString());
					System.out.println("바뀜");
				}
			}
		});
		btnNewButton_2.setBounds(433, 114, 97, 23);
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
}

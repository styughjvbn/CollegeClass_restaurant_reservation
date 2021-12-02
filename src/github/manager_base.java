package github;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class manager_base extends JPanel {
	public manager_shop table_manage;
	public CardLayout card = new CardLayout();
	public DTO_manager cnt_user = null;
	public JButton btnNewButton_3;
	public manage_menu manage_menu;
	public manage_reservation reservation_list;
	public String shopname;
	JPasswordField pwf = new JPasswordField();
	JPasswordField pwf1 = new JPasswordField();
	JPasswordField pwf2 = new JPasswordField();
	DAO_manager DAO=new DAO_manager();
	JPanel panel_3;
	JPanel panel_2;

	/**
	 * Create the panel.
	 */
	void init() {
		pwf.setText("Password를 입력해주세요.");
		pwf.setForeground(Color.LIGHT_GRAY);
		pwf.setEchoChar((char) 0);
		pwf1.setText("Password를 입력해주세요.");
		pwf1.setForeground(Color.LIGHT_GRAY);
		pwf1.setEchoChar((char) 0);
		pwf2.setText("Password를 입력해주세요.");
		pwf2.setForeground(Color.LIGHT_GRAY);
		pwf2.setEchoChar((char) 0);
		panel_3.setVisible(false);
		panel_2.setVisible(false);
	}
	public manager_base() {
		setLayout(card);
		table_manage = new manager_shop();// 점포관리 패널
		JPanel panel = new JPanel();// 점포관리 패널
		add(panel, "main");
		panel.setLayout(null);

		add(table_manage, "table_manage");// 점포관리 패널
		manage_menu = new manage_menu();
		add(manage_menu, "menu_manage");// 점포관리 패널
		reservation_list = new manage_reservation();
		add(reservation_list, "manage_reservation");
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("image/manage1.png"));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		btnNewButton.setBackground(new Color(204, 153, 102));
		btnNewButton.setFont(new Font("SEBANG Gothic", Font.BOLD, 25));

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel.getParent(), "table_manage");
				table_manage.shop = cnt_user.get_Shop();// 현재 로그인 된 사장의 점포를 저장
				table_manage.lblNewLabel_5.setFont(new Font("SEBANG Gothic", Font.BOLD, 20));
				table_manage.lblNewLabel_5.setText(table_manage.shop + " 점포관리");
				table_manage.init();// 현재 로그인된 사장 점포의 테이블 내역 불러옴
			}
		});
		btnNewButton.setBounds(60, 230, 350, 300);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setVisible(false);
		panel_1.setBounds(252, 138, 800, 600);
		add(panel_1, "update");
		panel_1.setBackground(new Color(226, 221, 215));
		panel_1.setLayout(null);
		
		panel_3 = new JPanel();
		panel_3.setBounds(349, 204, 570, 183);
		panel_3.setBackground(new Color(236, 230, 225));
		panel_3.setVisible(false);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uBCC0\uACBD\uC774 \uC644\uB8CC\uB418\uC5C8\uC2B5\uB2C8\uB2E4.");
		lblNewLabel_1.setFont(new Font("세방고딕 굵게", Font.BOLD, 25));
		lblNewLabel_1.setBounds(97, 68, 382, 36);
		panel_3.add(lblNewLabel_1);

		pwf.setBounds(365, 159, 430, 35);
		panel_1.add(pwf);

		pwf.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pwf.setText("Password를 입력해주세요.");
		pwf.setFont(new Font("SEBANG Gothic", Font.PLAIN, 20));
		pwf.setForeground(Color.LIGHT_GRAY);
		pwf.setBackground(Color.WHITE);
		pwf.setEchoChar((char) 0);
		pwf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (pwf.getText().equals("Password를 입력해주세요.")) {
					pwf.setText("");
					pwf.setEchoChar('*');
					pwf.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (pwf.getText().equals("")) {
					pwf.setEchoChar((char) 0);
					pwf.setForeground(Color.LIGHT_GRAY);
					pwf.setText("Password를 입력해주세요.");
				}
			}
		});

		JButton check = new JButton("\uD655\uC778");
		check.setBounds(819, 161, 100, 35);
		check.setFont(new Font("세방고딕 굵게", Font.BOLD, 14));
		check.setBorder(new LineBorder(new Color(200, 184, 164), 2, true));
		check.setBackground(new Color(200, 184, 164));
		panel_1.add(check);

		JLabel lblNewLabel_2 = new JLabel("\uD604\uC7AC \uBE44\uBC00\uBC88\uD638");
		lblNewLabel_2.setFont(new Font("세방고딕 굵게", Font.BOLD, 15));
		lblNewLabel_2.setBounds(370, 134, 121, 15);
		panel_1.add(lblNewLabel_2);

		panel_2 = new JPanel();
		panel_2.setVisible(false);
		panel_2.setBackground(new Color(226, 221, 215));
		panel_2.setBounds(333, 252, 603, 256);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		pwf1.setBounds(36, 83, 430, 35);
		panel_2.add(pwf1);
		pwf1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pwf1.setText("Password를 입력해주세요.");
		pwf1.setFont(new Font("SEBANG Gothic", Font.PLAIN, 20));
		pwf1.setForeground(Color.LIGHT_GRAY);
		pwf1.setBackground(Color.WHITE);
		pwf1.setEchoChar((char) 0);
		pwf1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (pwf1.getText().equals("Password를 입력해주세요.")) {
					pwf1.setText("");
					pwf1.setEchoChar('*');
					pwf1.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (pwf1.getText().equals("")) {
					pwf1.setEchoChar((char) 0);
					pwf1.setForeground(Color.LIGHT_GRAY);
					pwf1.setText("Password를 입력해주세요.");
				}
			}
		});

		JLabel lblNewLabel_3 = new JLabel("\uC0C8\uB85C\uC6B4 \uBE44\uBC00\uBC88\uD638");
		lblNewLabel_3.setFont(new Font("세방고딕 굵게", Font.BOLD, 15));
		lblNewLabel_3.setBounds(36, 52, 131, 21);
		panel_2.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\uC0C8\uB85C\uC6B4 \uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		lblNewLabel_4.setFont(new Font("세방고딕 굵게", Font.BOLD, 15));
		lblNewLabel_4.setBounds(36, 128, 200, 15);
		panel_2.add(lblNewLabel_4);

		pwf2.setBounds(36, 153, 430, 35);
		panel_2.add(pwf2);
		pwf2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pwf2.setText("Password를 입력해주세요.");
		pwf2.setFont(new Font("SEBANG Gothic", Font.PLAIN, 20));
		pwf2.setForeground(Color.LIGHT_GRAY);
		pwf2.setBackground(Color.WHITE);
		pwf2.setEchoChar((char) 0);
		pwf2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (pwf2.getText().equals("Password를 입력해주세요.")) {
					pwf2.setText("");
					pwf2.setEchoChar('*');
					pwf2.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (pwf2.getText().equals("")) {
					pwf2.setEchoChar((char) 0);
					pwf2.setForeground(Color.LIGHT_GRAY);
					pwf2.setText("Password를 입력해주세요.");
				}
			}
		});

		JButton update = new JButton("\uBCC0\uACBD");
		update.setFont(new Font("세방고딕 굵게", Font.BOLD, 14));
		update.setBorder(new LineBorder(new Color(200, 184, 164), 2, true));
		update.setBackground(new Color(200, 184, 164));
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pwf1.getText().toString().equals(pwf2.getText().toString())) {
					DAO.update_pw(cnt_user.get_ID(), pwf1.getText().toString());
					panel_3.setVisible(true);
				}
			}
		});
		update.setBounds(491, 155, 100, 33);
		panel_2.add(update);

		JButton btnNewButton_3_1 = new JButton("");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				init();
			}
		});
		btnNewButton_3_1.setForeground(Color.WHITE);
		btnNewButton_3_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnNewButton_3_1.setBorder(null);
		btnNewButton_3_1.setIcon(new ImageIcon("image/back2.png"));
		btnNewButton_3_1.setBackground(new Color(226, 221, 215));
		btnNewButton_3_1.setBounds(12, 10, 150, 90);
		panel_1.add(btnNewButton_3_1);
		

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("image/manage2.png"));
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel.getParent(), "menu_manage");
				manage_menu.cnt_user = cnt_user.get_Shop();
				manage_menu.init();
			}
		});
		btnNewButton_1.setBounds(465, 230, 350, 300);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		btnNewButton_2.setIcon(new ImageIcon("image/manage3.png"));
		btnNewButton_2.setBounds(870, 230, 350, 300);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel.getParent(), "manage_reservation");
				reservation_list.init(cnt_user.get_Shop());

			}
		});
		panel.add(btnNewButton_2);

		btnNewButton_3 = new JButton("");
		btnNewButton_3.setBorder(new LineBorder(new Color(226, 221, 215), 1, true));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setIcon(new ImageIcon("image/logout.png"));
		btnNewButton_3.setFont(new Font("SEBANG Gothic", Font.PLAIN, 15));
		btnNewButton_3.setBackground(new Color(226, 221, 215));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(60, 61, 150, 90);
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setRequestFocusEnabled(false);
		btnNewButton_4.setIcon(new ImageIcon("image/mymenu.png"));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel.getParent(), "update");
			}
		});
		btnNewButton_4.setBounds(1160, 80, 40, 40);
		panel.add(btnNewButton_4);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image/managebase.png"));
		lblNewLabel.setBounds(0, 0, 1280, 720);
		panel.add(lblNewLabel);

		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pw = cnt_user.get_PW();
				if (pwf.getText().toString().equals(pw)) {
					panel_2.setVisible(true);
				}
			}
		});

		table_manage.btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel.getParent(), "main");
			}
		});
		manage_menu.btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel.getParent(), "main");
			}
		});

	}
}
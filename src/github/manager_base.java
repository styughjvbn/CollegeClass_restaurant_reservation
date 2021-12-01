package github;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class manager_base extends JPanel {
	public manager_shop table_manage;
	public CardLayout card = new CardLayout();
	public DTO_manager cnt_user = null;
	public JButton btnNewButton_3;
	public manage_menu manage_menu;
	public reservation_list reservation_list;
	public String shopname;
	/**
	 * Create the panel.
	 */
	public manager_base() {
		setLayout(card);
		table_manage = new manager_shop();// 점포관리 패널
		JPanel panel = new JPanel();// 점포관리 패널
		add(panel, "main");
		panel.setLayout(null);

		add(table_manage, "table_manage");// 점포관리 패널
		manage_menu = new manage_menu();
		add(manage_menu, "menu_manage");// 점포관리 패널
    reservation_list=new reservation_list();
		add(reservation_list,"manage_reservation");
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
				System.out.println(cnt_user.get_Shop() + "dddfdf");
				reservation_list.init(cnt_user.get_Shop());
				
			}
		});
		panel.add(btnNewButton_2);

		btnNewButton_3 = new JButton("");
		btnNewButton_3.setBorder(new LineBorder(new Color(226, 221, 215), 1, true));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setIcon(new ImageIcon("image/logout.png"));
		btnNewButton_3.setFont(new Font("SEBANG Gothic", Font.PLAIN, 15));
		btnNewButton_3.setBackground(new Color(226,221,215));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(36, 45, 150, 90);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image/managebase.png"));
		lblNewLabel.setBounds(0, 0, 1280, 720);
		panel.add(lblNewLabel);
		
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
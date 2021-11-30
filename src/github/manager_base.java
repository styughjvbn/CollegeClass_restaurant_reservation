package github;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class manager_base extends JPanel {
	public manager_shop table_manage;
	public CardLayout card=new CardLayout();
	public DTO_manager cnt_user=null;
	public JButton btnNewButton_3;
	public manage_menu manage_menu;
	public reservation_list reservation_list;
	public String shopname;
	/**
	 * Create the panel.
	 */
	public manager_base() {
		setLayout(card);
		table_manage=new manager_shop();//점포관리 패널
		JPanel panel = new JPanel();//점포관리 패널
		add(panel, "main");
		panel.setLayout(null);
		
		add(table_manage,"table_manage");//점포관리 패널
		manage_menu=new manage_menu();
		add(manage_menu,"menu_manage");//점포관리 패널
		reservation_list manage_reservation=new reservation_list();
		add(manage_reservation,"manage_reservation");
		
		JButton btnNewButton = new JButton("\uC810\uD3EC\uAD00\uB9AC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel.getParent(), "table_manage");
				table_manage.shop=cnt_user.get_Shop();//현재 로그인 된 사장의 점포를 저장
				table_manage.lblNewLabel_5.setText(table_manage.shop+"점포관리");
				table_manage.init();//현재 로그인된 사장 점포의 테이블 내역 불러옴
			}
		});
		btnNewButton.setBounds(94, 159, 275, 238);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uBA54\uB274 \uAD00\uB9AC");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel.getParent(), "menu_manage");
				manage_menu.cnt_user=cnt_user.get_Shop();
				manage_menu.init();
			}
		});
		btnNewButton_1.setBounds(391, 159, 287, 238);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uC608\uC57D \uAD00\uB9AC");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel.getParent(), "manage_reservation");
				shopname = cnt_user.get_Shop();
				reservation_list.init(shopname);
			}
		});
		btnNewButton_2.setBounds(702, 159, 287, 238);
		panel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("logout");
		btnNewButton_3.setBounds(40, 41, 97, 23);
		panel.add(btnNewButton_3);
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

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

		table_manage = new manager_shop();// �젏�룷愿�由� �뙣�꼸
		JPanel panel = new JPanel();// �젏�룷愿�由� �뙣�꼸
		add(panel, "main");
		panel.setLayout(null);

		add(table_manage, "table_manage");// �젏�룷愿�由� �뙣�꼸
		manage_menu = new manage_menu();
		add(manage_menu, "menu_manage");// �젏�룷愿�由� �뙣�꼸
		reservation_list=new reservation_list();

		add(reservation_list,"manage_reservation");
		
		JButton btnNewButton = new JButton("\uC810\uD3EC\uAD00\uB9AC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel.getParent(), "table_manage");

				table_manage.shop=cnt_user.get_Shop();//���� �α��� �� ������ ������ ����
				table_manage.lblNewLabel_5.setText(table_manage.shop+"��������");
				table_manage.init();//���� �α��ε� ���� ������ ���̺� ���� �ҷ���

				table_manage.shop = cnt_user.get_Shop();// �쁽�옱 濡쒓렇�씤 �맂 �궗�옣�쓽 �젏�룷瑜� ���옣
				table_manage.lblNewLabel_5.setText(table_manage.shop + " �젏�룷愿�由�");
				table_manage.init();// �쁽�옱 濡쒓렇�씤�맂 �궗�옣 �젏�룷�쓽 �뀒�씠釉� �궡�뿭 遺덈윭�샂

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
				System.out.println(cnt_user.get_Shop() + "dddfdf");
				reservation_list.init(cnt_user.get_Shop());
				
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

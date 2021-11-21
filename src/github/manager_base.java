package github;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class manager_base extends JPanel {
	public manager_shop table_manage;
	public CardLayout card=new CardLayout();
	public DTO_manager_login cnt_user=null;
	/**
	 * Create the panel.
	 */
	public manager_base() {
		setLayout(card);
		table_manage=new manager_shop();
		JPanel panel = new JPanel();
		add(panel, "name_607799466526300");
		panel.setLayout(null);
		
		add(table_manage,"table_manage");
		JButton btnNewButton = new JButton("\uC810\uD3EC\uAD00\uB9AC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel.getParent(), "table_manage");
				table_manage.shop=cnt_user.get_Shop();
			}
		});
		btnNewButton.setBounds(94, 159, 275, 238);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uBA54\uB274 \uAD00\uB9AC");
		btnNewButton_1.setBounds(391, 159, 287, 238);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uC608\uC57D \uAD00\uB9AC");
		btnNewButton_2.setBounds(702, 159, 287, 238);
		panel.add(btnNewButton_2);
	}
}

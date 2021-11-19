package github.manager;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class manager_base extends JPanel {
	public manager_shop table_manage=new manager_shop();
	public CardLayout card=new CardLayout();
	/**
	 * Create the panel.
	 */
	public manager_base() {
		setLayout(card);
		
		JPanel panel = new JPanel();
		add(panel, "name_607799466526300");
		panel.setLayout(null);
		
		add(table_manage,"table_manage");
		JButton btnNewButton = new JButton("\uC810\uD3EC\uAD00\uB9AC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel.getParent(), "table_manage");
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

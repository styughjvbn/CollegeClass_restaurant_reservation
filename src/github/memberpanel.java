package github;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class memberpanel extends JPanel {
	Customer customer = new Customer();
	private ButtonGroup group = new ButtonGroup();
	private CardLayout card=new CardLayout();
	/**
	 * Create the panel.
	 */
	public memberpanel() {
		
		setBackground(Color.WHITE);
		setBounds(0, 0, 1280, 720);
		setVisible(true);
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(390, 149, 500, 450);
		add(panel_1);
		panel_1.setLayout(card);
		
		manager_signup_panel panel=new manager_signup_panel();
		panel.setBounds(-10008, -10031, 504, 437);
		panel_1.add(panel,"maneger_signup");
		
		customermember panel2=new customermember();
		panel2.setBounds(-10008, -10031, 504, 437);
		panel_1.add(panel2,"customer_signup");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\uC0AC\uC7A5");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_1, "maneger_signup");
			}
		});
		rdbtnNewRadioButton.setBounds(390, 89, 121, 23);
		add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\uACE0\uAC1D");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_1, "customer_signup");
			}
		});
		rdbtnNewRadioButton_1.setBounds(769, 89, 121, 23);
		add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_1);
		
	}
}

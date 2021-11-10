package github;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class signup_base extends JPanel {
	private ButtonGroup group = new ButtonGroup();
	private CardLayout card=new CardLayout();
	private Image img;
	private Dimension d;
	public JButton btnNewButton;
	/**
	 * Create the panel.
	 */
	public signup_base() {
		
		setBackground(Color.WHITE);
		setBounds(0, 0, 1280, 720);
		setVisible(true);
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(390, 149, 500, 450);
		add(panel_1);
		panel_1.setLayout(card);
		
		signup_manager panel=new signup_manager();
		panel.setBounds(-10008, -10031, 504, 437);
		panel_1.add(panel,"maneger_signup");
		
		signup_customer panel2=new signup_customer();
		panel2.setBounds(-10008, -10031, 504, 437);
		panel_1.add(panel2,"customer_signup");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\uC0AC\uC7A5");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_1, "maneger_signup");
			}
		});
		rdbtnNewRadioButton.setBounds(656, 89, 61, 23);
		add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\uACE0\uAC1D");
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_1, "customer_signup");
			}
		});
		rdbtnNewRadioButton_1.setBounds(568, 89, 61, 23);
		add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_1);
		
		btnNewButton = new JButton("");
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\33387\\Desktop\\2\uD559\uB144 2\uD559\uAE30\\\uC624\uD508\uC18C\uC2A4\uD504\uB85C\uC81D\uD2B8\\restaurant_reservation\\image\\back.png"));
		btnNewButton.setBounds(12, 10, 61, 50);
		add(btnNewButton);
		
		img = new ImageIcon("image/signup.jpg").getImage();

		d = getSize();
		
	}
	public void paintComponent(Graphics g) {
	      g.drawImage(img, 0, 0,d.width,d.height, null);
	  }
}

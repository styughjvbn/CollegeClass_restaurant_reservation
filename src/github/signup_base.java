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
import java.awt.Font;

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
		panel_1.setBounds(395, 204, 500, 450);
		add(panel_1);
		panel_1.setLayout(card);
		
		signup_manager panel=new signup_manager();
		panel.setBounds(-10008, -10031, 504, 437);
		panel_1.add(panel,"maneger_signup");
		
		signup_customer panel2=new signup_customer();
		panel2.setBounds(-10008, -10031, 504, 437);
		panel_1.add(panel2,"customer_signup");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Manager");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		rdbtnNewRadioButton.setBackground(new Color(226,221,215));
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_1, "maneger_signup");
			}
		});
		rdbtnNewRadioButton.setBounds(675, 160, 140, 38);
		add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Customer");
		rdbtnNewRadioButton_1.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		rdbtnNewRadioButton_1.setBackground(new Color(226,221,215));
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_1, "customer_signup");
			}
		});
		rdbtnNewRadioButton_1.setBounds(489, 160, 140, 38);
		add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_1);
		
		btnNewButton = new JButton("");//back¹öÆ°
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(226,221,215));
		btnNewButton.setIcon(new ImageIcon("image/back.png"));
		btnNewButton.setBounds(12, 10, 61, 50);
		add(btnNewButton);
		
		img = new ImageIcon("image/signup.jpg").getImage();

		d = getSize();
	}
	public void paintComponent(Graphics g) {
	      g.drawImage(img, 0, 0,d.width,d.height, null);
	  }
}

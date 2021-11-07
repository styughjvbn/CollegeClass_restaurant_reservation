package github;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Box;

public class welcomePanel extends JPanel {
	public JTextField id;
	public JPasswordField pw;
	private Image img;

	/**
	 * Create the panel.
	 */
	public welcomePanel() {
		setBounds(0, 1, 544, 342);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Log in");
		lblNewLabel.setBounds(270, 121, 121, 46);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.GREEN);
		add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(229, 177, 162, 31);
		id.setToolTipText("ID");
		add(id);
		id.setColumns(10);
		
		pw = new JPasswordField();
		pw.setBounds(229, 219, 162, 31);
		pw.setToolTipText("Enter pass");
		add(pw);
		
		JLabel lblNewLabel_1 = new JLabel("ID :");
		lblNewLabel_1.setBounds(148, 177, 75, 31);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 22));
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PW :");
		lblNewLabel_1_1.setBounds(142, 219, 75, 31);
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 22));
		add(lblNewLabel_1_1);
		img = new ImageIcon("image/restaurantimage.jpg").getImage();
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(img, 0, 0, null);
	}

}


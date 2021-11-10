package github;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;

public class welcomePanel extends JPanel {
	public JTextField textField_1;
	public JPasswordField passwordField;
	private ButtonGroup group = new ButtonGroup();
	JButton btnNewButton;
	String a;
	private Image img;
	private Dimension d;

	/**
	 * Create the panel.
	 */
	public welcomePanel() {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBackground(Color.WHITE);
		setBounds(0, 1, 1280, 720);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(285, 200, 500, 350);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(Color.BLACK, 2, true));
		add(panel);
		panel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setBounds(186, 104, 120, 38);
		panel.add(textField_1);
		textField_1.setAlignmentX(5.0f);
		textField_1.setColumns(10);
		textField_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "ID", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		textField_1.setBackground(Color.WHITE);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(186, 179, 120, 38);
		panel.add(passwordField);
		passwordField.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Password", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		passwordField.setBackground(Color.WHITE);
		
		btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(132, 238, 231, 100);
		panel.add(btnNewButton);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Segoe Print", Font.PLAIN, 26));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.WHITE);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Manager");
		rdbtnNewRadioButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = e.getActionCommand();
				System.out.print(a);
			}
		});
		
		rdbtnNewRadioButton_1_1.setForeground(Color.BLACK);
		rdbtnNewRadioButton_1_1.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		rdbtnNewRadioButton_1_1.setBounds(278, 48, 85, 23);
		panel.add(rdbtnNewRadioButton_1_1);
		rdbtnNewRadioButton_1_1.setBackground(Color.WHITE);
		group.add(rdbtnNewRadioButton_1_1);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Customer");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = e.getActionCommand();
				System.out.print(a);
			}
		});
		rdbtnNewRadioButton_1.setForeground(Color.BLACK);
		rdbtnNewRadioButton_1.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		rdbtnNewRadioButton_1.setBounds(146, 48, 96, 23);
		panel.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		group.add(rdbtnNewRadioButton_1);
		
		img = new ImageIcon("image/image01.jpg").getImage();
		
		d=getSize();
		System.out.println(d.width);
		System.out.println(d.height);
	}
	public void paintComponent(Graphics g) {
	      g.drawImage(img, 0, 0,d.width,d.height, null);
	  }
}


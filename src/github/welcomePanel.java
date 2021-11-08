package github;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class welcomePanel extends JPanel {
	public JTextField textField_1;
	public JPasswordField passwordField;
	private ButtonGroup group = new ButtonGroup();
	JButton btnNewButton;
	String a;

	/**
	 * Create the panel.
	 */
	public welcomePanel() {
		setBackground(Color.WHITE);
		setBounds(0, 1, 1080, 531);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel.setBounds(297, 46, 500, 450);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Resaurant");
		lblNewLabel_2.setForeground(Color.GREEN);
		lblNewLabel_2.setBounds(136, 2, 228, 129);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.PLAIN, 45));
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setBounds(186, 156, 120, 38);
		panel.add(textField_1);
		textField_1.setAlignmentX(5.0f);
		textField_1.setColumns(10);
		textField_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "ID", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GREEN));
		textField_1.setBackground(Color.WHITE);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(186, 224, 120, 38);
		panel.add(passwordField);
		passwordField.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Password", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GREEN));
		passwordField.setBackground(Color.WHITE);
		
		btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(133, 340, 231, 100);
		panel.add(btnNewButton);
		btnNewButton.setForeground(Color.GREEN);
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
		
		rdbtnNewRadioButton_1_1.setForeground(Color.GREEN);
		rdbtnNewRadioButton_1_1.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		rdbtnNewRadioButton_1_1.setBounds(279, 123, 85, 23);
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
		rdbtnNewRadioButton_1.setForeground(Color.GREEN);
		rdbtnNewRadioButton_1.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		rdbtnNewRadioButton_1.setBounds(146, 123, 96, 23);
		panel.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		group.add(rdbtnNewRadioButton_1);
	}
}


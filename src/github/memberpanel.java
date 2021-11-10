package github;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class memberpanel extends JPanel {
	Customer customer = new Customer();
	/**
	 * Create the panel.
	 */
	public memberpanel() {
		
		setBackground(Color.WHITE);
		setBounds(0, 0, 504, 437);
		setVisible(true);
		setLayout(null);
		manager_signup_panel panel=new manager_signup_panel();
		panel.setBounds(0, 0, 504, 437);
		add(panel);
		
		setBackground(Color.WHITE);
		setBounds(0, 0, 504, 437);
		setVisible(true);
		setLayout(null);
		customermember panel2=new customermember();
		panel.setBounds(0, 0, 504, 437);
		add(panel2);
	}

}

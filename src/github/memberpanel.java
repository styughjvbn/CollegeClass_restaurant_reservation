package github;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class memberpanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public memberpanel() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 544, 343);
		setLayout(null);
		setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome this is main panel");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2.setBounds(107, 41, 369, 52);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(58, 103, 98, 15);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Age");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(58, 167, 98, 15);
		add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Gender");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblNewLabel_3_2.setBounds(58, 220, 98, 33);
		add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Phone");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblNewLabel_3_3.setBounds(249, 94, 98, 24);
		add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("BirthDay");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblNewLabel_3_4.setBounds(249, 158, 98, 33);
		add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Job");
		lblNewLabel_3_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_5.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblNewLabel_3_5.setBounds(249, 224, 98, 24);
		add(lblNewLabel_3_5);
	}

}

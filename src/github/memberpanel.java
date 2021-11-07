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

public class memberpanel extends JPanel {
	private JTextField name1;
	private JTextField phone;
	private JTextField age;
	private JTextField birthday;
	Customer customer = new Customer();
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
		
		name1 = new JTextField();
		name1.setBounds(141, 98, 116, 21);
		name1.setColumns(10);
		add(name1);
		
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(339, 94, 116, 21);
		add(phone);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(141, 166, 116, 21);
		add(age);
		
		birthday = new JTextField();
		birthday.setColumns(10);
		birthday.setBounds(339, 166, 116, 21);
		add(birthday);
		
		JComboBox comboBox = new JComboBox(new String[] {"Male","Female"});
		comboBox.setForeground(Color.BLACK);
		comboBox.setBounds(141, 227, 116, 23);
		add(comboBox);
		
		JComboBox Job = new JComboBox();
		Job.setModel(new DefaultComboBoxModel(new String[] {"\uC0AC\uC7A5", "\uACE0\uAC1D"}));
		Job.setBounds(338, 227, 117, 23);
		add(Job);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nameTxt = name1.getText();
				String ageTxt = age.getText();
				String phoneTxt = phone.getText();
				String genderTxt = comboBox.getSelectedItem().toString();
				String JobTxt = Job.getSelectedItem().toString();
				customer.createTable();
				customer.createCustomer(nameTxt,phoneTxt,genderTxt,ageTxt,JobTxt);
				JOptionPane.showMessageDialog(null, "Your data has been saved successfully");
			}
			
		});
		btnNewButton.setBounds(80, 277, 97, 23);
		add(btnNewButton);
	}

}

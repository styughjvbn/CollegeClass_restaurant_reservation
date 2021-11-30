package github;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class reservation extends JPanel {
	private JTable table;
	private JTable table_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Create the panel.
	 */
	public reservation() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 36, 461, 226);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(36, 309, 461, 201);
		add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(665, 53, 316, 21);
		add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(665, 136, 316, 21);
		add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(665, 200, 316, 21);
		add(passwordField_2);
		
		JButton btnNewButton = new JButton("\uBE44\uBC00\uBC88\uD638 \uBCC0\uACBD");
		btnNewButton.setBounds(884, 366, 97, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC608\uC57D\uCDE8\uC18C");
		btnNewButton_1.setBounds(509, 97, 71, 124);
		add(btnNewButton_1);

	}
}

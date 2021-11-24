package github;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class signin_base extends JPanel {
	public JTextField textField_1;
	public JPasswordField PasswordField;
	private ButtonGroup group = new ButtonGroup();
	public JButton btnNewButton;
	String a = "Customer";// 로그인 첫화면 고객로그인으로 설정
	private Image img;
	private Dimension d;
	public JButton btnSignup;
	public JPanel error_panel;
	public JLabel error_label;

	/**
	 * Create the panel.
	 */
	public signin_base() {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBounds(0, 1, 1280, 720);
		setLayout(null);

		error_panel = new JPanel();
		error_panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		error_panel.setBackground(Color.LIGHT_GRAY);
		error_panel.setVisible(false);
		error_panel.setBounds(449, 302, 319, 120);
		add(error_panel);
		error_panel.setLayout(null);

		JButton error_button = new JButton("\uD655\uC778");
		error_button.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		error_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				error_panel.setVisible(false);
			}
		});
		error_button.setBounds(113, 87, 97, 23);
		error_panel.add(error_button);

		error_label = new JLabel("\uB85C\uADF8\uC778 \uC2E4\uD328");
		error_label.setBounds(88, 10, 137, 60);
		error_label.setFont(new Font("SEBANG Gothic", Font.PLAIN, 26));
		error_panel.add(error_label);

		JPanel panel = new JPanel();
		panel.setBounds(574, 0, 706, 758);
		panel.setBackground(new Color(255, 0, 0, 0));
		add(panel);
		panel.setLayout(null);

		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setBounds(126, 191, 458, 54);
		panel.add(textField_1);
		textField_1.setAlignmentX(5.0f);
		textField_1.setColumns(10);
		textField_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		textField_1.setText("ID를 입력해주세요.");
		textField_1.setFont(new Font("SEBANG Gothic", Font.PLAIN, 20));
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.setBackground(Color.WHITE);
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField_1.getText().equals("ID를 입력해주세요.")) {
					textField_1.setText("");
					textField_1.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textField_1.getText().equals("")) {
					textField_1.setForeground(Color.LIGHT_GRAY);
					textField_1.setText("ID를 입력해주세요.");
				}
			}
		});

		PasswordField = new JPasswordField();
		PasswordField.setBounds(126, 302, 458, 54);
		panel.add(PasswordField);
		PasswordField.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		PasswordField.setText("Password를 입력해주세요.");
		PasswordField.setFont(new Font("SEBANG Gothic", Font.PLAIN, 20));
		PasswordField.setForeground(Color.LIGHT_GRAY);
		PasswordField.setBackground(Color.WHITE);
		PasswordField.setEchoChar((char) 0);
		PasswordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (PasswordField.getText().equals("Password를 입력해주세요.")) {
					PasswordField.setText("");
					PasswordField.setEchoChar('*');
					PasswordField.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (PasswordField.getText().equals("")) {
					PasswordField.setEchoChar((char) 0);
					PasswordField.setForeground(Color.LIGHT_GRAY);
					PasswordField.setText("Password를 입력해주세요.");
				}
			}
		});

		btnNewButton = new JButton("SIGNIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(126, 457, 458, 54);
		panel.add(btnNewButton);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("SEBANG Gothic", Font.PLAIN, 26));
		btnNewButton.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(255, 204, 204)));
		btnNewButton.setBackground(new Color(204, 204, 204));

		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Manager");
		rdbtnNewRadioButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = e.getActionCommand();
			}
		});

		rdbtnNewRadioButton_1_1.setForeground(Color.BLACK);
		rdbtnNewRadioButton_1_1.setFont(new Font("SEBANG Gothic", Font.PLAIN, 20));
		rdbtnNewRadioButton_1_1.setBounds(382, 91, 154, 44);
		panel.add(rdbtnNewRadioButton_1_1);
		rdbtnNewRadioButton_1_1.setBackground(new Color(226, 221, 215));
		group.add(rdbtnNewRadioButton_1_1);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Customer");
		rdbtnNewRadioButton_1.setSelected(true);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = e.getActionCommand();
			}
		});
		rdbtnNewRadioButton_1.setForeground(Color.BLACK);
		rdbtnNewRadioButton_1.setFont(new Font("SEBANG Gothic", Font.PLAIN, 20));
		rdbtnNewRadioButton_1.setBounds(184, 91, 154, 44);
		panel.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBackground(new Color(226, 221, 215));
		group.add(rdbtnNewRadioButton_1);

		btnSignup = new JButton("SIGNUP");
		btnSignup.setForeground(Color.BLACK);
		btnSignup.setFont(new Font("SEBANG Gothic", Font.PLAIN, 26));
		btnSignup.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(255, 204, 204)));
		btnSignup.setBackground(new Color(204, 204, 204));
		btnSignup.setBounds(126, 524, 458, 54);
		panel.add(btnSignup);

		JLabel lblNewLabel = new JLabel("I D");
		lblNewLabel.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		lblNewLabel.setBounds(128, 166, 57, 15);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		lblNewLabel_1.setBounds(126, 277, 101, 15);
		panel.add(lblNewLabel_1);

		img = new ImageIcon("image/LoginTitle.jpg").getImage();

		d = getSize();
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, d.width, d.height, null);
	}
}

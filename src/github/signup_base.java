package github;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

public class signup_base extends JPanel {
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
		panel_1.setBounds(35, 140, 1215, 500);
		add(panel_1);
		panel_1.setLayout(card);
		
		//회원 유형 선택 패널
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(226,221,215));
		panel_1.add(panel_2, "member_type");
		panel_2.setLayout(null);
		
		JButton rdbtnNewRadioButton_1 = new JButton("\uAC1C\uC778 \uD68C\uC6D0\uAC00\uC785");  //customer 버튼
		rdbtnNewRadioButton_1.setBounds(313, 231, 203, 77);
		panel_2.add(rdbtnNewRadioButton_1);
		
		JButton rdbtnNewRadioButton = new JButton("\uC810\uD3EC \uD68C\uC6D0\uAC00\uC785");  //manager 버튼
		rdbtnNewRadioButton.setBounds(739, 231, 203, 77);
		panel_2.add(rdbtnNewRadioButton);
		
		//manager/customer 선택 버튼
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\kmj\\Documents\\GitHub\\restaurant_reservation\\image\\signup_step1.png"));
		lblNewLabel_1.setBounds(335, 42, 558, 82);
		panel_2.add(lblNewLabel_1);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_1, "maneger_signup");
			}
		});
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_1, "customer_signup");
			}
		});
		
		signup_manager panel=new signup_manager();
		panel.setBounds(-10008, -10031, 1215,500);
		panel_1.add(panel,"maneger_signup");
		
		signup_customer panel2=new signup_customer();
		panel2.setBounds(-10008, -10031, 504, 437);
		panel_1.add(panel2,"customer_signup");
		
		
		btnNewButton = new JButton("");  //뒤로가기
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("image/back.png"));
		btnNewButton.setBounds(12, 10, 61, 50);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNewLabel.setBounds(356, 52, 575, 84);
		add(lblNewLabel);
		
		img = new ImageIcon("image/signup.jpg").getImage();

		d = getSize();
		
	}
	public void paintComponent(Graphics g) {
	      g.drawImage(img, 0, 0,d.width,d.height, null);
	  }
}

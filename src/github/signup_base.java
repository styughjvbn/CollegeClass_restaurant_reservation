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
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class signup_base extends JPanel {
	private CardLayout card=new CardLayout();
	private Image img;
	private Dimension d;
	public JButton btnNewButton;
	public signup_manager panel;
	public signup_customer panel2;
	private JPanel panel_1;
	/**
	 * Create the panel.
	 */
	public signup_base() {
		
		setBackground(Color.WHITE);
		setBounds(0, 0, 1280, 720);
		setVisible(true);
		setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(35, 140, 1215, 500);
		add(panel_1);
		panel_1.setLayout(card);
		
		//회원 유형 선택 패널
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(226,221,215));
		panel_1.add(panel_2, "member_type");
		panel_2.setLayout(null);
		
		panel=new signup_manager();//사장 회원가입
		panel.setBounds(-10008, -10031, 1215,500);
		panel_1.add(panel,"maneger_signup");
		
		panel2=new signup_customer();//고객 회원가입
		panel2.setBounds(-10008, -10031, 504, 437);
		panel_1.add(panel2,"customer_signup");
		
		JButton rdbtnNewRadioButton_1 = new JButton("");  // customer 버튼
		rdbtnNewRadioButton_1.setBorder(null);
		rdbtnNewRadioButton_1.setIcon(new ImageIcon("image/csignupbutton.png"));
		rdbtnNewRadioButton_1.setBounds(436, 281, 134, 51);
		panel_2.add(rdbtnNewRadioButton_1);
		
		JButton rdbtnNewRadioButton = new JButton("");  //manager 버튼
		rdbtnNewRadioButton.setBorder(null);
		rdbtnNewRadioButton.setIcon(new ImageIcon("image/msignupbutton.png"));
		rdbtnNewRadioButton.setBounds(944, 281, 134, 51);
		panel_2.add(rdbtnNewRadioButton);
		
		//manager/customer 선택 버튼
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("image/signup_step13.PNG"));
		lblNewLabel_1.setBounds(299, 58, 666, 101);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("\uAC1C\uC778\uD68C\uC6D0");
		lblNewLabel_4.setFont(new Font("SEBANG Gothic", Font.BOLD, 25));
		lblNewLabel_4.setBounds(146, 256, 113, 33);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_2 = new JLabel("\uAC1C\uC778 \uD68C\uC6D0\uAC00\uC785\uC744 \uC6D0\uD558\uC2DC\uBA74 \uC120\uD0DD\uD574\uC8FC\uC138\uC694.");
		lblNewLabel_4_2.setFont(new Font("SEBANG Gothic", Font.PLAIN, 14));
		lblNewLabel_4_2.setBounds(146, 299, 289, 33);
		panel_2.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("\uC810\uD3EC \uD68C\uC6D0\uAC00\uC785\uC744 \uC6D0\uD558\uC2DC\uBA74 \uC120\uD0DD\uD574\uC8FC\uC138\uC694.");
		lblNewLabel_4_3.setFont(new Font("SEBANG Gothic", Font.PLAIN, 14));
		lblNewLabel_4_3.setBounds(664, 299, 266, 33);
		panel_2.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("\uC810\uD3EC\uD68C\uC6D0");
		lblNewLabel_4_4.setFont(new Font("SEBANG Gothic", Font.BOLD, 25));
		lblNewLabel_4_4.setBounds(664, 255, 113, 33);
		panel_2.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("SEBANG Gothic", Font.PLAIN, 12));
		lblNewLabel_2.setIcon(new ImageIcon("image/signup_select1.PNG"));
		lblNewLabel_2.setBounds(78, 189, 1057, 194);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("* \uD68C\uC6D0 \uC720\uD615\uC5D0 \uB530\uB77C \uAC00\uC785 \uC808\uCC28\uC5D0 \uCC28\uC774\uAC00 \uC788\uC73C\uB2C8 \uAC1C\uC778\uD68C\uC6D0 \uB610\uB294 \uAE30\uC5C5\uD68C\uC6D0\uC744 \uC120\uD0DD\uD574\uC8FC\uC138\uC694.");
		lblNewLabel_3.setFont(new Font("SEBANG Gothic", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(110, 405, 672, 33);
		panel_2.add(lblNewLabel_3);
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_1, "maneger_signup");
			}
		});
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.init();
				card.show(panel_1, "customer_signup");
			}
		});

		btnNewButton = new JButton("");  //뒤로가기
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(226,221,215));
		btnNewButton.setIcon(new ImageIcon("image/back.png"));
		btnNewButton.setBounds(59, 62, 48, 50);
		add(btnNewButton);
		
		panel.btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				card.show(panel_1, "member_type");
			}
		});
		panel2.btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_1, "member_type");
			}
		});
		img = new ImageIcon("image/signup.jpg").getImage();

		d = getSize();
	}
	void init() {
		card.show(panel_1, "member_type");
	}
	public void paintComponent(Graphics g) {
	      g.drawImage(img, 0, 0,d.width,d.height, null);
	  }
}
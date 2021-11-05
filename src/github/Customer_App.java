package github;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;

public class Customer_App {

	private JFrame frame;
	private JTextField id;
	private JPasswordField pw;
	private JTextField name1;
	private JTextField phone;
	private JTextField age;
	private JTextField birthday;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_App window = new Customer_App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Customer_App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Customer customer = new Customer();
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		ImagePanel1 welcomePanel = new ImagePanel1(new ImageIcon("image/restaurantimage.jpg").getImage());
		welcomePanel.setBounds(0, 1, 544, 342);
		frame.setSize(welcomePanel.getWidth(),welcomePanel.getHeight());
		
		JPanel memberpanel = new JPanel();
		memberpanel.setBackground(Color.WHITE);
		memberpanel.setBounds(0, 0, 544, 343);
		frame.getContentPane().add(memberpanel);
		memberpanel.setLayout(null);
		memberpanel.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome this is main panel");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2.setBounds(107, 41, 369, 52);
		memberpanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(58, 103, 98, 15);
		memberpanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Age");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(58, 167, 98, 15);
		memberpanel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Gender");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_3_2.setBounds(58, 220, 98, 33);
		memberpanel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Phone");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_3_3.setBounds(249, 94, 98, 24);
		memberpanel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("BirthDay");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_3_4.setBounds(249, 158, 98, 33);
		memberpanel.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Job");
		lblNewLabel_3_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_5.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_3_5.setBounds(249, 224, 98, 24);
		memberpanel.add(lblNewLabel_3_5);
		
		name1 = new JTextField();
		name1.setBounds(141, 98, 116, 21);
		memberpanel.add(name1);
		name1.setColumns(10);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(339, 94, 116, 21);
		memberpanel.add(phone);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(141, 166, 116, 21);
		memberpanel.add(age);
		
		birthday = new JTextField();
		birthday.setColumns(10);
		birthday.setBounds(339, 166, 116, 21);
		memberpanel.add(birthday);
		
		JComboBox comboBox = new JComboBox(new String[] {"Male","Female"});
		comboBox.setForeground(Color.BLACK);
		comboBox.setBounds(141, 227, 116, 23);
		memberpanel.add(comboBox);
		
		JComboBox Job = new JComboBox();
		Job.setModel(new DefaultComboBoxModel(new String[] {"\uC0AC\uC7A5", "\uACE0\uAC1D"}));
		Job.setBounds(338, 227, 117, 23);
		memberpanel.add(Job);
		
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
		memberpanel.add(btnNewButton);
		
		JButton BackButton = new JButton("Back");//뒤로가기 버튼 생성
		BackButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				welcomePanel.setVisible(true);
				memberpanel.setVisible(false);
				
			}
			
		});
		BackButton.setBounds(385, 277, 91, 23);
		memberpanel.add(BackButton);
		
		
		frame.getContentPane().add(welcomePanel);
		welcomePanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Log in");
		lblNewLabel.setBounds(270, 121, 121, 46);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.GREEN);
		welcomePanel.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(229, 177, 162, 31);
		id.setToolTipText("ID");
		welcomePanel.add(id);
		id.setColumns(10);
		
		pw = new JPasswordField();
		pw.setBounds(229, 219, 162, 31);
		pw.setToolTipText("Enter pass");
		welcomePanel.add(pw);
		
		JLabel lblNewLabel_1 = new JLabel("ID :");
		lblNewLabel_1.setBounds(148, 177, 75, 31);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 22));
		welcomePanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PW :");
		lblNewLabel_1_1.setBounds(142, 219, 75, 31);
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 22));
		welcomePanel.add(lblNewLabel_1_1);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(152, 260, 239, 31);
		btnLogIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(id.getText().equals("seyeon") && Arrays.equals(pw.getPassword(),"hello".toCharArray())) {
					System.out.println("Hello seyeon");

				}

				else {
					JOptionPane.showMessageDialog(null,"You failed to log in");
				}
		
				
			}
			
		});
		welcomePanel.add(btnLogIn);
		
		JButton membership = new JButton("\uD68C\uC6D0\uAC00\uC785"); //회원가입 버튼
		membership.setBounds(142, 137, 97, 23);
		membership.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				welcomePanel.setVisible(false);
				memberpanel.setVisible(true);
				
			}
			
		});
		welcomePanel.add(membership);
		frame.setJMenuBar(menuBar());
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public JMenuBar menuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu = new JMenu("About");
		
		bar.add(fileMenu);
		bar.add(aboutMenu);
		
		JMenuItem openFile = new JMenuItem("Open");
		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(openFile);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
		});
		return bar;
		
	}
}

class ImagePanel1 extends JPanel{
	private Image img;
	
	public ImagePanel1(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null))); //이미지 크기가 자동으로 조절
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null);
	}
	public int getWidth() {
		return img.getWidth(null);
	}
	public int getHeight() {
		return img.getHeight(null);
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(img, 0, 0, null);
	}
}

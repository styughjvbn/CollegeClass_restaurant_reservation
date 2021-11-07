package github;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
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
		frame.setSize(1080,720);
		welcomePanel Wpanel=new welcomePanel();
		
		frame.getContentPane().add(Wpanel);
		
		//23123
		

		
		memberpanel member = new memberpanel();
		frame.getContentPane().add(member);
		
		JButton membership = new JButton("\uD68C\uC6D0\uAC00\uC785"); //회원가입 버튼
		membership.setBounds(142, 137, 97, 23);
		membership.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Wpanel.setVisible(false);
				member.setVisible(true);
				
			}
			
		});
		Wpanel.add(membership);
		
		
		
		name1 = new JTextField();
		name1.setBounds(141, 98, 116, 21);
		member.add(name1);
		name1.setColumns(10);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(339, 94, 116, 21);
		member.add(phone);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(141, 166, 116, 21);
		member.add(age);
		
		birthday = new JTextField();
		birthday.setColumns(10);
		birthday.setBounds(339, 166, 116, 21);
		member.add(birthday);
		
		JComboBox comboBox = new JComboBox(new String[] {"Male","Female"});
		comboBox.setForeground(Color.BLACK);
		comboBox.setBounds(141, 227, 116, 23);
		member.add(comboBox);
		
		JComboBox Job = new JComboBox();
		Job.setModel(new DefaultComboBoxModel(new String[] {"\uC0AC\uC7A5", "\uACE0\uAC1D"}));
		Job.setBounds(338, 227, 117, 23);
		member.add(Job);
		
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
		member.add(btnNewButton);
		
		JButton BackButton = new JButton("Back");//뒤로가기 버튼 생성
		BackButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Wpanel.setVisible(true);
				member.setVisible(false);
				
				
			}
			
		});
		BackButton.setBounds(385, 277, 91, 23);
		member.add(BackButton);
		
		JPanel restpanel = new JPanel();
		restpanel.setBounds(0, 0, 511, 305);
		frame.getContentPane().add(restpanel);
		
		JButton btnNewButton_2 = new JButton("\uACE0\uAC1D\uC6A9");
		restpanel.add(btnNewButton_2);
		
		JPanel customerpanel = new JPanel();
		customerpanel.setBounds(0, 0, 511, 305);
		frame.getContentPane().add(customerpanel);
		
		JButton btnNewButton_1 = new JButton("\uC0AC\uC7A5\uC6A9");
		customerpanel.add(btnNewButton_1);
		frame.setJMenuBar(menuBar());
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(152, 260, 239, 31);
		btnLogIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String idcode = id.getText();
				String password = pw.getText();
				String job1 = "사장";
				String job2 = "고객";
				int result1 = Customer.login1(idcode, password, job1);
				int result2 = Customer.login2(idcode, password, job2);
				if(result1 == 1) {
					System.out.println("사장");
					Wpanel.setVisible(false);
					member.setVisible(false);
					restpanel.setVisible(false);
					customerpanel.setVisible(true);
				}
				else {
					if(result2 == 1) {
						System.out.println("고객");
						Wpanel.setVisible(false);
						member.setVisible(false);
						restpanel.setVisible(true);
						customerpanel.setVisible(false);
					}
					else
					{
						System.out.println("login failed");
					}
				}
		
				
			}
			
		});
		Wpanel.add(btnLogIn);
		
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

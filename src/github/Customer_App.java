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
	public static void main(String[] args) {//main 함수
		EventQueue.invokeLater(new Runnable() {//스윙이 동작될 수 있도록 하는 교통경찰같은 역할..?
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
		frame = new JFrame();
		frame.setResizable(false);//프로그램 크기 재조정 불가 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x키 누르면 프로그램 완전 종료
		frame.getContentPane().setLayout(null);
		frame.setSize(1080,720);//프로그램 크기 설정
		frame.setJMenuBar(menuBar());//메뉴바 설정
		Customer customer = new Customer();//DB객체 
		
		welcomePanel Wpanel=new welcomePanel();//처음 시작 로그인 패널 생성
		frame.getContentPane().add(Wpanel);//프레임에 로그인 패널 추가
		
		memberpanel member = new memberpanel();//회원가입 패널 생성
		frame.getContentPane().add(member);//프레임에 회원가입 패널 추가
		
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
		
		
		
		JButton btnLogIn = new JButton("Log in");//로그인 버튼
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
				}
				else {
					if(result2 == 1) {
						System.out.println("고객");
						Wpanel.setVisible(false);
						member.setVisible(false);
					}
					else
					{
						System.out.println("login failed");
					}
				}
			}
		});
		Wpanel.add(btnLogIn);
		frame.setLocationRelativeTo(null);//화면 중앙에 프로그램 띄우기
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

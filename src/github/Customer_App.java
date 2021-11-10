package github;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Customer_App {

	private JFrame frame;
	private CardLayout card = new CardLayout();

	/**
	 * 프로그램 실행
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
	 * 프레임 생성
	 */
	public Customer_App() {
		initialize();
	}

	/**
	 * 프레임 초기화
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("\uC2DD\uB2F9\uC608\uC57D \uD504\uB85C\uADF8\uB7A8");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x키 누르면 프로그램 완전 종료
		frame.getContentPane().setLayout(card);
		frame.setSize(1296,759);//프로그램 크기 설정 이거 중요 프레임 내부 패널의 크기가 1280x720 온전하게 표현되게 하기 위함
		Customer customer = new Customer();//DB객체 
		Customer.createTable();
		
		welcomePanel Wpanel=new welcomePanel();//처음 시작 로그인 패널 생성
		frame.getContentPane().add(Wpanel,"login");//프레임에 로그인 패널 추가
		card.show(frame.getContentPane(), "login");
		
		memberpanel member = new memberpanel();//회원가입 패널 생성
		frame.getContentPane().add(member,"signup");//프레임에 회원가입 패널 추가
		
		JButton membership = new JButton("\uD68C\uC6D0\uAC00\uC785"); //회원가입 버튼
		membership.setBounds(142, 137, 97, 23);
		membership.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(frame.getContentPane(), "signup");
			}
		});
		Wpanel.add(membership);
		
		
		JButton BackButton = new JButton("Back");//뒤로가기 버튼
		BackButton.setBounds(542, 219, 61, 23);
		BackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(frame.getContentPane(), "login");
			}
		});
		member.add(BackButton);
		
		
		Wpanel.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Wpanel.a.equals("Manager")){
					if(customer.login_manager(Wpanel.textField_1.getText(),Wpanel.passwordField.getText())) {
						System.out.println("사장 로그인 성공");
					}
					else
						System.out.println("로그인 실패");
				}
				else if(Wpanel.a.equals("Customer")){
					if(customer.login_customer(Wpanel.textField_1.getText(),Wpanel.passwordField.getText())) {
						System.out.println("고객 로그인 성공");
					}
					else
						System.out.println("로그인 실패");
				}
			}
		});
		
		
		frame.setLocationRelativeTo(null);//화면 중앙에 프로그램 띄우기
	}
}

package github;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Customer_App {

	private JFrame frame;
	private CardLayout card = new CardLayout();
	private JOptionPane aa=new JOptionPane();

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
		DAO_signup DAO=new DAO_signup();
		DAO.create_customer_Table();//첫 실행시 고객회원 테이블 생성
		DAO.create_manager_Table();//첫 실행시 사장회원 테이블 생성
		
		signin_base Wpanel=new signin_base();//처음 시작 로그인 패널 생성
		frame.getContentPane().add(Wpanel,"login");//프레임에 로그인 패널 추가
		card.show(frame.getContentPane(), "login");
		
		signup_base member = new signup_base();//회원가입 패널 생성
		frame.getContentPane().add(member,"signup");//프레임에 회원가입 패널 추가
		
		reservation_base reservation = new reservation_base();
		frame.getContentPane().add(reservation,"reservation");//프레임에 회원가입 패널 추가
		
		Wpanel.btnSignup.addActionListener(new ActionListener() {//회원가입 버튼 액션
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(frame.getContentPane(), "signup");
			}
		});
		
		member.btnNewButton.addActionListener(new ActionListener() {//뒤로가기 버튼 액션
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(frame.getContentPane(), "login");
			}
		});
		
		Wpanel.btnNewButton.addActionListener(new ActionListener() {//로그인 버튼 액션
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Wpanel.a.equals("Manager")){//콤보박스가 사장이라면
					if(DAO.login_manager(new DTO_manager_login(Wpanel.textField_1.getText(),Wpanel.PasswordField.getText()))) {
						aa.showMessageDialog(null, "환영합니다"+Wpanel.textField_1.getText()+"님");	
					}
					else
						aa.showMessageDialog(null, "로그인에 실패하였습니다");	
				}
				else if(Wpanel.a.equals("Customer")){//콤보박스가 고객이라면
					if(DAO.login_customer(new DTO_customer_login(Wpanel.textField_1.getText(),Wpanel.PasswordField.getText()))) {
						card.show(frame.getContentPane(), "reservation");
					}
					else
						aa.showMessageDialog(null, "로그인에 실패하였습니다");	
				}
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(450, 346, 319, 120);
		Wpanel.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(113, 87, 97, 23);
		panel.add(btnNewButton);
		
		
		frame.setLocationRelativeTo(null);//화면 중앙에 프로그램 띄우기
	}
}

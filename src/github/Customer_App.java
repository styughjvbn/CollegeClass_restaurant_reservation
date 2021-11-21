package github;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class Customer_App {

	private JFrame frame;
	private CardLayout card = new CardLayout();

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

	public Customer_App() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("\uC2DD\uB2F9\uC608\uC57D \uD504\uB85C\uADF8\uB7A8");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(card);
		frame.setSize(1296,759);
		DAO_signup DAO=new DAO_signup();
		DAO.create_customer_Table();
		DAO.create_manager_Table();
		
		signin_base Wpanel=new signin_base();//로그인 패널
		frame.getContentPane().add(Wpanel,"login");
		card.show(frame.getContentPane(), "login");
		
		signup_base member = new signup_base();//회원가입 패널
		frame.getContentPane().add(member,"signup");
		
		reservation_base reservation = new reservation_base();//예약 패널
		frame.getContentPane().add(reservation,"reservation");
		
		manager_base manage=new manager_base();
		frame.getContentPane().add(manage,"manage");
		
		reservation.back.addActionListener(new ActionListener() {//예약 패널의 back버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(frame.getContentPane(), "login");
			}
		});
		Wpanel.btnSignup.addActionListener(new ActionListener() {//회원가입 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(frame.getContentPane(), "signup");
			}
		});
		
		member.btnNewButton.addActionListener(new ActionListener() {//회원가입 패널의 back버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(frame.getContentPane(), "login");
			}
		});
		
		
		
		Wpanel.btnNewButton.addActionListener(new ActionListener() {//로그인 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Wpanel.a.equals("Manager")){
					DTO_manager_login temp=DAO.login_manager(new DTO_manager_login(Wpanel.textField_1.getText(),Wpanel.PasswordField.getText()));
					if(temp==null) {
						Wpanel.error_panel.setVisible(true);
					}
					else{
						card.show(frame.getContentPane(), "manage");
						manage.cnt_user=temp;
					}
				}
				else if(Wpanel.a.equals("Customer")){
					if(DAO.login_customer(new DTO_customer_login(Wpanel.textField_1.getText(),Wpanel.PasswordField.getText()))) {
						card.show(frame.getContentPane(), "reservation");
					}
					else
						Wpanel.error_panel.setVisible(true);
				}
			}
		});
		
		
		frame.setLocationRelativeTo(null);//포로그램 실행시 화면 가운데 띄우기
	}
}

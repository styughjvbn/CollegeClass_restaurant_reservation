package github;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Color;

public class Customer_App {

	private JFrame frame;
	private CardLayout card = new CardLayout();
	private JOptionPane aa=new JOptionPane();

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
					if(DAO.login_manager(new DTO_manager_login(Wpanel.textField_1.getText(),Wpanel.PasswordField.getText()))) {
					}
					else
						Wpanel.error_panel.setVisible(true);
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

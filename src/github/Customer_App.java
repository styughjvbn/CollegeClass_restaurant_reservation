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
		
		signin_base Wpanel=new signin_base();
		frame.getContentPane().add(Wpanel,"login");
		card.show(frame.getContentPane(), "login");
		
		signup_base member = new signup_base();
		frame.getContentPane().add(member,"signup");
		
		reservation_base reservation = new reservation_base();
		frame.getContentPane().add(reservation,"reservation");
		
		Wpanel.btnSignup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(frame.getContentPane(), "signup");
			}
		});
		
		member.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(frame.getContentPane(), "login");
			}
		});
		
		Wpanel.btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Wpanel.a.equals("Manager")){
					if(DAO.login_manager(new DTO_manager_login(Wpanel.textField_1.getText(),Wpanel.PasswordField.getText()))) {
						aa.showMessageDialog(null, "환영합니다"+Wpanel.textField_1.getText()+"님");	
					}
					else
						aa.showMessageDialog(null, "로그인 실패");	
				}
				else if(Wpanel.a.equals("Customer")){
					if(DAO.login_customer(new DTO_customer_login(Wpanel.textField_1.getText(),Wpanel.PasswordField.getText()))) {
						card.show(frame.getContentPane(), "reservation");
					}
					else
						aa.showMessageDialog(null, "로그인 실패");	
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
		
		
		frame.setLocationRelativeTo(null);
	}
}

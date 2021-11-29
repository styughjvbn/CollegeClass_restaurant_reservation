package github;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
		DAO.init();
		File imgFile = new File("image/shop_image");//폴더 생성
		if (!imgFile.exists()) {// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
			try{
				imgFile.mkdir(); //폴더 생성합니다.
			    System.out.println("폴더가 생성되었습니다.");
		        } 
		        catch(Exception e){
			    e.getStackTrace();
			}        
	    }
		signin_base Wpanel=new signin_base();//로그인 패널
		frame.getContentPane().add(Wpanel,"login");
		card.show(frame.getContentPane(), "login");
		
		signup_base member = new signup_base();//회원가입 패널
		frame.getContentPane().add(member,"signup");
		
		reservation_base reservation = new reservation_base();//예약 패널
		frame.getContentPane().add(reservation,"reservation");
		
		manager_base manage=new manager_base();//사장 패널
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
				member.init();
			}
		});
		member.btnNewButton.addActionListener(new ActionListener() {//회원가입 패널의 back버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(frame.getContentPane(), "login");
			}
		});
		member.panel2.StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(frame.getContentPane(), "login");
			}
		});
		
		manage.btnNewButton_3.addActionListener(new ActionListener() {//사장 패널 back버튼
			public void actionPerformed(ActionEvent e) {
				card.show(frame.getContentPane(), "login");
			}
		});
		
		Wpanel.btnNewButton.addActionListener(new ActionListener() {//로그인 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Wpanel.a.equals("Manager")){
					DTO_manager temp=DAO.login_manager(new DTO_manager(Wpanel.textField_1.getText(),Wpanel.PasswordField.getText()));
					if(temp==null) {
						Wpanel.error_panel.setVisible(true);
					}
					else{
						card.show(frame.getContentPane(), "manage");
						manage.cnt_user=temp;
					}
				}
				else if(Wpanel.a.equals("Customer")){
					DTO_customer temp=DAO.login_customer(new DTO_customer(Wpanel.textField_1.getText(),Wpanel.PasswordField.getText()));
					if(temp!=null) {
						card.show(frame.getContentPane(), "reservation");
						reservation.cnt_user=temp;
					}
					else
						Wpanel.error_panel.setVisible(true);
				}
			}
		});
			
		frame.setLocationRelativeTo(null);//포로그램 실행시 화면 가운데 띄우기
	}
}

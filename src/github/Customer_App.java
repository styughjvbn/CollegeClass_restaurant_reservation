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
		File imgFile = new File("image/shop_image");//���� ����
		if (!imgFile.exists()) {// �ش� ���丮�� ������� ���丮�� �����մϴ�.
			try{
				imgFile.mkdir(); //���� �����մϴ�.
			    System.out.println("������ �����Ǿ����ϴ�.");
		        } 
		        catch(Exception e){
			    e.getStackTrace();
			}        
	    }
		signin_base Wpanel=new signin_base();//�α��� �г�
		frame.getContentPane().add(Wpanel,"login");
		card.show(frame.getContentPane(), "login");
		
		signup_base member = new signup_base();//ȸ������ �г�
		frame.getContentPane().add(member,"signup");
		
		reservation_base reservation = new reservation_base();//���� �г�
		frame.getContentPane().add(reservation,"reservation");
		
		manager_base manage=new manager_base();//���� �г�
		frame.getContentPane().add(manage,"manage");
		
		reservation.back.addActionListener(new ActionListener() {//���� �г��� back��ư
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(frame.getContentPane(), "login");
			}
		});
		Wpanel.btnSignup.addActionListener(new ActionListener() {//ȸ������ ��ư
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(frame.getContentPane(), "signup");
				member.init();
			}
		});
		member.btnNewButton.addActionListener(new ActionListener() {//ȸ������ �г��� back��ư
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
		
		manage.btnNewButton_3.addActionListener(new ActionListener() {//���� �г� back��ư
			public void actionPerformed(ActionEvent e) {
				card.show(frame.getContentPane(), "login");
			}
		});
		
		Wpanel.btnNewButton.addActionListener(new ActionListener() {//�α��� ��ư
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
			
		frame.setLocationRelativeTo(null);//���α׷� ����� ȭ�� ��� ����
	}
}

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
	 * ���α׷� ����
	 */
	public static void main(String[] args) {//main �Լ�
		EventQueue.invokeLater(new Runnable() {//������ ���۵� �� �ֵ��� �ϴ� ����������� ����..?
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
	 * ������ ����
	 */
	public Customer_App() {
		initialize();
	}

	/**
	 * ������ �ʱ�ȭ
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("\uC2DD\uB2F9\uC608\uC57D \uD504\uB85C\uADF8\uB7A8");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//xŰ ������ ���α׷� ���� ����
		frame.getContentPane().setLayout(card);
		frame.setSize(1296,759);//���α׷� ũ�� ���� �̰� �߿� ������ ���� �г��� ũ�Ⱑ 1280x720 �����ϰ� ǥ���ǰ� �ϱ� ����
		Customer customer = new Customer();//DB��ü 
		Customer.createTable();
		
		welcomePanel Wpanel=new welcomePanel();//ó�� ���� �α��� �г� ����
		frame.getContentPane().add(Wpanel,"login");//�����ӿ� �α��� �г� �߰�
		card.show(frame.getContentPane(), "login");
		
		memberpanel member = new memberpanel();//ȸ������ �г� ����
		frame.getContentPane().add(member,"signup");//�����ӿ� ȸ������ �г� �߰�
		
		JButton membership = new JButton("\uD68C\uC6D0\uAC00\uC785"); //ȸ������ ��ư
		membership.setBounds(142, 137, 97, 23);
		membership.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(frame.getContentPane(), "signup");
			}
		});
		Wpanel.add(membership);
		
		
		JButton BackButton = new JButton("Back");//�ڷΰ��� ��ư
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
						System.out.println("���� �α��� ����");
					}
					else
						System.out.println("�α��� ����");
				}
				else if(Wpanel.a.equals("Customer")){
					if(customer.login_customer(Wpanel.textField_1.getText(),Wpanel.passwordField.getText())) {
						System.out.println("�� �α��� ����");
					}
					else
						System.out.println("�α��� ����");
				}
			}
		});
		
		
		frame.setLocationRelativeTo(null);//ȭ�� �߾ӿ� ���α׷� ����
	}
}

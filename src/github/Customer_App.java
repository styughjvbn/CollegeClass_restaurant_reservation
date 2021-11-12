package github;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Customer_App {

	private JFrame frame;
	private CardLayout card = new CardLayout();
	private JOptionPane aa=new JOptionPane();

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
		DAO_signup DAO=new DAO_signup();
		DAO.create_customer_Table();//ù ����� ��ȸ�� ���̺� ����
		DAO.create_manager_Table();//ù ����� ����ȸ�� ���̺� ����
		
		signin_base Wpanel=new signin_base();//ó�� ���� �α��� �г� ����
		frame.getContentPane().add(Wpanel,"login");//�����ӿ� �α��� �г� �߰�
		card.show(frame.getContentPane(), "login");
		
		signup_base member = new signup_base();//ȸ������ �г� ����
		frame.getContentPane().add(member,"signup");//�����ӿ� ȸ������ �г� �߰�
		
		Wpanel.btnSignup.addActionListener(new ActionListener() {//ȸ������ ��ư �׼�
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(frame.getContentPane(), "signup");
			}
		});
		
		member.btnNewButton.addActionListener(new ActionListener() {//�ڷΰ��� ��ư �׼�
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(frame.getContentPane(), "login");
			}
		});
		
		Wpanel.btnNewButton.addActionListener(new ActionListener() {//�α��� ��ư �׼�
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Wpanel.a.equals("Manager")){//�޺��ڽ��� �����̶��
					if(DAO.login_manager(new DTO_manager_login(Wpanel.textField_1.getText(),Wpanel.passwordField.getText()))) {
						aa.showMessageDialog(null, "ȯ���մϴ�"+Wpanel.textField_1.getText()+"��");	
					}
					else
						aa.showMessageDialog(null, "�α��ο� �����Ͽ����ϴ�");	
				}
				else if(Wpanel.a.equals("Customer")){//�޺��ڽ��� ���̶��
					if(DAO.login_customer(new DTO_customer_login(Wpanel.textField_1.getText(),Wpanel.passwordField.getText()))) {
						aa.showMessageDialog(null, "ȯ���մϴ�"+Wpanel.textField_1.getText()+"��");	
					}
					else
						aa.showMessageDialog(null, "�α��ο� �����Ͽ����ϴ�");	
				}
			}
		});
		
		
		frame.setLocationRelativeTo(null);//ȭ�� �߾ӿ� ���α׷� ����
	}
}

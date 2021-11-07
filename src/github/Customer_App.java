package github;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
		frame.setResizable(false);//���α׷� ũ�� ������ �Ұ� 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//xŰ ������ ���α׷� ���� ����
		frame.getContentPane().setLayout(null);
		frame.setSize(1080,720);//���α׷� ũ�� ����
		frame.setJMenuBar(menuBar());//�޴��� ����
		Customer customer = new Customer();//DB��ü 
		
		welcomePanel Wpanel=new welcomePanel();//ó�� ���� �α��� �г� ����
		frame.getContentPane().add(Wpanel);//�����ӿ� �α��� �г� �߰�
		
		memberpanel member = new memberpanel();//ȸ������ �г� ����
		frame.getContentPane().add(member);//�����ӿ� ȸ������ �г� �߰�
		
		JButton membership = new JButton("\uD68C\uC6D0\uAC00\uC785"); //ȸ������ ��ư
		membership.setBounds(142, 137, 97, 23);
		membership.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Wpanel.setVisible(false);
				member.setVisible(true);
			}
		});
		Wpanel.add(membership);
		
		
		JButton BackButton = new JButton("Back");//�ڷΰ��� ��ư ����
		BackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Wpanel.setVisible(true);
				member.setVisible(false);
			}
		});
		BackButton.setBounds(385, 277, 91, 23);
		member.add(BackButton);
		
		
		
		JButton btnLogIn = new JButton("Log in");//�α��� ��ư
		btnLogIn.setBounds(152, 260, 239, 31);
		btnLogIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String idcode = id.getText();
				String password = pw.getText();
				String job1 = "����";
				String job2 = "��";
				int result1 = Customer.login1(idcode, password, job1);
				int result2 = Customer.login2(idcode, password, job2);
				if(result1 == 1) {
					System.out.println("����");
					Wpanel.setVisible(false);
					member.setVisible(false);
				}
				else {
					if(result2 == 1) {
						System.out.println("��");
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
		frame.setLocationRelativeTo(null);//ȭ�� �߾ӿ� ���α׷� ����
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

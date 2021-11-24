package menu_practice;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class h extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					h frame = new h();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public h() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1115, 661);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 10, 800, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel menu_info = new JPanel();
		menu_info.setBounds(609, 277, 162, 166);
		panel.add(menu_info);
		menu_info.setLayout(null);
		
		JLabel menu_lab = new JLabel("\uBA54\uB274\uC815\uBCF4");
		menu_lab.setBounds(12, 10, 118, 15);
		menu_info.add(menu_lab);
		
		JTextField menu_name = new JTextField();
		menu_name.setBounds(22, 35, 116, 21);
		menu_info.add(menu_name);
		menu_name.setColumns(10);
		
		JTextField menu_cost = new JTextField();
		menu_cost.setBounds(22, 91, 116, 21);
		menu_info.add(menu_cost);
		menu_cost.setColumns(10);
		
		JButton modify = new JButton("\uC218\uC815");
		modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		modify.setBounds(12, 133, 56, 23);
		menu_info.add(modify);
		
		JButton del = new JButton("\uC0AD\uC81C");
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		del.setBounds(91, 133, 64, 23);
		menu_info.add(del);
	}
}

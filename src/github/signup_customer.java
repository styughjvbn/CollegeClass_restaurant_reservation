package github;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class signup_customer extends JPanel {
	private JPasswordField pwtxt;
	private JTextField idtxt;
	private JPasswordField pwtxtc;
	private JTextField nametxt;
	private JTextField agetxt;
	private JButton btnNewButton_2;
	private JOptionPane aa = new JOptionPane();
	private search machine = new search();
	private boolean isoverlap;
	private JComboBox comboBox;
	private DAO_signup DAO = new DAO_signup();
	private JTextField txtHp;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel HPLabel;
	private JLabel AGELabel;
	private JLabel idLabel;
	private JLabel pwLabel;
	private JLabel pwLabel_2;
	private JLabel WelcomeLabel;

	/**
	 * Create the panel.
	 */
	public signup_customer() {
		setBackground(new Color(226, 221, 215));
		setLayout(null);
		
		// 4��°
		JPanel Panel_4 = new JPanel();
		Panel_4.setBounds(12, 0, 1203, 507);
		add(Panel_4);
		Panel_4.setBackground(new Color(226, 221, 215));
		Panel_4.setLayout(null);
		Panel_4.setVisible(false);
		
		// 3��°
		JPanel Panel_3 = new JPanel();
		Panel_3.setBounds(58, 0, 1203, 507);
		add(Panel_3);
		Panel_3.setBackground(new Color(226, 221, 215));
		Panel_3.setLayout(null);
		Panel_3.setVisible(false);
		
		// 2��°
		JPanel Panel_2 = new JPanel();
		Panel_2.setBounds(52, 0, 1203, 507);
		add(Panel_2);
		Panel_2.setBackground(new Color(226, 221, 215));
		Panel_2.setLayout(null);
		Panel_2.setVisible(true);
		
		// 2�ܰ� �̹���
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(283, 0, 574, 83);
		Panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("image/signup_step21.PNG"));
		
		// 3�ܰ� �̹���
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(283, 0, 574, 83);
		Panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("image/signup_step31.PNG"));
		
		// 4�ܰ� �̹���
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(283, 0, 574, 83);
		Panel_4.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("image/signup_step41.PNG"));
		
		// 4��° �г�(ȯ�� �޼���)
		WelcomeLabel = new JLabel("");
		WelcomeLabel.setFont(new Font("SEBANG Gothic", Font.PLAIN, 30));
		WelcomeLabel.setBackground(new Color(226, 221, 215));
		WelcomeLabel.setBounds(283, 193, 57, 15);
		Panel_4.add(WelcomeLabel);
		
		// 3��° �г�, �ߺ��˻� ��ư
		JButton btnNewButton = new JButton("\uC911\uBCF5\uD655\uC778");
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon("image/check.png"));
		btnNewButton.setBounds(760, 147, 97, 53);
		Panel_3.add(btnNewButton);

		// 3��° �г�(pw)
		pwtxt = new JPasswordField();
		pwtxt.setText("Password�� �Է����ּ���.");
		pwtxt.setFont(new Font("SEBANG Gothic", Font.PLAIN, 20));
		pwtxt.setForeground(Color.LIGHT_GRAY);
		pwtxt.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pwtxt.setBackground(new Color(226, 221, 215));
		pwtxt.setBounds(283, 231, 465, 57);
		Panel_3.add(pwtxt);
		pwtxt.setEchoChar((char) 0);
		pwtxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (pwtxt.getText().equals("Password�� �Է����ּ���.")) {
					pwtxt.setText("");
					pwtxt.setEchoChar('*');
					pwtxt.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (pwtxt.getText().equals("")) {
					pwtxt.setEchoChar((char) 0);
					pwtxt.setForeground(Color.LIGHT_GRAY);
					pwtxt.setText("Password�� �Է����ּ���.");
				}
			}
		});

		// 3��° �г�(id)
		idtxt = new JTextField();
		idtxt.setText("ID�� �Է����ּ���.");
		idtxt.setFont(new Font("SEBANG Gothic", Font.PLAIN, 20));
		idtxt.setForeground(Color.LIGHT_GRAY);
		idtxt.setBackground(new Color(226, 221, 215));
		idtxt.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		idtxt.setBounds(283, 142, 465, 58);
		Panel_3.add(idtxt);
		idtxt.setColumns(10);
		idtxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (idtxt.getText().equals("ID�� �Է����ּ���.")) {
					idtxt.setText("");
					idtxt.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (idtxt.getText().equals("")) {
					idtxt.setForeground(Color.LIGHT_GRAY);
					idtxt.setText("ID�� �Է����ּ���.");
				}
			}
		});

		// 3��° �г�(pwcheck)
		pwtxtc = new JPasswordField();
		pwtxtc.setText("Password�� �������� �ѹ� �� �Է����ּ���.");
		pwtxtc.setFont(new Font("SEBANG Gothic", Font.PLAIN, 20));
		pwtxtc.setForeground(Color.LIGHT_GRAY);
		pwtxtc.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pwtxtc.setBackground(new Color(226, 221, 215));
		pwtxtc.setBounds(283, 323, 465, 57);
		Panel_3.add(pwtxtc);
		pwtxtc.setEchoChar((char) 0);
		pwtxtc.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (pwtxtc.getText().equals("Password�� �������� �ѹ� �� �Է����ּ���.")) {
					pwtxtc.setText("");
					pwtxtc.setEchoChar('*');
					pwtxtc.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (pwtxtc.getText().equals("")) {
					pwtxtc.setEchoChar((char) 0);
					pwtxtc.setForeground(Color.LIGHT_GRAY);
					pwtxtc.setText("Password�� �������� �ѹ� �� �Է����ּ���.");
				}
			}
		});
		

		// 2��° �г� (�̸�)
		nametxt = new JTextField();
		nametxt.setText("�̸��� �Է����ּ���.");
		nametxt.setFont(new Font("SEBANG Gothic", Font.PLAIN, 20));
		nametxt.setForeground(Color.LIGHT_GRAY);
		nametxt.setColumns(10);
		nametxt.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		nametxt.setBackground(new Color(226, 221, 215));
		nametxt.setBounds(273, 169, 500, 54);
		Panel_2.add(nametxt);
		nametxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (nametxt.getText().equals("�̸��� �Է����ּ���.")) {
					nametxt.setText("");
					nametxt.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (nametxt.getText().equals("")) {
					nametxt.setForeground(Color.LIGHT_GRAY);
					nametxt.setText("�̸��� �Է����ּ���.");
				}
			}
		});

		// 2��° �г� (����)
		agetxt = new JTextField();
		agetxt.setText("AGE");
		agetxt.setFont(new Font("SEBANG Gothic", Font.PLAIN, 20));
		agetxt.setForeground(Color.LIGHT_GRAY);
		agetxt.setColumns(10);
		agetxt.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		agetxt.setBackground(new Color(226, 221, 215));
		agetxt.setBounds(678, 349, 95, 45);
		Panel_2.add(agetxt);
		agetxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (agetxt.getText().equals("AGE")) {
					agetxt.setText("");
					agetxt.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (agetxt.getText().equals("")) {
					agetxt.setForeground(Color.LIGHT_GRAY);
					agetxt.setText("AGE");
				}
			}
		});

		// 3��° �г� (����)
		btnNewButton_2 = new JButton("\uAC00\uC785");
		btnNewButton_2.setIcon(new ImageIcon("image/signup.png"));
		btnNewButton_2.setBounds(283, 390, 465, 58);
		Panel_3.add(btnNewButton_2);
		
		idLabel = new JLabel("I D");
		idLabel.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		idLabel.setBounds(283, 117, 57, 15);
		Panel_3.add(idLabel);
		
		pwLabel = new JLabel("PASSWORD");
		pwLabel.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		pwLabel.setBounds(283, 206, 104, 15);
		Panel_3.add(pwLabel);
		
		pwLabel_2 = new JLabel("PASSWORD Check");
		pwLabel_2.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		pwLabel_2.setBounds(283, 298, 167, 15);
		Panel_3.add(pwLabel_2);

		// 2��° �г� (���� ����)
		comboBox = new JComboBox(new Object[] {});
		comboBox.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		comboBox.setBackground(new Color(226, 221, 215));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "���� ", "Male", "Female" }));
		comboBox.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		comboBox.setForeground(Color.BLACK);
		comboBox.setBounds(326, 351, 236, 40);
		Panel_2.add(comboBox);

		// 2��° �г� (�ڵ���)
		txtHp = new JTextField();
		txtHp.setText("HP�� �Է����ּ���.");
		txtHp.setFont(new Font("SEBANG Gothic", Font.PLAIN, 20));
		txtHp.setForeground(Color.LIGHT_GRAY);
		txtHp.setColumns(10);
		txtHp.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtHp.setBackground(new Color(226, 221, 215));
		txtHp.setBounds(273, 258, 499, 54);
		Panel_2.add(txtHp);
		txtHp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtHp.getText().equals("HP�� �Է����ּ���.")) {
					txtHp.setText("");
					txtHp.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtHp.getText().equals("")) {
					txtHp.setForeground(Color.LIGHT_GRAY);
					txtHp.setText("HP�� �Է����ּ���.");
				}
			}
		});

		// 2��° �г�(����)
		JLabel SEXLabel = new JLabel("S E X");
		SEXLabel.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		SEXLabel.setBounds(273, 351, 50, 40);
		Panel_2.add(SEXLabel);

		// �����ܰ�
		JButton NextButton = new JButton("\uB2E4\uC74C \uB2E8\uACC4");
		NextButton.setIcon(new ImageIcon("image/next.png"));
		NextButton.setBounds(994, 445, 127, 40);
		Panel_2.add(NextButton);
		
		// 2��° �г�(�̸�)
		JLabel NameLabel = new JLabel("Name");
		NameLabel.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		NameLabel.setBounds(273, 144, 57, 15);
		Panel_2.add(NameLabel);
		
		// 2��° �г�(��ȭ��ȣ)
		HPLabel = new JLabel("H.P");
		HPLabel.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		HPLabel.setBounds(273, 233, 57, 15);
		Panel_2.add(HPLabel);
		
		// 2��° �г�(����)
		AGELabel = new JLabel("AGE");
		AGELabel.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		AGELabel.setBounds(676, 324, 57, 15);
		Panel_2.add(AGELabel);
		NextButton.addActionListener(new ActionListener() {// step3���� ���� �����ܰ�
			public void actionPerformed(ActionEvent e) {
				Panel_3.setVisible(true);
				Panel_2.setVisible(false);
			}
		});
		// �ߺ�Ȯ�� ��ư ���ǹ�
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (DAO.overlap_id_customer(idtxt.getText()) == 0) {
					aa.showMessageDialog(null, "����� �� �ִ� ���̵��Դϴ�.");
					isoverlap = false;
				} else {
					aa.showMessageDialog(null, "���̵� �ߺ��˴ϴ�.");
					isoverlap = true;
				}
			}
		});
		// �����ϱ� ��ư ���ǹ�
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isoverlap) {
					if (!pwtxt.getText().equals(pwtxtc.getText())) {
						aa.showMessageDialog(null, "��й�ȣ�� �������� �ʽ��ϴ�.");
					} else {
						String id=idtxt.getText();
						String pw= pwtxt.getText();
						int age=Integer.parseInt(agetxt.getText().toString());
						String name=nametxt.getText();
						byte Gender=(byte)Integer.parseInt(comboBox.getSelectedItem().toString());
						String HP=txtHp.getText();
						
						if(agetxt.getText().toString().equals("")||name.equals("")||HP.equals("")||pw.equals("")||id.equals("")) {
							aa.showMessageDialog(null, "��� �Է����ּ���");	
						}else {
							Panel_4.setVisible(true);
							Panel_3.setVisible(false);
							DAO.customer_signup(new DTO_customer(id,pw,HP,Gender,name,age));
							WelcomeLabel.setText("ȯ���մϴ�" +id+ "��");	
						}
					}
				} else
					aa.showMessageDialog(null, "���̵� �ߺ��˴ϴ�.");

			}
		});
	}
}
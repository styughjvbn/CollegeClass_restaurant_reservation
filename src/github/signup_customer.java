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
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;

	/**
	 * Create the panel.
	 */
	public signup_customer() {
		setBackground(new Color(226, 221, 215));
		setLayout(null);
		
		// 2번째
		JPanel Panel_2 = new JPanel();
		Panel_2.setBounds(52, 0, 1203, 507);
		add(Panel_2);
		Panel_2.setBackground(new Color(226, 221, 215));
		Panel_2.setLayout(null);
		Panel_2.setVisible(true);

		// 4번째
		JPanel Panel_4 = new JPanel();
		Panel_4.setBounds(12, 0, 1203, 507);
		add(Panel_4);
		Panel_4.setBackground(new Color(226, 221, 215));
		Panel_4.setLayout(null);
		Panel_4.setVisible(false);

		// 3번째
		JPanel Panel_3 = new JPanel();
		Panel_3.setBounds(58, 0, 1203, 507);
		add(Panel_3);
		Panel_3.setBackground(new Color(226, 221, 215));
		Panel_3.setLayout(null);
		Panel_3.setVisible(false);
		
		// 2단계 이미지
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(283, 0, 574, 83);
		Panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("image/signup_step21.PNG"));
		
		// 3단계 이미지
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(283, 0, 574, 83);
		Panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("image/signup_step31.PNG"));
		
		// 4단계 이미지
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(283, 0, 574, 83);
		Panel_4.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("image/signup_step41.PNG"));
		
		// 3번째 패널, 중복검사 버튼
		JButton btnNewButton = new JButton("\uC911\uBCF5\uD655\uC778");
		btnNewButton.setIcon(new ImageIcon("image/check.png"));
		btnNewButton.setBounds(225, 75, 97, 30);
		Panel_3.add(btnNewButton);

		// 3번째 패널
		pwtxt = new JPasswordField();
		pwtxt.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Password", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pwtxt.setBackground(Color.WHITE);
		pwtxt.setBounds(13, 115, 201, 40);
		Panel_3.add(pwtxt);

		// 3번째 패널
		idtxt = new JTextField();
		idtxt.setBackground(Color.WHITE);
		idtxt.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "ID", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		idtxt.setBounds(13, 65, 200, 40);
		Panel_3.add(idtxt);
		idtxt.setColumns(10);

		// 3번째 패널
		pwtxtc = new JPasswordField();
		pwtxtc.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Password check",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pwtxtc.setBackground(Color.WHITE);
		pwtxtc.setBounds(13, 165, 201, 40);
		Panel_3.add(pwtxtc);

		// 2번째 패널 (이름)
		nametxt = new JTextField();
		nametxt.setText("이름을 입력해주세요.");
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
				if (nametxt.getText().equals("이름을 입력해주세요.")) {
					nametxt.setText("");
					nametxt.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (nametxt.getText().equals("")) {
					nametxt.setForeground(Color.LIGHT_GRAY);
					nametxt.setText("이름을 입력해주세요.");
				}
			}
		});

		// 2번째 패널 (나이)
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

		// 3번째 패널 (가입)
		btnNewButton_2 = new JButton("\uAC00\uC785");
		btnNewButton_2.setIcon(new ImageIcon("image/signup.png"));
		btnNewButton_2.setBounds(185, 377, 97, 30);
		Panel_3.add(btnNewButton_2);

		// 2번째 패널 (성별 선택)
		comboBox = new JComboBox(new Object[] {});
		comboBox.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		comboBox.setBackground(new Color(226, 221, 215));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "성별 ", "Male", "Female" }));
		comboBox.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		comboBox.setForeground(Color.BLACK);
		comboBox.setBounds(326, 351, 236, 40);
		Panel_2.add(comboBox);

		// 2번째 패널 (핸드폰)
		txtHp = new JTextField();
		txtHp.setText("HP를 입력해주세요.");
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
				if (txtHp.getText().equals("HP를 입력해주세요.")) {
					txtHp.setText("");
					txtHp.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtHp.getText().equals("")) {
					txtHp.setForeground(Color.LIGHT_GRAY);
					txtHp.setText("HP를 입력해주세요.");
				}
			}
		});

		// 2번째 패널
		JLabel lblNewLabel = new JLabel("S E X");
		lblNewLabel.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		lblNewLabel.setBounds(273, 351, 50, 40);
		Panel_2.add(lblNewLabel);

		// 다음단계
		JButton btnNewButton_1 = new JButton("\uB2E4\uC74C \uB2E8\uACC4");
		btnNewButton_1.setIcon(new ImageIcon("image/next.png"));
		btnNewButton_1.setBounds(994, 445, 127, 40);
		Panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel_10 = new JLabel("Name");
		lblNewLabel_10.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		lblNewLabel_10.setBounds(273, 144, 57, 15);
		Panel_2.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("H.P");
		lblNewLabel_11.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		lblNewLabel_11.setBounds(273, 233, 57, 15);
		Panel_2.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("AGE");
		lblNewLabel_12.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		lblNewLabel_12.setBounds(676, 324, 57, 15);
		Panel_2.add(lblNewLabel_12);
		btnNewButton_1.addActionListener(new ActionListener() {// step3으로 가는 다음단계
			public void actionPerformed(ActionEvent e) {
				Panel_3.setVisible(true);
				Panel_2.setVisible(false);
			}
		});
		

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (DAO.overlap_id_customer(idtxt.getText()) == 0) {
					aa.showMessageDialog(null, "사용할 수 있는 아이디입니다.");
					isoverlap = false;
				} else {
					aa.showMessageDialog(null, "아이디가 중복됩니다.");
					isoverlap = true;
				}
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isoverlap) {
					if (!pwtxt.getText().equals(pwtxtc.getText())) {
						aa.showMessageDialog(null, "비밀번호가 동일하지 않습니다.");
					} else {
						String id=idtxt.getText();
						String pw= pwtxt.getText();
						int age=Integer.parseInt(agetxt.getText().toString());
						String name=nametxt.getText();
						byte Gender=(byte)Integer.parseInt(comboBox.getSelectedItem().toString());
						String HP=txtHp.getText();
						
						if(agetxt.getText().toString().equals("")||name.equals("")||HP.equals("")||pw.equals("")||id.equals("")) {
							aa.showMessageDialog(null, "모두 입력해주세요");	
						}else {
							DAO.customer_signup(new DTO_customer(id,pw,HP,Gender,name,age));
							aa.showMessageDialog(null, "환영합니다"+id+"님");	
						}
					}
				} else
					aa.showMessageDialog(null, "아이디가 중복됩니다.");

			}
		});
	}
}
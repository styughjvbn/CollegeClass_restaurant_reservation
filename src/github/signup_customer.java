package github;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

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
	private JLabel WelcomeLabel_2;
	private CardLayout card=new CardLayout(0, 0);
	public JButton btnBack_1;
	private JLabel WelcomeLabel_3;
	public JButton StartButton;
	private JPanel Panel_2;

	/**
	 * Create the panel.
	 */
	public signup_customer() {
		setBackground(new Color(226, 221, 215));
		setLayout(card);
		
		// 4번째
		JPanel Panel_4 = new JPanel();
		Panel_4.setBounds(12, 0, 1203, 507);
		add(Panel_4, "4번째");
		Panel_4.setBackground(new Color(226, 221, 215));
		Panel_4.setVisible(false);
		
		// 3번째
		JPanel Panel_3 = new JPanel();
		Panel_3.setBounds(58, 0, 1203, 507);
		add(Panel_3, "3번");
		Panel_3.setBackground(new Color(226, 221, 215));
		Panel_3.setLayout(null);
		Panel_3.setVisible(false);
		
		// 2번째
		Panel_2 = new JPanel();
		Panel_2.setBounds(52, 0, 1203, 507);
		add(Panel_2, "2번째");
		Panel_2.setBackground(new Color(226, 221, 215));
		Panel_2.setLayout(null);
		Panel_2.setVisible(true);
		
		// 2단계 이미지
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(337, 0, 574, 83);
		Panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("image/signup_step21.PNG"));
		
		// 3단계 이미지
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(337, 0, 574, 83);
		Panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("image/signup_step31.PNG"));
		Panel_4.setLayout(null);
		
		// 4단계 이미지
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(337, 0, 574, 83);
		Panel_4.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("image/signup_step41.PNG"));
		
		// 4번째 패널(환영 메세지)
		WelcomeLabel_2 = new JLabel("");
		WelcomeLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		WelcomeLabel_2.setDisplayedMnemonic(KeyEvent.VK_ENTER);
		WelcomeLabel_2.setFont(new Font("SEBANG Gothic", Font.PLAIN, 30));
		WelcomeLabel_2.setBounds(412, 170, 425, 66);
		Panel_4.add(WelcomeLabel_2);
		
		JLabel WelcomeLabel_1 = new JLabel("");
		WelcomeLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		WelcomeLabel_1.setFont(new Font("SEBANG Gothic", Font.PLAIN, 30));
		WelcomeLabel_1.setBounds(412, 116, 425, 66);
		WelcomeLabel_1.setText("환영합니다!");	
		Panel_4.add(WelcomeLabel_1);
		
		StartButton = new JButton("");
		StartButton.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		StartButton.setBounds(359, 369, 504, 45);
		Panel_4.add(StartButton);
		StartButton.setIcon(new ImageIcon("image/cstartbtn.png"));
		
		WelcomeLabel_3 = new JLabel("\uC544\uB798 \uBC84\uD2BC\uC744 \uD074\uB9AD\uD558\uC5EC \uC2DC\uC791\uD574\uC8FC\uC2DC\uAE38 \uBC14\uB78D\uB2C8\uB2E4^^");
		WelcomeLabel_3.setFont(new Font("SEBANG Gothic", Font.PLAIN, 30));
		WelcomeLabel_3.setBounds(303, 232, 660, 65);
		Panel_4.add(WelcomeLabel_3);
		
		// 3번째 패널, 중복검사 버튼
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon("image/check.png"));
		btnNewButton.setBounds(711, 162, 140, 43);
		Panel_3.add(btnNewButton);

		// 3번째 패널(pw)
		pwtxt = new JPasswordField();
		pwtxt.setText("Password를 입력해주세요.");
		pwtxt.setFont(new Font("Dialog", Font.PLAIN, 15));
		pwtxt.setForeground(Color.LIGHT_GRAY);
		pwtxt.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pwtxt.setBackground(new Color(226, 221, 215));
		pwtxt.setBounds(356, 250, 495, 43);
		Panel_3.add(pwtxt);
		pwtxt.setEchoChar((char) 0);
		pwtxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (pwtxt.getText().equals("Password를 입력해주세요.")) {
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
					pwtxt.setText("Password를 입력해주세요.");
				}
			}
		});

		// 3번째 패널(id)
		idtxt = new JTextField();
		idtxt.setText("ID를 입력해주세요.");
		idtxt.setFont(new Font("Dialog", Font.PLAIN, 15));
		idtxt.setForeground(Color.LIGHT_GRAY);
		idtxt.setBackground(new Color(226, 221, 215));
		idtxt.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		idtxt.setBounds(356, 162, 355, 43);
		Panel_3.add(idtxt);
		idtxt.setColumns(10);
		idtxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (idtxt.getText().equals("ID를 입력해주세요.")) {
					idtxt.setText("");
					idtxt.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (idtxt.getText().equals("")) {
					idtxt.setForeground(Color.LIGHT_GRAY);
					idtxt.setText("ID를 입력해주세요.");
				}
			}
		});

		// 3번째 패널(pwcheck)
		pwtxtc = new JPasswordField();
		pwtxtc.setText("Password가 동일한지 한번 더 입력해주세요.");
		pwtxtc.setFont(new Font("Dialog", Font.PLAIN, 15));
		pwtxtc.setForeground(Color.LIGHT_GRAY);
		pwtxtc.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pwtxtc.setBackground(new Color(226, 221, 215));
		pwtxtc.setBounds(356, 307, 496, 43);
		Panel_3.add(pwtxtc);
		pwtxtc.setEchoChar((char) 0);
		pwtxtc.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (pwtxtc.getText().equals("Password가 동일한지 한번 더 입력해주세요.")) {
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
					pwtxtc.setText("Password가 동일한지 한번 더 입력해주세요.");
				}
			}
		});
		

		// 2번째 패널 (이름)
		nametxt = new JTextField();
		nametxt.setText("이름을 입력해주세요.");
		nametxt.setFont(new Font("Dialog", Font.PLAIN, 15));
		nametxt.setForeground(Color.LIGHT_GRAY);
		nametxt.setColumns(10);
		nametxt.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		nametxt.setBackground(new Color(226, 221, 215));
		nametxt.setBounds(356, 155, 500, 40);
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
		agetxt.setText("\uB098\uC774");
		agetxt.setFont(new Font("Dialog", Font.PLAIN, 15));
		agetxt.setForeground(Color.LIGHT_GRAY);
		agetxt.setColumns(10);
		agetxt.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		agetxt.setBackground(new Color(226, 221, 215));
		agetxt.setBounds(654, 321, 202, 40);
		Panel_2.add(agetxt);
		agetxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (agetxt.getText().equals("나이")) {
					agetxt.setText("");
					agetxt.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (agetxt.getText().equals("")) {
					agetxt.setForeground(Color.LIGHT_GRAY);
					agetxt.setText("나이");
				}
			}
		});

		// 3번째 패널 (가입)
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("image/cjoinbtn.png"));
		btnNewButton_2.setBounds(661, 406, 190, 43);
		Panel_3.add(btnNewButton_2);
		
		idLabel = new JLabel("I D");
		idLabel.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		idLabel.setBounds(356, 137, 57, 15);
		Panel_3.add(idLabel);
		
		pwLabel = new JLabel("PASSWORD");
		pwLabel.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		pwLabel.setBounds(356, 225, 104, 15);
		Panel_3.add(pwLabel);
		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon("image/cprebtn.png"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(Panel_2.getParent(), "2번째");
			}
		});
		btnBack.setBounds(356, 406, 189, 43);
		Panel_3.add(btnBack);

		// 2번째 패널 (성별 선택)
		comboBox = new JComboBox(new Object[] {});
		comboBox.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		comboBox.setBackground(new Color(226, 221, 215));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "성별 ", "남자", "여자" }));
		comboBox.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		comboBox.setForeground(Color.BLACK);
		comboBox.setBounds(356, 321, 202, 40);
		Panel_2.add(comboBox);

		// 2번째 패널 (핸드폰)
		txtHp = new JTextField();
		txtHp.setText("\uC804\uD654\uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		txtHp.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtHp.setForeground(Color.LIGHT_GRAY);
		txtHp.setColumns(10);
		txtHp.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtHp.setBackground(new Color(226, 221, 215));
		txtHp.setBounds(356, 240, 499, 40);
		Panel_2.add(txtHp);
		txtHp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtHp.getText().equals("전화번호를 입력해주세요.")) {
					txtHp.setText("");
					txtHp.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtHp.getText().equals("")) {
					txtHp.setForeground(Color.LIGHT_GRAY);
					txtHp.setText("전화번호를 입력해주세요.");
				}
			}
		});

		// 2번째 패널(성별)
		JLabel SEXLabel = new JLabel("\uC131\uBCC4");
		SEXLabel.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		SEXLabel.setBounds(356, 290, 50, 40);
		Panel_2.add(SEXLabel);

		// 다음단계
		JButton NextButton = new JButton("");
		NextButton.setIcon(new ImageIcon("image/cnextbtn.png"));
		NextButton.setBounds(654, 405, 202, 40);
		Panel_2.add(NextButton);
		
		// 2번째 패널(이름)
		JLabel NameLabel = new JLabel("\uC774\uB984");
		NameLabel.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		NameLabel.setBounds(356, 132, 57, 15);
		Panel_2.add(NameLabel);
		
		// 2번째 패널(전화번호)
		HPLabel = new JLabel("\uC804\uD654\uBC88\uD638");
		HPLabel.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		HPLabel.setBounds(357, 218, 67, 15);
		Panel_2.add(HPLabel);
		
		// 2번째 패널(나이)
		AGELabel = new JLabel("\uB098\uC774");
		AGELabel.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		AGELabel.setBounds(654, 303, 57, 15);
		Panel_2.add(AGELabel);
		
		btnBack_1 = new JButton("");
		btnBack_1.setIcon(new ImageIcon("image/cprebtn.png"));
		btnBack_1.setBounds(356, 405, 202, 40);
		Panel_2.add(btnBack_1);
		NextButton.addActionListener(new ActionListener() {// step3으로 가는 다음단계
			public void actionPerformed(ActionEvent e) {
				card.show(Panel_2.getParent(), "3번");
				
			}
		});
		// 중복확인 버튼 조건문
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
		// 가입하기 버튼 조건문
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
						byte Gender=(byte)(comboBox.getSelectedIndex());//남자는 1 여자는 2
						String HP=txtHp.getText();
						HP=HP.replace("-","");
						
						if(agetxt.getText().toString().equals("")||name.equals("")||HP.equals("")||pw.equals("")||id.equals("")) {
							aa.showMessageDialog(null, "모두 입력해주세요");	
						}else if(Gender==0)	{
							aa.showMessageDialog(null, "성별을 올바르게 선택해주세요");	
						}
						else {
							card.show(Panel_2.getParent(), "4번째");
							DAO.customer_signup(new DTO_customer(id,pw,HP,Gender,name,age));
							WelcomeLabel_2.setText(id + "  님!");	
						}
					}
				} else
					aa.showMessageDialog(null, "아이디가 중복됩니다.");

			}
		});
		
	}
	void init(){
		card.show(Panel_2.getParent(), "2번째");
	}
}
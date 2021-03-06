package github;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class signup_manager extends JPanel {
	private JPasswordField pwdPassword;
	private JTextField txtId;
	private JTextField textField_1;
	private JPasswordField pwdPassword_1;
	private JLabel lblNewLabel;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox comboBox;
	private JButton signup_bt;
	private DAO_signup DAO = new DAO_signup();

	private JOptionPane aa = new JOptionPane();
	private search machine = new search();
	private boolean isoverlap = false;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private ArrayList<String[]> list1;
	private CardLayout card=new CardLayout();
	public JButton btnNewButton_1_1;
	/**
	 * Create the panel.
	 */
	public signup_manager() {
		setBackground(new Color(226, 221, 215));
		setLayout(card);

		// 4단계 패널
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 0, 1203, 507);
		add(panel_1,"4단계");
		panel_1.setBackground(new Color(226, 221, 215));
		panel_1.setLayout(null);
		panel_1.setVisible(false);

		// 3단계 패널
		JPanel panel = new JPanel();
		panel.setBounds(58, 0, 1203, 507);
		add(panel,"3단계");
		panel.setBackground(new Color(226, 221, 215));
		panel.setLayout(null);
		panel.setVisible(false);

		// 2단계 패널
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(52, 0, 1203, 507);
		add(panel_2,"2단계");
		panel_2.setBackground(new Color(226, 221, 215));
		panel_2.setLayout(null);
		panel_2.setVisible(true);

		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(
				new ImageIcon("image/signup_step41.PNG"));
		lblNewLabel_10.setBounds(337, 20, 543, 69);
		panel_1.add(lblNewLabel_10);

		JButton btnNewButton_2 = new JButton(""); // 시작하기
		btnNewButton_2.setIcon(
				new ImageIcon("image/mstartbtn.png"));
		btnNewButton_2.setBounds(369, 301, 492, 46);
		panel_1.add(btnNewButton_2);

		// 환영합니다
		JLabel lblNewLabel_11 = new JLabel("\uD658\uC601\uD569\uB2C8\uB2E4 !");
		lblNewLabel_11.setFont(new Font("SEBANG Gothic", Font.BOLD, 25));
		lblNewLabel_11.setBounds(465, 147, 356, 52);
		panel_1.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel(
				"\uACC4\uC815 \uAC00\uC785\uC774 \uC644\uB8CC\uB418\uC5C8\uC2B5\uB2C8\uB2E4.");
		lblNewLabel_12.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		lblNewLabel_12.setBounds(515, 209, 217, 22);
		panel_1.add(lblNewLabel_12);

		// 점포 입력
		lblNewLabel = new JLabel("\uC810\uD3EC \uC815\uBCF4\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		lblNewLabel.setBounds(356, 109, 231, 27);
		panel_2.add(lblNewLabel);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("SEBANG Gothic", Font.BOLD, 18));

		lblNewLabel_4 = new JLabel("\uC9C0\uC5ED");
		lblNewLabel_4.setBounds(356, 151, 134, 27);
		panel_2.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));

		// 지역 입력
		textField_2 = new JTextField();
		textField_2.setBounds(356, 174, 500, 40);
		panel_2.add(textField_2);
		textField_2.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		textField_2.setForeground(new Color(200, 184, 164));
		textField_2.setText("\uC9C0\uC5ED\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(new Color(200, 184, 164), 2, true));
		textField_2.setBackground(new Color(226, 221, 215));

		lblNewLabel_5 = new JLabel("\uC0C1\uD638\uBA85");
		lblNewLabel_5.setBounds(356, 230, 134, 27);
		panel_2.add(lblNewLabel_5);
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));

		// 상호명 입력
		textField_3 = new JTextField();
		textField_3.setBounds(356, 255, 371, 40);
		panel_2.add(textField_3);
		textField_3.setSelectionColor(Color.BLACK);
		textField_3.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		textField_3.setForeground(new Color(200, 184, 164));
		textField_3.setText("\uC0C1\uD638\uBA85\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		textField_3.setColumns(10);
		textField_3.setBorder(new LineBorder(new Color(200, 184, 164), 2, true));
		textField_3.setBackground(new Color(226, 221, 215));

		comboBox = new JComboBox();
		comboBox.setBounds(356, 307, 500, 40);
		panel_2.add(comboBox);
		comboBox.setFont(new Font("SEBANG Gothic", Font.PLAIN, 15));
		comboBox.setBackground(new Color(226, 221, 215));
		comboBox.setBorder(new LineBorder(new Color(200, 184, 164), 2, true));

		// 검색버튼
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.setBounds(727, 255, 129, 40);
		panel_2.add(btnNewButton_2_1);
		btnNewButton_2_1.setBorder(null);
		btnNewButton_2_1.setIcon(
				new ImageIcon("image/msearchbtn.png"));

		// 다음단계
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("image/mnextbtn.png"));
		btnNewButton_1.setBounds(688, 434, 168, 40);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {// step3으로 가는 다음단계
			public void actionPerformed(ActionEvent e) {
				card.show(panel_2.getParent(), "3단계");
			}
		});

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(334, 10, 574, 83);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(
				new ImageIcon("image/signup_step21.PNG"));
		
		btnNewButton_1_1 = new JButton("");//1단계로 가는 이전버튼
		btnNewButton_1_1.setIcon(new ImageIcon("image/mprebtn.png"));
		btnNewButton_1_1.setBounds(356, 434, 168, 40);
		panel_2.add(btnNewButton_1_1);

		// 3단계 패널
		// 아이디
		txtId = new JTextField();
		txtId.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		txtId.setText("ID\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		txtId.setForeground(new Color(200, 184, 164));
		txtId.setBounds(356, 160, 365, 40);
		txtId.setBorder(new LineBorder(new Color(200, 184, 164), 2, true));
		txtId.setBackground(new Color(226, 221, 215));
		txtId.setColumns(10);
		txtId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtId.getText().equals("ID를 입력해주세요.")) {
					txtId.setText("");
					txtId.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtId.getText().equals("")) {
					txtId.setText("ID를 입력해주세요.");
					txtId.setForeground(new Color(200, 184, 164));
				}
			}
		});
		panel.add(txtId);

		pwdPassword = new JPasswordField();
		pwdPassword.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		pwdPassword.setText("PASSWORD\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		pwdPassword.setEchoChar((char) 0);
		pwdPassword.setForeground(new Color(200, 184, 164));
		pwdPassword.setBounds(356, 236, 494, 40);
		panel.add(pwdPassword);
		pwdPassword.setBorder(new LineBorder(new Color(200, 184, 164), 2, true));
		pwdPassword.setBackground(new Color(226, 221, 215));
		pwdPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (pwdPassword.getText().equals("PASSWORD를 입력해주세요.")) {
					pwdPassword.setText("");
					pwdPassword.setEchoChar('*');
					pwdPassword.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (pwdPassword.getText().equals("")) {
					pwdPassword.setEchoChar((char) 0);
					pwdPassword.setForeground(new Color(200, 184, 164));
					pwdPassword.setText("PASSWORD를 입력해주세요.");
				}
			}
		});

		pwdPassword_1 = new JPasswordField();
		pwdPassword_1.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		pwdPassword_1.setText("PASSWORD \uC7AC\uC785\uB825");
		pwdPassword_1.setEchoChar((char) 0);
		pwdPassword_1.setForeground(new Color(200, 184, 164));
		pwdPassword_1.setBounds(356, 286, 494, 40);
		panel.add(pwdPassword_1);
		pwdPassword_1.setBorder(new LineBorder(new Color(200, 184, 164), 2, true));
		pwdPassword_1.setBackground(new Color(226, 221, 215));
		pwdPassword_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (pwdPassword_1.getText().equals("PASSWORD 재입력")) {
					pwdPassword_1.setText("");
					pwdPassword_1.setEchoChar('*');
					pwdPassword_1.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (pwdPassword_1.getText().equals("")) {
					pwdPassword_1.setEchoChar((char) 0);
					pwdPassword_1.setForeground(new Color(200, 184, 164));
					pwdPassword_1.setText("PASSWORD 재입력");
				}
			}
		});

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(
				new ImageIcon("image/mducheck.png"));
		btnNewButton.setFont(new Font("SEBANG Gothic", Font.PLAIN, 15));
		btnNewButton.setBounds(721, 160, 129, 40);
		panel.add(btnNewButton);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		textField_1.setForeground(new Color(200, 184, 164));
		textField_1.setText("\uC804\uD654\uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		textField_1.setBounds(356, 363, 494, 40);
		panel.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(200, 184, 164), 2, true));
		textField_1.setBackground(new Color(226, 221, 215));
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField_1.getText().equals("전화번호를 입력해주세요.")) {
					textField_1.setText("");
					textField_1.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textField_1.getText().equals("")) {
					textField_1.setForeground(new Color(200, 184, 164));
					textField_1.setText("전화번호를 입력해주세요.");
				}
			}
		});

		// 가입하기
		signup_bt = new JButton("");
		signup_bt.setIcon(
				new ImageIcon("image/mjoinbtn.png"));
		signup_bt.setBounds(685, 436, 165, 40);
		panel.add(signup_bt);

		lblNewLabel_3 = new JLabel("\uACC4\uC815 \uC815\uBCF4\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("SEBANG Gothic", Font.BOLD, 18));
		lblNewLabel_3.setBounds(356, 91, 223, 30);
		panel.add(lblNewLabel_3);

		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(
				new ImageIcon("image/signup_step31.PNG"));
		lblNewLabel_6.setBounds(334, 10, 574, 71);
		panel.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("ID");
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		lblNewLabel_7.setBounds(356, 131, 134, 27);
		panel.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("PASSWORD");
		lblNewLabel_8.setForeground(Color.BLACK);
		lblNewLabel_8.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		lblNewLabel_8.setBounds(356, 210, 134, 27);
		panel.add(lblNewLabel_8);

		lblNewLabel_9 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_9.setForeground(Color.BLACK);
		lblNewLabel_9.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		lblNewLabel_9.setBounds(356, 336, 134, 27);
		panel.add(lblNewLabel_9);
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.setIcon(new ImageIcon("image/mprebtn.png"));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_2.getParent(), "2단계");
			}
		});
		btnNewButton_1_1_1.setBounds(356, 436, 165, 40);
		panel.add(btnNewButton_1_1_1);
		signup_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isoverlap) {
					if (!pwdPassword.getText().equals(pwdPassword_1.getText())) {
						aa.showMessageDialog(null, "비밀번호가 동일하지 않습니다.");
					} else {
						String shop = "";
						String id = txtId.getText();
						String pw = pwdPassword.getText();
						String HP = textField_1.getText();
						HP=HP.replace("-","");
						if (comboBox.getSelectedItem() == null || HP.equals("") || pw.equals("") || id.equals("")) {
							aa.showMessageDialog(null, "모두 입력해주세요");
						} else {
							panel_1.setVisible(true); // step4
							panel.setVisible(false);
							shop = comboBox.getSelectedItem().toString();
							DAO.new_shop(new DTO_shop(shop,list1.get(comboBox.getSelectedIndex())[4]));
							DAO.manager_signup(new DTO_manager(id, pw, HP, shop));
							lblNewLabel_11.setText("환영합니다!  " + id + "님");
						}
					}
				} else
					aa.showMessageDialog(null, "아이디가 중복됩니다.");

			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (DAO.overlap_id_manager(txtId.getText()) == 0) {
					aa.showMessageDialog(null, "사용할 수 있는 아이디입니다.");
					isoverlap = false;
				} else {
					aa.showMessageDialog(null, "아이디가 중복됩니다.");
					isoverlap = true;
				}
			}
		});


		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				machine = new search();
				machine.update_XY(textField_2.getText());
				machine.search_result(textField_3.getText());
				list1 = machine.get_result();
				for(int i=0;i<(int)list1.size();i++) {
					comboBox.addItem(list1.get(i)[0]);
				}
			}
		});
		textField_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField_3.getText().equals("상호명을 입력해주세요.")) {
					textField_3.setText("");
					textField_3.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textField_3.getText().equals("")) {
					textField_3.setText("상호명을 입력해주세요.");
					textField_3.setForeground(new Color(200, 184, 164));
				}
			}
		});
		textField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField_2.getText().equals("지역을 입력해주세요.")) {
					textField_2.setForeground(Color.BLACK);
					textField_2.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textField_2.getText().equals("")) {
					textField_2.setForeground(new Color(200, 184, 164));
					textField_2.setText("지역을 입력해주세요.");
          }
			}
		});
	}
}
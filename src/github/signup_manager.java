package github;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;

public class signup_manager extends JPanel {
	private JPasswordField passwordField_1;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox comboBox;
	private JButton signup_bt;
	private DAO_signup DAO = new DAO_signup();
	private JOptionPane aa=new JOptionPane();
	private search machine= new search();
	private boolean  isoverlap=false;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Create the panel.
	 */
	public signup_manager() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JButton btnNewButton = new JButton("\uC911\uBCF5\uD655\uC778");
		btnNewButton.setBounds(1097, 141, 97, 30);
		add(btnNewButton);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(928, 181, 160, 40);
		passwordField_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		passwordField_1.setBackground(Color.WHITE);
		add(passwordField_1);
		
		textField = new JTextField();
		textField.setBounds(928, 131, 160, 40);
		textField.setBackground(Color.WHITE);
		textField.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "ID", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(928, 292, 160, 40);
		textField_1.setColumns(10);
		textField_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "H.P", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textField_1.setBackground(Color.WHITE);
		add(textField_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(928, 242, 160, 40);
		passwordField.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Password check", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		passwordField.setBackground(Color.WHITE);
		add(passwordField);
		
		//점포 입력
		lblNewLabel = new JLabel("\uC810\uD3EC \uC785\uB825");  
		lblNewLabel.setForeground(new Color(90, 81, 75));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(84, 131, 102, 15);
		add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.BOLD, 20));
		textField_2.setForeground(Color.GRAY);
		textField_2.setText("\uC9C0\uC5ED\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		textField_2.setBounds(84, 168, 423, 40);
		textField_2.setColumns(10);
		textField_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_2.setBackground(new Color(226,221,215));
		textField_2.addFocusListener(new FocusAdapter() {
	         @Override
	         public void focusGained(FocusEvent e) {
	            if(textField_2.getText().equals("지역을 입력해주세요.")) {
	            	textField_2.setText("");
	            }
	            
	         }
	         @Override
	         public void focusLost(FocusEvent e) {
	            if(textField_2.getText().equals("")) {
	            	textField_2.setText("지역을 입력해주세요.");
	            }
	         }
	      });
		add(textField_2);
		
		//상호명 입력
		textField_3 = new JTextField();
		textField_3.setText("\uC0C1\uD638\uBA85\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		textField_3.setBounds(84, 218, 309, 40);
		textField_3.setColumns(10);
		textField_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_3.setBackground(new Color(226,221,215));
		textField_3.addFocusListener(new FocusAdapter() {
	         @Override
	         public void focusGained(FocusEvent e) {
	            if(textField_3.getText().equals("상호명을 입력해주세요.")) {
	            	textField_3.setText("");
	            }
	            
	         }
	         @Override
	         public void focusLost(FocusEvent e) {
	            if(textField_3.getText().equals("")) {
	            	textField_3.setText("상호명을 입력해주세요.");
	            }
	         }
	      });
		add(textField_3);
		
		comboBox = new JComboBox();
		comboBox.setBounds(84, 278, 423, 40);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		add(comboBox);
		
		signup_bt = new JButton("\uAC00\uC785");
		signup_bt.setBounds(1062, 376, 97, 30);
		add(signup_bt);
		
		//검색버튼
		JButton btnNewButton_2_1 = new JButton("\uAC80\uC0C9");
		btnNewButton_2_1.setBounds(392, 216, 115, 42);
		add(btnNewButton_2_1);
		
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\kmj\\Documents\\GitHub\\restaurant_reservation\\image\\signup_step1.png"));
		lblNewLabel_1.setBounds(340, 27, 535, 82);
		add(lblNewLabel_1);
		
		
		//상세정보
		lblNewLabel_2 = new JLabel("\uC0C1\uC138\uC815\uBCF4");
		lblNewLabel_2.setForeground(new Color(90, 81, 75));
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_2.setBounds(688, 131, 102, 15);
		add(lblNewLabel_2);
		
		JPanel panel = new JPanel();  //3단계 패널
		panel.setBounds(5, 350, 785, 253);
		add(panel);
		panel.setVisible(false);
		
		//다음단계
				JButton btnNewButton_1 = new JButton("\uB2E4\uC74C \uB2E8\uACC4"); 
				btnNewButton_1.setBounds(841, 407, 127, 40);
				add(btnNewButton_1);
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel.setVisible(true);
					}
				});
		

				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(DAO.overlap_id_manager(textField.getText())==0) {
							aa.showMessageDialog(null, "사용할 수 있는 아이디입니다.");
							isoverlap=false;
						}
						else {
							aa.showMessageDialog(null, "아이디가 중복됩니다.");
							isoverlap=true;
						}
					}
				});
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				machine=new search();
				machine.update_XY(textField_2.getText());
				machine.search_result(textField_3.getText());
				ArrayList<String[]> list1 = machine.get_result();
				for(int i=0;i<(int)list1.size();i++) {
					comboBox.addItem(list1.get(i)[1]);
				}
			}
		});
		signup_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isoverlap) {
					if (!passwordField_1.getText().equals(passwordField.getText())) {
						aa.showMessageDialog(null, "비밀번호가 동일하지 않습니다.");
					} else {
						String shop="";
						String id=textField.getText();
						String pw= passwordField_1.getText();
						String HP=textField_1.getText();
						if(comboBox.getSelectedItem()==null||HP.equals("")||pw.equals("")||id.equals("")) {
							aa.showMessageDialog(null, "모두 입력해주세요");	
						}else {
							shop=comboBox.getSelectedItem().toString();
							DAO.manager_signup(new DTO_manager_login(id,pw,HP,shop));
							aa.showMessageDialog(null, "환영합니다"+id+"님");	
						}
					}
				}
				else
					aa.showMessageDialog(null, "아이디가 중복됩니다.");
				
			}
		});
	}
}

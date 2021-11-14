package github;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	/**
	 * Create the panel.
	 */
	public signup_manager() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JButton btnNewButton = new JButton("\uC911\uBCF5\uD655\uC778");
		btnNewButton.setBounds(185, 16, 97, 30);
		add(btnNewButton);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		passwordField_1.setBackground(Color.WHITE);
		passwordField_1.setBounds(12, 60, 160, 40);
		add(passwordField_1);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "ID", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField.setBounds(13, 10, 160, 40);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "H.P", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(12, 160, 160, 40);
		add(textField_1);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Password check", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(12, 110, 160, 40);
		add(passwordField);
		
		lblNewLabel = new JLabel("\uC810\uD3EC");
		lblNewLabel.setBounds(12, 222, 57, 15);
		add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "\uC9C0\uC5ED", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(12, 247, 160, 40);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "\uC0C1\uD638\uBA85", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(185, 247, 160, 40);
		add(textField_3);
		
		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		comboBox.setBounds(12, 297, 333, 40);
		add(comboBox);
		
		signup_bt = new JButton("\uAC00\uC785");
		signup_bt.setBounds(185, 377, 97, 30);
		add(signup_bt);
		
		JButton btnNewButton_2_1 = new JButton("\uAC80\uC0C9");
		btnNewButton_2_1.setBounds(354, 299, 97, 30);
		add(btnNewButton_2_1);

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

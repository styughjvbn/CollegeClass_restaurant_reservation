package github;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class signup_customer extends JPanel {
	private JPasswordField pwtxt;
	private JTextField idtxt;
	private JPasswordField pwtxtc;
	private JTextField nametxt;
	private JTextField agetxt;
	private JButton btnNewButton_2;
	private JOptionPane aa=new JOptionPane();
	private search machine= new search();
	private boolean  isoverlap;
	private JComboBox comboBox;
	private DAO_signup DAO=new DAO_signup();
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public signup_customer() {
		setBackground(new Color(226,221,215));
		setLayout(null);
		
		JButton btnNewButton = new JButton("\uC911\uBCF5\uD655\uC778");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(225, 75, 97, 30);
		add(btnNewButton);
		
		pwtxt = new JPasswordField();
		pwtxt.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pwtxt.setBackground(Color.WHITE);
		pwtxt.setBounds(13, 115, 201, 40);
		add(pwtxt);
		
		idtxt = new JTextField();
		idtxt.setBackground(Color.WHITE);
		idtxt.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "ID", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		idtxt.setBounds(13, 65, 200, 40);
		add(idtxt);
		idtxt.setColumns(10);
		
		pwtxtc = new JPasswordField();
		pwtxtc.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Password check", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pwtxtc.setBackground(Color.WHITE);
		pwtxtc.setBounds(13, 165, 201, 40);
		add(pwtxtc);
		
		nametxt = new JTextField();
		nametxt.setColumns(10);
		nametxt.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		nametxt.setBackground(Color.WHITE);
		nametxt.setBounds(13, 15, 160, 40);
		add(nametxt);
		
		agetxt = new JTextField();
		agetxt.setColumns(10);
		agetxt.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Age", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		agetxt.setBackground(Color.WHITE);
		agetxt.setBounds(157, 257, 57, 40);
		add(agetxt);
		
		btnNewButton_2 = new JButton("\uAC00\uC785");
		btnNewButton_2.setBounds(185, 377, 97, 30);
		add(btnNewButton_2);
		
		comboBox = new JComboBox(new Object[]{});
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"male", "female"}));
		comboBox.setForeground(Color.BLACK);
		comboBox.setBounds(23, 272, 116, 21);
		add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "H.P.", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textField.setBackground(Color.WHITE);
		textField.setBounds(13, 215, 201, 40);
		add(textField);
		
		JLabel lblNewLabel = new JLabel("\uC131\uBCC4");
		lblNewLabel.setBounds(0, 275, 57, 15);
		add(lblNewLabel);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(DAO.overlap_id_customer(idtxt.getText())==0) {
					aa.showMessageDialog(null, "사용할 수 있는 아이디입니다.");
					isoverlap=false;
				}
				else {
					aa.showMessageDialog(null, "아이디가 중복됩니다.");
					isoverlap=true;
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
						String age=agetxt.getText();
						String name=nametxt.getText();
						String Gender=comboBox.getSelectedItem().toString();
						String HP=textField.getText();
						
						if(age.equals("")||name.equals("")||HP.equals("")||pw.equals("")||id.equals("")||Gender.equals("")) {
							aa.showMessageDialog(null, "모두 입력해주세요");	
						}else {
							DAO.customer_signup(new DTO_customer_login(id,pw,HP,Gender,name,age));
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

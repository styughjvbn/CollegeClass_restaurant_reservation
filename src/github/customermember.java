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
import javax.swing.DefaultComboBoxModel;

public class customermember extends JPanel {
	private JPasswordField pwtxt;
	private JTextField idtxt;
	private JPasswordField pwtxtc;
	private JTextField nametxt;
	private JTextField agetxt;
	private JButton btnNewButton_2;
	private Customer customer = new Customer();
	private JOptionPane aa=new JOptionPane();
	private search machine= new search();
	private boolean  isoverlap;
	private JComboBox comboBox;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public customermember() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("\uC911\uBCF5\uD655\uC778");
		btnNewButton.setBounds(185, 16, 97, 30);
		add(btnNewButton);
		
		pwtxt = new JPasswordField();
		pwtxt.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pwtxt.setBackground(SystemColor.menu);
		pwtxt.setBounds(12, 60, 160, 40);
		add(pwtxt);
		
		idtxt = new JTextField();
		idtxt.setBackground(UIManager.getColor("Button.background"));
		idtxt.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "ID", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		idtxt.setBounds(13, 10, 160, 40);
		add(idtxt);
		idtxt.setColumns(10);
		
		pwtxtc = new JPasswordField();
		pwtxtc.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Password check", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pwtxtc.setBackground(SystemColor.menu);
		pwtxtc.setBounds(12, 110, 160, 40);
		add(pwtxtc);
		
		nametxt = new JTextField();
		nametxt.setColumns(10);
		nametxt.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		nametxt.setBackground(SystemColor.menu);
		nametxt.setBounds(195, 60, 160, 40);
		add(nametxt);
		
		agetxt = new JTextField();
		agetxt.setColumns(10);
		agetxt.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Age", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		agetxt.setBackground(SystemColor.menu);
		agetxt.setBounds(195, 110, 160, 40);
		add(agetxt);
		
		btnNewButton_2 = new JButton("\uAC00\uC785");
		btnNewButton_2.setBounds(185, 377, 97, 30);
		add(btnNewButton_2);
		
		comboBox = new JComboBox(new Object[]{});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"male", "female"}));
		comboBox.setForeground(Color.BLACK);
		comboBox.setBounds(30, 175, 116, 21);
		add(comboBox);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Gender", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textField_4.setBackground(SystemColor.menu);
		textField_4.setBounds(12, 160, 160, 40);
		add(textField_4);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(customer.overlap_id(idtxt.getText())==0) {
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
						char[] pw= pwtxt.getPassword();
						String age=agetxt.getText();
						String name=nametxt.getText();
						String Gender=comboBox.getSelectedItem().toString();
						customer.customer_signup(id,pw,name,age,Gender);
					}
				}
				else
					aa.showMessageDialog(null, "아이디가 중복됩니다.");
				
			}
		});
	}
}

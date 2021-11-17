package github;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.util.ArrayList;
import java.util.Calendar;

public class customerpanel extends JPanel {
	private JTextField nametxt;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	Calendar calendar = Calendar.getInstance(); //java에서 날짜 + 시간을 받아옴
	private JButton checkbutton;
	
	/**
	 * Create the panel.
	 */
	public customerpanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBounds(676, 23, 298, 266);
		add(panel);
		panel.setLayout(null);
		
		nametxt = new JTextField();
		nametxt.setColumns(10);
		nametxt.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "\uC608\uC57D\uC790\uBA85", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		nametxt.setBackground(Color.WHITE);
		nametxt.setBounds(48, 22, 160, 40);
		panel.add(nametxt);
		
		JComboBox peoplebox = new JComboBox();
		peoplebox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		peoplebox.setBounds(67, 81, 141, 23);
		panel.add(peoplebox);
		
		textField_1 = new JTextField();
		textField_1.setText("\uC778\uC6D0\uC218");
		textField_1.setBounds(12, 82, 43, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("\uC2DC\uAC04");
		textField_2.setBounds(12, 132, 43, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox timebox = new JComboBox();
		timebox.setModel(new DefaultComboBoxModel(new String[] {"10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00"}));
		timebox.setBounds(67, 131, 141, 23);
		panel.add(timebox);
		
		textField_3 = new JTextField();
		textField_3.setText("\uB0A0\uC9DC");
		textField_3.setBounds(12, 185, 43, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox datebox = new JComboBox();
		datebox.setBounds(67, 184, 141, 23);
		//JAVA util을 써서 월과 일을 가져옴
		int Month = calendar.get(calendar.MONTH);
		int Day = calendar.get(calendar.DAY_OF_MONTH);
		//날짜 최대 5일까지 받음
		datebox.addItem((Month+1)+"-"+Day);
		datebox.addItem((Month+1)+"-"+(Day+1));
		datebox.addItem((Month+1)+"-"+(Day+2));
		datebox.addItem((Month+1)+"-"+(Day+3));
		datebox.addItem((Month+1)+"-"+(Day+4));
		panel.add(datebox);
		
		checkbutton = new JButton("Check");
		checkbutton.setBounds(189, 231, 97, 23);
		checkbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nametxt.getText();
				String people = peoplebox.getSelectedItem().toString();
				String time = timebox.getSelectedItem().toString();
				String date = datebox.getSelectedItem().toString();
						//String Gender=comboBox.getSelectedItem().toString();
				
			}
			
		});
		panel.add(checkbutton);

	}
}

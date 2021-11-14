package github;

import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class reservation_base extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private search machine=new search();
	private ArrayList<String[]> list1;

	/**
	 * Create the panel.
	 */
	public reservation_base() {
		setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, "name_257469438277100");
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBorder(new TitledBorder(null, "rotation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField.setBounds(77, 90, 146, 51);
		panel.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(790, 95, 313, 51);
		panel.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new TitledBorder(null, "keyword", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField_1.setBounds(246, 90, 146, 51);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				machine.update_XY(textField.getText());
				machine.search_result(textField_1.getText());
				list1 = machine.get_result();
				comboBox.removeAllItems();
				for(int i=0;i<(int)list1.size();i++) {
					comboBox.addItem(list1.get(i)[0]);
				}
			}
		});
		btnNewButton.setBounds(469, 61, 197, 119);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\uC774\uBBF8\uC9C0");
		lblNewLabel.setBounds(77, 212, 482, 306);
		panel.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(588, 212, 527, 306);
		panel.add(textArea);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource(); // 콤보박스 알아내기
                int index = cb.getSelectedIndex();// 선택된 아이템의 인덱스
                textArea.append(list1.get(index)[0]+"\n");
                textArea.append(list1.get(index)[1]+"\n");
                textArea.append(list1.get(index)[2]+"\n");
                textArea.append(list1.get(index)[3]+"\n");
                textArea.append(list1.get(index)[4]+"\n");
                System.out.println(index);
			}
		});

	}
}

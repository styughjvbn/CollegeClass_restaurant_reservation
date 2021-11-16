package github;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class reservation_base extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private search machine;
	private ArrayList<String[]> list1;
	private JTextField shop_name;
	private JTextField shop_tel;
	private JTextField shop_distance;
	private JTextField shop_adress;
	private JTextField shop_category;
	private static_map_image create_image=new static_map_image();
	private String shop="";

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
		textField.setBounds(28, 51, 146, 51);
		panel.add(textField);
		textField.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox();
		comboBox.setBounds(742, 56, 313, 51);
		panel.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new TitledBorder(null, "keyword", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField_1.setBounds(221, 51, 146, 51);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				machine=new search();
				machine.update_XY(textField.getText());
				machine.search_result(textField_1.getText());
				list1 = machine.get_result();
				System.out.println("list1의 사이즈 : "+list1.size());
				comboBox.removeAllItems();
				for(int i=0;i<(int)list1.size();i++) {
					comboBox.addItem(list1.get(i)[0]);
				}
			}
		});
		btnNewButton.setBounds(431, 51, 197, 51);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(28, 151, 600, 400);
		panel.add(lblNewLabel);
		
		shop_name = new JTextField();
		shop_name.setEditable(false);
		shop_name.setBounds(742, 211, 329, 21);
		panel.add(shop_name);
		shop_name.setColumns(10);
		
		shop_tel = new JTextField();
		shop_tel.setEditable(false);
		shop_tel.setBounds(742, 258, 329, 21);
		panel.add(shop_tel);
		shop_tel.setColumns(10);
		
		shop_distance = new JTextField();
		shop_distance.setEditable(false);
		shop_distance.setBounds(742, 317, 329, 21);
		panel.add(shop_distance);
		shop_distance.setColumns(10);
		
		shop_adress = new JTextField();
		shop_adress.setEditable(false);
		shop_adress.setBounds(742, 377, 329, 21);
		panel.add(shop_adress);
		shop_adress.setColumns(10);
		
		shop_category = new JTextField();
		shop_category.setEditable(false);
		shop_category.setBounds(742, 433, 329, 21);
		panel.add(shop_category);
		shop_category.setColumns(10);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int index = cb.getSelectedIndex();
				if (index > -1) {
					shop_name.setText(list1.get(index)[0]);
					shop_tel.setText(list1.get(index)[1]);
					shop_distance.setText(list1.get(index)[2]);
					shop_adress.setText(list1.get(index)[3]);
					shop_category.setText(list1.get(index)[4]);
					create_image.create_map_image(machine.get_center_x(), machine.get_center_y(), list1.get(index)[5],list1.get(index)[6], shop, list1.get(index)[0]);
					lblNewLabel.setIcon(new ImageIcon("image/shop/" + list1.get(index)[0] + ".png"));
					shop = list1.get(index)[0];
				}
			}
		});

	}
}

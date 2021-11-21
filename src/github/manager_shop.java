package github;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

class shop_table extends JLabel{
	int x,y;
	int size;
	public shop_table(int num,int tablenum){
		size=num;
		setBounds(0, 0, 100, 100);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setIcon(new ImageIcon("image/"+size+".png"));
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), Integer.toString(tablenum), TitledBorder.LEADING, TitledBorder.BOTTOM, null, new Color(0, 0, 0)));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x=e.getX();
				y=e.getY();
				System.out.println(x+" "+y);
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int a=e.getX()-x;
				int b=e.getY()-y;
				int old_x=getX();
				int old_y=getY();
				int hhh=old_x+a;
				int ggg=old_y+b;
				if(hhh<700&&hhh>0&&ggg>0&&ggg<500)
					setLocation(old_x+a,old_y+b);
				System.out.println(a+" "+b);
				
			}
		});
	}
}

public class manager_shop extends JPanel {
	private ArrayList<shop_table> shop_table=new ArrayList();
	int table_num=-1;
	int holyday[]=new int[7];
	private DAO_signup DAO=new DAO_signup();
	public String shop;
	/**
	 * Create the panel.
	 */
	public manager_shop() {
		setLayout(null);
		JButton btnNewButton_3 = new JButton("\uB9CC\uB4E4\uAE30");
		btnNewButton_3.setBounds(842, 311, 305, 31);
		add(btnNewButton_3);
		
		
		JLabel lblNewLabel = new JLabel("\uC778\uC6D0\uC218");
		lblNewLabel.setBounds(842, 267, 144, 31);
		add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "5"}));
		comboBox.setBounds(1009, 267, 138, 31);
		add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(12, 67, 800, 600);
		add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"}));
		comboBox_1.setBounds(885, 46, 97, 23);
		add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"}));
		comboBox_2.setBounds(1033, 46, 118, 23);
		add(comboBox_2);
		
		JLabel lblNewLabel_2 = new JLabel("\uC601\uC5C5\uC2DC\uAC04");
		lblNewLabel_2.setBounds(810, 50, 57, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("~");
		lblNewLabel_3.setBounds(994, 50, 57, 15);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uD734\uBB34\uC77C");
		lblNewLabel_4.setBounds(810, 103, 57, 15);
		add(lblNewLabel_4);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\uC6D4");
		chckbxNewCheckBox.setBounds(893, 99, 45, 23);
		add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("\uD654");
		chckbxNewCheckBox_1.setBounds(942, 99, 45, 23);
		add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("\uC218");
		chckbxNewCheckBox_2.setBounds(993, 99, 45, 23);
		add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("\uBAA9");
		chckbxNewCheckBox_3.setBounds(1042, 99, 45, 23);
		add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("\uAE08");
		chckbxNewCheckBox_4.setBounds(1090, 99, 45, 23);
		add(chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("\uD1A0");
		chckbxNewCheckBox_5.setBounds(1142, 99, 45, 23);
		add(chckbxNewCheckBox_5);
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("\uC77C");
		chckbxNewCheckBox_6.setBounds(1191, 99, 45, 23);
		add(chckbxNewCheckBox_6);
		
		JLabel lblNewLabel_5 = new JLabel("\uC810\uD3EC\uAD00\uB9AC");
		lblNewLabel_5.setBounds(176, 16, 342, 64);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_1 = new JLabel("\uD14C\uC774\uBE14 \uAD00\uB9AC");
		lblNewLabel_1.setBounds(842, 192, 196, 65);
		add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\uAC00\uC7A5 \uCD5C\uADFC \uD14C\uC774\uBE14 \uC0AD\uC81C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.remove(table_num);
				panel_1.repaint();
				shop_table.remove(table_num--);
			}
		});
		btnNewButton.setBounds(842, 410, 305, 31);
		add(btnNewButton);

		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int num=comboBox.getSelectedIndex()+2;
				shop_table temp=new shop_table(num,++table_num+1);
				shop_table.add(temp);
				
				panel_1.add(shop_table.get(table_num),table_num);
				panel_1.repaint();
			}
		});
		JButton btnNewButton_4 = new JButton("\uC800\uC7A5");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int open=comboBox_1.getSelectedIndex();
				int close=comboBox_2.getSelectedIndex();
				int count=comboBox.getSelectedIndex()+2;
				byte holyday=0;
				if(chckbxNewCheckBox.isSelected())
					holyday+=127;
				if(chckbxNewCheckBox_1.isSelected())
					holyday+=63;
				if(chckbxNewCheckBox_2.isSelected())
					holyday+=31;
				if(chckbxNewCheckBox_3.isSelected())
					holyday+=15;
				if(chckbxNewCheckBox_4.isSelected())
					holyday+=7;
				if(chckbxNewCheckBox_5.isSelected())
					holyday+=3;
				if(chckbxNewCheckBox_6.isSelected())
					holyday+=1;
				DAO.update_shop(new DTO_shop(shop,(byte)holyday,open,close,shop_table.size()));
				for(int i=0;i<shop_table.size();i++) {
					DAO.new_table(new DTO_manage_table(i+1,shop,shop_table.get(i).size,shop_table.get(i).getX(),shop_table.get(i).getY()));
					System.out.println(shop_table.get(i).getX()+" "+shop_table.get(i).getY());
				}
				
			}
		});
		btnNewButton_4.setBounds(842, 538, 305, 77);
		add(btnNewButton_4);
	}
}


package github;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class manage_reservation extends JPanel {

	/**
	 * Create the panel.
	 */

	public String shop_name;
	public JButton manage_reservation_back;
	private JTable table_c;
	private JTable table_o;
	private DAO_manager DAO=new DAO_manager();
	public ArrayList<String []> data1;
	public ArrayList<String []> data2;
	DefaultTableModel temp;
	DefaultTableModel temp1;
	
	void init(String shop) {
		
		data1 = DAO.getCurrentReservation(shop);
		temp = (DefaultTableModel)table_c.getModel();
		for(int i=0;i<data1.size();i++) {
			temp.addRow(data1.get(i));
		}
		
		data2 = DAO.getOldReservation(shop);
		temp1 = (DefaultTableModel)table_o.getModel();
		for(int i=0;i<data2.size();i++) {
			temp1.addRow(data2.get(i));
		}

	}
	public manage_reservation() {
		setLayout(null);

		table_c = new JTable();
		table_c.setFont(new Font("¼¼¹æ°íµñ º¸Åë", Font.PLAIN, 15));
		table_c.setBackground(new Color(226,221,215));
		table_c.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uC774\uB984", "\uC804\uD654\uBC88\uD638", "\uC778\uC6D0\uC218", "\uC608\uC57D\uC2DC\uAC04", "\uC608\uC57D\uB0A0\uC9DC", "\uC608\uC57D\uAE08", "\uC608\uC57D\uBA54\uB274", "\uC608\uC57D\uD14C\uC774\uBE14", "\uC694\uCCAD\uC2DC\uAC04"
			}
		));
		table_c.setBounds(22, 95, 966, 192);
		table_c.setPreferredScrollableViewportSize(new Dimension(800,100));
		table_c.setAlignmentX(0);
		JScrollPane scrollPane = new JScrollPane(table_c);
		scrollPane.setBounds(140, 145, 1000, 200);
		add(scrollPane);

		JLabel lblNewLabel = new JLabel("\uD604\uC7AC \uC608\uC57D");
		lblNewLabel.setFont(new Font("¼¼¹æ°íµñ ±½°Ô", Font.BOLD, 15));
		lblNewLabel.setBounds(140, 98, 189, 37);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uC9C0\uB09C\uC608\uC57D");
		lblNewLabel_1.setFont(new Font("¼¼¹æ°íµñ ±½°Ô", Font.BOLD, 15));
		lblNewLabel_1.setBounds(140, 376, 149, 23);
		add(lblNewLabel_1);
		
	    table_o = new JTable();
	    table_o.setFont(new Font("¼¼¹æ°íµñ º¸Åë", Font.PLAIN, 15));
		table_o.setBackground(new Color(226,221,215));
	    table_o.setModel(new DefaultTableModel(
	    	new Object[][] {
	    	},
	    	new String[] {
	    		"\uC774\uB984", "\uC804\uD654\uBC88\uD638", "\uC608\uC57D\uC2DC\uAC04", "\uC608\uC57D\uB0A0\uC9DC", "\uC778\uC6D0\uC218", "\uC608\uC57D\uAE08", "\uC608\uC57D\uBA54\uB274", "\uB098\uC774", "\uC131\uBCC4(1=male 2=female)"
	    	}
	    ));
		table_o.setBounds(22, 340, 150, 20);
		table_o.setPreferredScrollableViewportSize(new Dimension(800,100));
		table_o.setAlignmentX(0);
		JScrollPane scrollPane_o = new JScrollPane(table_o);
		scrollPane_o.setBounds(140, 409, 1000, 200);
		add(scrollPane_o);
		
		JButton manage_reservation_back = new JButton("");
		manage_reservation_back.setBorder(null);
		manage_reservation_back.setIcon(new ImageIcon("image/back2.png"));
		manage_reservation_back.setBounds(44, 54, 120, 50);
		add(manage_reservation_back);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("image/managebase.png"));
		lblNewLabel_2.setBounds(0, 0, 1280, 720);
		add(lblNewLabel_2);
		manage_reservation_back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				int count1=temp.getRowCount();
				for(int i=0;i<count1;i++) {
					temp.removeRow(0);
				}
				int count2=temp1.getRowCount();
				for(int i=0;i<count2;i++) {
					temp1.removeRow(0);
				}
				
			}
			
		});
		
		

	}
}

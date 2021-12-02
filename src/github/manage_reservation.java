package github;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JButton;

public class manage_reservation extends JPanel {

	/**
	 * Create the panel.
	 */

	public String shop_name;
	public JButton manage_reservation_back;
	private JTable table_c;
	private JTable table_o;
	private DAO_oldreservation DAO=new DAO_oldreservation();
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
		
		//지난 예약
		data2 = DAO.getOldReservation(shop);
		temp1 = (DefaultTableModel)table_o.getModel();
		for(int i=0;i<data2.size();i++) {
			temp1.addRow(data2.get(i));
		}

	}
	public manage_reservation() {
		setLayout(null);

		table_c = new JTable();
		table_c.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[]{"id","count","time","date","money","menu","table","book_time"}
				));
		table_c.setBounds(22, 95, 966, 192);
		table_c.setPreferredScrollableViewportSize(new Dimension(800,100));
		table_c.setAlignmentX(0);
		JScrollPane scrollPane = new JScrollPane(table_c);
		scrollPane.setBounds(80, 45, 802, 128);
		add(scrollPane);

		JLabel lblNewLabel = new JLabel("\uD604\uC7AC \uC608\uC57D");
		lblNewLabel.setBounds(80, 30, 126, 15);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uC9C0\uB09C\uC608\uC57D");
		lblNewLabel_1.setBounds(80, 283, 114, 15);
		add(lblNewLabel_1);
		
	    table_o = new JTable();
	    table_o.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[]{"id","count","time","date","money","menu","table","book_time"}
				));
		table_o.setBounds(22, 340, 150, 20);
		table_o.setPreferredScrollableViewportSize(new Dimension(800,100));
		table_o.setAlignmentX(0);
		JScrollPane scrollPane_o = new JScrollPane(table_o);
		scrollPane_o.setBounds(80, 304, 802, 128);
		add(scrollPane_o);
		
		JButton manage_reservation_back = new JButton("Back");
		manage_reservation_back.setBounds(972, 553, 59, 23);
		add(manage_reservation_back);
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

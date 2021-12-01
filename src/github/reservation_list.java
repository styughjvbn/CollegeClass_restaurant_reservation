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

public class reservation_list extends JPanel {

	/**
	 * Create the panel.
	 */

	public String shop_name;
	public JButton manage_reservation_back;
	public int i =0;
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
		for(int i=0;i<data1.size();i++) {
			temp1.addRow(data2.get(i));
		}

	}
	public reservation_list() {
		setLayout(null);
		//���� ���� �մ�

		//String[][] data = {{"1","2","3","4","5","6","7","8"}};
		//String[] headings = new String[] {"id","count","time","date","money","menu","table","book_time"};
		//setLayout(null);
		//String[] [] data = DAO_oldreservation.getCurrentReservation(DTO_reservation_current.get_shop()); ���������� ������ ����� �̰� �����.. DAO���� List�� ��ȯ�ϰ� �س��� �װ� �ϸ� �ɰŰ����� �𸣰ڳ�
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
		//�ؽ�Ʈ ���� ����
		JLabel lblNewLabel = new JLabel("\uD604\uC7AC \uC608\uC57D");
		lblNewLabel.setBounds(80, 30, 126, 15);
		add(lblNewLabel);
		//�ؽ�Ʈ ���� ����
		JLabel lblNewLabel_1 = new JLabel("\uC9C0\uB09C\uC608\uC57D");
		lblNewLabel_1.setBounds(80, 283, 114, 15);
		add(lblNewLabel_1);
		//���� ���� �մ�
		//String[][] olddata = DAO_oldreservation.getOldReservation(shop_name);
		//String[][] olddata = {{"1","2","3","4","5","6","7","8","9"},
				//{"1","2","3","4","5","6","7","8","9"}};
		//String [] head = new String[]{"id","shop","count","time","date","money","menu","table","book_time"};
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
				for(int i=0;i<data1.size();i++) {
					temp.removeRow(i);
				}
				for(int i=0;i<data1.size();i++) {
					temp1.removeRow(i);
				}
				
			}
			
		});
		
		

	}
}

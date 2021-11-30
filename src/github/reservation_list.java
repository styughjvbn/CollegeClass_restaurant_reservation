package github;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Dimension;

import javax.swing.JLabel;

public class reservation_list extends JPanel {

	/**
	 * Create the panel.
	 */

	public String shop_name;
	
	void init(String shop) {
		shop_name = shop;
	}
	
	public reservation_list() {
		//현재 예약 손님
		String[] [] data = DAO_oldreservation.getCurrentReservation(shop_name);
		String[] headings = new String[] {"id","shop","count","time","date","money","menu","table","book_time"};
		setLayout(null);
		//String[] [] data = DAO_oldreservation.getCurrentReservation(DTO_reservation_current.get_shop()); 위에문장은 예시임 지우고 이거 쓰면됌.. DAO에서 List를 반환하게 해놨음 그거 하면 될거같은데 모르겠네
		JTable table_c = new JTable(data,headings);
		table_c.setBounds(22, 95, 966, 192);
		table_c.setPreferredScrollableViewportSize(new Dimension(800,100));
		table_c.setAlignmentX(0);
		JScrollPane scrollPane = new JScrollPane(table_c);
		scrollPane.setBounds(36, 51, 802, 206);
		add(scrollPane);
		//텍스트 현재 예약
		JLabel lblNewLabel = new JLabel("\uD604\uC7AC \uC608\uC57D");
		lblNewLabel.setBounds(36, 26, 223, 15);
		add(lblNewLabel);
		//텍스트 과거 예약
		JLabel lblNewLabel_1 = new JLabel("\uC9C0\uB09C\uC608\uC57D");
		lblNewLabel_1.setBounds(33, 326, 139, 15);
		add(lblNewLabel_1);
		//과거 예약 손님
		//String[] [] data = DAO_oldreservation.getOldReservation(DTO_reservation_old.get_shop());
		String [][] olddata = new String [][] {{"1","2","3","4","5","6","7","8","9"}};
		String [] head = new String[]{"id","shop","count","time","date","money","menu","table","book_time"};
		JTable table_o = new JTable(olddata,head);
		table_o.setBounds(22, 340, 150, 20);
		table_o.setPreferredScrollableViewportSize(new Dimension(800,100));
		table_o.setAlignmentX(0);
		JScrollPane scrollPane_o = new JScrollPane(table_o);
		scrollPane_o.setBounds(36, 351, 802, 206);
		add(scrollPane_o);
		
		
		

	}

}

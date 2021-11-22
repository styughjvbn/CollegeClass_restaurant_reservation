package github;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.util.ArrayList;
import java.util.Calendar;

class fixed_shop_table extends JLabel{//드래그로 배치가 가능한 테이블 라벨
	int x,y;
	int size;
	public fixed_shop_table(int num,int tablenum,int newx,int newy){
		size=num;
		setBounds(newx, newy, 100 ,100 );
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setIcon(new ImageIcon("image/"+size+".png"));
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), Integer.toString(tablenum), TitledBorder.LEADING, TitledBorder.BOTTOM, null, new Color(0, 0, 0)));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}
}
public class reservation_detail extends JPanel {
	private JTextField nametxt;
	private JTextField textField_2;
	private JTextField textField_3;
	public JButton detail_back;
	Calendar calendar = Calendar.getInstance(); //java에서 날짜 + 시간을 받아옴
	private JButton checkbutton;
	public DTO_shop cnt_shop;
	private ArrayList<fixed_shop_table> shop_table=new ArrayList();
	private DAO_reservation DAO= new DAO_reservation();
	private String img;
	private int table_num=-1;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private int open, close;
	private JComboBox timebox;
	private JLabel lblNewLabel_1;
	
	/**
	 * Create the panel.
	 */
	public reservation_detail() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBounds(902, 33, 251, 532);
		add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(29, 83, 800, 600);
		add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 800, 600);
		panel_1.add(lblNewLabel);
		
		nametxt = new JTextField();
		nametxt.setColumns(10);
		nametxt.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "\uC608\uC57D\uC790\uBA85", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		nametxt.setBackground(Color.WHITE);
		nametxt.setBounds(48, 22, 160, 40);
		panel.add(nametxt);
		
		textField_2 = new JTextField();
		textField_2.setText("\uC2DC\uAC04");
		textField_2.setBounds(12, 132, 43, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		timebox = new JComboBox();
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
		checkbutton.setBounds(48, 419, 97, 23);
		checkbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nametxt.getText();
				String time = timebox.getSelectedItem().toString();
				String date = datebox.getSelectedItem().toString();
						//String Gender=comboBox.getSelectedItem().toString();
				
			}
			
		});
		panel.add(checkbutton);
		
		lblNewLabel_1 = new JLabel("\uC778\uC6D0\uC218");
		lblNewLabel_1.setBounds(67, 243, 141, 21);
		panel.add(lblNewLabel_1);
		
		detail_back = new JButton("");//back버튼
		detail_back.setBounds(29, 23, 61, 50);
		add(detail_back);
		detail_back.setBorder(null);
		detail_back.setBackground(new Color(226,221,215));
		detail_back.setIcon(new ImageIcon("image/back.png"));
		
	}
	void init() {
		ArrayList<int[]> temp=DAO.get_table_info(cnt_shop.get_shop_name());
		open=cnt_shop.get_shop_open();
		close=cnt_shop.get_shop_close();
		img=cnt_shop.get_shop_iner();
		shop_table.clear();
		table_num=-1;
		panel_1.removeAll();
		panel_1.add(lblNewLabel);
		timebox.removeAllItems();
		
		if((img!=null)&&(!(img.equals("null")))) {
			lblNewLabel.setIcon(new ImageIcon(img));
			lblNewLabel.repaint();
		}
		else {
			lblNewLabel.setIcon(new ImageIcon("image/drag.jpg"));
			lblNewLabel.repaint();
		}
		for(int i=0;i<temp.size();i++) {
			fixed_shop_table tmp=new fixed_shop_table(temp.get(i)[1],++table_num+1,temp.get(i)[2],temp.get(i)[3]);
			shop_table.add(tmp);
			panel_1.add(shop_table.get(table_num),table_num);			
		}
		panel_1.repaint();
		if(open<close) {
			for(int i=open;i<close;i++)
				timebox.addItem(i+"시");
		}
		else {
			for(int i=open;i<=23;i++)
				timebox.addItem(i+"시");
			for(int i=0;i<close;i++)
				timebox.addItem(i+"시");
		}
		
	}
}

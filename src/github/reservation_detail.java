package github;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.DebugGraphics;

class fixed_shop_table extends JLabel{//드래그로 배치가 가능한 테이블 라벨
	int x,y;
	int size;
	int table_num;
	public fixed_shop_table(int num,int tablenum,int newx,int newy){
		size=num;
		table_num=tablenum;
		setBounds(newx, newy, 100 ,100 );
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setIcon(new ImageIcon("image/"+size+".png"));
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), Integer.toString(tablenum), TitledBorder.LEADING, TitledBorder.BOTTOM, null, new Color(0, 0, 0)));
	}
}
public class reservation_detail extends JPanel {
	private JTextField nametxt;
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
	public ArrayList<String> holyday;
	private JComboBox datebox;
	private JLabel time_label;
	private JLabel lblNewLabel_1;
	private JLabel table_number;
	private JLabel table_size;
	private JLabel lblNewLabel_3;
	private JPanel panel;
	
	/**
	 * Create the panel.
	 */
	public reservation_detail() {
		setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(29, 83, 800, 600);
		panel_1.setVisible(false);
		add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 800, 600);
		panel_1.add(lblNewLabel);
		
		datebox = new JComboBox();
		datebox.setBounds(907, 110, 141, 23);
		add(datebox);
		datebox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int index = cb.getSelectedIndex();
				System.out.println(index);
				if(index<1) {
					panel_1.setVisible(false);
					panel.setVisible(false);
				}
				else {
					panel_1.setVisible(true);
				}
				repaint();
			}
		});

		detail_back = new JButton("");//back버튼
		detail_back.setBounds(29, 23, 61, 50);
		add(detail_back);
		detail_back.setBorder(null);
		detail_back.setBackground(new Color(226,221,215));
		detail_back.setIcon(new ImageIcon("image/back.png"));
		
		
		JLabel lblNewLabel_2 = new JLabel("\uB0A0\uC9DC");
		lblNewLabel_2.setBounds(897, 85, 57, 15);
		add(lblNewLabel_2);
		
		nametxt = new JTextField();
		nametxt.setBounds(888, 23, 160, 40);
		add(nametxt);
		nametxt.setColumns(10);
		nametxt.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "\uC608\uC57D\uC790\uBA85", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		nametxt.setBackground(Color.WHITE);
		
		checkbutton = new JButton("Check");
		checkbutton.setBounds(986, 455, 97, 23);
		add(checkbutton);
		
		panel = new JPanel();
		panel.setVisible(false);
		panel.setBounds(907, 175, 176, 232);
		add(panel);
		panel.setLayout(null);
		
		time_label = new JLabel("\uC2DC\uAC04");
		time_label.setBounds(0, 0, 57, 15);
		panel.add(time_label);
		
		timebox = new JComboBox();
		timebox.setBounds(0, 25, 141, 23);
		panel.add(timebox);
		
		lblNewLabel_1 = new JLabel("\uC120\uD0DD\uB41C \uD14C\uC774\uBE14");
		lblNewLabel_1.setBounds(0, 47, 151, 23);
		panel.add(lblNewLabel_1);
		
		table_number = new JLabel("");
		table_number.setBounds(0, 68, 151, 15);
		panel.add(table_number);
		
		lblNewLabel_3 = new JLabel("\uD14C\uC774\uBE14 \uD5C8\uC6A9 \uC778\uC6D0");
		lblNewLabel_3.setBounds(0, 93, 92, 23);
		panel.add(lblNewLabel_3);
		
		table_size = new JLabel("");
		table_size.setBounds(0, 126, 160, 15);
		panel.add(table_size);
		
		checkbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nametxt.getText();
				String time = timebox.getSelectedItem().toString();
				String date = datebox.getSelectedItem().toString();
						//String Gender=comboBox.getSelectedItem().toString();
				
			}
			
		});
		
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
			tmp.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					panel.setVisible(true);
					timebox.removeAllItems();
					timebox.addItem("시간선택");
					table_number.setText(Integer.toString(tmp.table_num));
					table_size.setText(Integer.toString(tmp.size));
					String date=datebox.getSelectedItem().toString().substring(0,10);
					ArrayList<String> qq=DAO.get_enable_time(cnt_shop.get_shop_name(),date,tmp.table_num);
					int[] is;
					if(qq!=null) {//
						is=new int[qq.size()];
						for(int i=0;i<is.length;i++)
							is[i]=Integer.parseInt(qq.get(i).substring(0,2));
						if(open<close) {
							for(int i=open;i<close;i++) {
								boolean is_in=false;
								for(int j=0;j<is.length;j++) {
									if(is[j]==i)
										is_in=true;
								}
								if(!is_in)
									timebox.addItem(i+"시");
							}
						}
						else {
							for(int i=open;i<=23;i++){
								boolean is_in=false;
								for(int j=0;j<is.length;j++) {
									if(is[j]==i)
										is_in=true;
								}
								if(!is_in)
									timebox.addItem(i+"시");
							}
							for(int i=0;i<close;i++){
								boolean is_in=false;
								for(int j=0;j<is.length;j++) {
									if(is[j]==i)
										is_in=true;
								}
								if(!is_in)
									timebox.addItem(i+"시");
							}
						}
					}else {
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
					//DB에서 예약 내역 가져와서 빈 시간 추가 
					
				}
			});
			shop_table.add(tmp);
			panel_1.add(shop_table.get(table_num),table_num);			
		}
		panel_1.repaint();
		set_reservationdate();
	}

	void set_reservationdate() {
		// JAVA util을 써서 월과 일을 가져옴
		datebox.removeAllItems();
		datebox.addItem("날짜선택");
		for (int i = 0; i < 7; i++) {
			boolean is_holyday = false;
			int year = calendar.get(calendar.YEAR);
			int Month = calendar.get(calendar.MONTH) + 1;
			int Day = calendar.get(calendar.DAY_OF_MONTH);
			int week = calendar.get(calendar.DAY_OF_WEEK);
			String week_ = "";
			switch (week) {
			case 1:
				week_ = "월";
				break;
			case 2:
				week_ = "화";
				break;
			case 3:
				week_ = "수";
				break;
			case 4:
				week_ = "목";
				break;
			case 5:
				week_ = "금";
				break;
			case 6:
				week_ = "토";
				break;
			case 7:
				week_ = "일";
				break;
			}
			for (int j = 0; j < holyday.size(); j++) {
				if (week_.equals(holyday.get(j))) {
					is_holyday = true;
					break;
				}
			}
			if (!is_holyday)
				datebox.addItem(year + "-" + Month + "-" + Day + "(" + week_ + ")");
			calendar.add(calendar.DAY_OF_MONTH, 1);
		}
	}
}

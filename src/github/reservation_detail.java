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
import java.awt.Font;

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
	public JButton checkbutton;
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
	private JPanel panel;
	private JLabel lblNewLabel_3;
	private JLabel table_size_1;
	private JLabel table_size_2;
	private JLabel table_size_3;
	private JLabel table_number_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;

	
	/**
	 * Create the panel.
	 */
	public reservation_detail() {
		setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(37, 49, 800, 600);
		add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 800, 600);
		panel_1.add(lblNewLabel);
		
		datebox = new JComboBox();
		datebox.setBackground(new Color(226,221,215));
		datebox.setFont(new Font("세방고딕 보통", Font.PLAIN, 15));
		datebox.setBounds(895, 150, 289, 33);
		add(datebox);
		//날짜 선택하면 시간선택화면 나옴
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
					panel.setVisible(true);
				}
				repaint();
			}
		});

		detail_back = new JButton("\uC774\uC804\uD654\uBA74");//back버튼
		detail_back.setForeground(new Color(120, 108, 100));
		detail_back.setFont(new Font("세방고딕 굵게", Font.BOLD, 17));
		detail_back.setBounds(900, 489, 284, 49);
		add(detail_back);
		detail_back.setBorder(new LineBorder(new Color(200, 184, 164), 2, true));
		detail_back.setBackground(new Color(200, 184, 164));
		detail_back.setIcon(null);
		
		
		JLabel lblNewLabel_2 = new JLabel("\uB0A0\uC9DC \uC120\uD0DD");
		lblNewLabel_2.setFont(new Font("세방고딕 보통", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(895, 122, 80, 23);
		add(lblNewLabel_2);
		
		checkbutton = new JButton("\uC88C\uC11D \uC120\uD0DD \uC644\uB8CC");
		checkbutton.setForeground(Color.WHITE);
		checkbutton.setBackground(new Color(120, 108, 100));
		checkbutton.setBorder(new LineBorder(new Color(120, 108, 100), 2, true));
		checkbutton.setFont(new Font("세방고딕 굵게", Font.BOLD, 17));
		checkbutton.setBounds(900, 548, 284, 49);
		add(checkbutton);
		
		panel = new JPanel();
		panel.setBackground(new Color(226,221,215));
		panel.setVisible(false);
		panel.setBounds(895, 184, 289, 269);
		add(panel);
		panel.setLayout(null);
		
		table_size_3 = new JLabel("\uBA85\uC785\uB2C8\uB2E4.");
		table_size_3.setForeground(new Color(120, 108, 100));
		table_size_3.setFont(new Font("세방고딕 굵게", Font.BOLD, 15));
		table_size_3.setBounds(25, 156, 233, 23);
		panel.add(table_size_3);
		
		table_size_2 = new JLabel("* \uC120\uD0DD\uD558\uC2E0 \uD14C\uC774\uBE14\uC758 \uCD5C\uB300 \uD5C8\uC6A9 \uC778\uC6D0\uC218\uB294");
		table_size_2.setForeground(new Color(120, 108, 100));
		table_size_2.setFont(new Font("세방고딕 굵게", Font.BOLD, 15));
		table_size_2.setBounds(5, 134, 279, 23);
		panel.add(table_size_2);
		
		table_size = new JLabel("");
		table_size.setForeground(new Color(120, 108, 100));
		table_size.setFont(new Font("세방고딕 굵게", Font.BOLD, 15));
		table_size.setBounds(7, 156, 23, 23);
		panel.add(table_size);
		
		time_label = new JLabel("\uC2DC\uAC04 \uC120\uD0DD");
		time_label.setFont(new Font("세방고딕 보통", Font.PLAIN, 15));
		time_label.setBounds(0, 10, 119, 23);
		panel.add(time_label);
		
		timebox = new JComboBox();
		timebox.setBackground(new Color(226,221,215));
		timebox.setFont(new Font("세방고딕 보통", Font.PLAIN, 15));
		timebox.setBounds(0, 38, 289, 33);
		panel.add(timebox);
		
		table_number = new JLabel("");
		table_number.setFont(new Font("세방고딕 굵게", Font.BOLD, 15));
		table_number.setBounds(110, 99, 23, 23);
		panel.add(table_number);
		
		JLabel time_label_1 = new JLabel("\uC608\uC57D\uC790\uBA85 \uC785\uB825");
		time_label_1.setForeground(new Color(120, 108, 100));
		time_label_1.setBounds(0, 210, 97, 19);
		panel.add(time_label_1);
		time_label_1.setFont(new Font("세방고딕 굵게", Font.BOLD, 15));
		
		nametxt = new JTextField();
		nametxt.setFont(new Font("세방고딕 굵게", Font.BOLD, 15));
		nametxt.setBounds(110, 210, 159, 19);
		panel.add(nametxt);
		nametxt.setColumns(10);
		nametxt.setBorder(null);
		nametxt.setBackground(new Color(226,221,215));
		
		lblNewLabel_1 = new JLabel("\uC120\uD0DD\uD55C \uD14C\uC774\uBE14");
		lblNewLabel_1.setBounds(0, 99, 103, 23);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(120, 108, 100));
		lblNewLabel_1.setFont(new Font("세방고딕 굵게", Font.BOLD, 15));
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\kmj\\Documents\\GitHub\\restaurant_reservation\\image\\hsection_icon.png"));
		lblNewLabel_3.setBounds(103, 224, 186, 15);
		panel.add(lblNewLabel_3);
		
		table_size_1 = new JLabel("");
		table_size_1.setIcon(new ImageIcon("C:\\Users\\kmj\\Documents\\GitHub\\restaurant_reservation\\image\\shadowicon.png"));
		table_size_1.setBounds(0, 127, 289, 57);
		panel.add(table_size_1);
		
		table_number_1 = new JLabel("\uBC88");
		table_number_1.setFont(new Font("세방고딕 굵게", Font.BOLD, 15));
		table_number_1.setBounds(128, 99, 23, 23);
		panel.add(table_number_1);
		
		lblNewLabel_1_1 = new JLabel("\uC608\uC57D \uC815\uBCF4 \uC785\uB825");
		lblNewLabel_1_1.setFont(new Font("세방고딕 굵게", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(895, 68, 128, 21);
		add(lblNewLabel_1_1);
		
		lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon("C:\\Users\\kmj\\Documents\\GitHub\\restaurant_reservation\\image\\hsection_icon.png"));
		lblNewLabel_1_1_1.setFont(new Font("세방고딕 굵게", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(895, 86, 289, 21);
		add(lblNewLabel_1_1_1);
		
	}
	DTO_reservation_current get_data() {
		return new DTO_reservation_current(
				"",
				cnt_shop.get_shop_name(),
				Integer.parseInt(table_size.getText().toString()),
				timebox.getSelectedItem().toString().substring(0,timebox.getSelectedItem().toString().lastIndexOf("시"))+":00:00",
				datebox.getSelectedItem().toString().substring(0, 10),
				0,
				"",
				Integer.parseInt(table_number.getText().toString())
				);
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
				public void mouseClicked(MouseEvent e) {  //테이블 선택 후
					//panel.setVisible(true);
					timebox.removeAllItems();
					timebox.addItem("시간 선택");
					table_number.setText(Integer.toString(tmp.table_num));
					table_size.setText(Integer.toString(tmp.size));
					String date=datebox.getSelectedItem().toString().substring(0,10);
					ArrayList<String> qq=DAO.get_enable_time(cnt_shop.get_shop_name(),date,tmp.table_num);
					int[] is;
					if(qq!=null) {//
						int hour = calendar.get(calendar.HOUR);
						is=new int[qq.size()];
						System.out.println(hour);
						for(int i=0;i<is.length;i++) {
							is[i]=Integer.parseInt(qq.get(i).substring(0,2));
						}
						if(open<close) {
							for(int i=open;i<close;i++) {
								boolean is_in=false;
								for(int j=0;j<is.length;j++) {
									if(is[j]==i||i<hour) 
										is_in=true;
								}
								if(!is_in) {
									if(0<i && i<10) {
										timebox.addItem("0"+i+"시 00분");
									}else {
										timebox.addItem(i+"시 00분");
									}
								}
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
									timebox.addItem(i+"시 00분");
							}
							for(int i=0;i<close;i++){
								boolean is_in=false;
								for(int j=0;j<is.length;j++) {
									if(is[j]==i)
										is_in=true;
								}
								if(!is_in)
									timebox.addItem(i+"시 00분");
							}
						}
					}else {
						if(open<close) {
							for(int i=open;i<close;i++)
									timebox.addItem(i+"시 00분");		
						}
						else {
							for(int i=open;i<=23;i++)
								timebox.addItem(i+"시 00분");
							for(int i=0;i<close;i++)
								timebox.addItem(i+"시 00분");
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
		datebox.addItem("날짜 선택");
			for (int i = 0; i < 7; i++) {
				boolean is_holyday = false;
				int year = calendar.get(calendar.YEAR);
				int Month = calendar.get(calendar.MONTH) + 1;
				int Day = calendar.get(calendar.DAY_OF_MONTH);
				int week = calendar.get(calendar.DAY_OF_WEEK);
				String week_ = "";
				switch (week) {
				case 1:
					week_ = "일";
					break;
				case 2:
					week_ = "월";
					break;
				case 3:
					week_ = "화";
					break;
				case 4:
					week_ = "수";
					break;
				case 5:
					week_ = "목";
					break;
				case 6:
					week_ = "금";
					break;
				case 7:
					week_ = "토";
					break;
				}
				for (int j = 0; j < holyday.size(); j++) {
					if (week_.equals(holyday.get(j))) {
						is_holyday = true;
						break;
					}
				}
				if (!is_holyday)
					if (0 < Day && Day < 10) {
						datebox.addItem(year + "-" + Month + "-0" + Day + " (" + week_ + ")");
					} else {
						datebox.addItem(year + "-" + Month + "-" + Day + " (" + week_ + ")");
					}
				calendar.add(calendar.DAY_OF_MONTH, 1);
			}
			calendar.add(calendar.DAY_OF_MONTH, -7);
		
	}
}
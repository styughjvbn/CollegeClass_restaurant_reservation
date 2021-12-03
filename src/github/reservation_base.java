package github;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class reservation_base extends JPanel {
	private Image img;
	private Dimension d;
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
	public JButton back;
	private CardLayout card=new CardLayout(0, 0);
	public DTO_customer cnt_user;
	private DAO_reservation DAO=new DAO_reservation();
	private JTextField open_time;
	private JTextField holyday;
	private DTO_shop cnt_shop;
	private reservation_payment payment;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JPanel panel_3;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private reservation temp;
	JPanel panel_2;
	JLabel lblNewLabel;
	JComboBox<String> comboBox;
	
	/**
	 * Create the panel.
	 */
	void init() {
		temp.set_();
		textField.setText("위치 검색");
		textField.setForeground(new Color(120, 108, 100));
		textField_1.setText("키워드 검색");
		textField_1.setForeground(new Color(120, 108, 100));
		panel_2.setVisible(false);
		lblNewLabel.setVisible(false);
		comboBox.removeAllItems();
	}
	public reservation_base() {
		setLayout(card);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(226,221,215));
		add(panel, "base");
		panel.setLayout(null);
		
		reservation_detail detail=new reservation_detail();
		detail.checkbutton.setForeground(Color.WHITE);
		detail.detail_back.setText("\uC774\uC804 \uD654\uBA74");
		detail.detail_back.setForeground(new Color(120, 108, 100));
		detail.checkbutton.setSize(284, 49);
		detail.detail_back.setFont(new Font("SEBANG Gothic", Font.BOLD, 17));
		detail.checkbutton.setLocation(900, 552);
		detail.detail_back.setSize(284, 49);
		detail.detail_back.setLocation(900, 489);
		add(detail, "detail");
		
		//
		temp=new reservation();
		temp.setBounds(446, 50, 800, 600);
		temp.setVisible(false);
		
		panel_3 = new JPanel();
		panel_3.setBounds(433, 50, 83, 67);
		panel.add(panel_3);
		panel_3.setVisible(false);
		//
		
		btnNewButton_3 = new JButton(" \uC608\uC57D\uD655\uC778 ");
		btnNewButton_3.setFont(new Font("SEBANG Gothic", Font.BOLD, 14));
		btnNewButton_3.setBorder(new LineBorder(new Color(200, 184, 164), 2, true));
		btnNewButton_3.setBackground(new Color(200, 184, 164));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO.cnt_2_old(cnt_user);
				temp.setVisible(true);
				temp.nextcard(0);
				temp.cnt_user=cnt_user;
				temp.init2(cnt_user.get_ID());
				temp.init(cnt_user.get_ID());
				panel_3.setVisible(false);
			}
		});
		panel_3.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton(" PW \uBCC0\uACBD ");
		btnNewButton_4.setFont(new Font("SEBANG Gothic", Font.BOLD, 14));
		btnNewButton_4.setBorder(new LineBorder(new Color(200, 184, 164), 2, true));
		btnNewButton_4.setBackground(new Color(200, 184, 164));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp.nextcard(1);
				temp.cnt_user=cnt_user;
				temp.setVisible(true);
				
				panel_3.setVisible(false);
			}
		});
		panel_3.add(btnNewButton_4);
		panel.add(temp);
		
		
		
		
		lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon("image/panel_base.png"));
		lblNewLabel_12.setBounds(0, 0, 1280, 720);
		detail.add(lblNewLabel_12);
		
		payment=new reservation_payment();
		payment.btnNewButton.setBackground(new Color(120, 108, 100));
		payment.btnNewButton_3.setBackground(new Color(200, 184, 164) );
		payment.btnNewButton.setBorder(new LineBorder(new Color(120, 108, 100) , 2, true));
		payment.btnNewButton_3.setBorder(new LineBorder(new Color(200, 184, 164) , 2, true));
		payment.btnNewButton_3.setForeground(new Color(120, 108, 100));
		payment.btnNewButton.setForeground(Color.WHITE);
		payment.btnNewButton_3.setFont(new Font("SEBANG Gothic", Font.BOLD, 17));
		payment.btnNewButton.setFont(new Font("SEBANG Gothic", Font.BOLD, 17));
		payment.btnNewButton.setText("\uC608\uC57D\uD558\uAE30");
		payment.btnNewButton_3.setText("\uC774\uC804 \uD654\uBA74");
		payment.btnNewButton.setSize(284, 49);
		payment.btnNewButton.setLocation(900, 552);
		payment.btnNewButton_3.setSize(284, 49);
		payment.btnNewButton_3.setLocation(900, 489);
		add(payment,"payment");
		
		lblNewLabel = new JLabel();
		lblNewLabel.setVisible(false);
		lblNewLabel.setBorder(new LineBorder(new Color(200, 184, 164), 1, true));
		lblNewLabel.setBounds(446, 50, 800, 600);
		panel.add(lblNewLabel);

		back = new JButton("\uB85C\uADF8\uC544\uC6C3");//back버튼
		back.setBorder(null);
		back.setBackground(new Color(226,221,215));
		back.setIcon(new ImageIcon("image/back.png"));
		back.setBounds(32, 50, 151, 43);
		back.setFont(new Font("SEBANG Gothic", Font.BOLD, 17));
		back.setForeground(new Color(120, 108, 100));
		panel.add(back);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(200, 184, 164), 1, true));
		panel_1.setBackground(new Color(226,221,215));
		panel_1.setBounds(32, 96, 407, 556);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBounds(12, 124, 389, 422);
		panel_1.add(panel_2);
		panel_2.setBackground(new Color(226,221,215));
		panel_2.setLayout(null);
		
		shop_name = new JTextField();
		shop_name.setBounds(24, 25, 353, 26);
		panel_2.add(shop_name);
		shop_name.setForeground(new Color(120, 108, 100));
		shop_name.setBackground(new Color(226,221,215));
		shop_name.setBorder(null);
		shop_name.setFont(new Font("SEBANG Gothic", Font.BOLD, 20));
		shop_name.setEditable(false);
		shop_name.setColumns(10);
		
		shop_tel = new JTextField();
		shop_tel.setBounds(141, 173, 236, 21);
		panel_2.add(shop_tel);
		shop_tel.setBorder(null);
		shop_tel.setForeground(new Color(236, 99, 94));
		shop_tel.setBackground(new Color(226,221,215));
		shop_tel.setFont(new Font("SEBANG Gothic", Font.PLAIN, 15));
		shop_tel.setEditable(false);
		shop_tel.setColumns(10);
		
		shop_distance = new JTextField();
		shop_distance.setBounds(63, 102, 314, 21);
		panel_2.add(shop_distance);
		shop_distance.setBorder(null);
		shop_distance.setBackground(new Color(226,221,215));
		shop_distance.setFont(new Font("SEBANG Gothic", Font.PLAIN, 15));
		shop_distance.setEditable(false);
		shop_distance.setColumns(10);
		
		shop_adress = new JTextField();
		shop_adress.setBounds(24, 61, 353, 21);
		panel_2.add(shop_adress);
		shop_adress.setBorder(null);
		shop_adress.setForeground(Color.GRAY);
		shop_adress.setBackground(new Color(226,221,215));
		shop_adress.setFont(new Font("SEBANG Gothic", Font.PLAIN, 15));
		shop_adress.setEditable(false);
		shop_adress.setColumns(10);
		
		open_time = new JTextField();
		open_time.setBounds(137, 214, 240, 21);
		panel_2.add(open_time);
		open_time.setBorder(null);
		open_time.setBackground(new Color(228,221,215));
		open_time.setFont(new Font("SEBANG Gothic", Font.PLAIN, 15));
		open_time.setColumns(10);
		
		holyday = new JTextField();
		holyday.setBounds(137, 245, 240, 21);
		panel_2.add(holyday);
		holyday.setFont(new Font("SEBANG Gothic", Font.PLAIN, 15));
		holyday.setBorder(null);
		holyday.setBackground(new Color(228,221,215));
		holyday.setColumns(10);
		
		shop_category = new JTextField();
		shop_category.setBounds(63, 144, 314, 21);
		panel_2.add(shop_category);
		shop_category.setBorder(null);
		shop_category.setBackground(new Color(226,221,215));
		shop_category.setFont(new Font("SEBANG Gothic", Font.PLAIN, 15));
		shop_category.setEditable(false);
		shop_category.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\uC608\uC57D\uD558\uAE30");
		btnNewButton_1.setBounds(36, 320, 321, 46);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.setForeground(new Color(120, 108, 100));
		btnNewButton_1.setBackground(new Color(200, 184, 164));
		btnNewButton_1.setBorder(new LineBorder(new Color(200, 184, 164), 2, true));
		btnNewButton_1.setFont(new Font("SEBANG Gothic", Font.BOLD, 20));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(24, 94, 40, 26);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("image/call_icon.png"));
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(23, 144, 30, 40);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("image/location_icon.png"));
		
		lblNewLabel_4 = new JLabel("\uAC80\uC0C9\uC9C0\uC5D0\uC11C");
		lblNewLabel_4.setBounds(63, 173, 81, 21);
		panel_2.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("SEBANG Gothic", Font.PLAIN, 15));
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(24, 216, 32, 30);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("image/time_icon.png"));
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(12, 81, 361, 15);
		panel_2.add(lblNewLabel_6);
		lblNewLabel_6.setIcon(new ImageIcon("image/hsection_icon.png"));
		
		lblNewLabel_10 = new JLabel("\uC815\uAE30 \uD734\uBB34");
		lblNewLabel_10.setBounds(63, 245, 69, 21);
		panel_2.add(lblNewLabel_10);
		lblNewLabel_10.setForeground(new Color(236, 99, 94));
		lblNewLabel_10.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		
		lblNewLabel_9 = new JLabel("\uC601\uC5C5 \uC2DC\uAC04");
		lblNewLabel_9.setBounds(63, 214, 69, 21);
		panel_2.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(12, 194, 361, 15);
		panel_2.add(lblNewLabel_8);
		lblNewLabel_8.setIcon(new ImageIcon("image/hsection_icon.png"));
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(12, 118, 361, 15);
		panel_2.add(lblNewLabel_7);
		lblNewLabel_7.setIcon(new ImageIcon("image/hsection_icon.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt_shop!=null) {
					card.show(panel.getParent(),"detail");
					detail.cnt_shop=cnt_shop;
					detail.init();
					temp.set_();
				}
				else {
					System.out.println("아직 입점이 되지 않은 점포입니다.");
				}
				
			}
		});
		panel_2.setVisible(false);
		
		comboBox = new JComboBox();
		comboBox.setBorder(new LineBorder(new Color(200, 184, 164), 1, true));
		comboBox.setBackground(new Color(226,221,215));
		comboBox.setFont(new Font("SEBANG Gothic", Font.PLAIN, 15));
		comboBox.setBounds(29, 75, 358, 39);
		panel_1.add(comboBox);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon("image/search_icon1.png"));
		btnNewButton.setBounds(342, 26, 42, 40);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				machine=new search();
				machine.update_XY(textField.getText());
				machine.search_result(textField_1.getText());
				list1 = machine.get_result();
				if (list1!=null||list1.size() > 0) {
					list1 = machine.get_result();
					comboBox.removeAllItems();
					for (int i = 0; i < (int) list1.size(); i++) {
						comboBox.addItem(list1.get(i)[0]);
					}
					temp.setVisible(false);
					panel_2.setVisible(true);
					lblNewLabel.setVisible(true);
				}
			}
		});
		textField = new JTextField();
		textField.setForeground(new Color(120, 108, 100));
		textField.setBackground(new Color(226,221,215));
		textField.setBounds(36, 26, 140, 40);
		panel_1.add(textField);
		textField.setFont(new Font("SEBANG Gothic", Font.BOLD, 17));
		textField.setText("\uC704\uCE58 \uAC80\uC0C9");
		textField.setBorder(new LineBorder(new Color(120, 108, 100), 0, true));
		textField.setColumns(10);
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField.getText().equals("위치 검색")) {
					textField.setText("");
					textField.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textField.getText().equals("")) {
					textField.setText("위치 검색");
					textField.setForeground(new Color(120, 108, 100));
				}
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(120, 108, 100));
		textField_1.setBackground(new Color(226,221,215));
		textField_1.setFont(new Font("SEBANG Gothic", Font.BOLD, 17));
		textField_1.setText("\uD0A4\uC6CC\uB4DC \uAC80\uC0C9");
		textField_1.setBounds(197, 26, 140, 40);
		panel_1.add(textField_1);
		textField_1.setBorder(new LineBorder(new Color(120, 108, 100), 0, true));
		textField_1.setColumns(10);
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField_1.getText().equals("키워드 검색")) {
					textField_1.setText("");
					textField_1.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textField_1.getText().equals("")) {
					textField_1.setText("키워드 검색");
					textField_1.setForeground(new Color(120, 108, 100));
				}
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("image/section_icon.png"));
		lblNewLabel_5.setBounds(175, 26, 5, 40);
		panel_1.add(lblNewLabel_5);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setIcon(new ImageIcon("image/mymenu.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(389, 50, 40, 40);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon("image/panel_base.png"));
		lblNewLabel_11.setBounds(0, 0, 1280, 720);
		panel.add(lblNewLabel_11);
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int index = cb.getSelectedIndex();
				if (index > -1) {
					panel_2.setVisible(true);
					btnNewButton_1.setText("예약하기");
					shop_name.setText(list1.get(index)[0]);
					cnt_shop=DAO.get_shop_info(shop_name.getText());
					shop_tel.setText(list1.get(index)[1]+"m");
					shop_distance.setText(list1.get(index)[2]);
					shop_adress.setText(list1.get(index)[3]);
					shop_category.setText(list1.get(index)[4]);
					if(cnt_shop!=null) {//입점된 점포라면 영업시간과 공휴일 출력
						open_time.setText(cnt_shop.get_shop_open()+":00 ~ "+cnt_shop.get_shop_close()+":00");
						int aa=cnt_shop.get_shop_holyday();
						String temp="";
						ArrayList<String> bb=new ArrayList();
						if(aa==0) {
							holyday.setText("휴무일 없음");
							detail.holyday=bb;
						}
						else {
						if((aa&64)==64)
							bb.add("월");
						if((aa&32)==32)
							bb.add("화");
						if((aa&16)==16)
							bb.add("수");
						if((aa&8)==8)
							bb.add("목");
						if((aa&4)==4)
							bb.add("금");
						if((aa&2)==2)
							bb.add("토");
						if((aa&1)==1)
							bb.add("일");
						for(int i=0;i<bb.size()-1;i++) {
							temp+=bb.get(i)+", ";
						}
						temp+=bb.get(bb.size()-1);
						holyday.setText("매주 "+temp+"요일");
						detail.holyday=bb;
						}
					}
					else {
						open_time.setText("");
						holyday.setText("");
						//btnNewButton_1.setBackground();
						btnNewButton_1.setText("입점 예정");
					}
						
					create_image.create_map_image(machine.get_center_x(), machine.get_center_y(), list1.get(index)[5],list1.get(index)[6], shop, list1.get(index)[0]);
					lblNewLabel.setIcon(new ImageIcon("image/shop/" + list1.get(index)[0] + ".png"));
					shop = list1.get(index)[0];
					temp.setVisible(false);
				}
				
			}
		});
		
		detail.detail_back.addActionListener(new ActionListener() { //상세페이지의 back버튼 클릭시 
			public void actionPerformed(ActionEvent e) {
				card.show(detail.getParent(),"base");
			}
		});
		detail.checkbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cnt_shop!=null) {
					card.show(detail.getParent(), "payment");
					payment.refresh(cnt_shop.get_shop_name());
					DTO_reservation_current temp=detail.get_data();
					temp.set_rc_id(cnt_user.get_ID());
					payment.pay=temp;
				}
			}
			
		});
		payment.btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(detail.getParent(), "detail");
			}
		});
		
		lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon("image/panel_base.png"));
		lblNewLabel_13.setBounds(0, 0, 1280, 720);
		payment.add(lblNewLabel_13);

	}
}

package github;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
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
	/**
	 * Create the panel.
	 */
	public reservation_base() {
		setLayout(card);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(226,221,215));
		add(panel, "base");
		panel.setLayout(null);
		
		reservation_detail detail=new reservation_detail();
		add(detail, "detail");
		
		payment=new reservation_payment();
		add(payment,"payment");
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBorder(new LineBorder(new Color(200, 184, 164), 1, true));
		lblNewLabel.setBounds(446, 40, 782, 606);
		panel.add(lblNewLabel);

		back = new JButton("");//back버튼
		back.setBorder(null);
		back.setBackground(new Color(226,221,215));
		back.setIcon(new ImageIcon("image/back.png"));
		back.setBounds(33, 40, 45, 43);
		panel.add(back);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(200, 184, 164), 1, true));
		panel_1.setBackground(new Color(226,221,215));
		panel_1.setBounds(33, 90, 413, 556);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(226,221,215));
		panel_2.setBounds(12, 124, 389, 422);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		shop_name = new JTextField();
		shop_name.setForeground(new Color(120, 108, 100));
		shop_name.setBackground(new Color(226,221,215));
		shop_name.setBorder(null);
		shop_name.setFont(new Font("굴림", Font.BOLD, 20));
		shop_name.setBounds(29, 149, 358, 26);
		panel_1.add(shop_name);
		shop_name.setEditable(false);
		shop_name.setColumns(10);
		
		shop_tel = new JTextField();
		shop_tel.setBorder(null);
		shop_tel.setBackground(new Color(226,221,215));
		shop_tel.setFont(new Font("굴림", Font.PLAIN, 15));
		shop_tel.setBounds(68, 226, 321, 21);
		panel_1.add(shop_tel);
		shop_tel.setEditable(false);
		shop_tel.setColumns(10);
		
		shop_distance = new JTextField();
		shop_distance.setForeground(new Color(236, 99, 94));
		shop_distance.setBorder(null);
		shop_distance.setBackground(new Color(226,221,215));
		shop_distance.setFont(new Font("굴림", Font.PLAIN, 15));
		shop_distance.setBounds(151, 297, 236, 21);
		panel_1.add(shop_distance);
		shop_distance.setEditable(false);
		shop_distance.setColumns(10);
		
		shop_adress = new JTextField();
		shop_adress.setBorder(null);
		shop_adress.setBackground(new Color(226,221,215));
		shop_adress.setFont(new Font("굴림", Font.PLAIN, 15));
		shop_adress.setBounds(68, 268, 319, 21);
		panel_1.add(shop_adress);
		shop_adress.setEditable(false);
		shop_adress.setColumns(10);
		
		shop_category = new JTextField();
		shop_category.setBorder(null);
		shop_category.setBackground(new Color(226,221,215));
		shop_category.setForeground(Color.GRAY);
		shop_category.setFont(new Font("굴림", Font.PLAIN, 15));
		shop_category.setBounds(29, 185, 358, 21);
		panel_1.add(shop_category);
		shop_category.setEditable(false);
		shop_category.setColumns(10);
		
		open_time = new JTextField();
		open_time.setBorder(null);
		open_time.setBackground(new Color(228,221,215));
		open_time.setFont(new Font("굴림", Font.PLAIN, 15));
		open_time.setBounds(142, 337, 249, 21);
		panel_1.add(open_time);
		open_time.setColumns(10);
		
		holyday = new JTextField();
		holyday.setFont(new Font("굴림", Font.PLAIN, 15));
		holyday.setBorder(null);
		holyday.setBackground(new Color(228,221,215));
		holyday.setBounds(142, 365, 249, 21);
		panel_1.add(holyday);
		holyday.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\uC608\uC57D\uD558\uAE30");
		btnNewButton_1.setForeground(new Color(120, 108, 100));
		btnNewButton_1.setBackground(new Color(200, 184, 164));
		btnNewButton_1.setBorder(new LineBorder(new Color(200, 184, 164), 2, true));
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton_1.setBounds(45, 458, 321, 46);
		panel_1.add(btnNewButton_1);
		textField = new JTextField();
		textField.setForeground(new Color(120, 108, 100));
		textField.setBackground(new Color(226,221,215));
		textField.setBounds(36, 26, 140, 40);
		panel_1.add(textField);
		textField.setFont(new Font("굴림", Font.BOLD, 17));
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
		textField_1.setFont(new Font("굴림", Font.BOLD, 17));
		textField_1.setText("\uD0A4\uC6CC\uB4DC \uAC80\uC0C9");
		textField_1.setBounds(192, 26, 155, 40);
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
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon("image/search_icon1.png"));
		btnNewButton.setBounds(347, 26, 42, 40);
		panel_1.add(btnNewButton);
		JComboBox<String> comboBox = new JComboBox();
		comboBox.setBorder(new LineBorder(new Color(200, 184, 164), 1, true));
		comboBox.setBackground(new Color(226,221,215));
		comboBox.setFont(new Font("굴림", Font.PLAIN, 15));
		comboBox.setBounds(29, 75, 358, 39);
		panel_1.add(comboBox);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("image/call_icon.png"));
		lblNewLabel_1.setBounds(29, 221, 40, 26);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("image/location_icon.png"));
		lblNewLabel_2.setBounds(25, 268, 30, 40);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("image/time_icon.png"));
		lblNewLabel_3.setBounds(29, 340, 32, 30);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(68, 297, 81, 21);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("image/section_icon.png"));
		lblNewLabel_5.setBounds(175, 26, 5, 40);
		panel_1.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("image/hsection_icon.png"));
		lblNewLabel_6.setBounds(25, 208, 361, 15);
		panel_1.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("image/hsection_icon.png"));
		lblNewLabel_7.setBounds(25, 248, 361, 15);
		panel_1.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("image/hsection_icon.png"));
		lblNewLabel_8.setBounds(25, 315, 361, 15);
		panel_1.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("\uC601\uC5C5 \uC2DC\uAC04");
		lblNewLabel_9.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_9.setBounds(68, 337, 69, 21);
		panel_1.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("\uC815\uAE30 \uD734\uBB34");
		lblNewLabel_10.setForeground(new Color(236, 99, 94));
		lblNewLabel_10.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_10.setBounds(68, 365, 69, 21);
		panel_1.add(lblNewLabel_10);
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int index = cb.getSelectedIndex();
				if (index > -1) {
					panel_2.setVisible(false);
					shop_name.setText(list1.get(index)[0]);
					cnt_shop=DAO.get_shop_info(shop_name.getText());
					shop_tel.setText(list1.get(index)[1]);
					shop_distance.setText(list1.get(index)[2]+"m");
					shop_adress.setText(list1.get(index)[3]);
					shop_category.setText(list1.get(index)[4]);
					if(cnt_shop!=null) {//입점된 점포라면 영업시간과 공휴일 출력
						open_time.setText(cnt_shop.get_shop_open()+":00 ~ "+cnt_shop.get_shop_close()+":00");
						int aa=cnt_shop.get_shop_holyday();
						String temp="";
						ArrayList<String> bb=new ArrayList();
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
						holyday.setText(temp);
						detail.holyday=bb;
					}
					else {
						open_time.setText("");
						holyday.setText("");
					}
						
					create_image.create_map_image(machine.get_center_x(), machine.get_center_y(), list1.get(index)[5],list1.get(index)[6], shop, list1.get(index)[0]);
					lblNewLabel.setIcon(new ImageIcon("image/shop/" + list1.get(index)[0] + ".png"));
					shop = list1.get(index)[0];
					
				}
				
			}
		});
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
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cnt_shop!=null) {
					card.show(panel.getParent(),"detail");
					detail.cnt_shop=cnt_shop;
					detail.init();
				}
				else {
					System.out.println("아직 입점이 되지 않은 점포입니다.");
				}
				
			}
		});
		
		detail.detail_back.addActionListener(new ActionListener() {//상세페이지의 back버튼 클릭시 
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

		img = new ImageIcon("image/signup.jpg").getImage();

		d = getSize();
	}

	public void paintComponent(Graphics g) {
	      g.drawImage(img, 0, 0,d.width,d.height, null);
	  }
}

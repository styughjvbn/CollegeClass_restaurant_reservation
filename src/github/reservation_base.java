package github;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class reservation_base extends JPanel {
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
	/**
	 * Create the panel.
	 */
	public reservation_base() {
		setLayout(card);
		
		
		JPanel panel = new JPanel();
		add(panel, "base");
		panel.setLayout(null);
		
		reservation_detail detail=new reservation_detail();
		add(detail, "detail");
		
		payment=new reservation_payment();
		add(payment,"payment");
		textField = new JTextField();
		textField.setBorder(new TitledBorder(null, "rotation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField.setBounds(46, 71, 146, 51);
		panel.add(textField);
		textField.setColumns(10);
		JComboBox<String> comboBox = new JComboBox();
		comboBox.setBounds(742, 56, 313, 51);
		panel.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new TitledBorder(null, "keyword", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField_1.setBounds(228, 71, 146, 51);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
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
		btnNewButton.setBounds(431, 51, 197, 51);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(28, 151, 600, 400);
		panel.add(lblNewLabel);
		
		shop_name = new JTextField();
		shop_name.setEditable(false);
		shop_name.setBounds(742, 151, 329, 21);
		panel.add(shop_name);
		shop_name.setColumns(10);
		
		shop_tel = new JTextField();
		shop_tel.setEditable(false);
		shop_tel.setBounds(742, 197, 329, 21);
		panel.add(shop_tel);
		shop_tel.setColumns(10);
		
		shop_distance = new JTextField();
		shop_distance.setEditable(false);
		shop_distance.setBounds(742, 240, 329, 21);
		panel.add(shop_distance);
		shop_distance.setColumns(10);
		
		shop_adress = new JTextField();
		shop_adress.setEditable(false);
		shop_adress.setBounds(742, 296, 329, 21);
		panel.add(shop_adress);
		shop_adress.setColumns(10);
		
		shop_category = new JTextField();
		shop_category.setEditable(false);
		shop_category.setBounds(742, 342, 329, 21);
		panel.add(shop_category);
		shop_category.setColumns(10);
		
		open_time = new JTextField();
		open_time.setBounds(742, 383, 329, 21);
		panel.add(open_time);
		open_time.setColumns(10);
		
		holyday = new JTextField();
		holyday.setBounds(742, 414, 329, 21);
		panel.add(holyday);
		holyday.setColumns(10);
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int index = cb.getSelectedIndex();
				if (index > -1) {
					shop_name.setText(list1.get(index)[0]);
					cnt_shop=DAO.get_shop_info(shop_name.getText());
					shop_tel.setText(list1.get(index)[1]);
					shop_distance.setText(list1.get(index)[2]);
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

		back = new JButton("");//back버튼
		back.setBorder(null);
		back.setBackground(new Color(226,221,215));
		back.setIcon(new ImageIcon("image/back.png"));
		back.setBounds(12, 10, 61, 50);
		panel.add(back);
		
		JButton btnNewButton_1 = new JButton("\uC608\uC57D\uD558\uAE30");
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
		btnNewButton_1.setBounds(742, 464, 329, 87);
		panel.add(btnNewButton_1);
		
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
	}
}

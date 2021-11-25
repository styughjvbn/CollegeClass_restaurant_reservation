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
		lblNewLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNewLabel.setBounds(446, 40, 782, 606);
		panel.add(lblNewLabel);

		back = new JButton("");//back��ư
		back.setBorder(null);
		back.setBackground(new Color(226,221,215));
		back.setIcon(new ImageIcon("image/back.png"));
		back.setBounds(33, 40, 53, 43);
		panel.add(back);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(200, 184, 164), 1, true));
		panel_1.setBackground(new Color(226,221,215));
		panel_1.setBounds(33, 90, 413, 556);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		shop_name = new JTextField();
		shop_name.setForeground(new Color(120, 108, 100));
		shop_name.setBackground(new Color(226,221,215));
		shop_name.setBorder(null);
		shop_name.setFont(new Font("����", Font.BOLD, 17));
		shop_name.setText("\uC0C1\uB2F9\uD68C\uAD00");
		shop_name.setBounds(29, 149, 360, 26);
		panel_1.add(shop_name);
		shop_name.setEditable(false);
		shop_name.setColumns(10);
		
		shop_tel = new JTextField();
		shop_tel.setBorder(null);
		shop_tel.setBackground(new Color(226,221,215));
		shop_tel.setFont(new Font("����", Font.PLAIN, 15));
		shop_tel.setText("043-255-1967");
		shop_tel.setBounds(29, 228, 360, 21);
		panel_1.add(shop_tel);
		shop_tel.setEditable(false);
		shop_tel.setColumns(10);
		
		shop_distance = new JTextField();
		shop_distance.setBorder(null);
		shop_distance.setBackground(new Color(226,221,215));
		shop_distance.setFont(new Font("����", Font.PLAIN, 15));
		shop_distance.setText("417");
		shop_distance.setBounds(29, 290, 360, 21);
		panel_1.add(shop_distance);
		shop_distance.setEditable(false);
		shop_distance.setColumns(10);
		
		shop_adress = new JTextField();
		shop_adress.setBorder(null);
		shop_adress.setBackground(new Color(226,221,215));
		shop_adress.setFont(new Font("����", Font.PLAIN, 15));
		shop_adress.setText("\uCDA9\uBD81 \uCCAD\uC8FC\uC2DC \uC0C1\uB2F9\uAD6C \uBD81\uBB38\uB85C2\uAC00 27-5");
		shop_adress.setBounds(29, 259, 360, 21);
		panel_1.add(shop_adress);
		shop_adress.setEditable(false);
		shop_adress.setColumns(10);
		
		shop_category = new JTextField();
		shop_category.setBorder(null);
		shop_category.setBackground(new Color(226,221,215));
		shop_category.setForeground(Color.GRAY);
		shop_category.setFont(new Font("����", Font.PLAIN, 15));
		shop_category.setText("\uC74C\uC2DD\uC810>\uD55C\uC2DD>\uC721\uB958, \uACE0\uAE30>\uC0BC\uACB9\uC0B4");
		shop_category.setBounds(29, 185, 360, 21);
		panel_1.add(shop_category);
		shop_category.setEditable(false);
		shop_category.setColumns(10);
		
		open_time = new JTextField();
		open_time.setBorder(null);
		open_time.setBackground(new Color(226,221,215));
		open_time.setFont(new Font("����", Font.PLAIN, 15));
		open_time.setText("8:00 ~22:00");
		open_time.setBounds(29, 386, 329, 21);
		panel_1.add(open_time);
		open_time.setColumns(10);
		
		holyday = new JTextField();
		holyday.setBorder(null);
		holyday.setBackground(new Color(226,221,215));
		holyday.setText("\uB9E4\uC8FC \uC218\uC694\uC77C");
		holyday.setBounds(29, 417, 329, 21);
		panel_1.add(holyday);
		holyday.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\uC608\uC57D\uD558\uAE30");
		btnNewButton_1.setBounds(45, 464, 321, 40);
		panel_1.add(btnNewButton_1);
		textField = new JTextField();
		textField.setForeground(new Color(120, 108, 100));
		textField.setBackground(new Color(200, 184, 164));
		textField.setBounds(29, 26, 154, 39);
		panel_1.add(textField);
		textField.setFont(new Font("����", Font.BOLD, 17));
		textField.setText("\uC704\uCE58 \uAC80\uC0C9");
		textField.setBorder(new LineBorder(new Color(120, 108, 100), 0, true));
		textField.setColumns(10);
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField.getText().equals("��ġ �˻�")) {
					textField.setText("");
					textField.setForeground(new Color(120, 108, 100));
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textField.getText().equals("")) {
					textField.setText("��ġ �˻�");
					textField.setForeground(new Color(120, 108, 100));
				}
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(120, 108, 100));
		textField_1.setBackground(new Color(200, 184, 164));
		textField_1.setFont(new Font("����", Font.BOLD, 17));
		textField_1.setText("\uD0A4\uC6CC\uB4DC \uAC80\uC0C9");
		textField_1.setBounds(194, 26, 150, 39);
		panel_1.add(textField_1);
		textField_1.setBorder(new LineBorder(new Color(120, 108, 100), 0, true));
		textField_1.setColumns(10);
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField_1.getText().equals("Ű���� �˻�")) {
					textField_1.setText("");
					textField_1.setForeground(new Color(120, 108, 100));
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textField_1.getText().equals("")) {
					textField_1.setText("Ű���� �˻�");
					textField_1.setForeground(new Color(120, 108, 100));
				}
			}
		});
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\kmj\\Documents\\GitHub\\restaurant_reservation\\image\\searchiconn.png"));
		btnNewButton.setBounds(344, 22, 43, 43);
		panel_1.add(btnNewButton);
		JComboBox<String> comboBox = new JComboBox();
		comboBox.setBorder(new LineBorder(new Color(200, 184, 164), 1, true));
		comboBox.setBackground(new Color(226,221,215));
		comboBox.setFont(new Font("����", Font.PLAIN, 15));
		comboBox.setBounds(29, 75, 358, 39);
		panel_1.add(comboBox);
		
		
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
					if(cnt_shop!=null) {//������ ������� �����ð��� ������ ���
						open_time.setText(cnt_shop.get_shop_open()+":00 ~ "+cnt_shop.get_shop_close()+":00");
						int aa=cnt_shop.get_shop_holyday();
						String temp="";
						ArrayList<String> bb=new ArrayList();
						if((aa&64)==64)
							bb.add("��");
						if((aa&32)==32)
							bb.add("ȭ");
						if((aa&16)==16)
							bb.add("��");
						if((aa&8)==8)
							bb.add("��");
						if((aa&4)==4)
							bb.add("��");
						if((aa&2)==2)
							bb.add("��");
						if((aa&1)==1)
							bb.add("��");
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
				System.out.println("list1�� ������ : "+list1.size());
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
					System.out.println("���� ������ ���� ���� �����Դϴ�.");
				}
				
			}
		});
		
		detail.detail_back.addActionListener(new ActionListener() {//���������� back��ư Ŭ���� 
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

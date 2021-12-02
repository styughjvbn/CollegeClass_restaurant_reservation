package github;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class manage_menu extends JPanel {
	/**
	 * Create the panel.
	 */
	private xy temp;// 카테고리 버튼
	private food temp2;// 상세메뉴 버튼
	int num = -1;// 패널의 개수
	private JOptionPane aa = new JOptionPane();//
	private ArrayList<xy> shop_menu = new ArrayList(); // 카테고리 버튼 배열
	private JTextField btnname; // 텍스트 필드 카테고리명
	public CardLayout card = new CardLayout();
	public JButton btnNewButton_1;
	public JPanel panel_1;
	public JPanel panel;
	private JButton btnNewButton_2;
	private DAO_manager DAO=new DAO_manager();
	public String cnt_user;

	public manage_menu() {
		
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setLayout(null);
		// card 패널 바깥에 존재함
		panel_1 = new JPanel();
		panel_1.setBounds(45, 125, 1000, 518);
		add(panel_1);
		panel_1.setLayout(card); // 바깥 카드 패널

		// 카테고리 만드는 패널 card아님
		panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.add(panel, "category_main");
		panel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));//왼쪽 정렬 옆 간격 10px 위아래 간격 10px

		// 카테고리 만드는 버튼임.
		JButton btnNewButton = new JButton("make category");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				temp = new xy(btnname.getText()); // xy class를 만든다. 버튼의 위치를 지정하는 클래스임.
				temp.setText(btnname.getText()); // textfield에 존재하는 글을 받아와서 버튼에 설정
				temp.category_name = btnname.getText();
				num++;
				shop_menu.add(temp); // ArrayList에 추가
				shop_menu.get(num).detail = new food(num); // detail에 패널을 추가 detail = xy 클래스에 존재하는 패널
				shop_menu.get(num).number = num;
				shop_menu.get(num).addMouseListener(new MouseAdapter() {
					int x = shop_menu.get(num).number;
					public void mouseClicked(MouseEvent me) {
							card.show(panel_1, "category" + x);
					}
				});
				panel.add(shop_menu.get(num));
				panel_1.add(shop_menu.get(num).detail, "category" + num);

				panel.validate();
				panel_1.repaint();
			}
		});
		btnNewButton.setBounds(1075, 186, 116, 23);
		add(btnNewButton);

		btnname = new JTextField();
		btnname.setBounds(1075, 143, 116, 21);
		add(btnname);

		btnNewButton_1 = new JButton("");//사장 메뉴 창으로 가는 버튼
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\kmj\\Documents\\GitHub\\restaurant_reservation\\image\\back2.png"));
		btnNewButton_1.setBounds(45, 65, 110, 45);
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("save");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO.delete_category(cnt_user);
				for(int i=0; i<shop_menu.size();i++) {		
					DAO.new_category(new DTO_menu_category(shop_menu.get(i).category_name,cnt_user));					
					for(int j=0;j<shop_menu.get(i).detail.Incategory.size();j++) {
						DAO.new_menu((new DTO_menu_detail(shop_menu.get(i).detail.Incategory.get(j).name+"_"+cnt_user,shop_menu.get(i).category_name,shop_menu.get(i).detail.Incategory.get(j).price)));
					}	
				}
			}
		});
		btnNewButton_2.setBounds(1094, 609, 97, 23);
		add(btnNewButton_2);
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\kmj\\Documents\\GitHub\\restaurant_reservation\\image\\managebase.png"));
		lblNewLabel_7.setBounds(0, 0, 1280, 720);
		add(lblNewLabel_7);
	}
	void init() {
		ArrayList<String> category=DAO.get_category(cnt_user);
		shop_menu.clear();
		panel.removeAll();
		for(int k=1;k<panel_1.getComponentCount();k++) {
			panel_1.remove(k);
		}
		num=-1;
		for(int i=0;i<category.size();i++) {
			xy init_category = new xy(category.get(i)); // xy class를 만든다. 버튼의 위치를 지정하는 클래스임.
			num++;
			shop_menu.add(init_category); // ArrayList에 추가
			shop_menu.get(num).number = num;
			shop_menu.get(num).detail = new food(num); // detail에 패널을 추가 detail = xy 클래스에 존재하는 패널
			shop_menu.get(num).detail.init(DAO.get_detail(category.get(i)));
			shop_menu.get(num).addMouseListener(new MouseAdapter() {
				int x = shop_menu.get(num).number;
				public void mouseClicked(MouseEvent me) {
						card.show(panel_1, "category" + x);
				}
			});
			panel.add(shop_menu.get(num));
			panel_1.add(shop_menu.get(num).detail, "category" + num);

			panel.validate();
			panel_1.repaint();
		}
	}

	class xy extends JButton {//카테고리 버튼
		food detail;
		int number;//키값
		public String category_name;//카테고리 이름

		public xy(String category_name) {
			setBorder(new LineBorder(new Color(0, 0, 0)));
			this.category_name = category_name;
			setText(this.category_name);
			setPreferredSize(new Dimension(100, 100));
		}
		
	}

	class food extends JPanel {//상세메뉴 패널
		public ArrayList<menu> Incategory = new ArrayList();
		private JOptionPane aa = new JOptionPane();
		private JTextField menucost;
		private JTextField menuname;
		int n = -1;
		private menu tmp;
		int key;//키값
		private menu_info menu_info;
		private JTextField menu_name;
		private JTextField menu_cost;
		private JPanel panel_2;

		public food(int num_) {
			key=num_;
			setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			setLayout(null);
			
			JLabel lblNewLabel0 = new JLabel("메뉴 추가");
			lblNewLabel0.setBounds(650, 30, 50, 15);
			add(lblNewLabel0);
			
			JButton btnNewButton = new JButton("확인");

			btnNewButton.setBounds(650, 113, 91, 23);
			add(btnNewButton);

			menucost = new JTextField();
			menucost.setBounds(700, 82, 96, 21);
			add(menucost);
			menucost.setColumns(10);

			menuname = new JTextField();
			menuname.setBounds(700, 51, 96, 21);
			add(menuname);
			menuname.setColumns(10);

			JLabel lblNewLabel = new JLabel("Name");
			lblNewLabel.setBounds(650, 54, 50, 15);
			add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("Cost");
			lblNewLabel_1.setBounds(650, 85, 50, 15);
			add(lblNewLabel_1);

			panel_2 = new JPanel();//상세메뉴가 생성될 패널
			panel_2.setBackground(Color.WHITE);
			panel_2.setBounds(5, 5, 615, 528);
			add(panel_2);
			panel_2.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));

			JButton Backbtn = new JButton("Back");
			Backbtn.setBounds(700, 494, 91, 23);
			Backbtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			add(Backbtn);

			JButton deletbtn = new JButton("delet");
			deletbtn.setBounds(654, 530, 91, 23);
			deletbtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);					
					panel.remove(key);
					panel_1.remove(key+1);
					panel_1.repaint();
					panel.validate();
					shop_menu.remove(key);
					System.out.println(shop_menu.size());
					for(int i=key;i<shop_menu.size();i++){
						shop_menu.get(i).number-=1;
						shop_menu.get(i).detail.key-=1;
					}
					num--;
				}
			});
			add(deletbtn);
			
			menu_info = new menu_info();
			menu_info.setBounds(609, 277, 162, 166);
			menu_info.setVisible(false);
			add(menu_info);
			menu_info.setLayout(null);
			
			JLabel menu_lab = new JLabel("\uBA54\uB274\uC815\uBCF4");
			menu_lab.setBounds(12, 10, 118, 15);
			menu_info.add(menu_lab);
			
			menu_name = new JTextField();
			menu_name.setBounds(22, 35, 116, 21);
			menu_info.add(menu_name);
			menu_name.setColumns(10);
			
			menu_cost = new JTextField();
			menu_cost.setBounds(22, 91, 116, 21);
			menu_info.add(menu_cost);
			menu_cost.setColumns(10);
			
			JButton modify = new JButton("\uC218\uC815");
			modify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Incategory.get(menu_info.ide).modify_info(Integer.parseInt(menu_cost.getText()), menu_name.getText());
					menu_info.setVisible(false);
				}
			});
			modify.setBounds(12, 133, 56, 23);
			menu_info.add(modify);
			
			JButton del = new JButton("\uC0AD\uC81C");
			del.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					menu_info.setVisible(false);
					int oo=menu_info.ide;
					panel_2.remove(oo);
					Incategory.remove(oo);
					for(int i=oo;i<Incategory.size();i++){
						Incategory.get(i).identy-=1;
					}
					n--;
				}
			});
			del.setBounds(91, 133, 64, 23);
			menu_info.add(del);
			
			btnNewButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					n++;
					tmp = new menu(Integer.parseInt(menucost.getText().toString()), menuname.getText()); // xy
					tmp.identy=n;
					Incategory.add(tmp);
					Incategory.get(n).addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent me) {
							menu ttmmp=(menu)me.getComponent();
							menu_info.setVisible(true);
							menu_info.set_label(ttmmp.identy);
							menu_name.setText(Incategory.get(menu_info.ide).name);
							menu_cost.setText(""+Incategory.get(menu_info.ide).price);						
						}
					});
					for(int i=0;i<Incategory.size();i++){
						System.out.println(Incategory.get(i).identy+Incategory.get(i).name+Incategory.get(i).price+"");
					}
					panel_2.add(Incategory.get(n));
					panel_2.revalidate();
				}
			});
		}

		void init(ArrayList<DTO_menu_detail> detail) {
			n=-1;
			Incategory.clear();
			for(int i=0;i<detail.size();i++) {
				n++;
				tmp = new menu(detail.get(i).get_md_price(),detail.get(i).get_md_name()); 
				tmp.identy=n;
				Incategory.add(tmp);
				Incategory.get(n).addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent me) {
						menu ttmmp=(menu)me.getComponent();
						menu_info.setVisible(true);
						menu_info.set_label(ttmmp.identy);
						menu_name.setText(Incategory.get(menu_info.ide).name.substring(Incategory.get(menu_info.ide).name.lastIndexOf("_")+1));
						menu_cost.setText(""+Incategory.get(menu_info.ide).price);						
					}
				});
				panel_2.add(Incategory.get(n));
				panel_2.revalidate();
			}
						
			
			for(int i=0;i<Incategory.size();i++){
				System.out.println(Incategory.get(i).identy+Incategory.get(i).name+Incategory.get(i).price+"");
			}			
		}
	}
	class menu_info extends JPanel{
		int ide=-1;
		void set_label(int a) {
			ide=a;
		}
	}
	class menu extends JLabel {
		public int price;
		public String name;
		int identy;

		public menu(int price, String name) {
			this.price = price;
			this.name = name;	
			setText("<html>" + this.name + "<br>" + this.price + "</html>");
			setBorder(new LineBorder(new Color(0, 0, 0)));
			setPreferredSize(new Dimension(100, 100));			
		}
		void modify_info(int price, String name) {
			this.price = price;
			this.name = name;	
			setText("<html>" + name + "<br>" + price + "</html>");
		}
	}
}

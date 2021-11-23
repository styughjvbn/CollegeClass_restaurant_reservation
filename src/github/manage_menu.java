package github;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
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

	public manage_menu() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setLayout(null);
		// card 패널 바깥에 존재함
		panel_1 = new JPanel();
		panel_1.setBounds(33, 45, 800, 600);
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
		btnNewButton.setBounds(877, 108, 97, 23);
		add(btnNewButton);

		btnname = new JTextField();
		btnname.setBounds(865, 77, 116, 21);
		add(btnname);

		btnNewButton_1 = new JButton("back");//사장 메뉴 창으로 가는 버튼
		btnNewButton_1.setBounds(912, 463, 97, 23);
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<shop_menu.size();i++) {
					System.out.println(shop_menu.get(i).number);
					System.out.println(shop_menu.get(i).category_name);
				}
			}
		});
		btnNewButton_2.setBounds(912, 542, 97, 23);
		add(btnNewButton_2);
	}

	class xy extends JButton {//카테고리 버튼
		food detail;
		int number;//키값
		public String category_name;//카테고리 이름

		public xy(String category_name) {
			setBorder(new LineBorder(new Color(0, 0, 0)));
			this.category_name = category_name;
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

		public food(int num_) {
			key=num_;
			setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			setLayout(null);
			
			
			JButton btnNewButton = new JButton("New button");

			btnNewButton.setBounds(627, 113, 91, 23);
			add(btnNewButton);

			menucost = new JTextField();
			menucost.setBounds(675, 82, 96, 21);
			add(menucost);
			menucost.setColumns(10);

			menuname = new JTextField();
			menuname.setBounds(675, 51, 96, 21);
			add(menuname);
			menuname.setColumns(10);

			JLabel lblNewLabel = new JLabel("Name");
			lblNewLabel.setBounds(627, 54, 50, 15);
			add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("Cost");
			lblNewLabel_1.setBounds(627, 85, 50, 15);
			add(lblNewLabel_1);

			JPanel panel_2 = new JPanel();//상세메뉴가 생성될 패널
			panel_2.setBackground(Color.WHITE);
			panel_2.setBounds(0, 0, 615, 538);
			add(panel_2);
			panel_2.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));

			JButton Backbtn = new JButton("Back");
			Backbtn.setBounds(654, 494, 91, 23);
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
			
			btnNewButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					n++;
					tmp = new menu(Integer.parseInt(menucost.getText().toString()), menuname.getText()); // xy
					tmp.setText("<html>" + menuname.getText() + "<br>" + menucost.getText() + "</html>"); 
					Incategory.add(tmp);

					panel_2.add(Incategory.get(n));
					panel_2.revalidate();
				}
			});
		}
	}
	class menu extends JButton {
		public int price;
		public String name;

		public menu(int price, String name) {
			setBorder(new LineBorder(new Color(0, 0, 0)));
			setPreferredSize(new Dimension(100, 100));
			this.price = price;
			this.name = name;
		}
	}
}

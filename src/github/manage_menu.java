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
import java.awt.Font;

public class manage_menu extends JPanel {
	/**
	 * Create the panel.
	 */
	private xy temp;// ī�װ� ��ư
	private food temp2;// �󼼸޴� ��ư
	int num = -1;// �г��� ����
	private JOptionPane aa = new JOptionPane();//
	private ArrayList<xy> shop_menu = new ArrayList(); // ī�װ� ��ư �迭
	private JTextField btnname; // �ؽ�Ʈ �ʵ� ī�װ���
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
		
		JLabel lblNewLabel_2 = new JLabel("\uBA54\uB274 \uCE74\uD14C\uACE0\uB9AC \uC774\uB984 \uC785\uB825");
		lblNewLabel_2.setFont(new Font("SEBANG Gothic", Font.BOLD, 17));
		lblNewLabel_2.setBounds(973, 372, 253, 34);
		add(lblNewLabel_2);
		// card �г� �ٱ��� ������
		panel_1 = new JPanel();
		panel_1.setBounds(45, 125, 900, 518);
		add(panel_1);
		panel_1.setLayout(card); // �ٱ� ī�� �г�

		// ī�װ� ����� �г� card�ƴ�
		panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(226,221,215));
		panel_1.add(panel, "category_main");
		panel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));//���� ���� �� ���� 10px ���Ʒ� ���� 10px

		// ī�װ� ����� ��ư��.
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton.setBackground(new Color(189, 182, 174));
		btnNewButton.setFont(new Font("SEBANG Gothic", Font.BOLD, 17));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				temp = new xy(btnname.getText()); // xy class�� �����. ��ư�� ��ġ�� �����ϴ� Ŭ������.
				temp.setText(btnname.getText()); // textfield�� �����ϴ� ���� �޾ƿͼ� ��ư�� ����
				temp.category_name = btnname.getText();
				num++;
				shop_menu.add(temp); // ArrayList�� �߰�
				shop_menu.get(num).detail = new food(num); // detail�� �г��� �߰� detail = xy Ŭ������ �����ϴ� �г�
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
		btnNewButton.setBounds(973, 443, 253, 35);
		add(btnNewButton);

		btnname = new JTextField();
		btnname.setFont(new Font("SEBANG Gothic", Font.PLAIN, 17));
		btnname.setBounds(973, 405, 253, 28);
		add(btnname);

		btnNewButton_1 = new JButton("");//���� �޴� â���� ���� ��ư
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setIcon(new ImageIcon("image/back2.png"));
		btnNewButton_1.setBounds(45, 65, 110, 45);
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnNewButton_2.setIcon(new ImageIcon("image/store.png"));
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
		btnNewButton_2.setBounds(973, 543, 253, 52);
		add(btnNewButton_2);
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("image/managebase.png"));
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
			xy init_category = new xy(category.get(i)); // xy class�� �����. ��ư�� ��ġ�� �����ϴ� Ŭ������.
			num++;
			shop_menu.add(init_category); // ArrayList�� �߰�
			shop_menu.get(num).number = num;
			shop_menu.get(num).detail = new food(num); // detail�� �г��� �߰� detail = xy Ŭ������ �����ϴ� �г�
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

	class xy extends JButton {//ī�װ� ��ư
		food detail;
		int number;//Ű��
		public String category_name;//ī�װ� �̸�

		public xy(String category_name) {
			setBorder(new LineBorder(new Color(200, 184, 164), 2, true));
			setBackground(new Color(226,221,215));
			this.category_name = category_name;
			setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
			setText(this.category_name);
			setPreferredSize(new Dimension(100, 100));
		}
		
	}

	class food extends JPanel {//�󼼸޴� �г�
		public ArrayList<menu> Incategory = new ArrayList();
		private JOptionPane aa = new JOptionPane();
		private JTextField menucost;
		private JTextField menuname;
		int n = -1;
		private menu tmp;
		int key;//Ű��
		private menu_info menu_info;
		private JTextField menu_name;
		private JTextField menu_cost;
		private JPanel panel_2;

		public food(int num_) {
			key=num_;
			setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			setBackground(new Color(226,221,215));
			setLayout(null);
			
			JLabel lblNewLabel0 = new JLabel("* �޴� �߰�");
			lblNewLabel0.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
			lblNewLabel0.setBounds(650, 20, 230, 35);
			add(lblNewLabel0);
			
			JLabel lblNewLabel = new JLabel("�̸� :");
			lblNewLabel.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
			lblNewLabel.setBounds(650, 54, 50, 35);
			add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("���� :");
			lblNewLabel_1.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
			lblNewLabel_1.setBounds(650, 84, 50, 35);
			add(lblNewLabel_1);
			
			JButton btnNewButton = new JButton("Ȯ��");
			btnNewButton.setFont(new Font("SEBANG Gothic", Font.BOLD, 17));
			btnNewButton.setBorder(new LineBorder(new Color(0,0,0)));
			btnNewButton.setBackground(new Color(189, 182, 174));
			btnNewButton.setBounds(650, 128,226, 35);
			add(btnNewButton);

			menuname = new JTextField();
			menuname.setBounds(695, 56, 180, 23);
			add(menuname);
			menuname.setColumns(10);
			
			menucost = new JTextField();
			menucost.setBounds(695, 86, 180, 23);
			add(menucost);
			menucost.setColumns(10);


			panel_2 = new JPanel();//�󼼸޴��� ������ �г�
			panel_2.setBackground(Color.WHITE);
			panel_2.setBounds(10, 10, 615, 498);
			add(panel_2);
			panel_2.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));

			JButton Backbtn = new JButton("ī�װ� ����");
			Backbtn.setFont(new Font("SEBANG Gothic", Font.BOLD, 17));
			Backbtn.setBorder(new LineBorder(new Color(0,0,0)));
			Backbtn.setBackground(new Color(189, 182, 174));
			Backbtn.setBounds(650, 405,226, 35);
			Backbtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			add(Backbtn);

			JButton deletbtn = new JButton("ī�װ� ����"); 
			deletbtn.setFont(new Font("SEBANG Gothic", Font.BOLD, 17));
			deletbtn.setBorder(new LineBorder(new Color(0,0,0)));
			deletbtn.setBackground(new Color(189, 182, 174));
			deletbtn.setForeground(new Color(236,99,94));
			deletbtn.setBounds(650, 445, 226, 35);
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
			
			
			//�޴������г�
			menu_info = new menu_info();
			menu_info.setBounds(650, 180, 235, 190);
			menu_info.setBackground(new Color(226,221,215));
			menu_info.setVisible(false);
			add(menu_info);
			menu_info.setLayout(null);
			
			JLabel menu_lab = new JLabel("* �޴�����");
			menu_lab.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
			menu_lab.setBounds(0, 0, 230, 35);
			menu_info.add(menu_lab);
			
			JLabel lblNewLabelab = new JLabel("�̸� :");
			lblNewLabelab.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
			lblNewLabelab.setBounds(0, 34, 50, 35);
			menu_info.add(lblNewLabelab);

			JLabel lblNewLabelab_1 = new JLabel("���� :");
			lblNewLabelab_1.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
			lblNewLabelab_1.setBounds(0, 64, 50, 35);
			menu_info.add(lblNewLabelab_1);
			
			menu_name = new JTextField();
			menu_name.setBounds(45, 36, 180, 23);
			menu_info.add(menu_name);
			menu_name.setColumns(10);
			
			menu_cost = new JTextField();
			menu_cost.setBounds(45, 66, 180, 23);
			menu_info.add(menu_cost);
			menu_cost.setColumns(10);
			
			JButton modify = new JButton("\uC218\uC815");  //����
			modify.setFont(new Font("SEBANG Gothic", Font.BOLD, 17));
			modify.setBorder(new LineBorder(new Color(0,0,0)));
			modify.setBackground(new Color(189, 182, 174));
			modify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Incategory.get(menu_info.ide).modify_info(Integer.parseInt(menu_cost.getText()), menu_name.getText());
					menu_info.setVisible(false);
				}
			});
			modify.setBounds(0, 110,226, 35);
			menu_info.add(modify);
			
			JButton del = new JButton("\uC0AD\uC81C");  //����
			del.setFont(new Font("SEBANG Gothic", Font.BOLD, 17));
			del.setBorder(new LineBorder(new Color(0,0,0)));
			del.setBackground(new Color(189, 182, 174));
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
			del.setBounds(0, 150,226, 35);
			menu_info.add(del);
			
			btnNewButton.addActionListener(new ActionListener() {  //���� �޴� ����

				@Override
				public void actionPerformed(ActionEvent e) {
					n++;
					tmp = new menu(Integer.parseInt(menucost.getText().toString()), menuname.getText()); // xy
					System.out.println(menucost.getText().toString()+menuname.getText());;
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
				tmp = new menu(detail.get(i).get_md_price(),detail.get(i).get_md_name().substring(0,detail.get(i).get_md_name().lastIndexOf("_"))); 
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
	class menu extends JLabel {  //���� �޴���
		public int price;
		public String name;
		int identy;

		public menu(int price, String name) {
			this.price = price;
			this.name = name;	
			// �� ������� ���
			if (price >= 1000) {
				String rightl = "%14s";
				String nprice = Integer.toString(price);
				nprice = nprice.substring(0, nprice.length() - 3) + ","
						+ nprice.substring(nprice.length() - 3, nprice.length()) + "��";
				setText("<html>" + this.name + "<br>" + nprice + "</html>");
			} else {
				String rightl = "%14s";
				String nprice = Integer.toString(price) + "��";
				setText("<html>" + this.name + "<br>" + nprice + "</html>");
			}
			setHorizontalAlignment(JLabel.CENTER);
			setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
			setBorder(new LineBorder(new Color(200, 184, 164), 2, true));
			setPreferredSize(new Dimension(100, 100));	
			addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) { // �ִ� 10����

				JLabel tjsxor = (JLabel) e.getComponent(); // ���� ī�װ� ǥ��
				tjsxor.setOpaque(true);
				tjsxor.setBackground(new Color(120, 108, 100));
				tjsxor.setForeground(Color.WHITE);
			}

			public void mouseReleased(MouseEvent e) {
				JLabel tjsxor = (JLabel) e.getComponent(); // ���� ī�װ� ǥ��
				tjsxor.setOpaque(false);
				tjsxor.setForeground(Color.BLACK);
			}
			});
		}
			
		void modify_info(int price, String name) {
			this.price = price;
			this.name = name;	
			
			// �� ������� ���
						if (price >= 1000) {
							String rightl = "%14s";
							String nprice = Integer.toString(price);
							nprice = nprice.substring(0, nprice.length() - 3) + ","
									+ nprice.substring(nprice.length() - 3, nprice.length()) + "��";
							setText("<html>" + this.name + "<br>" + nprice + "</html>");
						} else {
							String rightl = "%14s";
							String nprice = Integer.toString(price) + "��";
							setText("<html>" + this.name + "<br>" + nprice + "</html>");
						}
		}
	}
}

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

	public manage_menu() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setLayout(null);
		// card �г� �ٱ��� ������
		panel_1 = new JPanel();
		panel_1.setBounds(33, 45, 800, 600);
		add(panel_1);
		panel_1.setLayout(card); // �ٱ� ī�� �г�

		// ī�װ� ����� �г� card�ƴ�
		panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.add(panel, "category_main");
		panel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));//���� ���� �� ���� 10px ���Ʒ� ���� 10px

		// ī�װ� ����� ��ư��.
		JButton btnNewButton = new JButton("make category");
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
		btnNewButton.setBounds(877, 108, 97, 23);
		add(btnNewButton);

		btnname = new JTextField();
		btnname.setBounds(865, 77, 116, 21);
		add(btnname);

		btnNewButton_1 = new JButton("back");//���� �޴� â���� ���� ��ư
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

	class xy extends JButton {//ī�װ� ��ư
		food detail;
		int number;//Ű��
		public String category_name;//ī�װ� �̸�

		public xy(String category_name) {
			setBorder(new LineBorder(new Color(0, 0, 0)));
			this.category_name = category_name;
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

			JPanel panel_2 = new JPanel();//�󼼸޴��� ������ �г�
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

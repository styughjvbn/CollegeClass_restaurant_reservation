package github;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;

public class reservation_payment extends JPanel {
	private DAO_reservation DAO=new DAO_reservation();
	public String cnt_user;
	public String shop;
	private JPanel panel_2;
	private JPanel panel_3;
	private int n=-1;
	public JButton btnNewButton;
	private ArrayList<category> categorylist=new ArrayList();
	private ArrayList<detail> detaillist =new ArrayList();
	private CardLayout card=new CardLayout(0, 0);
	private JButton btnNewButton_1;
	private JTextArea textArea;
	private JLabel lblNewLabel;
	private JTextArea textArea_1;
	private JButton btnNewButton_2;
	private ArrayList<Integer> sele_price =new ArrayList();
	private ArrayList<String> sele_menu =new ArrayList();
	public JButton btnNewButton_3;
	public DTO_reservation_current pay;
	int sum=0;
	/**
	 * Create the panel.
	 */
	public reservation_payment() {
		setLayout(null);
		
		btnNewButton = new JButton("reservation ");		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay.set_rc_menu(sele_menu);
				pay.set_rc_money(sum);
				System.out.println(pay.get_rc_count()+"  "+pay.get_rc_date()+"  "+pay.get_rc_id()+"  "+pay.get_rc_menu()+"  "+pay.get_rc_money()+"  "+pay.get_rc_shop()+"  "+pay.get_rc_table()+"  "+pay.get_rc_time());
				DAO.new_reservation(pay);
			}
		});
		btnNewButton.setBounds(868, 512, 262, 36);
		add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(100, 100));
		panel_1.setBounds(37, 49, 800, 600);
		add(panel_1);
		panel_1.setLayout(card);
		
		panel_2 = new JPanel();
		panel_1.add(panel_2, "category");
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		panel_3 = new JPanel();
		panel_1.add(panel_3, "detail");
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		//메뉴선택화면으로 돌아가기
		btnNewButton_1 = new JButton("back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_1, "category");
				btnNewButton_1.setVisible(false);
			}
		});
		btnNewButton_1.setVisible(false);
		btnNewButton_1.setBounds(955, 405, 82, 43);
		add(btnNewButton_1);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(1025, 339, 92, 21);
		add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setBounds(1016, 63, 114, 256);
		add(textArea);
		textArea.setEditable(false);
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(866, 62, 114, 256);
		add(textArea_1);
		
		btnNewButton_2 = new JButton("\uAC00\uC7A5 \uCD5C\uADFC \uBA54\uB274 \uC0AD\uC81C");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sele_price.remove(sele_price.size()-1);
				sele_menu.remove(sele_menu.size()-1);
				textArea.setText("");
				textArea_1.setText("");
				sum=0;
				for(int i=0;i<sele_price.size();i++) {
					sum+=sele_price.get(i);
					textArea.append(sele_menu.get(i)+"\n");
					textArea_1.append(Integer.toString(sele_price.get(i))+"\n");
				}
				lblNewLabel.setText(Integer.toString(sum));
			}
		});
		btnNewButton_2.setBounds(867, 338, 129, 23);
		add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("back");
		
		btnNewButton_3.setBounds(841, 469, 97, 23);
		add(btnNewButton_3);

	}
	public void refresh(String cnt_shop) {
		this.shop=cnt_shop;
		categorylist.clear();
		panel_2.removeAll();
		textArea.setText("");
		textArea_1.setText("");
		ArrayList<String> list=DAO.get_category(this.shop);
		for(int i=0; i<list.size();i++) {
			category temp=new category(list.get(i));
			temp.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String str=((category)e.getComponent()).category_name;
					set_detail(DAO.get_detail(str));
					card.show(panel_2.getParent(), "detail");
					btnNewButton_1.setVisible(true);
				}
			});
			categorylist.add(temp);
			panel_2.add(categorylist.get(i));		
		}
		panel_2.revalidate();
	}
	public void set_detail(ArrayList<DTO_menu_detail> source) {
		detaillist.clear();
		panel_3.removeAll();

		for(int i=0;i<source.size();i++) {
			detail temp=new detail(source.get(i).get_md_price(),source.get(i).get_md_name());
			detaillist.add(temp);
			panel_3.add(detaillist.get(i));			
		}
		panel_3.revalidate();
	}
	
	
	
	class category extends JLabel{
		int number;//키값
		public String category_name;//카테고리 이름

		public category(String category_name) {
			setBorder(new LineBorder(new Color(0, 0, 0)));
			this.category_name = category_name;
			setText(this.category_name);
			setPreferredSize(new Dimension(100, 100));
		}
	}
	class detail extends JLabel{
		public int price;
		public String name;
		int identy;
		
		public detail(int price_, String name_) {
			this.price = price_;
			this.name = name_.substring(0,name_.lastIndexOf("_"));	
			setText("<html>" + this.name + "<br>" + this.price + "</html>");
			setBorder(new LineBorder(new Color(0, 0, 0)));
			setPreferredSize(new Dimension(100, 100));	
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {//최대 10개만
					sele_price.add(price);
					sele_menu.add(name);
					textArea.append(name+"\n");
					textArea_1.append(Integer.toString(price)+"\n");
					sum=0;
					for(int i=0;i<sele_price.size();i++) {
						sum+=sele_price.get(i);
					}
					lblNewLabel.setText(Integer.toString(sum));
				}
			});
		}
	}
}


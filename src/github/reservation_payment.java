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
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

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
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1_2;
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
		btnNewButton.setBounds(900, 548, 284, 49);
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
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(998, 383, 191, 21);
		add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(226,221,215));
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setBounds(900, 108, 159, 256);
		add(textArea);
		textArea.setEditable(false);
		
		textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(226,221,215));
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_1.setEditable(false);
		textArea_1.setBounds(1060, 108, 124, 256);
		add(textArea_1);
		
		btnNewButton_2 = new JButton("\uCD5C\uADFC \uC120\uD0DD \uBA54\uB274 \uC0AD\uC81C");
		btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 15));
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
					//돈 단위대로 출력
					if(sele_price.get(i)>=1000) { 
						String rightl= "%14s";
						String nprice= Integer.toString(sele_price.get(i));
						nprice= nprice.substring(0, nprice.length()-3)+","+nprice.substring(nprice.length()-3, nprice.length())+"원";
						textArea_1.append(String.format(rightl,  nprice)+"\n");
					}else {
						String rightl= "%14s";
						String nprice= Integer.toString(sele_price.get(i))+"원";
						lblNewLabel.setText(String.format(rightl,nprice));
						textArea_1.append(String.format(rightl,nprice)+"\n");
					}
				}
				//돈 단위대로 출력
				if(sum>=1000) {  
					String rightl= "%30s";
					String nprice= Integer.toString(sum);
					nprice= nprice.substring(0, nprice.length()-3)+","+nprice.substring(nprice.length()-3, nprice.length())+"원";
					lblNewLabel.setText(String.format(rightl,nprice));
				}else {
					String rightl= "%30s";
					String nprice= Integer.toString(sum)+"원";
					lblNewLabel.setText(String.format(rightl,nprice));
				}
			}
		});
		btnNewButton_2.setBounds(900, 414, 284, 27);
		add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("back");
		
		btnNewButton_3.setBounds(900, 489, 284, 49);
		add(btnNewButton_3);
		
		lblNewLabel_1 = new JLabel("\uCD1D \uC8FC\uBB38\uAE08\uC561");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setBounds(900, 384, 86, 21);
		add(lblNewLabel_1);
		
		//메뉴선택화면으로 돌아가기
		btnNewButton_1 = new JButton("back");
		btnNewButton_1.setBounds(762, 16, 59, 23);
		add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uBA54\uB274 \uC120\uD0DD");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(900, 68, 65, 21);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon("C:\\Users\\kmj\\Documents\\GitHub\\restaurant_reservation\\image\\hsection_icon.png"));
		lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(894, 86, 290, 21);
		add(lblNewLabel_1_1_1);
		
		lblNewLabel_1_1_2 = new JLabel("");
		lblNewLabel_1_1_2.setIcon(new ImageIcon("C:\\Users\\kmj\\Documents\\GitHub\\restaurant_reservation\\image\\hsection_icon.png"));
		lblNewLabel_1_1_2.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1_1_2.setBounds(894, 359, 290, 21);
		add(lblNewLabel_1_1_2);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_1, "category");
				btnNewButton_1.setVisible(false);
			}
		});
		btnNewButton_1.setVisible(false);

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

		panel_3.add(btnNewButton_1);
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
					 //돈 단위대로 출력
					if(price>=1000) { 
						String rightl= "%14s";
						String nprice= Integer.toString(price);
						nprice= nprice.substring(0, nprice.length()-3)+","+nprice.substring(nprice.length()-3, nprice.length())+"원";
						textArea_1.append(String.format(rightl,  nprice)+"\n");
					}else {
						String rightl= "%14s";
						String nprice= Integer.toString(price)+"원";
						lblNewLabel.setText(String.format(rightl,nprice));
						textArea_1.append(String.format(rightl,nprice)+"\n");
					}
					sum=0;
					for(int i=0;i<sele_price.size();i++) {
						sum+=sele_price.get(i);
					}
					//돈 단위대로 출력, 오른쪽 정렬
					if(sum>=1000) {  
						String rightl= "%30s";
						String nprice= Integer.toString(sum);
						nprice= nprice.substring(0, nprice.length()-3)+","+nprice.substring(nprice.length()-3, nprice.length())+"원";
						lblNewLabel.setText(String.format(rightl,nprice));
					}else {
						String rightl= "%30s";
						String nprice= Integer.toString(sum)+"원";
						lblNewLabel.setText(String.format(rightl,nprice));
						//lblNewLabel.setText(Integer.toString(sum)+"원");
					}
				}
			});
		}
	}
}


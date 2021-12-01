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
		
		//메뉴 다 고르고서 예약버튼
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
		panel_1.setBackground(new Color(226,221,215));
		panel_1.setPreferredSize(new Dimension(100, 100));
		panel_1.setBounds(37, 49, 800, 594);
		add(panel_1);
		panel_1.setLayout(null);
		
		//detail 패널
		panel_3 = new JPanel();
		panel_3.setBounds(0, 99, 797, 495);
		panel_1.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		//category 패널
				panel_2 = new JPanel();
				panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); 
				
		JScrollPane scrollPane = new JScrollPane(panel_2, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(null);
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(0, 5, 797, 90);
		panel_1.add(scrollPane);
		
		scrollPane.setViewportView(panel_2);
		
		//총 주문 금액
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(998, 383, 191, 21);
		add(lblNewLabel);
		
		//선택 메뉴 이름
		textArea = new JTextArea();
		textArea.setBackground(new Color(226,221,215));
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setBounds(900, 108, 159, 256);
		add(textArea);
		textArea.setEditable(false);
		
		//가격
		textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(226,221,215));
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_1.setEditable(false);
		textArea_1.setBounds(1060, 108, 124, 256);
		add(textArea_1);
		
		//최근 선택 메뉴 삭제 : 최근 메뉴 삭제하고 메뉴판 다시 출력
		btnNewButton_2 = new JButton("\uCD5C\uADFC \uC120\uD0DD \uBA54\uB274 \uC0AD\uC81C");
		btnNewButton_2.setBorder(new LineBorder(new Color(200, 184, 164), 1, true));
		btnNewButton_2.setForeground( new Color(120, 108, 100));
		btnNewButton_2.setBackground(new Color(200, 184, 164));
		btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sele_price.size() > 0) {
					sele_price.remove(sele_price.size() - 1);
					sele_menu.remove(sele_menu.size() - 1);
					textArea.setText("");
					textArea_1.setText("");
					sum = 0;
					for (int i = 0; i < sele_price.size(); i++) {
						sum += sele_price.get(i);
						textArea.append(sele_menu.get(i) + "\n");
						// 돈 단위대로 출력
						if (sele_price.get(i) >= 1000) {
							String rightl = "%14s";
							String nprice = Integer.toString(sele_price.get(i));
							nprice = nprice.substring(0, nprice.length() - 3) + ","
									+ nprice.substring(nprice.length() - 3, nprice.length()) + "원";
							textArea_1.append(String.format(rightl, nprice) + "\n");
						} else {
							String rightl = "%14s";
							String nprice = Integer.toString(sele_price.get(i)) + "원";
							lblNewLabel.setText(String.format(rightl, nprice));
							textArea_1.append(String.format(rightl, nprice) + "\n");
						}
					}
					// 돈 단위대로 출력
					if (sum >= 1000) {
						String rightl = "%30s";
						String nprice = Integer.toString(sum);
						nprice = nprice.substring(0, nprice.length() - 3) + ","
								+ nprice.substring(nprice.length() - 3, nprice.length()) + "원";
						lblNewLabel.setText(String.format(rightl, nprice));
					} else {
						String rightl = "%30s";
						String nprice = Integer.toString(sum) + "원";
						lblNewLabel.setText(String.format(rightl, nprice));
					}
				}
				//총 주문금액 돈 단위대로 출력
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
		
		//좌석 선택화면으로 돌아감
		btnNewButton_3 = new JButton("back");
		btnNewButton_3.setBounds(900, 489, 284, 49);
		add(btnNewButton_3);
		
		lblNewLabel_1 = new JLabel("\uCD1D \uC8FC\uBB38\uAE08\uC561");  //총 주문금액 글씨
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setBounds(900, 384, 86, 21);
		add(lblNewLabel_1);
		
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
		

	}
	
	public void refresh(String cnt_shop) {  //화면 초기화
		this.shop=cnt_shop;
		categorylist.clear();  
		panel_2.removeAll();
		
		textArea.setText("");
		textArea_1.setText("");
		ArrayList<String> list=DAO.get_category(this.shop);  //카테고리 리스트
		for(int i=0; i<list.size();i++) {
			category temp=new category(list.get(i)); 
			if(i==0) { //처음화면
				String str=temp.category_name;  //카테고리 이름 받아서
				set_detail(DAO.get_detail(str));  //메뉴들 받아옴
				panel_3.setVisible(true);
				
				temp.setOpaque(true);
				temp.setBackground(new Color(120, 108, 100));
				temp.setForeground(Color.WHITE);
			}
			
			temp.addMouseListener(new MouseAdapter() {  //카테고리 하나 누르면
				@Override
				public void mouseClicked(MouseEvent e) {
					String str=((category)e.getComponent()).category_name;  //카테고리 이름 받아서
					panel_3.setVisible(false);
					set_detail(DAO.get_detail(str));  //메뉴들을 받아옴
					panel_3.setVisible(true);
					
					set_category(list, str);  //선택 카테고리 표시
				}
			});
			categorylist.add(temp);
			panel_2.add(categorylist.get(i));		
		}
		panel_2.revalidate();
	}
	
	public void set_category(ArrayList<String> list, String str) {  //panel_3 카테고리 세팅
		panel_2.removeAll();
		categorylist.clear();  

		for(int i=0;i<list.size();i++) {
			category temp=new category(list.get(i));
			if(temp.category_name==str) {
				temp.setOpaque(true);
				temp.setBackground(new Color(120, 108, 100));
				temp.setForeground(Color.WHITE);
			}
			temp.addMouseListener(new MouseAdapter() {  //카테고리 하나 누르면
				@Override
				public void mouseClicked(MouseEvent e) {
					String str=((category)e.getComponent()).category_name;  //카테고리 이름 받아서
					panel_3.setVisible(false);
					set_detail(DAO.get_detail(str));  //메뉴들을 받아옴
					panel_3.setVisible(true);
					
					set_category(list, str);  //선택 카테고리 표시
				}
			});
			categorylist.add(temp);
			panel_2.add(categorylist.get(i));			
		}
		panel_2.revalidate();
	}
	
	public void set_detail(ArrayList<DTO_menu_detail> source) {  //panel_3 메뉴 세팅
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
		int number;//키 값
		public String category_name;//카테고리 이름

		public category(String category_name) {
			setBorder(null);
			this.category_name = category_name;
			setText(this.category_name);
			setHorizontalAlignment(JLabel.CENTER);
			setPreferredSize(new Dimension(100, 50));
		}
	}
	class detail extends JLabel{
		public int price;
		public String name;
		int identy;
		
		public detail(int price_, String name_) {
			this.price = price_;
			this.name = name_.substring(0,name_.lastIndexOf("_"));	
			//돈 단위대로 출력
			if(this.price>=1000) { 
				String rightl= "%14s";
				String nprice= Integer.toString(this.price);
				nprice= nprice.substring(0, nprice.length()-3)+","+nprice.substring(nprice.length()-3, nprice.length())+"원";
				setText("<html>" + this.name + "<br>" + nprice + "</html>");
			}else {
				String rightl= "%14s";
				String nprice= Integer.toString(this.price)+"원";
				setText("<html>" + this.name + "<br>" + nprice + "</html>");
			}
			setHorizontalAlignment(JLabel.CENTER);
			setBorder(new LineBorder(new Color(200, 184, 164), 1, true));
			setPreferredSize(new Dimension(100, 100));	
			addMouseListener(new MouseAdapter() {
				
				@Override
				public void mousePressed(MouseEvent e) { //최대 10개만
					
					JLabel tjsxor=(JLabel)e.getComponent();  //선택 카테고리 표시
					tjsxor.setOpaque(true);
					tjsxor.setBackground(new Color(120, 108, 100));
					tjsxor.setForeground(Color.WHITE);
					
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
					}
				}
				public void mouseReleased(MouseEvent e) {
					JLabel tjsxor=(JLabel)e.getComponent();  //선택 카테고리 표시
					tjsxor.setOpaque(false);
					tjsxor.setForeground(Color.BLACK);
				}
			});
		}
	}
}


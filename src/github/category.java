package github;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.CardLayout;

public class category extends JPanel {

	/**
	 * Create the panel.
	 */
	private xy temp;
	private food temp2;
	int x,y =0;
	int num =-1;
	private JOptionPane aa = new JOptionPane();
	private ArrayList<xy> shop_menu = new ArrayList(); //ī�װ� ��ư �迭
	private JTextField btnname; //�ؽ�Ʈ �ʵ� ī�װ���
	public CardLayout card=new CardLayout();
	private DB_connection db = new DB_connection();
	public JPanel panel_1;
	int categorynum;
	public category() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setLayout(null);
		//card �г� �ٱ��� ������
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 779, 648);
		add(panel_1);
		panel_1.setLayout(card); //�ٱ� ī�� �г�
		
		//ī�װ� ����� �г� card�ƴ�
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(40, 21, 722, 625);
		panel_1.add(panel, "category_main");
		panel.setLayout(null);

		//ī�װ� ����� ��ư��.
		JButton btnNewButton = new JButton("make category");
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		
				temp = new xy((x),(y),btnname.getText()); //xy class�� �����. ��ư�� ��ġ�� �����ϴ� Ŭ������.
				temp2 = new food(); //�г� class�� ����.
				temp.setText(btnname.getText()); //textfield�� �����ϴ� ���� �޾ƿͼ� ��ư�� ����
				num++;
				shop_menu.add(temp); //ArrayList�� �߰�
				shop_menu.get(num).detail = temp2; //detail�� �г��� �߰� detail = xy Ŭ������ �����ϴ� �г�
				temp.number = num;
				
				x = x+100;
				if(x == 700)
				{
					x = 0;
					y = y + 100;
				}
				if(y >= 600)
				{
					aa.showMessageDialog(null, "ī�װ��� �� á���ϴ�..!");
					return;
				}
				temp.addActionListener(new ActionListener() {

					int x = temp.number;
					public void actionPerformed(ActionEvent e) {
						card.show(panel_1, "category"+ x);
					}
					
				});

				panel.add(shop_menu.get(num));
				panel_1.add(shop_menu.get(num).detail,"category"+num);
				
				panel.repaint();
				panel_1.repaint();
			}
			
			
		});
		btnNewButton.setBounds(877, 108, 97, 23);
		add(btnNewButton);
		
		btnname = new JTextField();
		btnname.setBounds(865, 77, 116, 21);
		add(btnname);
		btnname.setColumns(10);
		
		JButton savebtn = new JButton("New button");
		savebtn.setBounds(877, 163, 91, 23);
		savebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!shop_menu.isEmpty()) {
				for(int i = 0;i<num;i++) {
					if(shop_menu.get(i).detail.Incategory.isEmpty()) {
					for(int j = 0;j<shop_menu.get(i).detail.n;j++) 
					DB_connection.menu_detail(new DTO_menu_detail(shop_menu.get(i).detail.Incategory.get(j).name,shop_menu.get(i).category_name,
							shop_menu.get(i).detail.Incategory.get(j).price));
					
					}
				}
			}
			}
				
		});

		
		add(savebtn);
		
		
			
	
		
	

}

class xy extends JButton{
	food detail;
	int number;
	public String category_name;
	public xy(int x, int y,String category_name) {
		setBounds(x,y,100,100);
		setBorder(new LineBorder(new Color(0,0,0)));
		this.category_name = category_name;

	}
}
class menu extends JButton{
	public int price;
	public String name;
	public menu(int x, int y, int price, String name) {
		setBounds(x,y,100,100);
		setBorder(new LineBorder(new Color(0,0,0)));
		this.price = price;
		this.name = name;
	}
}

class food extends JPanel{
	private category c = new category(); 
	public ArrayList<menu> Incategory = new ArrayList();
	private JOptionPane aa = new JOptionPane();
	private JTextField menucost;
	private JTextField menuname;
	public JButton Backbtn;
	int n =-1;
	int x2,y2 =0;
	private menu tmp;
	public food() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Cost\r\n");
		lblNewLabel_1.setBounds(627, 85, 50, 15);
		add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 615, 538);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(351, 5, 1, 1);
		panel_1.add(panel);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setLayout(null);
		
		JButton Backbtn = new JButton("Back");
		Backbtn.setBounds(654, 494, 91, 23);
		Backbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
			
		});
		add(Backbtn);
		

	
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				n++;
				tmp = new menu((x2),(y2),Integer.parseInt(menucost.getText().toString()),menuname.getText()); //xy class�� �����. ��ư�� ��ġ�� �����ϴ� Ŭ������.
				tmp.setText("<html>"+menuname.getText() + "<br>" + menucost.getText() + "</html>"); //textfield�� �����ϴ� ���� �޾ƿͼ� ��ư�� ����
				Incategory.add(tmp);
				
				x2 = x2+100;
				if(x2 == 700)
				{
					x2 = 0;
					y2 = y2+ 100;
				}
				if(y2 >= 600)
				{
					aa.showMessageDialog(null, "ī�װ��� �� á���ϴ�..!");
					return;
				}
				panel_1.add(Incategory.get(n));
				panel_1.repaint();

				
			}
			
		});

	


		


	}

}	
	
}

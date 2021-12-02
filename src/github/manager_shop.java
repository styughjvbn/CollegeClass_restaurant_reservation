package github;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

class shop_table extends JLabel{//드래그로 배치가 가능한 테이블 라벨
	int x,y;
	int size;
	public shop_table(int num,int tablenum){
		size=num;//테이블의 인원수
		setBounds(0, 0, 100, 100);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setIcon(new ImageIcon("image/"+size+".png"));
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), Integer.toString(tablenum), TitledBorder.LEADING, TitledBorder.BOTTOM, null, new Color(0, 0, 0)));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x=e.getX();
				y=e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int a=e.getX()-x;
				int b=e.getY()-y;
				int old_x=getX();
				int old_y=getY();
				int hhh=old_x+a;
				int ggg=old_y+b;
				if(hhh<700&&hhh>0&&ggg>0&&ggg<500)
					setLocation(old_x+a,old_y+b);
			}
		});
	}
	public shop_table(int num,int tablenum,int newx,int newy){
		size=num;
		setBounds(newx, newy, 100 ,100 );
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setIcon(new ImageIcon("image/"+size+".png"));
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), Integer.toString(tablenum), TitledBorder.LEADING, TitledBorder.BOTTOM, null, new Color(0, 0, 0)));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x=e.getX();
				y=e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int a=e.getX()-x;
				int b=e.getY()-y;
				int old_x=getX();
				int old_y=getY();
				int hhh=old_x+a;
				int ggg=old_y+b;
				if(hhh<700&&hhh>0&&ggg>0&&ggg<500)
					setLocation(old_x+a,old_y+b);
			}
		});
	}
}

public class manager_shop extends JPanel {
	private ArrayList<shop_table> shop_table=new ArrayList();
	private JCheckBox[] holydaycheck=new JCheckBox[7];
	int table_num;
	private DAO_manager DAO=new DAO_manager();
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	public JButton btnNewButton_1;
	public String shop;
	private JPanel panel_1;
	public byte holyday;
	public int open;
	public int close;
	private String img;
	private JLabel lblNewLabel_6;
	public JLabel lblNewLabel_5;
	/**
	 * Create the panel.
	 */
	public manager_shop() {
		setLayout(null);
		JButton c = new JButton("");//만들기 버튼
		c.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		c.setIcon(new ImageIcon("image/seat.png"));
		c.setBounds(810, 390, 400, 40);
		add(c);

		JLabel lblNewLabel = new JLabel("\uC778\uC6D0\uC218");//인원수 라벨
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblNewLabel.setBackground(new Color(226,221,215));
		lblNewLabel.setFont(new Font("SEBANG Gothic", Font.BOLD, 15));
		lblNewLabel.setBounds(810, 325, 400, 40);
		add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();//테이블 인원수 설정
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "5", "6"}));
		comboBox.setBackground(new Color(226,221,215));
		comboBox.setFont(new Font("SEBANG GOthic", Font.PLAIN, 12));
		comboBox.setBounds(1009, 325, 200, 40);
		add(comboBox);
		
		panel_1 = new JPanel();//드래그가 가능한 공간
		panel_1.setBackground(new Color(226,221,215));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(45, 125, 734, 518);
		add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_6 = new JLabel();//드래그가 가능한 공간의 배경화면
		lblNewLabel_6.setBounds(0, 0, 734, 518);
		panel_1.add(lblNewLabel_6);
		lblNewLabel_6.setBackground(new Color(226,221,215));
		lblNewLabel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		comboBox_1 = new JComboBox();//영업시작 시작 콤보박스
		comboBox_1.setFont(new Font("SEBANG Gothic", Font.PLAIN, 12));
		comboBox_1.setBackground(new Color(226,221,215));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"}));
		comboBox_1.setBounds(900, 70, 110, 30);
		add(comboBox_1);
		
		comboBox_2 = new JComboBox();//영업종료 시간 콤보박스
		comboBox_2.setFont(new Font("SEBANG Gothic", Font.PLAIN, 12));
		comboBox_2.setBackground(new Color(226,221,215));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"}));
		comboBox_2.setBounds(1075, 70, 110, 30);
		add(comboBox_2);
		
		JLabel lblNewLabel_2 = new JLabel("\uC601\uC5C5\uC2DC\uAC04");//영업시간
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("SEBANG Gothic", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(810, 65, 400, 40);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("~");
		lblNewLabel_3.setFont(new Font("SEBANG Gothic", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(1040, 70, 57, 30);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uD734\uBB34\uC77C");//휴무일
		lblNewLabel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_4.setFont(new Font("SEBANG Gothic", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(810, 130, 400, 40);
		add(lblNewLabel_4);
		
		//밑으로 쭉 월화수목금토일 체크박스
		holydaycheck[0] = new JCheckBox("\uC6D4");
		holydaycheck[0].setBackground(new Color(226,221,215));
		holydaycheck[0].setFont(new Font("SEBANG Gothic", Font.PLAIN,12));
		holydaycheck[0].setBounds(860, 137, 45, 23);
		add(holydaycheck[0]);
		
		holydaycheck[1] = new JCheckBox("\uD654");
		holydaycheck[1].setBackground(new Color(226,221,215));
		holydaycheck[1].setFont(new Font("SEBANG Gothic", Font.PLAIN,12));
		holydaycheck[1].setBounds(910, 137, 45, 23);
		add(holydaycheck[1]);
		
		holydaycheck[2] = new JCheckBox("\uC218");
		holydaycheck[2].setBackground(new Color(226,221,215));
		holydaycheck[2].setFont(new Font("SEBANG Gothic", Font.PLAIN,12));
		holydaycheck[2].setBounds(960, 137, 45, 23);
		add(holydaycheck[2]);
		
		holydaycheck[3] = new JCheckBox("\uBAA9");
		holydaycheck[3].setBackground(new Color(226,221,215));
		holydaycheck[3].setFont(new Font("SEBANG Gothic", Font.PLAIN,12));
		holydaycheck[3].setBounds(1010, 137, 45, 23);
		add(holydaycheck[3]);
		
		holydaycheck[4] = new JCheckBox("\uAE08");
		holydaycheck[4].setBackground(new Color(226,221,215));
		holydaycheck[4].setFont(new Font("SEBANG Gothic", Font.PLAIN,12));
		holydaycheck[4].setBounds(1060, 137, 45, 23);
		add(holydaycheck[4]);
		
		holydaycheck[5] = new JCheckBox("\uD1A0");
		holydaycheck[5].setBackground(new Color(226,221,215));
		holydaycheck[5].setFont(new Font("SEBANG Gothic", Font.PLAIN,12));
		holydaycheck[5].setBounds(1110, 137, 45, 23);
		add(holydaycheck[5]);
		
		holydaycheck[6] = new JCheckBox("\uC77C");
		holydaycheck[6].setBackground(new Color(226,221,215));
		holydaycheck[6].setFont(new Font("SEBANG Gothic", Font.PLAIN,12));
		holydaycheck[6].setBounds(1160, 137, 45, 23);
		add(holydaycheck[6]);
		//여기까지 체크 박스
		
		lblNewLabel_5 = new JLabel();//점포 관리 라벨 제목
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_5.setBounds(437, 51, 342, 64);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_1 = new JLabel("\uD14C\uC774\uBE14 \uAD00\uB9AC");//테이블 관리 라벨
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("SEBANG Gothic", Font.BOLD,15));
		lblNewLabel_1.setBounds(810, 260, 400, 40);
		add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");//가장 최근 테이블 삭제
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton.setIcon(new ImageIcon("image/delete.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.remove(table_num);
				panel_1.repaint();
				shop_table.remove(table_num--);
			}
		});
		btnNewButton.setBounds(810, 455, 400, 40);
		add(btnNewButton);

		
		c.addMouseListener(new MouseAdapter() {//만들기 버튼의 액션함수
			@Override
			public void mouseClicked(MouseEvent e) {
				int size=comboBox.getSelectedIndex()+2;
				shop_table temp=new shop_table(size,++table_num+1);
				shop_table.add(temp);
				
				panel_1.add(shop_table.get(table_num),table_num);
				panel_1.repaint();
			}
		});
		JButton btnNewButton_4 = new JButton("");//저장 버튼
		btnNewButton_4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnNewButton_4.setIcon(new ImageIcon("image/store.png"));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open=comboBox_1.getSelectedIndex();
				close=comboBox_2.getSelectedIndex();
				holyday=0;
				if(holydaycheck[0].isSelected())
					holyday+=64;
				if(holydaycheck[1].isSelected())
					holyday+=32;
				if(holydaycheck[2].isSelected())
					holyday+=16;
				if(holydaycheck[3].isSelected())
					holyday+=8;
				if(holydaycheck[4].isSelected())
					holyday+=4;
				if(holydaycheck[5].isSelected())
					holyday+=2;
				if(holydaycheck[6].isSelected())
					holyday+=1;
				DAO.update_shop(new DTO_shop(shop,(byte)holyday,open,close,shop_table.size(),"",img));
				DAO.delete_table(shop);
				for(int i=0;i<shop_table.size();i++) {
					DAO.new_table(new DTO_manage_table(i+1,shop,shop_table.get(i).size,shop_table.get(i).getX(),shop_table.get(i).getY()));
				}
			}
		});
		btnNewButton_4.setBounds(810, 552, 400, 80);
		add(btnNewButton_4);
		
		btnNewButton_1 = new JButton("");//뒤로가기 버튼
		btnNewButton_1.setBorder(new LineBorder(new Color(226, 221, 215), 2, true));
		btnNewButton_1.setIcon(new ImageIcon("image/back2.png"));
		btnNewButton_1.setBounds(45, 57, 120, 50);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");//배경화면 이미지 설정		
		btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton_2.setIcon(new ImageIcon("image/setting.png"));
		btnNewButton_2.setBounds(810, 195, 400, 40);
		add(btnNewButton_2);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("image/managebase.png"));
		lblNewLabel_7.setBounds(0, 0, 1280, 720);
		add(lblNewLabel_7);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
		        int returnVal = jfc.showOpenDialog(null);
		        File oriFile = jfc.getSelectedFile();
		        File copyFile = new File("image/shop_image/"+shop+"배경화면.jpg"); 
		        try {		        
		            FileInputStream fis = new FileInputStream(oriFile); //읽을파일
		            FileOutputStream fos = new FileOutputStream(copyFile); //복사할파일		            
		            int fileByte = 0; 
		            // fis.read()가 -1 이면 파일을 다 읽은것
		            while((fileByte = fis.read()) != -1) {
		                fos.write(fileByte);
		            }
		            //자원사용종료
		            fis.close();
		            fos.close(); 
		        } catch (FileNotFoundException ee) {
		            ee.printStackTrace();
		        } catch (IOException me) {
		            me.printStackTrace();
		        }
		        img="image/shop_image/"+shop+"배경화면.jpg";
		        lblNewLabel_6.setIcon(new ImageIcon(img));
			}
		});
	}
	void init() {
		ArrayList<int[]> temp=DAO.get_table_info(shop);
		img=DAO.get_shop_image(shop);
		shop_table.clear();
		table_num=-1;
		panel_1.removeAll();
		panel_1.add(lblNewLabel_6);
		
		if((img!=null)&&(!(img.equals("null")))) {
			lblNewLabel_6.setIcon(new ImageIcon(img));
			lblNewLabel_6.repaint();
		}
		else {
			lblNewLabel_6.setIcon(new ImageIcon("image/drag.jpg"));
			lblNewLabel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			lblNewLabel_6.repaint();
		}
		for(int i=0;i<temp.size();i++) {
			shop_table tmp=new shop_table(temp.get(i)[1],++table_num+1,temp.get(i)[2],temp.get(i)[3]);
			shop_table.add(tmp);
			panel_1.add(shop_table.get(table_num),table_num);			
		}
		panel_1.repaint();
		int[] a=DAO.get_shop_info(shop);
		int aa;

		comboBox_1.setSelectedIndex(a[1]);
		comboBox_2.setSelectedIndex(a[2]);
		holyday=(byte)a[0];
		aa=Byte.toUnsignedInt(holyday);
		System.out.println(Integer.toBinaryString(aa));
		for(int i=0;i<holydaycheck.length;i++) {
			holydaycheck[i].setSelected(false);
		}
		if((aa&64)==64)
			holydaycheck[0].setSelected(true);
		if((aa&32)==32)
			holydaycheck[1].setSelected(true);
		if((aa&16)==16)
			holydaycheck[2].setSelected(true);
		if((aa&8)==8)
			holydaycheck[3].setSelected(true);
		if((aa&4)==4)
			holydaycheck[4].setSelected(true);
		if((aa&2)==2)
			holydaycheck[5].setSelected(true);
		if((aa&1)==1)
			holydaycheck[6].setSelected(true);
	}
}


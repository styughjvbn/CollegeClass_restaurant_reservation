package github;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_manager {
	private static Connection conn;
	private static ResultSet rs;
	private static PreparedStatement pstmt;

	public static int update_shop(DTO_shop manager) {//���� ����
		try{
			   Connection con = getConnection();
			   PreparedStatement insert1 = con.prepareStatement(""
			     + "UPDATE shop SET"
			     + " shop_holyday = '"+manager.get_shop_holyday()+"',"
			     + " shop_open = '"+manager.get_shop_open()+"',"
			     + " shop_close = '"+manager.get_shop_close()+"',"
			     + " shop_table_num = '"+manager.get_shop_table_num()+"',"
			     + " shop_iner = '"+manager.get_shop_iner()+"'"
			     +" WHERE (shop_name = '"+manager.get_shop_name()+"');");
			   insert1.executeUpdate();
			  }catch(Exception e){
			   System.out.println(e.getMessage());
			  }
		return 0;
	}
	public static int new_table(DTO_manage_table manager) {//������ ���̺� �߰�
		try{
			   Connection con = getConnection();
			   PreparedStatement insert1 = con.prepareStatement(""
			     + "INSERT INTO manage_table"
			     + "(mt_table, mt_shop, mt_size, mt_x, mt_y) "
			     + "VALUE "
			     + "('"+manager.get_mt_table()+"','"+manager.get_mt_shop()+"','"+manager.get_mt_size()+"','"+manager.get_mt_x()+"','"+manager.get_mt_y()+"')");
			   insert1.executeUpdate();
			  }catch(Exception e){
			   System.out.println(e.getMessage());
			  }
		
		return 0;
	}
	public ArrayList<int[]> get_table_info(String shop) {//���� ���̺� ���� �޾ƿ���
		conn = getConnection();
		ArrayList<int[]> temp=new ArrayList();
		try {
			pstmt = conn.prepareStatement("select * from manage_table where mt_shop = ? ");
			pstmt.setString(1, shop); //ù��° ?�� ����
			
			rs = pstmt.executeQuery();
			while(rs.next()) {//rs�� next�� ���� ������ ��ġ�Ѵٴ� ��
				int a[]=new int[4];
				a[0]=rs.getInt(1);
				a[1]=rs.getInt(3);
				a[2]=rs.getInt(4);
				a[3]=rs.getInt(5);
				temp.add(a);
			}
			return temp;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}
	public int[] get_shop_info(String shop) {//���� ���� ��������
		conn = getConnection();
		int[] a=new int[4];
		try {
			pstmt = conn.prepareStatement("select * from shop where shop_name = ? ");
			pstmt.setString(1, shop); //ù��° ?�� ����
			
			rs = pstmt.executeQuery();
			if(rs.next()) {//rs�� next�� ���� ������ ��ġ�Ѵٴ� ��
				a[0]=rs.getInt(2);
				a[1]=rs.getInt(3);
				a[2]=rs.getInt(4);
				a[3]=rs.getInt(5);
				return a;
			}
			return null;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null; //�α��� ����
	}
	public String get_shop_image(String shop) {//���� �̹��� ��������
		conn = getConnection();
		String a;
		try {
			pstmt = conn.prepareStatement("select shop_iner from shop where shop_name = ? ");
			pstmt.setString(1, shop); //ù��° ?�� ����
			
			rs = pstmt.executeQuery();
			if(rs.next()) {//rs�� next�� ���� ������ ��ġ�Ѵٴ� ��
				a=rs.getString(1);
				return a;
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null; //�α��� ����
	}
	public boolean delete_table(String shop) {//���� ���̺� ��� ����
		conn = getConnection();
		int[] a=new int[4];
		try {
			pstmt = conn.prepareStatement("DELETE FROM manage_table WHERE mt_shop = ? ");
			pstmt.setString(1, shop); //ù��° ?�� ����
			
			pstmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false; //�α��� ����
	}
	public boolean delete_category(String shop) {//ī�װ� ��λ���
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("DELETE FROM menu_category WHERE mc_shop = ? ");
			pstmt.setString(1, shop); //ù��° ?�� ����
			
			pstmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false; //�α��� ����
	}
	public static int new_category(DTO_menu_category manager) {//ī�װ� �߰�
		try{
			   Connection con = getConnection();
			   PreparedStatement insert1 = con.prepareStatement(""
			     + "INSERT INTO menu_category"
			     + "(mc_category, mc_shop) "
			     + "VALUE "
			     + "('"+manager.get_mc_category()+"','"+manager.get_mc_shop()+"')");
			   insert1.executeUpdate();
			  }catch(Exception e){
			   System.out.println(e.getMessage());
			  }
		
		return 0;
	}
	public static int new_menu(DTO_menu_detail manager) {//�޴� �߰�
		try{
			   Connection con = getConnection();
			   PreparedStatement insert1 = con.prepareStatement(""
			     + "INSERT INTO menu_detail"
			     + "(md_name, md_category,md_price) "
			     + "VALUE "
			     + "('"+manager.get_md_name()+"','"+manager.get_md_category()+"','"+manager.get_md_price()+"')");
			   insert1.executeUpdate();
			  }catch(Exception e){
			   System.out.println(e.getMessage());
			  }
		
		return 0;
	}
	public ArrayList<String> get_category(String shop) {//ī�װ� �޾ƿ���
		conn = getConnection();
		ArrayList<String> temp=new ArrayList();
		try {
			pstmt = conn.prepareStatement("select * from menu_category where mc_shop = ? ");
			pstmt.setString(1, shop); //ù��° ?�� ����
			
			rs = pstmt.executeQuery();
			while(rs.next()) {//rs�� next�� ���� ������ ��ġ�Ѵٴ� ��		
				String category=rs.getString(1);
				temp.add(category);
			}
			return temp;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}
	public ArrayList<DTO_menu_detail> get_detail(String key) {//���� ���̺� ���� �޾ƿ���
		conn = getConnection();
		ArrayList<DTO_menu_detail> temp=new ArrayList();
		try {
			pstmt = conn.prepareStatement("select * from menu_detail where md_category = ? ");
			pstmt.setString(1, key); //ù��° ?�� ����
			
			rs = pstmt.executeQuery();
			while(rs.next()) {//rs�� next�� ���� ������ ��ġ�Ѵٴ� ��		
				DTO_menu_detail detail=new DTO_menu_detail(rs.getString(1),"",rs.getInt(3));
				temp.add(detail);
			}
			return temp;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}
	public static  Connection getConnection() {//DB�� ����
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/reservation";
			String user = "root";
			String pass = "12345678";//��й�ȣ ���� �ʿ�
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,pass);
			return con;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}

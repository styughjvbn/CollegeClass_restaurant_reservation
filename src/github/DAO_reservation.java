package github;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_reservation {
	private static Connection conn;
	private static ResultSet rs;
	private static PreparedStatement pstmt;

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
	public ArrayList<String> get_enable_time(String shop,String date,int table_num) {//���� ���̺� ���� �޾ƿ���
		conn = getConnection();
		ArrayList<String> temp=new ArrayList();
		try {
			pstmt = conn.prepareStatement("select rc_time from reservation_current where rc_shop = ? and rc_date = ? and rc_table = ?");
			pstmt.setString(1, shop); //ù��° ?�� ����
			pstmt.setString(2, date); //ù��° ?�� ����
			pstmt.setInt(3, table_num); //ù��° ?�� ����
			
			rs = pstmt.executeQuery();
			while(rs.next()) {//rs�� next�� ���� ������ ��ġ�Ѵٴ� ��
				temp.add(rs.getString(1));
			}
			return temp;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}
	public DTO_shop get_shop_info(String shop) {//���� ���� ��������
		conn = getConnection();
		DTO_shop temp;
		try {
			pstmt = conn.prepareStatement("select * from shop where shop_name = ? ");
			pstmt.setString(1, shop); //ù��° ?�� ����
			
			rs = pstmt.executeQuery();
			if(rs.next()) {//rs�� next�� ���� ������ ��ġ�Ѵٴ� ��
				temp=new DTO_shop(rs.getString(1),rs.getByte(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7));
				return temp;
			}
			return null;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null; //�α��� ����
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
	public static int new_reservation(DTO_reservation_current current) {//���� �߰�
		try{
			   Connection con = getConnection();
			   PreparedStatement insert1 = con.prepareStatement(""
			     + "INSERT INTO reservation_current"
			     + "(rc_id, rc_shop, rc_count, rc_time, rc_date, rc_money, rc_menu, rc_table) "
			     + "VALUE "
			     + "('"+current.get_rc_id()+"','"+current.get_rc_shop()+"','"+current.get_rc_count()+"','"+current.get_rc_time()+"','"+current.get_rc_date()+"','"+current.get_rc_money()+"','"+current.get_rc_menu()+"','"+current.get_rc_table()+"')");
			   insert1.executeUpdate();
			  }catch(Exception e){
			   System.out.println(e.getMessage());
			  }
		
		return 0;
	}
	public static  Connection getConnection() {//DB�� ����
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/reservation";
			String user = "root";
			String pass = "1q2w3e4r!";//��й�ȣ ���� �ʿ�
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,pass);
			return con;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}

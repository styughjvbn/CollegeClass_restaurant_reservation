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
			     + " shop_table_num = '"+manager.get_shop_table_num()+"'"
			     +" WHERE (shop_name = '"+manager.get_shop_name()+"');");
			   System.out.println(insert1);
			   insert1.executeUpdate();
			   System.out.println("The data has been saved!");
			  }catch(Exception e){
			   System.out.println(e.getMessage());
			  }
		
		return 0;
	}
	public static int new_table(DTO_manage_table manager) {//������ ���̺� ����
		try{
			   Connection con = getConnection();
			   PreparedStatement insert1 = con.prepareStatement(""
			     + "INSERT INTO manage_table"
			     + "(mt_table, mt_shop, mt_size, mt_x, mt_y) "
			     + "VALUE "
			     + "('"+manager.get_mt_table()+"','"+manager.get_mt_shop()+"','"+manager.get_mt_size()+"','"+manager.get_mt_x()+"','"+manager.get_mt_y()+"')");
			   insert1.executeUpdate();
			   System.out.println("The data has been saved!");
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
				System.out.println("�ҷ����� �Ϸ�");
			}
			return temp;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null; //�α��� ����
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
				System.out.println("�ҷ����� �Ϸ�");
			}
			return a;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null; //�α��� ����
	}
	public boolean delete_table(String shop) {//������ ���̺� ����
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

	public static  Connection getConnection() {//DB�� ����
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/reservation";
			String user = "root";
			String pass = "1q2w3e4r!";//��й�ȣ ���� �ʿ�
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,pass);
			System.out.println("The Connection successful");
			return con;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}

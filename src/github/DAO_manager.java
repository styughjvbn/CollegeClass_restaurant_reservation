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

	public static int update_shop(DTO_shop manager) {//점포 관리
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
	public static int new_table(DTO_manage_table manager) {//점포의 테이블 관리
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
	public ArrayList<int[]> get_table_info(String shop) {//점포 테이블 정보 받아오기
		conn = getConnection();
		ArrayList<int[]> temp=new ArrayList();
		try {
			pstmt = conn.prepareStatement("select * from manage_table where mt_shop = ? ");
			pstmt.setString(1, shop); //첫번째 ?에 넣음
			
			rs = pstmt.executeQuery();
			while(rs.next()) {//rs의 next에 값이 있으면 일치한다는 뜻
				int a[]=new int[4];
				a[0]=rs.getInt(1);
				a[1]=rs.getInt(3);
				a[2]=rs.getInt(4);
				a[3]=rs.getInt(5);
				temp.add(a);
				System.out.println("불러오기 완료");
			}
			return temp;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null; //로그인 실패
	}
	public int[] get_shop_info(String shop) {//점포 정보 가져오기
		conn = getConnection();
		int[] a=new int[4];
		try {
			pstmt = conn.prepareStatement("select * from shop where shop_name = ? ");
			pstmt.setString(1, shop); //첫번째 ?에 넣음
			
			rs = pstmt.executeQuery();
			if(rs.next()) {//rs의 next에 값이 있으면 일치한다는 뜻
				a[0]=rs.getInt(2);
				a[1]=rs.getInt(3);
				a[2]=rs.getInt(4);
				a[3]=rs.getInt(5);
				System.out.println("불러오기 완료");
			}
			return a;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null; //로그인 실패
	}
	public boolean delete_table(String shop) {//점포의 테이블 관리
		conn = getConnection();
		int[] a=new int[4];
		try {
			pstmt = conn.prepareStatement("DELETE FROM manage_table WHERE mt_shop = ? ");
			pstmt.setString(1, shop); //첫번째 ?에 넣음
			
			pstmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false; //로그인 실패
	}

	public static  Connection getConnection() {//DB와 연결
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/reservation";
			String user = "root";
			String pass = "1q2w3e4r!";//비밀번호 수정 필요
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

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
		return null; 
	}
	public DTO_shop get_shop_info(String shop) {//점포 정보 가져오기
		conn = getConnection();
		DTO_shop temp;
		try {
			pstmt = conn.prepareStatement("select * from shop where shop_name = ? ");
			pstmt.setString(1, shop); //첫번째 ?에 넣음
			
			rs = pstmt.executeQuery();
			if(rs.next()) {//rs의 next에 값이 있으면 일치한다는 뜻
				temp=new DTO_shop(rs.getString(1),rs.getByte(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7));
				return temp;
			}
			return null;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null; //로그인 실패
	}

	public static  Connection getConnection() {//DB와 연결
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/reservation";
			String user = "root";
			String pass = "11111111";//비밀번호 수정 필요
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

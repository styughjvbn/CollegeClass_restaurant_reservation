package github;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO_oldreservation {
	private static Connection conn;
	private static ResultSet rs;
	private static PreparedStatement pstmt;
	
	public static ArrayList<String []> getOldReservation(String shop){
		try {
			Connection conn = getConnection();
			pstmt = conn.prepareStatement("select * from reservation_old where shop = ?");
			pstmt.setString(1, shop);
			
			rs = pstmt.executeQuery();
			ArrayList<String []> list = new ArrayList<String[]>();
			while(rs.next()) {
				list.add(new String[] {
						rs.getString(1),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9)
				});
				
			}
			return list;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	public static ArrayList<String []> getCurrentReservation(String shop){
		try {
			Connection con = getConnection();
			pstmt = con.prepareStatement("select * from reservation_current where rc_shop = ?");
			pstmt.setString(1, shop);
			
			rs = pstmt.executeQuery();
			ArrayList<String []> list = new ArrayList<String[]>();

			while(rs.next()) {
				list.add(new String[] {
						rs.getString(1),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9)
				});
				
			}
			return list;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	public static  Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/reservation";
			String user = "root";
			String pass = "11111111";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,pass);
			return con;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
	
	
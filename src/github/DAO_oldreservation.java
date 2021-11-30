package github;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import github.DTO_shop;

public class DAO_oldreservation {
	private static Connection conn;
	private static ResultSet rs;
	private static PreparedStatement pstmt;
	public static String[][] getOldReservation(String shop){
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
			String [][] arr = new String[list.size()][8];
			return list.toArray(arr);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	public static String[][] getCurrentReservation(String shop){
		try {
			Connection con = getConnection();
			pstmt = con.prepareStatement("select * from reservation_current where shop = ?");
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
			String [][] arr = new String[list.size()][8];
			return list.toArray(arr);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
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
			}
			return temp;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}
	public ArrayList<String> get_enable_time(String shop,String date,int table_num) {//점포 테이블 정보 받아오기
		conn = getConnection();
		ArrayList<String> temp=new ArrayList();
		try {
			pstmt = conn.prepareStatement("select rc_time from reservation_current where rc_shop = ? and rc_date = ? and rc_table = ?");
			pstmt.setString(1, shop); //첫번째 ?에 넣음
			pstmt.setString(2, date); //첫번째 ?에 넣음
			pstmt.setInt(3, table_num); //첫번째 ?에 넣음
			
			rs = pstmt.executeQuery();
			while(rs.next()) {//rs의 next에 값이 있으면 일치한다는 뜻
				temp.add(rs.getString(1));
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

	public ArrayList<String> get_category(String shop) {//카테고리 받아오기
		conn = getConnection();
		ArrayList<String> temp=new ArrayList();
		try {
			pstmt = conn.prepareStatement("select * from menu_category where mc_shop = ? ");
			pstmt.setString(1, shop); //첫번째 ?에 넣음
			
			rs = pstmt.executeQuery();
			while(rs.next()) {//rs의 next에 값이 있으면 일치한다는 뜻		
				String category=rs.getString(1);
				temp.add(category);
			}
			return temp;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}
	public ArrayList<DTO_menu_detail> get_detail(String key) {//점포 테이블 정보 받아오기
		conn = getConnection();
		ArrayList<DTO_menu_detail> temp=new ArrayList();
		try {
			pstmt = conn.prepareStatement("select * from menu_detail where md_category = ? ");
			pstmt.setString(1, key); //첫번째 ?에 넣음
			
			rs = pstmt.executeQuery();
			while(rs.next()) {//rs의 next에 값이 있으면 일치한다는 뜻		
				DTO_menu_detail detail=new DTO_menu_detail(rs.getString(1),"",rs.getInt(3));
				temp.add(detail);
			}
			return temp;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}
	public static int new_reservation(DTO_reservation_current current) {//예약 추가
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
	public static int new_old_reservation(DTO_reservation_old old) {//이전 예약 추가
		try{
			   Connection con = getConnection();
			   PreparedStatement insert1 = con.prepareStatement(""
			     + "INSERT INTO reservation_old"
			     + "(id, shop, time, date, count, money, menu, age, gender) "
			     + "VALUE "
			     + "('"+old.get_id()+"','"+old.get_shop()+"','"+old.get_time()+"','"+old.get_date()+"','"+old.get_count()+"','"+old.get_money()+"','"+old.get_menu()+"','"+old.get_age()+"','"+old.get_gender()+"')");
			   System.out.println(insert1);
			   insert1.executeUpdate();
			  }catch(Exception e){
			   System.out.println(e.getMessage());
			  }
		
		return 0;
	}
	public static int delete_reservation(String ID,String shop,String time) {//예약 취소
		try{
			   Connection con = getConnection();
			   PreparedStatement insert1 = con.prepareStatement(""
			     + "DELETE FROM reservation_current WHERE (rc_id = '"
			     + ID
			     + "') and (rc_shop = '"
			     + shop
			     + "') and (rc_book_time = '"
			     + time
			     + "');");
			   insert1.executeUpdate();
			  }catch(Exception e){
			   System.out.println(e.getMessage());
			  }
		return 0;
	}
	public static int update_pw(String cnt_id,String new_pw) {//예약 추가
		try{
			   Connection con = getConnection();
			   PreparedStatement insert1 = con.prepareStatement(""
			     + "UPDATE customer SET"
			     + " customer_pw = '"
			     + new_pw
			     + "' WHERE (customer_id = '"
			     + cnt_id
			     + "');");
			   insert1.executeUpdate();
			   System.out.println(insert1);
			  }catch(Exception e){
			   System.out.println(e.getMessage());
			  }
		return 0;
	}
	public ArrayList<String[]> get_reservation_cnt(String id) {//점포 테이블 정보 받아오기
		conn = getConnection();
		ArrayList<String[]> temp=new ArrayList<String[]>();
		try {
			pstmt = conn.prepareStatement("select * from reservation_current where rc_id = ? ");
			pstmt.setString(1, id); //첫번째 ?에 넣음
			
			rs = pstmt.executeQuery();
			while(rs.next()) {//rs의 next에 값이 있으면 일치한다는 뜻	
				String[] reservation=new String[8];
				for(int i=0;i<8;i++) {
					reservation[i]=rs.getString(i+2);
				}
				temp.add(reservation);
			}
			return temp;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}
	public ArrayList<String[]> get_reservation_old(String id) {//점포 테이블 정보 받아오기
		conn = getConnection();
		ArrayList<String[]> temp=new ArrayList<String[]>();
		try {
			pstmt = conn.prepareStatement("select * from reservation_old where id = ? ");
			pstmt.setString(1, id); //첫번째 ?에 넣음
			
			rs = pstmt.executeQuery();
			while(rs.next()) {//rs의 next에 값이 있으면 일치한다는 뜻	
				String[] reservation=new String[6];
				for(int i=0;i<6;i++) {
					reservation[i]=rs.getString(i+2);
				}
				temp.add(reservation);
			}
			return temp;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}
	public int cnt_2_old(DTO_customer cnt_user) {//점포 테이블 정보 받아오기
		conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement("select * from reservation_current where rc_id='"
					+ cnt_user.get_ID()
					+"' and (rc_date >date_format(now(),'%Y-%m-%d') or (rc_date = date_format(now(),'%Y-%m-%d') and rc_time>time_format(now(),'%H:%i:%s')));");
			rs = pstmt.executeQuery();
			System.out.println(pstmt);
			while(rs.next()) {//rs의 next에 값이 있으면 일치한다는 뜻	
				new_old_reservation(new DTO_reservation_old(rs.getString(1),rs.getString(2),rs.getString(4),rs.getString(5),rs.getInt(3),rs.getInt(6),rs.getString(7),cnt_user.get_Age(),cnt_user.get_Gender()));	
			}
			pstmt = conn.prepareStatement("delete from reservation_current where rc_id='"
					+ cnt_user.get_ID()
					+"' and (rc_date >date_format(now(),'%Y-%m-%d') or (rc_date = date_format(now(),'%Y-%m-%d') and rc_time>time_format(now(),'%H:%i:%s')));");
			pstmt.executeUpdate();
			return 1;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0; 
	}
	public static  Connection getConnection() {//DB와 연결
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/reservation";
			String user = "root";
			String pass = "11111111";//비밀번호 수정 필요
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,pass);
			return con;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}

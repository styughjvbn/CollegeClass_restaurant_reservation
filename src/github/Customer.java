package github;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Customer {
	private static Connection conn;
	private static ResultSet rs;
	private static PreparedStatement pstmt;
	
	public static int manager_signup(String id,char[] pw,String HP,String shop) {//사장 회원가입
		String PW=new String(pw);
		try{
			   Connection con = getConnection();
			   PreparedStatement insert1 = con.prepareStatement(""
			     + "INSERT INTO manager"
			     + "(manager_id, manager_pw, manager_HP, manager_shop) "
			     + "VALUE "
			     + "('"+id+"','"+PW+"','"+HP+"','"+shop+"')");
			   insert1.executeUpdate();
			   System.out.println("The data has been saved!");
			  }catch(Exception e){
			   System.out.println(e.getMessage());
			  }
		
		return 0;
	}
	public static int customer_signup(String id,char[] pw,String Name,String Age, String Gender) {//고객 회원가입
		String PW=new String(pw);
		try{
			   Connection con = getConnection();
			   PreparedStatement insert1 = con.prepareStatement(""
			     + "INSERT INTO customer"
			     + "(idcode, pw, name, age, gender) " //customer DB 따로 만들던지 기존꺼 쓰던지 하면될듯
			     + "VALUE "
			     + "('"+id+"','"+PW+"','"+Name+"','"+Age+"','"+Gender+"')");
			   insert1.executeUpdate();
			   System.out.println("The data has been saved!");
			  }catch(Exception e){
			   System.out.println(e.getMessage());
			  }
		
		return 0;
	}
	public static int overlap_id(String id) {//중복확인
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("select * from manager where manager_id = ?");
			pstmt.setString(1, id); //첫번째 ?에 넣음
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //rs의 next에 값이 있으면 일치한다는 뜻
				return 1; //로그인 성공
			}
			else
				return 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	public static int overlap_id2customer(String id) {//고객 아이디 중복확인
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("select * from customer where idcode = ?");
			pstmt.setString(1, id); //첫번째 ?에 넣음
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //rs의 next에 값이 있으면 일치한다는 뜻
				return 1; //로그인 성공
			}
			else
				return 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	public static boolean login_manager(String idcode,String pw) {//사장 로그인
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("select * from manager where manager_id = ? and manager_pw= ? "); //db에서 idcode와 pw 테이블에 값이 존재하는지 확인
			pstmt.setString(1, idcode); //첫번째 ?에 넣음
			pstmt.setString(2, pw); //첫번째 ?에 넣음
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //rs의 next에 값이 있으면 일치한다는 뜻
				return true; //로그인 성공
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false; //로그인 실패
	}
	public static boolean login_customer(String idcode, String pw) {//고객 로그인
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("select * from customer where idcode = ? and pw = ?"); //db에서 idcode와 pw 테이블에 값이 존재하는지 확인
			pstmt.setString(1, idcode); //첫번째 ?에 넣음
			pstmt.setString(2, pw); //두번째 ?에 넣음
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //rs의 next에 값이 있으면 일치한다는 뜻
				return true; //로그인 성공
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false; //로그인 실패
	}

	public static ArrayList<String> getCustomers(){ //데이터를 db에서 불러옴, 실질적으로 쓰이진않지만 예시로 활용가능 db에서 데이터 불러오는 예시!
		  try{
		   Connection con = getConnection();
		   PreparedStatement statement = con.prepareStatement("Select name, phone, gender FROM customer");
		   ResultSet results = statement.executeQuery();//Query를 불러옴
		   ArrayList<String> list = new ArrayList<String>();
		   while(results.next()){
		    list.add("Name : "+ results.getString("name") +
		      " Phone "+ results.getString("phone") + 
		      " Gender : "+ results.getString("gender"));
		   }
		   System.out.println("The data has been fetched");
		   return list;
		   
		  }catch(Exception e){
		   System.out.println(e.getMessage());
		   return null;
		  }
		 }

	public static void createTable(){//고객 테이블이 존재하지 않는다면 만든다.
		  try{
		   Connection con = getConnection();
		   PreparedStatement create = con.prepareStatement(
		     "CREATE TABLE IF NOT EXISTS "
		     + "customer(id int NOT NULL AUTO_INCREMENT,"
		     + "name varChar(255),"
		     + "idcode varChar(255),"
		     + "gender varChar(255),"
		     + "PW varChar(255),"
		     + "Job varChar(255),"
		     + "PRIMARY KEY(id))");
		   create.execute();
		  }catch(Exception e){
		   System.out.println(e.getMessage());
		  }finally{
		   System.out.println("Table successfully created");
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
			System.out.println("The Connection successful");
			return con;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

}

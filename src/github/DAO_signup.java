package github;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_signup {
	private static Connection conn;
	private static ResultSet rs;
	private static PreparedStatement pstmt;
	
	public static int manager_signup(DTO_하루초밥 Haru) {//하루초밥 예약누르면 여기로 값이 들어감
		try{
			   Connection con = getConnection();
			   PreparedStatement insert1 = con.prepareStatement(""
			     + "INSERT INTO 하루초밥"
			     + "(r_name, r_peoplenum, r_time, r_table, r_date) "
			     + "VALUE "
			     + "('"+Haru.getr_name()+"','"+Haru.getr_peoplenum()+"','"+Haru.getr_time()+"','"+Haru.getr_table()+"','"+Haru.getr_date()+"')");
			   insert1.executeUpdate();
			   System.out.println("The data has been saved!");
			  }catch(Exception e){
			   System.out.println(e.getMessage());
			  }
		
		return 0;
	}
	public static int manager_signup(DTO_manager_login manager) {//사장 회원가입
		try{
			   Connection con = getConnection();
			   PreparedStatement insert1 = con.prepareStatement(""
			     + "INSERT INTO manager"
			     + "(manager_id, manager_pw, manager_HP, manager_shop) "
			     + "VALUE "
			     + "('"+manager.get_ID()+"','"+manager.get_PW()+"','"+manager.get_HP()+"','"+manager.get_Shop()+"')");
			   insert1.executeUpdate();
			   System.out.println("The data has been saved!");
			  }catch(Exception e){
			   System.out.println(e.getMessage());
			  }
		
		return 0;
	}
	public static int customer_signup(DTO_customer_login customer) {//고객 회원가입
		try{
			   Connection con = getConnection();
			   PreparedStatement insert1 = con.prepareStatement(""
			     + "INSERT INTO customer"
			     + "(customer_id, customer_pw, customer_hp, customer_gender, customer_name, customer_age) " //customer DB 따로 만들던지 기존꺼 쓰던지 하면될듯
			     + "VALUE "
			     + "('"+customer.get_ID()+"','"+customer.get_PW()+"','"+customer.get_HP()+"','"+customer.get_Gender()+"','"+customer.get_Name()+"','"+customer.get_Age()+"')");
			   insert1.executeUpdate();
			   System.out.println("The data has been saved!");
			  }catch(Exception e){
			   System.out.println(e.getMessage());
			  }
		
		return 0;
	}
	public static int overlap_id_manager(String id) {//중복확인
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("select * from manager where manager_id = ?");
			pstmt.setString(1, id); //첫번째 ?에 넣음
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //rs의 next에 값이 있으면 일치한다는 뜻
				return 1; //아이디 중복
			}
			else
				return 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	public static int overlap_id_customer(String id) {//고객 아이디 중복확인
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("select * from customer where customer_id = ?");
			pstmt.setString(1, id); //첫번째 ?에 넣음
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //rs의 next에 값이 있으면 일치한다는 뜻
				return 1; //아이디 중복
			}
			else
				return 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	public static boolean login_manager(DTO_manager_login manager) {//사장 로그인
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("select * from manager where manager_id = ? and manager_pw= ? "); //db에서 idcode와 pw 테이블에 값이 존재하는지 확인
			pstmt.setString(1, manager.get_ID()); //첫번째 ?에 넣음
			pstmt.setString(2, manager.get_PW()); //첫번째 ?에 넣음
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //rs의 next에 값이 있으면 일치한다는 뜻
				return true; //로그인 성공
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false; //로그인 실패
	}
	public static boolean login_customer(DTO_customer_login customer) {//고객 로그인
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("select * from customer where customer_id = ? and customer_pw = ?"); //db에서 idcode와 pw 테이블에 값이 존재하는지 확인
			pstmt.setString(1, customer.get_ID()); //첫번째 ?에 넣음
			pstmt.setString(2, customer.get_PW()); //두번째 ?에 넣음
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

	public static void create_customer_Table(){//고객 테이블이 존재하지 않는다면 만든다.
		  try{
		   Connection con = getConnection();
		   PreparedStatement create = con.prepareStatement(
		     "CREATE TABLE IF NOT EXISTS "
		     + "customer(customer_id VARCHAR(20) NOT NULL,"
		     + "customer_pw VARCHAR(20) NOT NULL,"
		     + "customer_hp VARCHAR(13) NOT NULL,"
		     + "customer_gender VARCHAR(5) NOT NULL,"
		     + "customer_name VARCHAR(10) NOT NULL,"
		     + "customer_age INT(30) UNSIGNED NOT NULL,"
		     + "PRIMARY KEY(customer_id), UNIQUE INDEX customer_id_UNIQUE (customer_id ASC) VISIBLE)");
		   create.execute();
		  }catch(Exception e){
		   System.out.println(e.getMessage());
		  }finally{
		   System.out.println("Table successfully created");
		  }
		 }
	public static void create_manager_Table(){//사장 테이블이 존재하지 않는다면 만든다.
		  try{
		   Connection con = getConnection();
		   PreparedStatement create = con.prepareStatement(
		     "CREATE TABLE IF NOT EXISTS "
		     + "manager(manager_id VARCHAR(20) NOT NULL,"
		     + "manager_pw VARCHAR(20) NOT NULL,"
		     + "manager_hp VARCHAR(13) NOT NULL,"
		     + "manager_shop VARCHAR(20) NOT NULL,"
		     + "PRIMARY KEY(manager_id), UNIQUE INDEX manager_id_UNIQUE (manager_id ASC) VISIBLE)");
		   create.execute();
		  }catch(Exception e){
		   System.out.println(e.getMessage());
		  }finally{
		   System.out.println("Table successfully created");
		  }
		 }
	public static void create_Haru_Table(){//하루초밥 테이블이 존재하지 않으면 만든다.
		  try{
		   Connection con = getConnection();
		   PreparedStatement create = con.prepareStatement(
		     "CREATE TABLE IF NOT EXISTS "
		     + "하루초밥(id하루초밥 VARCHAR(255) NOT NULL,"
		     + "r_name VARCHAR(255) NOT NULL,"
		     + "r_peoplenum VARCHAR(255) NOT NULL,"
		     + "r_time VARCHAR(255) NOT NULL,"
		     + "r_table VARCHAR(255) NOT NULL,"
		     + "r_date INT(30) UNSIGNED NOT NULL,"
		     + "PRIMARY KEY(id하루초밥), UNIQUE INDEX id하루초밥_UNIQUE (id하루초밥 ASC) VISIBLE)");
		   create.execute();
		  }catch(Exception e){
		   System.out.println(e.getMessage());
		  }finally{
		   System.out.println("Table successfully created");
		  }
		 }
	
	public static  Connection getConnection() {//DB와 연결
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/reservation";
			String user = "root";
<<<<<<< HEAD
			String pass = "1q2w3e4r!";//비밀번호 수정 필요
=======
			String pass = "@dhdldldhkdlwm2";//비밀번호 수정 필요
>>>>>>> ab868aa261f0b7891cf3e402b07c5ab485498bfe
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

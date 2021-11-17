package github;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class DB_connection {
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
			String url = "jdbc:mysql://localhost:3306/restaurant";
			String user = "root";
			String pass = "12345678";//비밀번호 수정 필요
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

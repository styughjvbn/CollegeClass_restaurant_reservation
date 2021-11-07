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
	public static void main(String[] args) {
		ArrayList<String>job = getJob();
		for(String item : job) {
			System.out.println(item);
		}
	}
	public static int login1(String idcode, String pw, String job) {
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("select * from customer where idcode = ? and pw = ? and Job = ?"); //db에서 idcode와 pw 테이블에 값이 존재하는지 확인
			pstmt.setString(1, idcode); //첫번째 ?에 넣음
			pstmt.setString(2, pw); //두번째 ?에 넣음
			pstmt.setString(3, job); //두번째 ?에 넣음
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //rs의 next에 값이 있으면 일치한다는 뜻
				return 1; //로그인 성공
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return -1; //로그인 실패
	}
	public static int login2(String idcode, String pw, String job) {
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("select * from customer where idcode = ? and pw = ? and Job = ?"); //db에서 idcode와 pw 테이블에 값이 존재하는지 확인
			pstmt.setString(1, idcode); //첫번째 ?에 넣음
			pstmt.setString(2, pw); //두번째 ?에 넣음
			pstmt.setString(3, job); //두번째 ?에 넣음
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //rs의 next에 값이 있으면 일치한다는 뜻
				return 1; //로그인 성공
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return -1; //로그인 실패
	}

	
	public static ArrayList<String> getJob(){ //직업을 불러오는 함수, 로그인 시에 쓰일것.
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Select Job FROM customer");
			ResultSet results = statement.executeQuery();
			ArrayList<String> job = new ArrayList<String>();
			while(results.next()) {
				job.add("Job : " + results.getString("Job"));
			}
			return job;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
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
	public static void createCustomer(String name, String idcode, String gender, String PW, String Job ){
		  try{
		   Connection con = getConnection();
		   PreparedStatement insert = con.prepareStatement(""
		     + "INSERT INTO customer"
		     + "(name, idcode, gender, PW, Job) "
		     + "VALUE "
		     + "('"+name+"','"+idcode+"','"+gender+"','"+PW+"','"+Job+"')");
		   insert.executeUpdate();
		   System.out.println("The data has been saved!");
		  }catch(Exception e){
		   System.out.println(e.getMessage());
		  }
		 }

	public static void createTable(){
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

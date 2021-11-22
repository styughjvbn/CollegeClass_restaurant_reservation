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
	
	public static int manager_signup(DTO_manager manager) {//사장 회원가입
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
	public static int new_shop(DTO_shop manager) {//새로운 점포 입점
		try{
			   Connection con = getConnection();
			   PreparedStatement insert1 = con.prepareStatement(""
			     + "INSERT INTO shop"
			     + "(shop_name, shop_address) "
			     + "VALUE "
			     + "('"+manager.get_shop_name()+"','"+manager.get_shop_address()+"')");
			   insert1.executeUpdate();
			   System.out.println("The data has been saved!");
			  }catch(Exception e){
			   System.out.println(e.getMessage());
			  }
		
		return 0;
	}
	public static int customer_signup(DTO_customer customer) {//고객 회원가입
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
	public DTO_manager login_manager(DTO_manager manager) {//사장 로그인
		DTO_manager temp;
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("select * from manager where manager_id = ? and manager_pw= ? "); //db에서 idcode와 pw 테이블에 값이 존재하는지 확인
			pstmt.setString(1, manager.get_ID()); //첫번째 ?에 넣음
			pstmt.setString(2, manager.get_PW()); //첫번째 ?에 넣음
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //rs의 next에 값이 있으면 일치한다는 뜻
				System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4));
				return new DTO_manager(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));//로그인 성공
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null; //로그인 실패
	}
	public static boolean login_customer(DTO_customer customer) {//고객 로그인
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

	public static void create_customer_Table(){
		  try{
		   Connection con = getConnection();
		   PreparedStatement create = con.prepareStatement(
		     "CREATE TABLE IF NOT EXISTS customer ("
		     + "  customer_id VARCHAR(20) NOT NULL,"
		     + "  customer_pw VARCHAR(20) NOT NULL,"
		     + "  customer_hp VARCHAR(11) NOT NULL,"
		     + "  customer_gender TINYINT UNSIGNED NOT NULL,"
		     + "  customer_name VARCHAR(10) NOT NULL,"
		     + "  customer_age TINYINT UNSIGNED NOT NULL,"
		     + "  customer_money MEDIUMINT UNSIGNED NULL DEFAULT '0',"
		     + "  PRIMARY KEY (customer_id),"
		     + "  UNIQUE INDEX customer_id_UNIQUE (customer_id ASC) VISIBLE);");
		   create.execute();
		   System.out.println("Table successfully created");
		  }catch(Exception e){
		   System.out.println(e.getMessage());
		   }
		 }
	public static void create_shop_Table(){
		  try{
		   Connection con = getConnection();
		   PreparedStatement create = con.prepareStatement(
		     "CREATE TABLE IF NOT EXISTS shop (\r\n"
		     + "  shop_name VARCHAR(20) NOT NULL,\r\n"
		     + "  shop_holyday TINYINT UNSIGNED NULL DEFAULT '0',\r\n"
		     + "  shop_open TINYINT UNSIGNED NULL DEFAULT '8',\r\n"
		     + "  shop_close TINYINT UNSIGNED NULL DEFAULT '22',\r\n"
		     + "  shop_table_num TINYINT UNSIGNED NULL DEFAULT '0',\r\n"
		     + "  shop_address VARCHAR(45) NOT NULL,\r\n"
		     + "  PRIMARY KEY (shop_name));");
		   create.execute();
		   System.out.println("Table successfully created");
		  }catch(Exception e){
		   System.out.println(e.getMessage());
		   }
		 }
	public static void create_manage_table_Table(){
		  try{
		   Connection con = getConnection();
		   PreparedStatement create = con.prepareStatement(
		     "CREATE TABLE IF NOT EXISTS manage_table (\r\n"
		     + "  mt_table TINYINT UNSIGNED NOT NULL,\r\n"
		     + "  mt_shop VARCHAR(20) NOT NULL,\r\n"
		     + "  mt_size TINYINT UNSIGNED NOT NULL,\r\n"
		     + "  mt_x SMALLINT NOT NULL,\r\n"
		     + "  mt_y SMALLINT NOT NULL,\r\n"
		     + "  PRIMARY KEY (mt_table, mt_shop),\r\n"
		     + "  INDEX shop_idx (mt_shop ASC) VISIBLE,\r\n"
		     + "  CONSTRAINT mt_table\r\n"
		     + "    FOREIGN KEY (mt_shop)\r\n"
		     + "    REFERENCES shop (shop_name)\r\n"
		     + "    ON DELETE CASCADE\r\n"
		     + "    ON UPDATE CASCADE);");
		   create.execute();
		   System.out.println("Table successfully created");
		  }catch(Exception e){
		   System.out.println(e.getMessage());
		   }
		 }
	public static void create_manager_Table() {
		  try{
		   Connection con = getConnection();
		   PreparedStatement create = con.prepareStatement(
		     "CREATE TABLE IF NOT EXISTS manager (\r\n"
		     + "  manager_id VARCHAR(20) NOT NULL,\r\n"
		     + "  manager_pw VARCHAR(20) NOT NULL,\r\n"
		     + "  manager_hp VARCHAR(13) NOT NULL,\r\n"
		     + "  manager_shop VARCHAR(20) NOT NULL,\r\n"
		     + "  PRIMARY KEY (manager_id),\r\n"
		     + "  UNIQUE INDEX manager_id_UNIQUE (manager_id ASC) VISIBLE,\r\n"
		     + "  INDEX shop_name_idx (manager_shop ASC) VISIBLE,\r\n"
		     + "  CONSTRAINT shop_name\r\n"
		     + "    FOREIGN KEY (manager_shop)\r\n"
		     + "    REFERENCES shop (shop_name)\r\n"
		     + "    ON DELETE CASCADE\r\n"
		     + "    ON UPDATE CASCADE);");
		   create.execute();
		   System.out.println("Table successfully created");
		  }catch(Exception e){
		   System.out.println(e.getMessage());
		   }
		 }
	public static void create_menu_category_Table(){
		  try{
		   Connection con = getConnection();
		   PreparedStatement create = con.prepareStatement(
		     "CREATE TABLE IF NOT EXISTS menu_category (\r\n"
		     + "  mc_category VARCHAR(20) NOT NULL,\r\n"
		     + "  mc_shop VARCHAR(20) NOT NULL,\r\n"
		     + "  PRIMARY KEY (mc_category, mc_shop),\r\n"
		     + "  INDEX mc_shop_idx (mc_shop ASC) VISIBLE,\r\n"
		     + "  CONSTRAINT mc_shop\r\n"
		     + "    FOREIGN KEY (mc_shop)\r\n"
		     + "    REFERENCES shop (shop_name)\r\n"
		     + "    ON DELETE CASCADE\r\n"
		     + "    ON UPDATE CASCADE);");
		   create.execute();
		   System.out.println("Table successfully created");
		  }catch(Exception e){
		   System.out.println(e.getMessage());
		   }
		 }
	public static void create_menu_detail_Table(){
		  try{
		   Connection con = getConnection();
		   PreparedStatement create = con.prepareStatement(
		     "CREATE TABLE IF NOT EXISTS menu_detail (\r\n"
		     + "  md_name VARCHAR(20) NOT NULL,\r\n"
		     + "  md_category VARCHAR(20) NOT NULL,\r\n"
		     + "  md_price MEDIUMINT UNSIGNED NOT NULL,\r\n"
		     + "  PRIMARY KEY (md_name),\r\n"
		     + "  INDEX md_category_idx (md_category ASC) VISIBLE,\r\n"
		     + "  CONSTRAINT md_category\r\n"
		     + "    FOREIGN KEY (md_category)\r\n"
		     + "    REFERENCES menu_category (mc_category)\r\n"
		     + "    ON DELETE CASCADE\r\n"
		     + "    ON UPDATE CASCADE);");
		   create.execute();
		   System.out.println("Table successfully created");
		  }catch(Exception e){
		   System.out.println(e.getMessage());
		   }
		 }
	public static void create_reservation_current_Table(){
		  try{
		   Connection con = getConnection();
		   PreparedStatement create = con.prepareStatement(
		     "CREATE TABLE IF NOT EXISTS reservation_current (\r\n"
		     + "  rc_id VARCHAR(20) NOT NULL,\r\n"
		     + "  rc_shop VARCHAR(20) NOT NULL,\r\n"
		     + "  rc_count TINYINT UNSIGNED NOT NULL,\r\n"
		     + "  rc_time TIME NOT NULL,\r\n"
		     + "  rc_date DATE NOT NULL,\r\n"
		     + "  rc_money MEDIUMINT UNSIGNED NOT NULL,\r\n"
		     + "  rc_menu VARCHAR(100) NOT NULL,\r\n"
		     + "  rc_table TINYINT UNSIGNED NOT NULL,\r\n"
		     + "  PRIMARY KEY (rc_id, rc_shop),\r\n"
		     + "  INDEX rc_ahop_idx (rc_shop ASC) VISIBLE,\r\n"
		     + "  INDEX rc_table_idx (rc_table ASC) VISIBLE,\r\n"
		     + "  CONSTRAINT rc_id\r\n"
		     + "    FOREIGN KEY (rc_id)\r\n"
		     + "    REFERENCES customer (customer_id)\r\n"
		     + "    ON DELETE CASCADE\r\n"
		     + "    ON UPDATE CASCADE,\r\n"
		     + "  CONSTRAINT rc_shop\r\n"
		     + "    FOREIGN KEY (rc_shop)\r\n"
		     + "    REFERENCES shop (shop_name)\r\n"
		     + "    ON DELETE CASCADE\r\n"
		     + "    ON UPDATE CASCADE,\r\n"
		     + "  CONSTRAINT rc_table\r\n"
		     + "    FOREIGN KEY (rc_table)\r\n"
		     + "    REFERENCES manage_table (mt_table)\r\n"
		     + "    ON DELETE CASCADE\r\n"
		     + "    ON UPDATE CASCADE);");
		   create.execute();
		   System.out.println("Table successfully created");
		  }catch(Exception e){
		   System.out.println(e.getMessage());
		   }
		 }
	public static void create_reservation_old_Table() {
		  try{
		   Connection con = getConnection();
		   PreparedStatement create = con.prepareStatement(
		     "CREATE TABLE IF NOT EXISTS reservation_old (\r\n"
		     + "  id VARCHAR(20) NOT NULL,\r\n"
		     + "  shop VARCHAR(20) NOT NULL,\r\n"
		     + "  time TIME NOT NULL,\r\n"
		     + "  date DATE NOT NULL,\r\n"
		     + "  count TINYINT UNSIGNED NOT NULL,\r\n"
		     + "  money MEDIUMINT UNSIGNED NOT NULL,\r\n"
		     + "  menu VARCHAR(100) NOT NULL,\r\n"
		     + "  age TINYINT UNSIGNED NOT NULL,\r\n"
		     + "  gender TINYINT UNSIGNED NOT NULL,\r\n"
		     + "  PRIMARY KEY (id, shop));");
		   create.execute();
		   System.out.println("Table successfully created");
		  }catch(Exception e){
		   System.out.println(e.getMessage());
		   }
		 }
	public static void init(){//DB생성
		create_customer_Table();
		create_shop_Table();
		create_manage_table_Table();
		create_manager_Table();
		create_menu_category_Table();
		create_menu_detail_Table();
		create_reservation_current_Table();
		create_reservation_old_Table();
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

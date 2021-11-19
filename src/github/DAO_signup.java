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
	
	public static int manager_signup(DTO_�Ϸ��ʹ� Haru) {//�Ϸ��ʹ� ���ഩ���� ����� ���� ��
		try{
			   Connection con = getConnection();
			   PreparedStatement insert1 = con.prepareStatement(""
			     + "INSERT INTO �Ϸ��ʹ�"
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
	public static int manager_signup(DTO_manager_login manager) {//���� ȸ������
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
	public static int customer_signup(DTO_customer_login customer) {//�� ȸ������
		try{
			   Connection con = getConnection();
			   PreparedStatement insert1 = con.prepareStatement(""
			     + "INSERT INTO customer"
			     + "(customer_id, customer_pw, customer_hp, customer_gender, customer_name, customer_age) " //customer DB ���� ������� ������ ������ �ϸ�ɵ�
			     + "VALUE "
			     + "('"+customer.get_ID()+"','"+customer.get_PW()+"','"+customer.get_HP()+"','"+customer.get_Gender()+"','"+customer.get_Name()+"','"+customer.get_Age()+"')");
			   insert1.executeUpdate();
			   System.out.println("The data has been saved!");
			  }catch(Exception e){
			   System.out.println(e.getMessage());
			  }
		
		return 0;
	}
	public static int overlap_id_manager(String id) {//�ߺ�Ȯ��
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("select * from manager where manager_id = ?");
			pstmt.setString(1, id); //ù��° ?�� ����
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //rs�� next�� ���� ������ ��ġ�Ѵٴ� ��
				return 1; //���̵� �ߺ�
			}
			else
				return 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	public static int overlap_id_customer(String id) {//�� ���̵� �ߺ�Ȯ��
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("select * from customer where customer_id = ?");
			pstmt.setString(1, id); //ù��° ?�� ����
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //rs�� next�� ���� ������ ��ġ�Ѵٴ� ��
				return 1; //���̵� �ߺ�
			}
			else
				return 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	public static boolean login_manager(DTO_manager_login manager) {//���� �α���
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("select * from manager where manager_id = ? and manager_pw= ? "); //db���� idcode�� pw ���̺� ���� �����ϴ��� Ȯ��
			pstmt.setString(1, manager.get_ID()); //ù��° ?�� ����
			pstmt.setString(2, manager.get_PW()); //ù��° ?�� ����
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //rs�� next�� ���� ������ ��ġ�Ѵٴ� ��
				return true; //�α��� ����
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false; //�α��� ����
	}
	public static boolean login_customer(DTO_customer_login customer) {//�� �α���
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("select * from customer where customer_id = ? and customer_pw = ?"); //db���� idcode�� pw ���̺� ���� �����ϴ��� Ȯ��
			pstmt.setString(1, customer.get_ID()); //ù��° ?�� ����
			pstmt.setString(2, customer.get_PW()); //�ι�° ?�� ����
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //rs�� next�� ���� ������ ��ġ�Ѵٴ� ��
				return true; //�α��� ����
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false; //�α��� ����
	}

	public static ArrayList<String> getCustomers(){ //�����͸� db���� �ҷ���, ���������� ������������ ���÷� Ȱ�밡�� db���� ������ �ҷ����� ����!
		  try{
		   Connection con = getConnection();
		   PreparedStatement statement = con.prepareStatement("Select name, phone, gender FROM customer");
		   ResultSet results = statement.executeQuery();//Query�� �ҷ���
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

	public static void create_customer_Table(){//�� ���̺��� �������� �ʴ´ٸ� �����.
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
	public static void create_manager_Table(){//���� ���̺��� �������� �ʴ´ٸ� �����.
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
	public static void create_Haru_Table(){//�Ϸ��ʹ� ���̺��� �������� ������ �����.
		  try{
		   Connection con = getConnection();
		   PreparedStatement create = con.prepareStatement(
		     "CREATE TABLE IF NOT EXISTS "
		     + "�Ϸ��ʹ�(id�Ϸ��ʹ� VARCHAR(255) NOT NULL,"
		     + "r_name VARCHAR(255) NOT NULL,"
		     + "r_peoplenum VARCHAR(255) NOT NULL,"
		     + "r_time VARCHAR(255) NOT NULL,"
		     + "r_table VARCHAR(255) NOT NULL,"
		     + "r_date INT(30) UNSIGNED NOT NULL,"
		     + "PRIMARY KEY(id�Ϸ��ʹ�), UNIQUE INDEX id�Ϸ��ʹ�_UNIQUE (id�Ϸ��ʹ� ASC) VISIBLE)");
		   create.execute();
		  }catch(Exception e){
		   System.out.println(e.getMessage());
		  }finally{
		   System.out.println("Table successfully created");
		  }
		 }
	
	public static  Connection getConnection() {//DB�� ����
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/reservation";
			String user = "root";
<<<<<<< HEAD
			String pass = "1q2w3e4r!";//��й�ȣ ���� �ʿ�
=======
			String pass = "@dhdldldhkdlwm2";//��й�ȣ ���� �ʿ�
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

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
	
	public static int manager_signup(String id,char[] pw,String HP,String shop) {//���� ȸ������
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
	public static int customer_signup(String id,char[] pw,String Name,String Age, String Gender) {//�� ȸ������
		String PW=new String(pw);
		try{
			   Connection con = getConnection();
			   PreparedStatement insert1 = con.prepareStatement(""
			     + "INSERT INTO customer"
			     + "(idcode, pw, name, age, gender) " //customer DB ���� ������� ������ ������ �ϸ�ɵ�
			     + "VALUE "
			     + "('"+id+"','"+PW+"','"+Name+"','"+Age+"','"+Gender+"')");
			   insert1.executeUpdate();
			   System.out.println("The data has been saved!");
			  }catch(Exception e){
			   System.out.println(e.getMessage());
			  }
		
		return 0;
	}
	public static int overlap_id(String id) {//�ߺ�Ȯ��
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("select * from manager where manager_id = ?");
			pstmt.setString(1, id); //ù��° ?�� ����
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //rs�� next�� ���� ������ ��ġ�Ѵٴ� ��
				return 1; //�α��� ����
			}
			else
				return 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	public static int overlap_id2customer(String id) {//�� ���̵� �ߺ�Ȯ��
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("select * from customer where idcode = ?");
			pstmt.setString(1, id); //ù��° ?�� ����
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //rs�� next�� ���� ������ ��ġ�Ѵٴ� ��
				return 1; //�α��� ����
			}
			else
				return 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	public static boolean login_manager(String idcode,String pw) {//���� �α���
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("select * from manager where manager_id = ? and manager_pw= ? "); //db���� idcode�� pw ���̺� ���� �����ϴ��� Ȯ��
			pstmt.setString(1, idcode); //ù��° ?�� ����
			pstmt.setString(2, pw); //ù��° ?�� ����
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //rs�� next�� ���� ������ ��ġ�Ѵٴ� ��
				return true; //�α��� ����
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false; //�α��� ����
	}
	public static boolean login_customer(String idcode, String pw) {//�� �α���
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("select * from customer where idcode = ? and pw = ?"); //db���� idcode�� pw ���̺� ���� �����ϴ��� Ȯ��
			pstmt.setString(1, idcode); //ù��° ?�� ����
			pstmt.setString(2, pw); //�ι�° ?�� ����
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

	public static void createTable(){//�� ���̺��� �������� �ʴ´ٸ� �����.
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

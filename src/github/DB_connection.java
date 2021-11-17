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
			String url = "jdbc:mysql://localhost:3306/restaurant";
			String user = "root";
			String pass = "12345678";//��й�ȣ ���� �ʿ�
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

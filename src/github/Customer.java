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
			pstmt = conn.prepareStatement("select * from customer where idcode = ? and pw = ? and Job = ?"); //db���� idcode�� pw ���̺� ���� �����ϴ��� Ȯ��
			pstmt.setString(1, idcode); //ù��° ?�� ����
			pstmt.setString(2, pw); //�ι�° ?�� ����
			pstmt.setString(3, job); //�ι�° ?�� ����
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //rs�� next�� ���� ������ ��ġ�Ѵٴ� ��
				return 1; //�α��� ����
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return -1; //�α��� ����
	}
	public static int login2(String idcode, String pw, String job) {
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement("select * from customer where idcode = ? and pw = ? and Job = ?"); //db���� idcode�� pw ���̺� ���� �����ϴ��� Ȯ��
			pstmt.setString(1, idcode); //ù��° ?�� ����
			pstmt.setString(2, pw); //�ι�° ?�� ����
			pstmt.setString(3, job); //�ι�° ?�� ����
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //rs�� next�� ���� ������ ��ġ�Ѵٴ� ��
				return 1; //�α��� ����
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return -1; //�α��� ����
	}

	
	public static ArrayList<String> getJob(){ //������ �ҷ����� �Լ�, �α��� �ÿ� ���ϰ�.
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

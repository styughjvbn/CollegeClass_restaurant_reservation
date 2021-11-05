package github;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;





public class Customer {

	public static ArrayList<String> getCustomers(){
		  try{
		   Connection con = getConnection();
		   PreparedStatement statement = con.prepareStatement("Select name, phone, gender FROM customer");
		   ResultSet results = statement.executeQuery();
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
	public static void createCustomer(String name, String phone, String gender, String age, String Job ){
		  try{
		   Connection con = getConnection();
		   PreparedStatement insert = con.prepareStatement(""
		     + "INSERT INTO customer"
		     + "(name, phone, gender, age, Job) "
		     + "VALUE "
		     + "('"+name+"','"+phone+"','"+gender+"','"+age+"','"+Job+"')");
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
		     + "phone varChar(255),"
		     + "gender varChar(255),"
		     + "age varChar(255),"
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
			String pass = "12345678";
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

package gunnuuu.dankook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Customer {
	/*public static void main(String[] args) {
		createTable();
		creatCustomer("Park","01055916593","Male","23","DanKook University..");
		ArrayList<String> list = getCustomers();
		for(String item:list) {
			System.out.println(item);
		}
	}*/
	
	public static String [][] getCustomers(){
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Select name, phone, gender, age, note FROM customer");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<>();
			while(results.next()) {
				list.add(new String[] {
						results.getString("name"),
						results.getString("phone"),
						results.getString("gender"),
						results.getString("age"),
						results.getString("note")
				});
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
				return null;
		}
	}
	
	public static void creatCustomer(String name, String phone, String gender, String age, String note) {
		try {
			Connection con = getConnection();	
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO customer"
					+ "(name, phone, gender, age, note) "
					+ "VALUE "
					+ "('"+name+"','"+phone+"','"+gender+"','"+age+"','"+note+"')");
			insert.executeUpdate();
			System.out.println("The data has been saved!");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void createTable() {
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
					+ "customer(id int NOT NULL AUTO_INCREMENT,"
					+ "name varChar(255),"
					+ "phone varChar(255),"
					+ "gender varChar(255),"
					+ "age varChar(255),"
					+ "note varChar(255),"
					+ "PRIMARY KEY(id))");
			create.execute();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			System.out.println("Table successfully created");
		}
	}
	
	public static Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6512600";
			String user = "sql6512600";
			String pass = "MvGgJfTB8t";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,pass);
			System.out.println("The Connection Successful");
			return con;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return(null);
		}
	}
	
}

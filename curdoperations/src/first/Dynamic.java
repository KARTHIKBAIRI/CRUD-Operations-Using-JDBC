package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Dynamic {

//	Driver Loading
	public static final String  Driver = "com.mysql.cj.jdbc.Driver";
	public static final String  username = "root";
	public static final String  password = "Karthikb@11";
	public static final String  url = "jdbc:mysql://localhost:3306/";
//	connection establish
	public static Connection conn;
//	prepare statement
	public static PreparedStatement pmst;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
//			Driver Loading
			Class.forName(Driver);
//			connection establish
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter database name");
//			query creating
			String sql = "drop database "+sc.next();
			pmst = conn.prepareStatement(sql);
//			executeQuery for retreiving data from database
			int i = pmst.executeUpdate();
			if(i==0) {
				System.out.println("Successfully created");
			}
			else {
				System.out.println("Error");
			}
			pmst.close();
			conn.close();
			sc.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}

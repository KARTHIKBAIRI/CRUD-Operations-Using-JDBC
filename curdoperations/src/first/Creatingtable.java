package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Creatingtable {
	public static final String  Driver = "com.mysql.cj.jdbc.Driver";
	public static final String  username = "root";
	public static final String  password = "Karthik";
	public static final String  url = "jdbc:mysql://localhost:3306/demo";
	public static Connection conn;
//	prepare statement
	public static PreparedStatement pmst;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter table name");
			String sql = "create table "+ sc.next() + "(id int,name varchar(30),email varchar(40))";
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i==0) {
				System.out.println("Successfully inserted");
			}
			else {
				System.out.println(" error ");
			}
			pmst.close();
			conn.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

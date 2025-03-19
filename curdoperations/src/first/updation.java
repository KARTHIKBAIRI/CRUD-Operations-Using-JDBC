package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class updation {
	public static final String  Driver = "com.mysql.cj.jdbc.Driver";
	public static final String  username = "root";
	public static final String  password = "Karthik";
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter database name");
			String  url = "jdbc:mysql://localhost:3306/"+sc.next();
			Class.forName(Driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("enter table name");
			String sql = "update "+sc.next()+" set name=?,email=? where id = ?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			System.out.println("Enter name");
			pmst.setString(1, sc.next());
			System.out.println("enter email");
			pmst.setString(2, sc.next());
			System.out.println("enter id");
			pmst.setInt(3, sc.nextInt());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("Data updated successfully");
			}
			else {
				System.out.println("check the connection");
			}
			pmst.close();
			conn.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

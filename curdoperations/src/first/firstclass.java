package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class firstclass {

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "Karthik");
			String sql = "create database emp";
			PreparedStatement pmst = (PreparedStatement) conn.prepareStatement(sql);
			int i=pmst.executeUpdate();
			if(i>0) {
				System.out.println("successfully created");
			}
			else {
				System.out.println("Error");
			}
			conn.close();
			pmst.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

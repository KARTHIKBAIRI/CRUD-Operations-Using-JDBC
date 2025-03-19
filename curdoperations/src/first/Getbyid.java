package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Getbyid {
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
			String sql = "select * from employee where emp_id = ? ";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter employee id");
			pmst.setInt(1,sc.nextInt());
			ResultSet rs = pmst.executeQuery();
			while(rs.next()) {
				System.out.println("emp_id"+ rs.getInt("emp_id")+
						"emp_name" + rs.getString("emp_name")+ "emp_email"+ rs.getString("emp_email"));
			}
			pmst.close();
			conn.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

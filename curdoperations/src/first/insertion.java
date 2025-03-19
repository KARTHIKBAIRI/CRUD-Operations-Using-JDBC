package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insertion {
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
			String sql = "insert into employee(emp_id,emp_name,emp_email) values (?,?,?)";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter employee id");
			pmst.setInt(1, sc.nextInt());
			System.out.println("Enter employee name");
			pmst.setString(2, sc.next());
			System.out.println("Enter employee mail");
			pmst.setString(3, sc.next());
			int i = pmst.executeUpdate();
			if(i>0) {
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

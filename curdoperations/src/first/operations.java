package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class operations {
	public static final String  Driver = "com.mysql.cj.jdbc.Driver";
	public static final String  username = "root";
	public static final String  password = "Karthikb@11";
	public static final String  url = "jdbc:mysql://localhost:3306/demo";
	public static Connection conn;
//	prepare statement
	public static PreparedStatement pmst;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			display();
				System.out.println("enter your choice");
				ch = Integer.parseInt(sc.nextLine());
				switch(ch){
					case 1 : createdatabase();
					break;
					case 2 : createtable();
					break;
					case 3 : insertion();
					break;
					case 4 : deletion();
					break;
					case 5 : getall();
					break;
					case 6 : getbyid();
					break;
					case 7 : droptable();
					break;
					case 8 : dropdatabase();
					break;
					case 9 : System.exit(0);
					break;
					default : System.out.println("invalid operation");
				}
				
		}while(ch>0);
	}

	private static void dropdatabase() {
		Scanner sc =new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/";
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("enter database name");
			String sql = "drop database "+sc.next();
			pmst = conn.prepareStatement(sql);
			int i= pmst.executeUpdate();
			if(i==0) {
				System.out.println("Successfully deleted");
			}
			else {
				System.out.println(" error ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void droptable() {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/Demo";
		// TODO Auto-generated method stub
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter table name");
			String sql = "drop table "+ sc.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i==0) {
				System.out.println("Successfully table deleted");
			}
			else {
				System.out.println(" error ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}

	private static void getbyid() {
		Scanner sc = new Scanner(System.in);
		String  url = "jdbc:mysql://localhost:3306/demo";
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void getall() {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/demo";
		// TODO Auto-generated method stub
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter table name");
			String sql = "select * from "+ sc.next();
			pmst = conn.prepareStatement(sql);
//			System.out.println("Enter table name");
//			pmst.setString(1, sc.next());
			ResultSet rs = pmst.executeQuery();
			while(rs.next()) {
				System.out.println("emp_id"+ rs.getInt("emp_id")+
						"emp_name" + rs.getString("emp_name")+ "emp_email"+ rs.getString("emp_email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	private static void deletion() {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/demo";
		// TODO Auto-generated method stub
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			String sql = "delete from employee where emp_id=?";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter employee id");
			pmst.setInt(1, sc.nextInt());
			int i = pmst.executeUpdate();
			if(i>0) {
				System.out.println("Successfully deleted");
			}
			else {
				System.out.println(" error ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	private static void insertion() {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/demo";
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
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	private static void createtable() {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/Demo";
		// TODO Auto-generated method stub
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter table name");
			String sql = "create table "+ sc.next() + "(id int,name varchar(30),email varchar(40))";
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if(i==0) {
				System.out.println("Successfully created");
			}
			else {
				System.out.println(" error ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	private static void createdatabase() {
		Scanner sc =new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/";
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("enter database name");
			String sql = "create database "+sc.next();
			pmst = conn.prepareStatement(sql);
			int i= pmst.executeUpdate();
			if(i>0) {
				System.out.println("Successfully created");
			}
			else {
				System.out.println(" error ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	private static void display() {
		System.out.println("Curd operations");
		System.out.println("\t1 .create database");
		System.out.println("\t2 .create table");
		System.out.println("\t3 .insertion");
		System.out.println("\t4 .Deletion");
		System.out.println("\t5 .get all records");
		System.out.println("\t6 .get record by id");
		System.out.println("\t7 .delete table");
		System.out.println("\t8 .delete database");
		System.out.println("\t9 .terminate process");
	}
}

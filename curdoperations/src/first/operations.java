package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class operations {
	public static final String Driver = "com.mysql.cj.jdbc.Driver";
	public static final String username = "root";
	public static final String password = "Karthikb@11";
	public static final String url = "jdbc:mysql://localhost:3306/";
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
			switch (ch) {
			case 1:
				createdatabase();
				break;
			case 2:
				createtable();
				break;
			case 3:
				insertion();
				break;
			case 4:
				deletion();
				break;
			case 5:
				getall();
				break;
			case 6:
				getbyid();
				break;
			case 7:
				droptable();
				break;
			case 8:
				dropdatabase();
				break;
			case 9:
				updation();
				break;
			case 10:
				System.exit(0);
				break;
			default:
				System.out.println("invalid operation");
			}

		} while (ch > 0);
	}

	private static void createdatabase() {
		try {
			Scanner sc = new Scanner(System.in);
			String url = "jdbc:mysql://localhost:3306/";
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("enter database name");
			String sql = "create database " + sc.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if (i > 0) {
				System.out.println("Successfully created");
			} else {
				System.out.println(" error ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createtable() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter database name");
			String  url = "jdbc:mysql://localhost:3306/"+sc.next();
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter table name");
			String sql = "create table " + sc.next() + "(id int,name varchar(30),email varchar(40))";
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if (i == 0) {
				System.out.println("Successfully created");
			} else {
				System.out.println(" error ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void insertion() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter database name");
			String  url = "jdbc:mysql://localhost:3306/"+sc.next();
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("enter table name");
			String sql = "insert into "+sc.next()+" (id,name,email) values (?,?,?)";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter id");
			pmst.setInt(1, sc.nextInt());
			System.out.println("Enter name");
			pmst.setString(2, sc.next());
			System.out.println("Enter mail");
			pmst.setString(3, sc.next());
			int i = pmst.executeUpdate();
			if (i > 0) {
				System.out.println("Successfully inserted");
			} else {
				System.out.println(" error ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void deletion() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter database name");
			String  url = "jdbc:mysql://localhost:3306/"+sc.next();
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("enter table name");
			String sql = "delete from "+sc.next() +" where id=?";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter id");
			pmst.setInt(1, sc.nextInt());
			int i = pmst.executeUpdate();
			if (i > 0) {
				System.out.println("Successfully deleted");
			} else {
				System.out.println(" error ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void getall() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter database name");
			String  url = "jdbc:mysql://localhost:3306/"+sc.next();
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter table name");
			String sql = "select * from " + sc.next();
			pmst = conn.prepareStatement(sql);
			ResultSet rs = pmst.executeQuery();
			while (rs.next()) {
				System.out.println("id : " + rs.getInt("id") + " name : " + rs.getString("name") + " email : "
						+ rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void getbyid() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter database name");
			String  url = "jdbc:mysql://localhost:3306/"+sc.next();
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter table name");
			String sql = "select * from "+ sc.next() +" where id = ? ";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter id");
			pmst.setInt(1, sc.nextInt());
			ResultSet rs = pmst.executeQuery();
			while (rs.next()) {
				System.out.println("id : " + rs.getInt("id") + " name : " + rs.getString("name") + " email : "
						+ rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void droptable() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter database name");
			String  url = "jdbc:mysql://localhost:3306/"+sc.next();
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter table name");
			String sql = "drop table " + sc.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if (i == 0) {
				System.out.println("Successfully table deleted");
			} else {
				System.out.println(" error ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void dropdatabase() {
		try {
			Scanner sc = new Scanner(System.in);
			String url = "jdbc:mysql://localhost:3306/";
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("enter database name");
			String sql = "drop database " + sc.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if (i == 0) {
				System.out.println("Successfully deleted");
			} else {
				System.out.println(" error ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void updation() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter database name");
			String  url = "jdbc:mysql://localhost:3306/"+sc.next();
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("enter table name");
			String sql = "update "+sc.next()+" set name=?,email=? where id = ?";
			pmst = conn.prepareStatement(sql);
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
		System.out.println("\t9 .update table");
		System.out.println("\t10 .terminate process");
	}
}

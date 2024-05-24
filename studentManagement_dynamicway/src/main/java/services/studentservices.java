package services;

import java.sql.Connection;
import java.sql.PreparedStatement;

import models.student;

public class studentservices {

	private Connection conn;

	public studentservices(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean addstudent(student stu) {
		boolean f = false;
		try {
			String sql = "insert into student (s_id,s_name,s_email,s_ph,s_branch) values (?,?,?,?,?)";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setInt(1, stu.getS_id());
			pmst.setString(2, stu.getS_name());
			pmst.setString(3, stu.getS_email());
			pmst.setLong(4,stu.getS_ph());
			pmst.setString(5, stu.getS_branch());
			int i = pmst.executeUpdate();
			if(i>0) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}

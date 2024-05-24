package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import dbconnection.studentdb;
import models.student;
import services.studentservices;

@WebServlet("/register")

public class studentservlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int stu_id = Integer.parseInt(req.getParameter("s_id"));
		String stu_name = req.getParameter("s_name");
		String stu_email = req.getParameter("s_email");
		Long stu_ph = Long.parseLong(req.getParameter("s_ph")) ;
		String stu_branch = req.getParameter("s_branch");
		student st = new student(stu_id, stu_name, stu_email, stu_ph, stu_branch);
		studentservices services = new studentservices(studentdb.getconnection());
//		HttpSession hs = req.getSession();
		boolean f = services.addstudent(st);
		if(f) {
			System.out.println("successfully inserted");
			resp.sendRedirect("home.jsp");
		}
		else {
			System.out.println("error");
			resp.sendRedirect("error.jsp");
		}
		super.doPost(req, resp);
	}

}

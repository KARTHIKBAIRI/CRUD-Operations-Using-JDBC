package college;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ex")
public class employee extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String sql = "insert into employee (name,email) values (?,?)";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setString(1, name);
			pmst.setString(2, email);
			int i = pmst.executeUpdate();
			if(i>0) {
				resp.sendRedirect("");
			}
			else {
				resp.sendRedirect("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

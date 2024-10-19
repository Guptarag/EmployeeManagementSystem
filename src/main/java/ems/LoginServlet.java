package ems;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");

			PreparedStatement pstmt = con.prepareStatement("select * from employees where email =? and pswrd = ?");

			pstmt.setString(1, email);
			pstmt.setString(2, password);
		
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				try {
					
					HttpSession session = req.getSession();
					session.setAttribute("name", rs.getString(2)+" "+rs.getString(3));
					session.setAttribute("email", rs.getString(5));
					session.setAttribute("mobileno", rs.getLong(4));
					session.setAttribute("designation", rs.getString(7));
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
					Statement stmt1 = con.createStatement();
					ResultSet rs1 = stmt1.executeQuery("select * from employees");
					req.setAttribute("rs", rs1);
					req.setAttribute("msg", "Login Sucessfully Done ");
					RequestDispatcher rd = req.getRequestDispatcher("allemp.jsp");
					rd.forward(req, resp);
					rs1.close();
					stmt1.close();
					con1.close();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			} else {
				
				req.setAttribute("msg", "Invalid Credentials.. Please Try again  ");
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}

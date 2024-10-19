package ems;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/reg")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int employeeId = Integer.parseInt(req.getParameter("id"));
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		long mobileNo = Long.parseLong(req.getParameter("mobileNo"));
		double salary = Double.parseDouble(req.getParameter("salary"));
		String designation = req.getParameter("designation");
		int deptNo = Integer.parseInt(req.getParameter("deptNo"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Connection con = null;
		PreparedStatement pstmt = null;
		String message =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
			pstmt = con.prepareStatement("insert into employees values (?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, employeeId);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setLong(4, mobileNo);
			pstmt.setString(5, email);
			pstmt.setDouble(6, salary);
			pstmt.setString(7, designation);
			pstmt.setInt(8, deptNo);
			pstmt.setString(9, password);

			int rows = pstmt.executeUpdate();

			System.out.println(rows + " row is created");
			if (rows>0) {
				message = "Registration SuccessFull";
			
				
			}
			else {
				message ="Please Try Again";
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		req.setAttribute("message", message);
		
		RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
		rd.forward(req, resp);

	}

}

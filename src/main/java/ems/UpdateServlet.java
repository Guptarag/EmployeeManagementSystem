package ems;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		long mobileNo = Long.parseLong(req.getParameter("mobileNo").strip());
		double salary = Double.parseDouble(req.getParameter("salary").strip());
		String designation = req.getParameter("designation");
		int deptNo = Integer.parseInt(req.getParameter("deptNo").strip());
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		int eid  =Integer.parseInt( req.getParameter("id").strip());
		Connection con = null;
		PreparedStatement pstmt = null;
		String message =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
			pstmt = con.prepareStatement("update employees set fname =? , lname =?,mobileno=?,email=?,salary=?,designation=?,deptno= ?,pswrd=? where eid =?");
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setLong(3, mobileNo);
			pstmt.setString(4, email);
			pstmt.setDouble(5, salary);
			pstmt.setString(6, designation);
			pstmt.setInt(7, deptNo);
			pstmt.setString(8, password);
			pstmt.setInt(9, eid);

			int rows = pstmt.executeUpdate();

			System.out.println(rows + " row is updated");
			if (rows>0) {
				message = "Updated SuccessFully";
			
				
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
		req.setAttribute("msg", message);
		
		RequestDispatcher rd = req.getRequestDispatcher("/allemp");
		rd.forward(req, resp);
		
		
		
	}

}

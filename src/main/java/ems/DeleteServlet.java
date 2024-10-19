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

@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int eid = Integer.parseInt(req.getParameter("id"));

		Connection con = null;
		PreparedStatement pstmt = null;
		String msg = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
			pstmt = con.prepareStatement("delete from employees  where eid = ?");

			pstmt.setInt(1, eid);
			int rows = pstmt.executeUpdate();

			System.out.println(rows + " Row is Deleted ");
			if(rows >0) {
				msg = "Employee with ID : "+eid+" is deleted Successfully";
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

		req.setAttribute("msg", msg);
		
		RequestDispatcher rd = req.getRequestDispatcher("/allemp");
		rd.forward(req, resp);

	}
}
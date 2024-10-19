package ems;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/updatepage")
public class UpdatePageServlet  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int eid = Integer.parseInt(req.getParameter("id"));
		
		Connection con=null;
		PreparedStatement pstmt= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","root");
			 pstmt = con.prepareStatement("select * from employees where eid =?");
			 
			 pstmt.setInt(1, eid);
			 ResultSet rs = pstmt.executeQuery();
			 
			 req.setAttribute("rs", rs);
			 
			 RequestDispatcher rd = req.getRequestDispatcher("updatepage.jsp");
			 rd.forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				}
				catch(SQLException e){
					e.printStackTrace();
					
				}
			}
			if(con!=null) {
				try {
					con.close();
				}
				catch(SQLException e){
					e.printStackTrace();
					
				}
			}
		}
		
		
		
	
	
	}

}

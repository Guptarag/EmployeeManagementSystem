<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Employees Info</title>

<link rel= "stylesheet" href="allemp.css">

</head>
<body>
    <h1>All Employee</h1>
    <a href="register.jsp" id="btn">  
        <button>Register New Employee</button>
    </a>
    
    <%  String msg = (String)request.getAttribute("msg"); 
    
    	if(msg != null ){
    %>
		    
    <h3 style="margin-bottom: 20px;" id="msg"><%= msg %> </h3>
    <% } %>    
    

    <table border="1" cellpadding="10" align="center">
        <tr>
            <th>Employee Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Mobile Number</th>
            <th>Email Address</th>
            <th>Salary</th>
            <th>Designation</th>
            <th>Department Number</th>
            <th>Password</th>
            <th colspan="2">Action</th>
        </tr>

        <%
        	
        ResultSet rs = (ResultSet) request.getAttribute("rs");
        while (rs.next()) {
        %>
        <tr>
            <td><%=rs.getInt(1)%></td>
            <td><%=rs.getString(2)%></td>
            <td><%=rs.getString(3)%></td>
            <td><%=rs.getLong(4)%></td>
            <td><%=rs.getString(5)%></td>
            <td><%=rs.getDouble(6)%></td>
            <td><%=rs.getString(7)%></td>
            <td><%=rs.getInt(8)%></td>
            <td><%=rs.getString(9)%></td>
            <td colspan="2">
                <div class="action-buttons">
                    <a href="delete?id=<%=rs.getInt(1)%>"><button>Delete</button></a>
                    <a href="updatepage?id=<%=rs.getInt(1)%>"><button>Update</button></a>
                </div>
            </td>
        </tr>
        <%
        }
        %>
    </table>

    <script>
        let msgEle = document.getElementById('msg');
        setTimeout(() => {
            msgEle.style.cssText = "display: none";
        }, 3000);
    </script>
</body>
</html>

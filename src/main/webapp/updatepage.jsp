<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Employee Registration Form</title>
<link rel="stylesheet" href="register.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
	
<style>
	input{
		color:lightgray;
	}

</style>
</head>
<body>
	<div class="container">
		<h1>Employee Updation Form</h1>

		<form action="update">
			<%
			ResultSet rs = (ResultSet) request.getAttribute("rs");

			if (rs.next()) {
			%>
			<div class="form-group">
				<div class="input-group">
					<label for="id"><i class="fas fa-id-badge"></i> Employee
						ID: <span style="color: red;">*</span></label> <input type="text" id="id"
						name="id" value="<%=rs.getInt(1)%> " >
				</div>
				<div class="input-group">
					<label for="deptNo"><i class="fas fa-building"></i>
						Department No:<span style="color: red;">*</span></label> <input
						type="number" id="deptNo" name="deptNo"
						value="<%=rs.getInt(8)%>" required>
				</div>
				<div class="input-group">
					<label for="firstName"><i class="fas fa-user"></i> First
						Name:<span style="color: red;">*</span></label> <input type="text"
						id="firstName" name="firstName"
						value="<%=rs.getString(2)%> " required>
				</div>
				<div class="input-group">
					<label for="lastName"><i class="fas fa-user"></i> Last
						Name:</label> <input type="text" id="lastName" name="lastName"
						value="<%=rs.getString(3)%> ">
				</div>
				<div class="input-group">
					<label for="mobileNo"><i class="fas fa-phone"></i> Mobile
						No: <span style="color: red;">*</span></label> <input type="tel"
						id="mobileNo" name="mobileNo" value="<%=rs.getLong(4)%> "
						required>
				</div>
				<div class="input-group">
					<label for="salary"><i
						class="fa-solid fa-indian-rupee-sign"></i> Salary: <span
						style="color: red;">*</span></label> <input type="number" id="salary"
						name="salary" value="<%=rs.getDouble(6)%>" required>
				</div>
				<div class="input-group">
					<label for="designation"><i class="fas fa-briefcase"></i>
						Designation:</label> <input type="text" id="designation"
						name="designation" value="<%=rs.getString(7)%> ">
				</div>

				<div class="input-group">
					<label for="email"><i class="fas fa-envelope"></i> Email: <span
						style="color: red;">*</span></label> <input type="email" id="email"
						name="email" value="<%=rs.getString(5)%> " required>
				</div>
				<div class="input-group">
					<label for="password"><i class="fas fa-lock"></i> Password:
						<span style="color: red;">*</span></label> <input type="password"
						id="password" name="password"
						value="<%=rs.getString(9)%> " required>
				</div>
			</div>
			<button type="submit">Update</button>


			<%
			}
			%>
		</form>
		<%
		String message = (String) request.getAttribute("message");
		if (message != null) {
		%>
		<h3 id="msg">
			<%=message%>
		</h3>
		<%
		}
		%>
	</div>
	
	<script >
	window.onload = function() {
		setTimeout(function() {
			let msgEle = document.getElementById('msg');
			if (msgEle) {
				msgEle.style.display = 'none';
			}
		}, 2000); // Hide message after 3 seconds
	};
	
	
	
	</script>
</body>
</html>
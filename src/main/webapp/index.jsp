<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome to EMS</title>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #222831;
	color: #EEEEEE;
}

h1 {
	margin-bottom: 20px;
}

.container {
	height: 90vh;
	width: 100%;
	display: flex;
	align-items: center;
	justify-content: center;
}

button {
	height: 60px;
	width: 250px;
	padding: 10px 20px;
	margin: 10px;
	border: none;
	border-radius: 5px;
	background-color: #00ADB5;
	color: white;
	font-size: 16px;
	cursor: pointer;
	transition: background-color 0.3s ease;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
	font-size: large;
}

button:hover {
	background-color: #007A7C;
}
.buttons{

	margin-left:40px;
}

@media ( max-width : 600px) {
	h1 {
		font-size: 24px;
	}
	button {
		width: 100%;
		margin: 5px 0;
	}
}
</style>
</head>
<body>
	<div class="container">


		<div>
			<h1>Welcome To Employee Management System</h1>
			
			<div class="buttons">
				<a href="register.jsp"><button>Click Here To Register</button></a> 
				<a href="allemp"><button>View All Employees</button></a>
			</div>
		</div>
	</div>
	<script>
        let msgEle = document.getElementById("msg");

        setTimeout(() => {
            msgEle.style.display = "none"; 
        }, 3000);
    </script>
</body>
</html>

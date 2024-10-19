<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<link rel="stylesheet" href="login.css" >

</head>
<body>
    <div class="container">
        <h1>Login</h1>
        <form action="login" method="post">
            <div class="form-group">
                <div class="input-container">
                    <i class="fas fa-user"></i>
                    <input type="text" id="email" name="email" placeholder="Email" required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-container">
                    <i class="fas fa-lock"></i>
                    <input type="password" id="password" name="password" placeholder="Password" required>
                </div>
            </div>
            <button type="submit">Login</button>
            
            
            <% String msg = (String)request.getAttribute("msg");
            	if (msg != null){
            %>
            <h3   id="msg"><%=  msg %></h3>
            <% } %>

        </form>
    </div>
    
    
    <script>
    
    	let msg = document.getElementById("msg");
    	
    	setTimeout(()=>{msg.style.display="none";},2000);
    
    </script>
</body>
</html>
    
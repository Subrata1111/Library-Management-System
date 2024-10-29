<%-- 
    Document   : AdminLogin
    Created on : Oct 19, 2024, 3:43:24 PM
    Author     : Subrata Dolui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>admin_login</title>
    </head>
    <body>
        <h1>WelCome To Library</h1>
        <h2>Admin Login</h2>
        <form action="AdminLoginServlet" method="post">
            UserName: <input type="text" name="username" required> <br>  
            Password: <input type="password" name="password" required> <br><!-- comment -->
            <button type="submit">Submit</button>
        </form>
    </body>
</html>

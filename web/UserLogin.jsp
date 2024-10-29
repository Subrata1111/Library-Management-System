
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login</title>
    </head>
    <body>
        <h1>WelCome To Library</h1>
        <h2>User Login</h2>
        <form action="UserLoginServlet" method="post">
            UserName: <input type="text" name="username" required> <br>  
            Password: <input type="password" name="password" required> <br>
            <button type="submit">Submit</button>
        </form>   
    </body>
</html>

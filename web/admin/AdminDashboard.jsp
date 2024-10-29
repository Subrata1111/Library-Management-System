
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard</title>
    </head>
    <body>
        
        <h2>Welcome, ${sessionScope.username} </h2>
        <a href="Maintenance.jsp">Maintenance</a><br>
        <a href="Reports.jsp">View Reports</a><br>
        <a href="Transactions.jsp">View Transactions</a><br>
        <form action="LogoutServlet" method="post">
            <input type="submit" value="Logout">
        </form>
    </body>
</html>

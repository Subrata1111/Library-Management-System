<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new book</title>
    </head>
    <body>
        <h1>Add a new book</h1>
        <form action="AddBookServlet" method="post">
            Name : <input type="text" name="name" required><br>
            Author : <input type="text" name="author" required><br>
            Category : <input type="text" name="category" required><br>
            Quantity : <input type="number" name="quantity" required><br>
            <input type="submit" value="Add Book">  
        </form>
        <a href="AdminDashboard.jsp">Back to Dashboard</a>
        <%
        String successMessage = (String) request.getAttribute("success");
        String errorMessage = (String) request.getAttribute("error");

        if (successMessage != null) {
        %>
            <p class="success"><%= successMessage %></p>
        <%
            } else if (errorMessage != null) {
        %>
            <p class="error"><%= errorMessage %></p>
        <%
            }
        %>
    </body>
</html>

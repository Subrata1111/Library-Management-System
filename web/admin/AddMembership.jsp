<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Membership</title>
    </head>
    <body>
        <% String message = (String) request.getAttribute("message"); %>
        <% if (message != null) { %>
            <p style="color:green;"><%= message %></p>
        <% } %>
        <h1>Membership Management</h1>
        <h3>Add Membership</h3>
        <form action="AddMembershipServlet" method="post">
            User ID: <input type="text" name="user_id" required><br>
            Membership Duration:
            <select name="membership_duration">
                <option value="6">6 Months</option>
                <option value="12">1 Year</option>
                <option value="24">2 Years</option>
            </select><br>
            <input type="submit" value="Add Membership">
        </form>
  
 
        
    </body>
</html>

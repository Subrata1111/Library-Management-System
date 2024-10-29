<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Membership</title>
    </head>
    <body>
        <% String message = (String) request.getAttribute("message"); %>
        <% if (message != null) { %>
            <p style="color:green;"><%= message %></p>
        <% } %>
        <h1>Update Membership</h1>
            <form action="UpdateMembershipServlet" method="post">
                Membership ID: <input type="text" name="membership_id" required><br>
                Extend Membership By:
                <select name="extension_duration">
                    <option value="6">6 Months</option>
                    <option value="12">1 Year</option>
                    <option value="24">2 Years</option>
                </select><br>
                <input type="submit" value="Update Membership">
            </form>
    </body>
</html>

package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.util.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class UpdateMembershipServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data
        String membershipNumber = request.getParameter("membershipNumber");
        String membershipDurationUpdate = request.getParameter("membershipDurationUpdate");
        String action = request.getParameter("action");

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Establish a database connection
            conn = DBConnection.getConnection();

            String sql="";

            // Check the action type - either extend or cancel membership
            if ("extend".equals(action)) {
                sql = "UPDATE memberships SET membershipDuration = ? WHERE membershipNumber = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, membershipDurationUpdate);
                pstmt.setString(2, membershipNumber);
            } else if ("cancel".equals(action)) {
                sql = "DELETE FROM memberships WHERE membershipNumber = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, membershipNumber);
            }

            // Execute the query
            int rowsUpdated = pstmt.executeUpdate();

            // Set a success message in the session
            HttpSession session = request.getSession();
            if (rowsUpdated > 0) {
                session.setAttribute("message", "Membership updated successfully!");
            } else {
                session.setAttribute("message", "Failed to update membership.");
            }

            // Redirect to the membership management page
            response.sendRedirect("admin/UpdateMembership.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

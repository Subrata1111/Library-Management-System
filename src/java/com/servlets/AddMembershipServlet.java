package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import com.util.DBConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class AddMembershipServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data
        String userId = request.getParameter("user_id");
        String durationStr = request.getParameter("membership_duration");
        
        int membershipDuration = Integer.parseInt(durationStr);  // in months
        Date startDate = new Date();  // current date as start date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        // Calculate end date based on start date and membership duration
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(java.util.Calendar.MONTH, membershipDuration);
        Date endDate = calendar.getTime();

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnection.getConnection();  // Assuming you have a DB connection utility
            String sql = "INSERT INTO membership (user_id, membership_duration, start_date, end_date) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(userId));
            pstmt.setInt(2, membershipDuration);
            pstmt.setString(3, sdf.format(startDate));
            pstmt.setString(4, sdf.format(endDate));
            
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                request.setAttribute("message", "Membership added successfully!");
            } else {
                request.setAttribute("message", "Failed to add membership.");
            }

            request.getRequestDispatcher("admin/AddMembership.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null){
                    pstmt.close();
                }
                if (conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

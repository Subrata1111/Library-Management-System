package com.servlets;

import java.sql.*;
import com.util.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddBookServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException , IOException{
        String name=request.getParameter("name");
        String author=request.getParameter("author");
        String category=request.getParameter("category");
        String quantity=request.getParameter("quantity");
        
        try{
            Connection con=DBConnection.getConnection();
            String query ="INSERT INTO books(name, author,category,quantity) VALUES(?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2,author);
            ps.setString(3,category);
            ps.setInt(4,Integer.parseInt(quantity));
            
            int result =ps.executeUpdate();
            if(result>0){
                request.setAttribute("success","Book added successfully");
                request.getRequestDispatcher("admin/AddBook.jsp").forward(request,response);
            }else{
                request.setAttribute("error", "Failed to add book");
                request.getRequestDispatcher("admin/AddBook.jsp").forward(request, response);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

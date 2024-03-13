package com.tap;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {
	Connection connection = null;
	private static PreparedStatement pstmt;
    Statement stmt = null;
    ResultSet rs = null;
	String url = "jdbc:mysql://localhost:3306/jee4";
	String username = "root";
	String pass = "Lodu@735671";
	String sql="select * from members where email=?";
	String query = "SELECT email FROM members";
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, pass);

			pstmt=connection.prepareStatement(sql);
			
			stmt = connection.createStatement();
			
			rs = stmt.executeQuery(query);
			String email=null;
			
			while (rs.next()) {
                email = rs.getString("email");
        
            }
			if(arg0.getParameter("email")==) {
				
			}
			
			
		
	
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

}

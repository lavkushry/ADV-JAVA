package com.tap;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.eclipse.jdt.internal.compiler.parser.Scanner;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

public class Servlet1 extends HttpServlet {
	Connection connection = null;
	PreparedStatement pstmt = null;
	String url = "jdbc:mysql://localhost:3306/jee4";
	String username = "root";
	String pass = "Lodu@735671";
	String sql = "INSERT INTO `members`(`name`,`lastname`,`email`) VALUES(?,?,?)";

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, pass);

			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, arg0.getParameter("name"));
			pstmt.setString(2, arg0.getParameter("lastname"));
			pstmt.setString(3, arg0.getParameter("emailid"));
			int n=pstmt.executeUpdate();
			
			PrintWriter out=arg1.getWriter();
			if(n>0) {
				out.print("Registration SuccessFull.... Please Hire me");
			}
			else {
				out.print("Registration Failure");
			}
	
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	
	}

}

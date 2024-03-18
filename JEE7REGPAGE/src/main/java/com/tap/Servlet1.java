package com.tap;

import java.io.IOException;
import java.io.PrintWriter;

import org.w3c.dom.Text;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Servlet1 extends HttpServlet {
	static int count = 3;

	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	    String pass = arg0.getParameter("password");
	    String username = arg0.getParameter("username");

//	    HttpSession session = arg0.getSession();
	   arg0.setAttribute("username", username);

	    PrintWriter out = arg1.getWriter();
	    arg1.setContentType("text/html");

	    if ("son2023".equals(pass)) {
	        out.print("Welcome to Home Page");
	    } else if (count > 0) {
	        count--;
	        out.print("INVALID PASSWORD! " + count + " Attempts Left");
	        RequestDispatcher rd = arg0.getRequestDispatcher("index.html");
	        rd.include(arg0, arg1);
	    } else {
	        arg1.sendRedirect("Login-servlet");
	    }
	}

}

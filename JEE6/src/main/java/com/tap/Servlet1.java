package com.tap;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		String un=arg0.getParameter("username");
		
		PrintWriter out =arg1.getWriter();
		
		out.print("Hello Mr "+un+" Welcome to my Page from Servlet1");
		
		RequestDispatcher ouut=arg0.getRequestDispatcher("Login-2");
		ouut.include(arg0, arg1);
	}

}

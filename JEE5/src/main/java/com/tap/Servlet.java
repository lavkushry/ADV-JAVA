package com.tap;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet{
	
//	@Override
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//		
//		String uname=arg0.getParameter("username");
//		
//		PrintWriter out= arg1.getWriter();
//		
//		out.print("Welcome to SERVLET class "+uname);
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String un=req.getParameter("username");
		PrintWriter out= resp.getWriter();
		out.print("Welcome "+un+" You're using DoGet");
	}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String un=req.getParameter("username");
		PrintWriter out= resp.getWriter();
		out.print("Welcome "+un+" You're using DoPost");
		
		}
}

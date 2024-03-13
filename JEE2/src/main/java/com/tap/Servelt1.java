package com.tap;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servelt1 extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String st=arg0.getParameter("username");
		PrintWriter out=arg1.getWriter();
		out.print("<h1> HELLO "+st);
		
	}

}

package com.tap;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String x=arg0.getParameter("x");
		String y=arg0.getParameter("y");
		int x1=Integer.parseInt(x);
		int y1=Integer.parseInt(y);
		int sum=x1+y1;
		arg0.setAttribute("mysum", sum);
		
		RequestDispatcher outt= arg0.getRequestDispatcher("Calc-Servlet1");
		
		outt.forward(arg0, arg1);
				
	}

}

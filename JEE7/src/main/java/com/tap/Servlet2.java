package com.tap;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String x=arg0.getParameter("x");
		String y=arg0.getParameter("y");
		int x1=Integer.parseInt(x);
		int y1=Integer.parseInt(y);
		int product=x1*y1;
		int sum=(int) arg0.getAttribute("mysum");
		PrintWriter out= arg1.getWriter();
		out.println("Sum of "+x1+" and "+y1+" is :  "+sum);
		out.print("Product of "+x1+" and "+y1+" is :  "+product);

	}

}

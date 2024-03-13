package com.tap;

import java.io.IOException;
import java.io.PrintWriter;

import org.w3c.dom.Text;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet1 extends  HttpServlet{
	static int count=3;
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	

		String pass=arg0.getParameter("password");
		PrintWriter out =arg1.getWriter();
		arg1.setContentType("Text/html");
		
		if("son2023".equals(pass))
		{
			out.print("Welcome to Home Page");
		}
		else if(count>0){
			out.print("INVALID PASSWORD ! "+count+" Attempts Left");
			count--;
			RequestDispatcher rd=arg0.getRequestDispatcher("index.html");
			rd.include(arg0, arg1);
		}else {
			out.print("Attempt Over ! Contact Us");
		}
	}
}

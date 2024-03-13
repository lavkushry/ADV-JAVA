package com.tap1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

public class Servlets1 extends HttpServlet {
	
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		String name=arg0.getParameter("username");
		String password=arg0.getParameter("password");
		String pass="lavkush";
		
		PrintWriter writer=arg1.getWriter();
		if(password==pass) {
		
			writer.print("Hello "+name+" Welcome to the Home Page");
		
		}else {
			writer.print("Wrong Password");
		}
	}

}

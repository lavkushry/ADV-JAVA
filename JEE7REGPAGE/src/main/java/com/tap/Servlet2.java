package com.tap;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
public class Servlet2 extends HttpServlet {
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpSession session = request.getSession();
		
	    String un = (String) session.getAttribute("username");
	    
	    PrintWriter out = arg1.getWriter();
	    
	    arg1.setContentType("text/html");
	    
	    out.print("HEY " + un + " ATTEMPTS OVER, CONTACT ADMIN");
	}

}

package com.tap;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String username = arg0.getParameter("username");
		String password = arg0.getParameter("password");

		Cookie c1 = new Cookie("username", username);
		Cookie c2 = new Cookie("password", password);

		arg1.addCookie(c1);
		arg1.addCookie(c2);

		arg1.sendRedirect("Login-servlet2");
	}

}

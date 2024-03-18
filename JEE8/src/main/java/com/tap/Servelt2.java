package com.tap;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servelt2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {

		Cookie[] c = arg0.getCookies();
		System.out.println(c[0]);

		for (Cookie a : c) {

			System.out.println(a.getName() + " " + a.getValue());
		}
	}

}

package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readCookie")
public class ReadCookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for(Cookie c:cookies) {
				out.println("<h1>"+c.getName() + "->" + c.getValue()+"</h1>");
			}
		}else {
			out.println("<h1>No Cookies</h1>");
		}
	}
}
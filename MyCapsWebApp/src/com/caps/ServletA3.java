package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servA3")
public class ServletA3 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Got a Request "+ getClass());
		String name=req.getParameter("search");
		PrintWriter out = resp.getWriter();
		out.println("<h1>ServA3 response</h1>");
		resp.sendRedirect("https://www.google.com/search?q="+name);
		
	}
	
}
package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servA1")
public class ServletA1 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Got a Request "+ getClass());
		//String name=req.getParameter("search");
		PrintWriter out = resp.getWriter();
		out.println("<h1>ServA1 respons</h1>");
		RequestDispatcher dispatcher =
				 req.getRequestDispatcher("/servA2");
		dispatcher.forward(req,resp);
		
		
	}
	
}
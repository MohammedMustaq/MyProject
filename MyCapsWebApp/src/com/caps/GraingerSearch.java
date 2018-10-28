package com.caps;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/grainger")
public class GraingerSearch extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String passwd = req.getParameter("pass");
		
		System.out.println(email);
		System.out.println(passwd);
		
		resp.sendRedirect("https://www.grainger.com/");
		
		
	}
}
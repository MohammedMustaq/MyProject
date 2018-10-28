package com.caps;

import java.io.*;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firstServ")
public class MyFirstSevlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String firstname=req.getParameter("fname");
		String lastname=req.getParameter("lname");
		System.out.println("Url ->"+req.getRequestURL());
		//System.out.println("length->"+req.getContentLength());
		//System.out.println("method->"+req.getMethod());
		//System.out.println("loacl addr->"+req.getLocalAddr());
		//System.out.println("local name->"+req.getLocalName());
		
		System.out.println(firstname);
		System.out.println(lastname);
		
		PrintWriter out=resp.getWriter();
		out.println("<h1> The Date is:"+ new Date()+"</h1>");
		out.println("The name is"+" "+firstname+" "+lastname);
		/*ServletConfig config=getServletConfig();
		String privateEmail=config.getInitParameter("email");
		out.println(privateEmail);*/
	}
}

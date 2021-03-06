package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/convert")
public class ConvertingPersistenceToNonPersistence extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter out=resp.getWriter();
		Cookie[] cookies=req.getCookies();
		if(cookies!=null)
		{
			for(Cookie c:cookies)
			{
				
				if(c.getName().equals("name"))
				{
					c.setMaxAge(-1);
					out.println("Converted");
				}
				else
				{
					c.setMaxAge(24*60*60);
				}
				
				resp.addCookie(c);
			}
			
		}
		out.println("State Changed");
	}
}

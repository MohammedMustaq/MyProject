package com.caps.mpt;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getdataServ1")
public class getdataServ1 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("request forwarded");
		PrintWriter out=resp.getWriter();
		//out.println("im sorryyyyyyyyyyyyy");
		//String url="http://localhost:8090/MyCapsWebApp/Login1.html";
		//resp.sendRedirect(url);
		out.println("<html>");
		out.println("<body>");
		out.println(" <h1>userid or password is invalid...</h1>");
		 out.println("<a href="+"http://localhost:8040/MyLoginApp/Login1.html"+"><button type=\"button\">LOGIN </a>");
			out.println("</body>");
			out.println("</html>");
	}
	}
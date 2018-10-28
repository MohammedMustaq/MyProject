package com.caps;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServ")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("sid");
		String passwd = req.getParameter("pass");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			/*
			 * 1. Load the Driver
			 */
			Class.forName("com.mysql.jdbc.Driver");
			
			/*
			 * 2. Get the DB Connection via Driver
			 */
						String dbUrl="jdbc:mysql://localhost:3307/capsv4_db?user=root&password=dinga";
						
			//2nd Version of getConnection
				FileReader in = new FileReader("C:/Users/user/Desktop/Capgemini/db.properties");
				Properties prop = new Properties();
				prop.load(in);
				con = DriverManager.getConnection(dbUrl,prop);
						

			System.out.println("Connected...");
			
			/*
			 * 3. Issue the SQL query via connection
			 */
			String sql = "select * from students_info where "
					+ " sid=? and password=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(userId));
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();

			/*
			 * 4. Process the results
			 */
			//PrintWriter out = resp.getWriter();
			PrintWriter out = resp.getWriter();
			out.print("<html>");
			out.print("<body>");
			out.print("<table border=1px cellspacing=0px bgcolor=aqua align=center >");//
			out.print("<h1><tr><th>Sid</th><th>FirstName</th><th>LastName</th><th>Gender</th><th>Password</th><th>Type</th></tr></h1>");
			
			if(rs.next()){
				HttpSession s=req.getSession();
				String fname=rs.getString("firstname");
				String type=rs.getString("type");
				//System.out.println(fname);
				s.setAttribute("name",fname);
				s.setAttribute("type",type);
				
				
				
				out.println("<br></br>");
				out.println("<br></br>");
				out.println("<br></br>");
				


				
				out.print("<tr><td>"+rs.getInt("sid")+"</td>");
				out.print("<td>"+rs.getString("firstname")+"</td>");
				out.print("<td>"+rs.getString("lastname")+"</td>");
				out.print("<td>"+rs.getString("gender")+"</td>");
				out.print("<td>"+rs.getString("password")+"</td>");
				out.print("<td>"+rs.getString("type")+"</td></tr>");
				out.println("</table>");
				out.println("<a href=\"http://localhost:8040/MyCapsStudentWebApp/ViewAllStudents\">Click On Me TO_ViewAllStudents</a>");
				out.println("</table>");
				out.println("</table>");
			}else {
				out.println("Login Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 5. close all the JDBC Objects
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
		}
	}
}
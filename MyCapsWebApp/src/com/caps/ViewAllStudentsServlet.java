package com.caps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;
@WebServlet("/ViewAllStudents")
public class ViewAllStudentsServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		PrintWriter out=resp.getWriter();
		try {
			/*
			 * 1. Load the Driver
			 */
			java.sql.Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			System.out.println("Driver Loaded...");
			
			/*
			 * 2. Get the DB Connection via Driver
			 */
						String dbUrl="jdbc:mysql://localhost:3307/capsv4_db"
								+ "?user=root&password=dinga";
			con = DriverManager.getConnection(dbUrl); //1st version of getConnection

			System.out.println("Connected...");
			
			/*
			 * 3. Issue the SQL query via connection
			 */
			String sql = "select * from students_info";

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			/*
			 * 4. Process the results
		-************-	 */
			out.print("<h1 >Students Info</h1>");//
			out.print("<html>");
			out.print("<body>");
			out.print("<table border=1px cellspacing=0px bgcolor=grey align=center>");//bgcolor=grey align=center
			out.print("<h1><tr><th>Sid</th><th>FirstName</th><th>LastName</th><th>Gender</th><th>Password</th><th>Type</th></tr></h1>");
			while(rs.next()){
				/*int regno = rs.getInt("sid");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String gender = rs.getString("gender");
				String passwd = rs.getString("password");
				String type = rs.getString("type");*/

				out.print("<tr><td>"+rs.getInt("sid")+"</td>");
				out.print("<td>"+rs.getString("firstname")+"</td>");
				out.print("<td>"+rs.getString("lastname")+"</td>");
				out.print("<td>"+rs.getString("gender")+"</td>");
				out.print("<td>"+rs.getString("password")+"</td>");
				out.print("<td>"+rs.getString("type")+"</td></tr>");
				
			}
			out.print("</table>");
			out.print("</body>");
			out.print("</html>");
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

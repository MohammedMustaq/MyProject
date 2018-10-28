package com.caps.mpt;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.caps.mpt.UserAuth;

@WebServlet("/loginServ1")
public class LoginServlet1 extends HttpServlet{
	 int count ;
	 UserAuth ua ;
	 HttpSession session;
	 long time;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String userId = req.getParameter("sid");
		String passwd = req.getParameter("password");
	//	System.out.println(userId+ " "+passwd);
		HttpSession s3=req.getSession(false);
		
		if(s3==null)
		{
			System.out.println("no session is there");
			count=0;
			ua=new UserAuth();
			session=req.getSession();
			time=session.getLastAccessedTime();
		}
		
		long currenttime=new Date().getTime();
		
		
		session.setAttribute("userauth", ua);
		session.setAttribute("times", time);
		session.setAttribute("counts", count);
		
		ua.setLocktime(3600000);//milliseconds for 1 hour
		if(currenttime-(long)session.getAttribute("times")>ua.getLocktime())
		{
			ua.setLock(false);
			ua.setAttempts(0);
			session.invalidate();
		}
		
		
		PrintWriter out = resp.getWriter();
		
		if(ua.getAttempts()<3 && !(ua.isLock())) {

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
				
				
				if(rs.next()){
					System.out.println("entered rs.next");
					/*int regno = rs.getInt("sid");
					String firstname = rs.getString("firstname");
					String lastname = rs.getString("lastname");
					String gender = rs.getString("gender");
					passwd = rs.getString("password");
					String type = rs.getString("type");

					out.println(regno);
					out.println(firstname);
					out.println(lastname);
					out.println(gender);
					out.println(passwd);
					out.println(type);
					out.println("*********************");*/
					out.println("<br></br>");
					out.println("<br></br>");
					out.println("<br></br>");
					


					
					out.print("<tr><td>"+rs.getInt("sid")+"</td>");
					out.print("<td>"+rs.getString("firstname")+"</td>");
					out.print("<td>"+rs.getString("lastname")+"</td>");
					out.print("<td>"+rs.getString("gender")+"</td>");
					out.print("<td>"+rs.getString("password")+"</td>");
					out.print("<td>"+rs.getString("type")+"</td></tr>");
				}else {
					out.println(" userid or password is invalid...");
					 ua.setAttempts(++count);
					System.out.println("login is failed for"+count);
					RequestDispatcher dispatcher =
							 req.getRequestDispatcher("/getdataServ1");
					dispatcher.forward(req,resp);
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
			
		
		}else {
			out.println("Account has been locked.please Contact system administrator ");
			ua.setLock(true);
			//session.invalidate();
		}
	}
}
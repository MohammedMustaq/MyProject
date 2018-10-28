package com.mpt.controller;
import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mpt.model.beans.Student;
import com.mpt.model.beans.UserAuth;
import com.mpt.model.dao.DAOimpl;
import com.mpt.model.dao.JDBCimpl;
import com.mpt.service.Validation;

@WebServlet("/loginServs1")
public class LoginServlet1 extends HttpServlet{
	UserAuth ua ;
	int count;
	 HttpSession session;
	 long time;
	 DAOimpl ref=new JDBCimpl();
	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String userId = req.getParameter("name");
		String passwd = req.getParameter("password");
		boolean login=Validation.login(userId, passwd);//back-end validation for username & password
		long currenttime=new Date().getTime();
		System.out.println(login);
		HttpSession s3=req.getSession(false);
		
			if(login)
			{
				if(s3==null)
				{	
					count=0;
					ua=new UserAuth();
					session=req.getSession();
					time=session.getLastAccessedTime();
					session.setAttribute("userauth", ua);
					session.setAttribute("counts", count);
				}
				
				long sesstime=time;
				long differ=currenttime-time;
				if(differ>120000)  				//(3600000)//milliseconds for 1 hour
					ua.time();
				
				if(ua.getAttempts()<3&!(ua.isLock())) 
				{
						Student rs=ref.result(userId, passwd);
					
						if(rs!=null)
						{
							req.setAttribute("student", rs);
							RequestDispatcher dispatcher=req.getRequestDispatcher("Home.jsp");
							dispatcher.forward(req, resp);
						}
						else 
						{
							ua.incCount(ua.getAttempts());
							System.out.println("login is failed for"+ua.getAttempts());		

							RequestDispatcher dispatcher = req.getRequestDispatcher("Error.jsp");
							dispatcher.forward(req,resp);
							}
				 }
				  else {
					RequestDispatcher dispatcher = req.getRequestDispatcher("Locked.jsp");
					dispatcher.forward(req,resp);
					}
				
			}
		
			else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("Error.jsp");
				dispatcher.forward(req,resp);
				}
		}
			
}

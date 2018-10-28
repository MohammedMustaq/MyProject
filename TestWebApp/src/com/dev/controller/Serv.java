package com.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.model.beans.Person;

@WebServlet("/serv")
public class Serv extends HttpServlet
{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
	Person p=new Person();
	p.setName("Mustaq");
	p.setId(1);
	p.setEmail("mustaq@gmail.com");
	p.setAddress("earth");
	HttpSession session=req.getSession();
	session.setAttribute("person", p);
	RequestDispatcher dispatcher=req.getRequestDispatcher("Home.jsp");
	dispatcher.forward(req, resp);
			
	}
	

}

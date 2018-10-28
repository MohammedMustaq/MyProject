package com.mpt.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mpt.model.beans.Student;

public class JDBCimpl implements DAOimpl {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Student s=new Student();
	
@Override
public Student result(String userId,String passwd) {

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
		String sql = "select * from employees_info where "
				+ " name=? and password=?";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,userId);
		pstmt.setString(2, passwd);
		
		rs = pstmt.executeQuery();

		/*
		 * 4. Process the results
		 */
		
		
		if(rs.next())
		{
			int regno=rs.getInt("sid");
			String name=rs.getString("name");
			String pass=rs.getString("password");
			s.setSid(regno);
			s.setName(name);
			s.setPassword(pass);
			return s;
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
	return null;	
}
}
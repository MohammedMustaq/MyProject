package com.caps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class TransactionExample {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			/*
			 * 1. Load the Driver
			 */
			Class.forName("com.mysql.jdbc.Driver");

			/*
			 * 2. Get the DB Connection via Driver
			 */
			
			String dbUrl="jdbc:mysql://localhost:3307/capsv4_db";

			//3rd version of getConnnecton()
			con = DriverManager.getConnection(dbUrl,"root","dinga"); //1st version of getConnection
			con.setAutoCommit(false);
			System.out.println("Connected...");

			/*
			 * 3. Issue the SQL query via connection
			 */
			
			String sql1 = "insert into students_info values(18,'a','b','M','root','N')";
			String sql2 = "insert into students_info values(19,'a','b','M','root','N')";
			String sql3 = "insert into students_info values(20,'a','b','M','root','N')";
			
			pstmt = con.prepareStatement(sql1);
			int count1 = pstmt.executeUpdate();
			pstmt.close();
			
			pstmt = con.prepareStatement(sql2);
			int count2 = pstmt.executeUpdate();
			pstmt.close();
			
//			int i = 10/0;
			
			pstmt = con.prepareStatement(sql3);
			int count3 = pstmt.executeUpdate();
			pstmt.close();
			
			con.commit();
			
			if(count1 == 1 && count2==1 && count3 == 1) {
				System.out.println("success");
			}else {
				System.out.println("failed");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//end of main

}
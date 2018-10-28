package com.caps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Scanner;

public class ExecuteBatchExample {
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

			System.out.println("Connected...");

			/*
			 * 3. Issue the SQL query via connection
			 */
			String option = "";
			Scanner in = new Scanner(System.in);
			String sql = "insert into students_info values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			while(true) {
				System.out.println("id:");
				int id = Integer.parseInt(in.nextLine());
				System.out.println("First Name: ");
				String fname= in.nextLine();
				System.out.println("LastName: ");
				String lname = in.nextLine();
				System.out.println("Gender: ");
				String gender = in.nextLine();
				
				System.out.println("Type: ");
				String type = in.nextLine();
				System.out.println("Password: ");
				String password=in.nextLine();
				System.out.println("To exit type 'exit'");
				option = in.nextLine();
				
				pstmt.setInt(1, id);
				pstmt.setString(2,fname);
				pstmt.setString(3, lname);
				pstmt.setString(4, gender);
				pstmt.setString(6, password);
				pstmt.setString(5, type);
				
				pstmt.addBatch();
				
				if(option.equalsIgnoreCase("exit")) 
					break;
				
			}
			
			
			
			
			int counts[] = pstmt.executeBatch();
			
			
			
			/*
			 * 4. Process the results
			 */
			System.out.println(Arrays.toString(counts));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//end of main

}
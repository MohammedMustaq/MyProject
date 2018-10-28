package com.caps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class BatchExecuteExample 
{

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
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

			//stmt = con.createStatement();
			//con.setAutoCommit(false);  
			  
			stmt=con.createStatement();  
			stmt.addBatch("insert into students_info values(8,'abc','xyz','M','N','root')");  
			stmt.addBatch("insert into students_info values(9,'abcd','wxyz','M','N','root')");  
			  
			stmt.executeBatch();//executing the batch  
			
			  
		//	con.commit();  
		//	con.close(); 
			rs = stmt.executeQuery(sql);

			/*
			 * 4. Process the results
			 */

			while(rs.next()){
				int regno = rs.getInt("sid");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String gender = rs.getString("gender");
				String passwd = rs.getString("password");
				String type = rs.getString("type");

				System.out.println(regno);
				System.out.println(firstname);
				System.out.println(lastname);
				System.out.println(gender);
				System.out.println(passwd);
				System.out.println(type);
				System.out.println("*********************");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

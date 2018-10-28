package com.caps;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class MyFirstJDBCProgramV3
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
						String dbUrl="jdbc:mysql://localhost:3307/capsv4_db";
			FileReader fr=new FileReader("C:/Users/user/Desktop/Capgemini/db.properties");
			Properties prop=new Properties();
			prop.load(fr);
			con = DriverManager.getConnection(dbUrl,prop); //1st version of getConnection

			System.out.println("Connected...");
			
			/*
			 * 3. Issue the SQL query via connection
			 *
			 **/
			 Scanner in = new Scanner(System.in);
		System.out.println("id:");
		int id = Integer.parseInt(in.nextLine());
			 
			String sql = "select * from students_info";
			stmt = con.createStatement();
			//stmt.setInt(1, id);

			//stmt = con.createStatement();
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
	}//end of main
}

package com.caps;

import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.log4j.Logger;

public class App 
{
	final static Logger logger=Logger.getLogger("App");
	public static void main(String[] args) {
		logger.info("Program Started......");
		try
		{
		logger.info("Giving File Path..");
		//String path="‪‪C:/Users/user/Desktop/life.txt";
		logger.info("Creating File Reader object..");
		FileReader in= new FileReader("‪‪C:/Users/user/Desktop/file.txt");
		logger.info("Creating BufferReader object and passing FIleReader Ref..");
		BufferedReader reader=new BufferedReader(in);
		logger.info("File Reading Started..");
		String line=null;
		while((line=reader.readLine())!=null) {
			System.out.println(line);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Program ended..");
	
		}
		
	}


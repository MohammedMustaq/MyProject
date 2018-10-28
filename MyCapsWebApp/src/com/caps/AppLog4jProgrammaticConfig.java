package com.caps;



import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class AppLog4jProgrammaticConfig {
final static Logger logger=Logger.getLogger("AppLog4jProgrammaticConfig");
public static void main(String[] args) {
	Layout layout=new SimpleLayout();
	Appender appender;
	//Appender a =newConsoleAppender();
	try
	{
		appender=new FileAppender(layout,"‪C:/Users/user/Desktop/my.txt",false);
		//3rd parameter is true by default
		//true=Appends the data into my.txt
		//false=delete previous data and rewrite
		logger.addAppender(appender);
	}catch(Exception e) {}
	logger.fatal("This is the error message....");
	
	System.out.println("Your logic executed successfully..");
}
}

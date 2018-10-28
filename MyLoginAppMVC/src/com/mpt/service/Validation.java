package com.mpt.service;

public class Validation {
	
	public static boolean isStringOnlyAlphabet(String str) 
    { 
        if((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z]*$"))) 
        	return true;
        else 
    	return false;
    	
    }
	public static  boolean password(String name) {
		String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}~";
		String str2[]=name.split("");

	if(name.length()==0) 
		return false;
	else
	{
		for (int i=0;i<str2.length;i++)
		{
			if (true==specialCharacters.contains(str2[i]))
			return true;
		}return false;
	}
	}
public static	boolean login(String usernm,String pass) {
	boolean b=isStringOnlyAlphabet(usernm);
	boolean c=password(pass);
	if(b&c)
		return true;
	else
		return false;
		
	}
		
	
}
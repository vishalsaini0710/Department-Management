package com.cetpa.util;

public class DateFormat 
{
	public static String chageFormat(String date)
	{
		String[] x=date.split("-");
		date=x[2]+"-"+x[1]+"-"+x[0];
		return date;
	}
}

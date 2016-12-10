package com.file.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	
	public static String getTimeString() {
		return getTimeStringByForFormat("yyy-MM-dd HH:mm:ss");
		 
	}
	public static String getTimeStringByForFormat(String  format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(new Date());
	}
	public static void main(String[] args) {
		System.out.println(getTimeString());
	}
}

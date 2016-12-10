package com.file.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

public class UtilFile {
	public static String getFizeSizeString(int size) {
		String sizeStr;
		if (size >= 0 && size < 1024) {
			sizeStr = size+"B";
		} else if (size >= 1024 && size < 1024*1024) {
			sizeStr = size/1024 + "KB";
		} else if (size >= 1024*1024 && size < 1024*1024*1024) {
			sizeStr = size/1024/1024 + "MB";
		} else {
			sizeStr = size/1024/1024/1024 + "GB";
		}
		return sizeStr;
	}
	public static  String transCharacter(HttpServletRequest request, String str) throws Exception{  
	    if(request.getHeader("USER-AGENT").toLowerCase().indexOf( "msie" ) > 0){  
	        return URLEncoder.encode(str, "UTF-8");  
	    }else if(request.getHeader("USER-AGENT").toLowerCase().indexOf( "firefox" ) > 0){  
	        return new String(str.getBytes("UTF-8"), "ISO8859-1");  
	    }  
	    return new String(str.getBytes("UTF-8"), "ISO8859-1");  
	}  
}

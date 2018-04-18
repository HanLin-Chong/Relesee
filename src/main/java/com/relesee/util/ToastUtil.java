package com.relesee.util;

public class ToastUtil {
	static StringBuffer info;
	public static String getToast(String title, String message, String color){
		info = new StringBuffer("[");
		info.append("{\"title\":"+"\""+message+"\",");
		info.append("\"message\":"+"\""+message+"\",");
		info.append("\"color\":"+"\""+color+"\"}]");
		return info.toString();
	}
}	

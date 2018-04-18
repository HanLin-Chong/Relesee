package com.relesee.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String getTime(){
		Date date = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format1.format(date);
	}
}

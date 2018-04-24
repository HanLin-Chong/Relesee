package com.relesee.contant;

import java.util.Properties;

import com.relesee.util.PropsUtil;

public class Contant {
	public static String FILE_NAME="constant.properties";
	public static String FILE_BASE_RUL;
	
	static{
			Properties props = PropsUtil.loadProps(FILE_NAME);
			FILE_BASE_RUL=(String) PropsUtil.getString(props,"file_base_url");	
	}
}

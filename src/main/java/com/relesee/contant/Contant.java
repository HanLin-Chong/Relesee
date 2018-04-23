package com.relesee.contant;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Contant {
	
	public static String FILE_NAME;
	public static String BASE_RUL;
	
	static{
		try{
			Properties props = new Properties();
			InputStream inputStream = null;
			inputStream =new FileInputStream(FILE_NAME);
			BASE_RUL=(String) props.get("base_url");
			props.load(inputStream);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

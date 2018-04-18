package com.relesee.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.relesee.bean.User;
import com.relesee.dao.UserLoginLogDao;
import com.relesee.domain.UserLoginLog;

/*
 * 
 */
public class UserLoginLogDaoImpl implements UserLoginLogDao{

	@Override
	public boolean createLog(UserLoginLog loginLog) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql = "insert into loginlog(";
		return false;
	}
	
}

package com.relesee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relesee.dao.impl.UserLoginLogDaoImpl;
import com.relesee.domain.UserLoginLog;


public class LoginLogService {

	private UserLoginLogDaoImpl logDao;
	public LoginLogService() {
	}
	public boolean addLog(UserLoginLog loginLog){
			
		return false;
	}
}

package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.impl.UserLoginLogDaoImpl;
import domain.UserLoginLog;


public class LoginLogService {

	private UserLoginLogDaoImpl logDao;
	public LoginLogService() {
	}
	public boolean addLog(UserLoginLog loginLog){
			
		return false;
	}
}

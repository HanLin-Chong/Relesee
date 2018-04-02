package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.daoImpl.UserLoginLogDaoImpl;
import domain.UserLoginLog;


public class LoginLogService {

	private UserLoginLogDaoImpl logDao;
	public LoginLogService() {
		// TODO Auto-generated constructor stub
	}
	public boolean addLog(UserLoginLog loginLog){
			
		return false;
	}
}

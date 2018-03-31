package dao.daoImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import dao.UserLoginLogDao;
import domain.User;
import domain.UserLoginLog;

public class UserLoginLogDaoImpl implements UserLoginLogDao{

	@Override
	public boolean createLog(UserLoginLog loginLog) {
		Date date = new Date();
		String sql = "insert into loginlog(";
		return false;
	}
	
}

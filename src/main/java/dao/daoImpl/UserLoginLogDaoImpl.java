package dao.daoImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import bean.User;
import dao.UserLoginLogDao;
import domain.UserLoginLog;

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

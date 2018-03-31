package dao;

import org.springframework.jdbc.core.JdbcTemplate;

import domain.UserLoginLog;

public interface UserLoginLogDao{
	public boolean createLog(UserLoginLog userLoginLog);
}

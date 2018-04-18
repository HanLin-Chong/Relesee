package com.relesee.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.relesee.domain.UserLoginLog;

public interface UserLoginLogDao{
	public boolean createLog(UserLoginLog userLoginLog);
}

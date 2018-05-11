package com.relesee.services;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relesee.bean.User;
import com.relesee.dao.UserDao;
import com.relesee.dao.UserLoginLogDao;
import com.relesee.dao.impl.UserDaoImpl;

/**
 * 
 * @author JinFeng
 * 用户登录的服务
 * @param user 将有前端输入的账号密码与后台查询的比对
 * @return 若果比对正确，返回true
 */
@Service()
public class LoginServiceImpl implements LoginService{
	@Autowired
	private UserDaoImpl userDao;
	@Override
	public boolean login(User user) {
		User queryRs = userDao.findById(user.getUserid());
		if(queryRs!=null){
			return invalidPassword(user,queryRs);
		}else{
			return false;
		}
	
	}
	public boolean invalidPassword(User input,User query){
		if(input!=null && input.getPassword().equals(query.getPassword()) && query!=null){
			return true;
		}
		return false;
	}
	public User getUser(User user){
		return userDao.findById(user.getUserid());
	}

}

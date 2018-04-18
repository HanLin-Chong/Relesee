package com.relesee.dao;
import com.relesee.bean.User;

public interface UserDao {
	public User findById(String userid);
}

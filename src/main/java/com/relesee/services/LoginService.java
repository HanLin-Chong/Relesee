package com.relesee.services;

import org.springframework.stereotype.Service;

import com.relesee.bean.User;

@Service
public interface LoginService {
	public boolean login(User user);
	public User getUser(User user);
	
}

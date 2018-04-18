package services;

import org.springframework.stereotype.Service;

import bean.User;

@Service
public interface LoginService {
	public boolean login(User user);
	public User getUser(User user);
	
}

package dao;

import java.util.Map;

import bean.User;

public interface UserDao {
	public User findById(String userid);
}

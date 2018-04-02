package dao;

import java.util.Map;

import domain.User;

public interface UserDao {
	public User findById(String userid);
}

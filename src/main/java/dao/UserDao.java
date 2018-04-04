package dao;
import bean.User;

public interface UserDao {
	public User findById(String userid);
}

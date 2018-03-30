package dao;

import java.util.Map;

public interface UserDao {
	public Map<String, Object> findById(String userid);
}

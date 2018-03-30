package dao.daoImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dao.BaseDao;
import dao.UserDao;
import domain.User;

public class UserDaoImpl extends BaseDao implements UserDao{

	public User findUserById(String userid){
		String sql = "select * from users where userid =?";
		User user=null;
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);  
		user = jdbcTemplate.queryForObject(sql, rowMapper,1);
		return user;
	}
	@Override
	public Map<String ,Object> findById(String userid) {
		String sql = "select * from users where userid =?";
		Object obj[] = {userid};
		return findByParam(sql, obj).get(0);
		
	}
	@Override
	public String toString(){
		 return null;
	}
}

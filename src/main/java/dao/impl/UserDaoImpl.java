package dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import bean.User;
import dao.UserDao;
/**
 * 
 * @author JinFeng
 *  UserDaoImpl 继承BaseDao
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired 
	private JdbcTemplate jdbcTemplate;
	/*
	 *  TODO
	 *  在这里原本不用增加 这个方法的，在BaseDao中使用@Aurowired  注入了JdbcTemplate  
	 *  但是没有实现其相关效果，在这里先使用这个方法代替
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemlate){
		this.jdbcTemplate = jdbcTemlate;
	}
	public User findById(String userid){
		String sql = "select * from users where userid =?";
		User user=null;
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);  
		try{
			user = jdbcTemplate.queryForObject(sql, rowMapper,userid);
		}catch(EmptyResultDataAccessException e){
			return null;
		}
		return user;
	}
}

package dao.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;
import dbconn.JDBCUtil;

/**
 * 
 * @author JinFeng
 * 使用jdbc的基础类，对jdbc的添加修改进行了简单的封装
 * @return boolean 返回true标识操作成功
 * @param 表示参数 ,如果sql语句中没有通配符，请将这个参数设置为null
 */
@Repository("baseDao")
public class BaseDaoImpl {
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	/*
	 * 更具是否查询的语句中是否有通配符 进行查询
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	public boolean updateByParam(String sql,Object[] args0){
		if(args0==null|| args0.length==0){
			if(jdbcTemplate.update(sql)>0){
				return true;
			}else{
				return false;
			}
		}
		if(jdbcTemplate.update(sql,args0)>0){
			return true;
		}
		else
			return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> findByParam(String sql,Object[] arg0){
		if(arg0==null || arg0.length==0){
			return jdbcTemplate.query(sql, new IRowMapper());
		}
		return jdbcTemplate.query(sql,new IRowMapper(), arg0);
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> find(String sql,Class<T> t){
		RowMapper<T> rowMapper =BeanPropertyRowMapper.newInstance(t);
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	/*
	 * 把数据库中的列名取出，放在map中，其中map的key与列名相同，即表示列名与想赌赢
	 */
	@SuppressWarnings("rawtypes")
	public class IRowMapper implements RowMapper{
		public Map<String, Object> mapRow(ResultSet rs,int rowNum) throws SQLException{
			Map<String, Object> row = new HashMap<String, Object>();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			for(int i=1,size = rsMetaData.getColumnCount();i<=size;i++){
				row.put(rsMetaData.getColumnLabel(i).toLowerCase(), rs.getObject(i));
			}
			return row;
		}
	}

}

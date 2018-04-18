package dbconn;

import java.sql.Connection;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 
 * @author JinFeng
 * 获取数据库链接
 */
public class JDBCUtil {
	/*
	 * 更具配置文件，获取指定的数据库连接池
	 */
	private static DataSource dataSource;
	static{
		dataSource = new ComboPooledDataSource("sqlserver");
	}
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return conn;
	}
	/*
	 * 关闭指定的数据数据库链接
	 */
	public void closeConn(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

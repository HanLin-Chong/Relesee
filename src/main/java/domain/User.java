package domain;

import java.io.Serializable;

/*
 * 用户表
 */
public class User implements Serializable{
	private String username="";
	
	private String userid="";
	
	private String deptid="";
	
	private String password="";
	
	private int userauth=0;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserauth() {
		return userauth;
	}

	public void setUserauth(int userauth) {
		this.userauth = userauth;
	}

	@Override
	public String toString(){
		return "Username:"+username+"password:"+password+"userid"+userid;
	}
	
}


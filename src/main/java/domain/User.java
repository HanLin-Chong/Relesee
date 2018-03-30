package domain;

import java.io.Serializable;

/*
 * 用户表
 */
public class User implements Serializable{
	private String userName;
	
	private String userId;
	
	private String deptId;
	
	private String password;
	
	private int userAuth;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptid(String deptid) {
		this.deptId = deptid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passsword) {
		this.password = passsword;
	}

	public int getUserAuth() {
		return userAuth;
	}

	public void setUserAuth(int userAuth) {
		this.userAuth = userAuth;
	}
	
	
}


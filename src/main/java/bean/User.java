package bean;

import java.io.Serializable;

/*
 * 用户表
 */
public class User implements Serializable{
	private String username="";
	
	private String userid="";
	
	private String deptid="";
	
	private String passwold="";
	
	private String emial;
	
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

	public String getPasswold() {
		return passwold;
	}

	public void setPasswold(String password) {
		this.passwold = password;
	}

	public int getUserauth() {
		return userauth;
	}

	public void setUserauth(int userauth) {
		this.userauth = userauth;
	}

	@Override
	public String toString(){
		return "Username:"+username+"password:"+passwold+"userid"+userid;
	}
	
}


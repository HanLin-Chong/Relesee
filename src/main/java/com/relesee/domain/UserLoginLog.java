package domain;

import java.io.Serializable;
import java.util.Date;

public class UserLoginLog implements Serializable{
	private int LoginLogId;
	private String userId;
	private int userIp;
	private Date loginDate;
	public int getLoginLogId() {
		return LoginLogId;
	}
	public void setLoginLogId(int loginLogId) {
		LoginLogId = loginLogId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getUserIp() {
		return userIp;
	}
	public void setUserIp(int userIp) {
		this.userIp = userIp;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
}	

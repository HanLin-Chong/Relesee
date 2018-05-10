package com.relesee.bean;


/**
 * 
 * @author jinfeng
 *  客用户类型的枚举类 
 *  1表示客户经理的id， 2 表示管理的id
 */
public enum UserType {
	Customanager("MSID",1),Admin("ADID",2);
	private String userName;
	private int type;
	private UserType(String userType, int type){
		 this.userName = userType;
		 this.type = type;
	}
	
	/**
	 * @param index
	 * @return 
	 *  获取用户类型
	 */
	public static String getName(int index){
		for(UserType userType : UserType.values()){
			if(userType.getType() == index){
				return userType.getUserName();
			}
		}
		return null;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}

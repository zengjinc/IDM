package com.ssm.pojo.to;

public class UserQueryTo{
	//userUuid userName	userStatus
	private String userId;
	private String userName;
//	private String userOu;
	private String userBizRole;
	private String userStatus;
//	private String userType;
	private String trustResource;
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserBizRole() {
		return userBizRole;
	}

	public void setUserBizRole(String userBizRole) {
		this.userBizRole = userBizRole;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getTrustResource() {
		return trustResource;
	}

	public void setTrustResource(String trustResource) {
		this.trustResource = trustResource;
	}

}

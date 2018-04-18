	package com.ssm.pojo.to;

public class EntitlementTo {
	private String resUuid;
	private String resId;
	private String resName;
	private String acctTgtUuid;
	private String acctLoginId;
	private String acctPrimary;
	private Integer acctStatus;
	public String getResUuid() {
		return resUuid;
	}
	public void setResUuid(String resUuid) {
		this.resUuid = resUuid;
	}
	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public String getAcctTgtUuid() {
		return acctTgtUuid;
	}
	public void setAcctTgtUuid(String acctTgtUuid) {
		this.acctTgtUuid = acctTgtUuid;
	}
	public String getAcctLoginId() {
		return acctLoginId;
	}
	public void setAcctLoginId(String acctLoginId) {
		this.acctLoginId = acctLoginId;
	}
	public Integer getAcctStatus() {
		return acctStatus;
	}
	public void setAcctStatus(Integer acctStatus) {
		this.acctStatus = acctStatus;
	}
	public String getAcctPrimary() {
		return acctPrimary;
	}
	public void setAcctPrimary(String acctPrimary) {
		this.acctPrimary = acctPrimary;
	}
	
}

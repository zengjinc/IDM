package com.ssm.pojo;

public class AccessControlAct {
    private Integer actCode;

    private String actName;

    private String actDesc;

    public Integer getActCode() {
        return actCode;
    }

    public void setActCode(Integer actCode) {
        this.actCode = actCode;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName == null ? null : actName.trim();
    }

    public String getActDesc() {
        return actDesc;
    }

    public void setActDesc(String actDesc) {
        this.actDesc = actDesc == null ? null : actDesc.trim();
    }
}
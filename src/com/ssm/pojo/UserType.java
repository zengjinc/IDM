package com.ssm.pojo;

public class UserType {
    private String userTypeUuid;

    private String userTypeName;

    private String userTypeDesc;

    private Integer userTypeStatus;

    public String getUserTypeUuid() {
        return userTypeUuid;
    }

    public void setUserTypeUuid(String userTypeUuid) {
        this.userTypeUuid = userTypeUuid == null ? null : userTypeUuid.trim();
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName == null ? null : userTypeName.trim();
    }

    public String getUserTypeDesc() {
        return userTypeDesc;
    }

    public void setUserTypeDesc(String userTypeDesc) {
        this.userTypeDesc = userTypeDesc == null ? null : userTypeDesc.trim();
    }

    public Integer getUserTypeStatus() {
        return userTypeStatus;
    }

    public void setUserTypeStatus(Integer userTypeStatus) {
        this.userTypeStatus = userTypeStatus;
    }
}
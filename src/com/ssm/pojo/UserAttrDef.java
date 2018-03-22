package com.ssm.pojo;

public class UserAttrDef {
    private String userAttrDefUuid;

    private String userAttrDefKey;

    private String userAttrDefDatatype;

    private Integer userAttrDefStatus;

    public String getUserAttrDefUuid() {
        return userAttrDefUuid;
    }

    public void setUserAttrDefUuid(String userAttrDefUuid) {
        this.userAttrDefUuid = userAttrDefUuid == null ? null : userAttrDefUuid.trim();
    }

    public String getUserAttrDefKey() {
        return userAttrDefKey;
    }

    public void setUserAttrDefKey(String userAttrDefKey) {
        this.userAttrDefKey = userAttrDefKey == null ? null : userAttrDefKey.trim();
    }

    public String getUserAttrDefDatatype() {
        return userAttrDefDatatype;
    }

    public void setUserAttrDefDatatype(String userAttrDefDatatype) {
        this.userAttrDefDatatype = userAttrDefDatatype == null ? null : userAttrDefDatatype.trim();
    }

    public Integer getUserAttrDefStatus() {
        return userAttrDefStatus;
    }

    public void setUserAttrDefStatus(Integer userAttrDefStatus) {
        this.userAttrDefStatus = userAttrDefStatus;
    }
}
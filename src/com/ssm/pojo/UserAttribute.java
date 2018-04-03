package com.ssm.pojo;

public class UserAttribute {
    private String userAttrUuid;

    private String userUuid;

    private String userAttrDefUuid;

    private String userAttriValue;

    public String getUserAttrUuid() {
        return userAttrUuid;
    }

    public void setUserAttrUuid(String userAttrUuid) {
        this.userAttrUuid = userAttrUuid == null ? null : userAttrUuid.trim();
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid == null ? null : userUuid.trim();
    }

    public String getUserAttrDefUuid() {
        return userAttrDefUuid;
    }

    public void setUserAttrDefUuid(String userAttrDefUuid) {
        this.userAttrDefUuid = userAttrDefUuid == null ? null : userAttrDefUuid.trim();
    }

    public String getUserAttriValue() {
        return userAttriValue;
    }

    public void setUserAttriValue(String userAttriValue) {
        this.userAttriValue = userAttriValue == null ? null : userAttriValue.trim();
    }
}
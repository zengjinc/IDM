package com.ssm.pojo;

public class UserAttribute {
    private String userAttrUuid;

    private String userUuid;

    private String userAttrDefKey;

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

    public String getUserAttrDefKey() {
        return userAttrDefKey;
    }

    public void setUserAttrDefKey(String userAttrDefKey) {
        this.userAttrDefKey = userAttrDefKey == null ? null : userAttrDefKey.trim();
    }

    public String getUserAttriValue() {
        return userAttriValue;
    }

    public void setUserAttriValue(String userAttriValue) {
        this.userAttriValue = userAttriValue == null ? null : userAttriValue.trim();
    }
}
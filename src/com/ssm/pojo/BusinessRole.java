package com.ssm.pojo;

public class BusinessRole {
    private String bizRoleUuid;

    private String bizRoleId;

    private String bizRoleName;

    private String bizRoleDesc;

    public String getBizRoleUuid() {
        return bizRoleUuid;
    }

    public void setBizRoleUuid(String bizRoleUuid) {
        this.bizRoleUuid = bizRoleUuid == null ? null : bizRoleUuid.trim();
    }

    public String getBizRoleId() {
        return bizRoleId;
    }

    public void setBizRoleId(String bizRoleId) {
        this.bizRoleId = bizRoleId == null ? null : bizRoleId.trim();
    }

    public String getBizRoleName() {
        return bizRoleName;
    }

    public void setBizRoleName(String bizRoleName) {
        this.bizRoleName = bizRoleName == null ? null : bizRoleName.trim();
    }

    public String getBizRoleDesc() {
        return bizRoleDesc;
    }

    public void setBizRoleDesc(String bizRoleDesc) {
        this.bizRoleDesc = bizRoleDesc == null ? null : bizRoleDesc.trim();
    }
}
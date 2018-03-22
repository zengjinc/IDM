package com.ssm.pojo;

public class Itrole {
    private String itroleUuid;

    private String itroleId;

    private String itroleName;

    private String itroleDesc;

    private String itroleResUuid;

    private String itroleTgtRoleUuid;

    public String getItroleUuid() {
        return itroleUuid;
    }

    public void setItroleUuid(String itroleUuid) {
        this.itroleUuid = itroleUuid == null ? null : itroleUuid.trim();
    }

    public String getItroleId() {
        return itroleId;
    }

    public void setItroleId(String itroleId) {
        this.itroleId = itroleId == null ? null : itroleId.trim();
    }

    public String getItroleName() {
        return itroleName;
    }

    public void setItroleName(String itroleName) {
        this.itroleName = itroleName == null ? null : itroleName.trim();
    }

    public String getItroleDesc() {
        return itroleDesc;
    }

    public void setItroleDesc(String itroleDesc) {
        this.itroleDesc = itroleDesc == null ? null : itroleDesc.trim();
    }

    public String getItroleResUuid() {
        return itroleResUuid;
    }

    public void setItroleResUuid(String itroleResUuid) {
        this.itroleResUuid = itroleResUuid == null ? null : itroleResUuid.trim();
    }

    public String getItroleTgtRoleUuid() {
        return itroleTgtRoleUuid;
    }

    public void setItroleTgtRoleUuid(String itroleTgtRoleUuid) {
        this.itroleTgtRoleUuid = itroleTgtRoleUuid == null ? null : itroleTgtRoleUuid.trim();
    }
}
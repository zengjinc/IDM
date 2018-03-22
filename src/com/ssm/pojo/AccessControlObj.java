package com.ssm.pojo;

public class AccessControlObj {
    private Integer objCode;

    private String objName;

    private String bojDesc;

    public Integer getObjCode() {
        return objCode;
    }

    public void setObjCode(Integer objCode) {
        this.objCode = objCode;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName == null ? null : objName.trim();
    }

    public String getBojDesc() {
        return bojDesc;
    }

    public void setBojDesc(String bojDesc) {
        this.bojDesc = bojDesc == null ? null : bojDesc.trim();
    }
}
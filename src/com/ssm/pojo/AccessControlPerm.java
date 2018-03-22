package com.ssm.pojo;

public class AccessControlPerm {
    private Integer roleCode;

    private Integer objCode;

    private Integer actCode;

    public Integer getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(Integer roleCode) {
        this.roleCode = roleCode;
    }

    public Integer getObjCode() {
        return objCode;
    }

    public void setObjCode(Integer objCode) {
        this.objCode = objCode;
    }

    public Integer getActCode() {
        return actCode;
    }

    public void setActCode(Integer actCode) {
        this.actCode = actCode;
    }
}
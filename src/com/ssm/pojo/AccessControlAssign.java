package com.ssm.pojo;

public class AccessControlAssign {
    private String assgUserUuid;

    private Integer assgObjCode;

    private Integer assgRoleCode;

    private Integer assgScpCode;

    private String assgDesc;

    public String getAssgUserUuid() {
        return assgUserUuid;
    }

    public void setAssgUserUuid(String assgUserUuid) {
        this.assgUserUuid = assgUserUuid == null ? null : assgUserUuid.trim();
    }

    public Integer getAssgObjCode() {
        return assgObjCode;
    }

    public void setAssgObjCode(Integer assgObjCode) {
        this.assgObjCode = assgObjCode;
    }

    public Integer getAssgRoleCode() {
        return assgRoleCode;
    }

    public void setAssgRoleCode(Integer assgRoleCode) {
        this.assgRoleCode = assgRoleCode;
    }

    public Integer getAssgScpCode() {
        return assgScpCode;
    }

    public void setAssgScpCode(Integer assgScpCode) {
        this.assgScpCode = assgScpCode;
    }

    public String getAssgDesc() {
        return assgDesc;
    }

    public void setAssgDesc(String assgDesc) {
        this.assgDesc = assgDesc == null ? null : assgDesc.trim();
    }
}
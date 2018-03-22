package com.ssm.pojo;

public class RelUserBizrole {
    private String relUserBizroleUserUuid;

    private String relUserBizroleBizroleUuid;

    private String relUserBizroleDesc;

    private String relUserBizrolePolUuid;

    public String getRelUserBizroleUserUuid() {
        return relUserBizroleUserUuid;
    }

    public void setRelUserBizroleUserUuid(String relUserBizroleUserUuid) {
        this.relUserBizroleUserUuid = relUserBizroleUserUuid == null ? null : relUserBizroleUserUuid.trim();
    }

    public String getRelUserBizroleBizroleUuid() {
        return relUserBizroleBizroleUuid;
    }

    public void setRelUserBizroleBizroleUuid(String relUserBizroleBizroleUuid) {
        this.relUserBizroleBizroleUuid = relUserBizroleBizroleUuid == null ? null : relUserBizroleBizroleUuid.trim();
    }

    public String getRelUserBizroleDesc() {
        return relUserBizroleDesc;
    }

    public void setRelUserBizroleDesc(String relUserBizroleDesc) {
        this.relUserBizroleDesc = relUserBizroleDesc == null ? null : relUserBizroleDesc.trim();
    }

    public String getRelUserBizrolePolUuid() {
        return relUserBizrolePolUuid;
    }

    public void setRelUserBizrolePolUuid(String relUserBizrolePolUuid) {
        this.relUserBizrolePolUuid = relUserBizrolePolUuid == null ? null : relUserBizrolePolUuid.trim();
    }
}
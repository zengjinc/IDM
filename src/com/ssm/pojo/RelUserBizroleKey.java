package com.ssm.pojo;

public class RelUserBizroleKey {
    private String relUserBizroleUserUuid;

    private String relUserBizroleBizroleUuid;

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
}
package com.ssm.pojo;

public class RelUserBizrole extends RelUserBizroleKey {
    private String relUserBizroleDesc;

    private String relUserBizrolePolUuid;

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
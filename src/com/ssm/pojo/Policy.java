package com.ssm.pojo;

public class Policy {
    private String polUuid;

    private String polId;

    private String polName;

    private String polDesc;

    private String polType;

    private String polJsonStr;

    public String getPolUuid() {
        return polUuid;
    }

    public void setPolUuid(String polUuid) {
        this.polUuid = polUuid == null ? null : polUuid.trim();
    }

    public String getPolId() {
        return polId;
    }

    public void setPolId(String polId) {
        this.polId = polId == null ? null : polId.trim();
    }

    public String getPolName() {
        return polName;
    }

    public void setPolName(String polName) {
        this.polName = polName == null ? null : polName.trim();
    }

    public String getPolDesc() {
        return polDesc;
    }

    public void setPolDesc(String polDesc) {
        this.polDesc = polDesc == null ? null : polDesc.trim();
    }

    public String getPolType() {
        return polType;
    }

    public void setPolType(String polType) {
        this.polType = polType == null ? null : polType.trim();
    }

    public String getPolJsonStr() {
        return polJsonStr;
    }

    public void setPolJsonStr(String polJsonStr) {
        this.polJsonStr = polJsonStr == null ? null : polJsonStr.trim();
    }
}
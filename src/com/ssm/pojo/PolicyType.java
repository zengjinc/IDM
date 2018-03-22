package com.ssm.pojo;

public class PolicyType {
    private String polTypeUuid;

    private String polTypeName;

    private String polTypeNameDesc;

    public String getPolTypeUuid() {
        return polTypeUuid;
    }

    public void setPolTypeUuid(String polTypeUuid) {
        this.polTypeUuid = polTypeUuid == null ? null : polTypeUuid.trim();
    }

    public String getPolTypeName() {
        return polTypeName;
    }

    public void setPolTypeName(String polTypeName) {
        this.polTypeName = polTypeName == null ? null : polTypeName.trim();
    }

    public String getPolTypeNameDesc() {
        return polTypeNameDesc;
    }

    public void setPolTypeNameDesc(String polTypeNameDesc) {
        this.polTypeNameDesc = polTypeNameDesc == null ? null : polTypeNameDesc.trim();
    }
}
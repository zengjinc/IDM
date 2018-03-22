package com.ssm.pojo;

public class ResourceType {
    private String resTypeUuid;

    private String resTypeName;

    private String resTypeHandler;

    public String getResTypeUuid() {
        return resTypeUuid;
    }

    public void setResTypeUuid(String resTypeUuid) {
        this.resTypeUuid = resTypeUuid == null ? null : resTypeUuid.trim();
    }

    public String getResTypeName() {
        return resTypeName;
    }

    public void setResTypeName(String resTypeName) {
        this.resTypeName = resTypeName == null ? null : resTypeName.trim();
    }

    public String getResTypeHandler() {
        return resTypeHandler;
    }

    public void setResTypeHandler(String resTypeHandler) {
        this.resTypeHandler = resTypeHandler == null ? null : resTypeHandler.trim();
    }
}
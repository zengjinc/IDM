package com.ssm.pojo;

public class Resource {
    private String resUuid;

    private String resId;

    private String resName;

    private String resDesc;

    private Integer resTrust;

    private String resTypeUuid;

    public String getResUuid() {
        return resUuid;
    }

    public void setResUuid(String resUuid) {
        this.resUuid = resUuid == null ? null : resUuid.trim();
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId == null ? null : resId.trim();
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName == null ? null : resName.trim();
    }

    public String getResDesc() {
        return resDesc;
    }

    public void setResDesc(String resDesc) {
        this.resDesc = resDesc == null ? null : resDesc.trim();
    }

    public Integer getResTrust() {
        return resTrust;
    }

    public void setResTrust(Integer resTrust) {
        this.resTrust = resTrust;
    }

    public String getResTypeUuid() {
        return resTypeUuid;
    }

    public void setResTypeUuid(String resTypeUuid) {
        this.resTypeUuid = resTypeUuid == null ? null : resTypeUuid.trim();
    }
}
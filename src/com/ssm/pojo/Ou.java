package com.ssm.pojo;

import java.util.Date;

public class Ou {
    private String ouUuid;

    private String ouResUuid;

    private Integer ouType;

    private String ouId;

    private String ouName;

    private String ouName2;

    private String ouDesc;

    private String ouManagerUuid;

    private String ouParentUuid;

    private String ouTgtUuid;

    private Date ouLastReconTime;

    private String oucol;

    public String getOuUuid() {
        return ouUuid;
    }

    public void setOuUuid(String ouUuid) {
        this.ouUuid = ouUuid == null ? null : ouUuid.trim();
    }

    public String getOuResUuid() {
        return ouResUuid;
    }

    public void setOuResUuid(String ouResUuid) {
        this.ouResUuid = ouResUuid == null ? null : ouResUuid.trim();
    }

    public Integer getOuType() {
        return ouType;
    }

    public void setOuType(Integer ouType) {
        this.ouType = ouType;
    }

    public String getOuId() {
        return ouId;
    }

    public void setOuId(String ouId) {
        this.ouId = ouId == null ? null : ouId.trim();
    }

    public String getOuName() {
        return ouName;
    }

    public void setOuName(String ouName) {
        this.ouName = ouName == null ? null : ouName.trim();
    }

    public String getOuName2() {
        return ouName2;
    }

    public void setOuName2(String ouName2) {
        this.ouName2 = ouName2 == null ? null : ouName2.trim();
    }

    public String getOuDesc() {
        return ouDesc;
    }

    public void setOuDesc(String ouDesc) {
        this.ouDesc = ouDesc == null ? null : ouDesc.trim();
    }

    public String getOuManagerUuid() {
        return ouManagerUuid;
    }

    public void setOuManagerUuid(String ouManagerUuid) {
        this.ouManagerUuid = ouManagerUuid == null ? null : ouManagerUuid.trim();
    }

    public String getOuParentUuid() {
        return ouParentUuid;
    }

    public void setOuParentUuid(String ouParentUuid) {
        this.ouParentUuid = ouParentUuid == null ? null : ouParentUuid.trim();
    }

    public String getOuTgtUuid() {
        return ouTgtUuid;
    }

    public void setOuTgtUuid(String ouTgtUuid) {
        this.ouTgtUuid = ouTgtUuid == null ? null : ouTgtUuid.trim();
    }

    public Date getOuLastReconTime() {
        return ouLastReconTime;
    }

    public void setOuLastReconTime(Date ouLastReconTime) {
        this.ouLastReconTime = ouLastReconTime;
    }

    public String getOucol() {
        return oucol;
    }

    public void setOucol(String oucol) {
        this.oucol = oucol == null ? null : oucol.trim();
    }
}
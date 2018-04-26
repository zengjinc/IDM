package com.ssm.pojo;

import java.util.Date;

public class Entitlement extends EntitlementKey {
    private Integer etmStatus;

    private String etmPolUuid;

    private String etmCreatorUuid;

    private Date etmCreateTime;

    private String etmModifierUuid;

    private Date etmModifiedTime;

    public Integer getEtmStatus() {
        return etmStatus;
    }

    public void setEtmStatus(Integer etmStatus) {
        this.etmStatus = etmStatus;
    }

    public String getEtmPolUuid() {
        return etmPolUuid;
    }

    public void setEtmPolUuid(String etmPolUuid) {
        this.etmPolUuid = etmPolUuid == null ? null : etmPolUuid.trim();
    }

    public String getEtmCreatorUuid() {
        return etmCreatorUuid;
    }

    public void setEtmCreatorUuid(String etmCreatorUuid) {
        this.etmCreatorUuid = etmCreatorUuid == null ? null : etmCreatorUuid.trim();
    }

    public Date getEtmCreateTime() {
        return etmCreateTime;
    }

    public void setEtmCreateTime(Date etmCreateTime) {
        this.etmCreateTime = etmCreateTime;
    }

    public String getEtmModifierUuid() {
        return etmModifierUuid;
    }

    public void setEtmModifierUuid(String etmModifierUuid) {
        this.etmModifierUuid = etmModifierUuid == null ? null : etmModifierUuid.trim();
    }

    public Date getEtmModifiedTime() {
        return etmModifiedTime;
    }

    public void setEtmModifiedTime(Date etmModifiedTime) {
        this.etmModifiedTime = etmModifiedTime;
    }
}
package com.ssm.pojo;

import java.util.Date;

public class Entitlement {
    private String etmUserUuid;

    private String etmAcctUuid;

    private Integer etmStatus;

    private String etmCreatorUuid;

    private Date etmCreateTime;

    private String etmModifierUuid;

    private Date etmModifiedTime;

    public String getEtmUserUuid() {
        return etmUserUuid;
    }

    public void setEtmUserUuid(String etmUserUuid) {
        this.etmUserUuid = etmUserUuid == null ? null : etmUserUuid.trim();
    }

    public String getEtmAcctUuid() {
        return etmAcctUuid;
    }

    public void setEtmAcctUuid(String etmAcctUuid) {
        this.etmAcctUuid = etmAcctUuid == null ? null : etmAcctUuid.trim();
    }

    public Integer getEtmStatus() {
        return etmStatus;
    }

    public void setEtmStatus(Integer etmStatus) {
        this.etmStatus = etmStatus;
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
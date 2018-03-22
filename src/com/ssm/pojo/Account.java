package com.ssm.pojo;

import java.util.Date;

public class Account {
    private String acctUuid;

    private String acctLoginId;

    private String acctResUuid;

    private String acctTgtUuid;

    private Integer acctPrimary;

    private Integer acctStatus;

    private String acctCreateorUuid;

    private Date acctCreatetime;

    private String acctModifierUuid;

    private Date acctModifiedtime;

    private Date acctLastReconTime;

    private String acctNextTask;

    public String getAcctUuid() {
        return acctUuid;
    }

    public void setAcctUuid(String acctUuid) {
        this.acctUuid = acctUuid == null ? null : acctUuid.trim();
    }

    public String getAcctLoginId() {
        return acctLoginId;
    }

    public void setAcctLoginId(String acctLoginId) {
        this.acctLoginId = acctLoginId == null ? null : acctLoginId.trim();
    }

    public String getAcctResUuid() {
        return acctResUuid;
    }

    public void setAcctResUuid(String acctResUuid) {
        this.acctResUuid = acctResUuid == null ? null : acctResUuid.trim();
    }

    public String getAcctTgtUuid() {
        return acctTgtUuid;
    }

    public void setAcctTgtUuid(String acctTgtUuid) {
        this.acctTgtUuid = acctTgtUuid == null ? null : acctTgtUuid.trim();
    }

    public Integer getAcctPrimary() {
        return acctPrimary;
    }

    public void setAcctPrimary(Integer acctPrimary) {
        this.acctPrimary = acctPrimary;
    }

    public Integer getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(Integer acctStatus) {
        this.acctStatus = acctStatus;
    }

    public String getAcctCreateorUuid() {
        return acctCreateorUuid;
    }

    public void setAcctCreateorUuid(String acctCreateorUuid) {
        this.acctCreateorUuid = acctCreateorUuid == null ? null : acctCreateorUuid.trim();
    }

    public Date getAcctCreatetime() {
        return acctCreatetime;
    }

    public void setAcctCreatetime(Date acctCreatetime) {
        this.acctCreatetime = acctCreatetime;
    }

    public String getAcctModifierUuid() {
        return acctModifierUuid;
    }

    public void setAcctModifierUuid(String acctModifierUuid) {
        this.acctModifierUuid = acctModifierUuid == null ? null : acctModifierUuid.trim();
    }

    public Date getAcctModifiedtime() {
        return acctModifiedtime;
    }

    public void setAcctModifiedtime(Date acctModifiedtime) {
        this.acctModifiedtime = acctModifiedtime;
    }

    public Date getAcctLastReconTime() {
        return acctLastReconTime;
    }

    public void setAcctLastReconTime(Date acctLastReconTime) {
        this.acctLastReconTime = acctLastReconTime;
    }

    public String getAcctNextTask() {
        return acctNextTask;
    }

    public void setAcctNextTask(String acctNextTask) {
        this.acctNextTask = acctNextTask == null ? null : acctNextTask.trim();
    }
}
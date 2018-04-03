package com.ssm.pojo;

import java.util.Date;

public class Schedulejob {
    private String scdUuid;

    private String scdId;

    private String scdName;

    private String scdJobGroup;

    private String scdCron;

    private Date scdLastRunTime;

    private Date scdNextRunTime;

    private String scdJobType;

    private String scdDesc;

    private Integer scdStatus;

    private String scdJsonAttr;

    public String getScdUuid() {
        return scdUuid;
    }

    public void setScdUuid(String scdUuid) {
        this.scdUuid = scdUuid == null ? null : scdUuid.trim();
    }

    public String getScdId() {
        return scdId;
    }

    public void setScdId(String scdId) {
        this.scdId = scdId == null ? null : scdId.trim();
    }

    public String getScdName() {
        return scdName;
    }

    public void setScdName(String scdName) {
        this.scdName = scdName == null ? null : scdName.trim();
    }

    public String getScdJobGroup() {
        return scdJobGroup;
    }

    public void setScdJobGroup(String scdJobGroup) {
        this.scdJobGroup = scdJobGroup == null ? null : scdJobGroup.trim();
    }

    public String getScdCron() {
        return scdCron;
    }

    public void setScdCron(String scdCron) {
        this.scdCron = scdCron == null ? null : scdCron.trim();
    }

    public Date getScdLastRunTime() {
        return scdLastRunTime;
    }

    public void setScdLastRunTime(Date scdLastRunTime) {
        this.scdLastRunTime = scdLastRunTime;
    }

    public Date getScdNextRunTime() {
        return scdNextRunTime;
    }

    public void setScdNextRunTime(Date scdNextRunTime) {
        this.scdNextRunTime = scdNextRunTime;
    }

    public String getScdJobType() {
        return scdJobType;
    }

    public void setScdJobType(String scdJobType) {
        this.scdJobType = scdJobType == null ? null : scdJobType.trim();
    }

    public String getScdDesc() {
        return scdDesc;
    }

    public void setScdDesc(String scdDesc) {
        this.scdDesc = scdDesc == null ? null : scdDesc.trim();
    }

    public Integer getScdStatus() {
        return scdStatus;
    }

    public void setScdStatus(Integer scdStatus) {
        this.scdStatus = scdStatus;
    }

    public String getScdJsonAttr() {
        return scdJsonAttr;
    }

    public void setScdJsonAttr(String scdJsonAttr) {
        this.scdJsonAttr = scdJsonAttr == null ? null : scdJsonAttr.trim();
    }
}
package com.ssm.pojo;

import java.util.Date;

public class Privilege {
    private String pvgUuid;

    private String pvgAcctUuid;

    private String pvgItroleUuid;

    private String pvgPolUuid;

    private String pvgCreatorUuid;

    private Date pvgCreateTime;

    private String pvgModifier;

    private Date pvgModifiedTime;

    public String getPvgUuid() {
        return pvgUuid;
    }

    public void setPvgUuid(String pvgUuid) {
        this.pvgUuid = pvgUuid == null ? null : pvgUuid.trim();
    }

    public String getPvgAcctUuid() {
        return pvgAcctUuid;
    }

    public void setPvgAcctUuid(String pvgAcctUuid) {
        this.pvgAcctUuid = pvgAcctUuid == null ? null : pvgAcctUuid.trim();
    }

    public String getPvgItroleUuid() {
        return pvgItroleUuid;
    }

    public void setPvgItroleUuid(String pvgItroleUuid) {
        this.pvgItroleUuid = pvgItroleUuid == null ? null : pvgItroleUuid.trim();
    }

    public String getPvgPolUuid() {
        return pvgPolUuid;
    }

    public void setPvgPolUuid(String pvgPolUuid) {
        this.pvgPolUuid = pvgPolUuid == null ? null : pvgPolUuid.trim();
    }

    public String getPvgCreatorUuid() {
        return pvgCreatorUuid;
    }

    public void setPvgCreatorUuid(String pvgCreatorUuid) {
        this.pvgCreatorUuid = pvgCreatorUuid == null ? null : pvgCreatorUuid.trim();
    }

    public Date getPvgCreateTime() {
        return pvgCreateTime;
    }

    public void setPvgCreateTime(Date pvgCreateTime) {
        this.pvgCreateTime = pvgCreateTime;
    }

    public String getPvgModifier() {
        return pvgModifier;
    }

    public void setPvgModifier(String pvgModifier) {
        this.pvgModifier = pvgModifier == null ? null : pvgModifier.trim();
    }

    public Date getPvgModifiedTime() {
        return pvgModifiedTime;
    }

    public void setPvgModifiedTime(Date pvgModifiedTime) {
        this.pvgModifiedTime = pvgModifiedTime;
    }
}
package com.ssm.pojo;

import java.util.Date;

public class Schedulejob {
    private String scdUuid;

    private String csdCron;

    private Date scdLastRunTime;

    private Date scdNextRunTime;

    private String schedulejobcol;

    public String getScdUuid() {
        return scdUuid;
    }

    public void setScdUuid(String scdUuid) {
        this.scdUuid = scdUuid == null ? null : scdUuid.trim();
    }

    public String getCsdCron() {
        return csdCron;
    }

    public void setCsdCron(String csdCron) {
        this.csdCron = csdCron == null ? null : csdCron.trim();
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

    public String getSchedulejobcol() {
        return schedulejobcol;
    }

    public void setSchedulejobcol(String schedulejobcol) {
        this.schedulejobcol = schedulejobcol == null ? null : schedulejobcol.trim();
    }
}
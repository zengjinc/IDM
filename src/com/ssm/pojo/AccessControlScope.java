package com.ssm.pojo;

public class AccessControlScope {
    private Integer scpCode;

    private String scpName;

    private String scpDesc;

    private String scpHandler;

    public Integer getScpCode() {
        return scpCode;
    }

    public void setScpCode(Integer scpCode) {
        this.scpCode = scpCode;
    }

    public String getScpName() {
        return scpName;
    }

    public void setScpName(String scpName) {
        this.scpName = scpName == null ? null : scpName.trim();
    }

    public String getScpDesc() {
        return scpDesc;
    }

    public void setScpDesc(String scpDesc) {
        this.scpDesc = scpDesc == null ? null : scpDesc.trim();
    }

    public String getScpHandler() {
        return scpHandler;
    }

    public void setScpHandler(String scpHandler) {
        this.scpHandler = scpHandler == null ? null : scpHandler.trim();
    }
}
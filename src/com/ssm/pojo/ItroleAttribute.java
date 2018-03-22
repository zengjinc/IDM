package com.ssm.pojo;

public class ItroleAttribute {
    private String itroleAttrItroleUuid;

    private String itroleAttrItroleKey;

    private String itroleAttrItroleVal;

    public String getItroleAttrItroleUuid() {
        return itroleAttrItroleUuid;
    }

    public void setItroleAttrItroleUuid(String itroleAttrItroleUuid) {
        this.itroleAttrItroleUuid = itroleAttrItroleUuid == null ? null : itroleAttrItroleUuid.trim();
    }

    public String getItroleAttrItroleKey() {
        return itroleAttrItroleKey;
    }

    public void setItroleAttrItroleKey(String itroleAttrItroleKey) {
        this.itroleAttrItroleKey = itroleAttrItroleKey == null ? null : itroleAttrItroleKey.trim();
    }

    public String getItroleAttrItroleVal() {
        return itroleAttrItroleVal;
    }

    public void setItroleAttrItroleVal(String itroleAttrItroleVal) {
        this.itroleAttrItroleVal = itroleAttrItroleVal == null ? null : itroleAttrItroleVal.trim();
    }
}
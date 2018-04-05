package com.ssm.pojo;

public class ItroleAttribute extends ItroleAttributeKey {
    private String itroleAttrItroleVal;

    public String getItroleAttrItroleVal() {
        return itroleAttrItroleVal;
    }

    public void setItroleAttrItroleVal(String itroleAttrItroleVal) {
        this.itroleAttrItroleVal = itroleAttrItroleVal == null ? null : itroleAttrItroleVal.trim();
    }
}
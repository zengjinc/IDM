package com.ssm.pojo;

public class ResourceAttribute {
    private String resAttrResUuid;

    private String resAttrName;

    private String resAttrDatatype;

    private String resAttrValue;

    public String getResAttrResUuid() {
        return resAttrResUuid;
    }

    public void setResAttrResUuid(String resAttrResUuid) {
        this.resAttrResUuid = resAttrResUuid == null ? null : resAttrResUuid.trim();
    }

    public String getResAttrName() {
        return resAttrName;
    }

    public void setResAttrName(String resAttrName) {
        this.resAttrName = resAttrName == null ? null : resAttrName.trim();
    }

    public String getResAttrDatatype() {
        return resAttrDatatype;
    }

    public void setResAttrDatatype(String resAttrDatatype) {
        this.resAttrDatatype = resAttrDatatype == null ? null : resAttrDatatype.trim();
    }

    public String getResAttrValue() {
        return resAttrValue;
    }

    public void setResAttrValue(String resAttrValue) {
        this.resAttrValue = resAttrValue == null ? null : resAttrValue.trim();
    }
}
package com.ssm.pojo;

public class SchedulejobAttribute {
    private String scdAttrScdUuid;

    private String scdAttrDatatype;

    private String scdAttrName;

    private String scdAttrVal;

    public String getScdAttrScdUuid() {
        return scdAttrScdUuid;
    }

    public void setScdAttrScdUuid(String scdAttrScdUuid) {
        this.scdAttrScdUuid = scdAttrScdUuid == null ? null : scdAttrScdUuid.trim();
    }

    public String getScdAttrDatatype() {
        return scdAttrDatatype;
    }

    public void setScdAttrDatatype(String scdAttrDatatype) {
        this.scdAttrDatatype = scdAttrDatatype == null ? null : scdAttrDatatype.trim();
    }

    public String getScdAttrName() {
        return scdAttrName;
    }

    public void setScdAttrName(String scdAttrName) {
        this.scdAttrName = scdAttrName == null ? null : scdAttrName.trim();
    }

    public String getScdAttrVal() {
        return scdAttrVal;
    }

    public void setScdAttrVal(String scdAttrVal) {
        this.scdAttrVal = scdAttrVal == null ? null : scdAttrVal.trim();
    }
}
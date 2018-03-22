package com.ssm.pojo;

public class PolicyAttribute {
    private String polAttrPolUuid;

    private String polAttrDatatype;

    private String polAttrName;

    private String polAttrVal;

    public String getPolAttrPolUuid() {
        return polAttrPolUuid;
    }

    public void setPolAttrPolUuid(String polAttrPolUuid) {
        this.polAttrPolUuid = polAttrPolUuid == null ? null : polAttrPolUuid.trim();
    }

    public String getPolAttrDatatype() {
        return polAttrDatatype;
    }

    public void setPolAttrDatatype(String polAttrDatatype) {
        this.polAttrDatatype = polAttrDatatype == null ? null : polAttrDatatype.trim();
    }

    public String getPolAttrName() {
        return polAttrName;
    }

    public void setPolAttrName(String polAttrName) {
        this.polAttrName = polAttrName == null ? null : polAttrName.trim();
    }

    public String getPolAttrVal() {
        return polAttrVal;
    }

    public void setPolAttrVal(String polAttrVal) {
        this.polAttrVal = polAttrVal == null ? null : polAttrVal.trim();
    }
}
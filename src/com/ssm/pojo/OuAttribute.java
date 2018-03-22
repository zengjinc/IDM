package com.ssm.pojo;

public class OuAttribute {
    private String ouAttrUuid;

    private String ouUuid;

    private String ouAttrDefKey;

    private String ouAttrVal;

    public String getOuAttrUuid() {
        return ouAttrUuid;
    }

    public void setOuAttrUuid(String ouAttrUuid) {
        this.ouAttrUuid = ouAttrUuid == null ? null : ouAttrUuid.trim();
    }

    public String getOuUuid() {
        return ouUuid;
    }

    public void setOuUuid(String ouUuid) {
        this.ouUuid = ouUuid == null ? null : ouUuid.trim();
    }

    public String getOuAttrDefKey() {
        return ouAttrDefKey;
    }

    public void setOuAttrDefKey(String ouAttrDefKey) {
        this.ouAttrDefKey = ouAttrDefKey == null ? null : ouAttrDefKey.trim();
    }

    public String getOuAttrVal() {
        return ouAttrVal;
    }

    public void setOuAttrVal(String ouAttrVal) {
        this.ouAttrVal = ouAttrVal == null ? null : ouAttrVal.trim();
    }
}
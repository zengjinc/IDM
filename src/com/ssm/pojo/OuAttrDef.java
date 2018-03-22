package com.ssm.pojo;

public class OuAttrDef {
    private String ouAttrDefUuid;

    private String ouAttrDefKey;

    private String ouAttrDefName;

    private String ouAttrDefDatatype;

    private Integer ouAttrDefMandatory;

    private Integer ouAttrDefEditable;

    private String ouAttrDefMax;

    private String ouAttrDefMin;

    private String ouAttrDefResUuid;

    public String getOuAttrDefUuid() {
        return ouAttrDefUuid;
    }

    public void setOuAttrDefUuid(String ouAttrDefUuid) {
        this.ouAttrDefUuid = ouAttrDefUuid == null ? null : ouAttrDefUuid.trim();
    }

    public String getOuAttrDefKey() {
        return ouAttrDefKey;
    }

    public void setOuAttrDefKey(String ouAttrDefKey) {
        this.ouAttrDefKey = ouAttrDefKey == null ? null : ouAttrDefKey.trim();
    }

    public String getOuAttrDefName() {
        return ouAttrDefName;
    }

    public void setOuAttrDefName(String ouAttrDefName) {
        this.ouAttrDefName = ouAttrDefName == null ? null : ouAttrDefName.trim();
    }

    public String getOuAttrDefDatatype() {
        return ouAttrDefDatatype;
    }

    public void setOuAttrDefDatatype(String ouAttrDefDatatype) {
        this.ouAttrDefDatatype = ouAttrDefDatatype == null ? null : ouAttrDefDatatype.trim();
    }

    public Integer getOuAttrDefMandatory() {
        return ouAttrDefMandatory;
    }

    public void setOuAttrDefMandatory(Integer ouAttrDefMandatory) {
        this.ouAttrDefMandatory = ouAttrDefMandatory;
    }

    public Integer getOuAttrDefEditable() {
        return ouAttrDefEditable;
    }

    public void setOuAttrDefEditable(Integer ouAttrDefEditable) {
        this.ouAttrDefEditable = ouAttrDefEditable;
    }

    public String getOuAttrDefMax() {
        return ouAttrDefMax;
    }

    public void setOuAttrDefMax(String ouAttrDefMax) {
        this.ouAttrDefMax = ouAttrDefMax == null ? null : ouAttrDefMax.trim();
    }

    public String getOuAttrDefMin() {
        return ouAttrDefMin;
    }

    public void setOuAttrDefMin(String ouAttrDefMin) {
        this.ouAttrDefMin = ouAttrDefMin == null ? null : ouAttrDefMin.trim();
    }

    public String getOuAttrDefResUuid() {
        return ouAttrDefResUuid;
    }

    public void setOuAttrDefResUuid(String ouAttrDefResUuid) {
        this.ouAttrDefResUuid = ouAttrDefResUuid == null ? null : ouAttrDefResUuid.trim();
    }
}
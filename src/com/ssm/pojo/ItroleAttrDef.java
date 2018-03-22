package com.ssm.pojo;

public class ItroleAttrDef {
    private String itroleAttrDefKey;

    private String itroleAttrDefName;

    private String itroleAttrDefDatatype;

    private Integer itroleAttrDefMandatory;

    private Integer itroleAttrDefEditable;

    private String itroleAttrDefMax;

    private String itroleAttrDefMin;

    private String itroleAttrDefResUuid;

    public String getItroleAttrDefKey() {
        return itroleAttrDefKey;
    }

    public void setItroleAttrDefKey(String itroleAttrDefKey) {
        this.itroleAttrDefKey = itroleAttrDefKey == null ? null : itroleAttrDefKey.trim();
    }

    public String getItroleAttrDefName() {
        return itroleAttrDefName;
    }

    public void setItroleAttrDefName(String itroleAttrDefName) {
        this.itroleAttrDefName = itroleAttrDefName == null ? null : itroleAttrDefName.trim();
    }

    public String getItroleAttrDefDatatype() {
        return itroleAttrDefDatatype;
    }

    public void setItroleAttrDefDatatype(String itroleAttrDefDatatype) {
        this.itroleAttrDefDatatype = itroleAttrDefDatatype == null ? null : itroleAttrDefDatatype.trim();
    }

    public Integer getItroleAttrDefMandatory() {
        return itroleAttrDefMandatory;
    }

    public void setItroleAttrDefMandatory(Integer itroleAttrDefMandatory) {
        this.itroleAttrDefMandatory = itroleAttrDefMandatory;
    }

    public Integer getItroleAttrDefEditable() {
        return itroleAttrDefEditable;
    }

    public void setItroleAttrDefEditable(Integer itroleAttrDefEditable) {
        this.itroleAttrDefEditable = itroleAttrDefEditable;
    }

    public String getItroleAttrDefMax() {
        return itroleAttrDefMax;
    }

    public void setItroleAttrDefMax(String itroleAttrDefMax) {
        this.itroleAttrDefMax = itroleAttrDefMax == null ? null : itroleAttrDefMax.trim();
    }

    public String getItroleAttrDefMin() {
        return itroleAttrDefMin;
    }

    public void setItroleAttrDefMin(String itroleAttrDefMin) {
        this.itroleAttrDefMin = itroleAttrDefMin == null ? null : itroleAttrDefMin.trim();
    }

    public String getItroleAttrDefResUuid() {
        return itroleAttrDefResUuid;
    }

    public void setItroleAttrDefResUuid(String itroleAttrDefResUuid) {
        this.itroleAttrDefResUuid = itroleAttrDefResUuid == null ? null : itroleAttrDefResUuid.trim();
    }
}
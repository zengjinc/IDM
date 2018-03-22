package com.ssm.pojo;

public class AccountAttrDef {
    private String acctAttrDefKey;

    private String acctAttrDefName;

    private String acctAttrDefDatatype;

    private Integer acctAttrDefMandatory;

    private Integer acctAttrDefEditable;

    private String acctAttrDefMax;

    private String acctAttrDefMin;

    private String acctAttrDefResUuid;

    public String getAcctAttrDefKey() {
        return acctAttrDefKey;
    }

    public void setAcctAttrDefKey(String acctAttrDefKey) {
        this.acctAttrDefKey = acctAttrDefKey == null ? null : acctAttrDefKey.trim();
    }

    public String getAcctAttrDefName() {
        return acctAttrDefName;
    }

    public void setAcctAttrDefName(String acctAttrDefName) {
        this.acctAttrDefName = acctAttrDefName == null ? null : acctAttrDefName.trim();
    }

    public String getAcctAttrDefDatatype() {
        return acctAttrDefDatatype;
    }

    public void setAcctAttrDefDatatype(String acctAttrDefDatatype) {
        this.acctAttrDefDatatype = acctAttrDefDatatype == null ? null : acctAttrDefDatatype.trim();
    }

    public Integer getAcctAttrDefMandatory() {
        return acctAttrDefMandatory;
    }

    public void setAcctAttrDefMandatory(Integer acctAttrDefMandatory) {
        this.acctAttrDefMandatory = acctAttrDefMandatory;
    }

    public Integer getAcctAttrDefEditable() {
        return acctAttrDefEditable;
    }

    public void setAcctAttrDefEditable(Integer acctAttrDefEditable) {
        this.acctAttrDefEditable = acctAttrDefEditable;
    }

    public String getAcctAttrDefMax() {
        return acctAttrDefMax;
    }

    public void setAcctAttrDefMax(String acctAttrDefMax) {
        this.acctAttrDefMax = acctAttrDefMax == null ? null : acctAttrDefMax.trim();
    }

    public String getAcctAttrDefMin() {
        return acctAttrDefMin;
    }

    public void setAcctAttrDefMin(String acctAttrDefMin) {
        this.acctAttrDefMin = acctAttrDefMin == null ? null : acctAttrDefMin.trim();
    }

    public String getAcctAttrDefResUuid() {
        return acctAttrDefResUuid;
    }

    public void setAcctAttrDefResUuid(String acctAttrDefResUuid) {
        this.acctAttrDefResUuid = acctAttrDefResUuid == null ? null : acctAttrDefResUuid.trim();
    }
}
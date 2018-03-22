package com.ssm.pojo;

public class AccountAttribute {
    private String acctAttrAcctUuid;

    private String acctAttrKey;

    private String acctAttrVal;

    public String getAcctAttrAcctUuid() {
        return acctAttrAcctUuid;
    }

    public void setAcctAttrAcctUuid(String acctAttrAcctUuid) {
        this.acctAttrAcctUuid = acctAttrAcctUuid == null ? null : acctAttrAcctUuid.trim();
    }

    public String getAcctAttrKey() {
        return acctAttrKey;
    }

    public void setAcctAttrKey(String acctAttrKey) {
        this.acctAttrKey = acctAttrKey == null ? null : acctAttrKey.trim();
    }

    public String getAcctAttrVal() {
        return acctAttrVal;
    }

    public void setAcctAttrVal(String acctAttrVal) {
        this.acctAttrVal = acctAttrVal == null ? null : acctAttrVal.trim();
    }
}
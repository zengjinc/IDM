package com.ssm.pojo;

public class AccountAttribute extends AccountAttributeKey {
    private String acctAttrVal;

    public String getAcctAttrVal() {
        return acctAttrVal;
    }

    public void setAcctAttrVal(String acctAttrVal) {
        this.acctAttrVal = acctAttrVal == null ? null : acctAttrVal.trim();
    }
}
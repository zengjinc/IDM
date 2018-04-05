package com.ssm.pojo;

public class AccountAttributeKey {
    private String acctAttrAcctUuid;

    private String acctAttrKey;

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
}
package com.ssm.pojo;

public class EntitlementKey {
    private String etmUserUuid;

    private String etmAcctUuid;

    public String getEtmUserUuid() {
        return etmUserUuid;
    }

    public void setEtmUserUuid(String etmUserUuid) {
        this.etmUserUuid = etmUserUuid == null ? null : etmUserUuid.trim();
    }

    public String getEtmAcctUuid() {
        return etmAcctUuid;
    }

    public void setEtmAcctUuid(String etmAcctUuid) {
        this.etmAcctUuid = etmAcctUuid == null ? null : etmAcctUuid.trim();
    }
}
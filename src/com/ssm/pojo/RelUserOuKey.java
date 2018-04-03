package com.ssm.pojo;

public class RelUserOuKey {
    private String relUserOuUserUuid;

    private String relUserOuOuUuid;

    public String getRelUserOuUserUuid() {
        return relUserOuUserUuid;
    }

    public void setRelUserOuUserUuid(String relUserOuUserUuid) {
        this.relUserOuUserUuid = relUserOuUserUuid == null ? null : relUserOuUserUuid.trim();
    }

    public String getRelUserOuOuUuid() {
        return relUserOuOuUuid;
    }

    public void setRelUserOuOuUuid(String relUserOuOuUuid) {
        this.relUserOuOuUuid = relUserOuOuUuid == null ? null : relUserOuOuUuid.trim();
    }
}
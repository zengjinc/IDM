package com.ssm.pojo;

public class AccessControlRule {
    private Integer ruleCode;

    private String ruleName;

    private String ruleDesc;

    private String ruleHandler;

    public Integer getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(Integer ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName == null ? null : ruleName.trim();
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc == null ? null : ruleDesc.trim();
    }

    public String getRuleHandler() {
        return ruleHandler;
    }

    public void setRuleHandler(String ruleHandler) {
        this.ruleHandler = ruleHandler == null ? null : ruleHandler.trim();
    }
}
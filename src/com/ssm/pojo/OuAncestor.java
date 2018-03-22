package com.ssm.pojo;

public class OuAncestor {
    private String ouDescendent;

    private String ouAncestor;

    private Integer ouDepth;

    public String getOuDescendent() {
        return ouDescendent;
    }

    public void setOuDescendent(String ouDescendent) {
        this.ouDescendent = ouDescendent == null ? null : ouDescendent.trim();
    }

    public String getOuAncestor() {
        return ouAncestor;
    }

    public void setOuAncestor(String ouAncestor) {
        this.ouAncestor = ouAncestor == null ? null : ouAncestor.trim();
    }

    public Integer getOuDepth() {
        return ouDepth;
    }

    public void setOuDepth(Integer ouDepth) {
        this.ouDepth = ouDepth;
    }
}
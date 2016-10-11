package com.oocllogistics.demo.service;

/**
 * Created by FANAN3 on 10/10/2016.
 */
public class SearchConditionDTO {
    public String getCust() {
        return cust;
    }

    public void setCust(String cust) {
        this.cust = cust;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String cust;
    private String code;
}

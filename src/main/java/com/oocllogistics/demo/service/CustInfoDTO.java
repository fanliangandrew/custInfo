package com.oocllogistics.demo.service;


public class CustInfoDTO {
    private String custName;
    private String custCode;
    private String custCity;
    private String contactPerson;
    private String tel;
    private String email;
    private String stat;

    public CustInfoDTO() {
    }

    public CustInfoDTO(String name, String code, String city, String person, String telephone, String emai, String sta){
        custName = name;
        custCode = code;
        custCity = city;
        contactPerson = person;
        tel = telephone;
        email = emai;
        stat = sta;
    }
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getCustCity() {
        return custCity;
    }

    public void setCustCity(String custCity) {
        this.custCity = custCity;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "CustInfoDTO{" +
                "custName='" + custName + '\'' +
                ", custCode='" + custCode + '\'' +
                ", custCity='" + custCity + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", stat='" + stat + '\'' +
                '}';
    }
}

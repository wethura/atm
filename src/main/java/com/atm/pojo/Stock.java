package com.atm.pojo;

public class Stock {
    private Integer sId;

    private String sCode;

    private Float sPrice;

    private String sName;

    private String sCompany;

    @Override
    public String toString() {
        return "Stock{" +
                "sId=" + sId +
                ", sCode='" + sCode + '\'' +
                ", sPrice=" + sPrice +
                ", sName='" + sName + '\'' +
                ", sCompany='" + sCompany + '\'' +
                '}';
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsCode() {
        return sCode;
    }

    public void setsCode(String sCode) {
        this.sCode = sCode == null ? null : sCode.trim();
    }

    public Float getsPrice() {
        return sPrice;
    }

    public void setsPrice(Float sPrice) {
        this.sPrice = sPrice;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public String getsCompany() {
        return sCompany;
    }

    public void setsCompany(String sCompany) {
        this.sCompany = sCompany == null ? null : sCompany.trim();
    }
}
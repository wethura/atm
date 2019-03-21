package com.atm.pojo;

import java.util.Date;

public class Payment {
    private Integer pId;

    private Integer uId;

    private String pUsage;

    private Float pMoney;

    private Date pDate;

    @Override
    public String toString() {
        return "Payment{" +
                "pId=" + pId +
                ", uId=" + uId +
                ", pUsage='" + pUsage + '\'' +
                ", pMoney=" + pMoney +
                ", pDate=" + pDate +
                '}';
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getpUsage() {
        return pUsage;
    }

    public void setpUsage(String pUsage) {
        this.pUsage = pUsage == null ? null : pUsage.trim();
    }

    public Float getpMoney() {
        return pMoney;
    }

    public void setpMoney(Float pMoney) {
        this.pMoney = pMoney;
    }

    public Date getpDate() {
        return pDate;
    }

    public void setpDate(Date pDate) {
        this.pDate = pDate;
    }
}
package com.atm.pojo;

import java.util.Date;

public class Welfare {
    private Integer wId;

    private Integer uId;

    private Date wDate;

    private Float wMoney;

    private String wName;

    private String wCard;

    @Override
    public String toString() {
        return "Welfare{" +
                "wId=" + wId +
                ", uId=" + uId +
                ", wDate=" + wDate +
                ", wMoney=" + wMoney +
                ", wName='" + wName + '\'' +
                ", wCard='" + wCard + '\'' +
                '}';
    }

    public Integer getwId() {
        return wId;
    }

    public void setwId(Integer wId) {
        this.wId = wId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Date getwDate() {
        return wDate;
    }

    public void setwDate(Date wDate) {
        this.wDate = wDate;
    }

    public Float getwMoney() {
        return wMoney;
    }

    public void setwMoney(Float wMoney) {
        this.wMoney = wMoney;
    }

    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
        this.wName = wName == null ? null : wName.trim();
    }

    public String getwCard() {
        return wCard;
    }

    public void setwCard(String wCard) {
        this.wCard = wCard == null ? null : wCard.trim();
    }
}
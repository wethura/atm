package com.atm.pojo;

public class UserStock {
    private Integer sId;

    private Integer uId;

    private Integer usNum;

    public UserStock(Integer sId, Integer uId, Integer usNum) {
        this.sId = sId;
        this.uId = uId;
        this.usNum = usNum;
    }

    @Override
    public String toString() {
        return "UserStock{" +
                "sId=" + sId +
                ", uId=" + uId +
                ", usNum=" + usNum +
                '}';
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getUsNum() {
        return usNum;
    }

    public void setUsNum(Integer usNum) {
        this.usNum = usNum;
    }
}
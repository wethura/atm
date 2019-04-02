package com.atm.service;

public interface StockService {

    /**
     * 子程序主程，入口
     */
    public void stockServiceControl();

    /**
     * 卖出股票
     */
    public void sellStock();


    /**
     * 购买股票
     * @return
     */
    public void shopStock();

}

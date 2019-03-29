package com.atm.service;

import com.atm.pojo.User;

public interface PaymentService {
	/**
	 * 手机充值业务
	 * @param id 用户主键
	 * @param money 充值金额
	 * @param phoneNumber 充值的手机号码
	 * @return
	 */
	String phoneRecharge(Integer id, int money, String phoneNumber);

	/**
	 *
	 * @param id 用户主键ID
	 * @param usage 缴费用途
	 * @param money 每次自动缴费金额
	 * @return
	 */
	String addPaymentItem(Integer id, String usage, float money);

	/**
	 * 启动类的目的，使用时直接调用该方法，不用理其他
	 * @param id
	 */
	void paymentStart(Integer id);
}
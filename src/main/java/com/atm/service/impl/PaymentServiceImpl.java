package com.atm.service.impl;


import com.atm.mapper.PaymentMapper;
import com.atm.mapper.UserMapper;
import com.atm.mapper.UserMessageMapper;
import com.atm.pojo.Payment;
import com.atm.pojo.User;
import com.atm.pojo.UserMessage;
import com.atm.service.PaymentService;
import com.atm.utils.IO;
import org.apache.ibatis.annotations.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Create by Administrator
 *
 * @author sola
 * @date 2019/03/28 1:22
 */

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private UserMessageMapper userMessageMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private PaymentMapper paymentMapper;


	@Override
	public String phoneRecharge(Integer id, int money, String phoneNumber){
		User user = null;
		try {
			user = userMapper.selectByPrimaryKey(id);

			if (user.getuMoney() >= money){
				user.setuMoney(user.getuMoney() - money);
				userMapper.updateByPrimaryKey(user);
				UserMessage userMessage = new UserMessage();
				userMessage.setuId(user.getuId());
				userMessage.setmDate(new Date());
				userMessage.setmRead(false);
				userMessage.setmTitle("充值提醒");
				userMessage.setmDetail("您好，你的手机号码：" + phoneNumber + "已经通过空中充值成功充值" + money + "元，并且从您的账号成功扣费，祝您生活愉快！");
				userMessageMapper.insert(userMessage);
				return "充值成功！";
			} else {
				return "充值失败，您的账户已经余额不足！";
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return "充值失败";
	}

	/**
	 *
	 * @param id 用户主键ID
	 * @param usage 缴费用途
	 * @param money 每次自动缴费金额
	 * @return
	 */
	@Override
	public String addPaymentItem(Integer id, String usage, float money){
		User user = null;
		try {
			user = userMapper.selectByPrimaryKey(id);
			if(user == null){
				return "添加自动缴费项目失败...";
			}
			Payment payment = new Payment();
			payment.setuId(user.getuId());
			payment.setpDate(new Date());
			payment.setpMoney(money);
			payment.setpUsage(usage);

			paymentMapper.insert(payment);
			return "添加自动缴费项目成功...";
		} catch (Exception e){
			e.printStackTrace();
		}

		return "添加自动缴费项目失败...";
	}

	@Override
	public void paymentStart(Integer id) {
		String string = null;
		int money;
		System.out.println("----------------------------------\n1. 手机充值\n2. 办理自动缴费业务" +
				"\n----------------------------------\n请输入您的选择：");
		int op = IO.cin.nextInt();
		switch (op){
			case 1:
				System.out.println("请输入充值金额：");
				money = IO.cin.nextInt();
				System.out.println("请输入充值手机号码：");
				string = IO.cin.next();
				System.out.println(this.phoneRecharge(id, money, string));
			break;

			case 2:
				System.out.println("请输入每月自动缴费金额：");
				money = IO.cin.nextInt();
				System.out.println("请备注用途：");
				string = IO.cin.next();
				System.out.println(this.addPaymentItem(id, string, money));
			break;
		}
	}
}

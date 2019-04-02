package com.atm.service;

import com.atm.MainClass;
import com.atm.mapper.PaymentMapper;
import com.atm.mapper.UserMapper;
import com.atm.mapper.UserMessageMapper;
import com.atm.pojo.Payment;
import com.atm.pojo.PaymentExample;
import com.atm.pojo.User;
import com.atm.pojo.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Create by Administrator
 *
 * @author sola
 * @date 2019/03/28 2:25
 */

@Service("paymentListener")
public class PaymentListener{

	@Autowired
	PaymentMapper paymentMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	UserMessageMapper userMessageMapper;

	List<Payment> paymentList = null;

	@Async
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000 * 60 * 60);
				PaymentExample paymentExample = new PaymentExample();
				paymentList = paymentMapper.selectByExample(paymentExample);
				System.out.println(paymentList);
				for(Payment payment: paymentList){

					Date now = new Date();
					int lenth = now.getYear() * 12 * 30 + now.getMonth() * 30  + now.getDay()
							- payment.getpDate().getYear() * 12 * 30 - payment.getpDate().getMonth() * 30 - payment.getpDate().getDay();
					if(lenth < 30) {
						continue;
					}

					User user = userMapper.selectByPrimaryKey(payment.getuId());
					UserMessage userMessage = new UserMessage();
					userMessage.setuId(user.getuId());
					userMessage.setmTitle("缴费通知");
					userMessage.setmDate(new Date());
					userMessage.setmRead(false);
					if(payment.getpMoney() <= user.getuMoney()){
						user.setuMoney(user.getuMoney() - payment.getpMoney());
						userMessage.setmDetail("已经从您的余额中扣除相关费用，作用说明：" + payment.getpUsage() +
								"费用说明" + payment.getpMoney() + "。您的余额剩余" + user.getuMoney() + "元。祝您胜过愉快！");
						payment.setpDate(new Date());
						userMessageMapper.insert(userMessage);
						userMapper.updateByPrimaryKey(user);
						paymentMapper.updateByPrimaryKey(payment);
					} else {
						userMessage.setmDetail("您好！不好意思麻烦您，由于您的余额不足以缴费，请及时向您的银行卡充值，我们将会尽快完成扣费，以免您的信誉受损。");
						userMessageMapper.insert(userMessage);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

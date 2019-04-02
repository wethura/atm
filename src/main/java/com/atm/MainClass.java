package com.atm;

import com.atm.pojo.Payment;
import com.atm.pojo.User;
import com.atm.service.PaymentListener;
import com.atm.service.PaymentService;
import org.apache.ibatis.annotations.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Create by Administrator
 *
 * @author sola
 * @date 2019/03/21 9:01
 */
public class MainClass {
	public static void main(String[] args){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		PaymentListener paymentListener = (PaymentListener) context.getBean(PaymentListener.class);
		paymentListener.run();
		Runner runner = context.getBean(Runner.class);
		runner.service();
	}
}

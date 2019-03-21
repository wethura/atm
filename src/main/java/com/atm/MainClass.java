package com.atm;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Create by Administrator
 *
 * @author sola
 * @date 2019/03/21 9:01
 */
public class MainClass {
	public static void main(String[] args){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		context.close();
	}
}

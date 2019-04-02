package com.atm.service.impl;

import com.atm.Runner;
import com.atm.mapper.UserMapper;
import com.atm.pojo.User;
import com.atm.pojo.UserExample;
import com.atm.service.UserService;
import com.atm.utils.IO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

/**
 * Create by Administrator
 *
 * @author sola
 * @date 2019/03/28 8:30
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;

	@Override
	public User logging(String u_card, String password) {

		try {
			UserExample userExample = new UserExample();
			UserExample.Criteria criteria = userExample.createCriteria();
			criteria.andUCardEqualTo(u_card);
			criteria.andUPasswordEqualTo(password);
			User user = userMapper.selectByExample(userExample).get(0);
			if(user != null) {
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return null;
	}

	@Override
	public User loggingController() {
		String u_card = null;
		String password = null;
		User user = null;

		Scanner cin = new Scanner(System.in);
		System.out.println("请输入卡号：");
		u_card = cin.next();
		System.out.println("请输入密码：");
		password = cin.next();
		user = this.logging(u_card, password);
		if(user == null) {
			System.out.println("登陆失败，请重新登陆...");
			return this.loggingController();
		}
		System.out.println("登陆成功...");
		return user;
	}

	@Override
	public void saveMoney(int id) {
		User user = new User();
		System.out.print("请输入存款金额：");
		Float money;
		try {
			money = IO.cin.nextFloat() + Runner.user.getuMoney();
			if(money.toString().equals("Infinity") || money <= 0) {
				System.out.println("输入错误，存款失败！");
				return;
			}
		} catch(Exception e) {
			System.out.println("输入错误，存款失败！");
			return;
		}
		user.setuId(id);
		user.setuMoney(money);
		userMapper.updateByPrimaryKeySelective(user);
		System.out.println("存款成功！");
	}

	@Override
	public void drawMoney(int id) {
		User user = userMapper.selectByPrimaryKey(id);
		System.out.print("请输入取款金额：");
		Float money;
		try {
			money = IO.cin.nextFloat();
			if(money.toString().equals("Infinity") || money <= 0) {
				System.out.println("输入错误，取款失败！");
				return;
			}
		} catch(Exception e) {
			System.out.println("输入错误，取款失败！");
			return;
		}
		if(money > user.getuMoney()) {
			System.out.println("余额不足，取款失败！");
			return;
		}
		user.setuMoney(user.getuMoney() - money);
		userMapper.updateByPrimaryKey(user);
		System.out.println("取款成功！");
	}

	@Override
	public void query(int id) {
		System.out.println("1.余额查询");
		System.out.println("2.用户信息查询");
		Integer cmd;
		try {
			cmd = IO.cin.nextInt();
			if(cmd != 1 && cmd != 2) {
				System.out.println("输入错误，查询失败！");
				return;
			}
		} catch(Exception e) {
			System.out.println("输入错误，查询失败！");
			return;
		}
		if(cmd == 1){
			queryRemain(id);
		}
		else{
			queryUserInfo(id);
		}
	}

	@Override
	public void queryRemain(int id) {
		Float money = userMapper.selectByPrimaryKey(id).getuMoney();
		System.out.println("你的余额为：" + money + "元。");
	}

	@Override
	public void queryUserInfo(int id) {
		User user = userMapper.selectByPrimaryKey(id);
		System.out.println("姓名：" + user.getuName());
		System.out.println("电话：" + user.getuPhone());
		System.out.println("地址：" + user.getuAddress());
	}

	@Override
	public void transfer(int id) {
		System.out.println("请输入转账账号：");
		IO.cin.next();

		User user = userMapper.selectByPrimaryKey(id);
		System.out.println("请输入转账金额：");
		Float money;
		try {
			money = IO.cin.nextFloat();
			if(money.toString().equals("Infinity") || money <= 0) {
				System.out.println("输入错误，转账失败！");
				return;
			}
		} catch(Exception e) {
			System.out.println("输入错误，转账失败！");
			return;
		}
		if(money > user.getuMoney()) {
			System.out.println("余额不足，转账失败！");
			return;
		}
		user.setuMoney(user.getuMoney() - money);
		userMapper.updateByPrimaryKey(user);
		System.out.println("转账成功！");
	}
}

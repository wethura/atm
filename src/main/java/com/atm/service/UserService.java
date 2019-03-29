package com.atm.service;

import com.atm.pojo.User;

/**
 * Create by Administrator
 *
 * @author sola
 * @date 2019/03/21 9:03
 */
public interface UserService {
	/**
	 *用户登陆服务
	 * @param u_card
	 * @param password
	 * @return
	 */
	User logging(String u_card, String password);

	/**
	 * 用户登陆的入口
	 * @return
	 */
	User loggingController();

	/**
	 * 存钱
	 * @param id
	 */
	public void saveMoney(int id);

	/**
	 * 取钱
	 * @param id
	 */
	public void drawMoney(int id);

	/**
	 * 查询入口
	 * @param id
	 */
	public void query(int id);

	/**
	 * 信息查询
	 * @param id
	 */
	public void queryRemain(int id);

	/**
	 * 查询用户信息
	 * @param id
	 */
	public void queryUserInfo(int id);

	/**
	 * 转账
	 * @param id
	 */
	public void transfer(int id);
}
package com.atm.service;

import com.atm.pojo.UserMessage;

import java.util.List;

/**
 * Create by Administrator
 *
 * @author sola
 * @date 2019/03/28 4:01
 */

public interface UserMessageService {

	/**
	 * 根据用户ID查询消息
	 * @param id
	 * @return
	 */
	void queryMessage(Integer id);
}

package com.atm.service.impl;

import com.atm.mapper.UserMessageMapper;
import com.atm.pojo.Payment;
import com.atm.pojo.UserExample;
import com.atm.pojo.UserMessage;
import com.atm.pojo.UserMessageExample;
import com.atm.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by Administrator
 *git push origin branchA:branchB
 * @author sola
 * @date 2019/03/28 4:16
 */
@Service("UserMessageService")
public class UserMessageServiceImpl implements UserMessageService {

	@Autowired
	UserMessageMapper userMessageMapper;

	List<UserMessage> userMessageList = null;


	@Override
	public List<UserMessage> queryMessage(Integer id) {
		UserMessageExample userMessageExample = new UserMessageExample();
		UserMessageExample.Criteria criteria = userMessageExample.createCriteria();
		criteria.andUIdBetween(0, id);
		userMessageExample.setOrderByClause("m_date");
		userMessageList = userMessageMapper.selectByExample(userMessageExample);
		return userMessageList;
	}
}

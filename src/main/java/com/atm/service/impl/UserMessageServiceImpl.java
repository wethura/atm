package com.atm.service.impl;

import com.atm.Runner;
import com.atm.mapper.UserMapper;
import com.atm.mapper.UserMessageMapper;
import com.atm.pojo.UserMessage;
import com.atm.pojo.UserMessageExample;
import com.atm.service.UserMessageService;
import com.atm.utils.IO;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
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
	public void queryMessage(Integer id) {
		UserMessageExample userMessageExample = new UserMessageExample();
		UserMessageExample.Criteria criteria = userMessageExample.createCriteria();
		criteria.andUIdBetween(0, id);
		userMessageExample.setOrderByClause("m_date");
		userMessageList = userMessageMapper.selectByExample(userMessageExample);

		int index = 1;
		System.out.println("0. 退出查看消息");
		for(UserMessage userMessage : userMessageList) {
			System.out.println((index ++) + "标题：" + userMessage.getmTitle() + (userMessage.getmRead()?"<已读>":"<未读>") + userMessage.getmDate());
		}
		System.out.println("请输入序号选择查看详情：");
		int idx = IO.cin.nextInt();
		if(idx >= index) {
			System.out.println("已超出范围。");
			this.queryMessage(Runner.ID);
			return ;
		} else if(idx == 0) {
			return;
		}else {
			UserMessage userMessage = userMessageList.get(idx - 1);
			System.out.println("标题：" + userMessage.getmTitle());
			System.out.println("内容：\n" + userMessage.getmDetail());

			userMessage.setmRead(true);
			userMessageMapper.updateByPrimaryKey(userMessage);
			return;
		}
	}
}

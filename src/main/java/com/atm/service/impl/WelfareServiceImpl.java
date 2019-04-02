package com.atm.service.impl;

import com.atm.Runner;
import com.atm.mapper.UserMapper;
import com.atm.mapper.UserMessageMapper;
import com.atm.mapper.WelfareMapper;
import com.atm.pojo.User;
import com.atm.pojo.UserMessage;
import com.atm.pojo.Welfare;
import com.atm.pojo.WelfareExample;
import com.atm.service.WelfareService;
import com.atm.utils.IO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Create by Administrator
 *
 * @author sola
 * @date 2019/03/29 11:19
 */
@Service("welfareService")
public class WelfareServiceImpl implements WelfareService {
	@Autowired
	WelfareMapper welfareMapper;
	private List<Welfare> welfareList;
	@Autowired
	UserMapper userMapper;
	@Autowired
	UserMessageMapper userMessageMapper;


	@Override
	public void showAllWelfare() {

		WelfareExample welfareExample = new WelfareExample();
		welfareList = welfareMapper.selectByExample(welfareExample);

		for(Welfare welfare: welfareList){
			System.out.println("用户<" + welfare.getwName() + "> 于" + welfare.getwDate()
					+ "捐赠" + welfare.getwMoney() + "元，感谢他为我们的公益事业做出一份贡献。");
		}
	}

	@Override
	public void makeWelfare(){
		System.out.println("请输入您做公益的金额数量：");
		float money = IO.cin.nextFloat();

		if(money > Runner.user.getuMoney()){
			System.out.println("您好，谢谢您做公益，但是由于您的余额不足，已经取消本次公益活动。");
			return;
		}

		UserMessage userMessage = new UserMessage();
		userMessage.setmRead(false);
		userMessage.setmDate(new Date());
		userMessage.setmDetail("谢谢您通过本公司的系统为我们的公益事业做出的贡献，捐献金额为" + money);
		userMessage.setmTitle("公益提醒");
		userMessage.setuId(Runner.ID);

		Welfare welfare = new Welfare();
		welfare.setuId(Runner.ID);
		welfare.setwCard(Runner.user.getuCard());
		welfare.setwDate(new Date());
		welfare.setwMoney(money);
		welfare.setwName(Runner.user.getuName());

		User user = Runner.user;
		user.setuMoney(user.getuMoney() - money);

		userMapper.updateByPrimaryKey(user);
		welfareMapper.insert(welfare);
		userMessageMapper.insert(userMessage);
		System.out.println("感谢您，公益成功，金额为" + money + "元。");
	}

	@Override
	public void start() {
		System.out.println("--------------------\n1. 查看公益款项\n2. 为公益事业做贡献\n请输入您的选择：");
		int op = IO.cin.nextInt();

		switch (op){
			case 1:
				this.showAllWelfare();
				break;

			case 2:
				this.makeWelfare();
				break;
		}
	}
}

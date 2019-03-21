package com.atm.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Create by Administrator
 *
 * @author sola
 * @date 2019/03/21 15:43
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void test(){
		System.out.println(userMapper.selectByPrimaryKey(1));
	}

}
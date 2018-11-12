package com.mugua.dianying;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mugua.dianying.Application;
import com.mugua.dianying.entity.User;
import com.mugua.dianying.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=Application.class)// 指定spring-boot的启动类  
public class ApplicationTest {

	@Autowired
	private UserMapper userMapper;
	@Test
	public void test() {
		User user = userMapper.selectById(1);
		System.out.println(user);
		
	}

}

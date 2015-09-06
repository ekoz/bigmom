/*
 * Power by www.xiaoi.com
 */
package com.zokee.common;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zokee.system.entity.User;
import com.zokee.system.service.UserService;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date Aug 12, 2015 5:33:29 PM
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/app.xml"})
public class TestUserMem {

	@Resource
	UserService userService;
	
	@Test
	public void save(){
		User user = userService.findUser("2c90820a4f216848014f2168730c0000");
		user.setUsername("laoli12345678901234567890");
		userService.saveUser(user);
	}
	
	@Test
	public void get(){
		User user = userService.findUser("2c90820a4f216848014f2168730c0000");
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		
	}
	
	@Test
	public void getAnther(){
		User user = userService.findUser("4028ed814d7e73a4014d7e73a7e20000");
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		
	}
}

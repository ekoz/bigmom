/*
 * Power by www.xiaoi.com
 */
package com.eastrobot.common;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zokee.system.entity.User;
import com.zokee.system.service.UserService;
import com.zokee.util.MD5Util;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 13, 2015 11:41:55 AM
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/app.xml"})
public class TestUserHandler {

	@Resource
	UserService userService;
	
	@Test
	public void testFindUser(){
		List<User> list = userService.findAllUser();
		System.out.println(list.size());
	}
	
	
	@Test
	public void testSaveUser(){
		User user = new User();
		user.setUsername("admin");
		user.setPassword(MD5Util.encrypt("admin"));
		userService.saveUser(user);
	}
	
	@Test
	public void testSaveUserWithNoEncrypt(){
		User user = new User();
		user.setUsername("xiaoming");
		user.setPassword("xiaoming");
		userService.saveUser(user);
	}
	
	@Test
	public void testUpdateUser(){
		User user = userService.findUserByUsername("admin");
		user.setPassword(MD5Util.encrypt("admin", "admin"));
		userService.saveUser(user);
	}
	
	@Test
	public void testFindByUsername(){
		
	}
	
	@Test
	public void testDeleteUser(){
		User user = userService.findUserByUsername("admin");
		userService.deleteUser(user);
	}
}

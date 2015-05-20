/*
 * Power by www.xiaoi.com
 */
package com.eastrobot.common;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zokee.system.entity.User;
import com.zokee.system.entity.UserInfo;
import com.zokee.system.service.UserService;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 19, 2015 11:31:20 AM
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/app.xml"})
public class TestOneToOne {

	@Resource
	UserService userService;
	
	@Resource
	HibernateTemplate hibernateTemplate;
	
	@Test
	public void saveUser(){
		User user = new User();
		user.setUsername("1");
		user.setPassword("1");
		userService.saveUser(user);
		
		UserInfo userinfo = new UserInfo();
		userinfo.setUser(user);
		userinfo.setUsername("1");
		userinfo.setPhone("1");
		userService.saveUserInfo(userinfo);
		
		user.setUserinfo(userinfo);
		userService.saveUser(user);
	}
	
	@Test
	public void updateUser(){
		User user = userService.findUserByUsername("1");
		user.setUsername("1");
		user.setPassword("1");
		userService.saveUser(user);
		
		UserInfo userinfo = user.getUserinfo();
		userinfo.setUser(user);
		userinfo.setUsername("1");
		userinfo.setPhone("1");
		userService.saveUserInfo(userinfo);
		
		user.setUserinfo(userinfo);
		userService.saveUser(user);
	}
	
	@Test
	public void testSetup(){
		
	}
	
	@Test
	public void saveOnlyUser(){
		User user = new User();
		user.setUsername("only");
		user.setPassword("only");
		userService.saveUser(user);
	}
	
	@Test
	public void deleteUser(){
		User user = userService.findUserByUsername("1");
		userService.deleteUser(user);
	}
	
	@Test
	public void testUserDAO(){
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
//		session.createQuery("").setMaxResults(1).setFirstResult(1);
	}
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("app.xml");
		UserService userService = (UserService) ac.getBean("userService");
		List<User> list = userService.findAllUser();
		System.out.println(list.size());
		
		User user = new User();
		user.setUsername("main");
		user.setPassword("main");
		
		userService.saveUser(user);
	}
}

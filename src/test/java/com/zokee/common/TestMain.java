/*
 * Power by www.xiaoi.com
 */
package com.zokee.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 20, 2015 3:05:06 PM
 * @version 1.0
 */
public class TestMain {

	public static void main(String[] args) {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("app.xml");
//		UserService userService = (UserService) ac.getBean("userService");
//		List<User> list = userService.findAllUser();
//		System.out.println(list.size());
//		
//		User user = new User();
//		user.setUsername("main");
//		user.setPassword("main");
//		
//		userService.saveUser(user);
		
		Map<String, String> map = new HashMap<String, String>(){
			{
				put("1", "1");
			}
		};
		
		System.out.println(map.get("1"));
	}
}

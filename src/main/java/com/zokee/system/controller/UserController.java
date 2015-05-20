/*
 * Power by www.xiaoi.com
 */
package com.zokee.system.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zokee.base.BaseController;
import com.zokee.system.entity.User;
import com.zokee.system.entity.UserInfo;
import com.zokee.system.service.UserService;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 19, 2015 10:38:52 AM
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	@Resource
	UserService userService;
	
	@RequestMapping("/regist")
	public void regist(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		int result = 1;
		String msg = "";
		
		User user = userService.findUserByUsername(username);
		
		if (user!=null){
			result = 0;
			msg = "当前用户名已注册";
		}else{
			user = new User();
			user.setUsername(username);
			user.setPassword(password);
			userService.saveUser(user);
			
			UserInfo userinfo = new UserInfo();
			userinfo.setUsername(username);
			userinfo.setUser(user);
			userinfo.setPhone(phone);
			userinfo.setEmail(email);
			userService.saveUserInfo(userinfo);
			
			user.setUserinfo(userinfo);
			userService.saveUser(user);
		}
		
		writeJson(response, JSONObject.fromObject("{\"result\":\"" + result + "\", \"msg\":\"" + msg + "\"}"));
	}
	
	@RequestMapping("/test")
	public void test(){
//		/*
		User user = new User();
		user.setUsername("test");
		user.setPassword("test");
		userService.saveUser(user);
//		*/
		/*
		Session session = sessionFactory.getCurrentSession();
		List<User> list = session.createQuery("from User").list();
		
		User user = new User();
		user.setUsername("test1");
		user.setPassword("test1");
		org.hibernate.Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(user);
		session.flush();
		transaction.commit();
		
		System.out.println(list.size());
		*/
	}
}

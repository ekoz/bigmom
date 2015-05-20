/*
 * Power by www.xiaoi.com
 */
package com.zokee.security;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zokee.base.SystemKeys;
import com.zokee.system.entity.UserInfo;
import com.zokee.system.service.UserService;


/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 18, 2015 1:41:42 PM
 * @version 1.0
 */
@Controller
public class LoginAction {

	@Resource
	UserService userService;
	
	@RequestMapping("/login")
	public String execute(HttpServletRequest request){
		User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		com.zokee.system.entity.User user = userService.findUserByUsername(userDetails.getUsername());
		
		request.getSession().setAttribute(SystemKeys.CURRENT_USER, user);
		
		return "index";
	}
}

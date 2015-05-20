/*
 * Power by www.xiaoi.com
 */
package com.zokee.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zokee.system.dao.UserDAO;
import com.zokee.system.dao.UserInfoDAO;
import com.zokee.system.entity.User;
import com.zokee.system.entity.UserInfo;
import com.zokee.system.service.UserService;


/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 15, 2015 8:44:09 PM
 * @version 1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	UserDAO userDAO;
	@Resource
	UserInfoDAO userInfoDAO;

	@Override
	public void deleteUser(User user) {
		userDAO.deleteUser(user);
	}

	@Override
	public List<User> findAllUser() {
		return userDAO.findAllUser();
	}

	@Override
	public User findUser(String id) {
		return userDAO.findUser(id);
	}

	@Override
	public User findUserByUsername(String username) {
		return userDAO.findUserByUsername(username);
	}

	@Override
	public void saveUser(User user) {
		System.out.println("执行这里...");
		userDAO.saveUser(user);
	}

	@Override
	public void saveUserInfo(UserInfo userinfo) {
		userInfoDAO.save(userinfo);
	}
	

}

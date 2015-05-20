/*
 * Power by www.xiaoi.com
 */
package com.zokee.system.service;

import java.util.List;

import com.zokee.system.entity.User;
import com.zokee.system.entity.UserInfo;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 15, 2015 8:40:39 PM
 * @version 1.0
 */
public interface UserService {

	public void saveUser(User user);
	
	public void deleteUser(User user);
	
	public User findUser(String id);
	
	public List<User> findAllUser();
	
	public User findUserByUsername(String username);

	public void saveUserInfo(UserInfo userinfo);
	
}

/*
 * Power by www.xiaoi.com
 */
package com.zokee.system.dao;

import java.util.List;

import com.zokee.system.entity.User;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 15, 2015 8:33:24 PM
 * @version 1.0
 */
public interface UserDAO {

	public void saveUser(User user);
	
	public void deleteUser(User user);
	
	public List<User> findAllUser();
	
	public User findUser(String id);
	
	public User findUserByUsername(String username);
}

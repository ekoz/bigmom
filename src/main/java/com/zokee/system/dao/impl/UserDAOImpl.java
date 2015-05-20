/*
 * Power by www.xiaoi.com
 */
package com.zokee.system.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zokee.base.support.BaseDAOImpl;
import com.zokee.system.dao.UserDAO;
import com.zokee.system.entity.User;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 15, 2015 8:35:40 PM
 * @version 1.0
 */
@Repository("userDAO")
public class UserDAOImpl extends BaseDAOImpl implements UserDAO{
	
	@Override
	public void deleteUser(User user) {
		delete(user);
	}

	@Override
	public List<User> findAllUser() {
		return find("from User");
	}

	@Override
	public User findUser(String id) {
		return findById(User.class, id);
	}

	@Override
	public User findUserByUsername(String username) {
		List<User> list = find("from User where username=?", new String[]{username});
		if (list!=null && list.size()>0) return list.get(0);
		return null;
	}

	@Override
	public void saveUser(User user) {
		saveOrUpdate(user);
	}

	
}

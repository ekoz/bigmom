/*
 * Power by www.xiaoi.com
 */
package com.zokee.system.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.google.code.ssm.api.InvalidateSingleCache;
import com.google.code.ssm.api.ParameterDataUpdateContent;
import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;
import com.google.code.ssm.api.UpdateSingleCache;
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
	private static final String NAMESPACE = "kbase";
	
	@Override
	@InvalidateSingleCache(namespace=NAMESPACE)
	public void deleteUser(@ParameterValueKeyProvider @ParameterDataUpdateContent User user) {
		delete(user);
	}

	@Override
	public List<User> findAllUser() {
		return find("from User");
	}

	@Override
	@ReadThroughSingleCache(namespace = NAMESPACE, expiration = 3600)
	public User findUser(@ParameterValueKeyProvider String id) {
		return (User) findById(User.class, id);
	}

	@Override
	public User findUserByUsername(String username) {
		List<User> list = find("from User where username=?", new String[]{username});
		if (list.size()>0) return list.get(0);
		return null;
	}

	/**
	 * @UpdateSingleCache(namespace=NAMESPACE, expiration=3600) 
	 * 数据库报错，但是数据依然会存入memcached，数据却不会存入数据库，所以导致数据库数据与memcached数据不一样
	 * @InvalidateSingleCache(namespace=NAMESPACE)
	 * 缓存失效
	 */
	@Override
	@InvalidateSingleCache(namespace=NAMESPACE)
	public void saveUser(@ParameterValueKeyProvider User user) {
		saveOrUpdate(user);
	}
	
}

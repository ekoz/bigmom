/*
 * Power by www.xiaoi.com
 */
package com.zokee.system.dao.impl;

import org.springframework.stereotype.Repository;

import com.zokee.base.support.BaseDAOImpl;
import com.zokee.system.dao.UserInfoDAO;
import com.zokee.system.entity.UserInfo;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 19, 2015 11:39:34 AM
 * @version 1.0
 */
@Repository("userInfoDAO")
public class UserInfoDAOImpl extends BaseDAOImpl implements UserInfoDAO {

	@Override
	public void save(UserInfo userinfo) {
		super.saveOrUpdate(userinfo);
	}

}

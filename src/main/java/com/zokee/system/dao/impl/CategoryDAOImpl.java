/*
 * Power by www.xiaoi.com
 */
package com.zokee.system.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.zokee.base.support.BaseDAOImpl;
import com.zokee.system.dao.CategoryDAO;
import com.zokee.system.entity.Category;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 22, 2015 10:36:26 AM
 * @version 1.0
 */
@Repository("categoryDAO")
public class CategoryDAOImpl extends BaseDAOImpl implements CategoryDAO{

	@Override
	public List<Category> findByParentId(String id) {
		if (StringUtils.isBlank(id)){
			return super.find("from Category where parentId is null");
		}else{
			return super.find("from Category where parentId=?", new String[]{id});
		}
	}
}

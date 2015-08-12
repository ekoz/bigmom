/*
 * Power by www.xiaoi.com
 */
package com.zokee.system.dao;

import java.util.List;

import com.zokee.base.BaseDAO;
import com.zokee.system.entity.Category;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 22, 2015 10:34:21 AM
 * @version 1.0
 */
public interface CategoryDAO extends BaseDAO{
	
	public List<Category> findByParentId(String id);
	
}

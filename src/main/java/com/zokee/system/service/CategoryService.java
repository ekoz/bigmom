/*
 * Power by www.xiaoi.com
 */
package com.zokee.system.service;

import java.util.List;

import net.sf.json.JSONArray;

import com.zokee.system.entity.Category;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 22, 2015 10:39:37 AM
 * @version 1.0
 */
public interface CategoryService {

	public void saveCategory(Category cate);
	
	public void deleteCategory(Category cate);
	
	public List<Category> findAllRoot();
	
	public List<Category> findAllChildren(Category cate);
	
	public List<Category> findByCateName(String name);
	
	public void saveByJson(JSONArray jsonArr, Category parent);

	public Category findById(String id);
}

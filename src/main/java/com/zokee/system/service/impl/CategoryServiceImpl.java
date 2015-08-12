/*
 * Power by www.xiaoi.com
 */
package com.zokee.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.zokee.system.dao.CategoryDAO;
import com.zokee.system.entity.Category;
import com.zokee.system.service.CategoryService;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 22, 2015 10:43:24 AM
 * @version 1.0
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	
	private static final Log log = LogFactory.getLog(CategoryService.class);

	@Resource
	public CategoryDAO categoryDAO;
	
	@Override
	public void deleteCategory(Category cate) {
		categoryDAO.delete(cate);
	}

	@Override
	public List<Category> findAllChildren(Category cate) {
		return categoryDAO.findByParentId(cate.getId());
	}

	@Override
	public List<Category> findAllRoot() {
		return categoryDAO.findByParentId(null);
	}

	@Override
	public void saveCategory(Category cate) {
		categoryDAO.saveOrUpdate(cate);
	}

	@Override
	public List<Category> findByCateName(String name) {
		return categoryDAO.find("from Category where catename=?", new String[]{name});
	}

	@Override
	public void saveByJson(JSONArray jsonArr, Category parent) {
		for (Object obj : jsonArr){
			JSONObject json = JSONObject.fromObject(obj);
			String name = json.getString("name");
			Category cate = null;
			List<Category> list = this.findByCateName(name);
			if (list.size()==0){
				log.debug("名称为 [" + name + "] 的分类不存在，开始创建...");
				cate = new Category();
				cate.setCatename(name);
				if (parent!=null){
					cate.setParentid(parent.getId());
				}
				this.saveCategory(cate);
			}else{
				cate = list.get(0);
			}
			
			if (json.has("items")){
				JSONArray children = json.getJSONArray("items");
				if (children!=null){
					this.saveByJson(children, cate);
				}
			}
		}
	}

	@Override
	public Category findById(String id) {
		return (Category) categoryDAO.findById(Category.class, id);
	}

}

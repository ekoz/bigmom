/*
 * Power by www.xiaoi.com
 */
package com.zokee.common;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zokee.system.entity.Category;
import com.zokee.system.entity.User;
import com.zokee.system.service.CategoryService;
import com.zokee.util.MD5Util;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 13, 2015 11:41:55 AM
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/app.xml"})
public class TestCateHandler {

	@Resource
	CategoryService cateService;
	
	@Test
	public void testFindCate(){
		List<Category> list = cateService.findByCateName("AAA");
		System.out.println(list.size());
		
	}
	
	@Test
	public void testSaveCate(){
		Category cate = new Category();
		cate.setCatename("AAA");
		cateService.saveCategory(cate);
	}
	
	@Test
	public void testDeleteCate(){
		List<Category> list = cateService.findByCateName("AAA");
		cateService.deleteCategory(list.get(0));
	}
	
	@Test
	public void testInit(){
		System.out.println(Class.class.getResource("/").getPath());
		
		File file = new File(Class.class.getResource("/").getPath()+File.separator+"catelist.js");
		
		System.out.println(file.exists());
		
		try {
			String categorylist = FileUtils.readFileToString(file, "utf-8");
			System.out.println(categorylist);
			JSONArray arr = JSONArray.fromObject(categorylist);
			
			
			//System.out.println(arr.size());
//			for (Object obj : arr){
//				JSONObject json = JSONObject.fromObject(obj);
//				System.out.println(json.get("name"));
//				
//				System.out.println(json.get("items"));
//			}
			
			cateService.saveByJson(arr, null);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

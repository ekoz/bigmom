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

import com.zokee.system.entity.Category;
import com.zokee.system.service.CategoryService;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 22, 2015 1:29:51 PM
 * @version 1.0
 */
public class TestReadCategory {

	@Resource
	CategoryService categoryService;
	
	@Test
	public void readFile(){
		
		System.out.println(Class.class.getResource("/").getPath());
		
		File file = new File(Class.class.getResource("/").getPath()+File.separator+"catelist.js");
		
		System.out.println(file.exists());
		
		try {
			String categorylist = FileUtils.readFileToString(file, "utf-8");
			System.out.println(categorylist);
			JSONArray arr = JSONArray.fromObject(categorylist);
			
			
			//System.out.println(arr.size());
			for (Object obj : arr){
				JSONObject json = JSONObject.fromObject(obj);
				System.out.println(json.get("name"));
				
				System.out.println(json.get("items"));
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
	}
	
}

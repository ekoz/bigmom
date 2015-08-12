/*
 * Power by www.xiaoi.com
 */
package com.zokee.system.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zokee.base.BaseController;
import com.zokee.system.entity.Category;
import com.zokee.system.service.CategoryService;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 23, 2015 10:16:12 AM
 * @version 1.0
 */
@Controller
@RequestMapping("/cate")
public class CategoryController extends BaseController {

	@Resource
	CategoryService categoryService;
	
	@RequestMapping("/getnodes")
	public void getNodes(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		String n = request.getParameter("n");
		String lv = request.getParameter("lv");
		String otherParam = request.getParameter("otherParam");
		
		System.out.println(id);
		System.out.println(n);
		System.out.println(lv);
		System.out.println(otherParam);
		
		List<Category> list = null;
		
		if (StringUtils.isBlank(id)){
			list = categoryService.findAllRoot();
		}else{
			Category cate = categoryService.findById(id);
			list = categoryService.findAllChildren(cate);
		}
		
		JSONArray jsonArr = new JSONArray();
		
		for (Category cate : list){
			JSONObject json = new JSONObject();
			json.accumulate("id", cate.getId());
			json.accumulate("name", cate.getCatename());
			json.accumulate("isParent", true);
			
			jsonArr.add(json);
		}
		
		writeJson(response, jsonArr);
	}
}

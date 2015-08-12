/*
 * Power by www.xiaoi.com
 */
package com.zokee.base;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.zokee.system.entity.User;
import com.zokee.system.entity.UserInfo;
import com.zokee.system.service.CategoryService;
import com.zokee.system.service.UserService;
import com.zokee.util.MD5Util;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 20, 2015 3:07:53 PM
 * @version 1.0
 */
@Service
public class SetupListener implements ApplicationListener<ContextRefreshedEvent> {
	
	private final Log log = LogFactory.getLog(SetupListener.class);

	private final static String ADMIN = "admin";
	
	@Resource
	UserService userService;
	@Resource
	CategoryService categoryService;
	
	/**
	 * <pre>
	 * 执行数据初始化
	 * 1、初始化admin账号
	 * 2、初始化sys_category
	 * </pre>
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null){//root application context 没有parent，他就是老大.

			//需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
			
			//初始化admin用户
			User admin = userService.findUserByUsername(ADMIN);
			if (admin==null){
				log.debug("the admin is not avaliable, create it now");
				User user = new User();
				user.setUsername(ADMIN);
				user.setPassword(MD5Util.encrypt(ADMIN, ADMIN));
				userService.saveUser(user);
				
				UserInfo userinfo = new UserInfo();
				userinfo.setUsername("admin");
				userinfo.setUser(user);
				userService.saveUserInfo(userinfo);
				
				user.setUserinfo(userinfo);
				userService.saveUser(user);
			}
			//初始化分类
			File file = new File(this.getClass().getResource("/").getPath()+File.separator+"catelist.js");
			if (file.exists()){
				try {
					String categorylist = FileUtils.readFileToString(file, "utf-8");
					JSONArray arr = JSONArray.fromObject(categorylist);
					categoryService.saveByJson(arr, null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//read: http://www.cnblogs.com/rollenholt/p/3612440.html
	//采用该方法，由于有两个容器，结果执行了两遍
	//implements InitializingBean{
//	@Override
//	public void afterPropertiesSet() throws Exception {
		
//	}

}

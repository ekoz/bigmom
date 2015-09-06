/*
 * Power by www.xiaoi.com
 */
package com.zokee.common;

import java.util.Collection;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.code.ssm.Cache;
import com.google.code.ssm.CacheFactory;
import com.google.code.ssm.api.format.SerializationType;
import com.google.code.ssm.providers.CacheException;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date Aug 12, 2015 2:38:11 PM
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/app.xml"})
public class TestMem {
	
	@Resource
	Cache defaultMemcachedClient;
	
	@Test
	public void test(){}
	
	@Test
	public void add(){
		
		
		
		try {
			defaultMemcachedClient.add("key1", 30, "hello world", SerializationType.JAVA);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (CacheException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			defaultMemcachedClient.shutdown();
		}
		
		
	}
	
	@Test
	public void get(){
		try {
//			System.out.println(defaultMemcachedClient.get("2c90820a4f216848014f2168730c0000", SerializationType.JAVA));
			
			System.out.println(defaultMemcachedClient.get("key1", SerializationType.JAVA));
			
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (CacheException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			defaultMemcachedClient.shutdown();
		}
	}
	
	@Test
	public void delete(){
		
		try {
			defaultMemcachedClient.delete("key1");
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (CacheException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void findAll(){
		Collection<String> col = defaultMemcachedClient.getAliases();
		System.out.println(col.size());
	}
}

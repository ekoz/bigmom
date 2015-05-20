/*
 * Power by www.xiaoi.com
 */
package com.eastrobot.common;

import org.junit.Test;

import com.zokee.util.MD5Util;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 18, 2015 1:21:10 PM
 * @version 1.0
 */
public class TestEncrypt {

	@Test
	public void testSalt(){
		System.out.println(MD5Util.encrypt("admin", "admin"));
	}
}

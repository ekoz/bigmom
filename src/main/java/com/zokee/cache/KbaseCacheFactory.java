/*
 * Power by www.xiaoi.com
 */
package com.zokee.cache;

import java.io.IOException;

import com.google.code.ssm.Cache;
import com.google.code.ssm.CacheFactory;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date Aug 25, 2015 3:14:12 PM
 * @version 1.0
 */
public class KbaseCacheFactory extends CacheFactory {

	@Override
	protected Cache createCache(){
		Cache cache = null;
		try {
			cache = super.createCache();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cache;
	}
}

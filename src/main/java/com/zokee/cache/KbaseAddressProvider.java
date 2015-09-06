/*
 * Power by www.xiaoi.com
 */
package com.zokee.cache;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import com.google.code.ssm.config.DefaultAddressProvider;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date Aug 25, 2015 3:25:00 PM
 * @version 1.0
 */
public class KbaseAddressProvider extends DefaultAddressProvider {

	protected List<InetSocketAddress> getAddresses(String s){
		
		System.out.println("===============================================");
		
		List<InetSocketAddress> addrs = new ArrayList();
		try{
			addrs = super.getAddresses(s);
		}catch (Exception e) {
			System.out.println("地址配置为空，不启用memcached功能");
		}
		return addrs;
	}
}

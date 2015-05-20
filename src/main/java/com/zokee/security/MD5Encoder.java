package com.zokee.security;

import org.springframework.security.authentication.encoding.BasePasswordEncoder;

import com.zokee.util.MD5Util;

public class MD5Encoder extends BasePasswordEncoder {

	@Override
	public String encodePassword(String rawPass, Object salt) {
		return MD5Util.encrypt(rawPass, salt);
	}

	@Override
	public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
		return encPass.equals(encodePassword(rawPass, salt));
	}

}

/*
 * Power by www.xiaoi.com
 */
package com.zokee.system.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.google.code.ssm.api.CacheKeyMethod;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 15, 2015 8:29:44 PM
 * @version 1.0
 */
@Entity
@Table(name="sys_user")
public class User implements Serializable{
	@Id
	@GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid")
	private String id;
	private String username;
	private String password;
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="userinfoid")
	private UserInfo userinfo;
	
	@CacheKeyMethod
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	
}
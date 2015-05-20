/*
 * Power by www.xiaoi.com
 */
package com.zokee.system.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 19, 2015 11:18:53 AM
 * @version 1.0
 */
@Entity
@Table(name="sys_userinfo")
public class UserInfo implements Serializable {
	@Id
	@GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid")
	private String id;
	private String username;
	private String phone;
	private String email;
	private Timestamp birthday;
	
	@OneToOne
	@JoinColumn(name="userid")
	private User user;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}

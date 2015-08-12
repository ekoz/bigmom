/*
 * Power by www.xiaoi.com
 */
package com.zokee.system.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 21, 2015 2:01:51 PM
 * @version 1.0
 */
@Entity
@Table(name="sys_category")
public class Category implements Serializable {

	@Id
	@GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid")
    @Column(length=32, unique=true)
    private String id;
	@Column(length=32)
	private String parentid;
	@Column(length=50)
	private String catename;
	@Column(length=50)
	private String catecode;
	@Column(length=50)
	private String catekey;
	@Column(length=255)
	private String catepath;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getCatename() {
		return catename;
	}
	public void setCatename(String catename) {
		this.catename = catename;
	}
	public String getCatecode() {
		return catecode;
	}
	public void setCatecode(String catecode) {
		this.catecode = catecode;
	}
	public String getCatekey() {
		return catekey;
	}
	public void setCatekey(String catekey) {
		this.catekey = catekey;
	}
	public String getCatepath() {
		return catepath;
	}
	public void setCatepath(String catepath) {
		this.catepath = catepath;
	}
	
	
}

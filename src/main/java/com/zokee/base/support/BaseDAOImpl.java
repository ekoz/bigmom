/*
 * Power by www.xiaoi.com
 */
package com.zokee.base.support;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.zokee.base.AbstractHibernateDAO;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 13, 2015 12:16:43 PM
 * @version 1.0
 */
public class BaseDAOImpl extends AbstractHibernateDAO{
	
//	@Resource
//	public void setSuperSessionFactory(SessionFactory sessionFactory){
//		super.setSessionFactory(sessionFactory);
//	}
	
	@Resource
	public void setSuperHibernateTemplate(HibernateTemplate hibernateTemplate){
		super.setHibernateTemplate(hibernateTemplate);
	}
}

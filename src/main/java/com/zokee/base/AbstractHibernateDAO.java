/*
 * Power by www.xiaoi.com
 */
package com.zokee.base;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 15, 2015 1:26:10 PM
 * @version 1.0
 */
public abstract class AbstractHibernateDAO extends HibernateDaoSupport implements BaseDAO{

	public <T> List<T> find(String queryString) {
		return (List<T>) getHibernateTemplate().find(queryString, null);
	}

	public <T> List<T> find(String queryString, Object... objects) {
		return (List<T>) getHibernateTemplate().find(queryString, objects);
	}
	
	public <T> List<T> findByNamedParam(String queryString, String paramName, Object value) {
		return (List<T>) getHibernateTemplate().findByNamedParam(queryString, paramName, value);
	}
	
	public <T> List<T> findByNamedParam(String queryString, String[] paramNames, Object[] values) {
		return (List<T>) getHibernateTemplate().findByNamedParam(queryString, paramNames, values);
	}

	public void save(Object entity) throws DAORuntimeException {
		getHibernateTemplate().save(entity);
	}

	public void update(Object entity) throws DAORuntimeException {
		getHibernateTemplate().update(entity);
	}

	public void delete(Object entity) throws DAORuntimeException {
		getHibernateTemplate().delete(entity);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void saveOrUpdate(Object entity) throws DAORuntimeException {
		System.out.println("最终执行这里");
		getHibernateTemplate().saveOrUpdate(entity);
	}

	public <T> T findById(Class<T> entityClass, String primarykey) throws DAORuntimeException {
		return getHibernateTemplate().get(entityClass, primarykey);
	}
	
	public <T> T execute(HibernateCallback<T> action){
		return getHibernateTemplate().execute(action);
	}
}

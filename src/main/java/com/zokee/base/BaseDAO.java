/*
 * Power by www.xiaoi.com
 */
package com.zokee.base;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateCallback;


/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 14, 2015 10:25:42 AM
 * @version 1.0
 */
public interface BaseDAO<T> {

	public List<T> find(String queryString) throws DAORuntimeException;
	
	public List<T> find(String queryString, Object...objects) throws DAORuntimeException;
	
	public List<T> findByNamedParam(String queryString, String paramName, Object value) throws DAORuntimeException;
	
	public List<T> findByNamedParam(String queryString, String[] paramNames, Object[] values) throws DAORuntimeException;
	
	public void save(T entity) throws DAORuntimeException;
	
	public void update(T entity) throws DAORuntimeException;
	
	public void delete(T entity) throws DAORuntimeException;
	
	public void saveOrUpdate(T entity) throws DAORuntimeException;
	
	public T findById(Class<T> entityClass, String primarykey) throws DAORuntimeException;
	
	public T execute(HibernateCallback<T> action) throws DAORuntimeException;
}

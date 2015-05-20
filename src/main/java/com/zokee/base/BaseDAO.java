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
public interface BaseDAO {

	public <T> List<T> find(String queryString) throws DAORuntimeException;
	
	public <T> List<T> find(String queryString, Object...objects) throws DAORuntimeException;
	
	public <T> List<T> findByNamedParam(String queryString, String paramName, Object value) throws DAORuntimeException;
	
	public <T> List<T> findByNamedParam(String queryString, String[] paramNames, Object[] values) throws DAORuntimeException;
	
	public void save(Object entity) throws DAORuntimeException;
	
	public void update(Object entity) throws DAORuntimeException;
	
	public void delete(Object entity) throws DAORuntimeException;
	
	public void saveOrUpdate(Object entity) throws DAORuntimeException;
	
	public <T> T findById(Class<T> entityClass, String primarykey) throws DAORuntimeException;
	
	public <T> T execute(HibernateCallback<T> action) throws DAORuntimeException;
}

package com.test.dao;

import java.util.List;

/**
 * 
 * @author xuanliu
 *dao interface
 */
public interface BaseDaoInter {

	boolean addObject(Object obj);
	boolean deleteObject(String hql,Object[] parameters);
	boolean updateObjectById(String beanName,Object[]parameters,Object[]values,int id);
	List<?> findObject(String hql,Object[]parameters,int page,int rowsPerPage);
	int findTotalNum(String hql,Object[] values);
	boolean checkByUserName(String name,String password);
}

package com.test.dao;
import java.util.List;

import com.test.beans.*;
/**
 * 
 * @author xuanliu
 *user interface data manipulation
 */
public interface UserDaoInter {
	//multi-pages query
	List<User> findByPage(int page,int rowspPerPage);
	int findTotalNum();//get database sum num recorder
	boolean addUser(User user);
	boolean delete(int id);
	boolean update(int id, Object[] parameters, Object[] values);
	boolean checkByUserName(String name, String password);
}

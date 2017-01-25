package com.test.service;

import com.test.beans.User;
import com.test.vo.PageBean;

/**
 * 
 * @author xuanliu
 *
 */
public interface UserServiceInter {
	PageBean findByPage(int page,int rowsPerPage);
	boolean addUser(User u);
	boolean deleteUserById(int id);
	boolean updateById(int id, Object[] objects, Object[] objects2);
	boolean checkByUserName(String name, String password);
}

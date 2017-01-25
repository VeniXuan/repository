package com.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.beans.User;
@Repository(value="userDao")

public class UserDaoImpl extends BaseDaoImpl implements UserDaoInter  {

	@Override
	public List<User> findByPage(int page, int rowspPerPage) {
		// TODO Auto-generated method stub
		String hql="from User";
		return (List<User>) super.findObject(hql,null,page,rowspPerPage);
		
	}

	@Override
	public int findTotalNum() {
		// TODO Auto-generated method stub
		String hql="select count(id) from User";
	return	super.findTotalNum(hql, null);
	
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub	
		return super.addObject(user);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		
		String hql="delete from User where id=?";
		return super.deleteObject(hql, new Object[]{id});
	}

	@Override
	public boolean update(int id, Object[] parameters, Object[] values) {
		// TODO Auto-generated method stub
		return super.updateObjectById("User", parameters, values, id);
	}

	@Override
	public boolean checkByUserName(String name,String password) {
		// TODO Auto-generated method stub
		
		return super.checkByUserName(name,password);
	}

}

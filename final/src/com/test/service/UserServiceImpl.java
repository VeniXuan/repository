package com.test.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test.beans.User;
import com.test.dao.UserDaoImpl;
import com.test.dao.UserDaoInter;
import com.test.utils.MyUtil;
import com.test.vo.PageBean;
@Service(value="userService")
public class UserServiceImpl implements UserServiceInter {
	@Resource(name="userDao")
	private UserDaoInter userDao;
	@Override
	public PageBean findByPage(int page, int rowsPerPage) {
		// TODO Auto-generated method stub
		PageBean pageBean=new PageBean();
		pageBean.setNowPage(page);
		List<User>data=userDao.findByPage(page, rowsPerPage);
		if(data!=null && data.size()>0)
		{
			int totalNum=userDao.findTotalNum();
			pageBean.setTotalNum(totalNum);
			pageBean.setTotalPage(MyUtil.getTotalPage(totalNum, rowsPerPage));	
		}
		pageBean.setData(data);
		return pageBean;
		
	//	pageBean.setData(data);
		//pageBean.setTotalNum(totalNum);
	
	}
	@Override
	public boolean addUser(User u) {
		// TODO Auto-generated method stub
		
		return userDao.addUser(u);
	}
	@Override
	public boolean deleteUserById(int id) {
		// TODO Auto-generated method stub
	
		return userDao.delete(id);
	}
	@Override
	public boolean updateById(int id, Object[] parameters, Object[] values) {
		// TODO Auto-generated method stub
		return userDao.update(id,parameters,values);
	}
	@Override
	public boolean checkByUserName(String name,String password) {
		// TODO Auto-generated method stub
		
		return userDao.checkByUserName(name,password);
	}

}

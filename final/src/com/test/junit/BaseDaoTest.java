package com.test.junit;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;

import com.test.beans.User;
import com.test.dao.BaseDaoInter;
@RunWith(SpringJUnit4ClassRunner.class)//set annotation for springjunit4
@ContextConfiguration(locations="classpath:applicationContext.xml")//set context

public class BaseDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Resource(name="baseDao")
	private BaseDaoInter baseDao;
	
	@BeforeTransaction
	public void before(){
		System.out.println("----------@BeforeTransaction-----------");
	}
	
	@AfterTransaction
	public void after(){
		System.out.println("----------@AfterTransaction-----------");
	}
	
	
	@Test
//	@Transactional
	@Rollback(true)
	
	public void testAddObject() {
		User user=new User();
		user.setGender("male");
		user.setName("david");
		user.setMobile("12332132");
		user.setPassword("123456");
		user.setEmail("@gmail");
		boolean flag=baseDao.addObject(user);
		if(flag){
			System.out.println("--------add Succeed----");
		}
		else {
			System.out.println("--------add Failed----");
		}
	}

	@Test
	@Rollback(false)
	public void testDeleteObject() {
		boolean flag=baseDao.deleteObject("delete from User where id=?", new Object[]{4});
		if(flag){
			System.out.println("--------delete Succeed----");
		}
		else{
			System.out.println("--------delete Failed----");
		}
	}

	@Test
	@Rollback(false)
	public void testUpdateObjectById() {
		boolean flag=baseDao.updateObjectById("User", new Object[]{"name","gender"}, new Object[]{"johns", "female"},4);
		if(flag){
			System.out.println("--------update Succeed----");
		}
		else{
			System.out.println("--------update Failed----");
		}
	}

	@Test
	@Rollback(true)
	public void testFindObject() {
		String hqlString="from User";
		List<User> dataList=(List<User>) baseDao.findObject(hqlString,null,1,10);
		if(dataList!=null&&dataList.size()>0){
			System.out.println("data.size:"+dataList.size());
			System.out.println("name:"+dataList.get(0).getName());
			System.out.println("name:"+dataList.get(0).getEmail());
			System.out.println("name:"+dataList.get(0).getMobile());
		}else{
			System.out.println("------no data------");
		}
		
		
	}

}

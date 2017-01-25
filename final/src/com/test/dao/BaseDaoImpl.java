package com.test.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.jms.Session;
import javax.management.Query;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


@Repository(value="baseDao")
public class BaseDaoImpl implements BaseDaoInter {
	/**
	 * 1 get sessionFactory,config in appCon.xml
	 * 2.through sessionfactory,getor reopen a new session for sys and database  
	 * 3.session->add del,upd,find
	 */
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public org.hibernate.Session getSession(){
		
		org.hibernate.Session session=sessionFactory.getCurrentSession();
		if(session==null){
			return sessionFactory.openSession();
		}else {
			return session;
		}
		
	}
	
	@Override
	public boolean addObject(Object obj) {
		// TODO Auto-generated method stub	
		try {
			getSession().save(obj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteObject(String hql, Object[] parameters) {
		
		try {
		org.hibernate.Query query=getSession().createQuery(hql);
		if(parameters!=null&& parameters.length>0)
		{
			for(int i=0;i<parameters.length;i++)
				query.setParameter(0, parameters[i]);
		}
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean updateObjectById(String beanName, Object[] parameters, Object[] values, int id) {
		// TODO Auto-generated method stub
		try {
			String hqlString="update"+" "+beanName+" "+"set"+" ";
			for(int i=0;i<parameters.length;i++){
				hqlString=hqlString+parameters[i]+"=?,";
			}
			System.out.println("here1: "+hqlString);
			//lose the last ,
			hqlString=hqlString.substring(0,hqlString.lastIndexOf(","));
			//add where id=?
			hqlString=hqlString+" "+"where id=?";
			//set
			System.out.println("here2: "+hqlString);
			org.hibernate.Query query=getSession().createQuery(hqlString);
			for(int j=0;j<values.length;j++)
			{
				query.setParameter(j,values[j]);
			}
			query.setParameter(values.length,id);
			System.out.println(" Here query: "+query);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return  false;
		}
		
		
	
	}

	@Override
	public List<?> findObject(String hql, Object[] parameters, int page, int rowsPerPage) {
		// TODO Auto-generated method stub
		try {
			org.hibernate.Query query=getSession().createQuery(hql);
			if(parameters!=null&&parameters.length>0){
				for(int i=0;i<parameters.length;i++)
				{
					query.setParameter(i, parameters[i]);
				}
			}
			query.setFirstResult((page-1)*rowsPerPage);
			query.setMaxResults(rowsPerPage);
			return query.list();
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
		
		
	}

	@Override
	public int findTotalNum(String hql, Object[] values) {
		// TODO Auto-generated method stub
		try {
			org.hibernate.Query query=getSession().createQuery(hql);
			if(values!=null && values.length>0){
				for(int i=0;i<values.length;i++){
					query.setParameter(i, values[i]);
				}
			}
			return Integer.parseInt(query.list().get(0)+"");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}

		
	}

	public boolean checkByUserName(String name, String password) {
		// TODO Auto-generated method stub
		try {
			System.out.println("***********name:"+name+" password:"+password);
			String hqlString="select name from User where name='"+name+"' and password='"+password+"'";

			org.hibernate.Query query=getSession().createQuery(hqlString);

	        List<String> list = query.list(); 
	        if(!list.isEmpty())
	        {  	
	        	System.out.println("*************true*********");
	        return true;
	        } 
	        else
	        {	System.out.println("************false*********");
	        	return false;
	        }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return  false;
		}
		

	}

}

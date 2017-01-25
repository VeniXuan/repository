package com.test.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.beans.User;
import com.test.service.UserServiceInter;
import com.test.utils.MyUtil;
import com.test.vo.PageBean;

/**
 * 
 * @author xuanliu
 *background manage controller
 */
@Controller
@RequestMapping(value="/manager")
public class ManagerController {
	
	@RequestMapping(value="/home.html")
	private String  home(){
		return "login";
	}
	@RequestMapping(value="/news.html")
	private String  news(){
		return "NewsPages";
	}
	@RequestMapping(value="/agentList.html")
	private String  agentList(){
		
		return "agentList";
	}

	@RequestMapping(value="/register.html")
	private String  register(){
		System.out.println("Register!!!!!!");
		return "register";
	}
	@RequestMapping(value="/account.html")
	private String  account(){
		//System.out.println("account!!!!!!");
		return "account";
	}
	@Resource(name="userService")
	private UserServiceInter userService;
	
	//page query
	@RequestMapping(value="findByPage.html")
	public String findByPage(HttpServletRequest request,HttpServletResponse response){
		String pageString=request.getParameter("page");
		int page=1;
		if(pageString!=null&&pageString.length()>0)
		{
			page=Integer.parseInt(pageString);
		}
		PageBean pageBean=userService.findByPage(page, MyUtil.rowsPerPage);
		request.setAttribute("pageBean", pageBean);
		return "home";
	}
	@RequestMapping(value="UserfindByPage.html")
	public String UserfindByPage(HttpServletRequest request,HttpServletResponse response){
		String pageString=request.getParameter("page");
		int page=1;
		if(pageString!=null&&pageString.length()>0)
		{
			page=Integer.parseInt(pageString);
		}
		PageBean pageBean=userService.findByPage(page, MyUtil.rowsPerPage);
		request.setAttribute("pageBean", pageBean);
		return "agentList";
	}
	
	//
	@RequestMapping(value="add.html")
	public void add(HttpServletRequest request,HttpServletResponse response){
		try {
			String name=request.getParameter("name");
			String gender=request.getParameter("gender");
			String email=request.getParameter("email");
			String mobile=request.getParameter("mobile");
			String password=request.getParameter("password");
			System.out.println("in userController: "+name+" "+email+" "+gender+" "+mobile);
			User u=new User();
			u.setName(name);
			u.setGender(gender);
			u.setMobile(mobile);
			u.setEmail(email);
			u.setPassword(password);
			boolean flag=userService.addUser(u);
			System.out.println("in userController flag: "+flag);
			if(flag){
				//
				MyUtil.printObject(response, "true");
			}else{
				//
				MyUtil.printObject(response, "false");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			MyUtil.printObject(response, "false");
		}
	}
	@RequestMapping(value="delete.html")
	public void deleteById(HttpServletRequest request,HttpServletResponse response)
	{
		try {
			String idStr=request.getParameter("id");
			int id=0;
			if (idStr!=null&& idStr.length()>0) {
				id=Integer.parseInt(idStr);
				boolean flag=userService.deleteUserById(id);
				if(flag){
					MyUtil.printObject(response, "true");
				}
				else {
					MyUtil.printObject(response, "false");
				}
			} else {
				MyUtil.printObject(response, "false");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			MyUtil.printObject(response, "false");
		}	
	}
	
	@RequestMapping(value="update.html")
	public void updateById(HttpServletRequest request,HttpServletResponse response)
	{	System.out.println("------------------------------------------------------- ");
	    try{
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String idStr=request.getParameter("id");
		System.out.println(" HEREHEREHEHHEHRHERHE"+name+" "+gender+" "+email+" "+mobile+" "+idStr);
		int id=0;
		if (idStr!=null&& idStr.length()>0) {
				id=Integer.parseInt(idStr);			
		} else {
				MyUtil.printObject(response, "false");
		}
		boolean flag=userService.updateById(id,new Object[]{"name","gender","mobile","email"},
				new Object[]{name,gender,mobile,email});
		if(flag){
			MyUtil.printObject(response, "true");
		}
		else {
			MyUtil.printObject(response, "false");
		}	
	    }catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    
	}
	@RequestMapping(value="check.html")
	public void checkByUserName(HttpServletRequest request,HttpServletResponse response)
	{	System.out.println("---------***---------checkByUserName-----------***-------------- ");
	    try{
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		

		boolean flag=userService.checkByUserName(name,password);
		if(flag){
			MyUtil.printObject(response, "true");
		}
		else {
			MyUtil.printObject(response, "false");
		}	
	    }catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    
	}
	@RequestMapping(value="/truepass.html")
	public String truepass(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		return "index1";
	}
	@RequestMapping(value="nopass.html")
	public String nopass(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("nopass");
		return "no";
	}
	
}

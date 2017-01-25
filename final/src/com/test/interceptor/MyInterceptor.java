package com.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor extends HandlerInterceptorAdapter{
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
	// TODO Auto-generated method stub
	System.out.println("--------------------------preHandler-------------------");

	
	return super.preHandle(request, response, handler);
}

@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	System.out.println("--------------------------postHandler--------------------");
	System.out.println("*****request.getRequestURI(): "+request.getRequestURI());///final/test/hello
	System.out.println("*****request.getRequestURL(): "+request.getRequestURL());//http://localhost:8080/final/test/hello
	System.out.println("*****contextpath: "+request.getContextPath());///final
	HttpSession session=request.getSession();
	//Get Post
	System.out.println("*****request.getMethod(): "+request.getMethod());
	System.out.println("*****request.getRemoteAddr(): "+request.getRemoteAddr());//ip

	super.postHandle(request, response, handler, modelAndView);
	}

@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
	System.out.println("--------------------------afterCompletion--------------------");
		super.afterCompletion(request, response, handler, ex);
	}

}

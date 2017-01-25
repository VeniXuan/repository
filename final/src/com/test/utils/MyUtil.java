package com.test.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author xuanliu
 *
 */
public final class MyUtil {
/**
 * 3 record per page
 */
	public final static int rowsPerPage=3;
	
	public final static String getIpAddress(HttpServletRequest request){ 
		String ip=request.getHeader("X-Forwarded-For");
		if(ip==null ||ip.length()==0|| "unknown".equalsIgnoreCase(ip) ){
			if(ip==null ||ip.length()==0|| "unknown".equalsIgnoreCase(ip) ){
				ip=request.getHeader("Proxy-Client-IP");
			System.out.println("Proxy-client-ip:"+request.getHeader("Proxy-Client-IP"));
			}
			if(ip==null ||ip.length()==0|| "unknown".equalsIgnoreCase(ip) ){
				ip=request.getHeader("WL-Proxy-Client-IP");
			System.out.println("Proxy-client-ip:"+request.getHeader("WL-Proxy-Client-IP"));
			}
			if(ip==null ||ip.length()==0|| "unknown".equalsIgnoreCase(ip) ){
				ip=request.getHeader("HTTP_CLIENT_IP");
			System.out.println("Proxy-client-ip:"+request.getHeader("HTTP_CLIENT_IP"));
			}
			if(ip==null ||ip.length()==0|| "unknown".equalsIgnoreCase(ip) ){
				ip=request.getHeader("HTTP_X_FORWARDED_FOR");
			System.out.println("Proxy-client-ip:"+request.getHeader("HTTP_X_FORWARDED_FOR"));
			}
			if(ip==null ||ip.length()==0|| "unknown".equalsIgnoreCase(ip) ){
				ip=request.getRemoteAddr();
			System.out.println("Proxy-client-ip:"+request.getRemoteAddr());
			}
		}
		else if(ip.length()>15){
			String [] ipsStrings=ip.split(",");
			//use multi layer proxy , X-FORWARDED-FOR carry many ip address
			for(int index=0;index<ipsStrings.length;index++){
				String strIpString=(String)ipsStrings[index];
				if(!("unknown".equalsIgnoreCase(strIpString))){
					ip=strIpString;
					break;
				}
			}
		}
			
		return ip;	
	}
	
	public static int getTotalPage(int totalNum,int rowsPerPage){
		int totalPage=0;
		if(totalNum%rowsPerPage>0)
			totalPage=totalNum/rowsPerPage+1;
		else {
			totalPage=totalNum/rowsPerPage;
		}
		return totalPage;
	}
	
	public static void printObject(HttpServletResponse response,String outStr){
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(outStr);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}

package com.hf.test;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.PageInfo;
import com.hf.bean.Emp;

public class PageUtil {
	
	public static String getPageInfo(PageInfo<Emp> pageInfo,HttpServletRequest request){
		
		//String path = request.getContextPath()+"/";
		String path ="/ssm/";
		StringBuilder builder = new StringBuilder();
		
		//拼接首页
		builder.append("<a href='"+path+"emps/1'>首页<a/>");
		builder.append("&nbsp&nbsp");
		//拼接上一页
		if (pageInfo.isHasPreviousPage()) {
			builder.append("<a href='"+path +"emps/"+pageInfo.getPrePage()+"'>上一页<a/>");
			builder.append("&nbsp&nbsp");
		}else {
			builder.append("上一页");
			builder.append("&nbsp&nbsp");
		}
		
		//拼接页码
		int[] nums = pageInfo.getNavigatepageNums();
		for (int i = 0; i < nums.length; i++) {
			if (i == pageInfo.getPageNum()) {
				builder.append("<a style='color:red;' href='"+path+"emps/"+i+"'>"+i+"<a/>");
				builder.append("&nbsp&nbsp");
			}else {
				builder.append("<a href='"+path+"emps/"+i+"'>"+i+"<a/>");
				builder.append("&nbsp&nbsp");
			}
		}
		
		//拼接下一页
		if (pageInfo.isHasNextPage()) {
			builder.append("<a href='"+path +"emps/"+pageInfo.getNextPage()+"'>下一页<a/>");
			builder.append("&nbsp&nbsp");
		}else {
			builder.append("下一页");
			builder.append("&nbsp&nbsp");
		}
		
		//拼接尾页
		builder.append("<a href='"+path +"emps/"+pageInfo.getPages()+"'>尾页<a/>");
		
		return builder.toString();
	}
}

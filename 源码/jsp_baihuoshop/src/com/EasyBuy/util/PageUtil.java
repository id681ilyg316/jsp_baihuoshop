package com.EasyBuy.util;

public class PageUtil {
	
	
	public static String getPagation(String targetUrl,int totalNum,int currentPage,int pageSize){
		int totalPage=totalNum%pageSize==0?totalNum/pageSize:(totalNum/pageSize)+1;//总页数
		StringBuffer sb=new StringBuffer();
		
		sb.append("<div class='pages'>");
		
		
		sb.append("<a href='"+targetUrl+"&page=1' class='p_pre'>首页</a> ");
		
		if(currentPage>1) {
			sb.append("<a href='"+targetUrl+"&page="+(currentPage-1)+"' class='p_pre'>上一页</a>");
		}else {
			sb.append("");
		}
		
		for(int i=currentPage-3;i<=currentPage+3;i++) {
			
			if(i<1 || i>totalPage) {
				continue;
			}
			
			if(i==currentPage) {
				sb.append("<a href='#' class='cur'>"+i+"</a> ");
			}else {
				sb.append("<a href='"+targetUrl+"&page="+i+"'>"+i+"</a>");
			}
		}
		
		if(currentPage==totalPage) {
			sb.append("");
		}else {
			sb.append("<a href='"+targetUrl+"&page="+(currentPage+1)+"' class='p_pre'>下一页</a>");
		}
		sb.append("<a href='"+targetUrl+"&page="+totalPage+"' class='p_pre'>尾页</a> ");
		sb.append("</div>");
		return sb.toString();
	}
}

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>咨询显示</title>

</head>
<body>
	
	<div class="m_right">
            <div class="mem_tit">资讯列表</div>
            <p style="padding-bottom: 25px;" align="right">
            	<c:if test="${sessionScope.currentUser.type!=0 && sessionScope.currentUser!=null}">
					<a href='javascript:window.location.href="${pageContext.request.contextPath}/admin/news?action=presave"'
					class="add_b">添加资讯</a>
				</c:if>
				 <br>
			</p>
            <table class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0" border="0">
                <tbody>
                <tr>
                    <td width="20%">文章标题</td>
                    <td width="25%">创建时间</td>
                     <c:if test="${sessionScope.currentUser.type!=0 && sessionScope.currentUser!=null}">
                    	<td colspan="2" width="25%">操作</td>
                    </c:if>
                </tr>
                	<c:forEach  var="news" items="${newsList }">
	                    <tr>
	                        <td><a href="${pageContext.request.contextPath}/admin/news?action=newsDetail&id=${news.id }">${news.title }</a></td>
	                        <td>
	                        	<fmt:formatDate value="${news.createTime }" type="date" pattern="yyyy-MM-dd"/>
	                        </td>
	                        <c:if test="${sessionScope.currentUser.type!=0 && sessionScope.currentUser!=null}">
		                        <td>
									<a href="${pageContext.request.contextPath}/admin/news?action=presave&id=${news.id }">修改</a>
								</td>
								<td>
									<a href="javascript:void(0);" onclick="deleteNews('${news.id }');" >删除</a>
								</td>
							</c:if>
	                    </tr>
                	</c:forEach>
                </tbody>
            </table>
            ${pageCode }
        </div>
	
</body>
</html>
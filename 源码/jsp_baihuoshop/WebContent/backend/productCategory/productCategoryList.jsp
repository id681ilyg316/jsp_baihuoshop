<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品分类显示</title>
</head>
<body>
			<div class="m_right" id="content">
				<div class="mem_tit">分类列表</div>
				<p align="right">
					<a href='javascript:window.location.href="${pageContext.request.contextPath}/admin/productCategory?action=presave"'
						class="add_b">添加分类</a> <br>
				</p>
				<br>
				<table class="order_tab"
					style="width: 930px; text-align: center; margin-bottom: 30px;"
					cellspacing="0" cellpadding="0" border="0">
					<tbody>
						<tr>
							<td width="20%">分类名称</td>
							<td width="25%">分类级别</td>
							<td width="25%">父级分类</td>
							<td width="25%">操作</td>
						</tr>
						<c:forEach var="allCategory" items="${allCategoryList }">
							
							<tr>
								
								<td>${allCategory.name }</td>
								<td id="customCategory">
									<c:choose>
						               <c:when test="${allCategory.type==1}">一级分类</c:when>
						               <c:when test="${allCategory.type==2}">二级分类</c:when>
						               <c:when test="${allCategory.type==3}">三级分类</c:when>
					            	</c:choose>
								</td>
								<td>
									<c:if test="${empty allCategory.parentName}">
	            						无
	           						</c:if>
						            <c:if test="${not empty allCategory.parentName}">
						            	${allCategory.parentName}
						            </c:if>
								</td>
								<td>
									<a style="margin-right: 30px" href="javascript:window.location.href='${pageContext.request.contextPath}/admin/productCategory?id=${allCategory.id }&action=presave&parentName=${allCategory.parentName}'" >修改</a>
									<a href="javascript:void(0);" onclick="deleteProductCategory(${allCategory.id});">删除</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				${pageCode }<!-- 分页 -->
				
			</div>
</body>
</html>
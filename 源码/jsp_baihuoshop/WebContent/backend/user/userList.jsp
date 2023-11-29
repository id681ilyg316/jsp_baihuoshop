<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>

</head>
<body>
	<div class="m_right" id="content">
            <div class="mem_tit">用户列表</div>
            <p align="right">
                <a href="${pageContext.request.contextPath}/admin/user?action=presave" class="add_b">添加用户</a>
                <br>
            </p>
            <br>
            <table class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0" border="0">
                <tbody>
                <tr>
                    <td width="10%">用户名称</td>
                    <td width="10%">真实姓名</td>
                    <td width="5%">性别</td>
                    <td width="5%">类型</td>
                    <td colspan="2" width="5%">操作</td>
                </tr>
                	<c:forEach var="user" items="${userList }">
	                    <tr>
	                        <td>${user.loginName }</td>
	                        <td>${user.userName }</td>
	                        <td>
	                            <c:if test="${user.sex==1 }">
	                            	男
	                            </c:if>
	                            <c:if test="${user.sex==0 }">
	                            	女
	                            </c:if>
	                        </td>
	                        <td>
	                            <c:if test="${user.type==1 }">
	                            	管理员
	                            </c:if>
	                            <c:if test="${user.type==0 }">
	                            	普通用户
	                            </c:if>
	                        </td>
	                        <td>
	                            <a href="${pageContext.request.contextPath}/admin/user?action=presave&id=${user.id }">修改</a>
	                        </td>
	                        <td>
	                        	<a href="javascript:void(0);" onclick="deleteUserId(${user.id });" >删除</a>
	                        </td>
	                    </tr>
                	</c:forEach>
                </tbody>
            </table>
            ${pageCode }
         </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>头部</title>
</head>
<body>
	<div class="soubg">
		 <div class="sou">
		   <!--Begin 所在收货地区 Begin-->
		    
		       <!--End 所在收货地区 End-->
		       <span class="fr">
		         <c:if test="${sessionScope.currentUser==null}">
		           <span class="fl">你好，请<a href="${pageContext.request.contextPath}/Pre/login.jsp"  style="color:#ff4e00;">登录</a>&nbsp;<a href="${pageContext.request.contextPath}/Pre/register.jsp" style="color:#ff4e00;">免费注册</a>&nbsp;&nbsp;</span>
		         </c:if>
		         <c:if test="${sessionScope.currentUser!=null}">
		           <span class="fl"><a href="${pageContext.request.contextPath}/admin/user?action=userDetail&id=${sessionScope.currentUser.id }">${sessionScope.currentUser.userName}</a>&nbsp;|&nbsp;<a href="${pageContext.request.contextPath}/admin/order?action=queryMyOrder&userId=${sessionScope.currentUser.id }">我的订单</a>&nbsp;</span>
		         </c:if>
		          <c:if test="${sessionScope.currentUser!=null && sessionScope.currentUser.type==1}">
		           <span class="fl">|&nbsp;<a href="${pageContext.request.contextPath}/admin/product?action=index">后台管理</a>&nbsp;</span>
		         </c:if>
		          <c:if test="${sessionScope.currentUser!=null}">
		            <span class="fl">|&nbsp;<a href="${pageContext.request.contextPath}/admin/user?action=logout" >注销</a></span>
		         </c:if>
		       </span>
		 </div>
	</div>
	
	<div id="fade1" class="black_overlay"></div>
	<div id="MyDiv1" class="white_content">
	  <div class="white_d">
	    <div class="notice_t">
	      <span class="fr" style="margin-top:10px; cursor:pointer;" onclick="CloseDiv_1('MyDiv1','fade1')"><img src="${pageContext.request.contextPath}/statics/images/close.gif"></span>
	    </div>
	    <div class="notice_c">
	      <table cellspacing="0" cellpadding="0" border="0" align="center">
	        <tbody><tr valign="top">
	          <td width="40"><img src="${pageContext.request.contextPath}/statics/images/suc.png"></td>
	          <td>
	            <span style="color:#3e3e3e; font-size:18px; font-weight:bold;" id="showMessage">操作成功</span><br>
	          </td>
	        </tr>
	      </tbody></table>
	    </div>
	  </div>
	</div>
</body>
</html>
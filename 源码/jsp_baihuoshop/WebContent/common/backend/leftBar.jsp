<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="m_left">
				<div class="left_n">管理中心</div>
				<div class="left_m">
					<div class="left_m_t t_bg1">订单中心</div>
					<ul>
						<li><a href="${pageContext.request.contextPath}/admin/order?action=queryMyOrder&userId=${sessionScope.currentUser.id }" <c:if test="${menu==1}"> class="now" </c:if>>我的订单</a></li>
						<c:if test="${sessionScope.currentUser.type==1 }">
							<li><a href="${pageContext.request.contextPath}/admin/order?action=queryAllOrder" <c:if test="${menu==3}"> class="now" </c:if>>全部订单</a></li>
						</c:if>

					</ul>
				</div>
				<div class="left_m">
					<div class="left_m_t t_bg2">会员中心</div>
					<ul>
						<li><a href="${pageContext.request.contextPath}/admin/user?action=userDetail&id=${sessionScope.currentUser.id }" <c:if test="${menu==2}"> class="now" </c:if>>用户信息</a></li>
						
						<c:if test="${sessionScope.currentUser.type==1 }">
							<li><a href="${pageContext.request.contextPath}/admin/user?action=queryUserList" <c:if test="${menu==8}"> class="now" </c:if>>用户列表</a></li>
						</c:if>
					</ul>
				</div>
				
				<c:if test="${sessionScope.currentUser.type==1 }">
					<div class="left_m">
						<div class="left_m_t t_bg2">商品管理</div>
						<ul>
							<li><a href="${pageContext.request.contextPath}/admin/productCategory?action=CategoryList" <c:if test="${menu==4}"> class="now" </c:if>>分类管理</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/product?action=index" <c:if test="${menu==5}"> class="now" </c:if>>商品管理</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/product?action=preSave" <c:if test="${menu==6}"> class="now" </c:if>>商品上架</a></li>
						</ul>
					</div>
				</c:if>
				
				<div class="left_m">
					<div class="left_m_t t_bg2">资讯中心</div>
					<ul>
						<li><a href="${pageContext.request.contextPath}/admin/news?action=index"  <c:if test="${menu==7}"> class="now" </c:if>>资讯列表</a></li>
					</ul>
				</div>
			</div>
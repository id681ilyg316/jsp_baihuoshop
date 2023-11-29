<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
		<div class="car_t">
	                             购物车 [
	            <span>
	                <c:if test="${sessionScope.cart!=null && sessionScope.cart.cartItems.size()>0}">
	                    ${sessionScope.cart.cartItems.size()}
	                </c:if>
	                <c:if test="${sessionScope.cart==null || sessionScope.cart.cartItems.size()<=0}">
	               	     空
	                </c:if>
	            </span>]
		</div>
        <div class="car_bg">
            <!--Begin 购物车未登录 Begin-->
            <c:if test="${sessionScope.currentUser==null}">
                <div class="un_login">还未登录！<a href="${pageContext.request.contextPath}/Pre/login.jsp" style="color:#ff4e00;">马上登录</a></div>
            </c:if>
            <c:if test="${sessionScope.currentUser!=null}">
                <div class="un_login">我的购物车</div>
            </c:if>
            <!--End 购物车未登录 End-->
            <!--Begin 购物车已登录 Begin-->
            <ul class="cars">
                <c:forEach items="${sessionScope.cart.cartItems}" var="temp">
                    <li>
                        <div class="img"><a href="${pageContext.request.contextPath}/Product?action=queryProductDeatil&id=${temp.product.id}"><img src="${pageContext.request.contextPath}/files/${temp.product.fileName}" width="58" height="58" /></a></div>
                        <div class="name"><a href="${pageContext.request.contextPath}/Product?action=queryProductDeatil&id=${temp.product.id}">${temp.product.name}</a></div>
                        <div class="price"><font color="#ff4e00">￥${temp.product.price}</font> X${temp.goNum}</div>
                    </li>
                </c:forEach>
            </ul>
            <div class="price_sum">共计&nbsp;<font color="#ff4e00">￥</font><span>${sessionScope.cart.totalMoney}</span></div>
            <c:if test="${sessionScope.currentUser==null}">
                <div class="price_a"><a href="${pageContext.request.contextPath}/Pre/login.jsp">去登录</a></div>
            </c:if>
            <c:if test="${sessionScope.currentUser!=null}">
                <div class="price_a"><a href="${pageContext.request.contextPath}/cart?action=toSettlement">去结算</a></div>
            </c:if>
            <!--End 购物车已登录 End-->
        </div>

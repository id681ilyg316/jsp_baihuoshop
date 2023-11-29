<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>易卖网</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui/css/layui.css"  media="all">
<script src="${pageContext.request.contextPath}/statics/layui/layui.js" charset="utf-8"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/style.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/jquery-1.11.1.min_044d0927.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/jquery.bxslider_e88acd1b.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/menu.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/select.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/lrscroll.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/iban.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/fban.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/f_ban.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/mban.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/bban.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/hban.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/tban.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/lrscroll_1.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/register/register.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/ShopShow.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/MagicZoom.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/MagicZoom.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/num.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/p_tab.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/shade.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/cart/cart.js"></script>
</head>
<body>
	
	<jsp:include page="../../common/pre/header.jsp"></jsp:include>
	
	<jsp:include page="../../common/pre/searchBar.jsp"></jsp:include>
	
	<div class="menu_bg">
	    <div class="menu">
		    <!--Begin 商品分类详情 Begin-->
			<div class="nav">
			    <div class="nav_t">全部商品分类</div>
			    <div class="leftNav none" style="display: none;">
			        <ul id="leftMenu">
			           <c:forEach items="${productCategoryVoList1}" var="temp" >
	                        <li>
		                        <div class="fj">
			                        <span class="n_img"><span></span>
			                        <img src="${pageContext.request.contextPath}/statics/images/${temp.productCategory.iconClass}"/></span>
			                        <span class="fl">${temp.productCategory.name}</span>
		                        </div>
	                            <div class="zj">
	                                <div class="zj_l">
	                                    <c:forEach items="${temp.productCategoryVoList2}" var="vo">
	                                        <div class="zj_l_c">
	                                            <h2>
	                                               <a href="${pageContext.request.contextPath}/product?action=productList2&id=${vo.productCategory.id}">${vo.productCategory.name}</a>
	                                            </h2>
	                                            <c:forEach items="${vo.productCategoryVoList3}" var="vo2">
	                                                 <a href="${pageContext.request.contextPath}/product?action=productList3&id=${vo2.id}&level=3">${vo2.name}</a> |
	                                            </c:forEach>
	                                        </div>
	                                    </c:forEach>
	                                </div>
	                            </div>
	                        </li>
                    </c:forEach>
			        </ul>
			    </div>
			</div>
			<ul class="menu_r">
				<li><a href="${pageContext.request.contextPath}/init">首页</a></li>
	            <c:forEach var="data" items="${productCategoryList }">
		            <li><a href="${pageContext.request.contextPath}/product?action=productList&id=${data.id }">${data.name }</a></li>
	            </c:forEach>
			</ul>
			<div class="m_ad">中秋送好礼！</div>
		    <!--End 商品分类详情 End-->
	    </div>
	</div>
	
	<div class="i_bg">
		<div id="settlement">
			<!-- 显示内容 -->
			<jsp:include page="${mainPage }"></jsp:include>	
		</div>
		
	</div>
	
	
	<!-- 尾部 -->
		<jsp:include page="../../common/footer.jsp"></jsp:include>
</body>
</html>
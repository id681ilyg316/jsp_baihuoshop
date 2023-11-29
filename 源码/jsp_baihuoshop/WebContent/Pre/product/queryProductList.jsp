<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表界面</title>
<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
</script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui/css/layui.css"  media="all">
<script src="${pageContext.request.contextPath}/statics/layui/layui.js" charset="utf-8"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/style.css">
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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/ShopShow.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/MagicZoom.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/MagicZoom.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/num.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/p_tab.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/shade.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/n_nav.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/cart/cart.js"></script>
<script>
      favoriteList();
</script>
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
	    <!--Begin 筛选条件 Begin-->
	    <!--End 筛选条件 End-->
	    <div class="content mar_20">
	        <div id="favoriteList">
		        <div class="l_history">
		        	<div class="fav_t">我的收藏</div>
				</div>
			</div>
	        <div class="l_list">
	            <div class="list_t">
	                <span class="fr">共发现${requestScope.total }件</span>
	            </div>
	            <div class="list_c">
	                <ul class="cate_list">
	                <c:forEach items="${requestScope.productList }" var="product">
	                    <li>
	                       <div class="img">
	                           <a href="${pageContext.request.contextPath}/product?action=queryProductDeatil&id=${product.id}" >
	                               <img src="${pageContext.request.contextPath}/files/${product.fileName }" width="210" height="185">
	                           </a>
	                       </div>
	                       <div class="price">
	                           <font>￥<span>${product.price }</span></font>
	                       </div>
	                       <div class="name"><a href="${pageContext.request.contextPath}/Product?action=queryProductDeatil&amp;id=733">${product.name }</a></div>
	                       <div class="carbg">
	                           <a href="javascript:void(0);" class="ss" onclick="addFavorite('733')">收藏</a>
	                           <a href="javascript:void(0);" class="j_car" onclick="addCartByParam(${product.id },1);">加入购物车</a>
	                       </div>
	                       <input type="hidden" value="${product.stock }">
	                    </li>
	                </c:forEach>
	                </ul>
					 ${pageCode }
	            </div>
	        </div>
	    </div>
	</div>
	
	<!-- 尾部 -->
		<jsp:include page="../../common/footer.jsp"></jsp:include>
</body>
</html>
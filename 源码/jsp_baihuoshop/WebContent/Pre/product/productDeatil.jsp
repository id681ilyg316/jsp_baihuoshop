<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
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
	    <div class="postion">
	    </div>
	    <div class="content">
	        <div id="tsShopContainer">
	            <div id="tsImgS">
	                <a href="${pageContext.request.contextPath}/files/${requestScope.product.fileName }" title="Images" class="MagicZoom" id="MagicZoom" style="position: relative; display: block; outline: currentcolor none 0px; text-decoration: none; width: 390px; -moz-user-select: none;">
	                	<img src="${pageContext.request.contextPath}/files/${requestScope.product.fileName }" id="sim894568" width="390" height="390">
		                <div id="bc894568" style="width: 300px; height: 297px; left: -10000px; top: 0px; overflow: hidden; z-index: 100; visibility: hidden; position: absolute;" class="MagicZoomBigImageCont">
		                	<div style="overflow: hidden;">
		                		<img src="${pageContext.request.contextPath}/files/${requestScope.product.fileName }" style="position: relative;">
		                	</div>
		                </div>
	                	<div class="MagicZoomPup" style="z-index: 10; visibility: hidden; position: absolute; opacity: 0.5; width: 300px; height: 297px;"></div>
	                </a>
	            </div>
	        </div>
	        <div class="pro_des">
	            <div class="des_name">
	                <input value="${product.id}" name="entityId" class="n_ipt" type="hidden">
	                <p>${requestScope.product.name }</p>
	                “开业巨惠，北京专柜直供”，不光低价，“真”才靠谱！
	            </div>
	            <div class="des_price">
	             	   本店价格：<b>￥${requestScope.product.price }</b><br>
	            </div>
	           <div class="des_price">
	                                        库存：<b>${requestScope.product.stock }</b><br>
	            </div>
	            <div class="des_choice">
	                <span class="fl">型号选择：</span>
	                <ul>
	                    <li class="checked">30ml
	                        <div class="ch_img"></div>
	                    </li>
	                    <li>50ml
	                        <div class="ch_img"></div>
	                    </li>
	                    <li>100ml
	                        <div class="ch_img"></div>
	                    </li>
	                </ul>
	            </div>
	            <div class="des_choice">
	                <span class="fl">颜色选择：</span>
	                <ul>
	                    <li>红色
	                        <div class="ch_img"></div>
	                    </li>
	                    <li class="checked">白色
	                        <div class="ch_img"></div>
	                    </li>
	                    <li>黑色
	                        <div class="ch_img"></div>
	                    </li>
	                </ul>
	            </div>
	            <br>
	            <br>
	            <div class="des_join">
	                <div class="j_nums">
	                    <input value="1" name="quantity" class="n_ipt" type="text">
	                    <input value="" onclick="addUpdate(jq(this));" class="n_btn_1" type="button">
	                    <input value="" onclick="jianUpdate(jq(this));" class="n_btn_2" type="button">
	                    <input name="productStock" value="1000" type="hidden">
	                </div>
	                <span class="fl">
	                     <img src="${pageContext.request.contextPath}/statics/images/j_car.png" onclick="addCart();">
	                </span>
	            </div>
	        </div>
	    </div>
	    <div class="content mar_20">
		    <div id="favoriteList">
			    <div class="l_history">
			        <div class="fav_t">我的收藏</div>
				</div>
			</div>
	        <div class="l_list">
	            <div class="des_border">
	                <div class="des_tit">
	                    <ul>
	                        <li class="current"><a href="#p_attribute">商品属性</a></li>
	                        <li><a href="#p_details">商品详情</a></li>
	                    </ul>
	                </div>
	                <div class="des_con" id="p_attribute">
	                    <table style="width:100%; font-family:'宋体'; margin:10px auto;" cellspacing="0" cellpadding="0" border="0" align="center">
	                        <tbody><tr>
	                            <td>商品名称：${requestScope.product.name }</td>
	                            <td>商品价格：${requestScope.product.price }</td>
	                            <td>品牌： 迪奥（Dior）</td>
	                            <td>上架时间：2015-09-06 09:19:09 </td>
	                        </tr>
	                        <tr>
	                            <td>商品毛重：160.00g</td>
	                            <td>商品产地：法国</td>
	                            <td>香调：果香调香型：淡香水/香露EDT</td>
	                            <td>&nbsp;</td>
	                        </tr>
	                        <tr>
	                            <td>容量：1ml-15ml </td>
	                            <td>类型：女士香水，Q版香水，组合套装</td>
	                            <td>&nbsp;</td>
	                            <td>&nbsp;</td>
	                        </tr>
	                    </tbody></table>
	                </div>
	            </div>
	            <div class="des_border" id="p_details">
	                <div class="des_t">商品详情</div>
	                <div class="des_con">
	                    <table style="width:745px; font-size:14px; font-family:'宋体';" cellspacing="0" cellpadding="0" border="0" align="center">
	                        <tbody>
	                        <tr>
	                            <td>
	                            </td>
	                        </tr>
	                    </tbody></table>
	                    <p align="center">
	                        <img src="${pageContext.request.contextPath}/files/${requestScope.product.fileName }" width="185" height="155">
	                    </p>
	                </div>
	            </div>
	        </div>
	    </div>
</div>
	
	<!-- 尾部 -->
		<jsp:include page="../../common/footer.jsp"></jsp:include>
	
</body>
</html>
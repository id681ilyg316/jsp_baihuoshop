<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

	
	    <div class="content mar_20">
    		<img src="${pageContext.request.contextPath}/statics/images/img1.jpg"/>
		</div>
		<div class="content mar_20" >
		    <table border="0" class="car_tab" style="width:1200px; margin-bottom:50px;" cellspacing="0" cellpadding="0">
		        <tr>
		            <td class="car_th" width="200">商品名称</td>
		            <td class="car_th" width="150">单价</td>
		            <td class="car_th" width="150">购买数量</td>
		            <td class="car_th" width="130">小计</td>
		            <td class="car_th" width="150">操作</td>
		        </tr>
		        <c:forEach items="${sessionScope.cart.cartItems}" var="temp">
		            <tr>
		                <td>
		                    <div class="c_s_img">
		                        <a href="${pageContext.request.contextPath}/Product?action=queryProductDeatil&id=${temp.product.id}"><img src="${pageContext.request.contextPath}/files/${temp.product.fileName}" width="73" height="73"/></a>
		                    </div>
		                        ${temp.product.name}
		                </td>
		                <td align="center" style="color:#ff4e00;">￥${temp.product.price}</td>
		                <td align="center">
		                    <div class="c_num">
		                        <input type="button" value="" onclick="subQuantity(this,'${temp.product.id}');" class="car_btn_1"/>
		                        <input type="text" id="count" value="${temp.goNum}" name="" class="car_ipt"/>
		                        <input type="button" id="a" value="" onclick="addQuantity(this,'${temp.product.id}',${temp.product.stock});" class="car_btn_2"/>
		                    </div>
		                </td>
		                <td align="center" style="color:#ff4e00;">￥${temp.cost}</td>
		                <td align="center"><a href="javascript:void(0);" onclick="removeCart('${temp.product.id}');" >删除</a>&nbsp; &nbsp;</td>
		            </tr>
		        </c:forEach>
		        <tr height="70">
		            <td colspan="6" style="font-family:'Microsoft YaHei'; border-bottom:0;">
		                <c:if test="${sessionScope.cart==null || sessionScope.cart.totalMoney==null}">
		                    <span class="fr">商品总价：<b style="font-size:22px; color:#ff4e00;">￥0</b></span>
		                </c:if>
		                <c:if test="${sessionScope.cart!=null && sessionScope.cart.totalMoney!=null}">
		                    <span class="fr">商品总价：<b style="font-size:22px; color:#ff4e00;">￥${sessionScope.cart.totalMoney}</b></span>
		                </c:if>
		            </td>
		        </tr>
		        <tr valign="top" height="150">
		            <td colspan="6" align="right">
		                <a href="${pageContext.request.contextPath}/init"><img src="${pageContext.request.contextPath}/statics/images/buy1.gif" /></a>&nbsp;&nbsp;
		                <c:if test="${sessionScope.cart!=null && sessionScope.cart.totalMoney>0}">
		                    <a href="javascript:void(0);" onclick="settlement2()"><img src="${pageContext.request.contextPath}/statics/images/buy2.gif" /></a>
		                </c:if>
		            </td>
		        </tr>
		    </table>
		</div>

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
</head>
<body>
	<div class="i_bg">
	    <!--Begin 筛选条件 Begin-->
	    <!--End 筛选条件 End-->
	    <div id="settlement"></div>
	    
	    <div class="content mar_20">
   	 		<img src="${pageContext.request.contextPath}/statics/images/img2.jpg"/>
		</div>
		<div class="content mar_20">
		    <div class="two_bg">
		        <div class="two_t">
		            <span class="fr"><a href="javascript:void(0);" onclick="settlement1();">修改</a></span>商品列表
		        </div>
		        <table border="0" class="car_tab" style="width:1110px;" cellspacing="0" cellpadding="0">
		            <tr>
		                <td class="car_th" width="550">商品名称</td>
		                <td class="car_th" width="150">购买数量</td>
		                <td class="car_th" width="130">小计</td>
		            </tr>
		            <c:forEach items="${sessionScope.cart.cartItems}" var="temp">
		                <tr>
		                    <td>
		                        <div class="c_s_img">
		                            <img src="${pageContext.request.contextPath}/files/${temp.product.fileName}" width="73" height="73"/>
		                        </div>
		                            ${temp.product.name}
		                    </td>
		                    <td align="center">${temp.goNum}</td>
		                    <td align="center" style="color:#ff4e00;">￥${temp.cost}</td>
		                </tr>
		            </c:forEach>
		        </table>
		
		        <div class="two_t">
		            <span class="fr"></span>收货人信息
		        </div>
		        <table border="0" class="peo_tab" style="width:1110px;" cellspacing="0" cellpadding="0">
		            <tr>
		                <td class="p_td" width="160">用户名称</td>
		                <td width="395">${sessionScope.currentUser.userName}</td>
		                <td class="p_td">登录名称</td>
		                <td>${sessionScope.currentUser.loginName}</td>
		            </tr>
		            <tr>
		                <td class="p_td">手机</td>
		                <td>${sessionScope.currentUser.mobile}</td>
		                <td class="p_td" width="160">电子邮件</td>
		                <td width="395">${sessionScope.currentUser.email}</td>
		            </tr>
		        </table>
		        <div class="two_t">
		            <span class="fr"></span>选择地址
		        </div>
		        <table border="0" class="peo_tab" style="width:1110px;" cellspacing="0" cellpadding="0">
		            <c:forEach items="${userAddressList}" var="temp" varStatus="status">
		                <tr>
		                    <td class="p_td" width="160">
		                        <c:choose>
		                            <c:when test="${empty temp.remark}">
		                                	地址${status.index+1}
		                            </c:when>
		                            <c:otherwise>
		                                ${temp.remark}
		                            </c:otherwise>
		                        </c:choose>
		                        <input type="radio" name="selectAddress" value="${temp.id}">
		                    </td>
		                    <td>
		                            ${temp.address}
		                    </td>
		                </tr>
		            </c:forEach>
		            <tr>
		                <td class="p_td" width="160">
		                                                         新地址<input type="radio" name="selectAddress" value="-1">
		                </td>
		                <td>
					                    地址&nbsp;<input type="text" value="" name="address" class="add_ipt">&nbsp;
					                    备注&nbsp;<input type="text" value="" name="remark" class="add_ipt">
		                </td>
		            </tr>
		        </table>
		        ${pageCode }
		        <table border="0" style="width:900px; margin-top:20px;" cellspacing="0" cellpadding="0">
		            <tr height="70">
		                <td align="right">
		                    <b style="font-size:14px;">应付款金额：<span
		                            style="font-size:22px; color:#ff4e00;">￥${sessionScope.cart.totalMoney}</span></b>
		                </td>
		            </tr>
		            <tr height="70">
		                <td align="right"><a href="javascript:void(0);" onclick="settlement3();"><img
		                        src="${pageContext.request.contextPath}/statics/images/btn_sure.gif"/></a></td>
		            </tr>
		        </table>
		    </div>
		</div>
	</div>   
</body>
</html>
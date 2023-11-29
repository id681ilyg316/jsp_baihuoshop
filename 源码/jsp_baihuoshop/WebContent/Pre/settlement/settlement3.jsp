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
    		<img src="${pageContext.request.contextPath}/statics/images/img3.jpg"/>
		</div>
		<div class="content mar_20">
		    <!--Begin 银行卡支付 Begin -->
		    <div class="warning">
		        <table border="0" style="width:1000px; text-align:center;" cellspacing="0" cellpadding="0">
		            <tr height="35">
		                <td style="font-size:18px;">
		                    感谢您在本店购物！您的订单已提交成功，请记住您的订单号: <font color="#ff4e00">${currentOrder.serialNumber}</font>
		                </td>
		            </tr>
		            <tr>
		                <td style="font-size:14px; font-family:'宋体'; padding:10px 0 20px 0; border-bottom:1px solid #b6b6b6;">
		                    您选定的配送方式为: <font color="#ff4e00">申通快递</font>； &nbsp; &nbsp;您选定的支付方式为: <font
		                        color="#ff4e00">支付宝</font>； &nbsp; &nbsp;您的应付款金额为: <font color="#ff4e00">￥${currentOrder.cost}</font>
		                </td>
		            </tr>
		            <tr>
		                <td style="padding:20px 0 30px 0; font-family:'宋体';">
		                    收款人信息：全称 ${sessionScope.currentUser.userName} ；地址 ${currentOrder.userAddress} ； <br/>
		                </td>
		            </tr>
		            <tr>
		                <td>
		                    <a href="${pageContext.request.contextPath}/init">首页</a> &nbsp; &nbsp; <a href="${pageContext.request.contextPath}/admin/user?action=userDetail&id=${sessionScope.currentUser.id }">用户中心</a>
		                </td>
		            </tr>
		        </table>
		    </div>
		</div>
	</div>   
</body>
</html>
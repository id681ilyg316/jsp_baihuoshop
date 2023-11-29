<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单列表</title>
</head>
<body>
	  <div class="m_right" id="content">
      <p></p>
      <p></p>
      <div class="mem_tit">订单列表</div>
      <table class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0" border="0">
        <tbody>
        <c:forEach var="orderMap" items="${orderMapList }">
          <tr class="td_bg">
            <td>用户名:${orderMap.order.loginName }</td>
            <td><a href="../../admin/order?action=queryOrderDeatil&amp;orderId=3">订单号:${orderMap.order.serialNumber }</a></td>
            <td>地址:${orderMap.order.userAddress }</td>
            <td>${orderMap.order.cost }</td>
          </tr>
          <tr>
          </tr>
          <tr>
            <td colspan="4">
              <table class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0" border="0">
                <tbody>
	                <tr>
	                  <td width="20%">商品名称</td>
	                  <td width="20%">商品图片</td>
	                  <td width="25%">数量</td>
	                  <td width="25%">价格</td>
	                </tr>
	                <c:forEach var="product" items="${orderMap.productList }">
		                <tr>
		                  <td>${product.name }</td>
		                  <td>
		                    <a href="../../Product?action=queryProductDeatil&amp;id=733" target="_blank">
		                      <img src="${pageContext.request.contextPath}/files/${product.fileName }" width="50" height="50">
		                    </a>
		                  </td>
		                  <td>${product.quantity }</td>
		                  <td>${product.price }</td>
		                </tr>
	                </c:forEach>
                
                </tbody>
              </table>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
      <c:if test="${orderMapList.size()<=0 }">
      		<div class="pages">暂无记录</div>
      </c:if>
       <c:if test="${orderMapList.size()>0 }">
      		${pageCode }
      </c:if>
    </div>
  
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理</title>
</head>
<body>
			
			<div class="m_right" id="content">
				<div class="mem_tit">商品列表</div>
				<br>
				<table class="order_tab"
					style="width: 930px; text-align: center; margin-bottom: 30px;"
					cellspacing="0" cellpadding="0" border="0">
					<tbody>
						<tr>
							<td width="10%">商品名称</td>
							<td width="10%">商品图片</td>
							<td width="5%">库存</td>
							<td width="10%">价格</td>
							<td colspan="2" width="10%">操作</td>
						</tr>
						<c:forEach var="product" items="${productList }">
							<tr>
								<td>${product.name }</td>
								<td><a
									href="${pageContext.request.contextPath}/Product?action=queryProductDeatil&amp;id=733"
									target="_blank"> <img
										src="${pageContext.request.contextPath}/files/${product.fileName }"
										width="50" height="50">
								</a></td>
								<td>${product.stock }</td>
								<td>${product.price }</td>
								<td>
									<a href="${pageContext.request.contextPath}/admin/product?action=preSave&id=${product.id }">修改</a>
								</td>
								<td>
									<a href="javascript:void(0);" onclick="deleteById('${product.id }');" >删除</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				${pageCode }
			</div>

</body>
</html>
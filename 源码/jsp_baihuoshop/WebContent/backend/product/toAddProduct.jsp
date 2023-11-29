<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品页面</title>
</head>
<body>
	
			<div class="m_right" id="content">
				<c:if test="${product==null }">
					<div class="mem_tit">添加商品</div>
				</c:if>
				
				<c:if test="${product!=null }">
					<div class="mem_tit">修改商品</div>
				</c:if>

				<br>
				<form action="${pageContext.request.contextPath}/admin/product?action=save" method="post"
					enctype="multipart/form-data" id="productAdd"
					onsubmit="return checkProduct();">
					<table class="add_tab" style="width: 930px;" cellspacing="0"
						cellpadding="0" border="0">
						<tbody>
							<tr>
								<td width="135" align="right">一级分类</td>
								<td colspan="3" style="font-family: '宋体';">
									<select data-type="2" name="categoryLevel1Id" style="background-color: #f6f6f6;" id="productCategoryLevel1" onchange="queryProductCategoryList(this,'productCategoryLevel2');">
											<option value="" selected="selected">请选择...</option>
											<c:forEach var="Category1" items="${productCategoryList1 }">
												<option  value='${Category1.id }' ${Category1.id==product.categoryLevel1Id?'selected':'' }>${Category1.name }</option>
											</c:forEach>
	
									</select>
								</td>
							</tr>
							<tr>
								<td width="135" align="right">二级分类</td>
								<td><select data-type="3" name="categoryLevel2Id"
									style="background-color: #f6f6f6;" id="productCategoryLevel2"
									onchange="queryProductCategoryList(this,'productCategoryLevel3');">
									<option value="0" selected="selected">请选择...</option>
									<c:forEach var="Category2" items="${productCategoryList2 }">
										<option value='${Category2.id }' ${Category2.id==product.categoryLevel2Id?'selected':'' }>${Category2.name }</option>
									</c:forEach>
								</select>
								</td>
							</tr>
							<tr>
								<td width="135" align="right">三级分类</td>
								<td><select name="categoryLevel3Id"
									style="background-color: #f6f6f6;" id="productCategoryLevel3">
									<option value="0" selected="selected">请选择...</option>
									<c:forEach var="Category3" items="${productCategoryList3 }">
											<option value='${Category3.id }' ${Category3.id==product.categoryLevel3Id?'selected':'' }>${Category3.name }</option>
									</c:forEach>
								</select>
								</td>
							</tr>
							<tr>
								<td width="135" align="right">商品名称</td>
								<td>
								<input value="${product.name }" class="add_ipt" name="name" id="name" type="text">（必填） 
								<input name="id" value="${product.id }" id="id" type="hidden"></td>
							</tr>
							<tr>
								<td width="135" align="right">商品图片</td>
								<td>
									<c:if test="${product!=null }">
										<img src="${pageContext.request.contextPath}/files/${product.fileName }"  width="50" height="50" />
									</c:if>
									<input class="text" name="photo" type="file">
									<span></span>
									<c:if test="${product!=null }">
										<input name="imageName" id="imageName" type="hidden" value="${product.fileName }"/>
									</c:if>
								</td>
							</tr>
							<tr>
								<td width="135" align="right">单价</td>
								<td>
									<input value="${product.price }" class="add_ipt" name="price" id="price" type="text">
								</td>
							</tr>
							<tr>
								<td width="135" align="right">库存</td>
								<td>
									<input value="${product.stock }" class="add_ipt" name="stock" id="stock" type="text">
								</td>
							</tr>
							<tr>
								<td width="135" align="right">描述</td>
								<td><textarea name="description">${stock.description }</textarea></td>
							</tr>
							<tr>
								<td></td>
								<td>
									<c:if test="${product!=null }">
										<input value="确定修改" class="s_btn" type="submit">
									</c:if>
									<c:if test="${product==null }">
									<input value="商品上架" class="s_btn" type="submit">
									</c:if>
								</td>
							</tr>
						</tbody>
					</table>
					<script type="text/javascript">
						var contextPath = "${pageContext.request.contextPath}";
					</script>
				</form>
			</div>
</body>
</html>
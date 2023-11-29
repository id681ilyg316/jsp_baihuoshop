<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
			<div class="m_right" id="content">
				<div class="mem_tit">分类列表</div>

				<div id="addProductCategory">
					<table border="0" class="add_tab" style="width: 930px;"
						cellspacing="0" cellpadding="0">
						<tr  >
							<td width="135" align="right">分类级别</td>
							<td colspan="3" style="font-family: '宋体';">
							<select <c:if test="${productCategory.id!=null}">disabled="disabled"</c:if>  name="type" style="background-color: #f6f6f6;" id="type" onchange="changeProductCategory(this);">
									<option value="" selected="selected">请选择...</option>
									<option value="1" <c:if test="${productCategory.type==1}">selected="selected"</c:if>>
										 一级分类
									</option>
									<option value="2" <c:if test="${productCategory.type==2}">selected="selected"</c:if>>
										 二级分类
									</option>
									<option value="3" <c:if test="${productCategory.type==3}">selected="selected"</c:if>>
										  三级分类
									</option>
							</select>
							</td>
						</tr>
						<tr id="yiji" <c:if test="${productCategory.type==1}">style="display:none"</c:if>>
							<td width="135" align="right">一级分类</td>
							<td colspan="3" style="font-family: '宋体';">
								<select data-type="2" name="productCategoryLevel1" style="background-color: #f6f6f6;" id="productCategoryLevel1" onchange="queryProductCategoryList(this,'productCategoryLevel2');">
										<option value="0" selected="selected">请选择...</option>
										<c:forEach items="${productCategoryList1}" var="temp">
											<option value="${temp.id}"
											<c:if test="${ productCategory.parentId==temp.id || parentProductCategory.id==temp.id }">selected="selected"</c:if>>${temp.name}</option>
										</c:forEach>
								</select>
							</td>
						</tr>
						<tr <c:if test="${productCategory.type!=3}">style="display:none"</c:if> id="erji" >
							<td width="135" align="right">二级分类</td>
							<td><select   name="productCategoryLevel2"
								style="background-color: #f6f6f6;" id="productCategoryLevel2">
									<option value="0" selected="selected">请选择...</option>
									<c:forEach items="${productCategoryList2}" var="temp">
										<option value="${temp.id}"
											<c:if test="${productCategory.id==temp.id || productCategory.parentId==temp.id}">selected="selected"</c:if>>${temp.name}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td align="right">分类名称</td>
							<td style="font-family: '宋体';"><input type="text"
								value="${productCategory.name}" class="add_ipt" id="name" />（必填）
								<input type="hidden" name="id" value="${productCategory.id}"
								id="id"></td>
						</tr>
					</table>
					<p align="right">
						<br> <a href="javascript:void(0);" onclick="saveOrUpdate();"
							class="add_b">确认修改</a>
					</p>
				</div>


				<script type="text/javascript">
					var contextPath = "${pageContext.request.contextPath}";
				</script>


			</div>

</body>
</html>
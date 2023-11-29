<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑资讯</title>
<script src="${pageContext.request.contextPath}/statics/js/backend/news.js"></script>
<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
</script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/statics/ckeditor/ckeditor.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/jquery-3.3.1.js"></script>

<script type="text/javascript">
layui.use('laydate', function(){
	  var laydate = layui.laydate;
	  //常规用法
	  laydate.render({
	    elem: '#test1'
	  });
});
</script>
</head>
<body>
	<div class="m_right" id="content">
				<c:if test="${news==null }">
					<div class="mem_tit">添加资讯</div>
				</c:if>
				
				<c:if test="${news!=null }">
					<div class="mem_tit">修改资讯</div>
				</c:if>

				<br>
				<form action="${pageContext.request.contextPath}/admin/news?action=save" method="post"
					id="NewsModify">
					<table class="add_tab" style="width: 930px;" cellspacing="0"
						cellpadding="0" border="0">
						<tbody>
							<tr>
								<td width="135" align="right">标题</td>
								<td colspan="3" style="font-family: '宋体';">
									<input name="title" value="${news.title }" id="title"  required lay-verify="required"  style="width: 250px;"   placeholder="请输入标题" class="layui-input" type="text">
								</td>
							</tr>
							<tr>
								<td width="135" align="right">内容</td>
								<td>
									<textarea required lay-verify="required"  placeholder="请输入内容" class="layui-textarea" id="newsContent" name="newsContent"  rows="4" cols="30">${news.content }</textarea>
								</td>
							</tr>
							<tr>
								<td width="135" align="right">时间</td>
								<td>
									<div class="layui-input-inline">
        								<input required lay-verify="required" value="${news.createTime }"  type="text" class="layui-input" id="test1" name="test1" placeholder="请选择时间">
      									<input value="${news.id }" type="hidden" id="id" name="id">
      								</div>
								</td>
							</tr>
							<tr>
								<td></td>
								<td>
									<c:if test="${news!=null }">
										<input value="确定修改" class="s_btn" type="submit">
									</c:if>
									<c:if test="${news==null }">
									<input value="确定添加" class="s_btn" type="submit">
									</c:if>
								</td>
							</tr>
						</tbody>
					</table>
					
				</form>
			</div>
<!-- <script type="text/javascript">
	CKEDITOR.replace("");
</script> -->
</body>
</html>
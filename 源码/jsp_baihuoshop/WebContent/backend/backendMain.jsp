<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台主界面</title>
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
	<script src="${pageContext.request.contextPath}/statics/js/backend/backend.js"></script>
	<script src="${pageContext.request.contextPath}/statics/js/backend/news.js"></script>
	<style type="text/css">
		div{
			margin: 0 auto !important;
		}
</style>
</head>
<body >
	
	
	<jsp:include page="../common/backend/menu.jsp"></jsp:include>
	
	<jsp:include page="../common/backend/searchBar.jsp"></jsp:include>

	<div class="i_bg bg_color" >
		<!--Begin 用户中心 Begin -->
		<div class="m_content" >
		
		<!-- 左边列表 -->
		<jsp:include page="../common/backend/leftBar.jsp"></jsp:include>
		
		<!-- 显示内容 -->
		<jsp:include page="${mainPage }"></jsp:include>	
					
		</div>

		<!-- 尾部 -->
		<jsp:include page="../common/footer.jsp"></jsp:include>

	</div>
</body>
</html>
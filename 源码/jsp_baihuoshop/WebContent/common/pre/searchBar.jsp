<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
    var contextPath = "${ctx}";
</script>
<div id="searchBar">
<div class="top">
    <div class="logo">
        <a href="${ctx}/init"><img src="${ctx}/statics/images/logo.png"></a>
    </div>
    <div class="search">
        <form action="${ctx}/product?action=dimProductName" method="post">
            <input type="text" value="${keyWord}" name="keyWord" class="s_ipt">
            <input type="submit" value="搜索" class="s_btn">
        </form>
        <!--推荐最热商品-->
    </div>
    
    <div class="i_car">
   	 	<jsp:include page="cart.jsp"></jsp:include>
    </div>
</div>
</div>




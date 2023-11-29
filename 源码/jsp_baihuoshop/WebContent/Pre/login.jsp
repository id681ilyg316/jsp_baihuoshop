<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商城登陆界面</title>
<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
</script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui/css/layui.css"  media="all">
<script src="${pageContext.request.contextPath}/statics/layui/layui.js" charset="utf-8"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/style.css"/>
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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/ShopShow.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/MagicZoom.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/MagicZoom.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/num.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/p_tab.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/common/shade.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/login/login.js"></script>
</head>
<body> 

<jsp:include page="../common/pre/header.jsp"></jsp:include>
 
<div class="log_bg">	
    <div class="top">
        <div class="logo"><a href="${pageContext.request.contextPath}/init"><img src="${pageContext.request.contextPath}/statics/images/logo.png" /></a></div>
    </div>
	<div class="login">
    	<div class="log_img"><img src="${pageContext.request.contextPath}/statics/images/l_img.png" width="611" height="425" /></div>
		<div class="log_c">
        	<form action="" method="post">
            <table border="0" style="width:370px; font-size:14px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr height="50" valign="top">
              	<td width="55">&nbsp;</td>
                <td>
                	<span class="fl" style="font-size:24px;">登录</span>
                    <span class="fr">还没有商城账号，<a href="register.jsp" style="color:#ff4e00;">立即注册</a></span>
                </td>
              </tr>
              <tr height="70">
                <td>用户名</td>
                <td><input placeholder="请输入用户名" autocomplete="off" class="layui-input l_user" required lay-verify="required" type="text" name="loginName" id="loginName" value="" /></td>
              </tr>
              <tr height="70">
                <td>密&nbsp; &nbsp; 码</td>
                <td><input placeholder="请输入密码" autocomplete="off" type="password" class="layui-input l_pwd" required lay-verify="required" name="password" id="password" value="" /></td>
              </tr>
              <tr height="60">
              	<td>&nbsp;</td>
                <td><input type="button" value="登录" class="log_btn" onclick="login()" /></td>
              </tr>
            </table>
            </form>
        </div>
    </div>
</div>

<div class="btmbg">
    <div class="btm">
        备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
        <img src="${pageContext.request.contextPath}/statics/images/b_1.gif" width="98" height="33" /><img src="${pageContext.request.contextPath}/statics/images/b_2.gif" width="98" height="33" /><img src="${pageContext.request.contextPath}/statics/images/b_3.gif" width="98" height="33" /><img src="${pageContext.request.contextPath}/statics/images/b_4.gif" width="98" height="33" /><img src="${pageContext.request.contextPath}/statics/images/b_5.gif" width="98" height="33" /><img src="${pageContext.request.contextPath}/statics/images/b_6.gif" width="98" height="33" />
    </div>    	
</div>
</body>
</html>
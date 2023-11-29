<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册界面</title>
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
</head>
<body>
	<jsp:include page="../common/pre/header.jsp"></jsp:include>
	
	<div class="log_bg">
	    <div class="top">
	        <div class="logo"><a href="${pageContext.request.contextPath}/init"><img src="../statics/images/logo.png"/></a></div>
	    </div>
	    <div class="regist">
	        <div class="log_img"><img src="../statics/images/l_img.png" width="611" height="425"/></div>
	        <div class="reg_c">
	            <form class="layui-form" action="" id="register">
	                <table border="0" style="width:420px; font-size:14px; margin-top:20px;" cellspacing="0" cellpadding="0">
	                    <tr height="50" valign="top">
	                        <td width="95">&nbsp;</td>
	                        <td>
	                            <span class="fl" style="font-size:24px;">注册</span>
	                            <span class="fr">已有商城账号，<a href="login.jsp" style="color:#ff4e00;">我要登录</a></span>
	                        </td>
	                    </tr>
	                    <tr height="50">
	                        <td align="right"><font color="#ff4e00">*</font>登录用户名 &nbsp;</td>
	                        <td><input placeholder="请输入用户名" autocomplete="off" required lay-verify="required" type="text" value="" id="loginName" name="loginName" class="layui-input l_user"/></td>
	                    </tr>
	                    <tr height="50">
	                        <td align="right"><font color="#ff4e00">*</font>&nbsp;密码 &nbsp;</td>
	                        <td><input placeholder="请输入密码" autocomplete="off" required lay-verify="required" type="password" value="" id="password" name="password" class="layui-input l_pwd"/></td>
	                    </tr>
	                    <tr height="50">
	                        <td align="right"><font color="#ff4e00">*</font>&nbsp;确认密码 &nbsp;</td>
	                        <td><input placeholder="请输入密码" autocomplete="off" required lay-verify="required" type="password" value="" id="confirmPassword" name="confirmPassword" class="layui-input l_pwd"/></td>
	                    </tr>
	                    <tr height="50">
	                        <td align="right"><font color="#ff4e00">*</font>&nbsp;真实姓名 &nbsp;</td>
	                        <td><input placeholder="请输入真实姓名" autocomplete="off" required lay-verify="required" type="text" value="" id="userName" name="userName" class="layui-input l_user"/></td>
	                    </tr>
	                    <tr height="50">
	                        <td align="right"><font color="#ff4e00">*</font>&nbsp;性别 &nbsp;</td>
	                        <td>
							      <input type="radio" name="sex" value="1" title="男" checked="checked">
							      <input type="radio" name="sex" value="0" title="女">
	                        </td>
	                    </tr>
	
	                    <tr height="50">
	                        <td align="right">&nbsp;身份证号 &nbsp;</td>
	                        <td><input placeholder="请输入身份证号" autocomplete="off" required lay-verify="required|identity" type="text" value="" id="identityCode" name="identityCode" class="layui-input l_user"/></td>
	                    </tr>
	                    <tr height="50">
	                        <td align="right">&nbsp;邮箱 &nbsp;</td>
	                        <td><input placeholder="请输入邮箱" autocomplete="off" required lay-verify="required|email" type="text" value="" id="email" name="email" class="layui-input l_email"/></td>
	                    </tr>
	                    <tr height="50">
	                        <td align="right">&nbsp;手机 &nbsp;</td>
	                        <td><input placeholder="请输入手机号" autocomplete="off" required lay-verify="required|phone" type="text" value="" id="mobile" name="mobile" class="layui-input l_tel"/></td>
	                    </tr>
	                    <tr height="60">
	                        <td>&nbsp;</td>
	                        <td><input type="button" lay-submit="" lay-filter="demo1" value="立即注册" class="layui-btn log_btn" /></td>
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
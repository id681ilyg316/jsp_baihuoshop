<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui/css/layui.css"  media="all">
<script src="${pageContext.request.contextPath}/statics/layui/layui.js" charset="utf-8"></script>
<title>编辑用户</title>
<script type="text/javascript">
layui.use(['form', 'layer'], function(){
	  var form = layui.form
	  ,layer = layui.layer;
	  
	//监听提交
	  form.on('submit(demo1)', function(data){
		  var password=data.field.password;
		  var repPassword=data.field.repPassword;
		  if(password!=repPassword){
			  layer.open({
				  type: 0, 
				  content: "两次密码不一致" ,//这里content是一个普通的String
				  icon :1,
				  time: 2000,
				});
			  return false;
		  }
	    $.post(contextPath+"/admin/user?action=save",{
	    	id:data.field.id,
	    	loginName:data.field.loginName,
	    	userName:data.field.userName,
	    	password:data.field.password,
	    	identityCode:data.field.identityCode,
	    	email:data.field.email,
	    	mobile:data.field.mobile,
	    	type:data.field.type,
	    	sex:data.field.sex,
	    	},
	    	function(result){
	    		var result=eval('('+result+')');
	    		if(result.success){
	    			window.location.href=contextPath+"/admin/user?action=queryUserList";
	    		}else{
	    			layer.open({
						  type: 0, 
						  content: result.error ,//这里content是一个普通的String
						  icon :1,
						  time: 2000,
						});
	    		}
	    });
	   
	  });
	  
});
</script>

</head>
<body>
	  <div class="m_right" id="content">
            <div class="mem_tit">
                                           添加用户
            </div>
            <br>
            
            <form class="layui-form" action="" id="userAdd" >
                <table class="add_tab" style="width:930px;" cellspacing="0" cellpadding="0" border="0">
                    <tbody>
                    <tr>
                        <td width="135" align="right">用户名</td>
                        <td colspan="3" style="font-family:'宋体';">
                            <input style="width: 400px;" required lay-verify="required" autocomplete="off" placeholder="请输入用户名" class="layui-input " value="${user.loginName }"  name="loginName" type="text">
                            <input value="${user.id }" name="id" type="hidden">
                        </td>
                    </tr>
                    <tr>
                        <td width="135" align="right">真实姓名</td>
                        <td>
                            <input style="width: 400px;" required lay-verify="required" autocomplete="off" placeholder="请输入真实姓名" value="${user.userName }" class="layui-input " name="userName" type="text">
                        </td>
                    </tr>
                    
                     <tr>
                         <td width="135" align="right">密码</td>
                         <td>
                             <input style="width: 400px;" required lay-verify="required" autocomplete="off" placeholder="请输入密码" value="${user.password }" class="layui-input " name="password" type="password">
                         </td>
                     </tr>
                    <%--  <c:if test="${user==null }"> --%>
	                     <tr>
	                         <td width="135" align="right">确认密码</td>
	                         <td>
	                             <input style="width: 400px;" required lay-verify="required" autocomplete="off" placeholder="请输入密码" value="${user.password }" class="layui-input " name="repPassword" type="password">
	                         </td>
	                     </tr>
                    <%--  </c:if> --%>
                    
                    <tr>
                        <td width="135" align="right">身份证号</td>
                        <td>
                            <input style="width: 400px;" required lay-verify="required|identity" placeholder="请输入身份证" value="${user.identityCode }" class="layui-input " name="identityCode" id="identityCode" type="text">
                        </td>
                    </tr>
                    <tr>
                        <td width="135" align="right">电子邮箱</td>
                        <td>
                            <input style="width: 400px;" required lay-verify="required|email" placeholder="请输入邮箱" value="${user.email }" class="layui-input " name="email" id="email" type="text">
                        </td>
                    </tr>
                    <tr>
                        <td width="135" align="right">手机</td>
                        <td>
                            <input style="width: 400px;" required lay-verify="required|phone" placeholder="请输入联系方式" value="${user.mobile }" class="layui-input " name="mobile" id="mobile" type="text">
                        </td>
                    </tr>
                    <tr>
                        <td width="135" align="right">用户类型</td>
                        <td>
                         <div class="layui-input-inline">
                            <select  name="type">
                            	<option selected="selected">请选择</option>
                                <option <c:if test="${user.type==1 }">selected</c:if> value="1">管理员</option>
                                <option <c:if test="${user.type==0 }">selected</c:if> value="0">普通用户</option>
                            </select>
                          </div>  
                        </td>
                    </tr>
                    <tr>
                        <td width="135" align="right">用户性别</td>
                        <td>
                         <div class="layui-input-inline">
                            <select  name="sex">
                            	<option  selected="selected">请选择</option>
                                <option <c:if test="${user.sex==1 }">selected</c:if>  value="1">男</option>
                                <option <c:if test="${user.sex==0 }">selected</c:if> value="0">女</option>
                            </select>
                          </div>  
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                        <c:if test="${user==null }">
                          <input value="添加用户" class="layui-btn" lay-submit="" lay-filter="demo1"  type="button">
                        </c:if>
                       	<c:if test="${user!=null }">
                          <input value="修改用户" class="layui-btn" lay-submit="" lay-filter="demo1"  type="button">
                        </c:if>
                        </td>
                    </tr>
                </tbody>
               </table>
            </form>
        </div>
</body>

</html>
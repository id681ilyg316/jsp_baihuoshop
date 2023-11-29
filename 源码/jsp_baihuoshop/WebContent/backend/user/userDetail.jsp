<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的信息</title>
</head>
<body>
	<div class="m_right" id="content">
				<div class="m_des">
					<table style="width: 870px; line-height: 22px;" cellspacing="0"
						cellpadding="0" border="0">
						<tbody>
							<tr valign="top">
								<td width="115"><img src="${pageContext.request.contextPath}/statics/images/user.jpg"
									width="90" height="90"></td>
								<td>
									<div class="m_user">${user.userName }</div>
									<br>
									<p>
										<c:if test="${user.sex==1 }">
											性别: 男<br>
										</c:if>
										<c:if test="${user.sex==2 }">
											性别: 女<br>
										</c:if>
										<br> 邮箱:${user.email }<br>
										<br> 电话:${user.mobile }<br>
										<br>
									</p>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
		</div>
</body>
</html>
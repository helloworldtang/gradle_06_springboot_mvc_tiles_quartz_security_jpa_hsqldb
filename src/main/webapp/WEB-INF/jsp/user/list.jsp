<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>添加用户</title>
</head>

<body>
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>用户名称</td>
					<td>用户密码</td>
					<td>用户角色</td>
				</tr>
			</thead>
			<c:forEach items="${listUser }" var="user">
				<tr>
					<td>${user.username }</td>
					<td>${user.password }</td>
					<td>${user.roles }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
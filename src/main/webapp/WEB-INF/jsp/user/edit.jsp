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
	<form class="form-signin" action="${ctx}/user/save" method="post">
		<c:choose>
        	<c:when test="${user.objid != null}"><h2>编辑用户信息</h2></c:when>
        	<c:otherwise><h2>添加新用户</h2></c:otherwise>
        </c:choose>
        <label>username</label>
        <input type="text" name="username" id="username">
        <br/>
        
        <label>password</label>
        <input type="password" name="password" id="password">
        <br/>
        
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit">登录</button>
    </form>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>登录</title>
</head>

<body>
<div class="container">
    <div class="warn">
    	<c:if test="${param.failure != null}">
    		<strong>用户名或密码不对！</strong>
    	</c:if>
    	<c:if test="${param.quit != null}">
    		<strong>您已退出当前系统</strong>
    	</c:if>
    	<c:if test="${param.singlePoint != null}">
    		<strong>您已在别处登陆系统</strong>
    	</c:if>
    </div>

    <form class="form-signin" action="${ctx}/login" method="post">
        <h2>请先登录</h2>
        <label>username</label>
        <input type="text" name="username" id="username">
        <br/>
        <label>password</label>
        <input type="password" name="password" id="password">
        <br/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit">登录</button>
    </form>
</div>
<!-- /container -->
</body>
</html>
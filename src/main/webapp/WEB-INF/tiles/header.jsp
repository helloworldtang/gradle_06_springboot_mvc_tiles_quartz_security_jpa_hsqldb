<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="navbar-header">
	这儿是头信息，放菜单之类的内容
	<br/>
	<div>
		<h3>
			<a href="${ctx}/user/list">用户列表</a>
			<a href="${ctx}/user/edit">用户新增</a>
			<a href="${ctx}/logout">退出</a>
		</h3>
	</div>
</div>

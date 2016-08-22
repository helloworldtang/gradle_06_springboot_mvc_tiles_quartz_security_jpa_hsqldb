<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title"/></title>
</head>
<body>
	<div class="container">
		<tiles:insertAttribute name="header"/>
	</div>
<hr>
	<div class="container">
		<tiles:insertAttribute name="content"/>
	</div>
<hr>	
	<div class="footer">
		<tiles:insertAttribute name="footer"/>
	</div>
</body>
</html>
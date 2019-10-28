<%@page import="com.mvc.hell.dto.MemberDetails"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="org.springframework.security.core.Authentication"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	Object principal = auth.getPrincipal();
    String name = "";
    if(principal != null) {
        name = auth.getName();
        
    }


	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<sec:authorize access="isAnonymous()">
	<a href='<c:url value="/loginform"/>'>LOGIN</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
	<a href="javascript:document.getElementById('logout').submit()">LOGOUT</a>
	<sec:authentication property="principal.name"/>
	
</sec:authorize>
<form id="logout" action='<c:url value="/logout"/>' method="post">
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
</form>
<h1>HELLO WORLD</h1>
<a href='<c:url value="/page"/>'>GUEST</a>
<a href='<c:url value="/member/page"/>'>MEMBER</a>
<a href='<c:url value="/admin/page"/>'>ADMIN</a>


</body>
</html>
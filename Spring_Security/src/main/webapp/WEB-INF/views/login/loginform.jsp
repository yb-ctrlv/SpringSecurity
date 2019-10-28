<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Login with Username and Password</h1>
<c:if test="${not empty param.error }">
	<h1>ERROR! 아이디와 비밀번호를 확인해주세요!</h1>
</c:if>

<form action="<c:url value="/login"/>" method="POST">

	<table>
		<tbody>
			<tr>
				<td>USER:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>PASSWORD:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="LOGIN">
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
				</td>
			</tr>
			
		</tbody>
	</table>

</form>
</body>
</html>
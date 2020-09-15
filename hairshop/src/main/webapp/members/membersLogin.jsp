<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>membersLogin.jsp</title>
</head>
<body>
<%=request.getAttribute("errormsg") %>

<form method="post" name="frm" id="frm" action="${pageContext.request.contextPath}/membersLogin.do">
	<div>
		<label for="id">ID:</label>
		<input type="text" id="id" name="id">
	</div>
	<div>
		<label for="pw">PW:</label>
		<input type="password" id="pw" name="pw">
	</div>
	<button>로그인</button>
</form>
</body>
</html>
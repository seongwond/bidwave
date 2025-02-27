<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>로그인</h2>

<% if (request.getParameter("registered") != null) { %>
<p>회원가입 성공</p>
<% } %>

<form action="/login" method="post">
    <div>
        <label for="username">Email:</label>
        <input type="email" id="username" name="username" required />
    </div>
    <div>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required />
    </div>
    <div>
        <input type="submit" value="Login" />
    </div>
</form>

</body>
</html>

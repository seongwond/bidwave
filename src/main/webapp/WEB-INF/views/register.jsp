<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<h2>회원가입</h2>
<form:form action="/register" method="post" modelAttribute="user">
    <div>
        <form:label path="email">Email:</form:label>
        <form:input path="email" required="true" />
        <form:errors path="email" />
    </div>
    <div>
        <form:label path="password">Password:</form:label>
        <form:password path="password" required="true" />
        <form:errors path="password" />
    </div>
    <div>
        <form:label path="name">Name:</form:label>
        <form:input path="name" required="true" />
        <form:errors path="name" />
    </div>
    <div>
        <form:label path="phone">Phone Number:</form:label>
        <form:input path="phone" required="true" />
        <form:errors path="phone" />
    </div>
    <div>
        <input type="submit" value="Register" />
    </div>
</form:form>
</body>
</html>

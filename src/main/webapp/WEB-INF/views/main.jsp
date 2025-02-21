<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>BidWave - 메인 페이지</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<header>
    <h1>BidWave에 오신 것을 환영합니다</h1>
    <nav>
        <a href="<c:url value='/login'/>">로그인</a>
        <a href="<c:url value='/register'/>">회원가입</a>
    </nav>
    <ul>
        <c:forEach var="item" items="${items}">
            <li>${item.name} - ${item.description}</li>
        </c:forEach>
    </ul>
</header>
<main>

</main>
<footer>
    <p>&copy; 2023 BidWave. All rights reserved.</p>
</footer>
<script src="<c:url value='/js/main.js'/>"></script>
</body>
</html>

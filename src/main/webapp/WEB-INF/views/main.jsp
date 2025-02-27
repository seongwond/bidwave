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
    <%-- 로그인 여부 확인 --%>
    <c:choose>
        <c:when test="${not empty userName}">
            <p>환영합니다, ${userName}님!</p>
            <a href="/logout">로그아웃</a>
        </c:when>
        <c:otherwise>
            <p>로그인이 필요합니다.</p>
            <a href="/login">로그인</a>
        </c:otherwise>
    </c:choose>
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

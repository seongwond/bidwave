<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/11faf2d6c3.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
</head>

<script>
    window.onload = function() {
        /*현재 페이지 주소*/
        var currentPage = "<%= request.getRequestURI() %>";

        if (currentPage.includes("/login")) { // 로그인 페이지일 때
            document.getElementById("doLogin").style.display = "none"; /*로그인 hidden*/
            document.getElementById("doRegist").style.display = "none"; /*회원가입 hidden*/
        }
        if (currentPage.includes("/register")) { // 회원가입 페이지일 때
            document.getElementById("doRegist").style.display = "none";
        }
    }
</script>

<header>
    <%--로고--%>
    <div class="logo">
        <a href="/main"> <i class="fa-solid fa-house-tsunami"></i></a>
        <a href="/main"><span>BidWave</span></a>
    </div>
    <div class="user-nav">
        <%-- 로그인 여부 확인 --%>
        <c:choose>
            <c:when test="${not empty userName}">
                <span class="user-name">환영합니다, ${userName}님!</span>
                <a href="/logout">로그아웃</a>
                <a href="/register-item" class="register-item">물품등록</a>
            </c:when>
            <c:otherwise>
                <div id="doLogin">
                    <a href="/login">로그인</a>
                </div>
                <div id="doRegist">
                    <a href="/register">회원가입</a>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</header>
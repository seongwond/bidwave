<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/views/head.jsp" />
<title>BidWave - 메인 페이지</title>
<body>
<header>
    <div class="logo">
        <i class="fa-solid fa-house-tsunami"></i>
        <span>BidWave</span>
    </div>
    <nav class="user-nav">
        <%-- 로그인 여부 확인 --%>
        <c:choose>
            <c:when test="${not empty userName}">
                <span class="user-name">환영합니다, ${userName}님!</span>
                <a href="/logout">로그아웃</a>
                <a href="/mypage">마이페이지</a>
                <a href="/register-item" class="register-item">물품등록</a>
            </c:when>
            <c:otherwise>
                <a href="/login">로그인</a>
                <a href="/register">회원가입</a>
            </c:otherwise>
        </c:choose>
    </nav>
</header>

<main>
    <!-- 메인 콘텐츠 -->
</main>
<footer>
    <jsp:include page="/WEB-INF/views/footer.jsp" /> <!--footer -->
</footer>
<script src="<c:url value='/js/main.js'/>"></script>
</body>
</html>

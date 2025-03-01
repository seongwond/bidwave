<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<jsp:include page="/WEB-INF/views/head.jsp" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css">
<title>로그인 - BidWave</title>
<body>
<header>
    <div class="logo">
        <a href="/main"> <i class="fa-solid fa-house-tsunami"></i></a>
        <a href="/main"><span>BidWave</span></a>
    </div>
</header>

<main class="login-container">
    <h2>로그인</h2>

    <% if (request.getParameter("registered") != null) { %>
    <p class="success-message">회원가입이 성공적으로 완료되었습니다!</p>
    <% } %>

    <form action="/login" method="post" class="login-form">
        <div class="form-group">
            <label for="username">아이디</label>
            <input type="email" id="username" name="username" placeholder="아이디" required />
        </div>
        <div class="form-group">
            <label for="password">비밀번호</label>
            <input type="password" id="password" name="password" placeholder="비밀번호" required />
        </div>

        <button type="submit" class="btn-login">로그인</button>
    </form>

    <div class="login-links">
        <div class="link-item">
            <i class="fa-solid fa-house-tsunami"></i>
            <p>아직 BidWave 회원이 아니신가요?</p>
            <a href="/register" class="btn-link">회원가입</a>
        </div>
        <div class="link-item">
            <i class="fa-solid fa-house-tsunami"></i>
            <p>아이디/비밀번호를 잊어버리셨나요?</p>
            <a href="/find-account" class="btn-link">아이디/비밀번호 찾기</a>
        </div>
    </div>

</main>

<footer class="footer">
    <jsp:include page="/WEB-INF/views/footer.jsp" />
</footer>

<script src="<c:url value='/js/main.js'/>"></script>
</body>
</html>

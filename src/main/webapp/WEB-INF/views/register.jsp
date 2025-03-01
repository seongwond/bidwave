<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<jsp:include page="/WEB-INF/views/head.jsp"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/register.css">
<title>회원가입 - BidWave</title>
<body>
<header>
    <div class="logo">
        <a href="/main"> <i class="fa-solid fa-house-tsunami"></i></a>
        <a href="/main"><span>BidWave</span></a>
    </div>
    <nav class="user-nav">
        <a href="/login">로그인</a>
    </nav>
</header>

<main class="register-container">
    <h2>회원가입</h2>
    <form:form method="post" action="${pageContext.request.contextPath}/register" modelAttribute="user" class="register-form">
        <div class="form-group">
        <form:label path="email">이메일:</form:label>
        <div style="flex-grow: 1; display: flex; flex-direction: column;">
            <form:input type="email" path="email" id="email" required="true" placeholder="이메일을 입력하세요"/>
            <small class="error-message" id="email-status"></small> <!-- 상태 메시지 -->
        </div>
        </div>


        <!-- 비밀번호 -->
        <div class="form-group">
            <form:label path="password">비밀번호:</form:label>
            <form:password path="password" id="password" required="true" placeholder="비밀번호를 입력하세요 (8자 이상)"/>
            <small class="error-message" id="password-error"></small>
            <form:errors path="password" cssClass="error-message"/>
        </div>


        <!-- 비밀번호 확인 추가 -->
        <div class="form-group">
            <label for="confirm-password">비밀번호 확인:</label>
            <input type="password" id="confirm-password" placeholder="비밀번호 확인">
            <small class="error-message" id="confirm-password-error"></small>
        </div>


        <!-- 이름 -->
        <div class="form-group">
            <form:label path="name">이름:</form:label>
            <form:input type="text" path="name" required="true" placeholder="이름을 입력하세요"/>
            <small class="error-message"></small>
            <form:errors path="name" cssClass="error-message"/>
        </div>

        <!-- 전화번호 -->
        <div class="form-group">
            <form:label path="phone">전화번호:</form:label>
            <form:input type="tel" path="phone" required="true" placeholder="'-' 없이 전화번호를 입력하세요"/>
            <small class="error-message"></small>
            <form:errors path="phone" cssClass="error-message"/>
        </div>

        <!-- 회원가입 버튼 -->
        <button type="submit" class="btn-register">회원가입</button>
    </form:form>
</main>

<footer class="footer">
    <jsp:include page="/WEB-INF/views/footer.jsp"/>
</footer>
<script src="${pageContext.request.contextPath}/static/js/register.js"></script>
</body>
</html>

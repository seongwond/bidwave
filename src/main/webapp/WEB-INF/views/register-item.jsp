<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/views/head.jsp" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/register-item.css">
<script src="${pageContext.request.contextPath}/static/js/register-item.js"></script>
<title>물품등록</title>
<body>
<header>
    <div class="logo">
        <a href="/main"> <i class="fa-solid fa-house-tsunami"></i></a>
        <a href="/main"><span>BidWave</span></a>
    </div>
    <nav class="user-nav">
        <%-- 로그인 여부 확인 --%>
        <c:if test="${not empty userName}">
            <span class="user-name">환영합니다, ${userName}님!</span>
            <a href="/logout">로그아웃</a>
            <a href="/mypage" class="mypage-link">마이페이지</a>
        </c:if>
    </nav>
</header>

<main class="register-item-container">
    <h2>물품등록</h2>
    <form:form method="post" modelAttribute="item" class="register-item-form">
        <div class="form-group">
            <label for="productName">상품명:</label>
            <form:input path="productName" id="productName" placeholder="상품명을 입력하세요"/>
        </div>

        <div class="form-group">
            <label for="description">상품 설명:</label>
            <textarea id="description" name="description" placeholder="상품 설명을 입력하세요"></textarea>
        </div>

        <div class="form-group">
            <label for="price">가격:</label>
            <div class="price-wrapper">
                <input type="text" id="price" name="price" value="1,000" placeholder="가격을 입력하세요"/>
                <button type="button" id="price-up">▲</button>
                <button type="button" id="price-down">▼</button>
            </div>
        </div>

        <div class="form-group">
            <label for="productImage">이미지 업로드:</label>
            <input type="file" id="productImageInput" accept="image/*"/>
            <!-- 이미지 미리보기 -->
            <img id="productImagePreview" src="#" alt="" style="display:none; width: 100%; max-width: 300px; margin-top: 10px; border-radius: 8px;"/>
        </div>

        <div class="form-group">
            <label for="endTime">경매 종료 시간:</label>
            <form:input path="endTime" id="endTime" type="datetime-local" placeholder="경매 종료 시간을 입력하세요"/>
        </div>

        <button type="submit" class="btn-submit">등록하기</button>
    </form:form>
</main>

<footer >
    <jsp:include page="/WEB-INF/views/footer.jsp" />
</footer>

</body>
</html>

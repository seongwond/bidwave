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
        <c:if test="${not empty userName}">
            <span class="user-name">환영합니다, ${userName}님!</span>
            <a href="/logout">로그아웃</a>
            <a href="/mypage" class="mypage-link">마이페이지</a>
        </c:if>
    </nav>
</header>

<main class="register-item-container">
    <h2>물품등록</h2>
    <form:form method="post" modelAttribute="item" class="register-item-form" enctype="multipart/form-data">
        <div class="form-group">
            <label for="category">카테고리 선택</label>
            <select name="category_id" id="category" required>
                <option value="">카테고리를 선택하세요</option>
                <c:forEach var="category" items="${categories}">
                    <option value="${category.categoryId}">${category.categoryName}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="productName">상품명:</label>
            <form:input path="productName" id="productName" placeholder="상품명을 입력하세요."/>
        </div>

        <div class="form-group">
            <label for="description">상품 설명:</label>
            <form:textarea path="description" id="description" placeholder="상품에 대한 설명을 입력하세요."></form:textarea>
        </div>

        <div class="form-group">
            <label for="priceStr">가격:</label>
            <label for="priceStr"></label><input type="text" id="priceStr" name="priceStr" placeholder="가격을 입력하세요" />
            <button type="button" id="price-up">▲</button>
            <button type="button" id="price-down">▼</button>
        </div>

        <!-- 이미지 미리보기 표시를 위한 img 태그 추가 -->
        <div class="form-group">
            <label for="productImageInput">상품 이미지:</label>
            <input type="file" id="productImageInput" name="productImageInput" accept="image/*"/>
            <!-- 미리보기 이미지를 표시할 img 태그 추가 -->
            <img id="productImagePreview" style="display:none; max-width: 200px; margin-top: 10px;"/>
        </div>


        <div class="form-group">
            <label for="endTime">경매 종료 시간:</label>
            <input type="datetime-local" id="endTime" name="endTimeStr"/>
        </div>

        <div class="form-group">
            <button type="submit" class="btn-submit">등록</button>
        </div>
    </form:form>
</main>

</body>
</html>

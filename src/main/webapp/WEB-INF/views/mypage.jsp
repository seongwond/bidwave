<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/views/head.jsp" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/mypage.css">
<title>마이페이지</title>
<body>
<header>
    <div class="logo">
        <a href="/main"> <i class="fa-solid fa-house-tsunami"></i></a>
        <a href="/main"><span>BidWave</span></a>
    </div>
    <nav class="user-nav">
        <%-- 로그인 여부 확인 --%>
        <c:choose>
            <c:when test="${not empty userName}">
                <span class="user-name">환영합니다, ${userName}님!</span>
                <a href="/logout">로그아웃</a>
                <a href="/register-item" class="register-item">물품등록</a>
            </c:when>
        </c:choose>
    </nav>
</header>

<main class="mypage-container">
    <h2>마이페이지</h2>
    <section class="user-info">
        <h3>개인 정보</h3>
        <p>이름: ${user.name}</p>
        <p>이메일: ${user.email}</p>
        <p>전화번호: ${user.phone}</p>
    </section>

    <section class="bid-list">
        <h3>내 입찰 목록</h3>
        <c:choose>
            <c:when test="${not empty bidList}">
                <table class="bid-table">
                    <thead>
                    <tr>
                        <th>입찰 ID</th>
                        <th>상품명</th>
                        <th>입찰 금액</th>
                        <th>입찰 시간</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="bid" items="${bidList}">
                        <tr>
                            <td>${bid.bidId}</td>
                            <td>${bid.productName}</td>
                            <td>${bid.amount}</td>
                            <td>${bid.bidTime}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p>입찰 내역이 없습니다.</p>
            </c:otherwise>
        </c:choose>
    </section>
</main>

<footer >
    <jsp:include page="/WEB-INF/views/footer.jsp" />
</footer>

</body>
</html>


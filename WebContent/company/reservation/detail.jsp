<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/images/logo.png">
    <link rel="stylesheet" href="/css/reset.css" type="text/css">
    <link rel="stylesheet" href="/css/layout.css">
    <link rel="stylesheet" href="/css/company/reservation/detail.css"  type="text/css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <title>예약 상세페이지</title>
</head>
<body>
    <header class="sec-header-page">
        <section class="header-sec pcHeader">
            <div class="header-logo">
                <h1><a class="teum-logo" href="/index">틈</a></h1>
            </div>
            <div>
                <ul class="main-menu">
                    <li class="header-search"><input type="text"><a href=""><i class="fas fa-search"></i></a></li>
                    <li><a href="/company/accommodation/reg">숙소등록</a></li>
                    <li><a href="/company/reservation/reservationInfo">예약현황</a></li>
                    <li><a href="">더보기</a></li>
                    <li class="mypage"><a href="/logout">로그아웃</a>
                        
                    </li>
                </ul>
            </div>
        </section>
    </header>

    <section class="container-sec">
        <div class="container">
            <aside id="aside" class="aside">
                <!-- <h1>게시판</h1> -->
                <ul style="width:230px;">
                    <li><a href="/company/userInfo/memberInfo"><i class="fas fa-exclamation-circle"></i>&nbsp;&nbsp;회원정보수정</a></li>
                    <li class="active"><a href="/company/reservation/reservationInfo"><i class="far fa-calendar-check"></i>&nbsp;&nbsp;예약관리</a></li>
                    <li><a href="/company/reverseOffer/reg"><i class="far fa-question-circle"></i>&nbsp;&nbsp;제안신청관리</a></li>
                    <li><a href="/company/reverseOffer/detail"><i class="far fa-question-circle"></i>&nbsp;&nbsp;역제안신청관리</a></li>
                    <li><a href="/company/accommodation/list"><i class="far fa-question-circle"></i>&nbsp;&nbsp;숙소현황</a></li>
                    <li><a href="/company/accommodation/reg"><i class="far fa-question-circle"></i>&nbsp;&nbsp;숙소등록</a></li>
                    <li><a href="/company/goldenTime/list"><i class="far fa-question-circle"></i>&nbsp;&nbsp;골든타임관리</a></li>
                </ul>
            </aside>
            <main id="main" class="main" style="min-height:600px;">
                <div class="breadcrumb">
                    <ul class="breadcrumb-list">
                        <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i> </li>
                        <li>&nbsp;&nbsp;&nbsp;마이페이지&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i> </li>
                        <li>&nbsp;&nbsp;&nbsp;예약관리</li>
                    </ul>
                </div>
                <section class="reservation-detail-sec">
                    <h1>예약 상세</h1>
                    <h2>${rd.accName }
                    
                    <c:if test="${rd.cancelStatus == 0 }">
               			<c:set var="now" value="<%=new java.util.Date()%>" />
               			<c:choose>
               				<c:when test="${rd.checkinDate  >= now}">
               					<span>이용예정</span>
               				</c:when>
               				<c:otherwise>
               					<span>이용완료</span>
               				</c:otherwise>
               			</c:choose>
               		</c:if>
               		<c:if test="${rd.cancelStatus == 1 }">
               			<span>취소</span>
               		</c:if>
                    </h2>
                    <section class="reservation-detail">
                        <div class="room">
                            <span class="left">예약한 룸</span><span class="right">${rd.roomName }</span>
                        </div>
                        <div class="checkin">
                            <span class="left">체크인</span><span class="right">${rd.checkinDate }</span>
                        </div>
                        <div class="checkout">
                            <span class="left">체크인</span><span class="right">${rd.checkoutDate }</span>
                        </div>
                        <div class="name">
                            <span class="left">예약자</span><span class="right">${rd.userName }</span>
                        </div>
                        <div class="phone">
                            <span class="left">휴대폰 번호</span><span class="right">${rd.phone }</span>
                        </div>
                        <div class="empty-line"></div>
                        <div class="price">
                            <span class="left">총 결제금액</span><span class="right highlight"><fmt:formatNumber value="${rd.price }" pattern="#,###" />원</span>
                        </div>
                        <div class="empty-line"></div>
                    </section>
                </section>
            </main>
        </div>
    </section>

    <section>
        <footer id="footer" class="footer">
            <div>
                <ul>
                    <li>
                        <a href="">회사소개</a>
                        <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
                    </li>
                    <li>
                        <a href="">이용약관</a>
                        <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
                    </li>
                    <li>
                        <a href="">개인정보처리방침</a>
                        <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
                    </li>
                    <li>
                        <a href="">사업자정보확인</a>
                        <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
                    </li>
                    <li>
                        <a href="">틈 마케팅센터</a>
                        <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
                    </li>
                    <li>
                        <a href="">액티비티 호스트센터</a>
                        <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
                    </li>
                    <li><a href="">콘텐츠산업진흥법에의한 표시</a></li>
                </ul>

                <p><b>고객행복센터 1577-8282</b> 오전 09:00 ~ 오후18:00</p>

                <address>
                    <span>(주)TEUM</span>
                    주소 : 서울특별시 종로구 인사동길 12 대일빌딩 15층
                    <br />대표이사 : 신중언 | 사업자등록번호 777-11-45678 <br />통신판매번호 : 2020-서울강남-12345 | 관광사업자 등록번호 : 제
                    1324-55호 <br />전화번호 : 010-1111-2222 <br />전자우편주소 : teum@teum.co.kr <br />Copyright TEUM COMPANY Corp. All rights
                    reserved.
                </address>
            </div>
        </footer>
    </section>
</body>
</html>
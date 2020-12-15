<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/images/logo.png">
    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/layout.css">
    <link rel="stylesheet" href="/css/event/list.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <title>TEUM | 틈을 채우다</title>
</head>
<body>
    <header class="sec-header-page">
        <section class="header-sec pcHeader">
            <div class="header-logo">
                <h1><a class="teum-logo" href="http://127.0.0.1:5500/main.html">틈</a></h1>
            </div>
            <div>
                <ul class="main-menu">
                    <li class="header-search"><input type="text"><a href=""><i class="fas fa-search"></i></a></li>
                    <li><a href="">제안하기</a></li>
                    <li><a href="">예약내역</a></li>
                    <li class="sub-page">
                        <a href="">더보기</a>
                        <div class="mega-menu">
                            <ul>
                                <li><a href="">공지사항</a></li>
                                <li><a href="">이벤트</a></li>
                                <li><a href="">1:1 문의</a></li>
                            </ul>
                        </div>
                    </li>
                    <li class="sub-page">
                        <a href="" class="character"><i class="fas fa-sort-down"></i></a>
                        <div class="mega-menu">
                            <ul>
                                <li><a href="">내정보</a></li>
                                <li><a href="">제안내역</a></li>
                                <li><a href="">찜한 숙소</a></li>
                                <li><a href="">로그아웃</a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </section>
    </header>
    
    <section class="container-sec">
        <div class="container">
            <aside id="aside" class="aside">
                <!-- <h1>게시판</h1> -->
                <ul>
                    <li><a href=""><i class="fas fa-exclamation-circle"></i>&nbsp;&nbsp;&nbsp;&nbsp;공지사항</a></li>
                    <li class="active"><a href=""><i class="far fa-calendar-check"></i>&nbsp;&nbsp;&nbsp;&nbsp;이벤트</a></li>
                    <li><a href=""><i class="far fa-question-circle"></i>&nbsp;&nbsp;&nbsp;&nbsp;Q&A</a></li>
                </ul>
            </aside>
            <main id="main" class="main">
                <div class="breadcrumb">
                    <ul class="breadcrumb-list">
                        <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i> </li>
                        <li>&nbsp;&nbsp;&nbsp;이벤트</li>
                    </ul>
                </div>
                <section class="event-sec">
                    <h1>이벤트 / <span>Event</span></h1>
                    <ul class="event-list">
                        <li class="current-tab"><a href="">진행중인 이벤트</a></li>
                        <li><a href="">종료된 이벤트</a></li>
                    </ul>
                    <c:forEach var="event" items="${list}">
                    	<c:if test="${event.openStatus == 1}">
	                    	<div class="event-img-container">
		                        <h1>${event.title}</h1>
		                        <h2>${event.regdate} ~ ${event.endDate}</h2>
		                        <div class="scale">
		                            <a href="detail?id=${event.id}">
			                            <c:forTokens var="imageName" items="${event.imageName}" delims="," varStatus="st">
			                        		<c:if test="${st.first == true}">
			                        			<img src="/images/event/2020/${event.id}/${imageName}">
			                        		</c:if>
			                        	</c:forTokens>
		                            </a>
		                        </div>
		                    </div>
                    	</c:if>
                    </c:forEach>
                    <!-- <div class="event-img-container">
                        <h1>세스코 인증 청결 숙소 이벤트에 참여해 보세요!</h1>
                        <h2>2020.01.01 ~ 2020.12.31</h2>
                        <div class="scale">
                            <a href=""><img src="/images/event/event1.png" alt=""></a>
                        </div>
                    </div>
                    <div class="event-img-container">
                        <h1>더블 혜택 할인받고 예약하세요!</h1>
                        <h2>2020.01.01 ~ 2020.12.31</h2>
                        <div class="scale">
                            <a href=""><img src="/images/event/event2.png" alt=""></a>
                        </div>
                    </div>
                    <div class="event-img-container">
                        <h1>안전여행 떠나고 10만원 상품권 획득기회!</h1>
                        <h2>2020.01.01 ~ 2020.12.31</h2>
                        <div class="scale">
                            <a href=""><img src="/images/event/event3.png" alt=""></a>
                        </div>
                    </div> -->
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
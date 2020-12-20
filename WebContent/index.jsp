<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/images/logo.png">
    <link rel="stylesheet" href="/css/reset.css" type="text/css">
    <link rel="stylesheet" href="/css/layout.css">
    <link rel="stylesheet" href="/css/main.css">
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
                    <li class="header-search"><input type="text" placeholder="숙소명 또는 위치">
                        <a href=""><i class="fas fa-search"></i></a>
                    </li>
                    <li>
                    	<c:if test="${type == 0 }">
                    		<a href="/user/offer/reg">제안하기</a>
                        </c:if>
                        <c:if test="${type == 1 }">
                    		<a href="/company/accommodation/reg">숙소등록</a>
                        </c:if>
                    </li>
                    <li>
                    	<c:if test="${type == 0 }">
                    		<a href="">예약내역</a>
                        </c:if>
                        <c:if test="${type == 1 }">
                    		<a href="">예약현황</a>
                        </c:if>
                    </li>
                    <li class="sub-page">
                        <a href="">더보기</a>
                        <div class="mega-menu">
                            <ul>
                                <li><a href="/notice/list">공지사항</a></li>
                                <li><a href="/event/list">이벤트</a></li>
                                <c:if test="${type == 0 }">
                                	<li><a href="">1:1 문의</a></li>
                        		</c:if>
                                
                            </ul>
                        </div>
                    </li>
                    <li class="sub-page">
                    	<c:if test="${empty email }">
                        	<a href="signin" class="character">로그인</a>
                        </c:if>
                        <c:if test="${email ne null}">
                        	<a href="" style="pointer-events:none;" class="character"><i class="fas fa-sort-down"></i></a>
                        </c:if>
                        
                        <c:if test="${type == 0 || type == 1 }">
	                        <div class="mega-menu">
	                            <ul>
	                                <c:if test="${type == 0 }">
			                    		 <li><a href="/user/userInfo/memberInfo">내정보</a></li>
			                        </c:if>
			                        <c:if test="${type == 1 }">
			                    		 <li><a href="/company/userInfo/memberInfo">내정보</a></li>
			                        </c:if>
			                        <c:if test="${type == 0 }">
			                    		 <li><a href="/user/userInfo/offerList">제안내역</a></li>
			                        </c:if>
			                        <c:if test="${type == 1 }">
			                    		 <li><a href="/company/reverseOffer/reg">제안내역</a></li>
			                        </c:if>
	                                <c:if test="${type == 0 }">
			                    		 <li><a href="/user/userInfo/pickList">찜한숙소</a></li>
			                        </c:if>
			                        <c:if test="${type == 1 }">
			                    		 <li><a href="/company/goldenTime/list">골든타임</a></li>
			                        </c:if>
	                                <li><a href="logout">로그아웃</a></li>
	                            </ul>
	                        </div>
                        </c:if>
                    </li>
                </ul>
            </div>
        </section>
    </header>

    <section id="sec-promotion-page" class="sec-promotion-page scrolling">
        <section class="promotion-sec">
            <div class="promotion-bar">
                <div>
                    <h1 style="font-size: 24px; color: #f3e62f;"><i class="fas fa-hourglass-half"></i> <i class="fas fa-stopwatch"></i> <span style="color: #f3e62f;">골든타임(아이콘 원하는거 쓰세요)</span></h1>
                </div>
                <div>
                    <div class="btn-left"><i style="font-size: 40px; color: #5f0081;" class="fas fa-arrow-circle-left"></i></div>
                    <div style="width: 918px; overflow:hidden;">
                        <div class="promotion-item-container" style="display: flex;">

                            <div class="promotion-item">
                                <div class="parent">
                                    <img src="images/company/호텔/리스트/신라스테이_삼성_메인.jpg" alt="">
        
                                    <div class="child"><span>00:00:00</span></div>
                                </div>
                                <div class="promotion-item-detail">
                                    <h2>강남 파르페 호텔</h2>
                                    <h4>128,000원</h4>
                                    <h3>42,000원</h3>
                                    <h5>서울시 강남구</h5>
                                </div>
                                <div>
                                    <h2>추천상품1</h2>
                                </div>
                            </div>
                            <div class="promotion-item">
                                <div class="parent">
                                    <img src="images/company/호텔/리스트/신라스테이_삼성_메인.jpg" alt="">
        
                                    <div class="child"><span>00:00:00</span></div>
                                </div>
                                <div class="promotion-item-detail">
                                    <h2>강남 파르페 호텔</h2>
                                    <h4>128,000원</h4>
                                    <h3>42,000원</h3>
                                    <h5>서울시 강남구</h5>
                                </div>
                                <div>
                                    <h2>추천상품2</h2>
                                </div>
                            </div>
                            <div class="promotion-item">
                                <div>
                                    <img src="images/company/호텔/리스트/신라스테이_삼성_메인.jpg" alt="">
                                </div>
                                <div class="promotion-item-detail">
                                    <h2>강남 파르페 호텔</h2>
                                    <h4>128,000원</h4>
                                    <h3>42,000원</h3>
                                    <h5>서울시 강남구</h5>
                                </div>
                                <div>
                                    <h2>추천상품3</h2>
                                </div>
                            </div>
                            <div class="promotion-item">
                                <div>
                                    <img src="images/company/호텔/리스트/신라스테이_삼성_메인.jpg" alt="">
                                </div>
                                <div class="promotion-item-detail">
                                    <h2>강남 파르페 호텔</h2>
                                    <h4>128,000원</h4>
                                    <h3>42,000원</h3>
                                    <h5>서울시 강남구</h5>
                                </div>
                                <div>
                                    <h2>추천상품4</h2>
                                </div>
                            </div>
                            <div class="promotion-item">
                                <div class="parent">
                                    <img src="images/company/호텔/리스트/신라스테이_삼성_메인.jpg" alt="">
        
                                    <div class="child"><span>00:00:00</span></div>
                                </div>
                                <div class="promotion-item-detail">
                                    <h2>강남 파르페 호텔</h2>
                                    <h4>128,000원</h4>
                                    <h3>42,000원</h3>
                                    <h5>서울시 강남구</h5>
                                </div>
                                <div>
                                    <h2>추천상품5</h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="btn-right"><i style="font-size: 40px; color: #5f0081;" class="fas fa-arrow-circle-right"></i></div>
                </div>
            </div>
        </section>

        <section class="category-sec">
                <div class="category-bar">
                    <ul>
                        <li>
                            <a class="category-img" href="/accommodation/list?type=1">
                                <img src="images/main/hotel-icon.png" alt="">
                                <span>호텔</span>
                            </a>
                        </li>
                        <li>
                            <a class="category-img" href="/accommodation/list?type=2">
                                <img src="images/main/motel-icon.png" alt="">
                                <span>모텔</span>
                            </a>
                        </li>
                        <li>
                            <a class="category-img" href="/accommodation/list?type=3">
                                <img src="images/main/guesthouse-icon.png" alt="">
                                <span>게스트하우스</span>
                            </a>
                        </li>
                        <li>
                            <a class="category-img" href="/accommodation/list?type=4">
                                <img src="images/main/resort-icon.png" alt="">
                                <span>리조트</span>
                            </a>
                        </li>
                        <li>
                            <a class="category-img" href="/accommodation/list?type=5">
                                <img src="images/main/pension-icon.png" alt="">
                                <span>펜션</span>
                            </a>
                        </li>
                    </ul>
                </div>
        </section>
    </section>

    <section id="sec-offer-page" class ="sec-offer-page scrolling">
        <div class="offer-katalk">
            <img src="/images/main/kaTalk.jpg">
        </div>
        <div class="offer-box">
            <div class="offer-ment">
                <p class="ment">일상속 작은 <span class="teum">틈,</span></p>
                <p class="ment"><span class="teum">틈</span>을 채우기 위한 여행.</p>
            </div>
            <div class="btn-container">
                <button class="btn-list" onclick="location.href='list'">제안하기</button>
            </div>
        </div>
    </section>
    
    <section id="sec-event-page" class="sec-event-page scrolling">
        <section class="event-sec">
            <div class="event-container">
                <h1>진행중인 이벤트</h1>
                <div class="cliper-btn prev-btn">
                    <i class="fas fa-angle-left"></i>
                </div>
                <div class="cliper-btn next-btn">
                    <i class="fas fa-angle-right"></i>
                </div>
                <div class="event-list-container">
                    <ul class="event-list">
                    	<c:if test="${count < 3}">
	                    	<c:forEach var="event" begin="0" end="${count}" items="${eventList}">
	                    		<c:forTokens var="imageName" items="${event.imageName}" delims="," varStatus="st">
		                    		<c:if test="${st.first == true}">
		                    			<li><a href="/event/detail?id=${event.id}"><img src="/images/event/2020/${event.id}/${imageName}"></a></li>
		                    		</c:if>
	                    		</c:forTokens>
	                    	</c:forEach>
                    	</c:if>
                    	<c:if test="${count >= 3}">
                    		<c:forEach var="event" begin="0" end="3" items="${eventList}">
                    			<c:forTokens var="imageName" items="${event.imageName}" delims="," varStatus="st">
	                    			<c:if test="${st.first == true}">
	                    				<li><a href="/event/detail?id=${event.id}"><img src="/images/event/2020/${event.id}/${imageName}"></a></li>                    			
	                    			</c:if>
                    			</c:forTokens>
                    		</c:forEach>
                    	</c:if>
                    </ul>
                </div>
                <div class="etc-container">
                    <div class="etc-img-container">
                        <a href=""><img src="/images/event/etc1.jpg" alt=""></a>
                    </div>
                    <div class="etc-img-container">
                        <a href=""><img src="/images/event/etc2.jpg" alt=""></a>
                    </div>
                </div>
            </div>
            <div class="weather-container">
                <h1>날씨</h1>
                <div class="weather-list-container">
                    <img src="/images/event/weather.jpg" alt="">
                </div>
            </div>
        </section>
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

    <script src="/js/index.js"></script>
</body>
</html>
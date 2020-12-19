<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/images/logo.png">
    <link rel="stylesheet" href="/css/reset.css" type="text/css">
    <link rel="stylesheet" href="/css/layout.css">
    <link rel="stylesheet" href="/css/company/reverseOffer/reg.css"  type="text/css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <script src="/js/company/reverseOffer/reg.js"></script>
    <title>TEUM | 틈을 채우다</title>
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
                    <li><a href="/user/offer/reg">제안하기</a></li>
                    <li><a href="">예약내역</a></li>
                    <li class="sub-page">
                        <a href="">더보기</a>
                        <div class="mega-menu">
                            <ul>
                                <li><a href="/notice/list">공지사항</a></li>
                                <li><a href="/event/list">이벤트</a></li>
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
                                <li><a href="/logout">로그아웃</a></li>
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
                <ul>
                    <li><a href=""><i class="far fa-calendar-check"></i>&nbsp;&nbsp;&nbsp;&nbsp;메뉴1</a></li>
                    <li class="active"><a><i class="far fa-calendar-check"></i>&nbsp;&nbsp;&nbsp;&nbsp;메뉴2</a></li>
                    <li><a href=""><i class="far fa-calendar-check"></i>&nbsp;&nbsp;&nbsp;&nbsp;메뉴3</a></li>
                </ul>
            </aside>
            <main id="main" class="main">
                <div class="breadcrumb">
                    <ul class="breadcrumb-list">
                        <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
                        <li>&nbsp;&nbsp;&nbsp;???&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
                        <li>&nbsp;&nbsp;&nbsp;???&nbsp;&nbsp;&nbsp;</li>
                    </ul>
                </div>
                <div>
                    <div class="btn-left" style="align-self: center;"><i style="font-size: 50px; color: gray; opacity: 0.5;" class="fas fa-angle-left"></i></div>
                    <div style="width: 700px; overflow:hidden;">
                        <div class="proposal-item-container" style="display: flex;">
                        	<c:forEach var="offer" items="${offerList}" varStatus="status">
                        	<div class="proposal-info ${(status.index == 0) ? 'picked' : ''}" onclick="location.href=''">
                                <h2>제안정보</h2>
                                <ul>
                                    <li>
                                        <div>날짜</div>
                                        <div>${offer.checkinDate} ~ ${offer.checkoutDate}</div>
                                    </li>
                                    <li>
                                        <div>위치</div>
                                        <div>${offer.location}</div>
                                    </li>
                                    <li>
                                        <div>인원수</div>
                                        <div>${offer.headcount}</div>
                                    </li>
                                    <li>
                                        <div>희망하는 가격</div>
                                        <div class="wanted-price">
                                        	<fmt:formatNumber value="${offer.price}" pattern="#,###" />원
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        	</c:forEach>
                        </div>
                    </div>
                    <div class="btn-right" style="align-self: center;"><i style="font-size: 50px; color: gray; opacity: 0.5;" class="fas fa-angle-right"></i></div>
                </div>
                <section class="offer-sec">
                    <h1>역제안이 가능한 방 목록</h1>
                    <form action="reg" method="post" class="offer-form">
                    	<c:forEach var="room" items="${showRoomList}" varStatus="status">
                        <section>
                            <div class="radio-container">
                                <input type="radio" name="room-id" value="${room.id}" id="radio-${status.index}" class="radio" required>
                                <label for="radio-${status.index}"><span></span></label>
                            </div>
                            <div class="offer-container">
                                <div class="offer-img-container">
                                    <a href=""><img src="" alt=""></a>
                                </div>
                                <div class="offer-detail-container">
                                    <div class="offer-room">
                                        <span>${room.name}</span>
                                    </div>
                                    <div class="offer-bed-count">
                                        <div>침대개수</div>
                                        <div>${room.bedCount}</div>
                                    </div>
                                    <div class="offer-max-headcount">
                                        <div>최대 수용인원</div>
                                        <div>${room.maxHeadcount}</div>
                                    </div>
                                    <div class="offer-price">
                                        <div>가격</div>
                                        <div>
                                        	<fmt:formatNumber value="${room.price}" pattern="#,###" />원
                                        </div>
                                    </div>
                                    <div class="highlight-btn-container">
                                        <input type="button" class="highlight-btn" value="예약이 가능한 방입니다">
                                    </div>
                                </div>
                            </div>
                        </section>
                    	</c:forEach>
                        <div class="submit-btn-container">
                            <input type="submit" class="submit-btn" value="역제안하기">
                        </div>
                    </form>
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
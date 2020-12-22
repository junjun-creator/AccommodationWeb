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
    <link rel="stylesheet" href="/css/user/reservation/pay.css"  type="text/css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <script src="/js/user/reservation/pay.js"></script>
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
            <main id="main" class="main">
                <div class="breadcrumb">
                    <ul class="breadcrumb-list">
                        <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
                        <li>&nbsp;&nbsp;&nbsp;예약하기&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
                        <li>&nbsp;&nbsp;&nbsp;결제하기&nbsp;&nbsp;&nbsp;</li>
                    </ul>
                </div>
                <form action="pay" method="post" class="reservation-form">
                    <section class="reservation-form-left">
                        <h1>예약자 정보</h1>
                        <div>예약자 이름</div>
                        <input type="text" class="name-input" value="${u.name }" disabled required autofocus autocomplete="off">
                        <div>휴대폰 번호</div>
                        <input type="text" class="phone-input" disabled value="${u.phone }" required autocomplete="off" pattern="^01[012678]-\d{3,4}-\d{4}$">
                        <div>결제수단 선택</div>
                        <select>
                            <option value="">신용 카드</option>
                            <option value="">체크 카드</option>
                        </select>
                        <div class="accept-container">
                            <div class="accept-all checkbox-container">
                                <input type="checkbox" class="checkbox checkbox-all">
                                &nbsp;&nbsp;&nbsp;<span>전체 동의</span>
                            </div>
                            <div class="checkbox-container">
                                <input type="checkbox" class="checkbox checkbox-single" required>
                                &nbsp;&nbsp;&nbsp;<u>숙소이용규칙 및 취소/환불규정 동의 </u><span class="highlight">(필수)</span>
                            </div>
                            <div class="checkbox-container">
                                <input type="checkbox" class="checkbox checkbox-single" required>
                                &nbsp;&nbsp;&nbsp;<u>개인정보 수집 및 이용 동의</u><span class="highlight">(필수)</span>
                            </div>
                            <div class="checkbox-container">
                                <input type="checkbox" class="checkbox checkbox-single" required>
                                &nbsp;&nbsp;&nbsp;<u>개인정보 제 3자 제공 동의</u><span class="highlight">(필수)</span>
                            </div>
                        </div>
                    </section>
                    <section class="reservation-form-right">
                        <div class="acc-info">숙소이름</div>
                        <div>
                            <span>${payInfo.accName}</span>
                        </div>
                        <div class="acc-info">객실타입/기간</div>
                        <div>
                            <span>${payInfo.name}</span>
                        </div>
                        <div class="acc-info">체크인</div>
                        <div>
                            <span>${checkinDate} 15:30</span>
                        </div>
                        <div class="acc-info">체크아웃</div>
                        <div>
                            <span>${checkoutDate} 12:00</span>
                        </div>
                        <div class="boundary"></div>
                        <div>총 결제금액(VAT 포함)</div>
                        <div class="price">
                        	<fmt:formatNumber value="${payInfo.price}" pattern="#,###" />원
                        </div>
                        <div class="guide-ment">* 해당 가격은 역제안 가격으로 인해 <span class="highlight">취소시 환불이 불가능</span>합니다.</div>
                        <div class="guide-ment">* 결제완료 후 <span class="highlight">예약자 이름</span>으로 바로 체크인 하시면 됩니다.</div>
                        <div class="submit-btn-container">
	                        <input type="hidden" name="checkinDate" value="${checkinDate}">
	                        <input type="hidden" name="checkoutDate" value="${checkoutDate}">
	                        <input type="hidden" name="accId" value="${param.accId}">
	                        <input type="hidden" name="roomId" value="${param.roomId}">
	                        <input type="hidden" name="price" value="${(empty param.price)?payInfo.price:param.price}">
	                        <input type="hidden" name="headcount" value="${(empty param.headcount)?0:param.headcount}">
                            <input type="submit" class="submit-btn" value="결제하기">
                        </div>
                    </section>
                </form>
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
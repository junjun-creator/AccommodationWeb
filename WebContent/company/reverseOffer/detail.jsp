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
    <link rel="stylesheet" href="/css/company/reverseOffer/detail.css"  type="text/css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <script src="/js/company/reverseOffer/detail.js"></script>
    <title>TEUM | 틈을 채우다</title>
</head>
<body>
    <jsp:include page="/inc/header.jsp"/>

    <section class="container-sec">
        <div class="container">
            <aside id="aside" class="aside">
                <!-- <h1>게시판</h1> -->
                <ul style="width:230px;">
                    <li><a href="/company/userInfo/memberInfo"><i class="far fa-user-circle"></i>&nbsp;&nbsp;회원정보수정</a></li>
                    <li><a href="/company/reservation/reservationInfo"><i class="far fa-calendar-check"></i>&nbsp;&nbsp;예약관리</a></li>
                    <li><a href="/company/reverseOffer/reg"><i class="fas fa-file-upload"></i>&nbsp;&nbsp;제안신청관리</a></li>
                    <li class="active"><a href="/company/reverseOffer/detail"><i class="fas fa-file-download"></i>&nbsp;&nbsp;역제안신청관리</a></li>
                    <li><a href="/company/accommodation/list"><i class="fas fa-map-marked-alt"></i>&nbsp;&nbsp;숙소현황</a></li>
                    <li><a href="/company/accommodation/reg"><i class="fas fa-sign-in-alt"></i>&nbsp;&nbsp;숙소등록</a></li>
                    <li><a href="/company/goldenTime/list"><i class="fas fa-hourglass-start"></i>&nbsp;&nbsp;골든타임관리</a></li>
                </ul>
            </aside>
            <main id="main" class="main" style="min-height:600px;">
                <div class="breadcrumb">
                    <ul class="breadcrumb-list">
                        <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
                        <li>&nbsp;&nbsp;&nbsp;???&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
                        <li>&nbsp;&nbsp;&nbsp;???&nbsp;&nbsp;&nbsp;</li>
                    </ul>
                </div>
                <div>
                	<c:if test="${empty roomList}">
              			제안목록에 불러올게 없어!!
               		</c:if>
               		<c:if test="${not empty offerList}">
	                    <div class="btn-left" style="align-self: center;"><i style="font-size: 50px; color: gray; opacity: 0.5;" class="fas fa-angle-left"></i></div>
	                    <div style="width: 700px; overflow:hidden;">
	                        <div class="proposal-item-container" style="display: flex;">
									<c:forEach var="offer" items="${offerList}">
									<div class="proposal-info">
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
                	</c:if>
                </div>
                <section class="offer-sec">
                    <h1>고객에게 역제안을 보낸 룸 목록</h1>
                    <form class="offer-form">
                    	<c:if test="${empty roomList}">
                    		역제안을 보낸 룸 목록이 없다능
                    	</c:if>
                    
                    	<c:if test="${not empty roomList}">
							<c:forEach var="room" items="${roomList}">
							<section>
	                            <div class="offer-container">
	                                <div class="offer-img-container">
	                                    <a href="">
	                                    	<c:forTokens var="fileRoute" items="${room.fileroute}" delims="," varStatus="st">
					                        	<c:if test="${st.first == true}">
						                        	<img src="${fileRoute}" alt="">
					                        	</c:if>
			                        		</c:forTokens>
	                                    </a>
	                                </div>
	                                <div class="offer-detail-container">
	                                    <div class="offer-room">
	                                        <span>${room.roomName}</span>
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
	                                        	<fmt:formatNumber value="${room.roomPrice}" pattern="#,###" />원
	                                        </div>
	                                        <div>
	                                        	<fmt:formatNumber value="${offerList[0].price}" pattern="#,###" />원
	                                        </div>
	                                    </div>
	                                    <div class="highlight-btn-container">
	                                        <input type="button" class="highlight-btn" value="아직 상대방이 결제를 하지 않았습니다.">
	                                    </div>
	                                </div>
	                            </div>
	                        </section>
							</c:forEach>
                    	</c:if>
                        
                        <div class="back-btn-container">
                            <a href="/index" class="back-btn">돌아가기</a>
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
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
    <title>신라스테이 삼성</title>
    <link rel="icon" href="/images/logo.png">
    <link rel="stylesheet" href="/css/reset.css" type="text/css">
    <link rel="stylesheet" href="/css/layout.css">
    <link href="/css/accommodationList/detail.css"  rel="stylesheet">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <script src="/js/accommodationLists/detail.js"></script>
</head>

<body>
    <jsp:include page="/inc/header.jsp"/>
    

    <section class="main-container">
        <div class="main">
            <section class="title">
                <div class="pic">
                    <div class="main-img">
	                    <c:forTokens var="fileRoute" items="${accImage.fileroute}" delims="," varStatus="st">
                        	<c:if test="${st.first == true}">
	                        	<img src="${fileRoute}" alt=""><br>
                        	</c:if>
                       	</c:forTokens>
                    </div>
                    <!-- <div class="cliper-btn prev-btn">
                        <i class="fas fa-angle-left"></i>
                    </div>
                    <div class="cliper-btn next-btn">
                        <i class="fas fa-angle-right"></i>
                    </div> -->
                    <div class="cliper">
                        <ul>
	                        <li><img src="/images/company/호텔/서울/강남,역삼,삼성/신라스테이_삼성/스탠다드_더블/1.jpg"></li>
	                        <li><img src="/images/company/호텔/서울/강남,역삼,삼성/신라스테이_삼성/스탠다드_트윈/2.jpg"></li>
	                        <li><img src="/images/company/호텔/서울/강남,역삼,삼성/라마다호텔/슈페리얼더블/1.jpg"></li> 
	                        <li><img src="/images/company/호텔/서울/강남,역삼,삼성/라마다호텔/슈페리얼트윈/2.jpg"></li>
	                        <li><img src="/images/company/호텔/서울/강남,역삼,삼성/머큐어_앰배서더_강남_쏘도베/디럭스 더블/1.jpg"></li>
                        </ul>
                    </div>
                </div>
                <div class="main-info">
                    <h1>${acc.name}</h1>
                    <h2>${acc.location}</h2>
                    <div class="rule">
                        <p>취소 및 환불 규정</p>
                        <ul>
                            <li> <i class="far fa-check-square"></i> 체크인일 기준 1일전 18시까지 : 100% 환불</li>
                            <li> <i class="far fa-check-square"></i> 체크인일 기준 1일전 18시이후~당일 : 환불불가</li>
                            <li> <i class="far fa-check-square"></i> 취소, 환불시 수수료가 발생할 수 있습니다</li>
                        </ul>
                    </div>
                    <div class="check">
                        <p>확인사항 및 기타</p>
                        <ul>
                            <li> <i class="far fa-check-square"></i> 거리두기 단계 상향에 따라 일부 시설 이용이 제한될 수 있습니다</li>
                            <li> <i class="far fa-check-square"></i> 최대인원 초과시 입실 불가합니다</li>
                            <li> <i class="far fa-check-square"></i> 위의 정보는 호텔의 사정에 따라 변경될 수 있습니다</li>
                            <li> <i class="far fa-check-square"></i> 해당 이미지는 실제와 상이 할 수 있습니다</li>
                            <li> <i class="far fa-check-square"></i> 체크인 시 배정 또는 베드타입 미기재 상품은 특정객실과 베드타입을 보장하지 않습니다</li>
                            <li> <i class="far fa-check-square"></i> 해당 객실가는 세금, 봉사료가 포함된 금액입니다</li>
                            <li> <i class="far fa-check-square"></i> 미성년자는 보호자 동반없이 이용하실 수 없습니다</li>
                        </ul>
                    </div>
                </div>
            </section>

            <div class="empty-line"></div>
    
            <section class="room-sec">
                <div class="subtitle">
                    <h1>객실 안내 및 예약</h1>
                    <form action="detail" method="get">
                        <input type="hidden" name="accId" value=${acc.id}>
                        체크인 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="date" class="form-option date checkin-date" name="checkinDate" value="${empty param ? '' : param.checkinDate }" required><br>
                        체크아웃 &nbsp;&nbsp;&nbsp; <input type="date" class="form-option date checkout-date" name="checkoutDate" value="${empty param ? '' : param.checkoutDate }" required><br>
                        <input type="submit" class="submit-btn" value="적용하기">
                    </form>
                </div>
                <form class="room-form">
                	<c:if test="${empty showRoomList && empty roomList}">
	               		<section class="cry-img-section">
	                        <div>
	                            <div class="cry-img-container">
	                                <img class="cry-img" src="/images/cry.png" alt="">
	                            </div>
	                            <div class="cry-ment-container">
	                                <div class="cry-ment">예약 가능한 방이 없습니다.</div>
	                                <div class="cry-ment">다른 날짜를 검색해 주세요.</div>
	                            </div>
	                        </div>
	                   	</section>
                	</c:if>
                	<c:if test="${empty showRoomList}">
	                	<c:forEach var="room" items="${roomList}" varStatus="st">
	                    <section>
	                        <div class="room-container">
	                            <div class="room-img-container">
	                                <c:forTokens var="fileRoute" items="${room.fileroute}" delims="," varStatus="st">
			                        	<c:if test="${st.first == true}">
				                        	<img src="${fileRoute}" alt=""><br>
			                        	</c:if>
			                       	</c:forTokens>
	                            </div>
	                            <div class="room-detail-container">
	                                <div class="room-room">
	                                    <span>${room.name}</span>
	                                </div>
	                                <div class="room-bed-count">
	                                    <div>침대개수</div>
	                                    <div>${room.bedCount}</div>
	                                </div>
	                                <div class="room-max-headcount">
	                                    <div>최대 수용인원</div>
	                                    <div>${room.maxHeadcount}</div>
	                                </div>
	                                <div class="room-price">
	                                    <div>가격</div>
	                                    <div>
	                                    	<fmt:formatNumber value="${room.price}" pattern="#,###" />원
	                                    </div>
	                                </div>
	                                <div class="highlight-btn-container">
	                                    <a href="/user/reservation/pay?accId=${acc.id}&roomId=${room.id}&checkinDate=${param.checkinDate}&checkoutDate=${param.checkoutDate}">
	                                    	<input type="button" class="highlight-btn rv-btn" value="예약하기">
	                                    </a>
	                                </div>
	                            </div>
	                        </div>
	                    </section>
	                	</c:forEach>
                	</c:if>
                	<c:if test="${empty roomList}">
	                	<c:forEach var="room" items="${showRoomList}" varStatus="st">
	                    <section>
	                        <div class="room-container">
	                            <div class="room-img-container">
	                                <c:forTokens var="fileRoute" items="${room.fileroute}" delims="," varStatus="st">
			                        	<c:if test="${st.first == true}">
				                        	<img src="${fileRoute}" alt=""><br>
			                        	</c:if>
			                       	</c:forTokens>
	                            </div>
	                            <div class="room-detail-container">
	                                <div class="room-room">
	                                    <span>${room.name}</span>
	                                </div>
	                                <div class="room-bed-count">
	                                    <div>침대개수</div>
	                                    <div>${room.bedCount}</div>
	                                </div>
	                                <div class="room-max-headcount">
	                                    <div>최대 수용인원</div>
	                                    <div>${room.maxHeadcount}</div>
	                                </div>
	                                <div class="room-price">
	                                    <div>가격</div>
	                                    <div>
	                                    	<fmt:formatNumber value="${room.price}" pattern="#,###" />원
	                                    </div>
	                                </div>
	                                <div class="highlight-btn-container">
	                                    <a href="/user/reservation/pay?accId=${acc.id}&roomId=${room.id}&userId=${userId}&checkinDate=${param.checkinDate}&checkoutDate=${param.checkoutDate}">
	                                    	<input type="button" class="highlight-btn" value="예약하기">
	                                    </a>
	                                </div>
	                            </div>
	                        </div>
	                    </section>
	                	</c:forEach>
                	</c:if>
                    
                </form>
                <c:if test="${type == 0 }">
	                <section class="goodsonmylist-box">
	                    <div class="goodsonmylist">
	                        <a href="" class="zzim ${(zzimStatus==0)?'unzzimed':'zzimed' }">♥ 찜</a>
	                        <input type="hidden" value=${userId }>
	                        <input type="hidden" value=${acc.id }>
	                    </div>
	                </section>
                </c:if>
                <c:set var="avg" value="${avg}"/>
                 <c:set var="count" value="${count}"/>
                <section class="review-section">
                    <h1>리뷰</h1>
                    <div class="review-info">
                        <span class="review-span">추천해요!</span><br>
                        <span class="review-span">평점<fmt:formatNumber type="number"  pattern="0.0" value="${ (((avg*10) - ((avg*10)%1)) * (1/10))}"/>/ 5.0</span><br>
                        <span class="review-total">전체 리뷰 ${count}개</span>
                    </div>
                    <c:forEach var="re" items="${review}">
                    <div class="review">
                        <img src="/images/review/face.png" class="review-img">
                        <div class="review-ment-container">
                            <div class="review-title">${re.userName}</div>
                            <div class="review-ment">${re.reviewContent}</div>
                            <div class="review-regdate">${re.reviewRegdate}</div>
                        </div>
                    </div>
                    </c:forEach>
                </section>
            </section>
        </div>
    </section>
    
    
    <section class="sec_footer">
        <footer>
            <div>
                <ul>
                    <li>
                        <a href="">회사소개</a>
                        <span>|</span>
                    </li>
                    <li>
                        <a href="">이용약관</a>
                        <span>|</span>
                    </li>
                    <li>
                        <a href="">개인정보처리방침</a>
                        <span>|</span>
                    </li>
                    <li>
                        <a href="">사업자정보확인</a>
                        <span>|</span>
                    </li>
                    <li>
                        <a href="">여기어때 마케팅센터</a>
                        <span>|</span>
                    </li>
                    <li>
                        <a href="">액티비티 호스트센터</a>
                        <span>|</span>
                    </li>
                    <li><a href="">콘텐츠산업진흥법에의한 표시</a></li>
                </ul>
        
                <p><b>고객행복센터 1577-8282</b>   오전 09:00 ~ 오후18:00</p>

                <address>
                    <span>(주)TEUM</span>
                    주소 : 서울특별시 종로구 인사동길 12 대일빌딩 15층
                    <br>대표이사 : 신중언 | 사업자등록번호 777-11-45678
                    <br>통신판매번호 : 2020-서울강남-12345 | 관광사업자 등록번호 : 제 1324-55호
                    <br>전화번호 : 010-1111-2222
                    <br>전자우편주소 : teum@teum.co.kr
                    <br>Copyright TEUM COMPANY Corp. All rights reserved.
                </address>
            </div>
        </footer>
    </section>
</body>
</html>
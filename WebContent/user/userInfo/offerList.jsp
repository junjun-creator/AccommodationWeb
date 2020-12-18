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
    <title>Document</title>
    <link rel="stylesheet" href="../../css/reset.css">
    <link rel="stylesheet" href="../../css/layout.css">
    <link rel="stylesheet" href="../../css/user/userInfo/proposalList.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <script src="/js/user/userInfo/proposalList.js"></script>
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
                    <li><a href="">제안하기</a></li>
                    <li><a href="">예약내역</a></li>
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
                <ul>
                    <li><a href="memberInfo"><i class="fas fa-exclamation-circle"></i>&nbsp;&nbsp;회원정보수정</a></li>
                    <li><a href=""><i class="far fa-calendar-check"></i>&nbsp;&nbsp;예약관리</a></li>
                    <li class="active"><a href="offerList"><i class="far fa-question-circle"></i>&nbsp;&nbsp;제안신청관리</a></li>
                    <li><a href="pickList"><i class="far fa-question-circle"></i>&nbsp;&nbsp;찜한상품조회</a></li>
                </ul>
            </aside>
            <main id="main" class="main">
                <div>

                </div>
                <div>
                    <div class="btn-left" style="align-self: center;"><i style="font-size: 50px; color: gray; opacity: 0.5;" class="fas fa-angle-left"></i></div>
                    <div style="width: 700px; overflow:hidden;">
                        <div class="proposal-item-container" style="display: flex;">
				
							<c:forEach items="${offerList }" var="offer" varStatus="status">
							
	                            <div class="proposal-info">
	                                <h2>제안정보</h2>
	                                <ul>
	                                    <li>
	                                        <div>날짜</div>
	                                        <div>${offer.checkinDate } ~ ${offer.checkoutDate }</div>
	                                    </li>
	                                    <li>
	                                        <div>위치</div>
	                                        <div>${offer.location }</div>
	                                    </li>
	                                    <li>
	                                        <div>인원수</div>
	                                        <div>${offer.headcount }</div>
	                                    </li>
	                                    <li>
	                                        <div>희망하는 가격</div>
	                                        <div class="wanted-price"><fmt:formatNumber value="${offer.price }" pattern="#,###" />원</div>
	                                    </li>
	                                </ul>
	                            </div>
							</c:forEach>
                        </div>
                    </div>
                    <div class="btn-right" style="align-self: center;"><i style="font-size: 50px; color: gray; opacity: 0.5;" class="fas fa-angle-right"></i></div>
                </div>
                <!-- <section class="proposal-sec">
                    <div class="cliper-btn prev-btn">
                        <i class="fas fa-angle-left"></i>
                    </div>
                    <div class="cliper-btn next-btn">
                        <i class="fas fa-angle-right"></i>
                    </div>
                    <h1>제안하신 목록입니다!</h1> 
                    <div class="proposal-container">
                        <div class="proposal-ul">
                            <div>
                                
                                <div class="proposal-info">
                                    <h2>제안정보</h2>
                                    <ul>
                                        <li>
                                            <div>날짜</div>
                                            <div>2020.12.12 ~ 2020.12.15</div>
                                        </li>
                                        <li>
                                            <div>위치</div>
                                            <div>경기도 하남시</div>
                                        </li>
                                        <li>
                                            <div>인원수</div>
                                            <div>4</div>
                                        </li>
                                        <li>
                                            <div>희망하는 가격</div>
                                            <div class="wanted-price">120,000원</div>
                                        </li>
                                    </ul>
                                </div>
                                <div class="proposal-info">
                                    <h2>제안정보</h2>
                                    <ul>
                                        <li>
                                            <div>날짜</div>
                                            <div>2020.12.07 ~ 2020.12.08</div>
                                        </li>
                                        <li>
                                            <div>위치</div>
                                            <div>서울시 강남구</div>
                                        </li>
                                        <li>
                                            <div>인원수</div>
                                            <div>3</div>
                                        </li>
                                        <li>
                                            <div>희망하는 가격</div>
                                            <div class="wanted-price">50,000원</div>
                                        </li>
                                    </ul>
                                </div>
                                <div class="proposal-info">
                                    <h2>제안정보</h2>
                                    <ul>
                                        <li>
                                            <div>날짜</div>
                                            <div>2020.12.07 ~ 2020.12.08</div>
                                        </li>
                                        <li>
                                            <div>위치</div>
                                            <div>서울시 강남구</div>
                                        </li>
                                        <li>
                                            <div>인원수</div>
                                            <div>3</div>
                                        </li>
                                        <li>
                                            <div>희망하는 가격</div>
                                            <div class="wanted-price">50,000원</div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                </section> -->

                <section class="offer-sec">
                    <form class="offer-form">
                        <h1>글래드 라이브 강남</h1>
                        <section>
                            <div class="offer-container">
                                <div class="offer-img-container">
                                    <!-- <a href=""><img src="http://lorempixel.com/370/220/"></a> -->
                                    <a href=""><img src="../../images/company/호텔/서울/강남구/라마다호텔/슈페리얼더블/메인.jpg" alt=""></a>
                                </div>
                                <div class="offer-detail-container">
                                    <div class="offer-room">
                                        <span>스위트룸</span>
                                    </div>
                                    <div class="offer-bed-count">
                                        <div>침대개수</div>
                                        <div>3</div>
                                    </div>
                                    <div class="offer-max-headcount">
                                        <div>최대 수용인원</div>
                                        <div>2</div>
                                    </div>
                                    <div class="offer-price">
                                        <div>가격</div>
                                        <div>258,220원</div>
                                    </div>
                                    <div class="submit-btn-container">
                                        <input type="submit" class="submit-btn" value="승인하기">
                                    </div>
                                </div>
                            </div>
                        </section>
                    </form>
                </section>

                <section class="offer-sec">
                    <form class="offer-form">
                        <h1>글래드 라이브 강남</h1>
                        <section>
                            <div class="offer-container">
                                <div class="offer-img-container">
                                    <!-- <a href=""><img src="http://lorempixel.com/370/220/"></a> -->
                                    <a href=""><img src="../../images/company/호텔/서울/강남구/라마다호텔/슈페리얼더블/메인.jpg" alt=""></a>
                                </div>
                                <div class="offer-detail-container">
                                    <div class="offer-room">
                                        <span>스위트룸</span>
                                    </div>
                                    <div class="offer-bed-count">
                                        <div>침대개수</div>
                                        <div>3</div>
                                    </div>
                                    <div class="offer-max-headcount">
                                        <div>최대 수용인원</div>
                                        <div>2</div>
                                    </div>
                                    <div class="offer-price">
                                        <div>가격</div>
                                        <div>258,220원</div>
                                    </div>
                                    <div class="submit-btn-container">
                                        <input type="submit" class="submit-btn" value="승인하기">
                                    </div>
                                </div>
                            </div>
                        </section>
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
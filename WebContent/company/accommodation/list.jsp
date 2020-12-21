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
    <link rel="stylesheet" href="../../css/company/userInfo/myAccommodationLists.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>

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
                    <li><a href=""><i class="fas fa-exclamation-circle"></i>&nbsp;&nbsp;회원정보수정</a></li>
                    <li><a href=""><i class="far fa-calendar-check"></i>&nbsp;&nbsp;예약관리</a></li>
                    <li><a href=""><i class="far fa-question-circle"></i>&nbsp;&nbsp;제안신청관리</a></li>
                    <li class="active"><a href=""><i class="far fa-question-circle"></i>&nbsp;&nbsp;숙소현황</a></li>
                    <li><a href=""><i class="far fa-question-circle"></i>&nbsp;&nbsp;숙소등록</a></li>
                    <li><a href=""><i class="far fa-question-circle"></i>&nbsp;&nbsp;골든타임관리</a></li>
                </ul>
            </aside>
            <main id="main" class="main">
                <div class="breadcrumb">
                    <ul class="breadcrumb-list">
                        <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i> </li>
                        <li>&nbsp;&nbsp;&nbsp;마이페이지</li>
                    </ul>
                </div>
                <section class="reservation-list-sec">
                    <h1>숙소현황</h1>
                    <section class="category-sec">
                        <div class="category-bar">
                            <ul>
                                <li>
                                    <a class="category-img ${(accType==0)?'selected':''}" href="list">
                                        <img src="../../images/main/all-icon.png" alt="">
                                        <span>전체</span>
                                    </a>
                                </li>
                                <li>
                                    <a class="category-img ${(accType==1)?'selected':''}" href="?accType=1">
                                        <img src="../../images/main/hotel-icon.png" alt="">
                                        <span>호텔</span>
                                    </a>
                                </li>
                                <li>
                                    <a class="category-img ${(accType==2)?'selected':''}" href="?accType=2">
                                        <img src="../../images/main/motel-icon.png" alt="">
                                        <span>모텔</span>
                                    </a>
                                </li>
                                <li>
                                    <a class="category-img ${(accType==3)?'selected':''}" href="?accType=3">
                                        <img src="../../images/main/guesthouse-icon.png" alt="">
                                        <span>게스트하우스</span>
                                    </a>
                                </li>
                                <li>
                                    <a class="category-img ${(accType==4)?'selected':''}" href="?accType=4">
                                        <img src="../../images/main/resort-icon.png" alt="">
                                        <span>리조트</span>
                                    </a>
                                </li>
                                <li>
                                    <a class="category-img ${(accType==5)?'selected':''}" href="?accType=5">
                                        <img src="../../images/main/pension-icon.png" alt="">
                                        <span>펜션</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </section>

                    <section class="acc-item-sec">
                    	<c:forEach items="${list }" var="item" varStatus="status">
	                        <div class="snip1368">
	                        <c:forTokens var="fileRoute" items="${item.accFileRoute}" delims="," varStatus="st">
	                        	<c:if test="${st.first == true}">
		                        	<img src="${fileRoute}" alt="">
	                        	</c:if>
	                        </c:forTokens>
	                            
	                            <h3>상세보기</h3>
	                            <figcaption>
	                                <div class="icons"><a href="#"><i class="ion-social-reddit-outline"></i></a>
	                                  <a href="#"> <i class="ion-social-twitter-outline"></i></a>
	                                  <a href="#"> <i class="ion-social-vimeo-outline"></i></a>
	                                </div>
	                              </figcaption>
	                            <div class="description-item">
	                                <p>${item.accName }</p>
	                                <P> <fmt:formatNumber type="number"  pattern="0.0" value="${ (((item.score*10) - ((item.score*10)%1)) * (1/10))*2   } " /> 추천해요</P>
	                                <p>${fn:substring(item.accLocation,0,7) }</p>
	                            </div>
	                            <div class="item-price">
	                                <div>
	                                    <p>숙박</p>
	                                    <p>예약특가</p>
	                                    <p><fmt:formatNumber value="${item.price }" pattern="#,###" />원</p>
	                                </div>
	                            </div>
	                            <div class="hovered-item-bg">
	                            </div>
	                        </div>
                    	</c:forEach>
                        
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/layout.css">
    <link rel="stylesheet" href="/css/company/goldenTime/list.css">
     <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <script src="/../../js/company/goldenTime/list.js"></script>
    <title>골든타임 리스트</title>
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
    <section  class="container-sec">
        <div class="container">
            <aside id="aside" class="aside">
                <!-- <h1>게시판</h1> -->
                <ul style="width:230px;">
                    <li><a href="/company/userInfo/memberInfo"><i class="far fa-user-circle"></i>&nbsp;&nbsp;회원정보수정</a></li>
                    <li><a href="/company/reservation/reservationInfo"><i class="far fa-calendar-check"></i>&nbsp;&nbsp;예약관리</a></li>
                    <li><a href="/company/reverseOffer/reg"><i class="fas fa-file-upload"></i>&nbsp;&nbsp;제안신청관리</a></li>
                    <li><a href="/company/reverseOffer/detail"><i class="fas fa-file-download"></i>&nbsp;&nbsp;역제안신청관리</a></li>
                    <li><a href="/company/accommodation/list"><i class="fas fa-map-marked-alt"></i>&nbsp;&nbsp;숙소현황</a></li>
                    <li><a href="/company/accommodation/reg"><i class="fas fa-sign-in-alt"></i>&nbsp;&nbsp;숙소등록</a></li>
                    <li class="active"><a href="/company/goldenTime/list"><i class="fas fa-hourglass-start"></i>&nbsp;&nbsp;골든타임관리</a></li>
                </ul>
            </aside>
            <main id="main" class="main" style="min-height:600px;">
                <div class="breadcrumb">
                    <ul class="breadcrumb-list">
                         <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i> </li>
                        <li>&nbsp;&nbsp;&nbsp;마이페이지</li>
                    </ul>
                </div>
                
		        <form action="list"  method="post">
                <section class="golden-sec">
                    <h1>골든타임 리스트 /
                    	<span>GoldenTime List</span>
                    </h1>
                    	<div class="formbox">
                    		<div class="form">
		                    	<div class="option-list">
			                    	<div>
						             	<span>시작일 :</span> <input class="startDate" type="date" name="start">
						               	<span>종료일 : </span> <input class="endDate"  type="date"name="end">
						            </div>
						            <div>    
						                <span>인하가격 : </span> <input type="text" class="form-option price-input" placeholder="원(￦) 단위로 입력해 주세요"  name="price">
					                </div>
				                </div>
				                <div class="btn-list">
				               		 
				                	<input class="switching"  type="hidden" name="switching" value="0">
				                	<input class="progress"  type="submit"  name="cmd"value="진행">
				                	<input class="nonprogress"  type="submit"  name="cmd"value="대기">
				                </div>
					           </div>  
	                    </div>
	                    <c:forEach var="g"  items="${list}">
		                    <div class="snip1368">
		                        <c:forTokens var="fileRoute" items="${g.fileroute}" delims="," varStatus="st">
	                        	<c:if test="${st.first == true}">
		                        	<img src="${fileRoute}" alt="">
	                        	</c:if>
	                        </c:forTokens>
		                        <input type="radio" class="radio" name="check" value="${g.id}" >
		                         <c:set var="status" value=""/>
		                         <c:if test="${g.goldentimeStatus==1}">
		                        	 <c:set var="status" value="진행중"/>
		                         </c:if> 
		                         <c:if test="${g.goldentimeStatus==0}">
		                        	 <c:set var="status" value="대기중"/>
		                         </c:if>     
		                        <h3>${status}</h3>
		                        <figcaption>
		                            <div class="icons"><a href="#"><i class="ion-social-reddit-outline"></i></a>
		                              <a href="#"> <i class="ion-social-twitter-outline"></i></a>
		                              <a href="#"> <i class="ion-social-vimeo-outline"></i></a>
		                            </div>
		                          </figcaption>
		                        <div class="description-item">
		                            <p style="color:black;">${g.name}</p>
		                            <div class="date-box" style="display:flex; color:orange; font-size:25px; font-weight:bold; margin-top:12px;margin-bottom:12px;">
		                            	<p class="start">${g.gtStartDate}</p><span>~</span><p class="end">${g.gtEndDate}</p>
		                            </div>
		                            <p style="color:black;">${g.location }</p>
		                        </div>
		                        <div class="item-price">
		                            <div>
		                                <p>인하가격</p>
		                                <p>${g.saleprice}원</p>
		                                <input type="hidden"  name="saleprice" value="${g.saleprice}">
		                            </div>
		                        </div>
		                        <div class="hovered-item-bg">
		                        </div>
		                    </div>
	                    </c:forEach>
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
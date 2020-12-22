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
    <link rel="stylesheet" href="../../css/reset.css">
    <link rel="stylesheet" href="/css/layout.css">
    <link rel="stylesheet" href="../../css/admin/layout.css">
    <link rel="stylesheet" href="../../css/admin/accommodations/applyDetail.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <title>등록 요청 업체</title>
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

    <main>
		<section class="body">
			<aside id="aside" class="aside">
				<h1>업체관리</h1>
				<ul>
					<li><a href="list">승인된 업체 리스트</a></li>
					<li class="active"><a href="applyList">업체 등록 관리</a></li>
				</ul>
			</aside>
			<div class="container">
				<nav id="nav" class="nav">
					<ul>
						<li class="current-tab">
							<a href="list">
								<i class="fas fa-hotel"></i><span>업체관리</span>
							</a>
						</li>
						<li>
							<a href="/admin/userInfo/list">
								<i class="fas fa-user-circle"></i><span> 회원관리</span>
							</a>
						</li>
						<li>
							<a href="/admin/promotion/goldenTime/list">
								<i class="far fa-calendar-alt"></i><span>프로모션관리</span>
							</a>
						</li>
						<li>
							<a href="/admin/customerService/notice/list">
								<i class="fas fa-headphones"></i><span>고객센터</span>
							</a>
						</li>
					</ul> 
				</nav>
				<main id="main" class="main">
					<div class="sub-container">
						<div class="breadcrumb">
							<ul class="breadcrumb-list">
                                <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
                                <li>&nbsp;&nbsp;&nbsp;업체관리&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
								<li>&nbsp;&nbsp;&nbsp;업체 등록 관리&nbsp;&nbsp;&nbsp;</li>
								<li>&nbsp;&nbsp;&nbsp;미승인 업체&nbsp;&nbsp;&nbsp;</li>
                            </ul>
						</div>
						<h1>미승인 업체</h1><br>
						<section class='title'>
							<div class="pic">
								<div class="main-img">
				                    <c:forTokens var="fileRoute" items="${accImage.fileroute}" delims="," varStatus="st">
			                        	<c:if test="${st.first == true}">
				                        	<img src="${fileRoute}" alt=""><br>
			                        	</c:if>
			                       	</c:forTokens>
		                    	</div>
								<%-- <div class="cliper">
									<ul>
										<li class="current"><c:forTokens var="fileRoute" items="${room.fileroute}" delims="," varStatus="st">
                                       <c:if test="${st.first == true}">
                                          <img src="${fileRoute}" alt="">
                                       </c:if>
                                    </c:forTokens></li>
										<li><c:forTokens var="fileRoute" items="${room.fileroute}" delims="," varStatus="st">
                                       <c:if test="${st.first == true}">
                                          <img src="${fileRoute}" alt="">
                                       </c:if>
                                    </c:forTokens></li>
										<li><c:forTokens var="fileRoute" items="${room.fileroute}" delims="," varStatus="st">
                                       <c:if test="${st.first == true}">
                                          <img src="${fileRoute}" alt="">
                                       </c:if>
                                    </c:forTokens></li>
										<li><c:forTokens var="fileRoute" items="${room.fileroute}" delims="," varStatus="st">
                                       <c:if test="${st.first == true}">
                                          <img src="${fileRoute}" alt="">
                                       </c:if>
                                    </c:forTokens></li> 
										<li><c:forTokens var="fileRoute" items="${room.fileroute}" delims="," varStatus="st">
                                       <c:if test="${st.first == true}">
                                          <img src="${fileRoute}" alt="">
                                       </c:if>
                                    </c:forTokens></li>
									</ul>
								</div> --%>
								<div class="cliper">
				                     <ul>
				                         <li class="current"><img src="/images/company/호텔/서울/강남,역삼,삼성/신라스테이_삼성/메인.jpg"></li>
				                         <li><img src="/images/company/호텔/서울/강남,역삼,삼성/신라스테이_삼성/스탠다드_더블/메인.jpg"></li>
				                         <li><img src="/images/company/호텔/서울/강남,역삼,삼성/신라스테이_삼성/메인.jpg"></li>
				                         <li><img src="/images/company/호텔/서울/강남,역삼,삼성/신라스테이_삼성/스탠다드_트윈/메인.jpg" alt= "신라스테이 삼성"></li> 
				                         <li><img src="/images/company/호텔/서울/강남,역삼,삼성/신라스테이_삼성/메인.jpg"></li>
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
						<div class="room-form">
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
			                         		 <div><fmt:formatNumber value="${room.price}" pattern="#,###" />원</div>
			                       		</div>
				                   </div>
			                  </div>
		                 </section>
			              	  <form>
								<div class="btn-box">
									<a class="btn-cancel" href="edit?id=${n.id}">승인</a>
                    				<a class="btn-cancel" href="del?id=${n.id}">삭제</a>
								</div>
							</form>
	                </c:forEach>   
	                </div>
						</section>
					</div>
				</main>
			</div>
		</section>
	</main>
</body>
</html>
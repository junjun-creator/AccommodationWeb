<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../css/reset.css">
	<link rel="stylesheet" href="/css/layout.css">
	<link rel="stylesheet" href="../../css/admin/layout.css">
    <link rel="stylesheet" href="../../css/admin/accommodations/detail.css">
	<link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
	<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <title>업체등록 요청 리스트</title>
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
					<li><a href="list" class="active">등록된 업체 리스트</a></li>
					<li><a href="regList">업체 등록 관리</a></li>
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
				
				<main class="main">
					<div class="sub-container">
						<div class="breadcrumb">
							<ul class="breadcrumb-list">
								<li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
								<li>&nbsp;&nbsp;&nbsp;업체관리&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
								<li>&nbsp;&nbsp;&nbsp;승인된 업체 리스트&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
								<li>&nbsp;&nbsp;&nbsp;승인된 업체&nbsp;&nbsp;&nbsp;</li>
							</ul>
						</div>
						<h1>등록된 업체</h1><br>
						
						<form class="room-form">
                			<c:if test="${empty showRoomList}">
	                			<c:forEach var="room" items="${roomList}" varStatus="st">
	                 		   <section>
	                    		    <div class="room-container">
	                   		         <div class="room-img-container">
	                   	             <img src="" alt= "">
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
	                                    	<input type="button" class="highlight-btn" value="예약하기">
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
	                                <img src="" alt= "">
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
								
				<form>
					<div class="btn-box">
						<input type="submit"  name="cmd"value="삭제" class="delete-btn">
					</div>	
				</form>
						</section>
					</div>
				</main>
			</div>
		</section>
	</main>
</body>
</html>
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
    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/layout.css">

    <link rel="stylesheet" href="/css/admin/layout.css">
    <link rel="stylesheet" href="/css/admin/accommodations/detail.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <title>등록 요청 업체</title>
</head>
<body>
    <header class="sec-header-page">
        <section class="header-sec pcHeader">
            <div class="header-logo">
                <h1><a class="teum-logo" href="/admin/index">틈</a></h1>
            </div>
            <div>
                <ul class="main-menu">
                    <li class="sub-page">
                        <a href="">로그인</a>
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
				<main id="main" class="main">
					<div class="sub-container">
						<div class="breadcrumb">
							<ul class="breadcrumb-list">
								<li><i class="fas fa-home"></i>HOME ▶ </li>
								<li>업체관리 ▶ </li>
								<li>업체된 업체 리스트 ▶ </li>
								<li>업체된 업체</li>
							</ul>
						</div>
						<h1>등록된 업체</h1><br>
						
						<section class='title'>
							<div class="pic">
								<div class="main-img">
									<img src = "/images/company/호텔/서울/강남,역삼,삼성/신라스테이_삼성/신라스테이_삼성_메인.png" alt= "신라스테이 삼성"><br>
								</div>
								<div class="cliper-btn prev-btn">
									<i class="fas fa-angle-left"></i>
								</div>
								<div class="cliper-btn next-btn">
									<i class="fas fa-angle-right"></i>
								</div>
								<div class="cliper">
									<ul>
										<li class="current"><img src="/images/company/호텔/서울/강남,역삼,삼성/신라스테이_삼성/신라스테이_삼성_메인.png"></li>
										<li><img src="/images/company/호텔/서울/강남,역삼,삼성/신라스테이_삼성/스탠다드_더블/신라스테이_삼성_스탠다드더블_메인.jpg"></li>
										<li><img src="/images/company/호텔/서울/강남,역삼,삼성/신라스테이_삼성/신라스테이_삼성_메인.png"></li>
										<li><img src="/images/company/호텔/서울/강남,역삼,삼성/신라스테이_삼성/스탠다드_트윈/신라스테이_삼성_스탠다드트윈_메인.png" alt= "신라스테이 삼성"></li> 
										<li><img src="/images/company/호텔/서울/강남,역삼,삼성/신라스테이_삼성/신라스테이_삼성_메인.png"></li>
									</ul>
								</div>
							</div>
							<div class="main-info">
								<h1>신라스테이 삼성</h1>
								<h2>서울 강남구 삼성동 168-3</h2>
								<div class="rule">
									<p>취소 및 환불 규정</p>
									<ul>
										<li> → 체크인일 기준 1일전 18시까지 : 100% 환불</li>
										<li> → 체크인일 기준 1일전 18시이후~당일 : 환불불가</li>
										<li> → 취소, 환불시 수수료가 발생할 수 있습니다</li>
									</ul>
								</div>
								<div class="check">
									<p>확인사항 및 기타</p>
									<ul>
										<li> → 거리두기 단계 상향에 따라 일부 시설 이용이 제한될 수 있습니다</li>
										<li> → 최대인원 초과시 입실 불가합니다</li>
										<li> → 위의 정보는 호텔의 사정에 따라 변경될 수 있습니다</li>
										<li> → 해당 이미지는 실제와 상이 할 수 있습니다</li>
										<li> → 체크인 시 배정 또는 베드타입 미기재 상품은 특정객실과 베드타입을 보장하지 않습니다</li>
										<li> → 해당 객실가는 세금, 봉사료가 포함된 금액입니다</li>
										<li> → 미성년자는 보호자 동반없이 이용하실 수 없습니다</li>
									</ul>
								</div>
							</div>
						</section>
						
						<section class="room-sec">
							<h1>객실 안내 및 예약</h1>
							
							<form class="room-form">
								<section>
									<!-- <div class="radio-container">
										<input type="radio" name="radio" id="radio-1" class="radio" required>
										<label for="radio-1"><span></span></label>
									</div> -->
									<div class="room-container">
										<div class="room-img-container">
											<img src="/images/company/호텔/서울/강남,역삼,삼성/신라스테이_삼성/스탠다드_트윈/메인.jpg" alt= "신라스테이 삼성">
										</div>
										<div class="room-detail-container">
											<div class="room-room">
												<span>스탠다드 트윈</span>
											</div>
											<div class="room-bed-count">
												<div>침대개수</div>
												<div>2</div>
											</div>
											<div class="room-max-headcount">
												<div>최대 수용인원</div>
												<div>2</div>
											</div>
											<div class="room-price">
												<div>가격</div>
												<div>128,260원</div>
											</div>
											
										</div>
									</div>
								</section>
								<div class="btn-box">
									<input type="button" value="삭제" class="btn delete-btn">
									<input type="button" value="승인" class="btn approval-btn">
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
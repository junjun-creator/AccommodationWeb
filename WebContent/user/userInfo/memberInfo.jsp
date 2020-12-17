<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../../css/reset.css">
    <link rel="stylesheet" href="../../css/layout.css">
    <link rel="stylesheet" href="../../css/user/userInfo/memberInfo.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <script src="/js/user/userInfo/memberInfo.js"></script>

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
                    <li class="active"><a href="memberInfo"><i class="fas fa-exclamation-circle"></i>&nbsp;&nbsp;회원정보수정</a></li>
                    <li><a href=""><i class="far fa-calendar-check"></i>&nbsp;&nbsp;예약관리</a></li>
                    <li><a href=""><i class="far fa-question-circle"></i>&nbsp;&nbsp;제안신청관리</a></li>
                    <li><a href=""><i class="far fa-question-circle"></i>&nbsp;&nbsp;찜한상품조회</a></li>
                </ul>
            </aside>
            <main id="main" class="main">
                <div class="breadcrumb">
                    <ul class="breadcrumb-list">
                        <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i> </li>
                        <li>&nbsp;&nbsp;&nbsp;마이페이지</li>
                    </ul>
                </div>
                <section class="member-info-sec">
                    <h1>비밀번호확인</h1>
                    <div>
                        <p>비밀번호입력</p>
                        <p>비밀번호를 다시 입력해주세요.</p>
                    </div>
                    <div>
                        <!-- <form action=""> -->
                            <div class="reg-form-item">
                                <div class="input-box">
                                    <div>
                                        <input type="password" class="password check-validation" 
                                        placeholder="최소8자 영문/숫자/특수문자 필수" id="password" name="password" autocorrect="off" 
                                        autocapitalize="off" autocomplete="off" aria-autocomplete="none" inputmode="text">
                                        <span class="caution-mention">최소8자 영문/숫자/특수문자 필수입니다</span>
                                    </div>
                                </div>
                            </div>
                            <div class="button-submit">
	                            <button class="disabled">확인</button>
                            </div>
                        <!-- </form> -->
                    </div>
                </section>
            </main>
        </div>
    </section>

    <!-- <section class="userInfo_main">
        <main class="sec_userInfo_main">
            <aside>
                <h1>회원정보관리(개인)</h1>
                <ul>
                    <li>
                        <a href=""><i style="color: red;" class="fas fa-angle-double-right"></i>회원정보수정</a>
                    </li>
                    <li>
                        <a href="">예약관리</a>
                    </li>
                    <li>
                        <a href="">경매신청관리</a>
                    </li>
                    <li>
                        <a href="">최근살펴본상품조회</a>
                    </li>
                    <li>
                        <a href="">찜한상품조회</a>
                    </li>
                </ul>
            </aside>

            <div>
                <section>
                    <h1>비밀번호확인</h1>
                    <div>
                            <p>비밀번호입력</p>
                            <p>비밀번호를 다시 입력해주세요.</p>
                    </div>
                    <div>
                        <form action="">
                            <input type="text">
                            <input type="submit" value="확인">
                        </form>
                    </div>

                </section>
            </div>
        </main>
    </section> -->

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
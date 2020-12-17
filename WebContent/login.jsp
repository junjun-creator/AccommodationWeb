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
    <link rel="stylesheet" href="../../css/login.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <script src="/js/login.js"></script>

</head>
<body>
    <header class="sec-header-page">
        <section class="header-sec pcHeader">
            <div class="header-logo">
                <h1><a class="teum-logo" href="index">틈</a></h1>
            </div>
            <div>
                <ul class="main-menu">
                    <li class="header-search"><input type="text"><a href=""><i class="fas fa-search"></i></a></li>
                    
                    <li><a href="">더보기</a></li>
                    <li class="mypage"><a href="">로그인</a>
                    </li>
                </ul>
            </div>
        </section>
    </header>

    <section class="container-sec">
        <div class="container">
            <main id="main" class="main">
               
                <!-- <h1>Join Now</h1> -->
                <img src="/images/login.png" alt="">
                <div class="reg-form-sec">

                   <!--  <form> -->
                        <div class="reg-form-container">
                            <div class="reg-form-item">
                                <label style="font-size: 12px;" for="email" title="이메일">
                                    <em style="color: red;">*</em>
                                    이메일
                                </label>
                                <div class="input-box">
                                    <div>
                                        <input type="email check-validation" class="email check-validation"  
                                        placeholder="teum@example.com" id="email" name="email" autocorrect="off" 
                                        autocapitalize="off" autocomplete="off" aria-autocomplete="none" inputmode="text">
                                        <span class="caution-mention">올바른 이메일 형식을 입력해주세요</span>
                                    </div>
                                </div>
                            </div>
                            <div class="reg-form-item">
                                <label style="font-size: 12px;" for="password" title="비밀번호">
                                    <em style="color: red;">*</em>
                                    비밀번호
                                </label>
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
                            <button class="disabled">로그인</button>
                        </div>
                    <!-- </form> -->
                </div>
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
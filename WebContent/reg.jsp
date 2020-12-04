<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../../css/reset.css">
    <link rel="stylesheet" href="../../css/jun.css">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<body>
    <header class="sec_header">
        <div class="header pcHeader">
            <div class="header_h1">
                <h1><a class="teum_logo" href="http://127.0.0.1:5500/main.html">틈</a></h1>
            </div>
            <div>
                <ul class="main_menu">
                    <li class="header_search"><input type="text"><a href=""><i class="fas fa-search"></i></a></li>
                    <li><a href="">공지사항</a></li>
                    <li><a href="">이벤트</a></li>
                    <li><a href="">더보기</a></li>
                    <li class="mypage"><a href="">로그인</a>
                        <div class="mega_menu">
                            <ul>
                                <li><a href="">submenu</a></li>
                                <li><a href="">submenu</a></li>
                                <li><a href="">submenu</a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </header>

    <header class="header mobileHeader">
        <div>
            <a href=""><i class="fas fa-bars"></i></a>
        </div>
        <div class="header_h1">
            <h1><a class="teum_logo" href="http://127.0.0.1:5500/main.html">틈</a></h1>
        </div>
        <div>
            <a href=""><i class="fas fa-search"></i></a>
        </div>
    </header>

    <section class="main">
        <main class="sec_login_main">

            <div>
                <img src="배경1-1.PNG" alt="">
            </div>

            <div class="login_form">
                <h1>회원가입</h1>
                
                <section class="sec_form">
                    <form method="post">
                        <table>
                            <tr>
                                <th style="white-space: nowrap;">이메일</th>
                                <td><input type="text" name="email"></td>
                                <td><input type="button" value="중복체크"></td>
                            </tr>
                            <tr>
                                <th style="white-space: nowrap;">이름</th>
                                <td><input type="text" name="name"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <th style="white-space: nowrap;">비밀번호</th>
                                <td><input type="password" name="pwd"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <th style="white-space: nowrap;">비밀번호확인</th>
                                <td><input type="password"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <th style="white-space: nowrap;">연락처</th>
                                <td><input type="text" name="phone"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <th style="white-space: nowrap;">생년월일</th>
                                <td><input type="text" name="birthday"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <th style="white-space: nowrap;">회원구분</th>
                                <td colspan="2" style="padding-left: 32px;">
                                    <input name="type" type="radio" value="개인회원" checked>
                                    <span>개인회원</span>
                                    <input name="type" type="radio" value="기업회원">
                                    <span>기업회원</span>
                                </td>
                            </tr>
                        </table>
    
                        <div class="btn_submit">
                            <input type="submit" value="여행가격의 빈 틈을 찾으러 GOGO~">
                        </div>
                    </form>
                </section>
            </div>
        </main>
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
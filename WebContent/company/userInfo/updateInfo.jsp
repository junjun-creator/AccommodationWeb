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
    <link rel="stylesheet" href="../../css/company/userInfo/updateInfo.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
	<script src="/js/company/userInfo/updateInfo.js"></script>

</head>

<body>
    <jsp:include page="/inc/header.jsp"/>

    <section class="container-sec">
        <div class="container">
            <aside id="aside" class="aside">
                <!-- <h1>게시판</h1> -->
                <ul style="width:230px;">
                    <li class="active"><a href="/company/userInfo/memberInfo"><i class="far fa-user-circle"></i>&nbsp;&nbsp;회원정보수정</a></li>
                    <li><a href="/company/reservation/reservationInfo"><i class="far fa-calendar-check"></i>&nbsp;&nbsp;예약관리</a></li>
                    <li><a href="/company/reverseOffer/reg"><i class="fas fa-file-upload"></i>&nbsp;&nbsp;제안신청관리</a></li>
                    <li><a href="/company/reverseOffer/detail"><i class="fas fa-file-download"></i>&nbsp;&nbsp;역제안신청관리</a></li>
                    <li><a href="/company/accommodation/list"><i class="fas fa-map-marked-alt"></i>&nbsp;&nbsp;숙소현황</a></li>
                    <li><a href="/company/accommodation/reg"><i class="fas fa-sign-in-alt"></i>&nbsp;&nbsp;숙소등록</a></li>
                    <li><a href="/company/goldenTime/list"><i class="fas fa-hourglass-start"></i>&nbsp;&nbsp;골든타임관리</a></li>
                </ul>
            </aside>
            <main id="main" class="main" style="min-height:600px;">
                <div class="breadcrumb">
                    <ul class="breadcrumb-list">
                        <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i> </li>
                        <li>&nbsp;&nbsp;&nbsp;마이페이지</li>
                    </ul>
                </div>
                <section class="update-info-sec">
                    <h1>회원정보수정</h1>
                    <div class="update-form-sec">
                        <form action="updateInfo" method="post">
                            <div class="reg-form-container">
                                <div class="reg-form-item">
                                    <label style="font-size: 12px;" for="email" title="이메일">
                                        <em style="color: red;">*</em>
                                        이메일
                                    </label>
                                    <div class="input-box">
                                        <div>
                                            <input type="email" value="${c.email }" disabled class="email"  
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
                                <div class="reg-form-item">
                                    <label style="font-size: 12px;" for="password-check" title="비밀번호확인">
                                        <em style="color: red;">*</em>
                                        비밀번호확인
                                    </label>
                                    <div class="input-box">
                                        <div>
                                            <input type="password" class="password-check" 
                                            placeholder="비밀번호확인" id="password-check" autocorrect="off" 
                                            autocapitalize="off" autocomplete="off" aria-autocomplete="none" inputmode="text">
                                            <span class="caution-mention">비밀번호가 일치하지 않습니다</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="reg-form-item">
                                    <label style="font-size: 12px;" for="name" title="이름">
                                        <em style="color: red;">*</em>
                                        이름
                                    </label>
                                    <div class="input-box">
                                        <div>
                                            <input type="text" value="${c.name }" disabled class="name" 
                                            placeholder="이름" id="name" autocorrect="off" 
                                            autocapitalize="off" autocomplete="off" aria-autocomplete="none" inputmode="text">
                                            <span class="caution-mention">한글 이름만 허용됩니다</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="reg-form-item">
                                    <label style="font-size: 12px;" for="birthday" title="생년월일">
                                        <em style="color: red;">*</em>
                                        생년월일
                                    </label>
                                    <div class="input-box">
                                        <div>
                                            <input type="text" disabled class="birthday" value="${c.birthday }"
                                            placeholder="휴대폰번호" id="birthday" autocorrect="off" 
                                            autocapitalize="off" autocomplete="off" aria-autocomplete="none" inputmode="text">
                                            <span class="caution-mention">휴대폰번호를 정확히 입력해주세요</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="reg-form-item">
                                    <label style="font-size: 12px;" for="phone" title="연락처">
                                        <em style="color: red;">*</em>
                                        연락처
                                    </label>
                                    <div class="input-box">
                                        <div>
                                            <input type="tel" class="phone check-validation" 
                                            placeholder="휴대폰번호" id="phone" autocorrect="off" 
                                            autocapitalize="off" autocomplete="off" aria-autocomplete="none" inputmode="text">
                                            <span class="caution-mention">휴대폰번호를 정확히 입력해주세요</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="reg-form-item">
                                    <label style="font-size: 12px;" for="checkbox-2" title="회원구분">
                                        <em style="color: red;">*</em>
                                        회원구분
                                    </label>
                                    <div>
                                        <div class="member-type">
                                            <div class="checkbox-container">
                                                <input name="member-type" type="radio" id="checkbox-2" value="회원" class="checkbox" disabled required>
                                                <label for="checkbox-2"><span></span></label>
                                            </div>
                                            <div>
                                                개인회원
                                            </div>
                                            <div class="checkbox-container">
                                                <input name="member-type" type="radio" id="checkbox-3" value="업체" class="checkbox" checked disabled required>
                                                <label for="checkbox-3"><span></span></label>
                                            </div>
                                            <div>
                                                기업회원
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="button-submit">
                                <input class="disabled" disabled type="submit" value="수정하기">
                            </div>
                        </form>
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
                        <a href="">회원정보수정</a>
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
                    <h1>회원정보수정</h1>
                    <form action="">
                        <table>
                            <tr>
                                <td>이메일</td>
                                <td colspan="2"><span>등록된 이메일정보</span></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>이름</td>
                                <td><span>등록된 이름정보</span></td>
                                <td><input type="button" value="개명신청"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>닉네임</td>
                                <td colspan="2"><input type="text"></td>
                                <td><input type="button" value="중복확인"></td>
                            </tr>
                            <tr>
                                <td>비밀번호</td>
                                <td colspan="2"><input type="text"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>비밀번호확인</td>
                                <td colspan="2"><input type="text"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>연락처</td>
                                <td colspan="2"><input type="text"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>회원구분</td>
                                <td colspan="3"><input type="radio" name="memtype">개인회원 <input type="radio"
                                        name="memtype">기업회원</td>
                            </tr>
                            <tr>
                                <td colspan="4"><input type="submit" value="수정하기"></td>
                            </tr>
                        </table>
                    </form>
                </section>
            </div>
        </main>
    </section> -->

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

                <p><b>고객행복센터 1577-8282</b> 오전 09:00 ~ 오후18:00</p>

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
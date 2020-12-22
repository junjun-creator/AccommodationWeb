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
    <link rel="stylesheet" href="../../css/user/userInfo/updateInfo.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
	<script src="/js/user/userInfo/updateInfo.js"></script>
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
                    <li><a href="/user/offer/reg">제안하기</a></li>
                    <li><a href="/user/reservation/reservationInfo">예약내역</a></li>
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
                    <li class="active"><a href="memberInfo"><i class="far fa-user-circle"></i>&nbsp;&nbsp;회원정보수정</a></li>
                    <li><a href="/user/reservation/reservationInfo"><i class="far fa-calendar-check"></i>&nbsp;&nbsp;예약관리</a></li>
                    <li><a href="offerList"><i class="fas fa-file-upload"></i>&nbsp;&nbsp;제안신청관리</a></li>
                    <li><a href="pickList"><i class="fas fa-hand-holding-heart"></i>&nbsp;&nbsp;찜한상품조회</a></li>
                </ul>
            </aside>
            <main id="main" class="main">
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
                                            <input type="email" value="${u.email }" disabled class="email"  
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
                                            <input type="text" value="${u.name }" disabled class="name" 
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
                                            <input type="text" disabled class="birthday" value="${u.birthday }"
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
                                                <input name="member-type" type="radio" id="checkbox-2" value="회원" class="checkbox" checked disabled required>
                                                <label for="checkbox-2"><span></span></label>
                                            </div>
                                            <div>
                                                개인회원
                                            </div>
                                            <div class="checkbox-container">
                                                <input name="member-type" type="radio" id="checkbox-3" value="업체" class="checkbox" disabled required>
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

    <script>
        /* var regExp_list = [/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]+$/i,
                        /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/,
                        /^[가-힣]+$/,
                        /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/
                        ];
        var checkbox = document.querySelectorAll('.checkbox');
        var button_submit = document.querySelector('.button-submit').firstElementChild;
        var inputAll = document.querySelectorAll('.check-validation');
        
        // 이메일 유효성 검사
        var email_input = document.querySelector('.email');
        var input_box_email = email_input.parentNode.parentNode;
        email_input.addEventListener("change", function(){
            var regExp =  /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]+$/i;
            if(regExp.test(email_input.value)){
                email_input.classList.add('pass');
                input_box_email.classList.remove('discorrect');
            }else{
                if(email_input.classList.contains('pass'))
                    email_input.classList.remove('pass');
                    input_box_email.classList.add('discorrect');
            }

            var count_validation = 0;
            for(var i=0;i<inputAll.length;i++){
                if(regExp_list[i].test(inputAll[i].value)){
                    count_validation++;
                }
            }
            if(count_validation == 4 &&
            password_input.value == password_check_input.value &&
            (checkbox[0].checked || checkbox[1].checked)){
                button_submit.classList.remove('disabled');
                button_submit.disabled = false;
            }
            else{
                button_submit.classList.add('disabled');
                button_submit.disabled = true;
            }
        });

        email_input.addEventListener("keydown",function(){
            var regExp =  /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]+$/i;
            if(regExp.test(email_input.value)){
                email_input.classList.add('pass');
                input_box_email.classList.remove('discorrect');
            }
            else{
                if(email_input.classList.contains('pass'))
                    email_input.classList.remove('pass');
                    input_box_email.classList.add('discorrect');
            }
        });
        email_input.addEventListener("keyup",function(){
            var regExp =  /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]+$/i;
            if(regExp.test(email_input.value)){
                email_input.classList.add('pass');
                input_box_email.classList.remove('discorrect');
            }
            else{
                if(email_input.classList.contains('pass'))
                    email_input.classList.remove('pass');
                    input_box_email.classList.add('discorrect');
            }

            var count_validation = 0;
            for(var i=0;i<inputAll.length;i++){
                if(regExp_list[i].test(inputAll[i].value)){
                    count_validation++;
                }
            }
            if(count_validation == 4 &&
            password_input.value == password_check_input.value &&
            (checkbox[0].checked || checkbox[1].checked)){
                button_submit.classList.remove('disabled');
                button_submit.disabled = false;
            }
            else{
                button_submit.classList.add('disabled');
                button_submit.disabled = true;
            }
        });

        //비밀번호 유효성 검사
        var password_input = document.querySelector('.password');
        var input_box_password = password_input.parentNode.parentNode;
        password_input.addEventListener("change", function(){
            var regExp =  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
            if(regExp.test(password_input.value)){
                password_input.classList.add('pass');
                input_box_password.classList.remove('discorrect');
            }else{
                if(password_input.classList.contains('pass'))
                    password_input.classList.remove('pass');
                    input_box_password.classList.add('discorrect');
            }

            var count_validation = 0;
            for(var i=0;i<inputAll.length;i++){
                if(regExp_list[i].test(inputAll[i].value)){
                    count_validation++;
                }
            }
            if(count_validation == 4 &&
            password_input.value == password_check_input.value &&
            (checkbox[0].checked || checkbox[1].checked)){
                button_submit.classList.remove('disabled');
                button_submit.disabled = false;
            }
            else{
                button_submit.classList.add('disabled');
                button_submit.disabled = true;
            }
        });

        password_input.addEventListener("keyup",function(){
            var regExp =  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
            if(regExp.test(password_input.value)){
                password_input.classList.add('pass');
                input_box_password.classList.remove('discorrect');
            }
            else{
                if(password_input.classList.contains('pass'))
                    password_input.classList.remove('pass');
                    input_box_password.classList.add('discorrect');
            }

            var count_validation = 0;
            for(var i=0;i<inputAll.length;i++){
                if(regExp_list[i].test(inputAll[i].value)){
                    count_validation++;
                }
            }
            if(count_validation == 4 &&
            password_input.value == password_check_input.value &&
            (checkbox[0].checked || checkbox[1].checked)){
                button_submit.classList.remove('disabled');
                button_submit.disabled = false;
            }
            else{
                button_submit.classList.add('disabled');
                button_submit.disabled = true;
            }
        });
        password_input.addEventListener("keydown",function(){
            var regExp =  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
            if(regExp.test(password_input.value)){
                password_input.classList.add('pass');
                input_box_password.classList.remove('discorrect');
            }
            else{
                if(password_input.classList.contains('pass'))
                    password_input.classList.remove('pass');
                    input_box_password.classList.add('discorrect');
            }
        });

        //비밀번호 확인 유효성 검사
        var password_check_input = document.querySelector('.password-check');
        var input_box_password_check = password_check_input.parentNode.parentNode;

        password_check_input.addEventListener("change", function(){
            if(password_input.value == password_check_input.value){
                password_check_input.classList.add('pass');
                input_box_password_check.classList.remove('discorrect');
            }else{
                if(password_check_input.classList.contains('pass'))
                    password_check_input.classList.remove('pass');
                    input_box_password_check.classList.add('discorrect');
            }

            var count_validation = 0;
            for(var i=0;i<inputAll.length;i++){
                if(regExp_list[i].test(inputAll[i].value)){
                    count_validation++;
                }
            }
            if(count_validation == 4 &&
            password_input.value == password_check_input.value &&
            (checkbox[0].checked || checkbox[1].checked)){
                button_submit.classList.remove('disabled');
                button_submit.disabled = false;
            }
            else{
                button_submit.classList.add('disabled');
                button_submit.disabled = true;
            }
        });

        password_check_input.addEventListener("keyup",function(){
            if(password_input.value == password_check_input.value){
                password_check_input.classList.add('pass');
                input_box_password_check.classList.remove('discorrect');
            }
            else{
                if(password_check_input.classList.contains('pass'))
                    password_check_input.classList.remove('pass');
                    input_box_password_check.classList.add('discorrect');
            }

            var count_validation = 0;
            for(var i=0;i<inputAll.length;i++){
                if(regExp_list[i].test(inputAll[i].value)){
                    count_validation++;
                }
            }
            if(count_validation == 4 &&
            password_input.value == password_check_input.value &&
            (checkbox[0].checked || checkbox[1].checked)){
                button_submit.classList.remove('disabled');
                button_submit.disabled = false;
            }
            else{
                button_submit.classList.add('disabled');
                button_submit.disabled = true;
            }
        });
        password_check_input.addEventListener("keydown",function(){
            if(password_input.value == password_check_input.value){
                password_check_input.classList.add('pass');
                input_box_password_check.classList.remove('discorrect');
            }
            else{
                if(password_check_input.classList.contains('pass'))
                    password_check_input.classList.remove('pass');
                    input_box_password_check.classList.add('discorrect');
            }
        });

        //이름 유효성 검사
        var name_input = document.querySelector('.name');
        var input_box_name = name_input.parentNode.parentNode;
        name_input.addEventListener("change", function(){
            var regExp = /^[가-힣]+$/;
            if(regExp.test(name_input.value)){
                name_input.classList.add('pass');
                input_box_name.classList.remove('discorrect');
            }else{
                if(name_input.classList.contains('pass'))
                    name_input.classList.remove('pass');
                    input_box_name.classList.add('discorrect');
            }

            var count_validation = 0;
            for(var i=0;i<inputAll.length;i++){
                if(regExp_list[i].test(inputAll[i].value)){
                    count_validation++;
                }
            }
            if(count_validation == 4 &&
            password_input.value == password_check_input.value &&
            (checkbox[0].checked || checkbox[1].checked)){
                button_submit.classList.remove('disabled');
                button_submit.disabled = false;
            }
            else{
                button_submit.classList.add('disabled');
                button_submit.disabled = true;
            }
        });

        name_input.addEventListener("keyup",function(){
            var regExp =  /^[가-힣]+$/;
            if(regExp.test(name_input.value)){
                name_input.classList.add('pass');
                input_box_name.classList.remove('discorrect');
            }
            else{
                if(name_input.classList.contains('pass'))
                    name_input.classList.remove('pass');
                    input_box_name.classList.add('discorrect');
            }

            var count_validation = 0;
            for(var i=0;i<inputAll.length;i++){
                if(regExp_list[i].test(inputAll[i].value)){
                    count_validation++;
                }
            }
            if(count_validation == 4 &&
            password_input.value == password_check_input.value &&
            (checkbox[0].checked || checkbox[1].checked)){
                button_submit.classList.remove('disabled');
                button_submit.disabled = false;
            }
            else{
                button_submit.classList.add('disabled');
                button_submit.disabled = true;
            }
        });
        name_input.addEventListener("keydown",function(){
            var regExp =  /^[가-힣]+$/;
            if(regExp.test(name_input.value)){
                name_input.classList.add('pass');
                input_box_name.classList.remove('discorrect');
            }
            else{
                if(name_input.classList.contains('pass'))
                    name_input.classList.remove('pass');
                    input_box_name.classList.add('discorrect');
            }
        });

        //연락처 유효성 검사
        var phone_input = document.querySelector('.phone');
        var input_box_phone = phone_input.parentNode.parentNode;
        phone_input.addEventListener("change", function(){
            var regExp =  /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
            if(regExp.test(phone_input.value)){
                phone_input.classList.add('pass');
                input_box_phone.classList.remove('discorrect');
            }else{
                if(phone_input.classList.contains('pass'))
                    phone_input.classList.remove('pass');
                    input_box_phone.classList.add('discorrect');
            }

            var count_validation = 0;
            for(var i=0;i<inputAll.length;i++){
                if(regExp_list[i].test(inputAll[i].value)){
                    count_validation++;
                }
            }
            if(count_validation == 4 &&
            password_input.value == password_check_input.value &&
            (checkbox[0].checked || checkbox[1].checked)){
                button_submit.classList.remove('disabled');
                button_submit.disabled = false;
            }
            else{
                button_submit.classList.add('disabled');
                button_submit.disabled = true;
            }
        });

        phone_input.addEventListener("keyup",function(){
            var regExp =  /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
            if(regExp.test(phone_input.value)){
                phone_input.classList.add('pass');
                input_box_phone.classList.remove('discorrect');
            }
            else{
                if(phone_input.classList.contains('pass'))
                    phone_input.classList.remove('pass');
                    input_box_phone.classList.add('discorrect');
            }

            var count_validation = 0;
            for(var i=0;i<inputAll.length;i++){
                if(regExp_list[i].test(inputAll[i].value)){
                    count_validation++;
                }
            }
            if(count_validation == 4 &&
            password_input.value == password_check_input.value &&
            (checkbox[0].checked || checkbox[1].checked)){
                button_submit.classList.remove('disabled');
                button_submit.disabled = false;
            }
            else{
                button_submit.classList.add('disabled');
                button_submit.disabled = true;
            }
        });
        phone_input.addEventListener("keydown",function(){
            var regExp =  /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
            if(regExp.test(phone_input.value)){
                phone_input.classList.add('pass');
                input_box_phone.classList.remove('discorrect');
            }
            else{
                if(phone_input.classList.contains('pass'))
                    phone_input.classList.remove('pass');
                    input_box_phone.classList.add('discorrect');
            }
        });

        for(var j=0;j<checkbox.length;j++){
            (function(m){
                checkbox[m].addEventListener("click",function(){
                    var count_validation = 0;
                    for(var i=0;i<inputAll.length;i++){
                        if(regExp_list[i].test(inputAll[i].value)){
                            count_validation++;
                        }
                    }
                    if(count_validation == 4 &&
                    password_input.value == password_check_input.value &&
                    (checkbox[0].checked || checkbox[1].checked)){
                        button_submit.classList.remove('disabled');
                        button_submit.disabled = false;
                    }
                    else{
                        button_submit.classList.add('disabled');
                        button_submit.disabled = true;
                    }
                });
            })(j);
        } */
    </script>
</body>

</html>
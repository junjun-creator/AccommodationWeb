<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../css/reset.css">
    <link rel="stylesheet" href="../../../css/layout.css">
    <link rel="stylesheet" href="../../../css/admin/layout.css">
    <link rel="stylesheet" href="../../../css/admin/userInfo/list.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <title>업체 상세</title>
</head>
<body>
    <header class="sec-header-page">
        <section class="header-sec pcHeader">
            <div class="header-logo">
                <h1><a class="teum-logo" href="http://127.0.0.1:5500/main.html">틈</a></h1>
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

    <section class="body">
        <aside id="aside" class="aside">
            <h1>회원관리</h1>
                <ul>
                    <li><a href="">개인회원리스트</a></li>
                    <li class="active"><a href="">기업회원리스트</a></li>
                </ul>
        </aside>
        <div class="container">
            <nav id="nav" class="nav">
                <ul>
                    <li><a href=""><i class="fas fa-hotel"></i><span>업체관리</span></a></li>
                    <li class="current-tab"><a href=""><i class="fas fa-user-circle"></i><span>회원관리</span></a></li>
                    <li><a href=""><i class="far fa-calendar-alt"></i><span>프로모션관리</span></a></li>
                    <li><a href=""><i class="fas fa-headphones"></i><span>고객센터</span></a></li>
                </ul>
            </nav>
            <main id="main" class="main">
                <div class="sub-container">
                    <div class="breadcrumb">
                        <ul class="breadcrumb-list">
                            <li><i class="fas fa-home"></i>HOME ▶ </li>
                            <li>회원관리 ▶ </li>
                            <li>개인회원리스트</li>
                        </ul>
                    </div>

                    <div class="user-info-member">
                        <h1>${member.name } 님</h1>
                    </div>
                    <!-- 다이아몬드 이런건 나중에 스크립트로 요청 정보 읽어서 등급에 맞게 클래스 이름만 setAttribute 해주면 될듯 -->
                    <div class="list-board">
                        <table>
                            <thead>
                                <tr>
                                    <td class="col-m">이메일</td>
                                    <td class="col-sm">회원구분</td>
                                    <td class="col-m">연락처</td>
                                    <td class="col-sm">생년월일</td>
                                    <td class="col-m">등록일</td>
                                    
                                </tr>
                            </thead>
                            <tbody>
                                    <td class="col-m">${member.email }</td>
                                    <td class="col-sm">${member.type }</td>
                                    <td class="col-m">${member.phone }</td>
                                    <td class="col-sm">${member.birthday }</td>
                                    <td class="col-m">${member.regdate }</td>
                            </tbody>
                        </table>
                    </div>

                    <div>
                        <h1>보유 숙소</h1>
                        <!-- <select name="" id="">
                            <option value="">전체</option>
                            <option value="">완료</option>
                            <option value="">취소</option>
                            <option value="">예약중</option>
                        </select> -->
                    </div>
                    <section class="list-board">
                            <table>
                                <thead>
                                    <tr>
                                        <td class="col-s">No.</td>
                                        <td class="col-m">숙소명</td>
                                        <td class="col-l">주소</td>
                                        <td class="col-m">숙소번호</td>
                                        <td class="col-m">등록일</td>
                                        <td class="col-sm">비고</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="col-s">1</td>
                                        <td class="col-m">삼성 신라호텔</td>
                                        <td class="col-l">jun</td>
                                        <td class="col-m">010-2222-3333</td>
                                        <td class="col-m">2020-01-11</td>
                                        <td class="col-sm"><input type="button" value="상세보기"></td>
                                    </tr>
                                    <tr>
                                        <td class="col-s">1</td>
                                        <td class="col-m">삼성 신라호텔</td>
                                        <td class="col-l">jun</td>
                                        <td class="col-m">010-2222-3333</td>
                                        <td class="col-m">2020-01-11</td>
                                        <td class="col-sm"><input type="button" value="상세보기"></td>
                                    </tr>
                                    
                                </tbody>
                            </table>
                    </section>

                    <div>
                        <h1>승인 대기중 숙소</h1>
                        <!-- <select name="" id="">
                            <option value="">전체</option>
                            <option value="">완료</option>
                            <option value="">취소</option>
                            <option value="">예약중</option>
                        </select> -->
                    </div>
                    <section class="list-board">
                        <table>
                            <thead>
                                <tr>
                                    <td class="col-s">No.</td>
                                    <td class="col-m">숙소명</td>
                                    <td class="col-l">주소</td>
                                    <td class="col-m">숙소번호</td>
                                    <td class="col-m">등록일</td>
                                    <td class="col-sm">비고</td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="col-s">1</td>
                                    <td class="col-m">삼성 신라호텔</td>
                                    <td class="col-l">jun</td>
                                    <td class="col-m">010-2222-3333</td>
                                    <td class="col-m">2020-01-11</td>
                                    <td class="col-sm"><input type="button" value="상세보기"></td>
                                </tr>
                                <tr>
                                    <td class="col-s">1</td>
                                    <td class="col-m">삼성 신라호텔</td>
                                    <td class="col-l">jun</td>
                                    <td class="col-m">010-2222-3333</td>
                                    <td class="col-m">2020-01-11</td>
                                    <td class="col-sm"><input type="button" value="상세보기"></td>
                                </tr>
                                
                            </tbody>
                        </table>
                    </section>

                    <section class="user-info-btn">
                        <input type="button" value="목록">
                        <input type="button" value="삭제">
                    </section>
                </div>
            </main>
        </div>
    </section>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/reset.css">
    <link rel="stylesheet" href="/css/layout.css">
    <link rel="stylesheet" href="../css/notice/list.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <script src="../../js/notice/list.js"></script>
    <title>TEUM | 틈을 채우다</title>
</head>
<body>
  <jsp:include page="/inc/header.jsp"/>
    <section class="container-sec">
        <div class="container">
            <aside id="aside" class="aside">
                <h1 class="d-none">게시판</h1>
                <ul>
                   <li class="active"><a href="list"><i class="fas fa-exclamation-circle"></i>&nbsp;&nbsp;&nbsp;&nbsp;공지사항</a></li>
                    <li><a href="/event/list"><i class="far fa-calendar-check"></i>&nbsp;&nbsp;&nbsp;&nbsp;이벤트</a></li>
                    <li><a href="/user/qna"><i class="far fa-question-circle"></i>&nbsp;&nbsp;&nbsp;&nbsp;Q&A</a></li>
                </ul>
            </aside>
            <main id="main" class="main">
                <h1 class="d-none">공지사항</h1>
                <div class="breadcrumb">
                    <ul class="breadcrumb-list">
                        <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i> </li>
                        <li>&nbsp;&nbsp;&nbsp;NOTICE</li>
                    </ul>
                </div>
                <section class="notice-sec">
                    <h1>공지사항 /
                        <span>Notice</span>
                    </h1>
                    
                    <ol class="notice-sec-list">
                    <c:forEach var="n" items="${list}" varStatus="status">
                        <li>
                            <input type="checkbox" id="${status.index}" class="checkbox" name="check" onclick="doOpenCheck(this);">
                            <div>
                                <p>${n.title}</p>
                                <p class="p-detail" style=" font-size: 11pt;">
                                	${n.content}
                                </p>
                                <p>${n.regdate}</p>
                            </div>
                            <p>Master</p>
                            <label for="${status.index}"><span></span></label>
                        </li>
                        </c:forEach>
                    </ol>
                </section>
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
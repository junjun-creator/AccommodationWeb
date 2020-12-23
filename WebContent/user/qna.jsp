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
    <link rel="stylesheet" href="/css/user/QnA.css">
     <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
   	<script src="/js/user/qna.js"></script>
    <title>TEUM | 틈을 채우다</title>
</head>
<body>
   <jsp:include page="/inc/header.jsp"/>
    <section  class="container-sec">
        <div class="container">
            <aside id="aside" class="aside">
                <h1 class="d-none">문의사항</h1>
                <ul>
                	 <li><a href="/notice/list"><i class="fas fa-exclamation-circle"></i>&nbsp;&nbsp;&nbsp;&nbsp;공지사항</a></li>
	                 <li><a href="/event/list"><i class="far fa-calendar-check"></i>&nbsp;&nbsp;&nbsp;&nbsp;이벤트</a></li>
	                 <li class="active"><a href="QnA"><i class="far fa-question-circle"></i>&nbsp;&nbsp;&nbsp;&nbsp;Q&A</a></li>
            	</ul>
            </aside>
            <main id="main" class="main">
                <div class="breadcrumb">
                    <ul class="breadcrumb-list">
                         <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i> </li>
                        <li>&nbsp;&nbsp;&nbsp;QnA</li>
                    </ul>
                </div>
                
                <section class="qna-sec">
                    <h1>1대1 문의사항 /
                   			 <span>QnA<span>
                    </h1>
                    <section class="change-tap">
                        <h1 class="d-none">체인지 탭</h1>
                        <ul class="change-list">
                            <li class="current-tab myQnA">
                              	<a>내 문의</a>
                            </li>
                            <li>
                               <a>문의하기</a>
                            </li>
                        </ul>
                    </section>
                    <div class="section">
	                   <section class="qna-list">
	                        <h1 class="d-none">내 문의 리스트</h1>
	                        <ol class="qna-sec-list">
	                        <c:forEach var="q" items="${list}" varStatus="status">
	                           <li>
	                             <input type="checkbox" id="${status.index}" class="checkbox" name="check" onclick="doOpenCheck(this);">
	                                <div>
	                                    <p>${q.title}</p>
	                                    <p class="p-detail">${q.answerContent}</p>
	                                    <p>${q.answerRegdate}</p>
	                                </div>
	                                <p>Master</p>
	                                <label for="${status.index}"><span></span></label>
	                            </li>
	                             </c:forEach>
	                        </ol>
	                    </section>
	                    <section class="qna-creat" style="display:none">
	                        <h1 class="d-none">문의 작성</h1>
	                       <form action="QnA" method="post">
	                           <select name="category" id="" class="category" >
		                                <option value="" selected disabled>전체</option>
		                                <option value="1"  ${(param.category=="1")?"selected":"" }>이벤트</option>
		                                <option value="2"  ${(param.category=="2")?"selected":"" }>예약/결제</option>
		                                <option value="3"  ${(param.category=="3")?"selected":"" }>취소/환불</option>
		                                <option value="4"  ${(param.category=="4")?"selected":"" }>서비스 이용</option>
		                                <option value="5"  ${(param.category=="5")?"selected":"" }>회원/개인정보</option>
		                                <option value="6"  ${(param.category=="6")?"selected":"" }>리뷰</option>
		                                <option value="7"  ${(param.category=="7")?"selected":"" }>기타</option>
			                        </select>
			                     <input type="text"  name="title"placeholder="제목을 적어주세요." required autofocus>  
	                            <textarea name="content" cols="50" rows="10" placeholder="문의할 내용을 적어주세요." required autofocus></textarea>
	                            <input type="submit" value="보내기" >
	                        </form>
	                    </section>
                    </div>
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
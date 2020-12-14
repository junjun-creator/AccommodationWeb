<%@page import="java.util.List"%>
<%@page import="com.teum.service.QnAService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/reset.css" type="text/css">
    <link rel="stylesheet" href="/css/layout.css">
    <link rel="stylesheet" href="/css/admin/layout.css">
    <link rel="stylesheet" href="/css/admin/QnA/list.css">
     <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <script src="/js/admin/customerService/notice/list.js" type="text/javascript"></script>
    <title>TEUM | 틈을 채우다</title>
</head>
<body>
   <header class="sec-header-page">
        <section class="header-sec pcHeader">
            <div class="header-logo">
                <h1><a class="teum-logo" href="http://127.0.0.1:5500/main.html">틈</a></h1>
            </div>
            <div>
                <ul class="main-menu">
                    <li class="header_search"><input type="text"><a href=""><i class="fas fa-search"></i></a></li>
                    <li><a href="">제안하기</a></li>
                    <li><a href="">예약내역</a></li>
                    <li><a href="">더보기</a></li>
                    <li class="mypage"><a href="">로그인</a>
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
	            <h1>고객센터</h1>
	                <ul>
	                    <li><a href="/admin/customerService/notice/list">공지사항</a></li>
	                    <li><a href="" class="active">QnA</a></li>
	                </ul>
	        </aside>
	        <div class="container">
	            <nav id="nav" class="nav">
	                <ul>
	                     <li><a href="/admin/accommodations/list"><i class="fas fa-hotel"></i><span>업체관리</span></a></li>
	                    <li><a href="/admin/userInfo/list"><i class="fas fa-user-circle"></i><span>회원관리</span></a></li>
	                    <li><a href="/admin/promotion/goldenTime/list"><i class="far fa-calendar-alt"></i><span>프로모션관리</span></a></li>
	                    <li class="current-tab"><a href="list"><i class="fas fa-headphones"></i><span>고객센터</span></a></li>
	                </ul>
	            </nav>
	            <main id="main" class="main">
	                <h1  class="d-none">문의사항</h1>
	                <section class="sub-container">
	                    <div class="breadcrumb">
	                        <ul class="breadcrumb-list">
	                             <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i> </li>
                        		<li>&nbsp;&nbsp;&nbsp;고객센터&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
	                            <li>&nbsp;&nbsp;&nbsp;QnA</li>
	                        </ul>
	                    </div>
	                    <section class="list-board">
		                   	<div class="main-search">
		                        <h1>문의사항 리스트</h1>
		                        <div>
			                        <select name="" id="" class="catagory">
			                            <form action="">
			                                <option value="" selected disabled>카테고리</option>
			                                <option value="이벤트">이벤트</option>
			                                <option value="예약/결제">예약/결제</option>
			                                <option value="취소/환불">취소/환불</option>
			                                <option value="서비스 이용">서비스 이용</option>
			                                <option value="회원/개인정보">회원/개인정보</option>
			                                <option value="리뷰">리뷰</option>
			                                <option value="기타">기타</option>
			                            </form>
		                                <input type="text">
			                        	<input type="submit" value="검색">
			                        </select>
		                        </div>
	                        </div>
	                        <table>
	                            <thead>
	                                <tr>
	                                    <td class="col-s">No.</td> 
	                                    <td class="col-sm">회원명</td>
	                                    <td class="col-ml">문의제목</td>
	                                    <td class="col-m">연락처</td>
	                                    <td class="col-sm">문의날짜</td>
	                                    <td class="col-s">상태</td>
	                                    <td class="col-s"><input type="checkbox" class="selectAllDelete"></td>
	                                </tr>
	                            </thead>
	                            <tbody>
	                            <c:forEach var="q" items="${list}">
	                            
	                                <tr>
	                                    <td>${q.id}</td>
	                                    <td>${q.userName}</td>
	                                    <td><a href="detail?id=${q.id}">${q.title}</td>
	                                    <td>${q.phone}</td>
	                                    <td>${q.regdate}</td>
	                                    <td>
	                                    	<c:choose>
												<c:when test="${q.answerStatus ==0 }">
													<%="답변안됨" %>
												</c:when>
												<c:otherwise>
					                            	<%="답변됨" %>
					                            </c:otherwise>                           
					                            
				                            </c:choose>
	                            		</td>
	                                    <td>
	                                        <input type="checkbox" name="" class="deleteChk" >
	                                    </td>
	                                </tr>
	                             </c:forEach>
	                                <tr class="btn-delete">
	                                    <td colspan="8">
	                                        <form action="">
	                                            <input type="submit" value="답변">
	                                            <input type="submit" value="삭제">
	                                        </form>
	                                    </td>
	                                </tr>
	                            </tbody>
	                        </table>
                    	</section>
                    </section>
                    <section>
                        <h1 class="d-none">페이지 정보</h1>
                        <div>
                            1 / 2 pages
                        </div>
                    </section>
                    <section>
                        <h1 class="d-none">페이지 요청목록</h1>
                        <ul>
                            <li>1</li>
                            <li>2</li>
                        </ul>
                    </section>
            	</main>
	        </div>
	    </section>
   </main>
</body>
</html>
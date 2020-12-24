<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" href="/images/logo.png">
	<link rel="stylesheet" href="/css/reset.css">
	<link rel="stylesheet" href="/css/layout.css">
    <link rel="stylesheet" href="/css/admin/layout.css">
	<link rel="stylesheet" href="/css/admin/promotion/event/detail.css">
	<link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <title>프로모션관리 | 틈을 채우다</title>
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

	<main>
	    <section class="body">
	        <aside id="aside" class="aside">
	            <h1>프로모션 관리</h1>
	                <ul>
	                    <li><a href="/admin/promotion/goldenTime/list">골든타임 관리</a></li>
	                    <li class="active"><a href="/admin/promotion/event/list">이벤트 관리</a></li>
	                </ul>
	        </aside>
	        <div class="container">
	            <nav id="nav" class="nav">
	                <ul>
	                    <li><a href="/admin/accommodations/list"><i class="fas fa-hotel"></i><span>업체관리</span></li></a>
	                    <li><a href="/admin/userInfo/list"><i class="fas fa-user-circle"></i><span> 회원관리</span></a></li>
	                    <li class="current-tab"><a href="/admin/promotion/goldenTime/list"><i class="far fa-calendar-alt"></i><span>프로모션관리</span></a></li>
	                    <li><a href="/admin/customerService/notice/list"><i class="fas fa-headphones"></i><span>고객센터</span></a></li>
	                </ul>
	            </nav>
	            <main id="main" class="main">
	                <div class="sub-container">
	                    <div class="breadcrumb">
	                        <ul class="breadcrumb-list">
                                <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
                                <li>&nbsp;&nbsp;&nbsp;프로모션 관리&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
                                <li>&nbsp;&nbsp;&nbsp;이벤트 관리&nbsp;&nbsp;&nbsp;</li>
                            </ul>
	                    </div>
	                    <section class="img-sec">
	                        <div class="img-container">
	                        	<c:forTokens var="imageName" items="${currEvent.imageName}" delims="," varStatus="st">
	                        		<c:if test="${st.last == true}">
	                        			<img src="/images/event/2020/${currEvent.id}/${imageName}">
	                        		</c:if>
	                        	</c:forTokens>
	                            
	                        </div>
	                    </section>
	                    <div class="btns-container">
                            <button class="btn btn-edit" onclick="location.href='edit?id=${currEvent.id}'">수정</button>
                            <button class="btn btn-delete" onclick="location.href='delete?id=${currEvent.id}'">삭제</button>
                        </div>
	                    <section class="page-list-sec">
	                    	
	                    	<c:choose>
	                    		<c:when test="${prevEvent == null && nextEvent == null}">
	                    			<!-- 아무런 출력이 없어야함 -->
	                    		</c:when>
	                    		<c:when test="${prevEvent == null}">
	                    			<div class="page next-page">
			                            <a href="detail?id=${nextEvent.id}">
			                                <span class="page-direction">다음글</span>
			                                <span class="page-title">${nextEvent.title}</span>
			                                <span class="page-date">기간: ${nextEvent.startDate} ~ ${nextEvent.endDate}</span>
			                            </a>
			                        </div>
	                    		</c:when>
	                    		<c:when test="${nextEvent == null}">
	                    			<div class="page prev-page">
			                            <a href="detail?id=${prevEvent.id}">
			                                <span class="page-direction">이전글</span>
			                                <span class="page-title">${prevEvent.title}</span>
			                                <span class="page-date">기간: ${prevEvent.startDate} ~ ${prevEvent.endDate}</span>
			                            </a>
		                        	</div>
	                    		</c:when>
	                    		<c:otherwise>
		                    		<div class="page prev-page">
			                            <a href="detail?id=${prevEvent.id}">
			                                <span class="page-direction">이전글</span>
			                                <span class="page-title">${prevEvent.title}</span>
			                                <span class="page-date">기간: ${prevEvent.startDate} ~ ${prevEvent.endDate}</span>
			                            </a>
		                        	</div>
			                		<div class="page next-page">
			                            <a href="detail?id=${nextEvent.id}">
			                                <span class="page-direction">다음글</span>
			                                <span class="page-title">${nextEvent.title}</span>
			                                <span class="page-date">기간: ${nextEvent.startDate} ~ ${nextEvent.endDate}</span>
			                            </a>
			                        </div>
	                    		</c:otherwise>
	                    	</c:choose>
	                    	
	                        <div class="btn-container">
	                            <button class="btn-list" onclick="location.href='list'">목록보기</button>
	                        </div>
	                    </section>
	                </div>
	            </main>
	        </div>
	    </section>
	</main>
</body>

</html>
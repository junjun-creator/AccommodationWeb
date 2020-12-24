<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" href="/images/logo.png">
	<link rel="stylesheet" href="/css/reset.css">
	<link rel="stylesheet" href="/css/layout.css">
    <link rel="stylesheet" href="/css/admin/layout.css">
	<link rel="stylesheet" href="/css/admin/promotion/event/list.css">
	<link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
	<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
	<script src="/js/admin/promotion/event/list.js"></script>
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
	                    <form action="list" class="search-form">
                            <h1>이벤트 리스트</h1>
                            <div>
                                <input type="text" class="input-search" placeholder="제목을 입력하세요." value="${param.search}" name="search">
                                <input type="submit" class="search-submit-btn" value="검색">
                            </div>
                        </form>
	                    <section>
	                        <form action="list" method="post" class="list-board">
	                        	<input type="hidden" name="id" value="${event.id}">
	                            <table>
	                                <thead>
	                                    <tr>
	                                        <td class="col-s">No.</td>
	                                        <td class="col-s">진행상태</td>
	                                        <td class="col-m">종료일</td>
	                                        <td>제목</td>
	                                        <td class="col-m">작성자</td>
	                                        <td class="col-m">작성일</td>
	                                        <td class="col-s">공개<input type="checkbox" class="open-chk-all"></td>
	                                        <td class="col-s">삭제<input type="checkbox" class="del-chk-all"></td>
	                                    </tr>
	                                </thead>
	                                <tbody>
                                	<c:forEach var="event" items="${list}">
                                		<c:set var="status" value="진행중"/>
										<fmt:formatDate var="today" value="${now}" pattern="yyyy-MM-dd"/>
										<c:if test="${today > event.endDate}">
											<c:set var="status" value="종료"/>
										</c:if>
										<c:set var="open" value=""/> 
                                		<c:if test="${event.openStatus == 1}">
                                			<c:set var="open" value="checked"/>
                                		</c:if>
	                                    <tr>
	                                        <td>${event.rownum}</td>
                                        	<td class="${today > event.endDate ? 'event-end' : 'event-ing'}">${status}</td>
	                                        <td>${event.endDate}</td>
	                                        <td class="text-left text-short"><a href="detail?id=${event.id}">${event.title}</a></td>
	                                        <td>관리자</td>
	                                        <td>${event.startDate}</td>
	                                        
	                                        <td><input type="checkbox" name="open-id" ${open} value="${event.id}" class="open-chk"></td>
	                                        <td><input type="checkbox" name="del-id" value="${event.id}" class="del-chk"></td>
	                                    </tr>
                                     </c:forEach>
	                                    
	                                    <tr>
	                                        <td colspan="8" class="no-border btn-row">
	                                        	<c:set var="ids" value=""/>
	                                        	<c:forEach var="event" items="${list}">
	                                        		<c:set var="ids" value="${ids} ${event.id}"/>
	                                        	</c:forEach>
	                                        	<input type="hidden" name="ids" value="${ids}">
	                                            <input type="button" onclick="location.href='reg'" value="글쓰기">
	                                            <input type="submit" class="open-btn" name="cmd" value="일괄공개">
	                                            <input type="submit" class="del-btn" name="cmd" value="일괄삭제">
	                                        </td>
	                                    </tr>
	                                    <tr>
	                                    	<c:set var="page" value="${(empty param.p) ? 1 : param.p}"/>
	                                    	<c:set var="startNum" value="${page - (page - 1) % 5}"/>
	                                    	<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count / 10), '.')}"/>
	                                    	<td colspan="8" class="no-border">
	                                    		<div class="pager-container">
						                            <div class="btn btn-prev">
					                            	<c:if test="${startNum > 1}">
						                            	<span><a href="?p=${startNum - 1}&search=">이전</a></span>
					                            	</c:if>
					                            	<c:if test="${startNum <= 1}">
						                            	<span><a href="?p=${startNum - 1}&search=" onclick="alert('이전 페이지가 없습니다.')">이전</a></span>
					                            	</c:if>
						                            </div>
						                            
						                            <ul class="pager-list">
					                            	<c:forEach var="i" begin="0" end="4">
						                            	<c:if test="${(startNum + i) <= lastNum}">
						                            		<li class="${(page == (startNum + i)) ? 'active-page' : ''}">
							                                	<a href="?p=${startNum + i}&search=${param.search}">${startNum + i}</a>
							                                </li>
							                            </c:if>
				                            		</c:forEach>
						                            </ul>
						                            
						                            <div class="btn btn-next">
					                                <c:if test="${startNum + 4 < lastNum}">
						                            	<span><a href="?p=${startNum + 5}&search=">다음</a></span>
					                            	</c:if>
					                            	<c:if test="${startNum + 4 >= lastNum}">
						                            	<span><a href="?p=${startNum + 5}&search=" onclick="alert('다음 페이지가 없습니다.')">다음</a></span>
					                            	</c:if>
						                            </div>
						                       	</div>
	                                    	</td>
	                                    </tr>
	                                </tbody>
	                            </table>
	                        </form>
	                    </section>
	                </div>
	            </main>
	        </div>
	    </section>
	</main>
	
</body>

</html>
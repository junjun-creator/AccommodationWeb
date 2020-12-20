<%@page import="com.teum.entity.Notice"%>
<%@page import="java.util.List"%>
<%@page import="com.teum.service.NoticeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="stylesheet" href="/css/reset.css" type="text/css">
    <link rel="stylesheet" href="/css/layout.css">
    <link rel="stylesheet" href="/css/admin/layout.css">
    <link rel="stylesheet" href="/css/admin/notice/list.css">
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
	            <h1>고객센터</h1>
	                <ul>
	                    <li  class="active"><a href="list" >공지사항</a></li>
	                    <li><a href="/admin/customerService/QnA/list">QnA</a></li>
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
	                <h1 class="d-none">공지사항</h1>
	                <section class="sub-container">
	                    <div class="breadcrumb">
	                        <ul class="breadcrumb-list">
	                            <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i> </li>
                        		<li>&nbsp;&nbsp;&nbsp;고객센터&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
	                            <li>&nbsp;&nbsp;&nbsp;공지사항 리스트</li>
	                        </ul>
	                    </div>
	                    <section class="list-board">
	                       <div class="main-search">
		                        <h1>공지사항 리스트</h1>
		                        <form action="list">
		                        	<input type="hidden" name="page">
									<input type="text" name="query" value="${param.query}">
									<input type="submit" value="검색">
								</form>
	                        </div>
	                        <form action="list" method="post">
	                        <table>
	                            <thead>
	                                <tr>
	                                    <td class="col-s">No.</td>
	                                    <td class="col-m">제목</td>
	                                    <td class="col-sm">날짜</td>
	                                    <td class="col-s">작성자</td>
	                                    <td class="col-s">상태</td>
	                                    <td class="col-s">공개<input type="checkbox" class="selectAllPubs"></td>
	                                    <td class="col-s">삭제<input type="checkbox" class="selectAllDelete"></td>
	                                </tr>
	                            </thead>
	                            <tbody>
	                            	<c:forEach var="n" items="${list}">
	                                <tr>
	                                    <td>${n.num}</td>
	                                    <td class="ellips"><a href="detail?id=${n.id}">${n.title}</a></td>
	                                    <td>${n.regdate}</td>
	                                    <td>관리자</td>
	                                    <td>
	                                    <c:choose>
	                                    	<c:when test="${n.openStatus eq 1}">
	                                    		공개중
	                                    	</c:when>
	                                    	<c:otherwise>
	                                    		비공개
	                                    	</c:otherwise>
	                                    </c:choose>
	                                    
	                                    </td>
	                                    <td>
	                                        <input type="checkbox" name="open-id" value="${n.id}"class=pubChk >
	                                    </td>
	                                    <td>
	                                        <input type="checkbox" name="del-id"  value="${n.id}"class="deleteChk" >
	                                    </td>
	                                </tr>
	                               </c:forEach>
	                                <tr class="btn-delete">
	                                    <td colspan="7">
	                                       		<c:set var="ids" value=""/>
	                                        	<c:forEach var="event" items="${list}">
	                                        		<c:set var="ids" value="${ids} ${n.id}"/>
	                                        	</c:forEach>
	                                        	<input type="hidden" name="ids" value="${ids}">
	                                         	<input type="button" onclick="location.href='reg'" value="생성" style="width:80px; height:25px ;margin: 0 5px 0 5px;">
	                                            <input type="submit" value="공개" name="cmd">
	                                            <input type="submit" value="비공개"name="cmd">
	                                            <input type="submit" value="삭제" name="cmd">
	                                       
	                                    </td>
	                                </tr>
	                                <tr>
											<td colspan="6" class="no-border">
												<div class="pager-container">
													<div class="btn btn-prev">
													<!--<c:set var="pageCnt" value="${fn:substringBefore(Math.ceil(pageCount/3)+1,'.')}"/>-->
													<c:set var="page" value="${(empty param.page)?1:param.page}"/>
													<c:set var="startNum" value="${page-(page-1)%5}" />
													<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(pageCount/3),'.') }" /><!--6-->
														<c:if test="${startNum>1}">
															<a href="list?page=${startNum-1}">이전</a>
														</c:if>
														<c:if test="${startNum<=1}">
															<span onclick="alert('이전 페이지가 없습니다.');">이전</span>
														</c:if>
													</div>
													<ul class="pager-list">
													
													<c:forEach var="i"  begin="0"  end="4">
													<c:if test="${(startNum+i)<=lastNum}">
														<li><a class="${(page==(startNum+i))?'active-page':''}" href="list?page=${startNum+i}&query=${param.query}">${startNum+i}</a></li>
													</c:if>
													</c:forEach>
													</ul>
													<div class="btn btn-next">
														<c:if test="${startNum+5<=lastNum}">
															<a href="list?page=${startNum+5}">다음</a>
														</c:if>
														<c:if test="${startNum+5>lastNum}">
															<span onclick="alert('다음 페이지가 없습니다.');">다음</span>
														</c:if>
													</div>
												</div>
											</td>
										</tr>
	                            </tbody>
	                        </table>
	                        </form>
	                    </section>
	                </section>
	            </main>
	        </div>
	    </section>
    </main>
    
</body>
</html>
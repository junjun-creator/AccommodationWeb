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
	<link rel="stylesheet" href="/css/admin/promotion/event/edit.css">
	<link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <script src="/js/admin/promotion/event/edit.js"></script>
    <title>프로모션관리 | 틈을 채우다</title>
</head>
<body>
    <jsp:include page="/inc/header.jsp"/>

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
	                    <li><a href="/admin/userInfo/users/usersList"><i class="fas fa-user-circle"></i><span> 회원관리</span></a></li>
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
	                    <h1>이벤트 등록</h1>
	                    <section class="form-sec">
	                        <form action="edit" method="post" class="reg-form" enctype="multipart/form-data">
	                        	<c:set var="open" value=""/>
	                        	<c:if test="${event.openStatus == 1}">
	                        		<c:set var="open" value="checked"/>
	                        	</c:if>
	                            <table class="table">
	                                <tr>
	                                    <th class="col-m">제목</th>
	                                    <td class="col-l text-left">
	                                        <input type="text" class="input-title" name="title" value="${event.title}" autofocus required>
	                                        <input type="checkbox" ${open} name="open" value="1" class="checkbox-open"><span>즉시 공개</span>
	                                    </td>
	                                </tr>
	                                <tr>
	                                    <th class="col-m">이벤트 기간</th>
	                                    <td class="col-l text-left">
                                            <input type="date" name="start-date" class="input-date start-date" value="${event.startDate}" required> ~ 
                                            <input type="date" name="end-date" class="input-date end-date" value="${event.endDate}" required>
	                                    </td>
	                                </tr>
	                                <tr>
	                                    <th>첨부파일(타이틀용)</th>
	                                    <td class="text-left">
	                                        <input type="file" name="file" value="/images/event/2020/${event.id}/${event.imageName}" multiple required>
	                                    </td>
	                                </tr>
	                                <tr>
	                                    <th>첨부파일(컨텐츠용)</th>
	                                    <td class="text-left">
	                                        <input type="file" name="file" value="/images/event/2020/${event.id}/${event.imageName}" multiple required>
	                                    </td>
	                                </tr>
	                                <tr>
	                                    <th>내용</th>
	                                    <td class="text-left">
	                                        <textarea class="textarea" cols="75" rows="25"></textarea>
	                                    </td>
	                                </tr>
	                            </table>
	                            <div>
	                            	<input type="hidden" name="id" value="${event.id}">
	                                <button class="btn-cancel" onclick="location.href='detail?id=${event.id}'">취소</button>
	                                <input class="btn-submit" type="submit" value="저장">
	                            </div>
	                        </form>
	                    </section>
	                </div>
	            </main>
	        </div>
	    </section>
	</main>
</body>

</html>
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
    <link rel="stylesheet" href="/css/admin/QnA/reg.css">
     <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <title>QnAAnswer</title>
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
	                    <li><a href="" >공지사항</a></li>
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
	                <h1 class="d-none">공지사항</h1>
	                <section class="sub-container">
	                    <div class="breadcrumb">
	                        <ul class="breadcrumb-list">
	                             <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i> </li>
                        		<li>&nbsp;&nbsp;&nbsp;고객센터&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
	                            <li>&nbsp;&nbsp;&nbsp;QnA&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
	                            <li>&nbsp;&nbsp;&nbsp;문의사항 답변</li>
	                        </ul> 
	                    </div>
	                    <section class="form-sec">
	                        <h1>문의사항 답변</h1>
	                        <form action=""  method="post"  class="reg-form">
	                            <table class="table">
	                                <tr>
	                                    <th class="col-m">제목</th>
	                                    <td class="col-l text-left">
	                                        <input type="text" class="input-title" name="title"  value="${q.title}" autofocus required>
	                                       
	                                    </td>
	                                </tr>
	                                <tr>
	                                    <th>내용</th>
	                                    <td class="text-left">
	                                        <textarea class="textarea" cols="75" rows="25" name="ANSWER_CONTENT"></textarea>
	                                    </td>
	                                </tr>
	                            </table>
	                            <div>
	                            	<input type="hidden" name="ANSWER_STATUS" value="1">
	                            	<input type="hidden" name="ADMIN_ID" value="${q.adminId}">
	                            	<input type="hidden" name="ID" value="${q.id}">
	                                <input class="btn-submit" type="submit" value="답변" />
	                                <a class="btn-cancel"  href="detail?id=${q.id}"><span>취소<span></a>
	                            </div>
	                        </form>
	                    </section>
	                </section>
	            </main>
	        </div>
	    </section>
    </main>
</body>
</html>
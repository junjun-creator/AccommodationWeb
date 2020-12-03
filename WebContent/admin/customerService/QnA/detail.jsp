<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../css/reset.css" type="text/css">
    <link rel="stylesheet" href="../../../css/admin/layout.css">
    <link rel="stylesheet" href="../../../css/admin/QnA/detail.css">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <title>문의사항 자세히보기</title>
</head>
<body>
    <header class="sec_header">
        <div class="header pcHeader">
            <div class="header_h1">
                <h1><a class="teum_logo" href="http://127.0.0.1:5500/main.html">틈</a></h1>
            </div>
            <div>
                <ul class="main_menu">
                    <li class="header_search"><input type="text"><a href=""><i class="fas fa-search"></i></a></li>
                    <li><a href="">공지사항</a></li>
                    <li><a href="">이벤트</a></li>
                    <li><a href="">더보기</a></li>
                    <li class="mypage"><a href="">로그인</a>
                        <div class="mega_menu">
                            <ul>
                                <li><a href="">submenu</a></li>
                                <li><a href="">submenu</a></li>
                                <li><a href="">submenu</a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </header>
    <main>
	    <section class="body">
	        <aside id="aside" class="aside">
	            <h1>고객센터</h1>
	                <ul>
	                    <li><a href="/admin/customerService/notice/list" >공지사항</a></li>
	                    <li><a href="list" class="active">QnA</a></li>
	                </ul>
	        </aside>
	        <div class="container">
	            <nav id="nav" class="nav">
	                <ul>
	                    <li><a href=""><i class="fas fa-hotel"></i><span>업체관리</span></a></li>
	                    <li><a href=""><i class="fas fa-user-circle"></i><span>회원관리</span></a></li>
	                    <li><a href=""><i class="far fa-calendar-alt"></i><span>프로모션관리</span></a></li>
	                    <li class="current-tab"><a href=""><i class="fas fa-headphones"></i><span>고객센터</span></a></li>
	                </ul>
	            </nav>
	            <main id="main" class="main">
	                <h1 class="d-none">문의사항</h1>
	                <section class="sub-container">
	                    <div class="breadcrumb">
	                        <ul class="breadcrumb-list">
	                            <li><i class="fas fa-home"></i>HOME ▶ </li>
	                            <li>고객센터 ▶ </li>
	                            <li>문의사항 리스트 ▶</li>
	                            <li>문의사항 디테일</li>
	                        </ul>
	                    </div>
	                    <section class="form-sec">
	                        <h1>문의사항 디테일</h1>
	                        <form action="" class="reg-form">
	                            <table class="table">
	                                <tr>
	                                    <th class="col-m">제목</th>
	                                    <td class="col-l text-left">
	                                       ${q.title}
	                                      
	                                    </td>
	                                </tr>
	                                <tr>
	                                    <th>내용</th>
	                                    <td class="text-left">
	                                        ${q.content}
	                                    </td>
	                                </tr>
	                            </table>
	                            <div>
	                                <a class="btn-cancel" href="reg?id=${q.id}">답변하기</a>
                    				<a class="btn-cancel" href="del?id=${q.id}">삭제</a>
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
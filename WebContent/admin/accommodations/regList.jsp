<%@page import="com.teum.entity.AccommodationList"%>
<%@page import="java.util.List"%>
<%@page import="com.teum.service.RegAccommodationListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../css/reset.css">
    <link rel="stylesheet" href="../../css/admin/layout.css">
    <link rel="stylesheet" href="../../css/admin/accommodations/regList.css">
	<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
	<script src="../../js/admin/accommodations/regList.js"></script>
    <title>업체등록 요청 리스트</title>
</head>
<body>
    <header class="sec-header">
        <div class="header pcHeader">
            <div class="header-h1">
                <h1><a class="teum_logo" href="http://127.0.0.1:5500/main.html">틈</a></h1>
            </div>
            <div>
                <ul class="main-menu">
                    <li class="header-search"><input type="text"><a href=""><i class="fas fa-search"></i></a></li>
                    <li><a href="">공지사항</a></li>
                    <li><a href="">이벤트</a></li>
                    <li><a href="">더보기</a></li>
                    <li class="mypage"><a href="">로그인</a>
                        <div class="mega-menu">
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
	            <h1>업체관리</h1>
	            <ul>
	                <li><a href="list">등록된 업체 리스트</a></li>
	                <li><a href="regList" class="active">업체 등록 관리</a></li>
	            </ul>
	    </aside>
	        </aside>
	        <div class="container">
	            <nav id="nav" class="nav">
	                <ul>
	                    <li class="current-tab">
	                        <a href="list">
	                            <i class="fas fa-hotel"></i><span>업체관리</span>
	                        </a>
	                    </li>
	                    <li>
	                        <a href="/admin/userInfo/list">
	                            <i class="fas fa-user-circle"></i><span> 회원관리</span>
	                        </a>
	                    </li>
	                    <li>
	                        <a href="/admin/promotion/goldenTime/list">
	                            <i class="far fa-calendar-alt"></i><span>프로모션관리</span>
	                        </a>
	                    </li>
	                    <li>
	                        <a href="/admin/customerService/notice/list">
	                            <i class="fas fa-headphones"></i><span>고객센터</span>
	                        </a>
	                    </li>
	                </ul>
	            </nav>
	            <main id="main" class="main">
	                <div class="sub-container">
	                    <div class="breadcrumb">
	                        <ul class="breadcrumb-list">
	                            <li><i class="fas fa-home"></i>HOME ▶ </li>
	                            <li>업체관리 ▶ </li>
	                            <li>업체 등록 관리</li>
	                        </ul>
	                    </div>
	                    <h1>업체 등록 관리</h1>
	                    <select name="" class="AccTypeCatagory">
		                    <form action="">
		                        <option value="" selected disabled>전체보기</option>
		                        <option value="호텔">호텔</option>
		                        <option value="모텔">모텔</option>
		                        <option value="게스트하우스">게스트하우스</option>
		                        <option value="리조트">리조트</option>
		                        <option value="펜션">펜션</option>
		                    </form>
		                </select>
		                <section>
		                    <form class="list-board">
		                        <table>
		                            <thead>
		                                <tr>
		                                    <td class="col-s">No.</td>
		                                    <td class="col-sm">사업자명</td>
		                                    <td class="col-m">숙소명</td>
		                                    <td class="col-m">위치</td>
		                                    <td class="col-m">등록일</td>
		                                    <td class="col-m">연락처</td>
		                                    <td class="col-sm">업체종류</td>
		                                    <td class="col-s"><input type="checkbox"></td>
		                                    <td class="col-s"><input type="checkbox"></td>
		                                </tr>
		                            </thead>
		                            <tbody>
		                               <c:forEach var="rl" items="${list}">
		                                    <tr>
		                                      	 <td>${rl.id}</td>
	                                       		 <td>${rl.name}</td>
	                                     	  	 <td><a href="accommodationDetail?accName=${rl.accName}">${rl.accName}</a></td>
	                                   		     <td>${rl.location}</td>
	                                 		     <td>${rl.regdate}</td>
	                                 		     <td>${rl.phone}</td>
	                                		     <td>${rl.accType}</td>
		                                        <td><input type="checkbox"></td>
		                                        <td><input type="checkbox"></td>
		                                    </tr>
		                                    </c:forEach> 
		                                    <tr>
		                                <tr>
		                                    <td></td>
		                                    <td></td>
		                                    <td></td>
		                                    <td></td>
		                                    <td></td>
		                                    <td></td>
		                                    <td></td>
		                                    <td><button type="submit">승인</button></td>
		                                    <td><button type="submit">삭제</button></td>
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
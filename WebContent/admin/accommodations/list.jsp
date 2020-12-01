<%@page import="com.teum.entity.AccommodationList"%>
<%@page import="com.teum.service.AccommodationListService"%>
<%@page import="java.util.List"%>
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
    <link rel="stylesheet" href="../../css/admin/accommodations/list.css">   
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <title>등록된 업체 리스트</title>
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
	            <h1>업체관리</h1>
	                <ul>
	                    <li><a href="" class="active">등록된 업체 리스트</a></li>
	                    <li><a href="">업체 등록 관리</a></li>
	                </ul>
	        </aside>
	        <div class="container">
	            <nav id="nav" class="nav">
	                <ul>
	                    <li class="current-tab">
	                        <a href="">
	                            <i class="fas fa-hotel"></i><span>업체관리</span>
	                        </a>
	                    </li>
	                    <li>
	                        <a href="">
	                            <i class="fas fa-user-circle"></i><span> 회원관리</span>
	                        </a>
	                    </li>
	                    <li>
	                        <a href="">
	                            <i class="far fa-calendar-alt"></i><span>프로모션관리</span>
	                        </a>
	                    </li>
	                    <li>
	                        <a href="">
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
	                            <li>등록된 업체 리스트</li>
	                        </ul>
	                    </div>
	                    <h1>등록된 업체 리스트</h1>
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
	                                    </tr>
	                                </thead>
	                                <tbody>
	                                <c:forEach var="al" items="${list}">
	                                    <tr>
	                                        <td>${al.id}</td>
	                                        <td>${al.name}</td>
	                                        <td>${al.accName}</td>
	                                        <td>${al.location}</td>
	                                        <td>${al.regdate}</td>
	                                        <td>${al.phone}</td>
	                                        <td>${al.accType}</td>
	                                        <td><input type="checkbox"></td>
	                                    </tr>
	                                    </c:forEach> 
	                                    <tr>
	                                        <td></td>
	                                        <td></td>
	                                        <td></td>
	                                        <td></td>
	                                        <td></td>
	                                        <td></td>
	                                        <td></td>
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
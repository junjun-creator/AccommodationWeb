<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.teum.entity.Users" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../css/reset.css">
    <link rel="stylesheet" href="../../../css/layout.css">
    <link rel="stylesheet" href="../../../css/admin/layout.css">
    <link rel="stylesheet" href="../../../css/admin/userInfo/list.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <title>등록된 업체 리스트</title>
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

    <section class="body">
        <aside id="aside" class="aside">
            <h1>회원관리</h1>
                <ul>
                    <li><a href="/admin/userInfo/users/usersList">개인회원리스트</a></li>
                    <li><a href="companyList" class="active">기업회원리스트</a></li>
                </ul>
        </aside>
        <div class="container">
            <nav id="nav" class="nav">
                <ul>
                    <li><a href=""><i class="fas fa-hotel"></i><span>업체관리</span></a></li>
                    <li class="current-tab"><a href=""><i class="fas fa-user-circle"></i><span>회원관리</span></a></li>
                    <li><a href=""><i class="far fa-calendar-alt"></i><span>프로모션관리</span></a></li>
                    <li><a href=""><i class="fas fa-headphones"></i><span>고객센터</span></a></li>
                </ul>
            </nav>
            <main id="main" class="main">
                <div class="sub-container">
                    
                    <div class="breadcrumb">
                        <ul class="breadcrumb-list">
                            <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
                            <li>&nbsp;&nbsp;&nbsp;회원관리&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
                            <li>&nbsp;&nbsp;&nbsp;기업회원리스트&nbsp;&nbsp;&nbsp;</li>
                        </ul>
                    </div>

                    <div>
                        <h1>숙소등록현황</h1>
                    </div>
                    <div class="list-board">
                        <table>
                            <thead>
                                <tr>
                                    <td class="col-sm">현황</td>
                                    <td class="col-m">인원</td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>등록숙소</td>
                                    <td>190건</td>
                                </tr>
                                <tr>
                                    <td>신청숙소</td>
                                    <td><a href="">4건</a></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                    <div>
                        <h1>등록된 기업회원리스트</h1>
                        <select name="" id="">
                            <option value="">이름순</option>
                            <option value="">등록일자순</option>
                        </select>
                    </div>
                    <section>
                        <form action="delete" class="list-board" method="post">
                            <table>
                                <thead>
                                    <tr>
                                        <td class="col-s">No.</td>
                                        <td class="col-sm">사업주명</td>
                                        <td class="col-m">이메일</td>
                                        <td class="col-m">생년월일</td>
                                        <td class="col-m">연락처</td>
                                        <td class="col-m">등록일</td>
                                        <td class="col-sm">전체선택<input type="checkbox"></td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="m" items="${list}">
		                                    <tr>
		                                        <td class="col-s">${m.rownum }</td>
		                                        <td class="col-sm">${m.name }</td>
		                                        <td class="col-m"><a href="detail?id=${m.id }">${m.email }</a></td>
		                                        <td class="col-sm">${m.birthday }</td>
		                                        <td class="col-m">${m.phone }</td>
		                                        <td class="col-m">${m.regdate }</td>
		                                        <td class="col-s">
		                                        	<input type="hidden" name="type" value="${m.type }">
		                                       		<input type="checkbox" name="selected" value="${m.id }">
		                                        </td>
		                                    </tr>
	                                 </c:forEach>
                                    <tr class="btn-delete">
                                        <td colspan="8"><input type="submit" value="탈퇴"></td>
                                    </tr>
                                    <tr>
                                        <td colspan="7" class="no-border">
                                            <div class="pager-container">
                                                <div class="btn btn-prev">
                                                    <span><a href="">이전</a></span>
                                                </div>
                                                <input type="hidden" value="${page}" class="page">
													<ul class="pager-list">
														<c:forEach var="pageC" begin="1" end="${pageCount }" varStatus="status">
															<li class=""><a href="usersList?page=${pageC}">${pageC}</a></li>
														</c:forEach>
														
													</ul>
                                                <div class="btn btn-next">
                                                    <span><a href="">다음</a></span>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                    </section>
                    <div class="search-container">
                        <div>
                            <form action="companyList">
                                <select name="field" id="">
                                    <option value="name" selected>사업주명</option>
                                    <option value="email">이메일</option>
                                </select>
                                <input type="text" name="query">
                                <input type="submit" value="검색">
                            </form>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </section>
    
    <script type="pager-template" id="pagerList">
		<li class><a href="usersList?page={id}">{page}</a></li>
	</script>
	
	<script src="/js/admin/userInfo/company/corporateMemberList.js"></script>
</body>
</html>
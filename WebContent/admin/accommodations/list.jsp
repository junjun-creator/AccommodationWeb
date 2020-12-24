<%@page import="com.teum.entity.Acc"%>
<%@page import="com.teum.service.AccService"%>
<%@page import="java.util.List"%>
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
	<link rel="stylesheet" href="/css/admin/layout.css">
    <link rel="stylesheet" href="/css/admin/accommodations/list.css">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	    <link rel="icon" href="/images/logo.png">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
	<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
	<script src="../../js/admin/accommodations/regList.js"></script>
    <title>승인등록 요청 리스트</title>
</head>
<body>
    <header class="sec-header-page">
        <section class="header-sec pcHeader">
            <div class="header-logo">
                <h1><a class="teum-logo" href="/admin/index">틈</a></h1>
            </div>
            <div>
                <ul class="main-menu">
                    <li class="header-search"><input type="text"><a href=""><i class="fas fa-search"></i></a></li>
                    <li><a href="/admin/promotion/event/list">제안하기</a></li>
                    <li><a href="">예약내역</a></li>
                    <li class="sub-page">
                        <a href="">더보기</a>
                        <div class="mega-menu">
                            <ul>
                                <li><a href="/admin/customerService/notice/list">공지사항</a></li>
                                <li><a href="/admin/promotion/event/list">이벤트</a></li>
                                <li><a href="/admin/customerService/qna/list">1:1 문의</a></li>
                            </ul>
                        </div>
                    </li>
                    <li class="sub-page">
                        <a href="" class="character"><i class="fas fa-sort-down"></i></a>
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
                <h1>업체관리</h1>
                <ul>
                    <li class="active"><a href="list" >승인된 업체 리스트</a></li>
                    <li><a href="applyList">업체 등록 관리</a></li>
                </ul>
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
                                <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
                                <li>&nbsp;&nbsp;&nbsp;업체관리&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
                                <li>&nbsp;&nbsp;&nbsp;승인된 업체 리스트&nbsp;&nbsp;&nbsp;</li>
                            </ul>
                        </div>
                        <div class="main-search">
                            <h1>승인된 업체 리스트</h1>
                            <form action="">
                                <select name="ac" class="acc-catagory">
                                    <option value="호텔" ${(param.ac == "호텔")?"selecte":"" } >호텔</option>
                                    <option value="모텔" ${(param.ac == "모텔")?"selecte":"" }>모텔</option>
                                    <option value="게스트하우스" ${(param.ac == "게스트하우스")?"selecte":"" } >게스트하우스</option>
                                    <option value="리조트" ${(param.ac == "리조트")?"selecte":"" }>리조트</option>
                                    <option value="펜션" ${(param.ac == "펜션")?"selecte":"" }>펜션</option>
                                </select>
                                <select name="f">
                                    <option value="company_name" ${(param.f == "company_name")?"selecte":"" } >사업자</option>
                                    <option value="acc_name" ${(param.f == "acc_name")?"selecte":"" } >숙소</option>
                                </select>
                                <input type="text" name="q" value="${param.search}">
                                <input type="submit" value="검색">
                            </form>
                        </div>
                        
                        <section>
							<form class="list-board" action="list" method="post">
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
                                        <c:forEach var="a" items="${list}">
										<tr>
											<td>${a.num}</td>
											<td>${a.companyName}</td>
											<td class="ellips"><a href="detail?id=${a.id}">${a.name}</a></td>
											<td class="ellips">${a.location}</td>
											<td>${a.regdate}</td>
											<td>${a.phone}</td>
											<td>${a.accType}</td>
											<td><input type="checkbox" name="del-id"  value="${a.id}"></td>
										</tr>
										</c:forEach> 
                                        <tr class="btn-line">
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td>
                                            	<button type="submit"name="cmd" value = "삭제">삭제</button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="8" class="no-border">
                                                <div class="pager-container">
                                                	<!--이전버튼  -->
                                                    <div class="btn btn-prev">
	                                                    <c:set var="ac" value="${accType}"/>
														<c:set var="page" value="${(empty param.p)?1:param.p}"/>
														<c:set var="startNum" value="${page-(page-1)%5}" />
														<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/10),'.') }" /><!--6-->
														
														<c:if test="${startNum>1}">
															<a href="list?page=${startNum-1}">이전</a>
														</c:if>
														<c:if test="${startNum<=1}">
															<span onclick="alert('이전 페이지가 없습니다.');">이전</span>
														</c:if>
													</div>
													<!--페이저 리스트  -->
													<ul class="pager-list">
														<c:forEach var="i"  begin="0"  end="4">
														<c:if test="${(startNum+i) <= lastNum}">
															<li><a class="${(page==(startNum+i))?'active-page':''}" href="list?p=${startNum+i}&ac=${param.ac}&f=${param.f}&q=${param.q}">${startNum+i}</a></li>
														</c:if>
														</c:forEach>
													</ul>
													<!--다음버튼  -->
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
					</div>
				</main>
			</div>
		</section>
	</main>
</body>
</html>
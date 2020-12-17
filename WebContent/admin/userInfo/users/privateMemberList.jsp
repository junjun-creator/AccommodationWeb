<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.teum.entity.Users" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
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
    <script src="/js/admin/userInfo/users/privateMemberList.js"></script>
    <title>등록된 회원 리스트</title>
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
				<h1>회원관리</h1>
					<ul>
						<li><a href="usersList" class="active">개인회원리스트</a></li>
						<li><a href="/admin/userInfo/company/companyList">기업회원리스트</a></li>
					</ul>
			</aside>
	        <div class="container">
	            <nav id="nav" class="nav">
	                <ul>
	                    <li><a href="/admin/accommodations/list"><i class="fas fa-hotel"></i><span>업체관리</span></a></li>
	                    <li class="current-tab"><a href="list"><i class="fas fa-user-circle"></i><span>회원관리</span></a></li>
	                    <li><a href="/admin/promotion/goldenTime/list"><i class="far fa-calendar-alt"></i><span>프로모션관리</span></a></li>
	                    <li><a href="/admin/customerService/notice/list"><i class="fas fa-headphones"></i><span>고객센터</span></a></li>
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
	                        <h1>등급별 회원수</h1>
	                    </div>
	                    <div class="list-board">
	                        <table>
	                            <thead>
	                                <tr>
	                                    <td class="col-sm">등급</td>
	                                    <td class="col-m">인원</td>
	                                </tr>
	                            </thead>
	                            <tbody class="rank-count">
	                            <c:set var="ranks" value="${fn:split('실버,골드,플레티넘,다이아',',')}" />
	                            
	                            <c:forEach items="${ranks}" var="ranks" varStatus="status">
	                                <tr>
	                                    <td>${ranks}</td>
	                                    <td>${rankCount[status.index]}명</td>
	                                </tr>
	                            </c:forEach>
	                            </tbody>
	                        </table>
	                    </div>
	
	                    <div>
	                        <h1>등록된 개인회원리스트</h1>
	                        <select name="" id="" class="order-by-rank">
	                            <option value="">전체등급</option>
	                            <option value="">실버</option>
	                            <option value="">골드</option>
	                            <option value="">플레티넘</option>
	                            <option value="">다이아</option>
	                        </select>
	                    </div>
	                    <section>
	                        <form action="delete" class="list-board" method="post">
	                            <table>
	                                <thead>
	                                    <tr>
	                                        <td class="col-s">No.</td>
	                                        <td class="col-sm">회원명</td>
	                                        <td class="col-m">이메일</td>
	                                        <td class="col-sm">생년월일</td>
	                                        <td class="col-m">휴대폰번호</td>
	                                        <td class="col-sm">회원등급</td>
	                                        <td class="col-s"><input type="checkbox"></td>
	                                    </tr>
	                                </thead>
	                                <tbody>
										<c:forEach var="m" items="${list}">
		                                    <tr>
		                                        <td class="col-s">${m.rownum }</td>
		                                        <td class="col-sm">${m.name }</td>
		                                        <td class="col-m" style="text-overflow:ellipsis; overflow:hidden; white-space:nowrap;"><a href="detail?id=${m.id }">${m.email }</a></td>
		                                        <td class="col-sm">${m.birthday }</td>
		                                        <td class="col-m">${m.phone }</td>
		                                        <td class="col-sm user-rank">${m.rankId }</td>
		                                        <td class="col-s"><input type="checkbox" name="selected" value="${m.id }"></td>
		                                    </tr>
										</c:forEach>
	                                    <tr class="btn-delete">
	                                        <td colspan="7"><input type="submit" value="삭제"></td>
										</tr>
										<tr>
											<td colspan="6" class="no-border">
												<div class="pager-container">
													<!--start index 구하기! -->
													<c:set var="page" value="${(empty param.page)?1:param.page }"/>
													<c:set var="startNum" value="${page-(page-1)%5}"/>
													<c:set var="lastNum" value="${pageLastCount }"/>
													<div class="btn btn-prev">
														<c:if test="${startNum > 1 }">
															<span><a href="?page=${startNum-1 }&field=&query=">이전</a></span>
														</c:if>
														<c:if test="${startNum <= 1 }">
															<span><a href="" onclick="alert('이전페이지가 없습니다.');">이전</a></span>
														</c:if>
													</div>
													<ul class="pager-list">
														<c:forEach var="i" begin="0" end="4" varStatus="status">
															<c:if test="${startNum+i <=lastNum }">
																<li class="${(page == (startNum+i))?'active-page':'' }"><a href="?page=${i+startNum }&field=${param.field }&query=${param.query}">${i+startNum }</a></li>
															</c:if>
														</c:forEach>
														
													</ul>
													<div class="btn btn-next">
														<c:if test="${startNum+4<lastNum }">
															<span><a href="?page=${startNum+5 }&field=&query=">다음</a></span>
														</c:if>
														<c:if test="${startNum+4>=lastNum }">
															<span><a href="" onclick="alert('다음페이지가 없습니다.');">다음</a></span>
														</c:if>
													</div>
												</div>
											</td>
										</tr>
	                                </tbody>
	                            </table>
	                        </form>
	                    </section>
						<div class="search-container private-list">
							<div>
								<form>
									<select name="field" id="">
										<option value="name" ${(param.field=="name")?"selected":"" }>회원명</option>
										<option value="email" ${(param.field=="email")?"selected":"" }>이메일</option>
									</select>
									<input type="text" name="query" value="${param.query }">
									<input type="submit" value="검색">
								</form>
							</div>
						</div>
	                </div>
	            </main>
	        </div>
	    </section>
	</main>
</body>
</html>
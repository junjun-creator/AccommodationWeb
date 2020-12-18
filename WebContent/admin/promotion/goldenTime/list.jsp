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
    <link rel="stylesheet" href="/css/admin/promotion/goldenTime/list.css">
     <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <title>골든타임 리스트</title>
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
	                    <li><a href="list" class="active">골든타임 관리</a></li>
	                    <li><a href="/admin/promotion/event/list" >이벤트 관리</a></li>
	                </ul>
	        </aside>
	        <div class="container">
	            <nav id="nav" class="nav">
	                <ul>
	                    <li><a href="/admin/accommodations/list"><i class="fas fa-hotel"></i><span>업체관리</span></a></li>
	                    <li><a href="/admin/userInfo/list"><i class="fas fa-user-circle"></i><span> 회원관리</span></a></li>
	                    <li class="current-tab"><a href="/admin/promotion/goldenTime/list"><i class="far fa-calendar-alt"></i><span>프로모션관리</span></a></li>
	                    <li><a href="/admin/customerService/notice/list"><i class="fas fa-headphones"></i><span>고객센터</span></a></li>
	                </ul>
	            </nav>
	            <main id="main" class="main">
	                <h1 class="d-none">골든타임</h1>
	                <section class="sub-container">
	                    <div class="breadcrumb">
	                        <ul class="breadcrumb-list">
	                             <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i> </li>
                        		<li>&nbsp;&nbsp;&nbsp;프로모션관리&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
	                            <li>&nbsp;&nbsp;&nbsp;골든타임 리스트</li>
	                        </ul>
	                    </div>
	                    <section class="list-board">
	                    	<div class="main-search">	
		                        <h1>골든타임 리스트</h1>
		                        <div>
		                      	<form action="list">
			                        <select name="category" class="AccTypeCatagory">
				                           <option value="" selected>전체보기</option>
				                           <option value="호텔" ${(param.category=="호텔")?"selected":"" }>호텔</option>
				                           <option value="모텔" ${(param.category=="모텔")?"selected":"" }>모텔</option>
				                           <option value="게스트하우스" ${(param.category=="게스트하우스")?"selected":"" }>게스트하우스</option>
				                           <option value="리조트" ${(param.category=="리조트")?"selected":"" }>리조트</option>
				                           <option value="펜션" ${(param.category=="펜션")?"selected":"" }>펜션</option>
				                    </select>
				                    	<input type="hidden" name="page">
				                    	<input type="text" name="query" value="${param.query}">
			                        	<input type="submit" value="검색">
				                     </form>
			                    </div>
	                    	</div>
	                    	<form action="list" method="post">	
	                        <table>
	                            <thead>
	                                <tr>
	                                    <td class="col-s">No.</td>
	                                    <td class="col-s">사업자명</td>
	                                    <td class="col-m">숙소명</td>
	                                    <td class="col-sm">위치</td>
	                                    <td class="col-sm">기간</td>
	                                    <td class="col-sm">연락처</td>
	                                    <td class="col-s">상태</td>
	                                </tr>
	                            </thead>
	                            <tbody>
	                            <c:forEach var="g" items="${list}">
	                            <c:set var="status" value=""/>
		                         <c:if test="${g.goldentimeStatus==1}">
		                        	 <c:set var="status" value="진행중"/>
		                         </c:if> 
		                         <c:if test="${g.goldentimeStatus==0}">
		                        	 <c:set var="status" value="대기중"/>
		                         </c:if>  
	                                <tr>
	                                    <td>${g.id}</td>
	                                    <td>${g.userName}</td>
	                                    <td>${g.name}</td>
	                                    <td>${g.location }</td>
	                                    <td>${g.gtStartDate}~<br>${g.gtEndDate}</td>
	                                    <td>${g.phone}</td>
	                                    <td>${status}</td>
	                                </tr>
	                               </c:forEach>
	                                 <tr>
											<td colspan="7" class="no-border">
												<div class="pager-container">
													<div class="btn btn-prev">
													<c:set var="category" value="${categoryType}"/>
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
														<li><a class="${(page==(startNum+i))?'active-page':''}" href="list?page=${startNum+i}&category=${category}&query=${param.query}">${startNum+i}</a></li>
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
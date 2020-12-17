<%@page import="java.util.List"%>
<%@page import="com.teum.service.QnAService"%>
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
    <link rel="stylesheet" href="/css/admin/QnA/list.css">
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
	                    <li><a href="/admin/customerService/notice/list">공지사항</a></li>
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
	                <h1  class="d-none">문의사항</h1>
	                <section class="sub-container">
	                    <div class="breadcrumb">
	                        <ul class="breadcrumb-list">
	                             <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i> </li>
                        		<li>&nbsp;&nbsp;&nbsp;고객센터&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
	                            <li>&nbsp;&nbsp;&nbsp;QnA</li>
	                        </ul>
	                    </div>
	                    <section class="list-board">
		                   	<div class="main-search">
		                        <h1>문의사항 리스트</h1>
		                        <div>
			                        <form action="list">
			                        <select name="catagory" id="" class="catagory">
			                                <option value="" selected disabled>카테고리</option>
			                                <option value="이벤트">이벤트</option>
			                                <option value="예약/결제">예약/결제</option>
			                                <option value="취소/환불">취소/환불</option>
			                                <option value="서비스 이용">서비스 이용</option>
			                                <option value="회원/개인정보">회원/개인정보</option>
			                                <option value="리뷰">리뷰</option>
			                                <option value="기타">기타</option>
			                        </select>
			                        </form>
			                          <form action="list">
		                                <input type="text" name="query">
			                        	<input type="submit" value="검색">
			                    	</form>
		                        </div>
	                        </div>
	                        <table>
	                            <thead>
	                                <tr>
	                                    <td class="col-s">No.</td> 
	                                    <td class="col-sm">회원명</td>
	                                    <td class="col-sm">카테고리</td>
	                                    <td class="col-ml">문의제목</td>
	                                    <td class="col-sm">연락처</td>
	                                    <td class="col-sm">문의날짜</td>
	                                    <td class="col-sm">상태</td>
	                                    <td class="col-s"><input type="checkbox" class="selectAllDelete"></td>
	                                </tr>
	                            </thead>
	                            <tbody>
	                            <c:forEach var="q" items="${list}">
	                            
	                                <tr>
	                                    <td>${q.id}</td>
	                                    <td>${q.userName}</td>
	                                    <td>
	                                    ${q.categoryType}
	                                    <%-- <c:choose>
											<c:when test="${q.categoryId eq 1}">
												이벤트
											</c:when>
											<c:when test="${q.categoryId eq 2}">
												예약/결제
											</c:when>
											<c:when test="${q.categoryId eq 3}">
												취소/환불
											</c:when>
											<c:when test="${q.categoryId eq 4}">
												서비스이용
											</c:when>
											<c:when test="${q.categoryId eq 5}">
												회원/개인정보
											</c:when>
											<c:when test="${q.categoryId eq 6}">
												리뷰
											</c:when>
											<c:otherwise>
												기타
											</c:otherwise>
	                                     </c:choose> --%>
	                                    </td>
	                                    <td><a href="detail?id=${q.id}">${q.title}</a></td>
	                                    <td>${q.phone}</td>
	                                    <td>${q.regdate}</td>
	                                    <td>
	                                    	<c:choose>
												<c:when test="${q.answerStatus ==0 }">
													<%="답변안됨" %>
												</c:when>
												<c:otherwise>
					                            	<%="답변됨" %>
					                            </c:otherwise>                           
					                            
				                            </c:choose>
	                            		</td>
	                                    <td>
	                                        <input type="checkbox" name="" class="deleteChk" >
	                                    </td>
	                                </tr>
	                             </c:forEach>
	                                <tr class="btn-delete">
	                                    <td colspan="8">
	                                        <form action="">
	                                            <input type="submit" value="답변">
	                                            <input type="submit" value="삭제">
	                                        </form>
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
                    	</section>
                    </section>
            	</main>
	        </div>
	    </section>
   </main>
</body>
</html>
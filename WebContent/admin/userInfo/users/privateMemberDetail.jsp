<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/images/logo.png">
    <link rel="stylesheet" href="../../../css/reset.css">
    <link rel="stylesheet" href="../../../css/layout.css">
    <link rel="stylesheet" href="../../../css/admin/layout.css">
    <link rel="stylesheet" href="../../../css/admin/userInfo/list.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <title>회원관리 | 틈을 채우다</title>
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
                    <li class="active"><a href="">개인회원리스트</a></li>
                    <li><a href="">기업회원리스트</a></li>
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
                            <li><i class="fas fa-home"></i>HOME ▶ </li>
                            <li>회원관리 ▶ </li>
                            <li>개인회원리스트</li>
                        </ul>
                    </div>

                    <div class="user-info">
                        <div class="user-info-member">
                            <h1>김병준 님 
                            <c:if test="${member.rankId==1 }">
                                    		<i class="fas fa-gem" style="color: green;"></i>
                                    	</c:if>
                                    	<c:if test="${member.rankId==2 }">
                                    		<i class="fas fa-gem" style="color: gold;"></i>
                                    	</c:if>
                                    	<c:if test="${member.rankId==3 }">
                                    		<i class="fas fa-gem" style="color: gray;"></i>
                                    	</c:if>
                                    	<c:if test="${member.rankId==4 }">
                                    		<i class="fas fa-gem" style="color: black;"></i>
                                    	</c:if>
                            </h1>
                        </div>
                        <div>
                            <img src="../../../images/logo.png" alt="">
                            <input type="button" value="사진 변경하기">
                        </div>
                    </div>
                    <!-- 다이아몬드 이런건 나중에 스크립트로 요청 정보 읽어서 등급에 맞게 클래스 이름만 setAttribute 해주면 될듯 -->
                    <div class="list-board">
                        <table>
                            <thead>
                                <tr>
                                    <td class="col-s">등급</td>
                                    <td class="col-m">이메일</td>
                                    <td class="col-sm">회원구분</td>
                                    <td class="col-m">연락처</td>
                                    <td class="col-sm">생년월일</td>
                                    <td class="col-m">등록일</td>
                                </tr>
                            </thead>
                            <tbody>
                                    <td class="col-s">
                                    	<c:if test="${member.rankId==1 }">
                                    		<i class="fas fa-gem" style="color: green;"></i>
                                    	</c:if>
                                    	<c:if test="${member.rankId==2 }">
                                    		<i class="fas fa-gem" style="color: gold;"></i>
                                    	</c:if>
                                    	<c:if test="${member.rankId==3 }">
                                    		<i class="fas fa-gem" style="color: gray;"></i>
                                    	</c:if>
                                    	<c:if test="${member.rankId==4 }">
                                    		<i class="fas fa-gem" style="color: black;"></i>
                                    	</c:if>
                                    </td>
                                    <td class="col-m">${member.email }</td>
                                    <td class="col-sm">${(member.type==0)?'개인회원':'기업회원' }</td>
                                    <td class="col-m">${member.phone }</td>
                                    <td class="col-sm">${member.birthday }</td>
                                    <td class="col-m">${member.regdate }</td>
                            </tbody>
                        </table>
                    </div>

                    <div>
                        <h1>예약 내역</h1>
                    </div>
                    <section class="list-board">
                            <table>
                                <thead>
                                    <tr>
                                        <td class="col-s">No.</td>
                                        <td class="col-sm">회원명</td>
                                        <td class="col-m">이메일</td>
                                        <td class="col-m">예약숙소</td>
                                        <td class="col-m">연락처</td>
                                        <td class="col-m">체크인</td>
                                        <td class="col-m">체크아웃</td>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${reservationList }" var="item">
                                	<tr>
                                        <td class="col-s">${item.rownum }</td>
                                        <td class="col-sm">${item.userName }</td>
                                        <td class="col-m">${item.userEmail }</td>
                                        <td class="col-m">${item.accName }</td>
                                        <td class="col-m">${item.phone }</td>
                                        <td class="col-m">${item.checkinDate }</td>
                                        <td class="col-m">${item.checkoutDate }</td>
                                    </tr>
                                </c:forEach>
                                    <tr>
											<td colspan="7" class="no-border">
												<div class="pager-container">
													<!--start index 구하기! -->
													<c:set var="page1" value="${(empty param.page1)?1:param.page1 }"/>
													<c:set var="startNum1" value="${page1-(page1-1)%5}"/>
													<c:set var="lastNum1" value="${pageLastCount1 }"/>
													<c:set var="page2" value="${(empty param.page2)?1:param.page2 }"/>
													<c:set var="startNum2" value="${page2-(page2-1)%5}"/>
													<c:set var="lastNum2" value="${pageLastCount2 }"/>
													<div class="btn btn-prev">
														<c:if test="${startNum1 > 1 }">
															<span><a href="?page1=${startNum1-1 }&page2=${page2}&id=${id}">이전</a></span>
														</c:if>
														<c:if test="${startNum1 <= 1 }">
															<span><a href="" onclick="alert('이전페이지가 없습니다.');">이전</a></span>
														</c:if>
													</div>
													<ul class="pager-list">
														<c:forEach var="i" begin="0" end="4" varStatus="status">
															<c:if test="${startNum1+i <=lastNum1 }">
																<li class="${(page1 == (startNum1+i))?'active-page':'' }"><a href="?page1=${i+startNum1 }&page2=${page2}&id=${id}">${i+startNum1 }</a></li>
															</c:if>
														</c:forEach>
														
													</ul>
													<div class="btn btn-next">
														<c:if test="${startNum1+4<lastNum1 }">
															<span><a href="?page1=${startNum1+5 }&page2=${page2}&id=${id}">다음</a></span>
														</c:if>
														<c:if test="${startNum1+4>=lastNum1 }">
															<span><a href="" onclick="alert('다음페이지가 없습니다.');">다음</a></span>
														</c:if>
													</div>
												</div>
											</td>
										</tr>
                                </tbody>
                            </table>
                    </section>

                    <div>
                        <h1>1:1 문의 내역</h1>
                        <!-- <select name="" id="">
                            <option value="">전체</option>
                            <option value="">완료</option>
                            <option value="">취소</option>
                            <option value="">예약중</option>
                        </select> -->
                    </div>
                    <section class="list-board">
                            <table>
                                <thead>
                                    <tr>
                                        <td class="col-s">No.</td>
                                        <td class="col-sm">회원명</td>
                                        <td class="col-l">문의 제목</td>
                                        <td class="col-m">연락처</td>
                                        <td class="col-m">문의일자</td>
                                        <td class="col-sm">답변여부</td>
                                        <td class="col-sm">비고</td>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${qnaList }" var="item">
                                	<tr>
                                        <td class="col-s">${item.rownum }</td>
                                        <td class="col-sm">${item.userName }</td>
                                        <td class="col-l">${item.title }</td>
                                        <td class="col-m">${item.phone }</td>
                                        <td class="col-m">${item.regdate }</td>
                                        <td class="col-s">${(item.answerStatus==1)?'예':'아니오' }</td>
                                        <td><button><a href="/admin/customerService/QnA/detail?id=${item.qnaId }">상세보기</a></button></td>
                                    </tr>
                                </c:forEach>
                                    <tr>
											<td colspan="7" class="no-border">
												<div class="pager-container">
													<!--start index 구하기! -->
													
													<div class="btn btn-prev">
														<c:if test="${startNum2 > 1 }">
															<span><a href="?page2=${startNum2-1 }&page1=${page1}&id=${id}">이전</a></span>
														</c:if>
														<c:if test="${startNum2 <= 1 }">
															<span><a href="" onclick="alert('이전페이지가 없습니다.');">이전</a></span>
														</c:if>
													</div>
													<ul class="pager-list">
														<c:forEach var="i" begin="0" end="4" varStatus="status">
															<c:if test="${startNum2+i <=lastNum2 }">
																<li class="${(page2 == (startNum2+i))?'active-page':'' }"><a href="?page2=${i+startNum2 }&page1=${page1}&id=${id}">${i+startNum2 }</a></li>
															</c:if>
														</c:forEach>
														
													</ul>
													<div class="btn btn-next">
														<c:if test="${startNum2+4<lastNum2 }">
															<span><a href="?page2=${startNum2+5 }&page1=${page1}&id=${id}">다음</a></span>
														</c:if>
														<c:if test="${startNum2+4>=lastNum2 }">
															<span><a href="" onclick="alert('다음페이지가 없습니다.');">다음</a></span>
														</c:if>
													</div>
												</div>
											</td>
										</tr>
                                   
                                    
                                </tbody>
                            </table>
                    </section>

                    <section class="user-info-btn">
                        <input type="button" value="목록">
                        <input type="button" value="탈퇴">
                    </section>
                </div>
            </main>
        </div>
    </section>
</body>
</html>
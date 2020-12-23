<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<header class="sec-header-page">
        <section class="header-sec pcHeader">
            <div class="header-logo">
                <h1><a class="teum-logo" href="/index">틈</a></h1>
            </div>
            <div>
                <ul class="main-menu">
                    <li class="header-search">
                    	<form action="/accommodation/list" method="get">
                    		<input type="text" name="search" placeholder="숙소명 또는 위치" value="${param.search}">
                    	</form>
                        <a href=""><i class="fas fa-search"></i></a>
                    </li>
                    <li>
                       <c:if test="${sessionScope.type == 0 }">
                          <a href="/user/offer/reg">제안하기</a>
                        </c:if>
                        <c:if test="${sessionScope.type == 1 }">
                          <a href="/company/accommodation/reg">숙소등록</a>
                        </c:if>
                    </li>
                    <li>
                       	<c:if test="${sessionScope.type == 0 }">
                          <a href="/user/reservation/reservationInfo">예약내역</a>
                        </c:if>
                        <c:if test="${sessionScope.type == 1 }">
                          <a href="/company/reservation/reservationInfo">예약현황</a>
                        </c:if>
                    </li>
                    <li class="sub-page">
                        <a href="">더보기</a>
                        <div class="mega-menu">
                            <ul>
                                <li><a href="/notice/list">공지사항</a></li>
                                <li><a href="/event/list">이벤트</a></li>
                                <c:if test="${sessionScope.type == 0 }">
                                   <li><a href="/user/qna">1:1 문의</a></li>
                              	</c:if>

                                
                            </ul>
                        </div>
                    </li>
                    <li class="sub-page">
                       <c:if test="${empty sessionScope.email }">
                           <a href="/signin" class="character">로그인</a>
                        </c:if>
                        <c:if test="${sessionScope.email ne null}">
                           <a href="" style="pointer-events:none;" class="character"><i class="fas fa-sort-down"></i></a>
                        </c:if>
                        
                        <c:if test="${sessionScope.type == 0 || sessionScope.type == 1 }">
                           <div class="mega-menu">
                               <ul>
                                   <c:if test="${sessionScope.type == 0 }">
                                    <li><a href="/user/userInfo/memberInfo">내정보</a></li>
                                 </c:if>
                                 <c:if test="${sessionScope.type == 1 }">
                                    <li><a href="/company/userInfo/memberInfo">내정보</a></li>
                                 </c:if>
                                 <c:if test="${sessionScope.type == 0 }">
                                    <li><a href="/user/reservation/reservationInfo">예약현황</a></li>
                                 </c:if>
                                 <c:if test="${sessionScope.type == 1 }">
                                    <li><a href="/company/reservation/reservationInfo">예약현황</a></li>
                                 </c:if>
                                 <c:if test="${sessionScope.type == 0 }">
                                    <li><a href="/user/userInfo/offerList">제안내역</a></li>
                                 </c:if>
                                 <c:if test="${sessionScope.type == 1 }">
                                    <li><a href="/company/reverseOffer/reg">제안내역</a></li>
                                 </c:if>
                                   <c:if test="${sessionScope.type == 0 }">
                                    <li><a href="/user/userInfo/pickList">찜한숙소</a></li>
                                 </c:if>
                                 <c:if test="${sessionScope.type == 1 }">
                                    <li><a href="/company/goldenTime/list">골든타임</a></li>
                                 </c:if>
                                   <li><a href="/logout">로그아웃</a></li>
                               </ul>
                           </div>
                        </c:if>
                    </li>
                </ul>
            </div>
        </section>
    </header>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.teum.entity.Users" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/images/logo.png">
    <link rel="stylesheet" href="../../css/reset.css">
    <link rel="stylesheet" href="../../css/admin/layout.css">
    <link rel="stylesheet" href="../../css/admin/userInfo/list.css">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <title>회원관리 | 틈을 채우다</title>
</head>
<body>
    <jsp:include page="/inc/header.jsp"/>

	<main>
	    <section class="body">
	        <aside id="aside" class="aside">
	            <h1>회원관리</h1>
	                <ul>
	                	<li><a href="">전체회원리스트</a></li>
	                    <li><a href="" class="active">개인회원리스트</a></li>
	                    <li><a href="">기업회원리스트</a></li>
	                </ul>
	        </aside>
	        <div class="container">
	            <nav id="nav" class="nav">
	                <ul>
	                    <li><a href="/admin/accommodations/list"><i class="fas fa-hotel"></i><span>업체관리</span></a></li>
	                    <li class="current-tab"><a href="/admin/userInfo/users/usersList"><i class="fas fa-user-circle"></i><span>회원관리</span></a></li>
	                    <li><a href="/admin/promotion/goldenTime/list"><i class="far fa-calendar-alt"></i><span>프로모션관리</span></a></li>
	                    <li><a href="/admin/customerService/notice/list"><i class="fas fa-headphones"></i><span>고객센터</span></a></li>
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
	
	                    <div class="user-info-member">
	                        <h1>${member.name}님 <i class="fas fa-gem" style="color: dimgrey;"></i></h1>
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
	                                    <td class="col-s"><i class="fas fa-gem" style="color: dimgrey;"></i></td>
	                                    <td class="col-m">${member.email }</td>
	                                    <td class="col-sm">${member.type }</td>
	                                    <td class="col-m">${member.phone }</td>
	                                    <td class="col-sm">${member.birthday }</td>
	                                    <td class="col-m">${member.regdate }</td>
	                            </tbody>
	                        </table>
	                    </div>
	
	                    <div>
	                        <h1>예약 내역</h1>
	                        <select name="" id="">
	                            <option value="">전체</option>
	                            <option value="">완료</option>
	                            <option value="">취소</option>
	                            <option value="">예약중</option>
	                        </select>
	                    </div>
	                    <section class="list-board">
	                            <table>
	                                <thead>
	                                    <tr>
	                                        <td class="col-s">No.</td>
	                                        <td class="col-sm">회원명</td>
	                                        <td class="col-sm">닉네임</td>
	                                        <td class="col-m">이메일</td>
	                                        <td class="col-m">예약숙소</td>
	                                        <td class="col-m">연락처</td>
	                                        <td class="col-m">예약일자</td>
	                                    </tr>
	                                </thead>
	                                <tbody>
	                                    <tr>
	                                        <td class="col-s">1</td>
	                                        <td class="col-sm">김병준</td>
	                                        <td class="col-sm">jun</td>
	                                        <td class="col-m">cjh@newlecture.com</td>
	                                        <td class="col-m">가평 ~~~ 펜션</td>
	                                        <td class="col-m">010-0000-1111</td>
	                                        <td class="col-m">2020-11-05</td>
	                                    </tr>
	                                    <tr>
	                                        <td class="col-s">2</td>
	                                        <td class="col-sm">김병준</td>
	                                        <td class="col-sm">jun</td>
	                                        <td class="col-m">sje@newlecture.com</td>
	                                        <td class="col-m">강릉 ~~~ 호텔</td>
	                                        <td class="col-m">010-3462-8452</td>
	                                        <td class="col-m">2020-11-05</td>
	                                    </tr>
	                                    <tr>
	                                        <td class="col-s">3</td>
	                                        <td class="col-sm">김병준</td>
	                                        <td class="col-sm">jun</td>
	                                        <td class="col-m">kbj@newlecture.com</td>
	                                        <td class="col-m">부산 ~~~ 호텔</td>
	                                        <td class="col-m">010-2365-5678</td>
	                                        <td class="col-m">2020-11-14</td>
	                                    </tr>
	                                    <tr>
	                                        <td class="col-s">4</td>
	                                        <td class="col-sm">김병준</td>
	                                        <td class="col-sm">jun</td>
	                                        <td class="col-m">psh@newlecture.com</td>
	                                        <td class="col-m">춘천 ~~~ 모텔</td>
	                                        <td class="col-m">010-3863-1263</td>
	                                        <td class="col-m">2020-11-23</td>
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
	                                        <td class="col-sm">닉네임</td>
	                                        <td class="col-m">문의 제목</td>
	                                        <td class="col-m">연락처</td>
	                                        <td class="col-m">문의일자</td>
	                                        <td class="col-sm">답변여부</td>
	                                        <td class="col-sm">비고</td>
	                                    </tr>
	                                </thead>
	                                <tbody>
	                                    <tr>
	                                        <td class="col-s">1</td>
	                                        <td class="col-sm">김병준</td>
	                                        <td class="col-sm">jun</td>
	                                        <td class="col-m">cjh@newlecture.com</td>
	                                        <td class="col-m">010-0000-1111</td>
	                                        <td class="col-m">2020-11-05</td>
	                                        <td class="col-s">예</td>
	                                        <td><input type="button" value="답변하기"></td>
	                                    </tr>
	                                    <tr>
	                                        <td class="col-s">2</td>
	                                        <td class="col-sm">김병준</td>
	                                        <td class="col-sm">jun</td>
	                                        <td class="col-m">sje@newlecture.com</td>
	                                        <td class="col-m">010-3462-8452</td>
	                                        <td class="col-m">2020-11-05</td>
	                                        <td class="col-s">예</td>
	                                        <td><input type="button" value="답변하기"></td>
	                                    </tr>
	                                    <tr>
	                                        <td class="col-s">3</td>
	                                        <td class="col-sm">김병준</td>
	                                        <td class="col-sm">jun</td>
	                                        <td class="col-m">kbj@newlecture.com</td>
	                                        <td class="col-m">010-2365-5678</td>
	                                        <td class="col-m">2020-11-14</td>
	                                        <td class="col-s">예</td>
	                                        <td><input type="button" value="답변하기"></td>
	                                    </tr>
	                                    <tr>
	                                        <td class="col-s">4</td>
	                                        <td class="col-sm">김병준</td>
	                                        <td class="col-sm">jun</td>
	                                        <td class="col-m">psh@newlecture.com</td>
	                                        <td class="col-m">010-3863-1263</td>
	                                        <td class="col-m">2020-11-23</td>
	                                        <td class="col-s">예</td>
	                                        <td><input type="button" value="답변하기"></td>
	                                    </tr>
	                                    
	                                </tbody>
	                            </table>
	                    </section>
	
	                    <section class="user-info-btn">
	                        <input type="button" onclick="location.href='/admin/userInfo/list'" value="목록">
	                        <form action="delete" method="post">
	                        	<input type="hidden" name="id" value="${member.id }">
	                        	<input type="hidden" name="type" value="${member.type }">
		                        <input type="submit" value="탈퇴">
	                        </form>
	                    </section>
	                </div>
	            </main>
	        </div>
	    </section>
	</main>
</body>
</html>
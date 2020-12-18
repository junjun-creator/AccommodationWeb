<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/css/reset.css">
<link rel="stylesheet" href="/css/admin/layout.css">
<link rel="stylesheet" href="/css/layout.css">
<link rel="stylesheet" href="/css/admin/accommodations/regList.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap"
	rel="stylesheet">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="../../js/admin/accommodations/regList.js"></script>
<title>업체등록 요청 리스트</title>
</head>
<body>
	<header class="sec-header-page">
        <section class="header-sec pcHeader">
            <div class="header-logo">
                <h1><a class="teum-logo" href="/index">틈</a></h1>
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
				<h1>업체관리</h1>
				<ul>
					<li><a href="list">등록된 업체 리스트</a></li>
					<li><a href="regList" class="active">업체 등록 관리</a></li>
				</ul>
			</aside>
			<div class="container">
				<nav id="nav" class="nav">
					<ul>
						<li class="current-tab"><a href="list"> <i
								class="fas fa-hotel"></i><span>업체관리</span>
						</a></li>
						<li><a href="/admin/userInfo/list"> <i
								class="fas fa-user-circle"></i><span> 회원관리</span>
						</a></li>
						<li><a href="/admin/promotion/goldenTime/list"> <i
								class="far fa-calendar-alt"></i><span>프로모션관리</span>
						</a></li>
						<li><a href="/admin/customerService/notice/list"> <i
								class="fas fa-headphones"></i><span>고객센터</span>
						</a></li>
					</ul>
				</nav>
				<main id="main" class="main">
					<div class="sub-container">
						<div class="breadcrumb">
							<ul class="breadcrumb-list">
								<li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i
									class="fas fa-angle-right"></i></li>
								<li>&nbsp;&nbsp;&nbsp;업체관리&nbsp;&nbsp;&nbsp;<i
									class="fas fa-angle-right"></i></li>
								<li>&nbsp;&nbsp;&nbsp;업체 등록 관리&nbsp;&nbsp;&nbsp;</li>
							</ul>
						</div>

						<div class="main-search">
							<h1>업체 등록 관리</h1>
							
							<form action="">
								<select name="ac" class="acc-catagory">
									<option ${(param.ac == "hotel")?"selecte":"" } value="hotel">호텔</option>
									<option ${(param.ac == "motel")?"selecte":"" }value="motel">모텔</option>
									<option ${(param.ac == "guesthouse")?"selecte":"" } value="guesthouse">게스트하우스</option>
									<option ${(param.ac == "resort")?"selecte":"" }value="resort">리조트</option>
									<option ${(param.ac == "pension")?"selecte":"" }value="pension">펜션</option>
								</select> 
								<select name="f">
	                            	<option ${(param.f == "companyName")?"selecte":"" } value="company_name">사업자</option>
	                            	<option ${(param.f == "acc_name")?"selecte":"" } value="acc_name">숙소</option>
	                            </select>
								
								<input type="text" name="search"value="${param.search }">
								<input type="submit" value="검색">
							</form>
						</div>
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
										<c:forEach var="al" items="${list}">
											<tr>
												<td>${al.id}</td>
												<td>${al.companyName}</td>
												<td><a href="applyDetail?accName=${al.name}">${al.name}</a></td>
												<td>${al.location}</td>
												<td>${al.regdate}</td>
												<td>${al.phone}</td>
												<td>${al.accType}</td>
												<td><input type="checkbox"></td>
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
											<td><button type="submit">승인</button></td>
											<td><button type="submit">삭제</button></td>
										</tr>
										<tr>
											<td colspan="8" class="no-border">
												<div class="pager-container">
													<div class="btn btn-prev">
														<span><a href="">이전</a></span>
													</div>
													<ul class="pager-list">
														<li class="active-page"><a href="">1</a></li>
														<li><a href="">2</a></li>
														<li><a href="">3</a></li>
														<li><a href="">4</a></li>
														<li><a href="">5</a></li>
														<li><a href="">6</a></li>
														<li><a href="">7</a></li>
														<li><a href="">8</a></li>
														<li><a href="">9</a></li>
														<li><a href="">10</a></li>
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
					</div>
				</main>
			</div>
		</section>
	</main>
</body>
</html>
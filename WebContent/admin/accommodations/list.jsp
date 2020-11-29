<%@page import="com.teum.entity.AccommodationList"%>
<%@page import="com.teum.service.AccommodationListService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	AccommodationListService service = new AccommodationListService();
	List<AccommodationList> list = service.getList();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../css/reset.css">
    <link rel="stylesheet" href="../../css/admin/accommodations/list.css">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <title>등록된 업체 리스트</title>
</head>
<body>
    <header id="header" class="header">
        <h1><a href="http://127.0.0.1:5500/main.html">틈</a></h1>
        <nav>
            <h1>메인메뉴</h1>
            <ul>
                <li><a href="">공지사항</a></li>
                <li><a href="">이벤트</a></li>
                <li><a href="">더보기</a></li>
                <li><a href="">로그인</a></li>
            </ul>
        </nav>
    </header>

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
                                <% for(AccommodationList al : list){ %>
                                    <tr>
                                        <td><%=al.getId() %></td>
                                        <td><%=al.getName() %></td>
                                        <td><%=al.getAccName() %></td>
                                        <td><%=al.getLocation() %></td>
                                        <td><%=al.getRegdate() %></td>
                                        <td><%=al.getPhone() %></td>
                                        <td><%=al.getAccType() %></td>
                                        <td><input type="checkbox"></td>
                                    </tr>
                                    <% } %> 
                                    <tr>
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
</body>
</html>
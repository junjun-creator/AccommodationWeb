<%@page import="com.teum.entity.Event"%>
<%@page import="java.util.List"%>
<%@page import="com.teum.service.EventService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	EventService service = new EventService();
	List<Event> list = service.getList();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../css/reset.css">
    <link rel="stylesheet" href="../../../css/admin/promotion/event/list.css">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <title>이벤트 리스트</title>
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
            <h1>프로모션 관리</h1>
                <ul>
                    <li><a href="">골든타임 관리</a></li>
                    <li><a href="" class="active">이벤트 관리</a></li>
                </ul>
        </aside>
        <div class="container">
            <nav id="nav" class="nav">
                <ul>
                    <li><a href=""><i class="fas fa-hotel"></i><span>업체관리</span></li></a>
                    <li><a href=""><i class="fas fa-user-circle"></i><span> 회원관리</span></a></li>
                    <li class="current-tab"><a href=""><i class="far fa-calendar-alt"></i><span>프로모션관리</span></a></li>
                    <li><a href=""><i class="fas fa-headphones"></i><span>고객센터</span></a></li>
                </ul>
            </nav>
            <main id="main" class="main">
                <div class="sub-container">
                    <div class="breadcrumb">
                        <ul class="breadcrumb-list">
                            <li><i class="fas fa-home"></i>HOME ▶ </li>
                            <li>프로모션관리 ▶ </li>
                            <li>이벤트 관리</li>
                        </ul>
                    </div>
                    <h1>이벤트 리스트</h1>
                    <section>
                        <form action="" class="list-board">
                            <table>
                                <thead>
                                    <tr>
                                        <td class="col-s">No.</td>
                                        <td class="col-s">진행상태</td>
                                        <td class="col-m">종료일</td>
                                        <td>제목</td>
                                        <td class="col-m">작성자</td>
                                        <td class="col-m">작성일</td>
                                        <td class="col-s">공개여부</td>
                                        <td class="col-s">삭제</td>
                                    </tr>
                                </thead>
                                <tbody>
                                	<%
                                	for (Event e : list) {
                                		String status = "진행중";
                                		if (e.getStatus() == 0)
                                			status = "종료";
                                	%>
                                    <tr>
                                        <td><%=e.getEventNo() %></td>
                                        <td class="event-ing"><%=status%></td>
                                        <td><%=e.getEndDate() %></td>
                                        <td class="text-left"><a href="detail.jsp"><%=e.getTitle() %></a></td>
                                        <td>관리자</td>
                                        <td><%=e.getRegDate() %></td>
                                        <td><input type="checkbox"></td>
                                        <td><input type="checkbox"></td>
                                    </tr>
                                    <%}%>
                                    
                                    <tr class="btn-delete">
                                        <td colspan="8">
                                            <input type="submit" value="글쓰기">
                                            <input type="submit" value="일괄공개">
                                            <input type="submit" value="전체삭제">
                                            <input type="submit" value="일괄삭제">
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                        <div class="pager-container">
                            <div class="btn btn-prev">
                                <span><a href="">이전</a></span>
                            </div>
                            <ul class="pager-list">
                                <li><a href="">1</a></li>
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
                    </section>
                </div>
            </main>
        </div>
    </section>
</body>

</html>
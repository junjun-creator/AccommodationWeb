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
    <link rel="stylesheet" href="../../../css/admin/promotion/event/reg.css">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <title>이벤트 등록</title>
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
                    <h1>이벤트 등록</h1>
                    <section class="form-sec">
                        <form action="" class="reg-form">
                        <%Event e = list.get(0); %>
                            <table class="table">
                                <tr>
                                    <th class="col-m">제목</th>
                                    <td class="col-l text-left">
                                        <input type="text" class="input-title"  value="<%=e.getTitle()%>" autofocus required>
                                        <input type="checkbox" class="checkbox-open"><span>즉시 공개</span>
                                    </td>
                                </tr>
                                <tr>
                                    <th>첨부파일</th>
                                    <td class="text-left">
                                        <input type="file">
                                    </td>
                                </tr>
                                <tr>
                                    <th>내용</th>
                                    <td class="text-left">
                                        <textarea class="textarea" cols="75" rows="25"></textarea>
                                    </td>
                                </tr>
                            </table>
                            <div>
                                <input class="btn-submit" type="submit" value="등록" />
                                <button class="btn-cancel" onclick="location.href='list.jsp'">취소</button>
                            </div>
                        </form>
                    </section>
                </div>
            </main>
        </div>
    </section>
</body>

</html>
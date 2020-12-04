<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../css/reset.css" type="text/css">
    <link rel="stylesheet" href="../../../css/admin/layout.css">
    <link rel="stylesheet" href="../../../css/admin/notice/reg.css">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <title>noticeCreate</title>
</head>
<body>
    <header class="sec_header">
        <div class="header pcHeader">
            <div class="header_h1">
                <h1><a class="teum_logo" href="http://127.0.0.1:5500/main.html">틈</a></h1>
            </div>
            <div>
                <ul class="main_menu">
                    <li class="header_search"><input type="text"><a href=""><i class="fas fa-search"></i></a></li>
                    <li><a href="">공지사항</a></li>
                    <li><a href="">이벤트</a></li>
                    <li><a href="">더보기</a></li>
                    <li class="mypage"><a href="">로그인</a>
                        <div class="mega_menu">
                            <ul>
                                <li><a href="">submenu</a></li>
                                <li><a href="">submenu</a></li>
                                <li><a href="">submenu</a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </header>
    <main>
	    <section class="body">
	        <aside id="aside" class="aside">
	            <h1>고객센터</h1>
	                <ul>
	                    <li><a href="list" class="active">공지사항</a></li>
	                    <li><a href="/admin/customerService/QnA/list">QnA</a></li>
	                </ul>
	        </aside>
	        <div class="container">
	            <nav id="nav" class="nav">
	                <ul>
	                    <li><a href=""><i class="fas fa-hotel"></i><span>업체관리</span></a></li>
	                    <li><a href=""><i class="fas fa-user-circle"></i><span>회원관리</span></a></li>
	                    <li><a href=""><i class="far fa-calendar-alt"></i><span>프로모션관리</span></a></li>
	                    <li class="current-tab"><a href=""><i class="fas fa-headphones"></i><span>고객센터</span></a></li>
	                </ul>
	            </nav>
	            <main id="main" class="main">
	                <h1 class="d-none">공지사항</h1>
	                <section class="sub-container">
	                    <div class="breadcrumb">
	                        <ul class="breadcrumb-list">
	                            <li><i class="fas fa-home"></i>HOME ▶ </li>
	                            <li>고객센터 ▶ </li>
	                            <li>공지사항 리스트 ▶</li>
	                            <li>공지사항 등록</li>
	                        </ul> 
	                    </div>
	                    <section class="form-sec">
	                        <h1>공지사항 등록</h1>
	                        <form method="post"  class="reg-form">
	                            <table class="table">
	                                <tr>
	                                    <th class="col-m">제목</th>
	                                    <td class="col-l text-left" colspan="3">
	                                        <input type="text"  name="title"  class="input-title" autofocus required>
	                                        <input type="checkbox" class="checkbox-open"  name="pub" ><span>즉시 공개</span>
	                                    </td>
	                                </tr>
	                                <tr>
	                                    <th >첨부파일</th>
	                                    <td class="text-left">
	                                        <input type="file">
	                                    </td>
	                                    <th class="col-m">작성자</th>
	                                    <td >
	                                    <input type="hidden" name="writer_id" value="관리자">
	                                     <span>관리자</span></td>
	                                </tr>
	                                <tr>
	                                    <th>내용</th>
	                                    <td class="text-left" colspan="3">
	                                        <textarea class="textarea" cols="75" rows="25"  name="content"></textarea>
	                                    </td>
	                                </tr>
	                            </table>
	                            <div>
	                                <input class="btn-submit" type="submit" value="등록" />
	                                <button class="btn-cancel"  onclick="location.href='list' ">취소</button>
	                            </div>
	                        </form>
	                    </section>
	                </section>
	            </main>
	        </div>
	    </section>
    </main>
</body>
</html>
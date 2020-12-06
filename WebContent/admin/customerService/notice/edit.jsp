<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../../css/reset.css" type="text/css">
     <link rel="stylesheet" href="../../../css/admin/layout.css">
    <link rel="stylesheet" href="../../../css/admin/notice/edit.css">
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
	                    <li><a href="" class="active">공지사항</a></li>
	                    <li><a href="">QnA</a></li>
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
	                <h1 class="d-none">공지사항</h1>
	                <section class="sub-container">
	                    <div class="breadcrumb">
	                        <ul class="breadcrumb-list">
	                            <li><i class="fas fa-home"></i>HOME ▶ </li>
	                            <li>고객센터 ▶ </li>
	                            <li>공지사항 리스트 ▶</li>
	                            <li>공지사항 디테일 ▶</li>
	                            <li>공지사항 수정</li>
	                        </ul>
	                    </div>
	                    <section class="form-sec">
	                        <h1>공지사항 디테일</h1>
	                        <form action="edit" method="post" class="reg-form">
	                            <table class="table">
	                                <tr>
	                                    <th class="col-m">제목</th>
	                                    <td class="col-l text-left">
	                                    	<input type="text" name="title" value="${n.title}" >
	                                    </td>
	                                    <th class="col-m">상태</th>
	                                    <td class="col-l text-left">
	                                      <input type="checkbox" class="checkbox-open"  name="pub"  ${n.pub}><span>즉시 공개</span>
	                                    </td>
	                                </tr>
	                                <tr>
	                                    <th>내용</th>
	                                    <td class="text-left" colspan="3">
	                                       <textarea rows="25" cols="75" name="content">${n.content}</textarea>
	                                    </td>
	                                </tr>
	                            </table>
	                            <div>
	                            	<input type="hidden" name="id" value="${n.id}">
	                                <a class="btn-cancel"  href="detail?id=${n.id}"><span>취소<span></a>
	                                <input type="submit"  class="btn-submit"  value="저장">
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
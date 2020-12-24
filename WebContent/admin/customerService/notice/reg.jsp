<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/images/logo.png">
     <link rel="stylesheet" href="/css/reset.css" type="text/css">
    <link rel="stylesheet" href="/css/layout.css">
    <link rel="stylesheet" href="/css/admin/layout.css">
    <link rel="stylesheet" href="/css/admin/notice/reg.css">
     <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <title>고객센터 | 틈을 채우다</title>
</head>
<body>
     <jsp:include page="/inc/header.jsp"/>
    <main>
	    <section class="body">
	        <aside id="aside" class="aside">
	            <h1>고객센터</h1>
	                <ul>
	                    <li class="active"><a href="list" >공지사항</a></li>
	                    <li><a href="/admin/customerService/QnA/list">QnA</a></li>
	                </ul>
	        </aside>
	        <div class="container">
	            <nav id="nav" class="nav">
	                <ul>
	                     <li><a href="/admin/accommodations/list"><i class="fas fa-hotel"></i><span>업체관리</span></a></li>
	                    <li><a href="/admin/userInfo/users/usersList"><i class="fas fa-user-circle"></i><span>회원관리</span></a></li>
	                    <li><a href="/admin/promotion/goldenTime/list"><i class="far fa-calendar-alt"></i><span>프로모션관리</span></a></li>
	                    <li class="current-tab"><a href="list"><i class="fas fa-headphones"></i><span>고객센터</span></a></li>
	                </ul>
	            </nav>
	            <main id="main" class="main">
	                <h1 class="d-none">공지사항</h1>
	                <section class="sub-container">
	                    <div class="breadcrumb">
	                        <ul class="breadcrumb-list">
	                            <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i> </li>
                        		<li>&nbsp;&nbsp;&nbsp;고객센터&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
	                            <li>&nbsp;&nbsp;&nbsp;공지사항 리스트&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
	                            <li>&nbsp;&nbsp;&nbsp;공지사항 등록</li>
	                        </ul> 
	                    </div>
	                    <section class="form-sec">
	                        <h1>공지사항 등록</h1>
	                        <form method="post"  class="reg-form" enctype="multipart/form-data">
	                            <table class="table">
	                                <tr>
	                                    <th class="col-m">제목</th>
	                                    <td class="col-l text-left" colspan="4">
	                                        <input type="text"  name="title"  class="input-title" autofocus required>
	                                        <input type="checkbox" class="checkbox-open"  name="OPEN_STATUS" ><span>즉시 공개</span>
	                                    </td>
	                                </tr>
	                                <tr>
                                		<th>첨부파일</th>
                                		<td colspan="2">
                                			<input type="file" accept=".jpg,.png" name="IMAGE_NAME">
                                		</td>
	                                    <th >작성자</th>
	                                    <td>
	                                    	<input type="hidden" name="ADMIN_ID" value="1">
	                                     	<span>관리자</span>
                                     	</td>
	                                </tr>
	                                <tr>
	                                    <th>내용</th>
	                                    <td class="text-left" colspan="4">
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
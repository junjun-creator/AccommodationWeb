<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="icon" href="/images/logo.png">
     <link rel="stylesheet" href="/css/reset.css" type="text/css">
    <link rel="stylesheet" href="/css/layout.css">
    <link rel="stylesheet" href="/css/admin/layout.css">
    <link rel="stylesheet" href="/css/admin/notice/edit.css">
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
	                    <li class="active"><a href="list">공지사항</a></li>
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
	                            <li>&nbsp;&nbsp;&nbsp;공지사항 디테일&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
	                        	<li>&nbsp;&nbsp;&nbsp;공지사항 수정</li>
	                        </ul>
	                    </div>
	                    <section class="form-sec">
	                        <h1>공지사항 수정</h1>
	                        <form action="edit" method="post" class="reg-form" enctype="multipart/form-data">
	                            <table class="table">
	                                <tr>
	                                    <th class="col-m">제목</th>
	                                    <td class="col-l text-left">
	                                    	<input type="text" name="title" value="${n.title}" >
	                                    </td>
	                                    <th class="col-m">상태</th>
	                                    <td class="col-l text-left">
	                                    
	                                      <input type="checkbox" class="checkbox-open"  name="OPEN_STATUS"  <c:choose>
	                                    	<c:when test="${n.openStatus eq 1}">
	                                    	checked
	                                    	</c:when>
	                                    	<c:otherwise>
	                                    	null
	                                    	</c:otherwise>
	                                    </c:choose>><span>즉시 공개</span>
	                                    </td>
	                                </tr>
	                                <tr>
	                                	<th>첨부파일</th>
                                		<td colspan="3">
                                			<input type="file" accept=".jpg,.png" name="IMAGE_NAME" >
                                		</td>
	                                </tr>
	                                <tr>
										<th>첨부된파일</th>
			                                <td colspan="3" class="text-align-left text-indent">
			                                <c:forTokens var="fileName" items="${n.imageName}" delims="," varStatus="st">
			                                	<fmt:formatDate var="year" value="${n.regdate}"  pattern="yyyy"/>
			                                	<a download href="/static/notice/${year}/${n.id}/${fileName}">${fileName}</a>
			                                	<c:if test="${st.last ==false }">
			                                		/
			                                	</c:if>
			                                </c:forTokens>
		                                </td>
	                                </tr>
	                                <tr>
	                                    <th>내용</th>
	                                    <td class="text-left" colspan="3">
	                                    
	                                       <textarea rows="25" cols="100" name="content">${n.content}</textarea>
	                                    </td>
	                                </tr>
	                            </table>
	                            <div>
	                            	<input type="hidden" name="ADMIN_ID" value="${n.adminId}">
	                            	<input type="hidden" name="id" value="${n.id}">
	                                <a class="btn-cancel"  href="detail?id=${n.id}"><span>취소</span></a>
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
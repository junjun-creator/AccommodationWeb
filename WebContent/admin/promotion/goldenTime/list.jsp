<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="stylesheet" href="/css/reset.css" type="text/css">
    <link rel="stylesheet" href="/css/layout.css">
    <link rel="stylesheet" href="/css/admin/layout.css">
    <link rel="stylesheet" href="/css/admin/promotion/goldenTime/list.css">
     <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <title>골든타임 리스트</title>
</head>
<body>
    <header class="sec-header-page">
        <section class="header-sec pcHeader">
            <div class="header-logo">
                <h1><a class="teum-logo" href="http://127.0.0.1:5500/main.html">틈</a></h1>
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
	            <h1>프로모션 관리</h1>
	                <ul>
	                    <li><a href="list" class="active">골든타임 관리</a></li>
	                    <li><a href="/admin/promotion/event/list" >이벤트 관리</a></li>
	                </ul>
	        </aside>
	        <div class="container">
	            <nav id="nav" class="nav">
	                <ul>
	                    <li><a href="/admin/accommodations/list"><i class="fas fa-hotel"></i><span>업체관리</span></a></li>
	                    <li><a href="/admin/userInfo/list"><i class="fas fa-user-circle"></i><span> 회원관리</span></a></li>
	                    <li class="current-tab"><a href="/admin/promotion/goldenTime/list"><i class="far fa-calendar-alt"></i><span>프로모션관리</span></a></li>
	                    <li><a href="/admin/customerService/notice/list"><i class="fas fa-headphones"></i><span>고객센터</span></a></li>
	                </ul>
	            </nav>
	            <main id="main" class="main">
	                <h1 class="d-none">골든타임</h1>
	                <section class="sub-container">
	                    <div class="breadcrumb">
	                        <ul class="breadcrumb-list">
	                             <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i> </li>
                        		<li>&nbsp;&nbsp;&nbsp;프로모션관리&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
	                            <li>&nbsp;&nbsp;&nbsp;골든타임 리스트</li>
	                        </ul>
	                    </div>
	                    <section class="list-board">
	                    	<div class="main-search">	
		                        <h1>골든타임 리스트</h1>
		                        <div>
			                        <select name="" class="AccTypeCatagory">
				                       <form action="">
				                           <option value="" selected disabled>전체보기</option>
				                           <option value="호텔">호텔</option>
				                           <option value="모텔">모텔</option>
				                           <option value="게스트하우스">게스트하우스</option>
				                           <option value="리조트">리조트</option>
				                           <option value="펜션">펜션</option>
				                       </form>
				                       	<input type="text">
			                        	<input type="submit" value="검색">
				                    </select>
			                    </div>
	                    	</div>	
	                        <table>
	                            <thead>
	                                <tr>
	                                    <td class="col-s">No.</td>
	                                    <td class="col-s">사업자명</td>
	                                    <td class="col-sm">숙소명</td>
	                                    <td class="col-sm">위치</td>
	                                    <td class="col-sm">등록일</td>
	                                    <td class="col-sm">연락처</td>
	                                    <td class="col-s">업체종류</td>
	                                    <td class="col-sm">삭제<input type="checkbox" class="selectAllDelete"></td>
	                                </tr>
	                            </thead>
	                            <tbody>
	                                <tr>
	                                    <td>1</td>
	                                    <td>김민영</td>
	                                    <td>시그니엘 서울</td>
	                                    <td>서울시 송파구</td>
	                                    <td>2020-11-10</td>
	                                    <td>010-7788-9988</td>
	                                    <td>호텔</td>
	                                    <td>
	                                        <input type="checkbox" name="" class="memberChk" >
	                                    </td>
	                                </tr>
	                               
	                                <tr class="btn-delete">
	                                    <td colspan="8">
	                                        <form action="">
	                                            <input type="submit" value="삭제">
	                                        </form>
	                                    </td>
	                                </tr>
	                            </tbody>
	                        </table>
	                    </section>
	                    <section>
	                        <h1 class="d-none">페이지 정보</h1>
	                        <div>
	                            1 / 2 pages
	                        </div>
	                    </section>
	                    <section>
	                        <h1 class="d-none">페이지 요청목록</h1>
	                        <ul>
	                            <li>1</li>
	                            <li>2</li>
	                        </ul>
	                    </section>
	                </section>
	            </main>
	        </div>
	    </section>
	</main>
    <script>
        var selectAll = document.querySelector(".selectAllDelete");
        selectAll.addEventListener('click', function(){
            var objs = document.querySelectorAll(".memberChk");
            for (var i = 0; i < objs.length; i++) {
              objs[i].checked = selectAll.checked;
            };
        }, false);
         
        var objs = document.querySelectorAll(".memberChk");
        for(var i=0; i<objs.length ; i++){
          objs[i].addEventListener('click', function(){
            var selectAll = document.querySelector(".selectAllDelete");
            for (var j = 0; j < objs.length; j++) {
              if (objs[j].checked === false) {
                selectAll.checked = false;
                return;
              };
            };
            selectAll.checked = true;                                   
        }, false);
        } 
      </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.teum.service.MemberService" %>
<%@ page import="com.teum.entity.Member" %>
<%@ page import="java.util.List" %>
    
<% 
	MemberService service = new MemberService();
	List<Member> list = service.getList(0);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../css/reset.css">
    <link rel="stylesheet" href="../../css/admin/layout.css">
    <link rel="stylesheet" href="../../css/admin/userInfo/list.css">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <title>등록된 업체 리스트</title>
</head>
<body>
    <header class="sec-header">
        <div id="header" class="header">
            <div class="header-h1">
                <h1><a class="teum-logo" href="http://127.0.0.1:5500/main.html">틈</a></h1>
            </div>
            <div>
                <ul class="main-menu">
                    <li class="header-search"><input type="text"><a href=""><i class="fas fa-search"></i></a></li>
                    <li><a href="">공지사항</a></li>
                    <li><a href="">이벤트</a></li>
                    <li><a href="">더보기</a></li>
                    <li class="mypage"><a href="">로그인</a>
                        <div class="mega-menu">
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
	            <h1>회원관리</h1>
	                <ul>
	                    <li><a href="" class="active">개인회원리스트</a></li>
	                    <li><a href="">기업회원리스트</a></li>
	                </ul>
	        </aside>
	        <div class="container">
	            <nav id="nav" class="nav">
	                <ul>
	                    <li><a href=""><i class="fas fa-hotel"></i><span>업체관리</span></a></li>
	                    <li class="current-tab"><a href=""><i class="fas fa-user-circle"></i><span>회원관리</span></a></li>
	                    <li><a href=""><i class="far fa-calendar-alt"></i><span>프로모션관리</span></a></li>
	                    <li><a href=""><i class="fas fa-headphones"></i><span>고객센터</span></a></li>
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
	
	                    <div>
	                        <h1>등급별 회원수</h1>
	                    </div>
	                    <div class="list-board">
	                        <table>
	                            <thead>
	                                <tr>
	                                    <td class="col-sm">등급</td>
	                                    <td class="col-m">인원</td>
	                                </tr>
	                            </thead>
	                            <tbody>
	                                <tr>
	                                    <td>실버</td>
	                                    <td>100명</td>
	                                </tr>
	                                <tr>
	                                    <td>골드</td>
	                                    <td>30명</td>
	                                </tr>
	                                <tr>
	                                    <td>플레티넘</td>
	                                <td>3명</td>
	                                </tr>
	                                <tr>
	                                    <td>다이아</td>
	                                    <td>1명</td>
	                                </tr>
	                            </tbody>
	                        </table>
	                    </div>
	
	                    <div>
	                        <h1>등록된 개인회원리스트</h1>
	                        <select name="" id="">
	                            <option value="">전체등급</option>
	                            <option value="">실버</option>
	                            <option value="">골드</option>
	                            <option value="">플레티넘</option>
	                            <option value="">다이아</option>
	                        </select>
	                    </div>
	                    <section>
	                        <form action="" class="list-board">
	                            <table>
	                                <thead>
	                                    <tr>
	                                        <td class="col-s">No.</td>
	                                        <td class="col-sm">회원명</td>
	                                        <td class="col-m">이메일</td>
	                                        <td class="col-sm">생년월일</td>
	                                        <td class="col-m">휴대폰번호</td>
	                                        <td class="col-sm">회원종류</td>
	                                        <td class="col-sm">회원등급</td>
	                                        <td class="col-s"><input type="checkbox"></td>
	                                    </tr>
	                                </thead>
	                                <tbody>
	                                <% for(Member m : list){ %>
	                                    <tr>
	                                        <td class="col-s"><%=m.getId() %></td>
	                                        <td class="col-sm"><%=m.getName() %></td>
	                                        <td class="col-m" style="text-overflow:ellipsis; overflow:hidden; white-space:nowrap;"><%=m.getEmail() %></td>
	                                        <td class="col-sm"><%=m.getBirthday() %></td>
	                                        <td class="col-m"><%=m.getPhone() %></td>
	                                        <td class="col-sm user-type">개인회원</td>
	                                        <td class="col-sm user-rank"><%=m.getRank() %></td>
	                                        <td class="col-s"><input type="checkbox"></td>
	                                    </tr>
	                                    <%} %>
	                                    <!-- <tr>
	                                        <td class="col-s">2</td>
	                                        <td class="col-sm">신중언</td>
	                                        <td class="col-sm">닉네임</td>
	                                        <td class="col-m">sje@newlecture.com</td>
	                                        <td class="col-sm">000000</td>
	                                        <td class="col-m">010-3462-8452</td>
	                                        <td class="col-m">2020-11-05</td>
	                                        <td class="col-s"><input type="checkbox"></td>
	                                    </tr>
	                                    <tr>
	                                        <td class="col-s">3</td>
	                                        <td class="col-sm">김병준</td>
	                                        <td class="col-sm">닉네임</td>
	                                        <td class="col-m">kbj@newlecture.com</td>
	                                        <td class="col-sm">000000</td>
	                                        <td class="col-m">010-2365-5678</td>
	                                        <td class="col-m">2020-11-14</td>
	                                        <td class="col-s"><input type="checkbox"></td>
	                                    </tr>
	                                    <tr>
	                                        <td class="col-s">4</td>
	                                        <td class="col-sm">박수현</td>
	                                        <td class="col-sm">닉네임</td>
	                                        <td class="col-m">psh@newlecture.com</td>
	                                        <td class="col-sm">000000</td>
	                                        <td class="col-m">010-3863-1263</td>
	                                        <td class="col-m">2020-11-23</td>
	                                        <td class="col-s"><input type="checkbox"></td>
	                                    </tr> -->
	                                    <tr class="btn-delete">
	                                        <td colspan="8"><input type="submit" value="삭제"></td>
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
    
    <script type="text/javascript">
    	window.addEventListener("load",function(){
    		
	    	var rank = document.querySelectorAll(".user-rank");
    		console.log(rank);
    		/* var icon = document.createElement('i');
    		icon.setAttribute("class","far fa-gem");
    		icon.style.color="red";
    		
			for(var v of rank){
				console.log(icon);
				v.append(icon);
				switch(v.innerText){
				case "0":
					v.innerText = "실버";
					break;
				case "1":
					v.innerText = "골드";
					break;
				case "2":
					v.innerText = "플래티넘";
					break;
				case "3":
					v.innerText = "다이아";
					break;
				}
			}
			
			var type = document.querySelectorAll(".user-type");
			for(var v of type){
				switch(v.innerText){
				case "0":
					v.innerText ="개인회원";
					break;
				case "1":
					v.innerText = "기업회원";
					break;
				}
			} */
		
			var icon = document.createElement('i');
	    	icon.setAttribute("class","far fa-gem");
	    	
			for(var i=0;i<rank.length;i++){
				(function(m){
					
					switch(rank[m].innerText){
		    		
					case "0":
						rank[m].style.color = "green";
						rank[m].innerHTML = "실버<i class='fas fa-gem'></i>";
						break;
					case "1":
						rank[m].style.color = "gold";
						rank[m].innerHTML = "골드<i class='fas fa-gem'></i>";
						break;
					case "2":
						rank[m].style.color = "gray";
						rank[m].innerHTML = "플래티넘<i class='fas fa-gem'></i>";
						console.log(m);
						break;
					case "3":
						rank[m].style.color = "black";
						rank[m].innerHTML = "다이아<i class='fas fa-gem'></i>";
						console.log(m);
						break;
					}
				})(i);
	    	}
    	});

    </script>
</body>
</html>
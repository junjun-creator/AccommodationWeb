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
    <title>숙소 리스트</title>
    <link rel="stylesheet" href="/css/reset.css" type="text/css">
    <link rel="stylesheet" href="/css/layout.css">
    <link rel="stylesheet" href="/css/accommodationList/list.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <script src="/js/accommodationLists/list.js"></script>

</head>
<body>
    <header class="sec-header-page">
        <section class="header-sec pcHeader">
            <div class="header-logo">
                <h1><a class="teum-logo" href="/index">틈</a></h1>
            </div>
            <div>
                <ul class="main-menu">
                    <li class="header-search"><input type="text"><a href=""><i class="fas fa-search"></i></a></li>
                    <li><a href="">제안하기</a></li>
                    <li><a href="">예약내역</a></li>
                    <li class="sub-page">
                        <a href="">더보기</a>
                        <div class="mega-menu">
                            <ul>
                                <li><a href="/notice/list">공지사항</a></li>
                                <li><a href="/event/list">이벤트</a></li>
                                <li><a href="">1:1 문의</a></li>
                            </ul>
                        </div>
                    </li>
                    <li class="sub-page">
                        <a href="" class="character"><i class="fas fa-sort-down"></i></a>
                        <div class="mega-menu">
                            <ul>
                                <li><a href="">내정보</a></li>
                                <li><a href="">제안내역</a></li>
                                <li><a href="">찜한 숙소</a></li>
                                <li><a href="/logout">로그아웃</a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </section>
    </header>

    <div class="container-wrapper">
        <div class="container">
            <aside class="aside">
                <form action="list" method="get">
                    <h1>지역</h1>
                    <div>
                       <input type="hidden" name="type" value="${type}">
                        <select name="bigCity" class="big-city">
                            <option value="서울">서울</option>
                            <option value="제주">제주</option>
                            <option value="부산">부산</option>
                            <option value="강원">강원</option>
                            <option value="경기">경기</option>
                            <option value="인천">인천</option>
                            <option value="경상">경상</option>
                            <option value="전라">전라</option>
                            <option value="충청">충청</option>
                        </select>
                        <select name="smallCity" class="small-city">
                            <!-- 서울 -->
                            <option value="강남구">강남구</option>
                            <option value="강동구">강동구</option>
                            <option value="강북구">강북구</option>
                            <option value="강서구">강서구</option>
                            <option value="관악구">관악구</option>
                            <option value="광진구">광진구</option>
                            <option value="구로구">구로구</option>
                            <option value="금천구">금천구</option>
                            <option value="노원구">노원구</option>
                            <option value="도봉구">도봉구</option>
                            <option value="동대문구">동대문구</option>
                            <option value="동작구">동작구</option>
                            <option value="마포구">마포구</option>
                            <option value="서대문구">서대문구</option>
                            <option value="서초구">서초구</option>
                            <option value="성동구">성동구</option>
                            <option value="성북구">성북구</option>
                            <option value="송파구">송파구</option>
                            <option value="양천구">양천구</option>
                            <option value="영등포구">영등포구</option>
                            <option value="용산구">용산구</option>
                            <option value="은평구">은평구</option>
                            <option value="종로구">종로구</option>
                            <option value="중구">중구</option>
                            <option value="중랑구">중랑구</option>
                        </select>
                    </div>
                    <br>
                    <h1>인원수</h1>
                    <div class="head-count">
                        <section name="head-count">
                            <select class="form-option people-select">
                                <option value="" name="people">1</option>
                                <option value="" name="people" selected>2</option>
                                <option value="" name="people">3</option>
                                <option value="" name="people">4</option>
                                <option value="" name="people">5</option>
                                <option value="" name="people">6</option>
                                <option value="" name="people">7</option>
                                <option value="" name="people">8</option>
                                <option value="" name="people">9</option>
                                <option value="" name="people">10</option>
                                <option value="" name="people">11</option>
                                <option value="" name="people">12</option>
                                <option value="" name="people">13</option>
                                <option value="" name="people">14</option>
                                <option value="" name="people">15</option>
                                <option value="" name="people">16</option>
                                <option value="" name="people">17</option>
                                <option value="" name="people">18</option>
                                <option value="" name="people">19</option>
                                <option value="" name="people">20</option>
                            </select>
                        </section>
                    </div>
                    <br>
    
                    <h1>날짜</h1>
                    <div class="calander">
                        체크인&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="date"><br>
                        체크아웃 &nbsp;&nbsp;&nbsp;<input type="date">
                    </div>
                    <br>
    
                    <h1>상세조건</h1>
                    <div>
                        <input type="checkbox" name="reserve">&nbsp;예약가능&nbsp;&nbsp;
                        <input type="checkbox" name="goldentime">&nbsp;골든타임
                    </div>
                    <br>
        
                    <h1>침대 종류</h1>
                    <div>
                        <input type="image" id="싱글" alt="" src="../images/침대 아이콘/싱글.png">
                        <input type="image" id="더블" alt="" src="../images/침대 아이콘/더블.png">
                        <input type="image" id="트윈" alt="" src="../images/침대 아이콘/트윈.png">
                    </div>
                    <br>
                    
                    <div class="submit-container">
                        <button type="reset" value="초기화" class="btn init-btn">초기화</button>
                        <button type="submit" value="적용" class="btn app-btn">적용</button>
                    </div>
                </form>
            </aside>
            
            <main class= "main">
                <div class="breadcrumb">
                    <ul class="breadcrumb-list">
                        <li><i class="fas fa-home"></i>&nbsp;&nbsp;HOME&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
                        <li>&nbsp;&nbsp;&nbsp;숙소 리스트&nbsp;&nbsp;&nbsp;</li>
                    </ul>
                </div>
                <section class="main-header">
                    <span class="acc-type">숙소리스트 / <span class="small-span">Accommodation List</span></span>
                </section>
                
                <section class="category-sec">
                    <div class="category-bar">
                        <ul>
                            <li>
                                <a class="category-img" href="list?type=1">
                                    <img src="/images/main/hotel-icon.png" alt="">
                                    <span>호텔</span>
                                </a>
                            </li>
                            <li>
                                <a class="category-img" href="list?type=2">
                                    <img src="/images/main/motel-icon.png" alt="">
                                    <span>모텔</span>
                                </a>
                            </li>
                            <li>
                                <a class="category-img" href="list?type=3">
                                    <img src="/images/main/guesthouse-icon.png" alt="">
                                    <span>게스트하우스</span>
                                </a>
                            </li>
                            <li>
                                <a class="category-img" href="list?type=4">
                                    <img src="/images/main/resort-icon.png" alt="">
                                    <span>리조트</span>
                                </a>
                            </li>
                            <li>
                                <a class="category-img" href="list?type=5">
                                    <img src="/images/main/pension-icon.png" alt="">
                                    <span>펜션</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </section>
                
                <section class="picked-item-sec">
                   <c:forEach var="acc" items="${accList}">
                    <div class="snip1368" onclick="location.href='detail?accId=${acc.id}'">
                        <img src="/images/company/호텔/서울/강남구/신라스테이_삼성/메인.jpg" alt="">
                        <h3>예약하기</h3>
                        <figcaption>
                            <div class="icons"><a href="#"><i class="ion-social-reddit-outline"></i></a>
                            <a href="#"> <i class="ion-social-twitter-outline"></i></a>
                            <a href="#"> <i class="ion-social-vimeo-outline"></i></a>
                            </div>
                        </figcaption>
                        <div class="description-item">
                            <p>${acc.name}</p>
                            <P>★ 9.1</P>
                            <p>${acc.location}</p>
                        </div>
                        <div class="item-price">
                            <div>
                                <p>예약특가</p>
                                <p>120,000원</p>
                            </div>
                        </div>
                        <div class="hovered-item-bg">
                        </div>
                    </div>
                   </c:forEach>
                    
                </section>
            </main>
        </div>
    </div>

    <section class="sec-footer">
        <footer>
            <div>
                <ul>
                    <li>
                        <a href="">회사소개</a>
                        <span>|</span>
                    </li>
                    <li>
                        <a href="">이용약관</a>
                        <span>|</span>
                    </li>
                    <li>
                        <a href="">개인정보처리방침</a>
                        <span>|</span>
                    </li>
                    <li>
                        <a href="">사업자정보확인</a>
                        <span>|</span>
                    </li>
                    <li>
                        <a href="">여기어때 마케팅센터</a>
                        <span>|</span>
                    </li>
                    <li>
                        <a href="">액티비티 호스트센터</a>
                        <span>|</span>
                    </li>
                    <li><a href="">콘텐츠산업진흥법에의한 표시</a></li>
                </ul>
        
                <p><b>고객행복센터 1577-8282</b>   오전 09:00 ~ 오후18:00</p>
    
                <address>
                    <span>(주)TEUM</span>
                    주소 : 서울특별시 종로구 인사동길 12 대일빌딩 15층
                    <br>대표이사 : 신중언 | 사업자등록번호 777-11-45678
                    <br>통신판매번호 : 2020-서울강남-12345 | 관광사업자 등록번호 : 제 1324-55호
                    <br>전화번호 : 010-1111-2222
                    <br>전자우편주소 : teum@teum.co.kr
                    <br>Copyright TEUM COMPANY Corp. All rights reserved.
                </address>
            </div>
        </footer>
    </section>
</body>
</html>
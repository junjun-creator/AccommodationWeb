<p align="center">
<img align="center" style="margin:0 auto;" src="https://user-images.githubusercontent.com/65852909/103152129-35686f00-47c8-11eb-82b4-a27dfd80ff37.png"/>

  <h2 align="center">TEUM</h2>
</p>

## 📑 프로젝트 소개
  - [x] 기존의 숙박 플랫폼 서비스는 숙박업체가 정해놓은 가격에 맞춰 소비자가 예약하는 시스템입니다.  
    그래서 소비자는 원하는 가격에 예약을 할 수 있고 숙박업체는 공실을 최소화할 수 있는 Win-Win 서비스를 구현하였습니다.
  - [x] 라이브러리와 프레임워크의 필요성을 체감하기 위해 json-simple, jdbc를 제외한 어떠한 라이브러리와 프레임워크도 사용하지 않았습니다.

## 🛠 사용 기술

| Front-End | Back-End | DataBase | Server | Tool |
| --- | --- | --- | --- | --- |
| HTML5<br>CSS3<br>JavaScript | Servlet & JSP | Oracle | Apache Tomcat | Git<br>Trello<br>Adobe XD<br>Photoshop |

## 📅 개발 기간
![프로젝트일정(틈)](https://user-images.githubusercontent.com/65852909/103269952-44366800-49fa-11eb-9bb9-7e3f6c3d4e8a.png)

## 📊 E-R Diagram
![E-R Diagram](https://user-images.githubusercontent.com/65852909/103152482-c12fca80-47cb-11eb-8748-09a80007ecdf.png)

## 📖 Issues 관리
<img width="1516" alt="스크린샷 2020-12-26 오후 10 51 42" src="https://user-images.githubusercontent.com/65852909/103152604-00aae680-47cd-11eb-9923-6960d38b75a1.png">

## 🎞 실행 화면

✅ [1] 메인화면 : 골든타임, 제안하기, 이벤트, 숙소등록 등 UI를 배치한 메인 페이지입니다.

![main](https://user-images.githubusercontent.com/65852909/103154683-576bec80-47dc-11eb-97b4-012b42eb20a7.gif)

✅ [2] 회원가입 : 여행자, 숙박업체 등록을 위한 회원가입 페이지입니다. 실시간 폼데이터 유효성 검사 및 AJAX를 통한 이메일 중복체크 기능을 구현하였습니다.

![signup](https://user-images.githubusercontent.com/65852909/103154728-b7629300-47dc-11eb-9a92-d9c25eafeca9.gif)

✅ [3] EMAIL & PASSWORD 검색 및 로그인 : 로그인을 위한 이메일, 비밀번호 분실 시 찾을 수 있도록 검색 기능(AJAX)을 구현하였습니다.

![findIdPwd](https://user-images.githubusercontent.com/65852909/103154759-0b6d7780-47dd-11eb-855f-818bc47a28ef.gif)

✅ [4] 제안(여행자) : 여행자가 원하는 장소, 일시, 인원, 가격 등을 제안할 경우, 해당 지역에 있는 모든 숙소에 제안 정보 전송하는 기능을 구현하였습니다.

![offer](https://user-images.githubusercontent.com/65852909/103154786-5ab3a800-47dd-11eb-8c43-f7d1274e0b23.gif)

✅ [5] 역제안(숙박업체) : 여행자로부터 받은 제안목록을 확인하고, 제안을 수락하며 여행자가 예약할 수 있도록 방 정보를 전송할 수 있는 기능을 구현하였습니다.

![reverseOffer](https://user-images.githubusercontent.com/65852909/103154849-da417700-47dd-11eb-9543-34ee89e97ab3.gif)

✅ [6] 역제안 받은 숙소 예약하기(여행자) : 내가 보낸 제안에 대한 역제안을 수락하고 예약하는 기능을 구현하였습니다.

![제안한것을 예약하는 gif임](https://user-images.githubusercontent.com/65852909/103154876-2ee4f200-47de-11eb-93df-40186ecf8346.gif)

✅ [7] 숙소리스트 훑어보기 : 숙소 타입(호텔, 모텔 등)별로 숙소리스트 검색 및 지역별 숙소리스트 검색 기능을 구현하였습니다.

![accList](https://user-images.githubusercontent.com/65852909/103154941-a1ee6880-47de-11eb-9079-c3f61349c513.gif)

✅ [8] 예약하기(기본) : 숙소리스트 검색 후, 원하는 숙소를 선택하여 예약하는 기능을 구현하였습니다.

![reservation](https://user-images.githubusercontent.com/65852909/103154962-e24de680-47de-11eb-87f7-e34e28c7cad6.gif)

✅ [9] 예약한 숙소에 리뷰 남기기 : 예약한 숙소에 리뷰를 남기는 기능을 구현하였습니다. 리뷰에는 별점과 코멘트를 남길 수 있습니다.

![review](https://user-images.githubusercontent.com/65852909/103154996-204b0a80-47df-11eb-8682-1872ccdb6e48.gif)

✅ [10] 골든타임 : 정해진 기간에 할인을 적용하고 있는 숙소들의 리스트를 확인할 수 있습니다. 해당 숙소를 소유하고있는 업체는 골든타임을 등록 및 해지할 수 있습니다.

![goldentime](https://user-images.githubusercontent.com/65852909/103155060-8f286380-47df-11eb-9f6f-e6074676cf25.gif)

✅ [11] 이벤트 : 현재 진행중인 이벤트 목록을 확인할 수 있는 페이지 입니다.

![event](https://user-images.githubusercontent.com/65852909/103155074-b3844000-47df-11eb-857a-3c707dbf87f1.gif)

✅ [12] 기타 : 이외에도 공지사항관리, 1:1문의, 관리자페이지(숙소등록관리,회원관리,이벤트&공지사항관리,골든타임관리) 기능도 구현 하였습니다.

## 💻 개발자

| <img src="https://avatars3.githubusercontent.com/u/65852909?s=400&u=8f18e9a8e35f4ea10e050c12d56c9c971e02eb4d&v=4" width="55" height="55"><br>[김병준](https://github.com/junjun-creator) | <img src="https://avatars2.githubusercontent.com/u/64012038?s=400&u=c1bf92ce021077a9d78d8418315c938e797fb238&v=4" width="55" height="55"><br>[신중언](https://github.com/Joong-eon) | <img src="https://avatars1.githubusercontent.com/u/40957996?s=400&u=df7fd20ae5c0afb399738e9b00fb770bea02d4b3&v=4" width="55" height="55"><br>[조재희](https://github.com/cbw1030) | <img src="https://avatars3.githubusercontent.com/u/73815879?s=400&v=4" width="55" height="55"><br>[박수현](https://github.com/suhyeon7846) |
| --- | --- | --- | --- |

## Contribution
  - 프로젝트 진행 총괄
  - [x] Front-end
    - 메인페이지(일부)
    - 로그인(아이디,비밀번호 검색 포함) 및 회원가입
    - 사용자 페이지
      - 회원 마이페이지 : 회원정보수정, 예약정보, 제안/역제안 정보, 찜한 숙소 목록
      - 기업 마이페이지 : 회원정보수정, 예약현황, 보유숙소현황
    - 관리자 페이지
      - 회원, 기업 멤버 관리 CRUD 페이지
  - [x] Back-end
    - 로그인(아이디,비밀번호 검색 포함) 및 회원가입
    - 사용자 페이지
      - 회원 마이페이지
        - 회원정보수정
        - 예약정보
        - 제안/역제안 정보
        - 찜한 숙소 목록
      - 기업 마이페이지
        - 회원정보수정
        - 예약현황
        - 보유숙소현황
    - 관리자 페이지
      - 회원, 기업 멤버 관리 페이지

## 개발에 어려웠던 점
  - [x] 기획부터 모든 개발 프로세스를 직접 수행하는 것이 쉽지 않았다.
  - [x] 배워가면서 설계하고 구현을 하다보니 코드의 집중화에 어려움이 있었다.

## 느낀점
  - [x] 팀프로젝트를 진행하며, 협업도구의 중요성을 깨달았다.
  - [x] 라이브러리를 제한적으로 사용해보니, 라이브러리의 필요성을 알게 되었다.

## 💼Download
  - git clone https://github.com/junjun-creator/AccommodationWeb.git
  

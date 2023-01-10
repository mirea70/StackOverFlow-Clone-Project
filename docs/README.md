<div align=center> 
    <h1> 📚 StackOverFlow 클론코딩 프로젝트 </h1>
</div>
<p align="center"> 
  <img src="https://user-images.githubusercontent.com/101246806/206632316-a597037d-0756-4943-bfd7-fb3f71f748c8.png" width= "800"/>
</p>
<div align=center> 
  <div align=left>
  <h3> - StackOverFlow 웹 페이지를 보며 클론코딩을 진행한 팀 프로젝트 입니다. <br/>
       - 메인 기능인 질문과 답변 기능에 집중하여 구현하였습니다. <br/> 
       - 첫 팀 프로젝트를 경험하면서 팀으로서 소통하고 협업하는 방법과 <br/>
       - 웹 서비스 운영에 필요한 배포 및 FE/BE 간 통신 방법 등 많은 것을 배웠습니다.
    <h3>
    </div>
</div>
    <h1> </h1>
<div align="center"> 
    <h3> 프로젝트 기간 : 2022.08.22 ~ 2022.09.06 </h3>
</div>
<br/>

# 💨 구현한 기능
### - 회원가입
<p align="left"> 
  <img src="https://user-images.githubusercontent.com/101246806/211681501-2e43ef8a-2e3d-440b-9c11-a6db2b68e1df.png">
</p>

- Sigh up 버튼을 눌러 회원가입을 진행합니다. 체크박스를 포함하여 하나라도 입력이 안되면 가입이 진행되지 않습니다.

  <br/>

### - 로그인
<p align="left"> 
  <img src="https://user-images.githubusercontent.com/101246806/211681590-10c7a003-db22-444d-929f-761e6b528051.png">
</p> 

- 회원가입한 정보를 토대로 로그인을 진행합니다.
- 비밀번호는 보안을 위해 마스킹처리 하였습니다.

 <br/>

### - 게시글 등록
<p align="left"> 
  <img src="https://user-images.githubusercontent.com/101246806/211681750-ac8e318c-f591-4072-aa77-1b8b46668a3c.png">
</p> 

- Ask question 버튼을 누르면 ask.html로 넘어가 다음 화면처럼 나옵니다.
- 정보를 입력하고 submit을 누르면 데이터베이스에 저장이 됨과 동시에 boardMain 페이지로 이동합니다.
- 원하는 태그를 공백 단위로 입력하여 추가할 수 있도록 구현하였습니다.
- 태그 부분은 타 기능들을 완성 후, 보완하려 하였으나 시간 부족 관계로 마무리하게 되었습니다.

 <br/>

### - 게시글 조회
<p align="left"> 
  <img src="https://user-images.githubusercontent.com/101246806/211681841-3c3143a6-a73f-4419-987d-378bbaa8ed1b.png">
</p> 

- 위 화면처럼 나타나고 제목부분을 누르면 해당 게시글을 자세히 볼 수 있습니다.
- 작성자의 정보와 작성 시간이 나타납니다. 아래에 답글을 작성할 수도 있습니다.

<br/>

### - 답글 작성
<p align="left"> 
  <img src="https://user-images.githubusercontent.com/101246806/211681914-9d994abc-206b-44b5-a61e-7513d80cd6b8.png">
</p>

<br/>

### - 질문 및 답글의 수정/삭제
<p align="left"> 
  <img src="https://user-images.githubusercontent.com/101246806/211682088-c72f75cc-9040-4e04-81b3-ab0f4dead797.png">
</p> 

- 질문 게시글과 답글이 등록된 후, 위의 Edit 버튼을 누르면 수정이 가능합니다.
- Delete 버튼을 누르면 각각 삭제가 가능합니다.
- 모두 작성자 본인일 경우에만 가능합니다.

<br/>
  
# :information_desk_person: 팀 인원
<p align="center"> 
  <li> FE : 고영석(팀장)  김태형  엄신영 </li>
  <li> BE : 박성재  박제관 </li>
</p> 
  
  <br/>
  
# 👉 역할
### - BE 개발 담당(기여도 80% 이상)
### - AWS 배포 인프라 구축(EC2, RDS) 담당
### - FE/BE 간 통신 리드
### - 테이블 설계 및 테이블 명세서 작성
### - API 기능 구현
### - 회원 도메인 기능 : 로그인(오류 수정 및 보조), 회원 조회
### - 질문 게시판 기능
  * CRUD
  * 질문 채택/채택 취소
  * 질문 투표 + / -
  * 정렬 기준 옵션
### - 질문에 대한 답변 기능
  * CRUD
  * 답변 투표 + / -
### - 답변에 대한 댓글 기능(CRUD)
### - 검색 기능
### - API 문서화
### - FE/BE 소통 핵심 담당
<br/>
  
# :sparkler: 기술스택
<p align="left"> 
  <img src="https://user-images.githubusercontent.com/101246806/206642915-17915aba-51d2-45a4-944d-f7d4ecee54fe.png" width= "800"/>
</p>
  
<br/>
  
# :green_book: 문서
  
## 🔎 [요구사항 명세서](https://docs.google.com/spreadsheets/d/1qkCF0rwuUDvT3aVnf98bFDHh35_hZhu8mZDKAznOwDU/edit#gid=0)
## 💻 [테이블 명세서](https://docs.google.com/spreadsheets/d/10EhFUWv6WEIdJ3mcB5F-kzcbbPT5oQpJrlaWXNZrDxY/edit#gid=1147718210)
## 📂 [API 문서]
<p align="left"> 
  <img src="https://user-images.githubusercontent.com/101246806/206637685-279b9b6d-8143-403e-8498-10c0de3e678b.png" width= "800"/>
</p>
<p align="left"> 
  <img src="https://user-images.githubusercontent.com/101246806/206637817-c59864b3-9e43-4ea3-841d-1904e380bbed.png" width= "800"/>
</p>
<br/>

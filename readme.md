# 한이음 사이드 프로젝트 - 블로그
## 백엔드(Spring)

프로젝트 생성 - https://start.spring.io/
- spring-version: 3.0.2
- java-version: oracle jdk 17.0.6(https://download.oracle.com/java/17/archive/jdk-17.0.6_windows-x64_bin.exe)
- Dependencies: spring boot devtools, lombok, spring web
- MariaDB : 
```
// 게시글 테이블
CREATE TABLE `Board` (
  `idx` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `writeDate` timestamp NULL DEFAULT current_timestamp(),
  `imageLoc` text DEFAULT NULL,
  PRIMARY KEY (`idx`)
)

// 유저 테이블
CREATE TABLE `User` (
  `userId` varchar(100) NOT NULL,
  `userName` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `regDate` varchar(100) DEFAULT current_timestamp(),
  PRIMARY KEY (`userId`)
)
```

# api요청시 주의사항
> axios.defaults.withCredentials = true; //axios 사용 컴포넌트 마다 한번씩 붙여넣을 것

이거 안쓰면 세션ID가 계속 바뀌기 때문에 로그인 유지가 안됨


## API 표
/api/users
<table>
<tr>
<th>URL</th>
<th>Method</th>
<th>설명</th>
<th>request</th>
<th>response</th>
</tr>
<tr>
<td>/signup</td>
<td>POST</td>
<td>회원가입 후 세션<br>생성하여 자동로그인</td>
<td><code>
{
    "userId" : "",    <br> &emsp;
    "userName" : "",  <br> &emsp;
    "password" : "",  <br> &emsp;
    "regDate" : null  <br>
}
</code></td>
<td>userId</td>
</tr>
<tr>
<td>/login</td>
<td>POST</td>
<td>세션 생성하여 로그인</td>
<td><code>
{
    "userId" : "",    <br> &emsp;
    "password" : "",  <br>
}
</code></td>
<td>
id가 존재하지 않을 때 : "0"<br>
id가 존재하지만 pw가 틀렸을 때 : "1"<br>
로그인 성공 : userId<br>
</td>
</tr>
<tr>
<td>/logout</td>
<td>GET</td>
<td>세션 삭제하여 로그아웃</td>
<td>-</td>
<td>-</td>
</tr>
<tr>
<td>/isLogin</td>
<td>GET</td>
<td>세션 값이 있는지 확인</td>
<td>-</td>
<td>userId</td>
</tr>
<tr>
<td>/modify</td>
<td>PUT</td>
<td>회원정보 수정(세션에 저장된 userId와<br>넘긴 데이터의 userId가 같은지 확인하기<br>때문에 로그인이 돼있어야 함)</td>
<td><code>
{
    "userId" : "",    <br> &emsp;
    "userName" : "",  <br> &emsp;
    "password" : "",  <br> &emsp;
    "regDate" : null  <br>
}
</code></td>
<td>-</td>
</tr>
<tr>
<td>/delete</td>
<td>POST</td>
<td>회원정보 삭제</td>
<td><code>
{
    "userId" : "",    <br> &emsp;
    "password" : "",  <br>
}
</code></td>
<td>
pw가 틀렸을 때 : "1"<br>
삭제됐을 때 : "0"</td>
</tr>
</table>
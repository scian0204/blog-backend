# 한이음 사이드 프로젝트 - 블로그
## 백엔드(Spring)

프로젝트 생성 - https://start.spring.io/
- spring-version: 3.0.2
- java-version: oracle jdk 17.0.6(https://download.oracle.com/java/17/archive/jdk-17.0.6_windows-x64_bin.exe)
- Dependencies: spring boot devtools, lombok, spring web
- MariaDB : 
```
// 게시글 테이블
Board : {
    idx int primary Auto_Increment,
    userId varchar foreign(User.userId) Not_Null,
    title varchar Not_Null,
    content text,
    writeDate date Current_Timestamp,
    imageLoc text
}

// 유저 테이블
User {
    userId varchar primary,
    userName varchar Not_Null,
    password varchar Not_Null, //sha256로 암호화
    regDate date Current_Timestamp
}
```

## API 표
<table>
<tr>
<th>URL</th>
<th>Method</th>
<th>설명</th>
<th>request</th>
<th>response</th>
</tr>
<tr>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
</table>
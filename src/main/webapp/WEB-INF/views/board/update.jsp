<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>게시글 수정</title>
    <link rel="stylesheet" type="text/css" href="/css/hello-spring.css" />
  </head>
  <body>
    <h1>게시글 수정</h1>
    <!-- action ==> form 내부의 value를 전송할 앤드포인트 -->
    <form method="post" action="/update/${article.id}">
      <div class="grid write">
        <label for="subject">제목</label>
        <input
          id="subject"
          type="text"
          name="subject"
          placeholder="제목을 입력하세요"
          value="${article.subject}"
        />

        <label for="email">이메일</label>
        <input
          id="email"
          type="email"
          name="email"
          placeholder="이메일을 입력하세요"
          value="${article.email}"
        />

        <label for="content">내용</label>
        <textarea id="content" name="content" placeholder="내용을 입력하세요">
${article.content}</textarea
        >

        <div class="btn-group">
          <div class="right-align">
            <a href="/update/${article.id}">수정</a>
            <a href="/delete?id=${article.id}">삭제</a>
            <input type="submit" value="저장" />
          </div>
        </div>
      </div>
    </form>
  </body>
</html>

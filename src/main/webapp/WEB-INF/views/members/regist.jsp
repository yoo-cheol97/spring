<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>회원가입</title>
  </head>
  <body>
    <h1>회원가입</h1>
    <form method="post">
      <div class="grid write">
        <label for="email">이메일</label>
        <input id="email" type="email" name="email" />

        <label for="name">이름</label>
        <input id="name" type="text" name="name" />

        <label for="password">비밀번호</label>
        <input id="password" type="password" name="password" />
        <input type="submit" value="등록" />
      </div>
    </form>
  </body>
</html>

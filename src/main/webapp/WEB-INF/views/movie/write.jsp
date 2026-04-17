<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>영화 등록</title>
    <link rel="stylesheet" type="text/css" href="/css/hello-spring.css" />
</head>
<body>

    <h1>영화 등록</h1>
    <form method="post" action="/writeM">
        <div class="grid write">
            <label for="title">제목</label>
            <input
                id="title"
                type="text"
                name="title"
                placeholder="제목을 입력하세요"
            />

            <label for="openDate">개봉일</label>
            <input
                id="openDate"
                type="date"
                name="openDate"
            />

            <label for="runningTime">상영시간</label>
            <input
                id="runningTime"
                type="number"
                name="runningTime"
                placeholder="상영시간(분)"
            />

            <label for="state">상태</label>
            <input
                id="state"
                type="text"
                name="state"
                placeholder="예: 개봉됨"
            />

            <label for="language">언어</label>
            <input
                id="language"
                type="text"
                name="language"
                placeholder="예: 한국어"
            />

            <label for="introduce">소개</label>
            <textarea
                id="introduce"
                name="introduce"
                placeholder="영화 소개"
            ></textarea>
            
           
            <label for="attach-files">영화 포스터 첨부파일</label>
        <div id="attach-files" class="attach-files">
          <input type="file" name="attachFile" />
          <button type="button" class="add-file">➕</button>
        </div>

            <div class="btn-group">
                <div class="right-align">
                    <input type="submit" value="저장" />
                </div>
            </div>
        </div>
    </form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>영화 목록</title>
<link rel="stylesheet" type="text/css" href="/css/hello-spring.css">
</head>
<body>
	<div class="grid list">
		<h1>영화 목록</h1>

		<table class="grid">
			<colgroup>
				<col width="200" />
				<col width="*" />
				<col width="150" />
				<col width="120" />
				<col width="120" />
				<col width="120" />
				<col width="200" />
			</colgroup>
			<thead>
				<tr>
					<th>영화</th>
					<th>제목</th>
					<th>상영시간</th>
					<th>상태</th>
					<th>언어</th>
					<th>소개</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty movie}">
						<c:forEach items="${movie}" var="movie">
							<tr>
								<td>${movie.movieId}</td>
								<td>${movie.title}</td>
								<td>${movie.runningTime}</td>
								<td>${movie.state}</td>
								<td>${movie.language}</td>
								<td>${movie.introduce}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="6">데이터가 없습니다</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>

		<div class="btn-group">
			<div class="right-align">
				<a href="/movie/writeM">영화 등록</a>
			</div>
		</div>
	</div>
</body>
</html>
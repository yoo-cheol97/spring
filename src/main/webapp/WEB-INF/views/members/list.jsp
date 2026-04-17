<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:include page="/WEB-INF/views/templates/header.jsp">
    <jsp:param value="게시글 회원 목록" name="title" />
    </jsp:include>
	<div class="grid list">
		<h1>회원목록</h1>
		<div>총 ${searchCountM}개의 게시글이 검색되었습니다.</div>
		<!-- HTML 주석: 브라우저 개발자 도구에서 노출되는 주석. -->
		<%-- JSP 주석: 브라우저 개발자 도구에서 노출되지 않는 주석. --%>
		<%--
      <% for (BoardVO board: searchResult) { %>
          <div><%=board.getId()%></div>
      <% } %>
      --%>
		<table class="grid">
			<colgroup>
				<col width="200" />
				<col width="*" />
				<col width="150" />
				<col width="80" />
				<col width="180" />
				<col width="180" />
			</colgroup>
			<thead>
				<tr>
					<th>이메일</th>
					<th>이름</th>
					<th>비밀번호</th>
				</tr>
			</thead>
			<tbody>
				<!-- searchResult가 존재하지 않으면, "검색된 데이터가 없습니다"를 보여주고 -->
				<c:choose>
					<c:when test="${not empty searchResultM}">
					<!-- searchResult가 존재하면, 반복하여 데이터를 보여주고 -->
						<c:forEach items="${searchResultM}" var="members">
							<tr>
								<td>${members.email}</td>
							<%-- 	<td>
								<a href="/view/${board.id}">${board.subject}</a>
								</td>
								 --%>
								<td>${members.name}</td>
								<td>${members.password}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
					<!-- searchResult가 존재하지 않으면, "검색된 데이터가 없습니다"를 보여주고 -->
					<tr>
					<td colspan="6"> 검색된 데이터가 없습니다</td>
					</tr>
					</c:otherwise>
				</c:choose>
				
			</tbody>
		</table>
		<div class="btn-group">
			<div class="right-align">
				<a href="/regist">새로운 게시글 작성</a>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/views/templates/footer.jsp"></jsp:include>
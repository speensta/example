<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.js"></script>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.css" />
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid-theme.min.css" />

</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<h2>board_view</h2>
	<table border="1">
		<colgroup>
			<col width="10%;">
			<col width="40%;">
			<col width="10%;">
			<col width="40%;">
		</colgroup>
		<tr>
			<th>제목</th>
			<td>${view.btitle}</td>
			<th>작성일자</th>
			<td>
				<fmt:formatDate value="${view.bregdate}" pattern="yyyy-MM-dd HH:mm:ss" />
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">${view.bowner}</td>
		</tr>
	</table>
</body>
</html>
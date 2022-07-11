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
<script>
	//grid에 들어갈 초기 내용
	var clients = [{
		"Name": "Otto Clay",
		"Age": 25,
		"Country": 1,
		"Address": "Ap #897-1459 Quam Avenue",
		"Married": false
	},
		{
			"Name": "Connor Johnston",
			"Age": 45,
			"Country": 2,
			"Address": "Ap #370-4647 Dis Av.",
			"Married": true
		},
		{
			"Name": "Lacey Hess",
			"Age": 29,
			"Country": 3,
			"Address": "Ap #365-8835 Integer St.",
			"Married": false
		},
		{
			"Name": "Timothy Henson",
			"Age": 56,
			"Country": 1,
			"Address": "911-5143 Luctus Ave",
			"Married": true
		},
		{
			"Name": "Ramona Benton",
			"Age": 32,
			"Country": 3,
			"Address": "Ap #614-689 Vehicula Street",
			"Married": false
		}
	];

	$("#jsGrid").jsGrid({
		width: "100%",
		height: "400px",

		autoload: true,
//데이터 변경, 추가, 삭제대하여 자동으로 로드되게 함
		sorting: true,
//그리드 헤더 클릭시 sorting이 되게함
		data: clients,
//clients를 생성된 배열를 연결함.

		fields: [{
			name: "Name",
			type: "text",
			width: 150
		},
			{
				name: "Age",
				type: "number",
				width: 50
			},
			{
				name: "Address",
				type: "text",
				width: 200
			},
			{
				name: "Married",
				type: "checkbox",
				title: "Is Married",
				sorting: false
			}
		]
//grid에 표현될 필드 요소
	});
</script>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<h2>board_list</h2>
	<div id="jsGrid"></div>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="row" items="${list}">
		<tr>
			<td>${row.bno}</td>
			<td><a href="/board/view.do?bno=${row.bno}">${row.btitle}</a></td>
			<td>${row.bowner}</td>
			<td>
				<fmt:formatDate value="${row.bregdate}" pattern="yyyy-MM-dd HH:mm:ss" />
			</td>
		</tr>
		</c:forEach>
	</table>

	<div class="paging">
	<c:forEach var="row" begin="1" end="${pageBlock}" varStatus="i">
		<span><a href="/board/list.do?pageIndex=${i.count}">${i.count}</a></span>
	</c:forEach>
	</div>
</body>
</html>
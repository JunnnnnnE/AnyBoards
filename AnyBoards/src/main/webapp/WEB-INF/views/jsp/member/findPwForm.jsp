<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AnyBoards 임시 비밀번호 발급</title>
<link rel="shortcut icon" href="/any/resources/images/icon/icon_favicon.ico" type="image/x-icon"> <!-- favicon -->
<link rel="stylesheet" type="text/css" href="/any/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/any/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/any/resources/css/memberForm.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />
	
	<!-- Contents -->
	<div id="contents">
		<div id="contents_title">
			<h1>임시 비밀번호 발급</h1>
			<h2>아이디와 이메일을 입력하시면 임시 비밀번호를 발급받을 수 있습니다.</h2>
		</div>
		<div id="contents_detail">
			<!-- Form -->
			<form id="join_form" class="find_form" action="findPw" method="post" onSubmit="return pwCheck()">
				<table>
					<tbody>
						<tr>
							<th>아이디</th>
							<td>
								<input id="member_id" type="text" name="member_id" placeholder="아이디">
							</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td>
								<input id="member_email" type="text" name="member_email" placeholder="이메일">
							</td>
						</tr>
					</tbody>
				</table>
				<div id="btn_wrap">
					<input type="button" value="취소" class="btn_com btn_main" onClick="goLogin()">  
					<input type="submit" value="확인" class="btn_com btn_main">
				</div>
			</form>
		</div>
	</div>
	
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
	
	<!-- JS -->
	<script type="text/javascript" src="/any/resources/js/member/member.js"></script>
</body>
</html>
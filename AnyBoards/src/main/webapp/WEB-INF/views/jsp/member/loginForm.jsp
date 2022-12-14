<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AnyBoards 로그인</title>
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
            <h1>로그인</h1>
            <h2>로그인 후 커뮤니티 이용이 가능합니다.</h2>
        </div>
        <div id="contents_detail">
            <h1>AnyBoards</h1>
            <!-- Form -->
            <form id="login_form" action="login" method="post" onSubmit="return loginProcess()">
                <input id="member_id" type="text" name="member_id" placeholder="아이디">
                <input id="member_pw" type="password" name="member_pw" placeholder="비밀번호">
                <ul id="login_menu" class="side_menu">
                    <li><a href="/any/member/findId">아이디 찾기</a></li>
                    <li><a href="/any/member/findPw">임시 비밀번호 발급</a></li>
                    <li><a href="/any/member/join">회원가입</a></li>
                </ul>
                <div id="btn_wrap">
                    <input id="btn_sumit" type="submit" value="로그인" class="btn_com btn_main">
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
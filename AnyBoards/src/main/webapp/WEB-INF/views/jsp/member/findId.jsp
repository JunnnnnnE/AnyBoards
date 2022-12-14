<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AnyBoards 아이디 찾기</title>
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
            <h1>아이디 찾기</h1>
            <h2>이름과 이메일을 입력하시면 아이디를 찾으실 수 있습니다.</h2>
        </div>
        <div id="contents_detail">
            <!-- Form -->
            <form id="join_form" class="find_form">
            	<c:choose>
            		<c:when test="${findId.member_id eq null}"> 
				    	<h2>해당 회원의 아이디를 찾을 수 없습니다.</h2>
					</c:when>
					<c:otherwise>
						<h2>해당 회원의 아이디는 <b><c:out value="${findId.member_id}"/></b> 입니다.</h2>
					</c:otherwise>
				</c:choose>
                <div id="btn_wrap">
                    <input type="button" value="로그인 화면으로 이동" class="btn_com btn_main" onClick="goLogin()">
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
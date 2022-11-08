<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AnyBoaads 마이페이지</title>
<link rel="shortcut icon" href="/any/resources/images/icon/icon_favicon.ico" type="image/x-icon"> <!-- favicon -->
<link rel="stylesheet" type="text/css" href="/any/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/any/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/any/resources/css/board.css">
<link rel="stylesheet" type="text/css" href="/any/resources/css/myPage.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />
	
	<!-- Contents -->
	    <div id="contents">
	        <div id="contents_title">
	            <h1>마이페이지</h1>
	            <h2>마이페이지에서 회원정보를 확인할 수 있습니다.</h2>
	        </div>
	        <div id="contents_detail">
	            <div id="contents_wrap">
	                <!-- Category -->
	                <ul id="contents_category">
	                    <li><a href="/any/member/" class="select">마이페이지</a></li>
	                    <li><a href="/any/member/boardList">내가 작성한 게시글</a></li>
	                    <li><a href="/any/member/commentList">내가 작성한 댓글</a></li>
	                    <li><a href="#">나의 포인트</a></li>
	                    <li><a href="/any/follow/myFollowPage">팔로잉</a></li>
	                    <li><a href="/any/scrap/scrapList">스크랩</a></li>
	                </ul>
	                <!-- My Page -->
	                <div id="board_list" class="my_page">
	                	<div class="profile">
	                		<div class="member_info">

								<c:choose>
									<c:when test="${board.member_profile eq 'N'}">
								<!-- 프로필 사진이 없을 경우 -->
	                			<img src="/any/resources/images/icon/icon_profile.svg" class="badge">	                			
									</c:when>
									<c:otherwise>
	                			<!-- 프로필 사진이 있을 경우 -->	
	                			<img src="${path}${board.member_profile}" class="badge">	
									</c:otherwise>
								</c:choose>
	                			<div class="info_box">
		                			<h4>나의 등급 
		                			<c:choose>
		                			<c:when test="${board.member_pro_check == 'Y' }">
		                			<span class="rank">[Expert]</span>
		                			</c:when>
		                			<c:when test="${board.member_admin == 'Y'}">
		                			<span class="rank" style="color:#FF0105;">[Admin]</span>
		                			</c:when>
		                			<c:otherwise>
		                			<span class="rank" style="color:#111;">[AnyBoarders]</span>
		                			</c:otherwise>
		                			</c:choose>
		                			</h4>
		                			<h3>${sessionScope.member.member_nick}</h3>
		                			<p>
		                				환영합니다! <b>${sessionScope.member.member_name}</b>님 (ID : ${sessionScope.member.member_id})<br>
		                				가입일 : <fmt:formatDate value="${sessionScope.member.member_date}" pattern="yyyy.MM.dd"/> | 이메일 : ${sessionScope.member.member_email}
		                			</p>
	                			</div>
	                			<ul class="info_icon number">
	                                <li><img src="/any/resources/images/icon/icon_message.svg" class="i_msg">0</li>
	                                <li><img src="/any/resources/images/icon/icon_follow.svg" class="i_follow">${allFollowCount}</li>
	                                <li><img src="/any/resources/images/icon/icon_scrap.svg" class="i_scrap">${allScrapCount}</li>
	                            </ul>
	                            <a href="/any/member/profile" class="btn_com btn_mod_profile">프로필사진</a>
	                			<a href="/any/member/mypageModify" class="btn_com btn_mod_member">회원정보 수정</a>
	                		</div>
	                		<div class="member_board">
		                		<hr>
			                	<ul>
									<li>내가 작성한 게시글<a href="/any/member/boardList">${allBoardCount}개</a></li>
			                		<li>내가 작성한 댓글<a href="/any/member/commentList">${allCommentCount}개</a></li>
			                		<li>나의 포인트<a href="#">${sessionScope.member.member_point}point</a></li>
								</ul>
			                	<hr>
		                	</div>
		                	<a href="/any/member/delete" class="btn_del_member">회원탈퇴</a>
	                	</div>
	                </div>
	                <!-- Member Info -->
	                <div id="member_info">
	                    <a href="/any/board/boardWrite" class="btn_com btn_main">게시글 작성</a>
	                    
	                    
	                </div>
	            </div>
	        </div>
	    </div>
    
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
</body>
</html>
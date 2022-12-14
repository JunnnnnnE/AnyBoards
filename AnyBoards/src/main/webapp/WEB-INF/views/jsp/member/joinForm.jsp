<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AnyBoards 회원가입</title>
<link rel="shortcut icon" href="/any/resources/images/icon/icon_favicon.ico" type="image/x-icon"> <!-- favicon -->
<link rel="stylesheet" type="text/css" href="/any/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/any/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/any/resources/css/memberForm.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />
<script src="https://www.google.com/recaptcha/api.js"></script>

	<!-- Contents -->
	<div id="contents">
        <div id="contents_title">
            <h1>회원가입</h1>
            <h2>회원가입을 하고 AnyBoards 커뮤니티를 이용하세요.</h2>
        </div>
        <div id="contents_detail">
            <!-- Form -->
            <form id="join_form" name="userInfo" method="post" onSubmit="return checkValue()">
                <table>
                	<tbody>
	                    <tr class="check">
	                        <th>아이디</th>
	                        <td>
	                            <input type="text" name="member_id" id="member_id" placeholder="아이디">
	                            <button class="btn_com btn_check" type="button" name="checkId" id="checkId">중복 체크</button>
	                            <input type="hidden" name="idDuplication" id="idDuplication"/>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>비밀번호</th>
	                        <td>
	                            <input type="password" id="member_pw" name="member_pw" placeholder="비밀번호">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>비밀번호 확인</th>
	                        <td>
	                            <input type="password" name="member_pw1" placeholder="비밀번호 확인">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>이름</th>
	                        <td>
	                            <input type="text" id="member_name" name="member_name" placeholder="이름">
	                        </td>
	                    </tr>
	                    <tr class="check">
	                        <th>닉네임</th>
	                        <td>
	                            <input type="text" name="member_nick" id="member_nick" placeholder="닉네임">
	                            <button class="btn_com btn_check" type="button" name="checkNick" id="checkNick">중복 체크</button>
	                            <input type="hidden" name="nickDuplication" id="nickDuplication"/>
	                        </td>
	                    </tr>
	                    <tr class="check emailChk" >
	                        <th>이메일</th>
	                        <td>
	                            <input type="text" id= "member_email" name="member_email" placeholder="이메일">
	                            <span id="emailChk" class="doubleChk">인증번호 전송</span>
								<input id="member_emailChk" type="text" id= "member_email" name="member_emailChk" placeholder="인증번호 입력">
								<span id="emailChk2" class="doubleChk">이메일인증</span></br>
								<span class="point successEmailChk">이메일 입력후 인증번호 보내기를 해주십시오.</span>
								<input type="hidden" id="emailDoubleChk"/>
								<input type="hidden" name="emailDuplication" id="emailDuplication"/>
								<br/><br/><br/><br/><br/><br/><br/>
	                        </td>
	                    </tr>
	                    <tr class="captcha">
	                        <th></th>
	                        <td>
	                            <div id="g-recaptcha" class="g-recaptcha" data-sitekey="6Lda52AgAAAAAPkgal4uFLTpngYX6W0PeT5uf0vX"></div>
	                        </td>
	                    </tr>
                    </tbody>
                </table>
                 <div id="btn_wrap">
                    <input type="button" value="취소" class="btn_com btn_main" onClick="goLogin()">
                    <input type="submit" value="가입" class="btn_com btn_main">
                </div>
            </form>
        </div>
    </div>
    
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
	
	<!-- JS -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript" src="/any/resources/js/member/member.js"></script>
	<script type="text/javascript" src="/any/resources/js/member/memberJoin.js"></script>

	
</body>
</html>
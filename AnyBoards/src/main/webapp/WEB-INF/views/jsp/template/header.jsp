<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<body>
    <header id="header">
        <div id="header_logo">
            <a href="/any">AnyBoards</a>
        </div>
        <nav id="header_nav">
            <ul>
                <li><a href="/any">Home</a></li>
                <li><a href="/any/board?board_group_no=1">Community</a></li>
                <li><a href="/any/board?board_group_no=2">Q&amp;A</a></li>
                <li><a href="/any/board/notice">Notice</a></li>
            </ul>
        </nav>
        
        <!-- 로그인 전 : 세션 값이 없을 경우 -->
        <c:if test="${sessionScope.member.member_no == null}">
            <div id="header_menu">
                <ul>
                    <li><a href="/any/member/login" class="log">로그인</a></li>
                    <li><a href="/any/member/join" class="btn_com btn_join">가입</a></li>
                </ul>
            </div>
        </c:if>
        
        <!-- 로그인 후 : 세션 값이 있을 경우 -->
        <c:if test="${sessionScope.member.member_no != null}">
            <div id="header_menu">
                <ul>
                    <%-- <li><c:out value="${sessionScope.member_no}"/></li> 세션 값 확인 --%>
                    <!-- Admin 로그인 -->
                    <c:if test="${sessionScope.member_admin == 'Y'}">
                        <li><a href="/any/admin/memberList" class="btn_com">관리자 페이지로 이동</a></li>
                    </c:if>
                    <li><a href="/any/member/logout" class="log" onClick="logout()">로그아웃</a></li>
                    <li><a href="/any/member/" class="log">마이페이지</a></li>
                    <li><a class="chat" >쪽지</a></li>
                    <li><a href="#"><img src="/any/resources/images/icon/icon_alarm_n.svg"></a></li>
                    <!-- <li><a href="#" onclick="msgList()" ><img src="/any/resources/images/icon/icon_alarm_n.svg"></a></li> -->
                  
                  <!--프로필 이미지 -->
                  	<c:forEach items="${icon}" var="profile">
                  	<c:choose>
                    <c:when test="${profile.member_profile eq 'N'}">
                	<li><a href="/any/member/"><img src="/any/resources/images/icon/icon_profile.svg"></a></li>
                	</c:when>
                	<c:otherwise>
               		 <li><a href="/any/member/"><img src="${path}${profile.member_profile}" class="header_profile"></a></li>
                	</c:otherwise>
                	</c:choose>
                	</c:forEach>
         
                </ul>
            </div>
        </c:if>
        
    </header>
    
    <!-- JS -->
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript" src="/any/resources/js/common.js"></script>
	<script type="text/javascript">
	$('.chat').on("click",function(e){
		
		e.preventDefault();
		
		let popUrl = "/any/chatMainList";
		let popOption = "width = 1080px, height=600px, top=200px, left=400px, status=no,  toolbar=no, menubar=no" ;
		
		window.open(popUrl,"쪽지",popOption);
		
	});
	</script>
</body>
</html>
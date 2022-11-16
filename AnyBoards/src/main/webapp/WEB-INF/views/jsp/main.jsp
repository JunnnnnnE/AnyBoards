<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AnyBoards</title>
<link rel="shortcut icon" href="/any/resources/images/icon/icon_favicon.ico" type="image/x-icon"> <!-- favicon -->
<link rel="stylesheet" type="text/css" href="/any/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/any/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/any/resources/css/main.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="template/header.jsp" flush="false" />

	<!-- Contents -->
    <div id="contents">
        <div id="contents_title">
            <h1>AnyBoards</h1>
            <h2>
            	정보 공유 커뮤니티 사이트 입니다 !<br>
                정보를 공유하고 소통해보세요
            </h2>
            <div id="contents_pro">
	            <ul class="display-container">
	           
				    <li class="note-display" data-note="${allMemberCount}.00">
				  
				    	<div class="circle">
				    		<svg width="84" height="84" class="circle__svg">
				    			<circle cx="41" cy="41" r="38" class="circle__progress circle__progress--path"></circle>
				          		<circle cx="41" cy="41" r="38" class="circle__progress circle__progress--fill"></circle>
				        	</svg>
					        <div class="percent">
					        	<span class="percent__int">0</span>
					       	 	<span class="percent__dec">00</span>
					        </div>
				      	</div>
				      	<span class="label">전체 회원</span>
				    </li>
				    
				    <li class="note-display" data-note="${allBoardCount}.00">
				    
				    	<div class="circle">
				    		<svg width="84" height="84" class="circle__svg">
				    			<circle cx="41" cy="41" r="38" class="circle__progress circle__progress--path"></circle>
				          		<circle cx="41" cy="41" r="38" class="circle__progress circle__progress--fill"></circle>
				        	</svg>
					        <div class="percent">
					        	<span class="percent__int">0</span>
					       	 	<span class="percent__dec">00</span>
					        </div>
				      	</div>
				      	<span class="label">전체 게시글</span>
				    </li>
				   
				    <li class="note-display" data-note="${allCommentCount}.00">
				     
				    	<div class="circle">
				    		<svg width="84" height="84" class="circle__svg">
				    			<circle cx="41" cy="41" r="38" class="circle__progress circle__progress--path"></circle>
				          		<circle cx="41" cy="41" r="38" class="circle__progress circle__progress--fill"></circle>
				        	</svg>
					        <div class="percent">
					        	<span class="percent__int">0</span>
					       	 	<span class="percent__dec">00</span>
					        </div>
				      	</div>
				      	<span class="label">전체 댓글</span>
				    </li>
			    </ul>
            </div>
            <div id="btn_wrap">
                <a href="/any/board?board_group_no=1" class="btn_com btn_main">커뮤니티로 이동</a>
            </div>
            <div id="particles-js"></div>
        </div>
    </div>

	<!-- Footer -->
	<jsp:include page="template/footer.jsp" flush="false" />
	
	<!-- JS -->
	<script type="text/javascript" src="/any/resources/js/plugin/particles.min.js"></script>
	<script type="text/javascript" src="/any/resources/js/plugin/app.js"></script>
	<script type="text/javascript" src="/any/resources/js/plugin/progress.js"></script>
	<script type="text/javascript" src="/any/resources/js/member/member.js"></script>
</body>
</html>
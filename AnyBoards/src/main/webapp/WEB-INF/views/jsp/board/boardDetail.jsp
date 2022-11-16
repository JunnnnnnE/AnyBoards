<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AnyBoards 게시판 상세</title>
<link rel="shortcut icon" href="/any/resources/images/icon/icon_favicon.ico" type="image/x-icon"> <!-- favicon -->
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css">
<link rel="stylesheet" type="text/css" href="/any/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/any/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/any/resources/css/board.css">
<link rel="stylesheet" type="text/css" href="/any/resources/css/summernote.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />

	<!-- Contents -->
    <div id="contents">
        <div id="contents_title">
            	<h1>커뮤니티</h1>
            	<h2>커뮤니티를 통해 IT 정보를 공유하고 소통할 수 있습니다.</h2>
        </div>
        <div id="contents_detail">
            <div id="contents_wrap">
            <!-- Category -->
                <ul id="contents_category">
						<li><a href="/any/board?board_group_no=1" class="select">COMMUNITY</a></li>
                </ul>
                <!-- Board -->
                <div id="board_list">
                    <!-- Title -->
                    <div id="board_list_title">
                        <h2><a href="../board?board_group_no?=${boardNo}">< 리스트로 이동</a></h2>
                    </div>
					<!-- List Row -->
                	<c:forEach items="${boardDetail}" var="boardDetail" varStatus="status">
	                    <div id="board_list_row">
	                        <div class="row">
	                            <div class="row_info">
	                                <div class="row_top member">
	                                    	<h4>
												<span class="rank" style="color: #111;">[anyBoarder]</span>
											</h4>
												<div style="display: none; position: absolute;" id="drop-content">
													<input type="hidden" id="member_nick" name="member_nick"  value="${boardDetail.member_nick }">
													<input type="hidden" id="member_no" name="member_no" value="${boardDetail.member_no }">
												</div>
	                                </div>
	                                <span class="row_top date"><fmt:formatDate value="${boardDetail.board_date}" pattern="yyyy.MM.dd"/></span>
	                           		<ul class="detail_count">
										<li><a class="heart"><img id="heart" src="/any/resources/images/icon/heart.svg"></a></li>
										<li><a class="report"><img id="report" src="/any/resources/images/icon/siren.png"></a></li>
									</ul>
	                            </div>
	                            <div class="row_title">
	                                <h3>
	                                    <a>
												${boardDetail.board_title}	                                        		
												<c:if test="${boardDetail.board_file_check == 'Y' }">
                                        		<img src="/any/resources/images/icon/icon_file.svg" class="i_file">
                                        		</c:if>
	                                    </a>
	                                </h3>
	                            </div>
	                            <div class="row_contents">
                         			<p>${boardDetail.board_content}</p>
	                            	<form name="downFile" role="form" method="post">
	                            		<input type="hidden" class="FILE_NO" name="FILE_NO" value="">
										<c:forEach var="file" items="${file}">
											<span><a href="#" onClick="fn_fileDown(${file.FILE_NO}); return false;">${file.ORG_FILE_NAME}</a>(${file.FILE_SIZE}kb)</span>
										</c:forEach>
									</form>
	                            </div>
	                            <ul class="row_top number">
	                                <li><img src="/any/resources/images/icon/icon_hit.svg" class="i_hit">${boardDetail.board_hit_count}</li>
	                                <li><img src="/any/resources/images/icon/icon_comment.svg" class="i_cmt"></li>
	                                <li><img src="/any/resources/images/icon/icon_like.svg" class="i_like"></li>
	                            </ul>
	                            <c:if test="${sessionScope.member_no != null}">
	                            <div class="btn_group">
	                            <ul>
	                            	
		                			<c:if test="${sessionScope.member_no == boardDetail.member_no }">
	                            	<input type="hidden" name="board_no" value="${board_no}">
		                			<%-- <input type="button" value="삭제" class="btn_com btn_board" onClick="location.href='/any/board/delete?board_no='+ ${board_no}"> --%>
		                			<input type="button" value="삭제" class="btn_com btn_board" onClick="deleteBoard()">
		                			<li><input type="button" value="수정" class="btn_com btn_board" onclick="location.href='/any/board/modify?board_no=' + ${board_no}">
		                			</c:if>
								</ul>
	                            </div>
	                            </c:if>
	                        </div>
	                        <hr>
	                    </div>
                    </c:forEach>
                    
                	<!-- Comment Form -->
	               	 <div id="comment_form">
	                	<form action="comment" method="post" enctype="multipart/form-data" onSubmit="return checkValue()" >
		                	<input type="hidden" id="board_no" name="board_no" value="${board_no}">
		                	<textarea class="summernote" name="bcomment_content" placeholder="댓글 작성" id="bcomment_content"></textarea>
	                		<div class="filebox">
							<input class="upload-name" value="첨부파일" placeholder="첨부파일">
							<label for="file">파일찾기</label> 
							<input type="file" id="file" name="file">
							</div>
		                	<input type="reset" value="취소" class="btn_com btn_board btn_cmt">
		                	<input type="submit" value="작성" class="btn_com btn_board btn_cmt">
	                	</form>	
	                	
	                </div>
	                
	 				<!-- 댓글갯수 -->
                    <h2><b class="comment_count">1</b>개의 댓글</h2>
                </div>
            </div>
        </div>
    </div>
    
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
	
	<!-- JS -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	<script type="text/javascript" src="/any/resources/js/board/detail/boardDetail.js"></script>
	<script type="text/javascript" src="/any/resources/js/board/board.js"></script>
	<script>
   $(document).ready(function () {

        var heartval = 1;
		var heart = document.getElementById('heart').value;
		
        if(heartval>0) {
            console.log(heartval);
            $("#heart").prop("src", "/any/resources/images/icon/heart-fill.svg");
            $(".heart").prop('name',heartval)
        }
        else {
            console.log(heartval);
            $("#heart").prop("src", "/any/resources/images/icon/heart.svg");
            $(".heart").prop('name',heartval)
        }
    });
    

</script>
</body>

</html>
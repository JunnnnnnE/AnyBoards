<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AnyBoards 게시판</title>
<link rel="shortcut icon" href="/any/resources/images/icon/icon_favicon.ico" type="image/x-icon"> <!-- favicon -->
<link rel="stylesheet" type="text/css" href="/any/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/any/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/any/resources/css/board.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />

	<!-- Contents -->
    <div id="contents">
        <div id="contents_title">
            	<h1>커뮤니티</h1>
            	<h2>커뮤니티를 통해 정보를 공유하고 소통할 수 있습니다.</h2>
        </div>
        <div id="contents_detail">
            <div id="contents_wrap">
                <!-- Category -->
                <!-- Board -->
                <div id="board_list">
                    <!-- Title -->
                    <div id="board_list_title">
					<h2>COMMUNITY</h2>	         
                    
                    <ul id="board_list_menu" class="side_menu">
	                        <li><a href="#">최신순</a></li>
							<li><a href="#">조회순</a></li>
							<li><a href="#">추천순</a></li>
							<li><a href="#">댓글순</a></li>
                        </ul>
                    </div>
                    <!-- Search -->
                    <div id="board_list_search">
						<select class="dropdown" id="selectBoxTest">
                        	<option value="" id="search" disabled>선택</option>
                            <option value="all" id="search" selected>전체</option>
                            <option value="title" id="search">제목</option>
                            <option value="content" id="search">내용</option>
                            <option value="nick" id="search">작성자</option>
                        </select>
                        <div class="search">
                            <input type="text" id="keyword"  onkeyup="enterkey()" placeholder="검색">
                            <button class="btn_search" onClick="searchBoard()"></button>
                        </div>
                    </div>
                	<!-- List Row -->
                    <div id="board_list_row">
                        <!-- Row1 -->
                        <c:choose>
							<c:when test="${paging.total > 0}">
		                        <c:forEach items="${board}" var="board">
			                        <div class="row">
			                            <div class="row_info">
			                                <div class="row_top member">
			                                    <h4>
													<c:choose>
														<c:when test="${board.board_count > 50 }">
															<span class="rank">[글쟁이]</span>
														</c:when>
														<c:otherwise>
															<span class="rank" style="color: #111;">[AnyBoarder]</span>
														</c:otherwise>
													</c:choose>
													${board.member_nick}
			                                    </h4>
			                                </div>
											<span class="row_top date"><fmt:formatDate value="${board.board_date}" pattern="yyyy.MM.dd"/></span>
			                                <ul class="row_top number">
			                                    <li><img src="/any/resources/images/icon/icon_hit.svg" class="i_hit">${board.board_hit_count}</li>
												<li><img src="/any/resources/images/icon/icon_comment.svg" class="i_cmt"></li>
												<li><img src="/any/resources/images/icon/icon_like.svg" class="i_like"></li>
											</ul>
			                            </div>
			                            <div class="row_title">
			                                <h3>
												<a class="overtext" href="/any/board/detail?board_no=${board.board_no}"> 
													${board.board_title}
													<c:if test="${board.board_file_check eq 'Y'}">
														<img src="/any/resources/images/icon/icon_file.svg" class="i_file">
													</c:if>
			                                    </a>
			                                </h3>
			                               	<p id="board_no" style="display: none;">${board.board_no}</p>
			                            </div>
			                        </div>
			                        <hr>
		                        </c:forEach>
                        	</c:when>
                        	
							<c:otherwise>
								<p>해당 내용이 없습니다.</p>
							</c:otherwise>
						</c:choose>					
                    </div>
                    <!-- Pagination -->
	                <div id="board_list_pagination">
	                	<ul>
							<!-- 왼쪽 버튼 -->
							<!-- 시작페이지가 1이 아닐 때 -->
							<c:if test="${paging.nowPage != 1}">
								<li><a class="prev" href="/any/board?sort=${sort}&search=${paging.search}&keyword=${paging.keyword}&board_group_no=${paging.board_group_no}&nowPage=${paging.nowPage - 1}&cntPerPage=${paging.cntPerPage}"></a></li>
							</c:if>
							<!-- 페이징 숫자가 나오는 부분 -->
							<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
								<c:choose>
									<c:when test="${p == paging.nowPage}">
										<li><a class="select">${p}</a></li>
									</c:when>
									<c:when test="${p != paging.nowPage}">
										<li><a href="/any/board?sort=${sort}&search=${paging.search}&keyword=${paging.keyword}&board_group_no=${paging.board_group_no}&nowPage=${p}&cntPerPage=${paging.cntPerPage}">${p}</a></li>
									</c:when>
								</c:choose>
							</c:forEach>
							<!-- 오른쪽 버튼 -->
							<c:if test="${paging.nowPage < paging.endPage}">
								<li><a class="next" href="/any/board?sort=${sort}&search=${paging.search}&keyword=${paging.keyword}&board_group_no=${paging.board_group_no}&nowPage=${paging.nowPage + 1}&cntPerPage=${paging.cntPerPage}"></a></li>
							</c:if>
						</ul>
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
	
	<!-- JS -->
	<script type="text/javascript" src="/any/resources/js/board/mainBoard.js"></script>
</body>
</html>
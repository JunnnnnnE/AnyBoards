<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AnyBoards 게시글 작성</title>
<link rel="shortcut icon" href="/any/resources/images/icon/icon_favicon.ico" type="image/x-icon"> <!-- favicon -->
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css">
<link rel="stylesheet" type="text/css" href="/any/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/any/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/any/resources/css/board.css">
<link rel="stylesheet" type="text/css" href="/any/resources/css/boardForm.css">
<link rel="stylesheet" type="text/css" href="/any/resources/css/summernote.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />

	<!-- Contents -->
    <div id="contents">
        <div id="contents_title">
            <h1>게시글 작성</h1>
            <h2>게시글을 작성할 수 있습니다.</h2>
        </div>
        <div id="contents_detail">
            <div id="contents_wrap">
                <!-- Board -->
                <div id="board_list">
                    <!-- Title -->
                    <div id="board_list_title">
                        <h2>게시글 작성</h2>
                    </div>
                    <!-- Form -->
                    <form id="board_form" name="board_form" method="post" enctype="multipart/form-data" onSubmit="return checkValue()" >
		                <table>
		                	<tbody>
			                    <tr>
			                        <th>카테고리</th>
			                        <td>
			                            <select class="dropdown" id="board_group_no" name="board_group_no">
			                            	<option value="1" selected>Community</option>
				                        </select>
			                        </td>
			                    </tr>
			                    <tr>
			                        <th>제목</th>
			                        <td>
			                           <input type="text" name="board_title" placeholder="제목"> 
			                        </td>
			                    </tr>
			                    <tr class="contents_title">
			                        <th>내용</th>
			                        <td >
			                            <textarea class="summernote" name="board_content" placeholder="내용"></textarea>
			                        </td>
			                    </tr>
			                    <tr id="fileDiv" class="file_upload">
			                        <th>첨부파일&nbsp;&nbsp;&nbsp;<a href="#this" class="btn_com btn_add_file" id="addFile">+</a></th>
			                        <td>
		                            	<input type="file" id="file" name="file_0">
		                            	<a href="#this" class="btn_com btn_del_file" id="deleteFile">파일 삭제</a>
			                        </td>
			                    </tr>
		                    </tbody>
		                </table>
		                <div id="btn_wrap">
		                	<input type="button" value="취소" class="btn_com btn_main" onClick="goBoard()">
		                    <input type="submit" value="게시글 작성" class="btn_com btn_main">
		                </div>
		            </form>
                </div>
            </div>
        </div>
    </div>
    
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
	
	<!-- JS -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	<script type="text/javascript" src="/any/resources/js/board/board.js"></script>
	<script type="text/javascript" src="/any/resources/js/board/boardWrite.js"></script>
</body>
</html>
var filebox = document.getElementById('filebox');
var fileNoArry = new Array();
var fileNameArry = new Array();

function deleteComment(board_no, ref_step, ref_level) {
		if(confirm("해당 댓글을 삭제하시겠습니까?")) {
			alert("해당 댓글을 삭제하였습니다.");
			location.href='/any/board/deleteComment?board_no='+board_no+'&ref_step='+ref_step+'&ref_level='+ref_level
		}else{
			return false;
		}
	}

//댓글 작성&수정 시 값 확인 함수
function checkValue() {


	var ext = $('#file').val().split('.').pop().toLowerCase();
	if(ext != ""){
	if ($.inArray(ext, ['gif', 'png', 'jpg', 'jpeg', 'doc', 'docx', 'xls', 'xlsx', 'hwp', 'pdf', 'zip']) == -1) {
		alert(ext + ' 확장자는 업로드 할 수 없습니다.');
		$("#file").val("");
		return false;
	}
	}else{
		return true;
	}


}

function modicheckValue() {


	var ext = $('#file-m').val().split('.').pop().toLowerCase();
	if(ext != ""){
	if ($.inArray(ext, ['gif', 'png', 'jpg', 'jpeg', 'doc', 'docx', 'xls', 'xlsx', 'hwp', 'pdf', 'zip']) == -1) {
		alert(ext + ' 확장자는 업로드 할 수 없습니다.');
		$("#file").val("");
		return false;
	}
	}else{
		return true;
	}


}
//파일 삭제 기능
function fn_del(value, name) {

	fileNoArry.push(value);
	fileNameArry.push(name);
	$("#fileNoDel").attr("value", fileNoArry);
	$("#fileNameDel").attr("value", fileNameArry);
	filebox.remove();
	
	$('#delbox').hide();
	$('#makeBox').show();
}

//파일 추가 버튼 함수
function makeFileBox(){
	$('#makeFileBox').append(filebox);
	$('#makeBox').hide();
	$('#delbox').show();
}


//답글 작성 폼 생성/제거
function recomment(ref_step, ref_level){
	if ($('.answer_form-'+ref_step+'-'+ref_level).css('display') == 'none') {
		$('.answer_form-'+ref_step+'-'+ref_level).show();
    } else {
		$('.answer_form-'+ref_step+'-'+ref_level).hide();
    }
}

//답글 수정 폼 생성
function modifyReComment(ref_step, ref_level){
	/*선택한 기존 답글 리스트를 숨기고, 숨겨뒀던 답글 폼을 보여준다 */
	$('#comment_list-'+ref_step+'-'+ref_level).hide();
	$('.answer_form-'+ref_step+'-'+ref_level).show();

}
//답글 수정 폼 생성 
function reCommentCancel(ref_step, ref_level){
	$('#comment_list-'+ref_step+'-'+ref_level).show();
	$('.answer_form-'+ref_step+'-'+ref_level).hide();
}



//댓글 접기 펼치기
function dis(ref_step, ref_level) {
	if ($('#comment_list .answer_list-'+ref_step+'-'+ref_level).css('display') == 'none') {
		$('#comment_list .answer_list-'+ref_step+'-'+ref_level).show();
    } else {
		$('#comment_list .answer_list-'+ref_step+'-'+ref_level).hide();
    }
}

function modifyComment(ref_step){
	console.log("ref_step :" + ref_step);
	
		if ($('cb-'+ref_step).css('display') == 'none') {
		$('.cb-'+ref_step).show();
	    } else {
		// 댓글 수정 버튼을 누를 시 
			$('.cb-'+ref_step).hide();
			$('#comment_form-'+ref_step).show();			
	    }
	
}

//댓글 수정 취소
function modifyCancel(ref_step){
	console.log("ref_step :" + ref_step);
	
		
		$('.cb-'+ref_step).show();
		$('#comment_form-'+ref_step).hide();			
	     
	
}

function fn_fileDown(fileNo) {
	var formObj = $("form[name='downFile']");
	$(".FILE_NO").attr("value", fileNo);
	formObj.attr("action", "/any/board/downFile");
	formObj.submit();
}

$("#btn_recommend").click(function() {
	if (confirm("해당 글을 추천하시겠습니까?")) {
		location.href="/any/board/recommend"
		alert("해당 글을 추천하였습니다.")
	}
});


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

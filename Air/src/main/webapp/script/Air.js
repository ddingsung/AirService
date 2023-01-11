function JoinCheck(){
	if(document.frm.id.value.length == 0){
		alert("아이디를 입력해주세요.");
		document.frm.id.focus();
		return false;
	}
	if(document.frm.pass.value.length == 0){
		alert("비밀번호 입력해주세요.");
		document.frm.pass.focus();
		return false;
	}
	if(document.frm.passCheck.value.length == 0){
		alert("비밀번호 확인란을 입력해주세요.");
		document.frm.passCheck.focus();
		return false;
	}
	if(document.frm.kname.value.length == 0){
		alert("한글 이름을 입력해주세요");
		document.frm.kname.focus();
		return false;
	}
	if(document.frm.ename.value.length == 0){
		alert("영어 이름을 입력해주세요");
		document.frm.ename.focus();
		return false;
	}
	if(document.frm.email.value.length == 0){
		alert("이메일을 입력해주세요");
		document.frm.email.focus();
		return false;
	}
	if(document.frm.phone.value.length == 0){
		alert("핸드폰번호를 입력해주세요");
		document.frm.phone.focus();
		return false;
	}
	if(document.frm.gender.value.length == 0){
		alert("성별을 선택해주세요");
		return false;
	}
	if(document.frm.pass.value != document.frm.passCheck.value){
		alert("비밀번호를 다시한번 확인해주세요");
		document.frm.passCheck.focus();
		return false;
	}
	if(document.frm.reid.value.length == 0){
		alert("아이디 중복체크를 해주세요");
		return false;
	}
	if(document.frm.id.value != document.frm.reid.value){
		alert("아이디 중복체크를 해주세요");
		return false;
	}
	return true;
}

function UpdateCheck(){
	if(document.frm.id.value.length == 0){
		alert("아이디를 입력해주세요.");
		document.frm.id.focus();
		return false;
	}
	if(document.frm.pass.value.length == 0){
		alert("비밀번호 입력해주세요.");
		document.frm.pass.focus();
		return false;
	}
	if(document.frm.passCheck.value.length == 0){
		alert("비밀번호 확인란을 입력해주세요.");
		document.frm.passCheck.focus();
		return false;
	}
	if(document.frm.kname.value.length == 0){
		alert("한글 이름을 입력해주세요");
		document.frm.kname.focus();
		return false;
	}
	if(document.frm.ename.value.length == 0){
		alert("영어 이름을 입력해주세요");
		document.frm.ename.focus();
		return false;
	}
	if(document.frm.email.value.length == 0){
		alert("이메일을 입력해주세요");
		document.frm.email.focus();
		return false;
	}
	if(document.frm.phone.value.length == 0){
		alert("핸드폰번호를 입력해주세요");
		document.frm.phone.focus();
		return false;
	}
	if(document.frm.gender.value.length == 0){
		alert("성별을 선택해주세요");
		return false;
	}
	if(document.frm.pass.value != document.frm.passCheck.value){
		alert("비밀번호를 다시한번 확인해주세요");
		document.frm.passCheck.focus();
		return false;
	}
	
	return true;
}


function idCheck(){
	var url = "AirServlet?command=id_Check_form&id=" + document.frm.id.value;
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars = yes, resizable = no, width = 450, height = 200");
}

function idok(){
	opener.frm.id.value = document.frm.id.value;
	opener.frm.reid.value = document.frm.id.value;
	self.close();
}

function deleteCheck(){
	if(!confirm("정말로 취소 하시겠습니까?")){
		return false;
	}else{
		alert("예매가 취소되었습니다.");
	}
}
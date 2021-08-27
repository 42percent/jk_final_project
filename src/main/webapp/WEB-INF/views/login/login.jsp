<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" type="text/css" />  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<!-- cookie -->
<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>

</head>
<body onkeydown="javascript:onEnterLogin();">
<h1>로그인</h1>
<form action="loginAf.do" name="loginForm" id="_frmForm" method="POST"> 

<div class=""> 
<label for="id">아이디</label>
<input id="_id" type="text" name="id" placeholder="아이디"> 

</div> 

<div class=""> 
<label for="pwd">비밀번호</label>
<input id="_pwd" type="password" name="pwd" placeholder="비밀번호"> 

</div> 

<div class="">
<label>
   <input type="checkbox" id="chk_save_id">아이디 저장
</label>
</div>

<span title="아이디찾기" id="findid-btn">아이디찾기</span>
<br>
<button type="button" id="findpw-btn" title="비밀번호찾기">비밀번호찾기</button> 

<button type="button" class="" id="_btnLogin" title="로그인">로그인</button> 
<button type="button" class="" id="_btnRegi" title="회원가입">회원가입</button>


</form>

<script type="text/javascript">
let _id = $.cookie("_id");
if(_id != null){
	//alert("쿠키 있음");
	$("#_id").val( _id );
	$("#chk_save_id").attr("checked", "checked");	
}

$("#chk_save_id").click(function(){

	if( $("#chk_save_id").is(":checked") ){	// 첵크 되었을 때
		if( $("#_id").val().trim() == ""){
			alert("id를 입력해 주십시오");
			$("#chk_save_id").prop("checked", false);
		}
		else{
			$.cookie("_id", $("#_id").val(), { expires:356, path:'/' });
		}
	}
	else{
		//alert("쿠키 삭제");
		$.removeCookie("_id", {path:'/'});
	}	
});


$("#_btnRegi").click(function () {
	location.href = "regi.do";
});

$("#_btnLogin").click(function () {
	
	if($("#_id").val().trim() == ""){
		alert("id를 입력해 주십시오");
		$("#_id").focus();
	}else if($("#_pwd").val().trim() == ""){
		alert("패스워드를 입력해 주십시오");
		$("#_pwd").focus();
	}else{
		$("#_frmForm").submit();
	}

});


</script>

<script type="text/javascript">

$(function () {
	$("#findid-btn").click(function () {
		location.href='findid.do';
	});
});


$(function () {
	$("#findpw-btn").click(function () {
		location.href='findpw.do';
	});
});


</script>

<script type="text/javascript">

		function onEnterLogin(){

			var keyCode = window.event.keyCode;

			

			if (keyCode == 13) { //엔테키 이면

				loginForm.submit();

			}

		} //onEnterLogin()
		
		

	</script>






</body>
</html>
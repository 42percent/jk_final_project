<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" type="text/css" />  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

</head>
<body>

	<form method="post" action="findidAf.do" name="frmForm" id="_frmForm">
	
		<div>
			<input type="text" id="name" name="name"/>
			<label for="name">name</label>
		</div>
		<div>
			<input type="text" id="phone" name="phone"/>
			<label for="phone">phone</label>
		</div>
		<div>
			<input type="text" id="email" name="email"/>
			<label for="email">email</label>
		</div>

        <div>
			<input type="submit" value="check">
		</div>
<button type="button" id="_btnlogin" title="로그인화면으로 돌아가기">로그인화면으로 돌아가기</button>

<br><br>
		<!-- 이름과 전화번호가 일치하지 않을 때-->
		<c:if test="${check == 1}">
			<script>
			    opener.document.frmForm.name.value = "";
			    opener.document.frmForm.phone.value = "";
				opener.document.frmForm.email.value = "";
			</script>
			<label>일치하는 정보가 존재하지 않습니다.</label>
			
			
		</c:if>

		<!-- 이름과 비밀번호가 일치할 때 -->
		<c:if test="${check == 0 }">
		<label> 찾으시는 아이디는 ' ${ id }' 입니다.</label>	
		</c:if>

	</form>
<script type="text/javascript">
$("#_btnlogin").click(function () {
	location.href = "login.do";
});

</script>

</body>
</html>
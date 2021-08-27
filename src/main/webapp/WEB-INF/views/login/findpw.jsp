<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" type="text/css" />  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

</head>
<body>


	
		
		<div>
			<input type="text" id="id" name="id"/>
			<label for="id">ID</label>
		</div>
		<div>
			<input type="text" id="name" name="name"/>
			<label for="name">NAME</label>
		</div>
		<div>
			<input type="text" id="email" name="email"/>
			<label for="email">E-MAIL</label>
		</div>

        <div>
			<input type="submit" value="check" id="check" name="check">
		</div>
<button type="button" id="_btnlogin" title="로그인화면으로 돌아가기">로그인화면으로 돌아가기</button>


<script>
	$(function(){
		$("#check").click(function(){
			$.ajax({
				url : "findpw.do",
				type : "POST",
				data : {
					id : $("#id").val(),
					name : $("#name").val(),
					email : $("#email").val()
				},
				success : function(result) {
					alert(result);
				},
			})
		});
	})


</script>

<script type="text/javascript">
$("#_btnlogin").click(function () {
	location.href = "login.do";
});

</script>

</body>
</html>
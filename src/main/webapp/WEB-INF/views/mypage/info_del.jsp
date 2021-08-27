<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>
    
<c:set var="mem" value="${mem}"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" type="text/css" />  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
</head>
<body>

<form action="info_delAf.do" name="frmForm" id="_frmForm" method="post">

<h1>회원탈퇴</h1>

아이디 : <input type="text" name="id" >
비밀번호 : <input type="password" name="pwd">

 <div class="">
<input type="submit" class="" id="_btndelAf" value="탈퇴하기">
 </div>
 
  <div class="">
<input type="submit" class="" id="_btn" value="돌아가기">
 </div>


</form>

<script type="text/javascript">
$("#_btn").click(function () {
	location.href = "mypage_main.do";
});

</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Market Write</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<form name="frmForm" id="frmForm" action="marketupload.do" method="post" enctype="multipart/form-data">

카테고리 : 
<select name="canum" >
			<option value="1">육류</option>
			<option value="2">수산</option>
			<option value="3">채소</option>	
			<option value="4">과일</option>
			<option value="5">밀키트</option>
</select>
<br>
서브 카테고리 :
<input type="text" name="subca" size="50">
<br>
상품명 :
<input type="text" name="title" size="50">
<br>
상품서브설명 :
<input type="text" name="subtitle" size="50">
<br>
가격 :
<input type="text" name="price" size="10">
<br>
용량/중량 :
<input type="text" name="gram" size="10">
<br>
원산지 : 
<input type="text" name="country" size="10">
<br>
유통기한 : 
<input type="text" name="expiration" size="50">
<br>
상품내용 : 
<input type="file" name="fileload" size="10">
<br>
메인사진 : 
<input type="file" name="fileload2" size="10">

<a href="#none" id="_btnWrite" title="상품등록">상품등록</a>
</form>



</body>

<script type="text/javascript">
$("#_btnWrite").click(function () {
	//alert('상품등록');
	
	$("#frmForm").submit();
});
</script>
</html>
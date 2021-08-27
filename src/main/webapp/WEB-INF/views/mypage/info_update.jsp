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
<title>회원정보수정</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" type="text/css" />  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<!-- 다음지도 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>



<form action="info_updateAf.do" name="frmForm" id="_frmForm" method="POST"> 


<label for="id">아이디</label>
<input type="text" name="id" value="${mem.id }" readonly="readonly" >
<br>
<label for="pwd">비밀번호</label>
<input type="password" name="prepwd" value="${mem.pwd }" >
<br>
<label for="newpwd">비밀번호 변경</label>
<input type="password" name="pwd" id="newpwd" >
<div class="" id="newpwd_check"></div>
<br>
<label for="newpwd2">비밀번호 확인</label>
<input type="password" name="newpwd" id="newpwd2" >
<div class="" id="newpwd2_check"></div>
<br>
<label for="name">이름</label>
<input type="text" name="name" value="${mem.name }">
<br>
<label for="nickname">닉네임</label>
<input type="text" name="nickname" id="_nickname" value="${mem.nickname }">
<div class="" id="nickname_check"></div>
<br>
<label for="gender">성별</label>
<input value="${mem.gender }" name="gender" readonly="readonly">
<br>
<label for="birth">생년월일</label>
<input value="${mem.birth }" name="birth" readonly="readonly">
<br>
<label for="phone">휴대폰번호</label>
<input type="text" name="phone" value="${mem.phone }">
<br>
<label for="email">이메일</label>
<input type="text" name="email" value="${mem.email }">
<br>

<label for="address1">주소</label>                 
<input class="" placeholder="우편번호" name="address1" id="addr1" type="text" required>
<button type="button" class="" onclick="execPostCode();">우편번호 찾기</button>                               
<input class="form-control" style="top: 5px;" placeholder="도로명 주소" name="address1" id="addr2" type="text" required />
<input class="form-control" placeholder="상세주소" name="address1" id="addr3" type="text" required />



 <div class="">
<input type="submit" class="" id="_btnupdateAf" value="수정완료">
 </div>
 
  <div class="">
<input type="submit" class="" id="_btn" value="돌아가기">
 </div>


</form>



<script type="text/javascript">
$("#_btn").click(function () {
	location.href = "mypage_main.do";
});

/* 주소 */

function execPostCode() {
    new daum.Postcode({
        oncomplete: function(data) {
           // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

           // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
           // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
           var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
           var extraRoadAddr = ''; // 도로명 조합형 주소 변수

           // 법정동명이 있을 경우 추가한다. (법정리는 제외)
           // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
           if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
               extraRoadAddr += data.bname;
           }
           // 건물명이 있고, 공동주택일 경우 추가한다.
           if(data.buildingName !== '' && data.apartment === 'Y'){
              extraRoadAddr += (extraRoadAddr !== '' ? ', '+  data.buildingName : data.buildingName);
           }
           // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
           if(extraRoadAddr !== ''){
               extraRoadAddr = ' (' + extraRoadAddr + ')';
           }
           // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
           if(fullRoadAddr !== ''){
               fullRoadAddr += extraRoadAddr;
           }

           // 우편번호와 주소 정보를 해당 필드에 넣는다.
           console.log(data.zonecode);
           console.log(fullRoadAddr);
           
           
           $("#addr1").val(data.zonecode);
           $("#addr2").val(fullRoadAddr);
           
           
           
           /* document.getElementById('signUpUserPostNo').value = data.zonecode; //5자리 새우편번호 사용
           document.getElementById('signUpUserCompanyAddress').value = fullRoadAddr;
           document.getElementById('signUpUserCompanyAddressDetail').value = data.jibunAddress; */
       }
    }).open();
}

$(document).ready(function() {
	   let location = "${mem.address1}";
	   let a = location.indexOf(",");
	   let b = location.lastIndexOf(",");
	   let addr1 = location.substring(0, a);
	   let addr2 = location.substring(a+1, b);
	   let addr3 = location.substring(b+1);
	     
	     $('#addr1').val(addr1);
	     $('#addr2').val(addr2); 
	     $('#addr3').val(addr3); 
	});
	
// 비밀번호 정규식
var pwJ = /^[A-Za-z0-9]{4,12}$/; 

/* 닉네임 유효성 검사 */
$("#_nickname").blur(function () {
	// 닉네임 첵크	

	$.ajax({
		url: "getnickname.do",
		type:"post",
		data:{ nickname:$("#_nickname").val() },
		success:function( msg ){
			if(msg == 'YES'){
				$("#nickname_check").text("사용중인 닉네임입니다");
				$("#nickname_check").css("color", "red");
				$("#_nickname").val("");
				
			       } else if ($("#_nickname").val().trim() == ""){
				      $('#nickname_check').text('닉네임을 입력해주세요');
				      $('#nickname_check').css('color', 'red');
				      	  
			}else {	
				   $("#nickname_check").text("이 닉네임은 사용할 수 있습니다 ");
				   $("#nickname_check").css("color", "blue");
				   $("#_nickname").val().trim();
				   
					
			}
		}, error:function(){
			alert('error');
		}
	});

});


//비밀번호 
$("#_newpwd").blur(function() {
	if (pwJ.test($(this).val())) {
			console.log(pwJ.test($(this).val()));
			$("#newpwd_check").text('');
	} else {
		$('#newpwd_check').text('4~12자 영문 대 소문자, 숫자를 사용하세요.');
		$('#newpwd_check').css('color', 'red');
		
	}
});

$("#_pwd2").blur(function() {
	if ($('#_newpwd').val() == $('#_newpwd2').val()) {
			$("#newpwd2_check").text('');
	} else {
		$('#newpwd2_check').text('비밀번호가 일치하지 않습니다.');
		$('#newpwd2_check').css('color', 'red');
		
	}
});



</script>  



</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" type="text/css" />  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<!-- 다음지도 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<style type="text/css">
#email_num_false{
     background-color: #ebebe4;
}
#email_num_true{
     background-color: white; 
}

.correct{
    color : green;
}
.incorrect{
    color : red;
}
</style>

</head>
<body>

<form action="regiAf.do" name="frmForm" id="_frmForm" method="POST"> 

			<!-- 이름 -->
			<div class="">
				<label for="name">이름</label><br>
					<input type="text" class="" id="_name" name="name" placeholder="Name" required>
				<div class="" id="name_check"></div>
			</div>
			<!-- 닉네임 -->
			<div class="">
				<label for="nickname">닉네임</label><br>
					<input type="text" class="" id="_nickname" name="nickname" placeholder="Nickname" required>
				<div class="" id="nickname_check"></div>
			</div>
			<!-- 성별 -->
			<div>
				<input type="radio" id="_gender" name="gender" value="남자" checked="checked" required>&nbsp;남 
				<input type="radio" id="_gender" name="gender" value="여자" required>&nbsp;여
			</div>
			<!-- 생년월일 -->
			<div class="">
				<label for="birth">생년월일</label><br>
					<input type="text" class="" id="_birth" name="birth" placeholder="ex) 19990415" required>
				<div class="" id="birth_check"></div>
			</div>
			
			<!-- 휴대전화 -->
			<div class="">
				<label for="phone">휴대폰번호 ('-' 없이 번호만 입력해주세요)</label><br>
				<input type="text" class="" id="_phone" name="phone" placeholder="Phone Number" required>
				<div class="" id="phone_check"></div>
			</div>
			
			 <div class="">
               <label for="address">주소</label><br>                   
                 <input class="" placeholder="우편번호" name="address1" id="addr1" type="text" readonly="readonly" required>
                 <button type="button" class="" onclick="execPostCode();">우편번호 찾기</button>                               
            </div>
            <div class="">
                  <input class="form-control" style="top: 5px;" placeholder="도로명 주소" name="address1" id="addr2" type="text" readonly="readonly" required />
            </div>
            <div class="">
                  <input class="form-control" placeholder="상세주소" name="address1" id="addr3" type="text" required />
            </div>

			<!-- 이메일 -->
			     
			<div class="mail_wrap">
				<div class="mail_name">이메일</div> 
				<div class="mail_input_box">
					<input class="mail_input" name="email" id="_email">
					<div class="" id="email_check"></div>
				</div>

				
				<div class="mail_check_wrap">
					<div class="mail_check_input_box" id="mail_check_input_box_false">
						<input class="mail_check_input" placeholder="인증번호를 입력해주세요" id="check_mail" disabled="disabled">
						<div id="mail_input_box_warn"></div>
					</div>
						<button type="button" id="mail_check_button">인증번호 전송</button>
					<div class="clearfix"></div>
					<span id="mail_check_input_box_warn"></span>
				</div>
			</div>
			
	      <div class="">
	       <input type="submit" class="" id="_btnRegi" value="회원가입">
	      </div>
</form>



	



<script type="text/javascript">

var code = "";                //이메일전송 인증번호 저장위한 코드

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


    
/* 정규식 */
 
//모든 공백 체크 정규식
	var empJ = /\s/g;
	//아이디 정규식
	var idJ = /^[a-z0-9]{4,12}$/;
	// 비밀번호 정규식
	var pwJ = /^[A-Za-z0-9]{4,12}$/; 
	// 이름 정규식
	var nameJ = /^[가-힣]{2,6}$/;
	// 이메일 검사 정규식
	var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	// 휴대폰 번호 정규식
	var phoneJ = /^01([0|1|6|7|8|9]?)?([0-9]{4})?([0-9]{4})$/;
	
	
	


	/* 아이디 유효성 검사 */
$("#_id").blur(function () {
	// id첵크	

	$.ajax({
		url: "getId.do",
		type:"post",
		data:{ id:$("#_id").val() },
		success:function( msg ){
			if(msg == 'YES'){
				$("#id_check").text("사용중인 아이디입니다");
				$("#id_check").css("color", "red");
				$("#_id").val("");
				
			    } else if ($("#_id").val().trim() == ""){
				   $('#id_check').text('아이디를 입력해주세요');
				   $('#id_check').css('color', 'red');
				   	  
			}else {	
				   if (idJ.test($("#_id").val())) {
				      $("#id_check").text("이 아이디는 사용할 수 있습니다 ");
				      $("#id_check").css("color", "blue");
				      $("#_id").val().trim();
				     
				 } else {
				      $('#id_check').text("4~12자 영문 소문자, 숫자를 사용하세요.");
				      $('#id_check').css('color', 'red');
				      		
			}
			}
		}, error:function(){
			alert('error');
		}
	});

});


//비밀번호 
	$("#_pwd").blur(function() {
		if (pwJ.test($(this).val())) {
				console.log(pwJ.test($(this).val()));
				$("#pwd_check").text('');
		} else {
			$('#pwd_check').text('4~12자 영문 대 소문자, 숫자를 사용하세요.');
			$('#pwd_check').css('color', 'red');
			
		}
	});
	
	$("#_pwd2").blur(function() {
		if ($('#_pwd').val() == $('#_pwd2').val()) {
				$("#pwd2_check").text('');
		} else {
			$('#pwd2_check').text('비밀번호가 일치하지 않습니다.');
			$('#pwd2_check').css('color', 'red');
			
		}
	});
	
	
	



/* 닉네임 유효성 검사 */
$("#_nickname").blur(function () {
	// id첵크	

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


	
	
	// 이름에 특수문자 들어가지 않도록 설정
	$("#_name").blur(function() {
		if (nameJ.test($(this).val())) {
				console.log(nameJ.test($(this).val()));
				$("#name_check").text('');

		    } else {
		    	 if ($("#_name").val().trim() == ""){
		            $('#name_check').text('이름을 입력해주세요');
		            $('#name_check').css('color', 'red');
		            	
		    	
		        } else {
			        $('#name_check').text('이름을 확인해주세요');
			        $('#name_check').css('color', 'red');
			        
		    }
		    }
	});
	
	// 휴대전화
	$('#_phone').blur(function(){
		if(phoneJ.test($(this).val())){
			console.log(nameJ.test($(this).val()));
			$("#phone_check").text('');
		} else {
			 if ($("#_phone").val().trim() == ""){
		            $('#phone_check').text('휴대폰번호를 입력해주세요');
		            $('#phone_check').css('color', 'red');
		            	
		    	
		        } else {
			        $('#phone_check').text('휴대폰번호를 확인해주세요');
			        $('#phone_check').css('color', 'red');
			        
		    }
		}
	});
	
	// 생일 유효성 검사
	var birthJ = false;
	
	// 생년월일	birthJ 유효성 검사
	$('#_birth').blur(function(){
		var dateStr = $(this).val();		
	    var year = Number(dateStr.substr(0,4)); // 입력한 값의 0~4자리까지 (연)
	    var month = Number(dateStr.substr(4,2)); // 입력한 값의 4번째 자리부터 2자리 숫자 (월)
	    var day = Number(dateStr.substr(6,2)); // 입력한 값 6번째 자리부터 2자리 숫자 (일)
	    var today = new Date(); // 날짜 변수 선언
	    var yearNow = today.getFullYear(); // 올해 연도 가져옴
		
	    if (dateStr.length <=8) {
			// 연도의 경우 1900 보다 작거나 yearNow 보다 크다면 false를 반환합니다.
		    if (1900 > year || year > yearNow){
		    	
		    	$('#birth_check').text('생년월일을 확인해주세요 ');
				$('#birth_check').css('color', 'red');
		    	
		    }else if (month < 1 || month > 12) {
		    		
		    	$('#birth_check').text('생년월일을 확인해주세요 ');
				$('#birth_check').css('color', 'red'); 
		    
		    }else if (day < 1 || day > 31) {
		    	
		    	$('#birth_check').text('생년월일을 확인해주세요 ');
				$('#birth_check').css('color', 'red'); 
		    	
		    }else if ((month==4 || month==6 || month==9 || month==11) && day==31) {
		    	 
		    	$('#birth_check').text('생년월일을 확인해주세요 ');
				$('#birth_check').css('color', 'red'); 
		    	 
		    }else if (month == 2) {
		    	 
		       	var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
		       	
		     	if (day>29 || (day==29 && !isleap)) {
		     		
		     		$('#birth_check').text('생년월일을 확인해주세요 ');
					$('#birth_check').css('color', 'red'); 
		    	
				}else{
					$('#birth_check').text('');
					birthJ = true;
				}//end of if (day>29 || (day==29 && !isleap))
		     	
		    }else{
		    	
		    	$('#birth_check').text(''); 
				birthJ = true;
			}//end of if
			
			}else {//1.입력된 생년월일이 8자 초과할때 :  auth:false
				        $('#birth_check').text('생년월일을 확인해주세요');
				        $('#birth_check').css('color', 'red');
				        
			    
			}
		}); //End of method /*
		
	// 이메일
		$("#_email").blur(function() {
			if (mailJ.test($(this).val())) {
					console.log(mailJ.test($(this).val()));
					$("#email_check").text('');

			    } else {
			    	 if ($("#_name").val().trim() == ""){
			            $('#email_check').text('이메일을 입력해주세요');
			            $('#email_check').css('color', 'red');
			            	
			    	
			        } else {
				        $('#email_check').text('이메일을 확인해주세요');
				        $('#email_check').css('color', 'red');
				        
			    }
			    }
		});

		 /* 인증번호 이메일 전송 */
		 $("#mail_check_button").click(function(){
		 	
		 	var email = $(".mail_input").val();			// 입력한 이메일
		 	var checkBox = $(".mail_check_input");		// 인증번호 입력란
		 	var boxWrap = $(".mail_check_input_box");	// 인증번호 입력란 박스
		 	var warnMsg = $("#mail_input_box_warn");	// 이메일 입력 경고글
		 	
		 	/* 이메일 형식 유효성 검사 */
		 	if(mailJ.test($(this).val()) || $("#_email").val().trim() == ""){
		 		warnMsg.html("올바르지 못한 이메일 형식입니다.");
		 		warnMsg.css("display", "inline-block");
		 		return false;
		 	} else {
		 		warnMsg.html("이메일이 전송 되었습니다. 이메일을 확인해주세요.");
		 		$("#email_check").text('');
		 	}	
		 	
		 	$.ajax({
		 		
		 		type:"GET",
		 		url:"mailCheck.do?email=" + email,
		 		success:function(data){
		 			
		 			//console.log("data : " + data);
		 			checkBox.attr("disabled",false);
		 			boxWrap.attr("id", "mail_check_input_box_true");
		 			code = data;
		 			
		 		}
		 				
		 	});
		 	
		 });
		 /* 인증번호 비교 */
		 $(".mail_check_input").blur(function(){
		 	
		 	var inputCode = $(".mail_check_input").val();		// 입력코드	
		 	var checkResult = $("#mail_check_input_box_warn");	// 비교 결과 	
		 	
		 	if(inputCode == code){							// 일치할 경우
		 		checkResult.html("인증번호가 일치합니다.");
		 		checkResult.attr("class", "correct");		
		 		mailnumCheck = true;
		 	} else {											// 일치하지 않을 경우
		 		checkResult.html("인증번호를 다시 확인해주세요.");
		 		checkResult.attr("class", "incorrect");
		 		mailnumCheck = false;
		 	}	
		 	
		 });
		
		
			
		// 가입하기 실행 버튼 유효성 검사!
		var inval_Arr = new Array(8).fill(false);
		$('#_btnRegi').click(function(){
			// 비밀번호 정규식
			if (pwJ.test($('#_pwd').val())) {
				inval_Arr[0] = true;
			} else {
				inval_Arr[0] = false;
			}
			
			// 이름 정규식
			if (nameJ.test($('#_name').val())) {
				inval_Arr[1] = true;	
			} else {
				inval_Arr[1] = false;
			}
			// 생년월일 정규식
			if (birthJ) {
				console.log(birthJ);
				inval_Arr[2] = true;
			} else {
				inval_Arr[2] = false;
			}
			// 이메일 정규식
			if (mailJ.test($('#_email').val())){
				inval_Arr[3] = true;
			} else {
				inval_Arr[3] = false;
			} 
			// 휴대폰번호 정규식
			if (phoneJ.test($('#_phone').val())) {
				console.log(phoneJ.test($('#_phone').val()));
				inval_Arr[4] = true;
			} else {
				inval_Arr[4] = false;
			}
			//주소
			 if ($("#addr1").val().trim() == ""){
				 inval_Arr[5] = false;
		        } else {
		         inval_Arr[5] = true;
		    }
			//닉네임
			 if ($("#_nickname").val().trim() == ""){
				 inval_Arr[6] = false;
		        } else {
		         inval_Arr[6] = true;
		    }
			//인증번호
			 if ($("#check_mail").val().trim() == ""){
				 inval_Arr[7] = false;
		        } else {
		         inval_Arr[7] = true;
		    }
			
			var validAll = true;
			for(var i = 0; i < inval_Arr.length; i++){
				
				if(inval_Arr[i] == false){
					validAll = false;
				}
			}
			if(validAll){ // 유효성 모두 통과

				alert('회원가입에 성공하셨습니다!');
				
			} else {
				alert('입력한 정보들을 다시 한번 확인해주세요')
				
			}
			
		});
		
</script>


</body>
</html>
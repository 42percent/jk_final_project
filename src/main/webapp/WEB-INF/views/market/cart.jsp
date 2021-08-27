<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:requestEncoding value="utf-8"/>
<c:set var="cartCount" value="${cartCount}"/>
<c:set var="login" value="${login}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<title>Cart</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
	<link rel="stylesheet" href="css/10-11.css" />
	<link href="css/styles.css" rel="stylesheet" /> 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- 결제관련 -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
    <!-- 다음지도 -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
      let location = "${login.address1}";
      let a = location.indexOf(",");
      let b = location.lastIndexOf(",");
      let addr1 = location.substring(0, a);
      let addr2 = location.substring(a+1, b);
      let addr3 = location.substring(b+1);
      
      
        $('#addr1').val(addr1);
        $('#addr2').val(addr2); 
        $('#addr3').val(addr3); 
   });
    </script>
	
 	<script type="text/javascript">
		$(document).ready(function() {
			basket.reCalc();
			basket.updateUI();
		});
	</script> 
	
	<!-- 카테고리 드롭다운바 -->
	<script type="text/javascript">
        $(document).ready(function() {
        	$('#ca_manu .dropdown-menu').hide();
        	
        	$('.nav-link').mouseover(function () {
				$('.dropdown-menu').slideDown();
			});
        	$('.dropdown-menu').mouseleave(function () {
				$('.dropdown-menu').hide();
			});
        	
        });
        </script>
        
        <!-- 검색기능 -->
        <script type="text/javascript">
        $(document).ready(function() {
        $("#btnSearch").click(function () {
        	location.href = "getSearchList.do?search=" + $("#_search").val();	
        	});
        });
        </script>
        
        <!-- 카카오 주소 API -->
        <script type="text/javascript">
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
           $("#addr3").val('');
           
       }
    }).open();
}
</script>

<script type="text/javascript">

function delCart(data) {
	
	var seq = data;
	
	$.ajax({
		url:"delCart.do",
		type:"GET",
		data: {"seq":seq},
		success:function(data){
			//alert("삭제합니다");
			location.reload(true); 
			self.close();
		},
		error:function(){
			alert("에러발생");
			self.close();
		}
	});
	
}

function countUp(count,seq) {
	
	var allData = {"count":count, "seq":seq};
	
	$.ajax({
		url:"countUp.do",
		type:"GET",
		data:allData,
		success:function(data){
			//alert("수량증가");
			location.reload(true);
			self.close();
		},
		error:function(){
			alert("수량증가 에러발생");
			self.close();
		}
	});
}

function countDown(count,seq){
	
	var allData = {"count":count, "seq":seq};
	
	$.ajax({
		url:"countDown.do",
		type:"GET",
		data:allData,
		success:function(data){
			//alert("수량감소");
			location.reload(true); 
			self.close();
		},
		error:function(){
			alert("수량감소 에러발생");
			self.close();
		}
	});
}

</script>

<script type="text/javascript">
	function delAllItem(data) {
		
		var id = data
		
		$.ajax({
			url:"delAllItem.do",
			type:"GET",
			data: {"id":id},
			success:function(data){
				//alert("delAllItem 성공");
				location.reload(true); 
				self.close();
			},
			error:function(){
				alert("delAllItem 에러");
				self.close();
			}
		});
		
	}
	
</script>

 

<script type="text/javascript">
	$(document).ready(function() {
		
		$("#orderSubmit").click(function () {
			
			var len = $("input[name='buy']:checked").length;
			var IMP = window.IMP; // 생략가능
			
			
			
			
			IMP.init('imp30434795');
		// 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
		// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
			IMP.request_pay({
				pg: 'inicis', 
				pay_method: 'card',
				merchant_uid: new Date().getTime(),
				name: '${login.name}'+'님 상품'+len+'개',//결제창에서 보여질 이름
				amount: $('#sumPrice').val() ,            //가격
				buyer_email: '${login.email}',
				buyer_name: '${login.name}',
				buyer_tel: '${login.phone}',
				buyer_addr: $('#addr2').val() + $('#addr3').val() ,
				buyer_postcode: $('#addr1').val(),
			}, function (rsp) {
				console.log(rsp);
				if (rsp.success) {
					//체크한 상품만 JSON데이터로 보내보기 오더넘버는 merchant_uid로 지정
					var orderNum = rsp.merchant_uid;
					var Arr = [];
					
					$('.chk:checked').each(function(){
						var seq = $(this).val();
						//console.log(seq);
						Arr.push(seq);
					});
					console.log("Arr>>>>"+Arr);
					var dataList = Arr;
					
					//var allData = {"orderNum":orderNum, "checkArray":dataList};
					console.log("dataList>>>>"+dataList); 
					console.log("orderNum>>>>"+orderNum);
					//console.log("allData>>>>"+JSON.stringify(allData));
					
					$.ajax({
						type : "POST",
						url : "getData.do",
						data : {
							dataList:dataList,
							orderNum:orderNum
						},
						dataType:'JSON',
						traditional: true ,
						success:function(data){
							alert("데이터 넘기기 성공");
							console.log(data);
							location.reload(true); 
						},
						error : function() {
							console.log('에러');
							location.reload(true); 
						}
					});
				} else {
					var msg = '결제에 실패하였습니다.';
					msg += '에러내용 : ' + rsp.error_msg;
				}
			});
		});
		
	});
	
</script>
        

</head>
<body>
    	<div align="center" style="height: 100px">
    		<a>로고</a><br>
    		<a href="marketmain.do">메인으로 이동</a>
    		<a href="marketwrite.do">상품등록</a>
    	</div>
    	<div align="right">회원가입/로그인</div>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                    	<li class="nav-item dropdown" >
                            <a class="nav-link dropdown-toggle" id="ca_manu">전체 카테고리</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="marketlist.do?canum=1">
                                	<img src="./image/meat.png" alt="카테고리 아이콘" style="width: 24px; height: 24px;">
                                	정육</a>
                                </li>
                                <li><a class="dropdown-item" href="marketlist.do?canum=2">
                                	<img src="./image/fish.png" alt="카테고리 아이콘" style="width: 24px; height: 24px;">
                                	수산</a></li>
                                <li><a class="dropdown-item" href="marketlist.do?canum=3">
                                	<img src="./image/carrot.png" alt="카테고리 아이콘" style="width: 24px; height: 24px;">
                                	채소</a></li>
                                <li><a class="dropdown-item" href="marketlist.do?canum=4">
	                                <img src="./image/fruit.png" alt="카테고리 아이콘" style="width: 24px; height: 24px;">
	                                과일</a>
                                </li>
                                <li><a class="dropdown-item" href="'marketlist.do?canum=5'">
                                	<img src="./image/kit.png" alt="카테고리 아이콘" style="width: 24px; height: 24px;">
                                	밀키트</a>
                                </li>
                            </ul>
                        </li>&nbsp;&nbsp;&nbsp;&nbsp;
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="newMarketList.do">신상품</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
                        <li class="nav-item"><a class="nav-link" href="#!">베스트</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
                        <li class="nav-item"><a class="nav-link" href="#!">할인/특가</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
                    </ul>
                    <form class="d-flex" action="getSearchList.do">
					    <input class="form-control me-2" placeholder="Search" aria-label="Search" id="_search">
					    <button class="btn btn-outline-success" type="button" id="btnSearch">Search</button>
				    </form>&nbsp;&nbsp;&nbsp;&nbsp;
                    <form class="d-flex">
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill">${cartCount}</span>
                        </button>
                    </form>
                </div>
            </div>
        </nav>

    <form name="orderform" id="orderform" method="post" class="orderform" action="/Page" onsubmit="return false;">
    
            <div class="basketdiv" id="basket">
                <div class="row head">
                    <div class="subdiv">
                        <div class="check">선택</div>
                        <div class="img">이미지</div>
                        <div class="pname">상품명</div>
                    </div>
                    <div class="subdiv">
                        <div class="basketprice">가격</div>
                        <div class="num">수량</div>
                        <div class="sum">합계</div>
                    </div>
                    <div class="subdiv">
                        <div class="basketcmd"></div>
                    </div>
                    <div class="split"></div>
                </div>
        		<c:set var="row_count" value="0"/>
        		<c:set var="row_sum" value="0" />
        		<c:forEach var="list" items="${cartList}" varStatus="i" >
                <div class="row data">
                    <div class="subdiv">
                        <div class="check"><input type="checkbox" class="chk" name="buy" value="${list.seq}" checked="checked" onclick="basket.checkItem();">&nbsp;</div>
                        <div class="img"><img src="./marketimage/${list.mainpt}" width="60"></div>
                        <input type="hidden" value="${list.mainpt}" id="mainpt">
                        <input type="hidden" value="${list.title}" id="title">
                        <input type="hidden" value="${list.canum}" id="canum">
                        <div class="pname">
                            <span>${list.title}</span>
                        </div>
                    </div>
                    <div class="subdiv">
                        <div class="basketprice"><input type="text" name="p_price" id="p_price${i.count}" class="p_price" value="${list.price}"></div>
                        <div class="num">
                            <div class="updown">
                                <input type="text" name="p_num" id="p_num${i.count}" size="2" maxlength="4" class="p_num" value="${list.count}"  onkeyup="basket.changePNum(${i.count});">
                                <%-- <span onclick="basket.changePNum(${i.count});"><i class="fas fa-arrow-alt-circle-up up"></i></span>
                                <span onclick="basket.changePNum(${i.count});"><i class="fas fa-arrow-alt-circle-down down"></i></span> --%>
                                <span onclick="countUp('${list.count}','${list.seq}');"><i class="fas fa-arrow-alt-circle-up up"></i></span>
                                <span onclick="countDown('${list.count}','${list.seq}');"><i class="fas fa-arrow-alt-circle-down down"></i></span>
                            </div>
                        </div>
                        
                        <div class="sum"><fmt:formatNumber value="${list.price * list.count}" pattern="#,###,###" />원</div>
                        <c:set var="row_count" value="${row_count + list.count}"/>
                        <c:set var="row_sum" value="${row_sum + (list.price * list.count)}" />
                    </div>
                    <div class="subdiv">
                         <div class="basketcmd"><a href="javascript:void(0)" class="abutton" onclick="delCart('${list.seq}');">삭제</a></div> 
                    </div>
                </div>
                </c:forEach>
            </div>
    
            <div class="right-align basketrowcmd">
                <a href="javascript:void(0)" class="abutton" onclick="basket.delCheckedItem();">선택상품삭제</a>
                <a href="javascript:void(0)" class="abutton" onclick="delAllItem('${login.id}');">장바구니비우기</a>
            </div>
    		
            <div class="bigtext right-align sumcount" id="sum_p_num">상품갯수: <c:out value="${row_count}"/>개</div>
            <div class="bigtext right-align box blue summoney" id="sum_p_price">합계금액: <c:out value="${row_sum}"/>원</div>
            <input type="hidden" id="sumPrice" value="${row_sum}">
    
    	<ul class="list-group list-group-flush" style="padding-left: 300px; padding-right: 300px; padding-bottom: 100px;">
        	<li class="list-group-item">

    		</li>
			<li class="list-group-item">
				<a>주문자</a>	<a style="padding-left: 100px" id="userName">${login.name}</a>
    		</li>
			<li class="list-group-item">
				<a>휴대폰</a>	<a style="padding-left: 100px" id="userPhone">${login.phone}</a>
			</li>
			<li class="list-group-item">
				<a>이메일</a>	<a style="padding-left: 100px" id="userEmail">${login.email}</a>
			</li>
			<li class="list-group-item">
				<a style="padding-right: 100px;">배송지</a>	
				<input id="addr1" size="3" value="" readonly="readonly" style="border: 0px;">
				<input id="addr2" size="60" value="" readonly="readonly" style="border: 0px;">
				<button type="button" id="Mod_Address" onclick="execPostCode();">배송지 변경</button>
				<br>
				<a style="padding-right: 170px;"></a>
				<input id="addr3" value="" placeholder="상세주소 입력" style="border: 0px;">
				
			</li>
		</ul>   
		
		<div id="goorder" class="">
	        <div class="clear"></div>
	        <div class="buttongroup center-align cmd">
	            <button id="orderSubmit">결제하기</button>
	        </div>
    	</div>

        </form>
        
        
		<script type="text/javascript">
		let basket = {
			    totalCount: 0, 
			    totalPrice: 0,
			    //체크한 장바구니 상품 비우기
			    delCheckedItem: function(){
			        document.querySelectorAll("input[name=buy]:checked").forEach(function (item) {
			            item.parentElement.parentElement.parentElement.remove();
			        });
			        //AJAX 서버 업데이트 전송
			    
			        //전송 처리 결과가 성공이면
			        this.reCalc();
			        this.updateUI();
			    },
			    
			    //재계산
			    reCalc: function(){
			        this.totalCount = 0;
			        this.totalPrice = 0;
			        document.querySelectorAll(".p_num").forEach(function (item) {
			            if(item.parentElement.parentElement.parentElement.previousElementSibling.firstElementChild.firstElementChild.checked == true){
			                var count = parseInt(item.getAttribute('value'));
			                this.totalCount += count;
			                var price = item.parentElement.parentElement.previousElementSibling.firstElementChild.getAttribute('value');
			                this.totalPrice += count * price;
			            }
			        }, this); // forEach 2번째 파라메터로 객체를 넘겨서 this 가 객체리터럴을 가리키도록 함. - thisArg
			    },
			    //화면 업데이트
			    updateUI: function () {
			        document.querySelector('#sum_p_num').textContent = '상품갯수: ' + this.totalCount.formatNumber() + '개';
			        document.querySelector('#sum_p_price').textContent = '합계금액: ' + this.totalPrice.formatNumber() + '원';
			    },
			    
			    checkItem: function () {
			        this.reCalc();
			        this.updateUI();
			    }
			 
			}

			// 숫자 3자리 콤마찍기
			Number.prototype.formatNumber = function(){
			    if(this==0) return 0;
			    let regex = /(^[+-]?\d+)(\d{3})/;
			    let nstr = (this + '');
			    while (regex.test(nstr)) nstr = nstr.replace(regex, '$1' + ',' + '$2');
			    return nstr;
			};
		</script>
		
	
		
		
</body>
</html>

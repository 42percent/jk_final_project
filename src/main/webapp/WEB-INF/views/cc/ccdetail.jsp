<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>
<c:set var="cm" target="${cmlist}"/>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" var="today" />

<head>
       <link href="css/enterbutton.css" rel="stylesheet" />
        <link href="css/modal.css" rel="stylesheet" />
</head> 
    
<div>

<form name="frmForm" id="_frmForm" method="get" action="ccupdate.do">

<input type="hidden" name="seq" value="${cc.seq}"/>

<table style="margin-left:auto; 
    margin-right:auto; width:65%;" border="1" >

<colgroup>
<col style="width:120px;" />
<col style="width:auto;" />
<col style="width:auto;" />

</colgroup>

 <tbody>	
	<tr class="nickname">
	 <tr>
    	<td colspan="3" style="text-align: center;">
    		<img src="upload/${cc.newfilename}" width="400">   	
    	</td>   
    </tr>
    <tr>
		<th>클래스선생님</th>
		<td style="text-align: left">${cc.nickname}</td>
		<td rowspan="10" id="map" style="margin:auto 0;width:500px;height:350px;">
		
		</td>
	</tr>
	<tr>
		<th>클래스명</th>
		<td style="text-align: left">${cc.title}</td>
	</tr>
 	<tr>
		<th>작성일</th>
		<td style="text-align: left">${cc.rdate.substring(5, 10)}</td>
	</tr>
	<tr>
		<th>위치</th>
		<td style="text-align: left">${cc.location}</td>
	
	</tr>
	<tr>
		<th>카테고리</th>
		<td style="text-align: left">${cc.kinds}</td>
	</tr>
	<tr>	
		<th>모집인원</th>
		<td style="text-align: left">(${cmc}/${cc.membernum})
			<button type="button" id="openmodal" >참여인원</button>
  				<div class="modal hidden">
    			<div class="modal__overlay">
    			<div class="modal__content">
    		<h2>	
      			<c:if test="${empty cmlist}"><h1>참여인원이 없습니다.</h1></c:if>
      				<c:if test="${not empty cmlist }">
      					<h4 style="text-align: left">참여한 사람</h4>
      					<hr style="border: solid 1px gray;"></hr>
      				</c:if>	
						<c:forEach var="cm" items="${cmlist}">
							<c:choose>
								<c:when test="${cm.gender eq '남자'}">
								<div style="text-align: left">
								<img src="image/004.png" alt="..." width=50 height="40" />${cm.nickname}
								</div>
								</c:when>
								<c:otherwise>
								<div style="text-align: left">
								<img src="image/003.png" alt="..." width="50" height="40"/>${cm.nickname}
								</div>
								</c:otherwise>
						</c:choose>
				</c:forEach>
			</h2>
			<br><br><br>
     	<button type="button" id="close">X</button>
    			</div>
    			</div>
 			 </div>
  		</td>
	</tr>
	<tr>
		<th>수업기간</th>
		<td style="text-align: left">${cc.cdate1.substring(5, 10)} ~ ${cc.cdate2.substring(5, 10)}</td>
	</tr>
	<tr>
		<th>수업요일</th>
		<td style="text-align: left">매주 ${cc.cday}</td>
	</tr>
	<tr>
		<th>마감날짜</th>
		<td style="text-align: left">${cc.edate.substring(5, 10)}</td>
	</tr>
	<tr>
		<th>조회수</th>
		<td style="text-align: left">${cc.readcount}</td>
	</tr>
	 <tr>
		<th>내용</th>
		<td colspan="2" style="text-align: left; height: 300px;" id="_content">${cc.content}</td>
	</tr>
	<tr>
		<td colspan="3" style="height:50px; text-align:center;">
			<c:choose>	
				<c:when test="${check eq true}" >
				<a class="btn btn-outline-danger mt-auto" id="btn_resignCM">참여취소</a>
				</c:when>
				<c:when test="${cmc eq cc.membernum || cc.edate < today}">
				<a class="btn btn-outline-dark mt-auto">참여마감</a>
				</c:when>
				<c:otherwise>
				<a class="btn btn-outline-primary mt-auto" id="btn_enterCM">참여하기</a>
				</c:otherwise>
			</c:choose>				
		</td>
	</tr> 
</tbody> 
</table>
</form>
</div>
<br><br>
<div style="text-align: center">
	<button type="button" title="글보기" onclick="location.href='cclist.do'">글목록</button>
	<c:if test="${cc.nickname eq login.nickname}"> 
		<button type="button" id="_btnUpdate" title="글수정">모임수정</button>
		<button type="button" id="_btnDel" title="삭제">모임삭제</button>
	</c:if>  
</div>			

<!-- Reply List {s}-->
<div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
	<h6 class="border-bottom pb-2 mb-0">Reply list</h6>
	<div id="replyList"></div>
</div>
	 
<!-- 페이징-->
 <!-- <div class="container">
	<nav aria-label="Page navigation">
		<ul class="pagination" id="pagination" style="justify-content:center;"></ul>
	</nav>
</div> -->

 <!-- 댓글  -->
<div class="container">
    <form name="form" id="form" role="form" method="post">
    <br><br>
        <div>
            <div>
                <span><strong>Comments</strong></span> <span id="cCnt"></span>
            </div>
            <div>
                <table class="table">                    
                    <tr>
                        <td>
                        	<input class="form-control" id="id" value=${login.nickname } hidden=""></input>
                            <textarea style="width: 1100px" rows="3" cols="30" id="content" name="content" placeholder="댓글을 입력하세요"></textarea>
                            <br>
                            <div>
                                <button type="button" id="btnReplySave" style="width: 60;">등록</button>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>      
    </form>
</div>
<!-- Reply Form {e} -->

<!-- seq만 필요하므로 -->
<form name="frmForm" id="_frmForm" action="pdsupdate.do" method="post">
	<input type="hidden" name="seq" value="${cc.seq}">
</form>

<!-- 댓글리스트 불러오기 -->
<script>
	$(document).ready(function(){
		showReplyList();
	});
</script>

<script>
function showReplyList(){
	var paramData = {"seq_class" : ${cc.seq}};
	//alert(${recipe.seq});
	
	$.ajax({
        type: 'POST',
        url: "getCMCList.do",
        data: paramData,
        dataType: 'json',
        success: function(result) {
        	
           	var htmls = "";

		if(result.length < 0){
			htmls.push("등록된 댓글이 없습니다.");

		} else {
                    $(result).each(function(){
                    var orgNickNames = '${login.nickname}';
                    	if(this.step == 0){
                     htmls += '<div class="media text-muted pt-3" id="seq' + this.seq + '">';

                     // htmls += '<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:32x32">';

                     htmls += '<title>Placeholder</title>';

                     htmls += '<rect width="100%" height="100%" fill="#007bff"></rect>';

                     //htmls += '<text x="50%" fill="#007bff" dy=".3em">32x32</text>';

                     htmls += '</svg>';

                     htmls += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">';

                     htmls += '<span class="d-block">';

                     htmls += '<strong class="text-gray-dark">' + this.nickname + '</strong>';

                     htmls += '<span style="padding-left: 7px; font-size: 9pt">';
					
                     htmls += '<a href="javascript:void(0)" onclick="fn_reReply(' + this.seq + ', \'' + this.nickname + '\', \'' + this.content + '\' )" style="padding-right:5px">답글</a>';
                     if(orgNickNames == this.nickname){	 
                     htmls += '<a href="javascript:void(0)" onclick="fn_editReply(' + this.seq + ', \'' + this.nickname + '\', \'' + this.content + '\' )" style="padding-right:5px">수정</a>';

                     htmls += '<a href="javascript:void(0)" onclick="fn_deleteReply(' + this.seq + ')" >삭제</a>';
                     }                     
                     htmls += '</span>';

                     htmls += '</span>';

                    	}else{
                            htmls += '<div class="media text-muted pt-3" id="seq' + this.seq + '">';
                           
                            // htmls += '<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:32x32">';

                            htmls += '<title>Placeholder</title>';

                            htmls += '<rect width="100%" height="100%" fill="#007bff"></rect>';

                            //htmls += '<text x="50%" fill="#007bff" dy=".3em">32x32</text>';

                            htmls += '</svg>';

                            htmls += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">';

                            htmls += '<span class="d-block">';

                            htmls += '<img src="image/arrow.png" width="30px" height="30px" alt=""><strong class="text-gray-dark">&nbsp&nbsp&nbsp&nbsp&nbsp'+ this.id + '</strong>';

                            htmls += '<span style="padding-left: 7px; font-size: 9pt">';
                            if(orgNickNames == this.nickname){
                            if(this.content == " "){
                            htmls += '<a href="javascript:void(0)" onclick="fn_reupdate(' + this.seq + ', \'' + this.nickname + '\' )" style="padding-right:5px">저장</a>';
                            }else{
                          	  htmls += '<a href="javascript:void(0)" onclick="fn_editReply(' + this.seq + ', \'' + this.nickname + '\', \'' + this.content + '\' )" style="padding-right:5px">수정</a>';
                            }
                            htmls += '<a href="javascript:void(0)" onclick="fn_deleteReply(' + this.seq + ')" >삭제</a>';
                            }
                            htmls += '</span>';

                            htmls += '</span>';
                            
                  }
                    	if(this.content == " "){
    						if(this.step == 0){
    						htmls += '<textarea style="width: 1100px" rows="3" cols="30" id="content" name="content" placeholder="댓글을 입력하세요"></textarea>'
    						}else{
    							htmls += '<textarea style="width: 1100px" rows="3" cols="30" id="content" name="content" placeholder="대댓글을 입력하세요"></textarea>'	
    						}
    					}else{
    						if(this.step == 0){
                         		htmls += this.content;
    						}else{
    							htmls += '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp'+ this.content;
    						}
    					}
                      	 htmls += '</p>';
                         htmls += '</div>';
                    });	//each end
    		}	
    		$("#replyList").html(htmls);
    		
            }	   // Ajax success end
   	});	// Ajax end
}

$(document).on('click', '#btnReplySave', function(){
	var content = $('#content').val();
	var nickname = $('#id').val();
	var paramData = JSON.stringify({"content": content, "nickname": nickname, "seq_class":'${cc.seq}'

	});
	var headers = {"Content-Type" : "application/json"
			, "X-HTTP-Method-Override" : "POST"};
	
	$.ajax({

		url: "writeCMC.do"
		, headers : headers
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){
			showReplyList();			
			$('#content').val('');
			//$('#id').val('');
			//alert("댓글등록성공");
		}
		, error: function(error){
			console.log("에러 : " + error);
			//alert("댓글등록실패");
		}
	});
});

function fn_editReply(seq, id, content){

	var htmls = "";
	htmls += '<div class="media text-muted pt-3" id="seq' + seq + '">';
	//htmls += '<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:32x32">';
	htmls += '<title>Placeholder</title>';
	htmls += '<rect width="100%" height="100%" fill="#007bff"></rect>';
	//htmls += '<text x="50%" fill="#007bff" dy=".3em">32x32</text>';
	htmls += '</svg>';
	htmls += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">';
	htmls += '<span class="d-block">';
	htmls += '<strong class="text-gray-dark">' + id + '</strong>';
	htmls += '<span style="padding-left: 7px; font-size: 9pt">';
	htmls += '<a href="javascript:void(0)" onclick="fn_updateReply(' + seq + ', \'' + id + '\')" style="padding-right:5px">저장</a>';
	htmls += '<a href="javascript:void(0)" onClick="showReplyList()">취소<a>';
	htmls += '</span>';
	htmls += '</span>';		
	htmls += '<textarea name="editContent" id="editContent" class="form-control" rows="3">';
	htmls += content;
	htmls += '</textarea>';
	htmls += '</p>';
	htmls += '</div>';
	$('#seq' + seq).replaceWith(htmls);
	$('#seq' + seq + ' #editContent').focus();

}

function fn_updateReply(seq, id){
	var replyEditContent = $('#editContent').val();
	var paramData = JSON.stringify({"content": replyEditContent, "seq": seq});

	var headers = {"Content-Type" : "application/json"
			, "X-HTTP-Method-Override" : "POST"};

	$.ajax({
		url: "updateCMC.do"
		, headers : headers
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){
                            console.log(result);
			showReplyList();
		}
		, error: function(error){
			console.log("에러 : " + error);
		}
	});
}

function fn_reupdate(seq, nickname){
	var replyEditContent = $('#content').val();
	var paramData = JSON.stringify({"content": replyEditContent
			, "seq": seq
	});

	var headers = {"Content-Type" : "application/json"
			, "X-HTTP-Method-Override" : "POST"};

	$.ajax({
		url: "updatereCMC.do"
		, headers : headers
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){
                            console.log(result);
			showReplyList();
		}
		, error: function(error){
			console.log("에러 : " + error);
		}
	});
}

function fn_deleteReply(seq){		//seq로 바꿈
	var paramData = {"seq": seq};
	
	if(confirm("삭제하시겠습니까?")) {
		$.ajax({
			url: "deleteCMC.do"
			, data : paramData
			, type : 'POST'
			, dataType : 'text'
			, success: function(result){
				showReplyList();
			}
			, error: function(error){
				console.log("에러 : " + error);             
			}
		})
	}else {
		return false;
	}
}

function fn_reReply(seq, nickname){
	var paramData = JSON.stringify({"seq": seq
									, "seq_class":seq_class
									,"nickname":'${login.nickname}'});

	var headers = {"Content-Type" : "application/json"
			, "X-HTTP-Method-Override" : "POST"};

	$.ajax({
		url: "writeReCMC.do"
		, headers : headers
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){
			showReplyList();
			$('#content').val('');
		}
		, error: function(error){
			//alert("ddddd");
			console.log("에러 : " + error);
		}
	});
} 
</script>

<script type="text/javascript">
$("#_btnUpdate").click(function() {	
//	alert('글수정하기');		
	$("#_frmForm").attr({ "target":"_self", "action":"ccupdate.do" }).submit();
}); 
$("#_btnDel").click(function() {	
	let v = confirm('정말 삭제하시겠습니까?');
	if(v == true) {
		$("#_frmForm").attr({ "target":"_self", "action":"ccdelete.do" }).submit();
	}
});
$("#btn_enterCM").click(function() {
	var title = "${cc.title}";
	//alert(title);
	var seq_class = ${cc.seq};
	//alert(seq_class.value);
	var nickname = "${login.nickname}";
	//alert(nickname);
	var nickname2 = "${cc.nickname}";
	
	if(nickname == nickname2){
		alert("강사는 참여하실 수 없습니다.")
		return;
	}
	var gender = "${login.gender}";
	//alert(gender);
	
	var allData = {"seq_class": seq_class, "nickname": nickname, "gender":gender};
	if(confirm("'"+ title + "' 클래스에서 참여하시겠습니까?")) {
		$.ajax({
			url:"enterCM.do",
			type:"GET",
			data: allData,
			success:function(data){
				alert("참여되었습니다");
				writeCal();
				location.reload(true);
				window.opener.location.reload();
			},
		    error ( error, obj ){
				alert("실패");
	        }
	    });
	} else { 
		return false; 
	}
});

$("#btn_resignCM").click(function() {
	var title = "${cc.title}";
	//alert(title);
	var seq_class = ${cc.seq};
	//alert(seq_class.value);
	var nickname = "${login.nickname}";
	//alert(nickname);
	
	var allData = {"seq_class": seq_class, "nickname": nickname};
	if(confirm("'"+ title + "' 클래스에서 참여취소하시겠습니까?")) {
		$.ajax({
			url:"resignCM.do",
			type:"GET",
			data: allData,
			success:function(data){
				alert("탈퇴되었습니다");
				deleteCal();
				location.reload(true);
				window.opener.location.reload();
			},
		    error (error, obj){
				alert("실패");
	        }
	    });
	} else { 
		return false; 
	}
});

function writeCal() {
	var title = "${cc.title}";
	var seq_class = ${cc.seq};
	var nickname = "${login.nickname}";
	var cdate1 = "${cc.cdate1}";
	var cdate2 = "${cc.cdate2}";
	var cday = "${cc.cday}";
	
	var allData = {"seq_class": seq_class, "nickname": nickname, "title": title, "cdate1": cdate1, "cdate2": cdate2, "cday": cday};
	
	$.ajax({
		url:"writeCalendar.do",
		type:"GET",
		data: allData,
		success:function(data){
			//alert("일정이 추가되었습니다");
		},
	    error (error, obj){
			//alert("일정추가 실패");
        }
    });	
}

function deleteCal() {
	var seq_class = ${cc.seq};
	var nickname = "${login.nickname}";
	
	var allData = {"seq_class": seq_class, "nickname": nickname};
	
	$.ajax({
		url:"deleteCalendar.do",
		type:"GET",
		data: allData,
		success:function(data){
			//alert("일정이 삭제되었습니다");
		},
	    error (error, obj){
			//alert("일정삭제 실패");
        }
    });	
}
</script>

<!-- 모달창 -->
<script>
const openBtn = document.getElementById('openmodal');
//onModal button

const closeBtn = document.getElementById('close');
//offModal button

const modal = document.querySelector('.modal');
//HTML에서의 모달 최상위 요소

const overlay = document.querySelector('.modal__overlay');
//모달창이 활성화되면 흐린 배경을 표현하는 요소

const openModal = () => {
modal.classList.remove('hidden');
}

const closeModal = () => {
modal.classList.add('hidden');
}
openBtn.addEventListener('click', openModal);
//onModal

closeBtn.addEventListener('click', closeModal);
//모달창 내부의 닫기 버튼

overlay.addEventListener('click', closeModal);
//모달창 영역 밖
</script>

<!-- 지도 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2ca38279a4625985f230ca7162f4fbf2&libraries=services"></script>

<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
};  

//지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

//주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

//주소로 좌표를 검색합니다
geocoder.addressSearch('${cc.location}', function(result, status) {

// 정상적으로 검색이 완료됐으면 
 if (status === kakao.maps.services.Status.OK) {

    var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

    // 결과값으로 받은 위치를 마커로 표시합니다
    var marker = new kakao.maps.Marker({
        map: map,
        position: coords
    });

 	// 인포윈도우로 장소에 대한 설명을 표시합니다
    var infowindow = new kakao.maps.InfoWindow({
        content: '<div style="width:150px;text-align:center;padding:6px 0;font-size:14px;">${cc.location}<p style="font-size:10px"></p></div>'
    });
    infowindow.open(map, marker);

    // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
    map.setCenter(coords);
} 
});    
</script>
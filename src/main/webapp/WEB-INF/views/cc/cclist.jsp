<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<c:set var="cclist" value="${cclist}"/> 
<c:set var="cm" value="${cmlist.toString()}"/>

<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" var="today" />
<html>

<script type="text/javascript">
var search = "${search}";
var choice = "${choice}";
var check = "${check}";
var category = "${category}";

$(document).ready(function () {
	if(search != ""){
		$("#_choice").val( choice );
		
		document.getElementById("_search").value = search;
	}	
	if(check == "true") {
		$('#box').prop('checked',true); 
	}
	if(category != ""){
		$("#_category").val(category);
	}
});
</script>

<script type="text/javascript" src="./jquery/jquery.twbsPagination.min.js"></script>

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>COOKCLASS</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
   	     
       <!--  <section class="py-5">
		<h3 align="center"></h3> -->
        	
        	<div class="container px-4 px-lg-5 mt-5">
        	
        	<div>
        		카테고리별<select id="_category" name="category">
        			<option value="" selected="selected">선택</option>
        			<option value="한식">한식</option>
      				<option value="일식">일식</option>
        			<option value="중식">중식</option>
        			<option value="양식">양식</option>
        			<option value="디저트&베이커리">디저트&베이커리</option>
        			<option value="기타">기타</option>
        		</select>
        		<select id="_choice" name="choice">
					<option value="" selected="selected">선택</option>
					<option value="title">제목</option>
					<option value="content">내용</option>
					<option value="nickname">작성자</option>
				</select>
				<input type="text" id="_search" name="search">
				<button type="button" id="btnSearch">Search</button>
        	</div>
        	<br>
        
            <div align="left">
			참여모집중인 클래스만 보기<input type="checkbox" name='box' id="box">
			</div>
			<br>
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-left">
               		<c:if test="${empty cclist}"><h3 style="margin-left: auto; margin-right: auto">검색결과가 없습니다.</h3></c:if>
                    <c:forEach var="cclist" items="${cclist}" varStatus="i" >
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <h5 class="fw-bolder" onclick="location.href='ccdetail.do?seq=${cclist.seq}'"><img class="card-img-top" src="upload/${cclist.newfilename}" alt="..." width="300" height="200" /></h5>
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                      <h5 class="fw-bolder">${cclist.title}</h5>
                    				<h6 align="left">강의기간: ${cclist.cdate1.substring(5, 10)}~${cclist.cdate2.substring(5, 10)}</h6>
                    				<h6 align="left">강의요일: 매주 ${cclist.cday}</h6>
                    				<h6 align="left">모집인원: (${cclist.membercount}/${cclist.membernum})</h6> 
                    				<h6 align="left">장소: ${cclist.location}</h6>
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center">
                                 	<c:choose>
                                 		<c:when test="${fn:contains(cm, cclist.title) eq true and fn:contains(cm, cclist.content)}">
                                 			<a class="btn btn-outline-danger mt-auto" id="btn_resignCM" onclick="resignCM('${cclist.title}', '${cclist.seq}');deleteCal('${cclist.seq}')">참여취소</a>
                                 		</c:when>
                                		<c:when test="${cclist.membercount eq ccllist.membernum || cclist.edate < today}">
											<a class="btn btn-outline-dark mt-auto">참여마감</a>
										</c:when>
										<c:otherwise>
											<a class="btn btn-outline-primary mt-auto" id="btn_enterCM" onclick="enterCM('${cclist.title}', '${cclist.seq}', '${cclist.nickname}');
											writeCal('${cclist.title}', '${cclist.seq}', '${cclist.cdate1}', '${cclist.cdate2}', '${cclist.cday}');">참여하기</a>
	                                	</c:otherwise>
                                	</c:choose>
                                	</div>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </section>
		        
		<!-- pagination -->
		
		<div class="container">
		    <nav aria-label="Page navigation">
		        <ul class="pagination" id="pagination" style="justify-content:center;"></ul>
		    </nav>
		</div>
			
<script type="text/javascript">
function enterCM(title, seq, nickname){ 
	var title = title;
	var nickname = nickname;
	var nickname2 = "${login.nickname}";
	var seq_class = seq;
 	var gender = "${login.gender}";
 	//var cdate1 = cdate1;
 	//var cdate2 = cdate2;
 	//var cday = cday;
	
	if(nickname2 == nickname){
		alert("강사는 참여하실 수 없습니다.")
		return;
	}

	var allData = {"seq_class": seq_class, "nickname": nickname2, "gender":gender};
	
	if(confirm("'"+ title + "' 클래스에서 참여하시겠습니까?")) {
		$.ajax({
			url:"enterCM.do",
			type:"GET",
			data: allData,
			success:function(data){
				alert("참여되었습니다");
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
}
function resignCM(title, seq){ 
	var title = title;
	var seq_class = seq;
	var nickname = "${login.nickname}";
	
	var allData = {"seq_class": seq_class, "nickname": nickname};
	if(confirm("'"+ title + "' 클래스에서 참여취소하시겠습니까?")) {
		$.ajax({
			url:"resignCM.do",
			type:"GET",
			data: allData,
			success:function(data){
				alert("탈퇴되었습니다");
				deleteCal(seq);
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
}

function writeCal(title, seq, cdate1, cdate2, cday) {
	var title = title;
	var seq_class = seq;
	var nickname = "${login.nickname}";
	var cdate1 = cdate1;
	var cdate2 = cdate2,
	var cday = cday;
	alert("cdate1");
	
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

function deleteCal(seq) {
	var seq_class = seq;
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

<script>
let totalCount = ${totalCount};	// 서버로부터 총글의 수를 취득
//alert(count);
let nowPage = ${pageNumber};	// 서버로부터 현재 페이지를 취득
//alert(pageNum);

let pageSize = 10;

let _totalPages = totalCount / pageSize;
if(totalCount % pageSize > 0){
	_totalPages++;
}

//$("#pagination").twbsPagination('destroy');	// 페이지 갱신 : 페이징을 갱신해 줘야 번호가 재설정된다.

$("#pagination").twbsPagination({
	startPage: nowPage,
	totalPages: _totalPages,
	visiblePages: 10,
	first:'<span sria-hidden="true">«</span>',
	prev:"이전",
	next:"다음",
	last:'<span sria-hidden="true">»</span>',
	initiateStartPageClick:false,		// onPageClick 자동 실행되지 않도록 한다
	onPageClick:function(event, page){
		if($("#_category").val() != '') {
		 	if($("#box").is(":checked")){
			    location.href = "cclist.do?check=true&search=" + $("#_search").val() + "&choice=" + $("#_choice").val() + "&category=" + $("#_category").val() + "&pageNumber=" + (page - 1);	
			}else{
				location.href = "cclist.do?check=false&search=" + $("#_search").val() + "&choice=" + $("#_choice").val() + "&category=" + $("#_category").val() + "&pageNumber=" + (page - 1);	
			}
		}else {
			if($("#box").is(":checked")){
			    location.href = "cclist.do?check=true&search=" + $("#_search").val() + "&choice=" + $("#_choice").val() + "&pageNumber=" + (page - 1);		
			}else{
				location.href = "cclist.do?check=false&search=" + $("#_search").val() + "&choice=" + $("#_choice").val() + "&pageNumber=" + (page - 1);	
			}
		} 
	}
});	

$("#box").change(function(){
	if($("#_category").val() != '') {
		if($("#box").is(":checked")){
		    location.href = "cclist.do?check=true&category=" +$("#_category").val();
		}else{
		    location.href = "cclist.do?check=false&category=" +$("#_category").val();
		}
	}else{
		if($("#box").is(":checked")){
		    location.href = "cclist.do?check=true"
		}else{
		    location.href = "cclist.do?check=false"
		}
	}
});

$("#_category").change(function() {
	/* location.href = "cclist.do?category=" +$("#_category").val(); */
	if($("#box").is(":checked")){
	    location.href = "cclist.do?check=true&category=" +$("#_category").val();
	}else{
	    location.href = "cclist.do?check=false&category=" +$("#_category").val();
	}
});

$("#btnSearch").click(function () {
	if($("#_category").val() != '') {
	 	if($("#box").is(":checked")){
		    location.href = "cclist.do?check=true&search=" + $("#_search").val() + "&choice=" + $("#_choice").val() + "&category=" + $("#_category").val();	
		}else{
			location.href = "cclist.do?check=false&search=" + $("#_search").val() + "&choice=" + $("#_choice").val() + "&category=" + $("#_category").val();
		}
	}else {
		if($("#box").is(":checked")){
		    location.href = "cclist.do?check=true&search=" + $("#_search").val() + "&choice=" + $("#_choice").val();	
		}else{
			location.href = "cclist.do?check=false&search=" + $("#_search").val() + "&choice=" + $("#_choice").val();
		}
	}
	
});
</script>

        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </body>
</html>

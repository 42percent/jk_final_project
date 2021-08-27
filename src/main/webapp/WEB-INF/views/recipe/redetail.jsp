<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="comtotalCount" value="${comtotalCount}"/>
<fmt:requestEncoding value="utf-8"/>

 <style type="text/css">
    	
    	/* .heart{
    	width: 50px;
		height: 50px;
    	} */
    	
		.card-img-top {
		width: 700px;
		height: 400px;
		object-fit: fill;

		
		}
 
 		tr.mar{
 		border-bottom: 20px solid #fff;
 		}
 		
 		tr#mar{
 		border-top: 40px solid #fff;
 		}
 		
/* 		table {
    	margin-left:auto; 
	    margin-right:auto;
		}

		table, td, th {
		    border-collapse : collapse;
		    border : 1px solid black;
		}; */

 </style>
<table class="list_table" style="width: 100%;" id="msgListTable" >
<colgroup>
	<col width="200">
</colgroup>
	<tr class="mar" id="mar">
		<td class="img_wrap" style="text-align: center;">
			<img id="img">
			<img class="card-img-top" src="upload/${recipe.newbestimg}" />
		</td>
	</tr>
</table>



<table class="list_table" style="width: 100%;" id="msgListTable" >
	<colgroup>
		<col width="300">
	</colgroup>
	
	<tr hidden="">
		<th>아이디</th>
		<td style="text-align: center;">${recipe.id }</td>
	</tr>
	<tr class="mar">
		<td style="text-align: center;"><h1>${recipe.recipetitle }</h1></td>	
	</tr>
	<tr class="mar">
		<td style="text-align: center; color: gray;">
			${recipe.recintroduce }
		</td>
	</tr>
	<tr hidden="">	
			<td style="text-align: center;">${recipe.reccategory }<br><br></td>
		</tr>
	<tr>
			<td style="text-align: center;">👨‍🍳 ${recipe.recperson}&nbsp&nbsp&nbsp&nbsp&nbsp⏰ ${recipe.rectime }&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp🍳 ${recipe.reclevel }
	</tr>
</table><br><br>

<table class="list_table" style="margin-left:auto; margin-right:auto; width:85%;" >
	<colgroup>
		<col width="400">
	</colgroup>
	<tr>
		<td style="text-align: center;">
		<h3 style="margin-right: 400;">재료</h3>
		<textarea rows="10" cols="70" name="ingredient" readonly="readonly">${recipe.ingredient }</textarea>
		</td>
	</tr>
</table>
<br><br><br>

<table class="list_table" style="width: 100%;">
	<colgroup>
		<col width="550">
	</colgroup>

	<tr  class="mar">
		<td style="text-align: center">
		<h3>요리순서</h3><br>
			${recipe.reccontent}
		</td>
	</tr>
	

</table>



<table class="list_table" style="width: 100%;">
	<tr>
		<td style="height:50px; text-align: center">
		<span>
			<c:if test="${recipe.id eq login.id}">
			<button type="button" class="btn btn-primary btn-sm" id="_btnrec" title="레시피 목록">레시피 목록</button>
			<button type="button" class="btn btn-primary btn-sm" id="_btnUpdate" title="글수정">수정하기</button>
			<button type="button" class="btn btn-primary btn-sm" id="_btnDel" title="삭제">삭제하기</button>
			</c:if>
		</span>
		</td>
	</tr>
	<tr>
	<td align="center">
				<!-- 좋아요 -->
	<c:choose>
		<c:when test="${likecheck eq 'true' }">
			<button type="button" class="heartx" id="heartx" style="width: 10;">❤+${likecount}</button>
		</c:when>
		<c:when test="${likecheck eq 'false' }">
			<button type="button" class="heart" id="heart" style="width:10;">🤍+${likecount}</button>
		</c:when>
	</c:choose>	
	</td>
	</tr>
</tbody>
</table>
		
			
		<!-- Reply List {s}-->
	<div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
	<h6 class="border-bottom pb-2 mb-0" style="margin-left: 250px; margin-right: 250px;">Reply list</h6>
	<div id="replyList" style="margin-left: 250px; margin-right: 250px;"></div>
	</div>
	 
	 		<!-- 페이징-->
 	<div class="container">
		   <nav aria-label="Page navigation">
		       <ul class="pagination" id="pagination" style="justify-content:center;"></ul>
		   </nav>
	</div>

 
 <!-- 댓글  -->
	<div class="container" >
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
                        	<input class="form-control" id="id" value=${login.id } hidden=""></input>
                            <textarea style="width: 1100px" rows="3" cols="30" id="content" name="content" placeholder="댓글을 입력하세요"></textarea>
                            <br>
                            <div>
                                <button type="button" class="btn btn-sm btn-primary" id="btnReplySave" style="width: 60;"> 등록 </button>
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
	<input type="hidden" name="seq" value="${recipe.seq }">
</form>




<script>

	$(document).ready(function(){

		showReplyList();

	});

</script>

<script type="text/javascript">
$(document).on('click', '#heartx', function(){

	var seq_recipe = "${recipe.seq}";
	//alert(seq_recipe);
	var id = "${login.id}";
	//alert(id);
	
	
	var allData = {"id":id, "seq_recipe":seq_recipe};
	
	$.ajax({
		url:"heartx.do",
		type:"GET",
		data:allData,
		success:function(data){
			alert("안좋아요");
			location.reload(true);
            window.opener.location.reload();
		},
	 	error(error, obj){
			alert("실패");
		}	 
	});	
});

$(document).on('click', '#heart', function(){

	var seq_recipe = "${recipe.seq}";
	//alert(seq_recipe);
	var id = "${login.id}";
	//alert(id);
	
	
	var allData = {"id":id, "seq_recipe":seq_recipe};
	
	$.ajax({
		url:"heart.do",
		type:"GET",
		data:allData,
		success:function(data){
			alert("좋아요");
			location.reload(true);
            window.opener.location.reload();
		},
	 	error(error, obj){
			alert("실패");
		}	 
	});	
});
</script>

<script>

/*  function paging(){
	var pagingData = {"bbsid" : ${recipe.seq}};
	
	$.ajax({
		type: 'POST',
		url: 'commentpaging.do',
		data: pagingData,
		dataType: 'json',
		success: function(result){
		 	var totalCount = this.totalCount;
			//alert(totalCount);
			var nowPage = this.nowPage;		// 서버로부터 현재 페이지를 취득
			var pageSize = 10;

			var totalPages = totalCount / pageSize;
			if(totalCount % pageSize > 0){
				totalPages++;
			} 
		}
		, error: function(error){
			alert("에러");
		}
	})
}
 */
function showReplyList(){
	var paramData = {"bbsid" : ${recipe.seq}};
	//alert(${recipe.seq});
	
	$.ajax({
        type: 'POST',
        url: "getReqlyList.do",
        data: paramData,
        dataType: 'json',
        success: function(result) {
        	//paging();
           	var htmls = "";

		if(result.length < 1){

			htmls.push("등록된 댓글이 없습니다.");

		} else {
              $(result).each(function(){
            	  var orgNickNames = '${login.id}';
                    	if(this.step == 0){
                     htmls += '<div class="media text-muted pt-3" id="seq' + this.seq + '">';

                     // htmls += '<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:32x32">';

                     htmls += '<title>Placeholder</title>';

                     htmls += '<rect width="100%" height="100%" fill="#007bff"></rect>';

                     //htmls += '<text x="50%" fill="#007bff" dy=".3em">32x32</text>';

                     htmls += '</svg>';

                     htmls += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">';

                     htmls += '<span class="d-block">';

                     htmls += '<strong class="text-gray-dark">' + this.id + '</strong>';

                     htmls += '<span style="padding-left: 7px; font-size: 9pt">';
					 
                     htmls += '<a href="javascript:void(0)" onclick="fn_reReply(' + this.seq + ', \'' + this.bbsid + '\' )" style="padding-right:5px">답글</a>';
                     if(orgNickNames == this.id){
                     htmls += '<a href="javascript:void(0)" onclick="fn_editReply(' + this.seq + ', \'' + this.id + '\', \'' + this.content + '\' )" style="padding-right:5px">수정</a>';

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
                              if(orgNickNames == this.id){
                              if(this.content == " "){
                              htmls += '<a href="javascript:void(0)" onclick="fn_reupdate(' + this.seq + ', \'' + this.id + '\' )" style="padding-right:5px">저장</a>';
                              }else{
                            	  htmls += '<a href="javascript:void(0)" onclick="fn_editReply(' + this.seq + ', \'' + this.id + '\', \'' + this.content + '\' )" style="padding-right:5px">수정</a>';
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
	var id = $('#id').val();
	var paramData = JSON.stringify({"content": content
			, "id": id
			, "bbsid":'${recipe.seq}'

	});
	var headers = {"Content-Type" : "application/json"
			, "X-HTTP-Method-Override" : "POST"};
	
	$.ajax({

		url: "saveReqly.do"
		, headers : headers
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){
			showReplyList();			
			$('#content').val('');
			//$('#id').val('');
		}
		, error: function(error){
			console.log("에러 : " + error);
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
	var paramData = JSON.stringify({"content": replyEditContent
			, "seq": seq
	});

	var headers = {"Content-Type" : "application/json"
			, "X-HTTP-Method-Override" : "POST"};

	$.ajax({
		url: "updateReply.do"
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

 function fn_reupdate(seq, id){
	var replyEditContent = $('#content').val();
	var paramData = JSON.stringify({"content": replyEditContent
			, "seq": seq
	});

	var headers = {"Content-Type" : "application/json"
			, "X-HTTP-Method-Override" : "POST"};

	$.ajax({
		url: "updatere.do"
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
	
	$.ajax({
		url: "deleteReply.do"
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
}


function fn_reReply(seq, bbsid){
	var paramData = JSON.stringify({"seq": seq
									, "bbsid":bbsid
									,"id":'${login.id}'});

	var headers = {"Content-Type" : "application/json"
			, "X-HTTP-Method-Override" : "POST"};

	$.ajax({
		url: "rereply.do"
		, headers : headers
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){
			showReplyList();
			$('#content').val('');
		}
		, error: function(error){
			alert("ddddd");
			console.log("에러 : " + error);
		}
	});
} 




</script>
 
<script>
function _refrush() {
	location.reload();
	clearTimeout(myVar);
}



$("#_btnUpdate").click(function() {	
//	alert('글수정하기');		
	$("#_frmForm").attr({ "target":"_self", "action":"reupdate.do" }).submit();
});

$("#_btnDel").click(function() {	
	 let v = confirm('정말 삭제하시겠습니까?');
	   if(v == true) {
			$("#_frmForm").attr({ "target":"_self", "action":"recipedelete.do" }).submit();
	   }
});

$("#_btnrec").click(function(){
	$("#_frmForm").attr({ "target":"_self", "action":"recipe.do" }).submit();
});
</script> 


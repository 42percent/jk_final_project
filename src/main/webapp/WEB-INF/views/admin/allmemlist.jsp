<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<table class="list_table" style="width: 85%" id="_list_table" border="1">
<col width="50"><col width="100"><col width="100"><col width="100">
<col width="100"><col width="100"><col width="130"><col width="200">
<col width="90"><col width="120">
	<tr>
		<td colspan="10" style="text-align: left;">
			<h2 style="margin-left: 20px;">모든회원정보</h2>
		</td>
	</tr>
	<tr>
		<th>번호</th><th>아이디</th><th>이름</th><th>닉네임</th><th>생년월일</th><th>성별</th><th>이메일</th><th>주소</th><th>회원상태</th><th>가입일자</th>
	</tr>
<c:forEach items="${allmemlist}" var="all" varStatus="i">
	<tr>
		<td>${all.seq}</td>
		<td>${all.id}</td>
		<td>${all.name}</td>
		<td>${all.nickname}</td>
		<td>${all.birth}</td>
		<td>${all.gender}</td>
		<td>${all.email}</td>
		<td>${all.address1}</td>
		<td>${all.auth}</td>
		<td>${all.joindate.substring(0,11)}</td>
	</tr>
</c:forEach>
</table>

	<a href="<c:url value='/excelDown.do'/>">엑셀</a>
	

<br><br>
<!-- 검색 -->
<div class="box_border" style="margin-top: 5px;margin-bottom: 10px">
	<table style="margin-left: auto;margin-right: auto; margin-top: 3px; margin-bottom: 3px">
		<tr>
			<td>검색</td>
			<td style="padding-left: 5px">
				<select id="_choice" name="choice">
					<option value="" selected="selected">선택</option>
					<option value="name">이름</option>
					<option value="nickname">닉네임</option>
					<option value="id">아이디</option>
				</select>	
			</td>
			<td style="padding-left: 5px">
				<input type="text" id="_search" name="search">
			</td>
			<td style="padding-left: 5px">
				<span class="button blue">
					<button type="button" id="btnSearch">검색</button>
				</span>
			</td>
		</tr>
	</table>
</div>
<br><br>

<!-- pagination -->
<div class="container">
    <nav aria-label="Page navigation">
        <ul class="pagination" id="pagination" style="justify-content:center;"></ul>
    </nav>
</div>

<br><br>

<script type="text/javascript">
var search = "${search}";
var choice = "${choice}";

$(document).ready(function () {
	if(search != ""){
		$("#_choice").val( choice );
		
		document.getElementById("_search").value = search;
	}	
});
</script>

<script>
let totalCount = ${totalCount};	// 서버로부터 총글의 수를 취득
// alert(count);
let nowPage = ${pageNumber};	// 서버로부터 현재 페이지를 취득
// alert(pageNum);

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
		location.href = "allmemlist.do?search=" + $("#_search").val() + "&choice=" + $("#_choice").val() + "&pageNumber=" + (page - 1);	
	}
});	


$("#btnSearch").click(function () {
	location.href = "allmemlist.do?search=" + $("#_search").val() + "&choice=" + $("#_choice").val();	
});

</script>


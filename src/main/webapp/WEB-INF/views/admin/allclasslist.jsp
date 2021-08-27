<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>




<table class="list_table" style="width: 85%" id="_list_table" border="1">
<col width="50"><col width="100"><col width="100"><col width="100">
<col width="100"><col width="100"><col width="100">
	<tr>
		<td colspan="10" style="text-align: left;">
			<h2 style="margin-left: 20px;">모든클래스정보</h2>
		</td>
	</tr>
	<tr>
		<th>번호</th><th>카테고리</th><th>내용</th><th>진행자</th><th>지역</th><th>조히수</th><th>참여현황</th>
	</tr>
<c:forEach items="${allclasslist}" var="cl" varStatus="i">
	<tr>
		<td>${cl.seq}</td>
		<td>${cl.kinds}</td>
		<td>${cl.title}</td>
		<td>${cl.nickname}</td>
		<td>${cl.location}</td>
		<td>${cl.readcount}</td>
		<td>0/10</td>
	</tr>
</c:forEach>
</table>

<br><br>
<!-- 검색 -->
<div class="box_border" style="margin-top: 5px;margin-bottom: 10px">
	<table style="margin-left: auto;margin-right: auto; margin-top: 3px; margin-bottom: 3px">
		<tr>
			<td>검색</td>
			<td style="padding-left: 5px">
				<select id="_choice" name="choice">
					<option value="" selected="selected">선택</option>
					<option value="title">제목</option>
					<option value="kinsd">카테고리</option>
					<option value="nickname">닉네임</option>
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
		location.href = "allclasslist.do?search=" + $("#_search").val() + "&choice=" + $("#_choice").val() + "&pageNumber=" + (page - 1);	
	}
});	


$("#btnSearch").click(function () {
	location.href = "allclasslist.do?search=" + $("#_search").val() + "&choice=" + $("#_choice").val();	
});

</script>
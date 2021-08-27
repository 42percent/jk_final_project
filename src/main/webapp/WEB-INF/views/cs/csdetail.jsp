<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>

<form name="frmForm" id="_frmForm" method="get" action="csupdate.do">

<input type="hidden" name="seq" value="${cs.seq}"/>

<table class="list_table" style="width:85%;">

<colgroup>
<col style="width:200px;" />
<col style="width:auto;" />
</colgroup>

<tbody>	
	<tr class="id">
		<th>아이디</th>
		<td style="text-align: left">${cs.id}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td style="text-align: left">${cs.title}</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td style="text-align: left">${cs.rdate.substring(0,11)}</td>
	</tr>
	<tr>
		<th>조회수</th>
		<td style="text-align: left">${cs.readcount}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td style="text-align: left"><textarea rows="20px" cols="80px" 
		name='content' id="_content">${cs.content}</textarea></td>
	</tr>
	<tr>
		<td colspan="2" style="height:50px; text-align:center;">
		<span>
			<c:if test="${cs.id eq login.id}">
			<button type="button" class="btn btn-primary btn-sm" id="_btnUpdate" title="글수정">글수정하기</button>
			<button type="button" class="btn btn-primary btn-sm" id="_btnDel" title="삭제">삭제하기</button>
			</c:if>
			<button type="button" class="btn btn-primary btn-sm" id="_btnReply" title="답글달기">답글달기</button>
		</span>
		</td>
	</tr>
</tbody>
</table>

</form>


<script type="text/javascript">

$("#_btnUpdate").click(function() {	
//	alert('글수정하기');		
	$("#_frmForm").attr({ "target":"_self", "action":"csupdate.do" }).submit();
});
$("#_btnReply").click(function() {	
//	alert('답글달기');	
	$("#_frmForm").attr({ "target":"_self", "action":"answer.do" }).submit();
});
$("#_btnDel").click(function() {			
	$("#_frmForm").attr({ "target":"_self", "action":"csdelete.do" }).submit();
});

</script>


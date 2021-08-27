<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>

<form name="frmForm" id="_frmForm" method="post" action="csupdateAf.do">
<input type="hidden" name="seq" value="${cs.seq}" />
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
	<td style="text-align: left">
		<input size="60" type="text" name="title" value='${cs.title}' >
	</td>
</tr>
<tr>
	<th>작성일</th>
	<td style="text-align: left">${cs.rdate}</td>
</tr>
<tr>
	<th>내용</th>
	<td style="text-align: left"><textarea rows="20px" cols="80px"
	name='content' id="_content">${cs.content}</textarea></td>
</tr>
<tr>
	<td colspan="2" style="height:50px; text-align:center;">
		<span>
			<button type="button" class="btn btn-primary btn-sm" id="_btnUpdate" title="수정하기">수정하기</button>
		</span>
	</td>
</tr>

</tbody>
</table>

</form>

<script type="text/javascript">
$("#_btnUpdate").click(function() {	
//	alert('글수정하기');	
	$("#_frmForm").attr({ "target":"_self", "action":"csupdateAf.do" }).submit();
});
</script>

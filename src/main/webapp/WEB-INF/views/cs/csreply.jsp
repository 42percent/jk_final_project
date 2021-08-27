<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form name="frmForm" id="_frmForm" method="post" action="csreplyAf.do">
<input type="hidden" name="seq"   value="${bbs.seq}"/>

<table class="list_table" style="width:85%;">
<colgroup>
<col style="width:200px;" />
<col style="width:auto;" />
</colgroup>

<tbody>	

<tr class="id">
	<th>아이디</th>
	<td style="text-align: left"><input type="text" name="id" readonly="readonly" 
	value='${login.id}' size="60"/></td>
</tr>
<tr>
	<th>제목</th>
	<td style="text-align: left"><input type="text" name="title" size="60"/></td>
</tr>
<tr>
	<th>내용</th>
	<td style="text-align: left">
		<textarea rows="20px" cols="80px" name='content' id="_content"></textarea>
	</td>
</tr>
<tr>
<td colspan="2" style="height:50px; text-align:center;">
	<span>
	<button type="button" class="btn btn-primary btn-sm" id="_btnReply" title="답글달기">답글달기</button>
	</span>
</td>
</tr>

</tbody>

</table>
</form>

<script type="text/javascript">
$("#_btnReply").click(function() {	
	alert('답글달기');	
	$("#_frmForm").attr({ "target":"_self", "action":"answerAf.do" }).submit();
});
</script>
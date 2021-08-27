<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>
 

<div class="write" align="center">
<form name="frmForm" id="_frmForm" method="post" action="cswriteAf.do">
<table class="writetable">
<col width="100"><col width="400" style="align: left; ">
<tr>
	<td colspan="2"><h1 style="margin-left: 20px">글쓰기</h1></td>
</tr>
<tr>
	<th>작성자</th>
	<td>
		<input type="text" name="id" readonly="readonly" value='${login.id}' size="60"/>
	</td>
</tr>
<tr>
	<th>제목</th>
	<td>
		<input type="text" name="title" id="title" size="50" />
		<c:if test="${login.auth == 1}">
		
			<input type="checkbox" name="type" id="type" value="1"/>
			<label for="type"><b>공지글 설정</b></label>
		</c:if>
	</td>
</tr>
<tr>
	<th>내용</th>
	<td><textarea rows="30" cols="80" name="content" id="content"></textarea></td>
</tr>
<tr>
	<td colspan="2" style="text-align: right;">
		<button type="button" class="btn btn-primary btn-sm" id="_list" >목록으로</button>
		<button type="button" class="btn btn-primary btn-sm" id="_btnWrite" title="글쓰기">글쓰기</button>
	</td>
</tr>

</table>

</form>
</div>

<script type="text/javascript">
$("#_btnWrite").click(function() {	
	alert('글작성');	
	$("#_frmForm").attr({ "target":"_self", "action":"cswriteAf.do" }).submit();	
});
</script>


<script type="text/javascript">
	// 글쓰기 form 유효성 검사
	function writeform_check(){
		var title = document.getElementById("title");
		var content = document.getElementById("content");
		
		if(title.value.trim() == ""){
			alert("제목을 입력하세요");
			title.focus();
			return false;
		}
		
		if(content.value.trim() == ""){
			alert("내용을 입력하세요");
			content.focus();
			return false;
		}
		$("#write_form").attr({ "target":"_self", "action":"cswriteAf.do" }).submit();
	};
</script> 


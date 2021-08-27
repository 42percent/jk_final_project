<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
  <!-- 서머노트를 위해 추가해야할 부분 -->
  <script src="${pageContext.request.contextPath}/resources/summernote/summernote-lite.js"></script>
  <script src="${pageContext.request.contextPath}/resources/summernote/lang/summernote-ko-KR.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/summernote/summernote-lite.css">
  <!--  -->
 <style type="text/css">
		
		.img_wrap {
            width: 300px;
            margin-top: 50px;
        }
        .img_wrap img {
            width: 300px;
            height:200px;
        }
 		
 		tr.mar{
 		border-bottom: 20px solid #fff;
 		}

 </style>
<script type="text/javascript">
    
    var sel_file;
   
  $(document).ready(function() {
    	$("#input_img").on("change", handleImgFileSelect);
    
    function handleImgFileSelect(e) {
        var files = e.target.files;
        var filesArr = Array.prototype.slice.call(files);

        filesArr.forEach(function(f) {
            if(!f.type.match("image.*")) {
                alert("확장자는 이미지 확장자만 가능합니다.");
                return;
            }

            sel_file = f;            
            var reader = new FileReader();
            reader.onload = function(e) {
                $("#img").attr("src", e.target.result);
            }
            reader.readAsDataURL(f);
            
        }); 
    }
  });
</script>

<form name="frmForm" id="_frmForm" action="recipeupdateAf.do" method="post" enctype="multipart/form-data">
<input type="hidden" name="seq" value="${recipe.seq}">

<table class="list_table" style="margin-left:auto; margin-right:auto; width:68%;">
<colgroup>
	<col width="100"><col width="300"><col width="200">
</colgroup>

<tr>
	<td hidden="">${recipe.id}</td>
</tr>

<tr>
	<th>제목</th>
	<td>
		<%-- <input type="text" name="recipetitle" size="48" value="${recipe.recipetitle}"> --%>
		<textarea rows="1" cols="80" name="recipetitle">${recipe.recintroduce }</textarea>
	</td>
	<td rowspan="3" class="img_wrap">
		<!-- 기존의 파일 -->
		<input type="hidden" name="newnamefile" value="${recipe.newbestimg}">
		<input type="hidden" name="namefile" value="${recipe.bestimg}" size="50" readonly="readonly">
		<!-- <img id="img"> -->
		<img class="img"  id="img" src="upload/${recipe.newbestimg}" />
		<!-- 수정할 파일 -->
		<input type="file" name="fileload" id="input_img" style="width: 300px">		
	</td>
<tr>
	<tr>
		<th>요리소개</th>
		<td>
			<textarea rows="7" cols="80" name="recintroduce">${recipe.recintroduce }</textarea>
		</td>
	</tr>
	<tr class="mar">
	<th>카테고리</th>
	<td>
		<select id="reccategory" name="reccategory">
			<option value="한식">한식</option>
			<option value="양식">양식</option>
			<option value="일식">일식</option>	
			<option value="중식">중식</option>
			<option value="디저트&베이커리">디저트/베이커리</option>
		</select>
	</td>
</tr>

<tr class="mar">
	<th>요리정보</th>
	<td>몇인분
		<select id="recperson" name="recperson">
			<option value="1인분">1인분</option>
			<option value="2인분">2인분</option>
			<option value="3인분">3인분</option>	
			<option value="4인분">4인분</option>
			<option value="대량">대량</option>
		</select>
		요리시간
		<select id="rectime" name="rectime">
			<option value="10분미만">10분미만</option>
			<option value="30분">30분</option>
			<option value="한시간">한시간</option>	
			<option value="한시간반">한시간반</option>
			<option value="두시간이상">두시간이상</option>
		</select>
		난이도
		<select id="reclevel" name="reclevel">
			<option value="왕초보">왕초보</option>
			<option value="쉬움">쉬움</option>
			<option value="중간">중간</option>	
			<option value="어려움">어려움</option>
			<option value="헬">헬</option>
		</select>
	</td>
</tr>
<tr class="mar">
		<th>요리재료</th>
		<td colspan="2">
		<textarea rows="10" cols="80" name="ingredient">${recipe.ingredient }</textarea>
		</td>
	</tr>

	<tr>

		<td colspan="3" align="center">
		<textarea class="summernote" name="reccontent" id="summernote">${recipe.reccontent}</textarea>
		</td>

	</tr>
	<tr>
	<td colspan="3" align="center">
		<button type="button" id="btnupdate" name="btnupdate" onclick="update()">수정완료</button>
	</td>
	</tr>
</table>
			
	
</form>

<script>
$("#reccategory").val("${recipe.reccategory}").attr("selected", "selected");
$("#recperson").val("${recipe.recperson}").attr("selected", "selected");
$("#rectime").val("${recipe.rectime}").attr("selected", "selected");
$("#reclevel").val("${recipe.reclevel}").attr("selected", "selected");
</script>

<script>

$(document).ready(function() {
    $('#summernote').summernote({
       placeholder: '레시피를 작성해주세요',
      tabsize: 2,
      width: 800,
     height: 1000,
       fontNames : [ '맑은고딕', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', ],
       fontNamesIgnoreCheck : [ '맑은고딕' ],
       focus : true,
    callbacks: {
       onImageUpload: function(files, editor, welEditable) {
             for (var i = files.length - 1; i >= 0; i--) {
                sendFile(files[i], this);
             }
         }
    }
    
 });

});

function sendFile(file, el) {
 var form_data = new FormData();
   form_data.append('file', file);
   $.ajax({
     data: form_data,
     type: "POST",
     url: 'contentImageSend.do',
     cache: false,
     contentType: false,
     enctype: 'multipart/form-data',
     processData: false,
     success: function(img_name) {
          $(el).summernote('editor.insertImage', img_name);
     }
   });
}
function update() {
	
	
	$("#_frmForm").submit();
}

/* $("#btnupdate").click(function(){
	
	
	
	$("#_frmForm").submit();
}); */

</script>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>SummerNoteExample</title>
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
<script type="text/javascript">
   
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
        $("#input_img").on("change", handleImgFileSelectb);
        reader.readAsDataURL(f);
        
    }); 
}

function handleImgFileSelecta(e) {
    var files = e.target.files;
    var filesArr = Array.prototype.slice.call(files);
    //alert("aaa 추가한 파일 명 " + fileArr);
    filesArr.forEach(function(f) {
        if(!f.type.match("image.*")) {
            alert("확장자는 이미지 확장자만 가능합니다.");
            return;
        }

        sel_file = f;

        var reader = new FileReader();
        reader.onload = function(e) {
            $("#img_a").attr("src", e.target.result);
            $("#input_img_b").on("change", handleImgFileSelectb);
        }
        reader.readAsDataURL(f);
    });     
}

 function handleImgFileSelectb(e) {
    var files = e.target.files;
    var filesArr = Array.prototype.slice.call(files);
    //alert("bbbb 추가한 파일 명 " + fileArr);
    filesArr.forEach(function(f) {
        if(!f.type.match("image.*")) {
            alert("확장자는 이미지 확장자만 가능합니다.");
            return;
        }

        sel_file = f;

        var reader = new FileReader();
        reader.onload = function(e) {
            $("#img_b").attr("src", e.target.result);
            $("#input_img_c").on("change", handleImgFileSelectc);
            $("#input_img_d").on("change", handleImgFileSelectd);
            $("#input_img_e").on("change", handleImgFileSelecte);
            $("#input_img_f").on("change", handleImgFileSelectf);
        }
        reader.readAsDataURL(f);
    }); 
} 
 function handleImgFileSelectc(e) {
     var files = e.target.files;
     var filesArr = Array.prototype.slice.call(files);
     //alert("bbbb 추가한 파일 명 " + fileArr);
     filesArr.forEach(function(f) {
         if(!f.type.match("image.*")) {
             alert("확장자는 이미지 확장자만 가능합니다.");
             return;
         }

         sel_file = f;

         var reader = new FileReader();
         reader.onload = function(e) {
             $("#img_c").attr("src", e.target.result);
             $("#input_img_c").on("change", handleImgFileSelectc);
             $("#input_img_d").on("change", handleImgFileSelectd);
             $("#input_img_e").on("change", handleImgFileSelecte);
             $("#input_img_f").on("change", handleImgFileSelectf);
         }
         reader.readAsDataURL(f);
     }); 
 } 
 
 function handleImgFileSelectd(e) {
     var files = e.target.files;
     var filesArr = Array.prototype.slice.call(files);
     //alert("bbbb 추가한 파일 명 " + fileArr);
     filesArr.forEach(function(f) {
         if(!f.type.match("image.*")) {
             alert("확장자는 이미지 확장자만 가능합니다.");
             return;
         }

         sel_file = f;

         var reader = new FileReader();
         reader.onload = function(e) {
             $("#img_d").attr("src", e.target.result);
         }
         reader.readAsDataURL(f);
     }); 
 } 
 function handleImgFileSelecte(e) {
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
             $("#img_e").attr("src", e.target.result);
         }
         reader.readAsDataURL(f);
     }); 
 } 
 function handleImgFileSelectf(e) {
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
             $("#img_f").attr("src", e.target.result);
         }
         reader.readAsDataURL(f);
     }); 
 } 

});   



</script>

<style type="text/css">
  .img_wrap {
            width: 300px;
            margin-top: 50px;
     	}
        .img_wrap img {
            width: 300px;
            height:200px;
        }
  
</style>

</head>
<body>


<form name="frmForm" id="_frmForm" method="post" action="upload.do"  enctype="multipart/form-data">

<table class="list_table" style="width:85%; margin-left: 500px">
<colgroup>
<col style="width:200px;" />
<col style="width:auto;" />
</colgroup>

<tbody>	
	<tr class="id">
		<th></th>
		<td style="text-align: left">
			<input type="text" name="id" readonly="readonly" value='${login.id}' size="60" hidden=""/>
		</td>
	</tr>
<tr>
<th>제목</th>
	<td style="text-align: left">
				<input type="text" name="recipetitle" size="48"/>
			</td>
			<td rowspan="2" class="img_wrap" style="margin-left: 5px">
		<img id="img">
		<input type="file" name="fileload" id="input_img" style="width: 950px">
	</td>
	</tr>
	<tr>
	<th>요리소개</th>
	<td style="text-align: left">
		<textarea rows="6" cols="50" name="recintroduce"></textarea>
	</td>
</tr>
<tr class="space">
	<th>카테고리</th>
	<td style="text-align: left;">
		<select id="reccategory" name="reccategory">
			<option value="한식">한식</option>
			<option value="양식">양식</option>
			<option value="일식">일식</option>	
			<option value="중식">중식</option>
			<option value="디저트&베이커리">디저트/베이커리</option>
		</select>
	</td>
</tr>

<tr>
	<th>요리정보</th>
	<td style="text-align: left;">몇인분
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
</table>
<br>
<table class="list_table" style="margin-left: 500px">
<tr>
	<th>요리재료</th>
	<td style="text-align: left" colspan="2">	<!-- 썸머노트, smart editor -->
		<textarea rows="6" cols="80" name="ingredient"></textarea>
	</td>
</tr>
</table>
<br>
<table style="margin-left: 500px">
	<tr>
<th></th>
	<td>
 	 <textarea class="summernote" name="reccontent" id="summernote"></textarea>    
	</td>
</tr>
<tr>
		<td colspan="2" style="height:50px; text-align:center;">
			<span>
				<a href="#none" id="_btnrecipe" title="레시피등록">
					<img alt="" src="image/bwrite.png">
				</a>
			</span>
		</td>
	</tr>
</tbody>
</table>
</form>
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

$("#_btnrecipe").click(function () {
	
	
	
	$("#_frmForm").submit();
});
</script>
</body>
</html>

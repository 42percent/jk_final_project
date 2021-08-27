<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Recipe Write</title>
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

<table class="list_table" style="margin-left:auto;  margin-right:auto;">
<colgroup>
<col style="width:auto;" />
<col style="width:auto;" />
<col style="width:auto;" />
</colgroup>

<tbody align="center">	
	<tr class="id">

		<td>
			<input type="text" name="id" readonly="readonly" value='${login.id}' size="60" hidden=""/>
		</td>
	</tr>
<tr>
<td>제목</td>
	<td align="left">
				<!-- <input type="text" name="recipetitle" size="67"/> -->
				<textarea rows="1" cols="65" name="recipetitle"></textarea>
			</td>
 			<td rowspan="2" class="img_wrap" align="center" >
		<img id="img">
		<input type="file" name="fileload" id="input_img">
	</td>
	</tr>
	<tr>
	<th>요리소개</th>
	<td align="left">
		<textarea rows="6" cols="65" name="recintroduce"></textarea>
	</td>
</tr>
<tr class="space">
	<th>카테고리</th>
	<td align="left">
		<select id="reccategory" name="reccategory">
			<option value="한식">한식</option>
			<option value="양식">양식</option>
			<option value="일식">일식</option>	
			<option value="중식">중식</option>
			<option value="베이커리">베이커리</option>
		</select>
	</td>
</tr>

<tr>
	<th>요리정보</th>
	<td align="left">
		인원
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
<tr>
	<td>요리재료</td>
	<td align="left">
		<textarea rows="6" cols="65" name="ingredient" ></textarea>
	</td>
</tr>


	<tr>

	<td colspan="3" align="center">
 	 <textarea class="summernote" name="reccontent" id="summernote"></textarea>    
	</td>
</tr>
<tr>
		<td colspan="3" style="height:50px;" align="center">
			<span>
				<a href="#none" id="_btnrecipe" title="레시피등록">
				<br>
					<img alt="" src="image/bwrite.png">
				</a>
			</span>
		</td>
	</tr>
</tbody>
</table>
</form>
<script type="text/javascript">
$("#_btnrecipe").click(function() {
   let recipetitle = document.frmForm.recipetitle;
   let fileload = document.frmForm.fileload;
   //let kinds = $("#kinds option:selected").val();
   let recintroduce = document.frmForm.recintroduce;
   let ingredient = document.frmForm.ingredient;
   let reccontent = document.frmForm.reccontent;
   
   let v = confirm("레시피를 작성하시겠습니까?");
   
   
   if(recipetitle.value.trim() == ""){
      alert("제목을 입력하세요");
      recipetitle.focus();
      return false;
   }if(fileload.value.trim() == ""){
      alert("대표사진을 지정하세요");
      fileload.focus();
      return false;
   /* }if(kinds == ""){
      alert("카테고리를 지정하세요");
      document.getElementsByName("kinds")[0].focus();
      return false; */
   }if(recintroduce.value.trim() == ""){
      alert("요리소개를 작성해주세요");
      recintroduce.focus();
      return false;
   }if(ingredient.value.trim() == ""){
      alert("요리재료를 작성해주세요");
      ingredient.focus();
      return false;
   }if(reccontent.value.trim() == ""){
      alert("요리순서를 작성해주세요");
      reccontent.focus();
      return false;
   }else if (v==true) {
      $("#_frmForm").submit();
    }
});

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

/* $("#_btnrecipe").click(function () {
	
	
	
	$("#_frmForm").submit();
}); */
</script>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 	<div id="_top_menu">
		<ul class="navi">
			<li><a href="home.do" title="답변형 게시판">Home</a></li>
			<li><a href="recipe.do" title="유저 레시피">유저 레시피</a></li>
			<li><a href="recipe.do">레시피</a>
		      <ul id="sub-menu">
		        <li><a href="recipe.do?search=한식&choice=reccategory" aria-label="subemnu">한식</a></li>
		        <li><a href="recipe.do?search=양식&choice=reccategory" aria-label="subemnu">양식</a></li>
		        <li><a href="recipe.do?search=일식&choice=reccategory" aria-label="subemnu">일식</a></li>
		        <li><a href="recipe.do?search=중식&choice=reccategory" aria-label="subemnu">중식</a></li>
		        <li><a href="recipe.do?search=베이커리&choice=reccategory" aria-label="subemnu">베이커리</a></li>
		      </ul>
		    </li>	
			<li><a href="summernote.do" title="레시피 등록">레시피 등록</a></li>
			
			<li><a href="marketmain.do" title="">마켓메인페이지</a></li>
			
			<li><a href="cclist.do" title="쿠킹클래스">쿠킹클래스</a></li>
			<li><a href="ccwrite.do" title="모임생성">모임생성</a></li>
			
		</ul>
	</div> -->
	
<link rel="stylesheet" type="text/css" href="./css/nav.css">
<body class="navmenu">
    <nav class="navmenu">
        <ul>
            <li><a href="home.do">Home</a></li>
            <li><a href="recipe.do">유저 레시피</a>
            <!-- First Tier Drop Down -->
            <ul>
                <li><a href="recipe.do?search=한식&choice=reccategory">한식</a></li>
                <li><a href="recipe.do?search=양식&choice=reccategory">양식</a></li>
                <li><a href="recipe.do?search=일식&choice=reccategory">일식</a></li>
                <li><a href="recipe.do?search=중식&choice=reccategory">중식</a></li>
                <li><a href="recipe.do?search=베이커리&choice=reccategory">베이커리</a></li>
                <li><a href="recipewrite.do" >레시피등록</a></li>
                
            </ul>        
            </li>
            <li><a href="cclist.do">쿠킹 클래스</a>
            <!-- First Tier Drop Down -->
            <ul>
                <li><a href="ccwrite.do">모임생성</a></li>
                <li><a href="calist.do">나의수업일정</a></li>
                <li><a href="#">Tutorials</a></li>
            </ul>
            </li>
            <li><a href="marketmain.do">마켓 페이지</a></li>
      <!--       <li><a href="#">Contact</a></li>
            <li><a href="#">About</a></li>  -->
        </ul>
    </nav>
    </body>
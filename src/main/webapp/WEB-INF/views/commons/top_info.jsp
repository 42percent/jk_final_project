<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="nows" class="java.util.Date" />
<!-- useBean : object 생성 -->

<div>
	<div id="top_menu">
		<ul class="navi">
			<li><a href="login.do" title="로그인">로그인</a></li>
			<li><a href="regi.do" title="회원가입">회원가입</a></li>	
			<li><a href="mypage_main.do" title="마이페이지">마이페이지</a></li>	
			<li><a href="logout.do" title="로그아웃">로그아웃</a></li>	

			<li><a href="cslist.do" title="고객센터">고객센터</a></li>
			<li><a href="allmemlist.do" title="모든회원보기">모든회원보기</a></li>
			<li><a href="allrecipelist.do" title="전체레시피보기">전체레시피보기</a></li>
			<li><a href="allclasslist.do" title="전체클래스보기">전체클래스보기</a></li>
			<li><a href="allmarketlist.do" title="전체상품보기">전체상품보기</a></li>
			<li><a href="sellchart.do" title="매출통계">매출통계</a></li>
			<li><a href="http://pf.kakao.com/_cWims" title="관리자페이지">채팅하기</a></li>
		</ul>		
	</div>
</div> 



<c:if test="${login.nickname != '' }">
      [${login.nickname}]님 환영합니다
</c:if>



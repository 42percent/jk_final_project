<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 쿠킹클래스</title>
</head>
<body>

 <section class="py-5">
        <h3 align="center"></h3>
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-left">
                    <c:forEach items="${myclass}" var="myclass" varStatus="i" >
                        <div class="card h-100">
                            <!-- Product image-->
                             <h5 class="fw-bolder" onclick="location.href='ccdetail.do?seq=${myclass.SEQ}'"><img class="card-img-top" src="upload/${myclass.NEWFILENAME}" alt="..." width="300" height="200" /></h5>
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->

<h5 class="fw-bolder">${myclass.TITLE}</h5>
<h6>클래스 선생님 ${myclass.NICKNAME}</h6>
<h6>장소 ${myclass.LOCATION}</h6>
            </div>
                          
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </section>
		        




</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>
<title>운영중인 쿠킹클래스</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" type="text/css" />  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>


 <section class="py-5">
        <h3 align="center"></h3>
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-left">
                    <c:forEach items="${mycclist}" var="mycc" varStatus="i" >
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <h5 class="fw-bolder" onclick="location.href='ccdetail.do?seq=${mycc.seq}'"><img class="card-img-top" src="upload/${mycc.newfilename}" alt="..." width="300" height="200" /></h5>
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->

<h5 class="fw-bolder">${mycc.title}</h5>
<h6>강의날짜 ${mycc.cdate.substring(2, 10)}</h6>
<h6>모집인원 (1/${mycc.membernum})</h6>
<h6>장소 ${mycc.location}</h6>
            </div>
                          
                        </div>
                    </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </section>
		        



</body>
</html>
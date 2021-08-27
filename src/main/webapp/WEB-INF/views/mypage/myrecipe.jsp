<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>

 <c:forEach items="${myrecipelist}" var="myrecipe" varStatus="i" >

  <section class="py-5">
        <h3 align="center"></h3>
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-left">
                    <c:forEach var="myrecipe" items="${myrecipelist}" varStatus="i" >
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <h5 class="fw-bolder" onclick="location.href='redetail.do?seq=${myrecipe.seq}'">
                          	  <img class="card-img-top" src="upload/${myrecipe.newbestimg }" alt="..." width="300" height="200" /></h5>
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder"  onclick="location.href='redetail.do?seq=${myrecipe.seq}'">${myrecipe.recipetitle}</h5>
                                    <!-- Product price-->
                                    작성자: ${myrecipe.id}<br>
                                    ${myrecipe.reccategory }<br>
                                    조리시간:${myrecipe.rectime} <br>
                                </div>
                            </div>
                        
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </section>
		        
 </c:forEach>

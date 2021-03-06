<%@page import="bit.your.prj.dto.MarketDto"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>
<c:set var="dto" value="${dto}"/>
<c:set var="login" value="${login}"/>
<c:set var="cartCount" value="${cartCount}"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>MarketDetail</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        
        <script type="text/javascript">
		$(document).ready(function() {
			basket.reCalc();
			basket.updateUI();
		});
		</script> 
        
        <script type="text/javascript">
        $(document).ready(function() {
        	$('#ca_manu .dropdown-menu').hide();
        	
        	$('.nav-link').mouseover(function () {
				$('.dropdown-menu').slideDown();
			});
        	$('.dropdown-menu').mouseleave(function () {
				$('.dropdown-menu').hide();
			});
        	
        });
        </script>
        <script type="text/javascript">
        $(document).ready(function() {
        $("#btnSearch").click(function () {
        	location.href = "getSearchList.do?search=" + $("#_search").val();	
        	});
        });
        </script>
        
        <script type="text/javascript">
        $(document).ready(function () {
        	
			$('#btn_cart').click(function () {
				var id = $("#id").val();
				var itemnum = $("#itemnum").val();
				var count = $("#p_num1").val();
				var address = $("#address").val();
				
				var allData = {"id":id , "itemnum": itemnum, "count":count, "address":address};
			        
			    $.ajax({
			        url:"addcart.do",
			        type: "GET",
			        data: allData,
			        success:function(data){
			        	alert("??????????????? ?????? ????????????");
			        	location.reload(true); 
			        	window.opener.location.reload();
			        	self.close();
			        },
			        error:function(jqXHR, textStatus, errorThrown){
			            alert("?????? ??????~~ \n" + textStatus + " : " + errorThrown);
			            self.close();
			     	}
			   }); 	
				
		  }); 	
    });
        
        
      
        </script>
        
        
    </head>
    <body>
    	<div align="center" style="height: 100px">
    		<a>??????</a><br>
    		<a href="marketmain.do">???????????? ??????</a>
    		<a href="marketwrite.do">????????????</a>
    	</div>
    	<div align="right">????????????/?????????</div>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                    	<li class="nav-item dropdown" >
                            <a class="nav-link dropdown-toggle" id="ca_manu">?????? ????????????</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="marketlist.do?canum=1">
                                	<img src="./image/meat.png" alt="???????????? ?????????" style="width: 24px; height: 24px;">
                                	??????</a>
                                </li>
                                <li><a class="dropdown-item" href="marketlist.do?canum=2">
                                	<img src="./image/fish.png" alt="???????????? ?????????" style="width: 24px; height: 24px;">
                                	??????</a></li>
                                <li><a class="dropdown-item" href="marketlist.do?canum=3">
                                	<img src="./image/carrot.png" alt="???????????? ?????????" style="width: 24px; height: 24px;">
                                	??????</a></li>
                                <li><a class="dropdown-item" href="marketlist.do?canum=4">
	                                <img src="./image/fruit.png" alt="???????????? ?????????" style="width: 24px; height: 24px;">
	                                ??????</a>
                                </li>
                                <li><a class="dropdown-item" href="'marketlist.do?canum=5'">
                                	<img src="./image/kit.png" alt="???????????? ?????????" style="width: 24px; height: 24px;">
                                	?????????</a>
                                </li>
                            </ul>
                        </li>&nbsp;&nbsp;&nbsp;&nbsp;
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="newMarketList.do">?????????</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
                        <li class="nav-item"><a class="nav-link" href="#!">?????????</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
                        <li class="nav-item"><a class="nav-link" href="#!">??????/??????</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
                    </ul>
                    <form class="d-flex" action="getSearchList.do">
					    <input class="form-control me-2" placeholder="Search" aria-label="Search" id="_search">
					    <button class="btn btn-outline-success" type="button" id="btnSearch">Search</button>
				    </form>&nbsp;&nbsp;&nbsp;&nbsp;
                    <form class="d-flex" action="goCart.do">
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            ????????????
                            <span class="badge bg-dark text-white ms-1 rounded-pill">${cartCount}</span>
                        </button>
                    </form>
                </div>
            </div>
        </nav>
        <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="./marketimage/${dto.newmainpt}" alt="..." /></div>
                    <div class="col-md-6" id="abc">
                        <h1 class="display-5 fw-bolder">${dto.title}</h1>
                        <div class="small mb-1" >${dto.subtitle }</div><br>
                        <ul class="list-group list-group-flush">
						  <li class="list-group-item">
						  
						  	<a style="width: 150px;float: left;width: 150px;line-height: 20px;">??????</a><a><fmt:formatNumber value="${dto.price}" pattern="#,###,###"/>???</a>
						  	<input type="hidden" value="${login.id}" id="id">
						  	<input type="hidden" value="${dto.itemnum}" id="itemnum">
						  	<input type="hidden" value="${login.address1}" id="address">
						  	<input type="hidden" value="${dto.seq}" id="seq">
    					  </li>
						  <li class="list-group-item">
						  	<a style="width: 150px;float: left;width: 150px;line-height: 20px;">??????/??????</a><a>${dto.gram}</a>
    					  </li>
						  <li class="list-group-item">
						  	<a style="width: 150px;float: left;width: 150px;line-height: 20px;">?????????</a><a>${dto.country}</a>
						  </li>
						  <li class="list-group-item">
						  	<a style="width: 150px;float: left;width: 150px;line-height: 20px;">????????????</a><a>${dto.expiration}</a>
						  </li>
						  <li class="list-group-item" >
						  	<a style="width: 150px;float: left;width: 150px;line-height: 20px;">??????</a>
						  	<div class="updown">
						  	<img alt="" src="./image/minus.png" style="width: 20px;" class="down">
						  	<input readonly="readonly" value="1" style="width: 35px; height:30px; text-align: center;" name="p_num1" id="p_num1" class="p_num">
						  	<img alt="" src="./image/plus.png" style="width: 20px;" class="up">
						  	</div>
						  </li>
						</ul>
						<br>
						<a style="float: left; width: 150px; margin-left: 300px;">??? ?????? ?????? :</a>
						<div class="sum" style="font-weight: bold; font-size: 20px; line-height: 20px;">${dto.price}???</div>
						<br>
                        <div class="d-flex">
                            <button class="btn btn-outline-dark flex-shrink-0" type="button" style="margin-left: 400px;" id="btn_cart">
                                <i class="bi-cart-fill me-1"></i>
                                ???????????? ??????
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        	<img alt="" src="./marketimage/${dto.content}" style="display:block; margin-left: auto; margin-right: auto;">
        <!-- Related items section-->
        <section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5">
            	<h2 class="fw-bolder mb-4">????????? ??????</h2>
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <c:forEach var="market" items="${marketlist}" varStatus="i" begin="0" end="3">
                    <c:if test="${dto.seq ne market.seq}">
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="./marketimage/${market.newmainpt}" alt="..." onclick="location.href='marketdetail.do?seq=${market.seq}'" />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder" onclick="location.href='marketdetail.do?seq=${market.seq}'">${market.title}</h5>
                                    <!-- Product price-->
                                    <fmt:formatNumber value="${market.price}" pattern="#,###,###"/>???<br>
                                    <a style="font-size: 12px; color: gray;">${market.subtitle}</a>
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="">???????????? ??????</a></div>
                            </div>
                        </div>
                    </div>
                    </c:if>
                    </c:forEach>
                </div>
            </div>
        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2021</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <script type="text/javascript">
        
        document.addEventListener('DOMContentLoaded', function() {
        	document.querySelectorAll('.updown').forEach(

        	    function(item, idx){

        	          //?????? ?????? ?????? ??? ??????
        	        item.querySelector('input').addEventListener('keyup', function(){
        	           basket.changePNum(idx+1);
        	        });
        	          //?????? ?????? ????????? ??????
        	        item.children[0].addEventListener('click', function(){
        	            basket.changePNum(idx+1);
        	        });
        	          //?????? ?????? ????????? ??????
        	        item.children[2].addEventListener('click', function(){
        	            basket.changePNum(idx+1);
        	        });
        	    }
        	);
        	
	});
        
        
         let basket = {

        	    totalCount: 0, //?????? ?????? ??????
        	    totalPrice: 0, //?????? ????????? ??????

        	    //?????????

        	    reCalc: function(){

        	        this.totalCount = 0;
        	        this.totalPrice = 0;
        	        
        	        document.querySelectorAll(".p_num").forEach(function (item) {
        	            var count = parseInt(item.getAttribute('value'));
        	            this.totalCount += count;
        	            var price = ${dto.price};
        	            this.totalPrice += count * price;
        	        }, this); // forEach 2?????? ??????????????? ????????? ????????? this ??? ?????????????????? ??????????????? ???. - thisArg

        	    }, 
        	    
        	  	//?????? ????????????
        	     updateUI: function () {

        	        document.querySelector('.sum').textContent = this.totalPrice.formatNumber() + '???';
        	    },  
        	    
        	    //?????? ?????? ??????

        	    changePNum: function (pos) {
        	        var item = document.querySelector('input[name=p_num'+pos+']');
        	        var p_num = parseInt(item.getAttribute('value'));
        	        var newval = event.target.classList.contains('up') ? p_num+1 : 
        	        	event.target.classList.contains('down') ? p_num-1 : event.target.value;

        	        if (parseInt(newval) < 1 || parseInt(newval) > 99) { return false; }
        	        item.setAttribute('value', newval);
        	        item.value = newval;

        	        var price = ${dto.price};
        	        
        	         //item.parentElement.parentElement.nextElementSibling.textContent = (newval * price)+ '???'; 
        	        //AJAX ???????????? ??????
        	        
        	        this.reCalc();
        	        this.updateUI();
        	    }
        	}
         
         		Number.prototype.formatNumber = function(){
	        	    if(this==0) return 0;
	        	    let regex = /(^[+-]?\d+)(\d{3})/;
	        	    let nstr = (this + '');
	        	    while (regex.test(nstr)) nstr = nstr.replace(regex, '$1' + ',' + '$2');
	        	    return nstr;
        	};
        </script>
    </body>
</html>


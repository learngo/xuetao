<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/index-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/index-scrollpic.css"/>" />

    <div class="">
      <div id="carousel-example-generic" class="carousel slide">
        <ol class="carousel-indicators">
          <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
          <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        </ol>
        <div class="carousel-inner">
          <div class="item active">
            <img src="<c:url value="/resources/images/home/party.jpg"/>" alt="">
          </div>
          <div class="item">
           <img src="<c:url value="/resources/images/home/good.jpg"/>" alt="">
          </div>
        </div>
      </div><!-- carousel end //-->
    </div>
<script>
$('.carousel').carousel();
$(document).ready(function(){
	  $(".carousel-inner .item img").css({
		  "width":Init.windowWidth+'px',
		  "height":(Init.windowHeight-60)+'px'
		  });
	});
</script>



<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/prettyPhoto.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/piano.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/piano-detail.css"/>" />
<div class="breadcrumbrow">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href='<c:url value="/"></c:url>'>首页</a></li>
				<li class="active"><a href="#">活动</a></li>
			</ul>
		</div>
	</div>
<div class="container">
   <div class="work">
    <div class="row">
      <div class="col-md-4">
        <h5>${good.title }</h5>
        <p>${good.name}</p>
       
        <h5> About Project</h5>
        <p>${good.description } </p>
         <h5> create time:</h5>
        <p>${good.createTime }</p>
        </div>
      <div class="col-md-8">
        <ul class="portfolio_showcase">
          <li> <img src="../resources/web/img/1.png" alt="Image" /></li>
          <li> <img src="../resources/web/img/2.png" alt="Image" /></li>
          <li> <img src="../resources/web/img/3.png" alt="Image" /></li>
          <li> <img src="../resources/web/img/4.png" alt="Image" /></li>
        </ul>
        <div id="number" class="work-pagination"> </div>
      </div>
    </div>
  </div>
</div>

<script src="../resources/web/js/jquery.prettyPhoto.js" type="text/javascript"></script> 
<script src="../resources/web/js/superfish.js" type="text/javascript"></script> 
<script src="../resources/web/js/jquery.isotope.min.js" type="text/javascript"></script> 
<script src="../resources/web/js/custom.js" type="text/javascript"></script>



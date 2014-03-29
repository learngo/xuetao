<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/prettyPhoto.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/piano.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/piano-detail.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/contact.css"/>" />
<div class="breadcrumbrow">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href='<c:url value="/"></c:url>'>Home</a></li>
				<li class="active"><a href="goods">Good</a></li>
			</ul>
		</div>
	</div>
  <div class="container">
   <div class="work" style="height: 450px; overflow: hidden;">
    <div class="row">
      <div class="col-md-4">
        <h5>${good.title }</h5>
        <p>${good.name}</p>
        <h5>About Good</h5>
        <p>${good.description } </p>
        <h5>Add time:</h5>
        <p>${good.createTime }</p>
        </div>
      <div class="col-md-8">
        <ul class="portfolio_showcase">
          <li> <img src="<c:url value="${good.logo}"/>" alt="Image" style="height: 400px;width: 750px"/></li>
          <c:forEach var="pic" items="${goodPics}" varStatus="statu">
            <li> <img src="<c:url value="${pic.path}"/>" alt="Image" style="height: 400px;width: 750px"/></li>
          </c:forEach>
        </ul>
        <div id="number" class="work-pagination"> </div>
      </div>
    </div>
</div>

  <div class="row">
     <div class="col-md-8 fr"> 
     <c:if test="${goodComments!=null}">
       <c:forEach items="${goodComments }" var="goodComment">
       <div class="media">
        <div class="media-body">
          <h4 class="media-heading">Media Heading</h4>
           ${goodComment.content}
        </div>
      </div>
       </c:forEach>
       
     
     </c:if>
    </div>
  </div>
  
  
  
  <div class="row contact">
    <div class="col-md-8 fr">
      <div class="wpcf7" id="wpcf7-f75-t1-o1">
        <form action="<c:url value="/web/addGoodMessage"/>" method="post" class="wpcf7-form">
          <div id="output" class="alert"> </div>
          <!-- 
          <div class="form-meta clearfix">
            <div class="formcol">
              <label for="fname"> First Name</label>
              <input type="text" name="fname" value="" id="fname" size="40" />
              <label for="lname"> Last Name</label>
              <input type="text" name="lname" value="" id="lname" size="40" />
            </div>
            <div class="formcol">
              <label for="email"> Email Address</label>
              <input type="text" name="email" id="email" value="" size="40" />
              <label for="subject"> Subject</label>
              <input type="text" name="subject" id="subject" value="" size="40" />
            </div>
          </div>
           -->
           <input type="hidden" value="goodId" value="${good.id}" />
          <label for="message"> Message：</label>
          <textarea name="message" id="message" cols="40" rows="10"></textarea>
          <input type="submit" id="send-message" value="Send" class="btn btn-success mt20 mb20" />
        </form>
      </div>
    </div>
  </div>
</div>
<script src="../resources/web/js/jquery.prettyPhoto.js" type="text/javascript"></script> 
<script src="../resources/web/js/superfish.js" type="text/javascript"></script> 
<script src="../resources/web/js/jquery.isotope.min.js" type="text/javascript"></script> 
<script src="../resources/web/js/detail.js" type="text/javascript"></script>



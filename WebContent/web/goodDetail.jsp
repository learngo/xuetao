<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
   <div class="work" >
    <div class="row">
      <div class="col-md-4">
         <c:if test="${member!=null }">
         <h5> Sale Name </h5>
        <p>${member.name }</p>
         </c:if>
         <c:if test="${good.buyerName!=null }">
         <h5>Buyer Name </h5>
        <p>${good.buyerName }</p>
         </c:if>
        <h5>Good Name </h5>
        <p>${good.name }</p>
        <h5>Good Price </h5>
        <p>${good.price}</p>
        <h5>About Good</h5>
        <p>${good.description } </p>
        <h5>Add time:</h5>
        <p>${good.createTime }</p>
        <div id="output" class="alert">contact</div>
        <c:if test="${evalutes!=null}">
	       <c:forEach items="${evalutes }" var="evalute">
	       <div class="media">
	        <div class="media-body">
	          <h4 class="media-heading">
                <a 
					href="<c:url value="/viewMemberInfo"/>?memberId=${evalute.memberId}">
						${evalute.memberName}
				</a>
	          </h4>
	           Phone:
	           ${evalute.remark }
	           <br/>
	           Message:
	            ${evalute.content}
	            ---
	            <fmt:formatDate value="${evalute.createTime}" pattern="yyyy-MM-dd HH:mm"/>
	           <br/>
	           <a href="<c:url value="/web/goodCommentDetail"/>?goodId=${good.goodId}&evaluateId=${evalute.id}"
					target="_blank">Reply sum </a>(${evalute.replyCount})
	           </div>
	           </div>
	           </c:forEach>
	     </c:if>
        
	       
      </div>
      <div class="col-md-8">
        <ul class="portfolio_showcase">
          <li> <img src="<c:url value="${good.logo}"/>" alt="Image" style="height: 400px;width: 750px"/></li>
          <c:forEach var="pic" items="${goodPics}" varStatus="statu">
            <li> <img src="<c:url value="${pic.path}"/>" alt="Image" style="height: 400px;width: 750px"/></li>
          </c:forEach>
        </ul>
        <div id="number" class="work-pagination"> </div>
        
        <div class="row contact">
      <div class="wpcf7 mt20">
        <form action="<c:url value="/member/subEvalute"/>" method="post" class="wpcf7-form">
          <div id="output" class="alert"> leave u contact</div>
           <div class="form-meta clearfix">
            <div class="formcol">
              <label for="fname">contact phone</label>
              <input type="text" name="remark" value="" size="40"  required="required"/>
            </div>
            </div>
          <input type="hidden" name="evaluateProductId" value="${good.goodId}" />
          <input type="hidden" name="evaluateProductType" value="2" />
          <input type="hidden" name="evaluateProductMemberId" value="${good.memberId}" />
          <label for="message"> Message：</label>
          <textarea name="content" id="message" cols="40" rows="10" required="required"></textarea>
          <input type="submit" id="send-message" value="Send" class="btn btn-success mt20 mb20" />
        </form>
      </div>
      </div>
      </div>
    </div>
</div>
  
  
  
  <div class="row contact">
  
    <div class="col-md-8 fr">
      
    </div>
  </div>
</div>



<script src="../resources/web/js/jquery.prettyPhoto.js" type="text/javascript"></script> 
<script src="../resources/web/js/superfish.js" type="text/javascript"></script> 
<script src="../resources/web/js/jquery.isotope.min.js" type="text/javascript"></script> 
<script src="../resources/web/js/detail.js" type="text/javascript"></script>



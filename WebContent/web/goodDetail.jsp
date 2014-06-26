<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/prettyPhoto.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/piano.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/piano-detail.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/contact.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/partyDetail.css"/>" />
<div class="">
		<div class="container">
            <ul class="detail-nav">
				<li class="active"><a href='<c:url value="/"></c:url>'>SHOP></a></li>
				<li><a href="goods">${good.name }</a></li>
			</ul>
		</div>
	</div>
  <div class="container">
   <div class="work" >
    <div class="row">
        <div class="party_content good_content">

            <span class="party_content_title">
                <span class="photo">
                <img width="69" height="43" src="<c:url value="${member.photo }"/>" alt="${member.name }" class="avatar"/>
                </span>
                <span class="name">
                    <a href="<c:url value="/viewMemberInfo"/>?memberId=${member.id}">
                    ${member.name}
                    </a>
                </span>
                <span>
                    <a href="#commentParty" data-toggle="modal"class="btn btn-success fr mb20" >LEAVE U CONTACT</a>
                </span>
            </span>

            <ul class="good-pics">
                <li> <img src="<c:url value="${good.logo}"/>" alt="Image" style="width: 100%;"/></li>
                <c:forEach var="pic" items="${goodPics}" varStatus="statu">
                <li> <img src="<c:url value="${pic.path}"/>" alt="Image" style="width: 100%;"/></li>
                </c:forEach>
            </ul>

            <div class="good_info">
                 <c:if test="${member!=null }">
                    <div class="text-primary">
                        <span class="info-title"> Sale Name</span>
                        <p>${member.name }</p>
                    </div>
                 </c:if>
                 <c:if test="${good.buyerName!=null }">
                     <div class="text-primary">
                         <span class="info-title">Buyer Name </span>
                         <p>${good.buyerName }</p>
                     </div>
                 </c:if>
                <div class="text-primary">
                    <span class="info-title">Good Name </span>
                        <p>${good.name }</p>
                </div>
                <div class="text-primary">
                    <span class="info-title">Good Price </span>
                        <p>${good.price}</p>
                </div>
                <div class="text-primary">
                    <span class="info-title">About Good</span>
                        <p>${good.description } </p>
                </div>
                <div class="text-primary">
                    <span class="info-title">Add time:</span>
                        <p>${good.createTime }</p>
                </div>
            </div>
      </div>

        <div class="contact">
              <div class="wpcf7 mt20">
                    <form action="<c:url value="/member/subEvalute"/>" method="post" class="wpcf7-form">
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
                      <textarea name="content" id="message" cols="40" rows="10"  placeholder="Please enter a message" required="required"></textarea>
                      <input type="submit" id="send-message" value="Send" class="btn btn-success mt20 mb20" />
                    </form>
              </div>
      </div>

      <div class="comments">
        <ul>
              <c:if test="${evalutes!=null}">
                   <c:forEach items="${evalutes }" var="evalute">
                       <li>
			                <div class="comments-avatar">
			                <img class="avatar" src="<c:url value="/"/>${evalute.memberPhoto}">
			                </div>
			                <div class="comments-content">
			                <h2>
			                <span> ${evalute.memberName}(${evalute.remark })</span><span><fmt:formatDate value="${evalute.createTime}" pattern="yyyy-MM-dd HH:mm"/> </span>
			                </h2>
			                <p>
			                 ${evalute.content}
			                </p>
			                <a href="javascript:;" class="btn-reply" data="${evalute.id}" >Reply immediately &gt;</a>
			                <div class="comments-answer">
			                <c:if test="${evalute.evaluateComments!=null}">
			                   <c:forEach items="${evalute.evaluateComments }" var="evaluateComment">
			                    <h2>${evaluateComment.memberName } answer:</h2>
				                <p>
				                   ${evaluateComment.content }
				                </p>
			                   </c:forEach>
			                   </c:if>
			                
			                </div>
			                </div>
			            </li>
                       
                       </c:forEach>
                 </c:if>
            
            
        </ul>
      </div>


    </div>
</div>

</div>



<script src="../resources/web/js/jquery.prettyPhoto.js" type="text/javascript"></script> 
<script src="../resources/web/js/superfish.js" type="text/javascript"></script> 
<script src="../resources/web/js/jquery.isotope.min.js" type="text/javascript"></script> 
<script src="../resources/web/js/detail.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
   $('.btn-reply').click(function(){
        var a=$(this);
        if(a.hasClass('disable')){
            return;
        }
        a.addClass('disable');
        var b=$('<div class="comments-msg-box"><textarea name="comment"  cols="40" rows="10"  placeholder="Please enter a message" required="required"></textarea><a href="javascript:;"  class="btn btn-submit">OK</a></div>');
        b.insertAfter($(this));
        b.find('textarea').focus();
        b.find('.btn-submit').bind('click',function(){
            var box=$(this).closest('.comments-msg-box');
            var value=box.find('textarea').val();
            
            alert(value);
            
            
            box.remove();
            a.removeClass('disable');
        });
    });
});
</script>


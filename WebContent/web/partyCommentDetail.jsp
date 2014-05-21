<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/buy-card.css"/>" />
	<link rel="stylesheet"
	href="<c:url value="/resources/web/css/commentDetail.css"/>" />

<div class="breadcrumbrow">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href='<c:url value="/"></c:url>'>首页</a></li>
			<li class="active"><a href="#">活动详情</a></li>
		</ul>
	</div>
</div>
<div class="container">
	<div class="col-md-3">
		<span> <img width="233" height="145"
			class="product-image thumbnail"
			src="<c:url value="${party.icon}"/>"
			alt="${party.title }">
		</span>
		<p class="text-primary tc">
		  ${party.title }
		</p>
		<p class="text-primary"><span class="color_f63 fb">活动发起人：</span>
		   ${member.name} 
		  </p>
		<p class="text-primary"><span class="color_f63 fb">活动时间：</span>
		   <fmt:formatDate value="${party.startTime }" pattern="yyyy-MM-dd"/>~
		  <fmt:formatDate value="${party.endTime }" pattern="yyyy-MM-dd"/>
		  </p>
		  <p class="text-primary"><span class="color_f63 fb">活动地点：</span>
		  ${party.address }
		  </p>
		<div class="media-body">
		   <span class="color_f63 fb">活动简介：</span>
		   ${party.description }
		</div>
	</div>
	<div class="col-md-9 content">
	   <div class="comment-content">
                <div class="comment-content-title">
                    评价内容
                    <a href="<c:url value="/web/partyDetail?partyId=${party.id}"/>" class="fr"> 返回</a>
                </div>
                <div class="comment-content-detail">
                    <div class="article">
                        <h2 class="art_title clearfix">
                            <div class="leftPart">
                                ${evalute.remark}                       
                             </div>
                            <div class="rightPart">   
                            <fmt:formatDate value="${evalute.createTime}" pattern="yyyy-MM-dd HH:mm"/>   
                            </div> 
                        </h2>
                        <ul class="art_tags clearfix">
                                                    </ul>
                        <div class="art_content J_mi_art_content">
                         ${evalute.content}     
                         </div>
                          <div class="article_answer J_art_answer">
                            <h3 id="reply">我要回复</h3>
                            <div class="answer-input-bar">
                            <form class="form-horizontal" action="<c:url value="/member/subEvaluteComment"/>">
                                <input type="text" class="input-frame J_mi_reply_input" name="content"  required="required"/>
                                <input type="hidden" value="${evalute.id}" name="evaluateId">
								<input  type="hidden" name="evaluateProductType" value="1"/>
			                    <input  type="hidden" name="evaluateProductId" value="${party.id}"/>
			                    <input  type="hidden" name="memberId" value="${evalute.memberId}"/>
						         <button type="submit" class="btn btn-primary" >回复</button>
                            </form>
                            </div>
                            <ul class="answer-list J_mi_comment_replay">
                             <c:if test="${evalute.evaluateComments!=null}">
	       						<c:forEach items="${evalute.evaluateComments }" var="evaluateComment">
                            <li>
	                            <div class="author clearfix">
	                            	<div class="leftPart">${evaluateComment.memberName }</div>
	                            </div>
	                            <p>${evaluateComment.content }</p>
	                            <div class="reply_footer  clearfix">
		                            <div class="rightPart"><fmt:formatDate value="${evaluateComment.createTime}" pattern="yyyy-MM-dd HH:mm"/>&nbsp;&nbsp;&nbsp;&nbsp;
		                            <a href="#replyModal${evaluateComment.id}" data-toggle="modal" class="btn btn-primary">[ 回复]</a>
	              <!-- Modal -->
<div class="modal fade" id="replyModal${evaluateComment.id}">
 		<div class="modal-dialog panel-primary">
          <div class="modal-content">
            <div class="modal-header panel-heading">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
              <h4 class="modal-title">reply：</h4>
            </div>
            <form class="form-horizontal" action="<c:url value="/member/subEvaluteComment"/>">
				<div class="modal-body">
					<input type="hidden" value="${evaluateComment.id}" name="evaluateId">
					<input  type="hidden" name="evaluateProductType" value="1"/>
                    <input  type="hidden" name="evaluateProductId" value="${party.id}"/>
                    <input  type="hidden" name="memberId" value="${evaluateComment.memberId}"/>
					<div class="form-group">
						<label class="col-lg-2 control-label">replyContent：</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" name="content"
								placeholder="reply: ${evaluateComment.memberName }"  required="required"/>
						</div>
					</div>
				</div>
				<div class="modal-footer">
	              <button type="button" class="btn btn-default " data-dismiss="modal">cancel</button>
	              <button type="submit" class="btn btn-primary" >submit</button>
            	</div>
          </form>   
          </div><!-- /.modal-content //-->
        </div><!-- /.modal-dialog //-->
</div><!-- /.modal -->
		                            </div>
	                            </div>
                            </li>
                            </c:forEach>
                            </c:if>
                         </ul>
                        </div>
                    </div>
                    <div class="head_photo">
                        <h3 class="name">${evalute.memberName}</h3>
                    </div>      
                </div>
                
            </div>
	</div>
</div>


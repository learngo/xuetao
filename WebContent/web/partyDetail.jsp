<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/partyDetail.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/comment.css"/>" />
<div class="breadcrumbrow">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href='<c:url value="/"></c:url>'>首页</a></li>
			<li class="active"><a href="#">活动详情</a></li>
		</ul>
	</div>
</div>
<div class="container">
  <div class="row">
	  <div class="col-md-9 party_content">
	  <span class="party_content_title">
	  <span class="photo">
	  <img width="69" height="43" src="<c:url value="${member.photo }"/>"
										alt="${member.name }" class="avatar">
	  </span>
	  <span class="name">
		  <a href="<c:url value="/viewMemberInfo"/>?memberId=${member.id}">
											${member.name} 
		  </a>
	  </span>
	  <span>
	  <a href="#commentParty" data-toggle="modal" class="btn btn-primary fr">[ message]</a>
				<a href="<c:url value="/member/joinParty" />?partyId=${party.id}"> <button class="btn btn-success fr mb20">Join</button></a>
	  </span>
	  </span>
	     <ul>
          <li> 
              <img src="<c:url value="${party.icon}"/>" alt="Image" style="width: 100%"/>
          </li>
        </ul>
        <div class="party_info">
        <p class="text-primary tc">
		  ${party.title }
		</p>
		<p class="text-primary"><span class="color_f63 fb">活动发起人：</span>
		   
		   <a href="<c:url value="/viewMemberInfo"/>?memberId=${member.id}">
										${member.name} 
		   </a>
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
		<div class="media-body">
		   <span class="color_f63 fb">活动总结：</span>
		   ${party.description }
		</div>
        
        </div>
     <div class="row goods-detail-desc">
			<div class="xm-box goods-detail-comment " id="goodsComment">
				<div class="box-hd">
					<div class="title">用户评价</div>
				</div>
				<div class="box-bd" id="J_goods_detail_comment">
					<div class="com-body">
						<ul class="content">
						 <c:if test="${evalutes!=null}">
	       <c:forEach items="${evalutes }" var="evalute">
	     
	           <li>
								<div class="article">
									<h2 class="art_title clearfix"> 
									<div class="leftPart">  ${evalute.remark }  </div> 
									<div class="rightPart">   <fmt:formatDate value="${evalute.createTime}" pattern="yyyy-MM-dd HH:mm"/>   </div> 
									</h2>
									<div class="art_content">${evalute.content}</div>
									<div class="art_info clearfix">
										<div class="rightPart">
											<a href="<c:url value="/web/partyCommentDetail"/>?partyId=${party.id}&evaluateId=${evalute.id}"
												target="_blank">阅读全文</a> <span class="separator">|</span> <a
												href="<c:url value="/web/partyCommentDetail"/>?partyId=${party.id}&evaluateId=${evalute.id}#reply"
												target="_blank">回复</a>(${evalute.replyCount})
										</div>
									</div>
								</div>
								<div class="head_photo">
									 <a target="_blank"
										href="<c:url value="/viewMemberInfo"/>?memberId=${evalute.memberId}"><h3 class="name">${evalute.memberName}</h3></a>
								</div>
							</li>
	           
	           </c:forEach>
	     </c:if>
							
						</ul>
					</div>
				</div>
			</div>


</div>
	  </div>
	   <div class="col-md-3">
	   <span class="party_title">Member of Join</span>
	   <ul class="party_join_member">
	   <c:if test="${acountInfos!=null }">
					  <c:forEach var="acountInfo" items="${acountInfos }" varStatus="statu">
					     <li>
							<span class="img photo"> <a 
									href="<c:url value="/viewMemberInfo"/>?memberId=${acountInfo.id}">
										<img width="69" height="43"
										src="<c:url value="${acountInfo.photo }"/>"
										alt="${acountInfo.name }" class="avatar">
								</a>
							</span>
							<span class="member_info">
							<div class="name">${acountInfo.name }</div>
							<div class="schoolName">${acountInfo.schoolName }</div>
							</span>
						</li>
					  </c:forEach>
		</c:if>
	   </ul>
	   </div>
  </div>

	
	
</div>


	              <!-- Modal -->
<div class="modal fade" id="commentParty">
 		<div class="modal-dialog panel-primary">
          <div class="modal-content">
            <div class="modal-header panel-heading">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
              <h4 class="modal-title">reply：</h4>
            </div>
            <form class="form-horizontal" action="<c:url value="/member/subEvalute"/>">
				<div class="modal-body">
					<input  type="hidden" name="evaluateProductType" value="1"/>
                    <input  type="hidden" name="evaluateProductId" value="${party.id}"/>
                    <input  type="hidden" name="evaluateProductMemberId" value="${party.memberId}"/>
					<div class="form-group">
						<label class="col-lg-2 control-label">replyContent：</label>
						<div class="col-lg-10">
						 <textarea class="form-control" name="content" id="message" cols="50" rows="5" required="required" placeholder="reply:  ${member.name}"></textarea>
         
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

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
	   <div class="row">
	   <div class="comment-content">
                <div class="comment-content-title">
                    评价内容
                </div>
                <div class="comment-content-detail">
                    <div class="article">
                        <h3 class="art_star clearfix">
                            <div class="leftPart">
                                <span class="icon-stat icon-stat-5"></span>
                            </div>
                            <div class="rightPart">
                                2014年04月06日                            </div>
                        </h3>
                        <h2 class="art_title clearfix">
                            <div class="leftPart">
                                我的是红米手机，2A...                            </div>
                            <div class="rightPart">
                                来自于小米网                            </div>
                        </h2>
                        <ul class="art_tags clearfix">
                                                    </ul>
                        <div class="art_content J_mi_art_content">我的是红米手机，2A的电池不知道在红米上好用不，有什么要求吗？看着电池很好，赞一个。</div>
                        
                        
                        <div class="art_info clearfix">
                            <div class="leftPart">
                                                                100%的用户认为此评论有用  
                                <span class="separator">|</span> 
                                                                此评价是否有用？    
                                <span class=" usebtn J_use" data-id="3282404">有用</span>
                                <div class=" usebtn J_unuse" data-id="3282404">没用</div>
                            </div>
                            
                        </div>
                                                <div class="art_reply"> <i>官方回复：</i>类似于小米手机用万能充，虽然都可以充电，但是最好还是使用原装的，因为毕竟不是专门根据红米设计的，所以，我建议还是用红米电池，感谢您的支持。</div>
                                                <div class="article_answer J_art_answer">
                            <h3>我要回复</h3>
                            <div class="answer-input-bar">
                                <input type="text" class="input-frame J_mi_reply_input">
                                <a href="" class="btn btn-dake answer-submit J_mi_reply_btn">提交</a>
                            </div>
                            <ul class="answer-list J_mi_comment_replay"><li><div class="author clearfix"><div class="leftPart">189830719</div></div><p>2A的电池配上座充，可以用在红米电信上面吗？</p><div class="reply_footer  clearfix"><div class="rightPart">2014年05月20日&nbsp;&nbsp;&nbsp;&nbsp;<a href="" class="J_mi_reply_reply_btn">[ 回复]</a></div></div><div class="reply_input hide J_mi_reply_reply_input"><input type="text" class="input_frame" placeholder="回复:189830719&nbsp;&nbsp;"><a class="btn btn-dake J_mi_reply_reply_confirmBtn" data-parentid="971">确认</a></div></li></ul>
                            <div class="answer-more J_mi_comment_reply_more" style="display: none;">
                                
                                <a href="" class="">查看更多</a>
                            </div>
                        </div>
                    </div>
                    <div class="head_photo">
                        <img src="https://account.xiaomi.com/static/img/passport/photo.jpg" alt="">
                        <h3 class="name">252354120</h3>
                        
                    </div>      
                </div>
                
            </div>
	</div>
</div>

</div>


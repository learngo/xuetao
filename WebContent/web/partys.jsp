<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/buy.css"/>" />

<div class="party-carousel">
    <div id="carousel-example-generic" class="carousel slide">
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        </ol>
        <div class="carousel-inner">
            <div class="item active">
                <div class="good_bg party_bg">
                    <div class="container">
                        <div class="party-wrap">
                            <div class="party-title">
                                <span class="icon-location"></span>
                                <span class="party_bg_title"> Travel experiences to share about Portugal Obidos</span>
                            </div>
                            <span class="good_bg_total_money">
                                <p class="party-icon-sum"></p>
                                <p class="">Sum in Party</p>
                                <p >(${totalSum })</p>
                            </span>
                            <span class="good_bg_total_sum">
                                <p class="party-icon-time"></p>
                                <p>Start time</p>
                                <p class="month">December 1</p>
                                <p class="time">8:00</p>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="good_bg party_bg">
                    <div class="container">
                        <div class="party-wrap">
                            <div class="party-title">
                                <span class="icon-location"></span>
                                <span class="party_bg_title"> Travel experiences to share about Portugal Obidos</span>
                            </div>
                            <span class="good_bg_total_money">
                                <p class="party-icon-sum"></p>
                                <p class="">Sum in Party</p>
                                 <p >(${totalSum })</p>
                            </span>
                            <span class="good_bg_total_sum">
                                <p class="party-icon-time"></p>
                                <p>Start time</p>
                                <p class="month">December 1</p>
                                <p class="time">8:00</p>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



<div class="container">
<div class="row">
		<div class="works">
            <ul class="party-type">
                <li class="active"><a href="<c:url value="/web/partys"/>">All</a></li>
            </ul>
			<ul>
				<c:if test="${partys!= null}">
					<c:forEach var="party" varStatus="status" items="${partys}">
						<li class="work">
							<div class="work_image">
								<a href="<c:url value="/web/partyDetail?partyId=${party.id}"/>">
									 <img src="<c:url value="${party.icon}"/>" alt="${party.title}"/>
								</a>
							</div>
							<div class="work_title">
								<span class="work_disc">
									<p class="work_disc_name">
									  ${party.title}
									</p>
									<p>
									 <c:if test="${party.state==0 }">
									 进行中
									</c:if>
									<c:if test="${party.state==1 }">已经结束
									</c:if>
									
									</p>
								</span>
							    <span class="party_users">${party.joinSum}</span>
							</div>
                            <div class="user">
                                <img src="${party.memberPhoto}" class="avatar"/>
                            </div>
						</li>
					</c:forEach>
				</c:if>
				<c:if test="${partys== null}">
						<div class="jumbotron">
				          <h1 id="jumboheader">抱歉，没有您需要的活动</h1>
				      </div>
			   </c:if>
			</ul>
		</div>
	</div>


    <div class="pagebar">
	     <c:if test="${commPage!=null}">
	     ${commPage}
	    </c:if>
    </div>
    
    
</div>




<script>
$(document).ready(function(){
    $('.carousel').carousel();
    $('.nav .party').addClass('active');
});
$('#tooltip-right').tooltip();
</script>
 
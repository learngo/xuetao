<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/buy.css"/>" />

<div class="good_bg">
<div class="container">
   <span class="good_bg_title">
   Maybe you don't need ,is looking for thers
   </span>
   <span class="good_bg_total_sum">
        <p class="good_bg_total_sum_icon"></p>
        <p class=""> All the goods</p>
        <p >(1473)</p>
   </span>
   <span class="good_bg_total_money">
        <p class="good_bg_total_money_icon"></p>
        <p class=""> All the goods</p>
        <p >(1473)</p>
   </span>
 </div>
</div>
<div class="container">
<div class="row">
		<div class="works">

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
								<span class="work_price"> 
								<span class="work_price_sum">
										${party.joinSum}</span>
								</span>
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



    <div class="col-md-12">
		<div class="row">
			<ul class="pager">
			    <c:if test="${isPre==1 }">
				<li class="previous"><a href="<c:url value="/web/partys"/>?curPage=${curPage-1}&pageSize=12">&larr; 上一页</a></li>
				</c:if>
				<c:if test="${isNext==1 }">
				<li class="next"><a href="<c:url value="/web/partys"/>?curPage=${curPage+1}&pageSize=12"">下一页 &rarr;</a></li>
				</c:if>
		   </ul>
		</div>


      
    </div>
    

</div>




<script>
$('#tooltip-right').tooltip();
</script>
 
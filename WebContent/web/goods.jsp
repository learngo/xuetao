<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/buy.css"/>" />
<div class="good_bg">
    <div class="container">
       <span class="good_bg_title">
       Maybe you don't need ,is looking for thers
       </span>

       <span class="good_bg_total_money">
            <p class="good_bg_total_money_icon"></p>
            <p class=""> All the goods</p>
            <p >(${totalSum })</p>
       </span>
       <span class="good_bg_total_sum">
        <p class="good_bg_total_sum_icon"></p>
        <p class=""> All the goods</p>
        <p >(${totalSum })</p>
       </span>
     </div>
</div>
<div class="container">
	<div class="row">
		<div class="works">

			<ul>
				<li class="work nav_goods">
					<div class="list-group">
						<a href="<c:url value="/web/goods"/>"
							class="list-group-item tc">Category</a>
						<c:if test="${categorys!=null }">
							<c:forEach var="category" varStatus="status" items="${categorys}">
								<a  categoryId='${category.id}'href="<c:url value="/web/goods"/>?categoryId=${category.id}"
									class="list-group-item"> <span class="nav_love_icon"></span>
									${category.name} <span class="nav_right_icon"></span>
								</a>
							</c:forEach>
						</c:if>
                        <div class="moreItem">
                            <a class="list-group-item" href="/xuetao/web/goods" categoryid="">
                                <span class="nav_love_icon"></span>
                                more goods <span class="nav_right_icon"></span>
                            </a>
                            <a class="list-group-item" href="/xuetao/web/goods" categoryid="">
                                <span class="nav_love_icon"></span>
                                more goods <span class="nav_right_icon"></span>
                            </a>
                        </div>
						<a href="javascript:;" class="list-group-item more">
							<span class="nav_more_icon"></span>
						</a>
					</div>
				</li>

				<c:if test="${goods!= null}">
					<c:forEach var="good" varStatus="status" items="${goods}">
						<li class="work">
							<div class="work_image">
								<a href="<c:url value="/web/goodDetail?goodId=${good.goodId}"/>">
									<img alt="${good.name }" src="<c:url value="${good.logo}"/>">
								</a>
							</div>
							<div class="work_title">
								<span class="work_disc">
									<p class="work_disc_name">${good.name }</p>
									<p class="work-des">${good.title}</p>
								</span> <span class="work_price"> <span class="work_price_sum">$
										${good.price }</span>
								</span>
							</div>
                            <div class="user">
                                <img src="<c:url value="/"/>${good.memberPhoto }" class="avatar"/>
                            </div>
						</li>
					</c:forEach>
				</c:if>

			</ul>
		</div>
	</div>
	<div class="row">
        <!--
		<ul class="pager">
			<c:if test="${isPre==1 }">
				<li class="previous">
                    <a  href="<c:url value="/web/goods"/>?curPage=${curPage-1}&pageSize=12&categoryId=${categoryId}">&larr;pre</a>
                </li>
			</c:if>
			<c:if test="${isNext==1 }">
				<li class="next">
                    <a href="<c:url value="/web/goods"/>?curPage=${curPage+1}&pageSize=12&categoryId=${categoryId}">next&rarr;</a>
                </li>
			</c:if>
		</ul>
        
        <div class="pagenation">
            <a href="<c:url value="/web/goods"/>?curPage=${curPage-1}&pageSize=12&categoryId=${categoryId}" class="prev">&nbsp;</a>
            <a  href="javascript:;" class="active">1</a>
            <a  href="javascript:;">2</a>
            <a  href="javascript:;">3</a>
            <a  href="javascript:;">2</a>
            <span class="dot">...</span>
            <a  href="javascript:;">10</a>
            <a  href="javascript:;">20</a>
            <a  href="javascript:;">30</a>
            <a href="<c:url value="/web/goods"/>?curPage=${curPage+1}&pageSize=12&categoryId=${categoryId}" class="next">&nbsp;</a>
        </div>
        -->
        <div class="pagebar">
		     <c:if test="${commPage!=null}">
		     ${commPage}
		    </c:if>
   		</div>
	</div>
</div>




<script>
$(function(){
    $('.nav .goods').addClass('active');
    var cId='<c:out value="${categoryId}"/>';
    if(cId!=''){
        $('a[categoryId='+cId+']').addClass('active');
    }
    $('.nav_goods .more').click(function(e){
        e.stopPropagation();
        $('.moreItem').slideDown();
        $(this).hide();
    });
    $(document).click(function(){
        $('.moreItem').slideUp();
        $('.nav_goods .more').show();
    });
    //$('#tooltip-right').tooltip();
});

</script>

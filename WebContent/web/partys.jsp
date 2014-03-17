<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/buy.css"/>" />

<div class="breadcrumbrow">
		<div class="container">
			<ul class="breadcrumb">
				<li><a href='<c:url value="/"></c:url>'>首页</a></li>
				<li class="active"><a href="#">活动</a></li>
			</ul>
		</div>
	</div>
<div class="container">
	<div class="col-md-3">
      <div class="list-group">
        <a href="#" class="list-group-item active">类型</a>
        <a href="#" class="list-group-item">科技比赛</a>
        <a href="#" class="list-group-item">交友活动</a>
        <a href="#" class="list-group-item">旅游活动</a>
        <a href="#" class="list-group-item">社团活动</a>
      </div>
    </div>
    <div class="col-md-9 content">
       <div class="leading">
        <h2>活动中心
        <a data-toggle="tooltip" title="bottom tooltip" data-placement="right" 
           id="tooltip-right"><small>帮助中心</small></a></h2>
      </div>
  
      
      
    <div class="row-fluid">
			<ul class="unstyled product-sources">
				
				
			   <c:if test="${partys!= null}">
					<c:forEach var="party" varStatus="status" items="${partys}">
						<li class="product-source"><a href="buy-card.jsp">
								<span class="img thumbnail"> 
							    <img src="<c:url value="${party.icon}"/>" alt="${party.title}" width="160" height="98"/>
							</span> <span class="name">${party.title}</span> <span class="info">参加人数（${party.joinSum}）</span>
						</a>
						</li>
					</c:forEach>
				</c:if>
				
				
				
				
				
				
				
			</ul>
		</div>
		<div class="row">
			<ul class="pager">
				<li class="previous"><a href="<c:url value="/web/partys"/>?curPage=${curPage-1}&pageSize=12">&larr; 上一页</a></li>
				<li class="next"><a href="<c:url value="/web/partys"/>?curPage=${curPage+1}&pageSize=12"">下一页 &rarr;</a></li>
			</ul>
		</div>


      
    </div>
    

</div>




<script>
$('#tooltip-right').tooltip();
</script>
 
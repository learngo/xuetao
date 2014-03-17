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
        <a href="#" class="list-group-item">乐器</a>
        <a href="#" class="list-group-item">图书</a>
        <a href="#" class="list-group-item">衣服</a>
        <a href="#" class="list-group-item">自行车</a>
      </div>
    </div>
    <div class="col-md-9 content">
       <div class="leading">
        <h2>活动中心
        <a data-toggle="tooltip" title="bottom tooltip" data-placement="right" 
           id="tooltip-right"><small>帮助中心</small></a></h2>
      </div>
  
      
      
			<div class="row-fluid">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>标题</th>
							<th class="tr">价格</th>
						</tr>
					</thead>
					<tbody>
						
						
							
			   <c:if test="${goods!= null}">
					<c:forEach var="good" varStatus="status" items="${goods}">
						<tr>
							<td><span class="img"> <a
									href="<c:url value="${good.logo }"/>">
										<img width="69" height="43"
										src="<c:url value="${good.logo}"/>"
										alt="${good.name}">
								</a>
							</span></td>
							<td>
							 <p><h3>${good.name }</h3></p>
							 <p>${good.title}</p>
							</td>
							<td class="tr"><span class="badge badge-danger">${good.price }</span>元</td>
						</tr>
						
						
						
					</c:forEach>
				</c:if>
					
					</tbody>
				</table>

		</div>
		<div class="row">
			<ul class="pager">
				<li class="previous"><a href="<c:url value="/web/goods"/>?curPage=${curPage-1}&pageSize=12">&larr; 上一页</a></li>
				<li class="next"><a href="<c:url value="/web/goods"/>?curPage=${curPage+1}&pageSize=12"">下一页 &rarr;</a></li>
			</ul>
		</div>

      
    </div>
    

</div>




<script>
$('#tooltip-right').tooltip();
</script>
 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/buy-card.css"/>" />

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
		<p class="text-primary tc">${party.title }</p>
		<div class="media-body">
			<h4 class="media-heading">${party.updateTime}</h4>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${party.description }
		</div>
	</div>
	<div class="col-md-9 content">
		<div class="leading">
			<h2>
				参加成员 <a data-toggle="tooltip" title="bottom tooltip"
					data-placement="right" id="tooltip-right"><small>帮助中心</small></a>
			</h2>
		</div>
		


		<div class="row-fluid">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>First Name</th>
							<th>Last Name</th>
							<td>Doe</td>
							<th class="tr">Username</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><span class="img"> <a itemprop="url"
									href="<c:url value="/resources/web/images/buy/lands-end.png"/>">
										<img width="69" height="43"
										src="<c:url value="/resources/web/images/buy/lands-end.png"/>"
										itemprop="image"
										data-src="https://s3.amazonaws.com/assets.coupontrade.com/assets/product-sources/269/thumb/lands-end.png?1370009162"
										alt="Buy Lands' End Gift Card">
								</a>
							</span></td>
							<td>John</td>
							<td>Smith</td>
							<td>Doe</td>
							<td class="tr"><button class="btn btn-success">Success</button></td>
						</tr>
						<tr>
							<td><span class="img"> <a itemprop="url"
									href="<c:url value="/resources/web/images/buy/lands-end.png"/>">
										<img width="69" height="43"
										src="<c:url value="/resources/web/images/buy/lands-end.png"/>"
										itemprop="image"
										data-src="https://s3.amazonaws.com/assets.coupontrade.com/assets/product-sources/269/thumb/lands-end.png?1370009162"
										alt="Buy Lands' End Gift Card">
								</a>
							</span></td>
							<td>John</td>
							<td>Smith</td>
							<td>Doe</td>
							<td class="tr"><button class="btn btn-success">Success</button></td>
						</tr>
						<tr>
							<td><span class="img"> <a itemprop="url"
									href="<c:url value="/resources/web/images/buy/lands-end.png"/>">
										<img width="69" height="43"
										src="<c:url value="/resources/web/images/buy/lands-end.png"/>"
										itemprop="image"
										data-src="https://s3.amazonaws.com/assets.coupontrade.com/assets/product-sources/269/thumb/lands-end.png?1370009162"
										alt="Buy Lands' End Gift Card">
								</a>
							</span></td>
							<td>John</td>
							<td>Smith</td>
							<td>Doe</td>
							<td class="tr"><button class="btn btn-success">Success</button></td>
						</tr>
					</tbody>
				</table>
		</div>


	</div>


</div>




<script>
	$('#tooltip-right').tooltip();
</script>

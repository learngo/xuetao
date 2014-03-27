<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />

<div class="breadcrumbrow">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href='<c:url value="/"></c:url>'>Home</a></li>
			<li class="active"><a href="browseGood">Browse Good</a></li>
		</ul>
	</div>
</div>
<div class="container">
	<div class="col-md-3">
		<div class="list-group">
			<a href="settings" class="list-group-item ">
			  <span class="glyphicon glyphicon-cog"></span>
			   member base info
			</a> 
			
			<a href="password" class="list-group-item">
			  <span class="glyphicon glyphicon-lock"></span>
			 modify  password 
			</a> 
			<a href="email" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			  set  email
			</a> 
			<a href="addGood" class="list-group-item ">
			  <span class="glyphicon glyphicon-envelope"></span>
			   add good
			</a> 
			<a href="browseGood" class="list-group-item active">
			  <span class="glyphicon glyphicon-envelope"></span>
			   browse goods
			</a> 
			<a href="party" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			   add party
			</a> 
			<a href="browseParty" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			     browse partys
			</a> 
		</div>
	</div>
	<div class="col-md-9 content">
		<div class="row">
			<div class="panel panel-default panel-col">
			     <div class="panel-heading">Information</div>
			     <div class="panel-body">
					<table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>Logo</th>
            <th>name</th>
            <th>title</th>
            <th>price</th>
            <th>level</th>
            <th>manager</th>
          </tr>
        </thead>
        <tbody>
							
							<c:if test="${goods!=null }">
								<c:forEach var="good" varStatus="status"
									items="${goods}">
									<tr>
										<td>${good.goodId }</td>
										<td>${good.name }</td>
										<td>${good.title }</td>
										<td>${good.price }</td>
										<td>${good.level }</td>
										<td><a href="deleteGood?goodId=${good.goodId }">delete</a> 
										<a href="<c:url value="/web/goodDetail?goodId=${good.goodId}"/>">view</a>
										<!-- <a href="addGood?goodId=${good.goodId}">view</a> -->
										
										</td>
									</tr>
								</c:forEach>
							</c:if>



						</tbody>
      </table>



				</div>
			</div>
		</div>
	</div>


</div>




<script>
	$('#tooltip-right').tooltip();
</script>

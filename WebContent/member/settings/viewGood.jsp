<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />

<div class="breadcrumbrow">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href='<c:url value="/"></c:url>'>首页</a></li>
			<li class="active"><a href="browseGood">浏览商品</a></li>
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
			<a href="addGood" class="list-group-item active">
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
		<div class="row-fluid">
			<div class="panel panel-default panel-col">
			     <div class="panel-heading">View Good info</div>
			     <div class="panel-body">
					<form  class="form-horizontal" enctype="multipart/form-data" method="post" action="submitGood">

						<div class="form-group">
							<label class="col-md-2 control-label" for="profile_truename">Good Name：</label>
							<div class="col-md-7 controls">
								<input type="text" class="form-control" value="${goodView.name }" readonly="readonly">
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label class="required">Category：</label>
							</div>
							<div class="col-md-7 controls radios">
								<input type="text" class="form-control" value="${goodView.category }" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label class="required">Color：</label>
							</div>
							<div class="col-md-7 controls radios">
								
								<input type="text" class="form-control" value="${goodView.level }" readonly="readonly">
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_company">Logo:</label>
							</div>
							<div class="col-md-7 controls">
								<img alt="" src="<c:url value="${goodView.logo }"></c:url>">
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_job">Price:</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" class="form-control" value="${goodView.price }" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_job">Title:</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" class="form-control" value="${goodView.title }" readonly="readonly">
							</div>
						</div>

						

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_about">Description：</label>
							</div>
							<div class="col-md-7 controls">
								<textarea  name="description"
									class="form-control" rows="20" >${goodView.description }</textarea>
							</div>
						</div>
						
					</form>



				</div>
			</div>
		</div>
	</div>


</div>




<script>
	$('#tooltip-right').tooltip();
</script>

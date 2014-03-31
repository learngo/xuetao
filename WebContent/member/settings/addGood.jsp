<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />

<div class="breadcrumbrow">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href='<c:url value="/"></c:url>'>home</a></li>
			<li class="active"><a href="addGood">add good</a></li>
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
			<a href="addGood" class="list-group-item active">
			  <span class="glyphicon glyphicon-envelope"></span>
			   add good
			</a> 
			<a href="browseGood" class="list-group-item">
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
			     <div class="panel-heading">Add Good</div>
			     <div class="panel-body">
					<form  class="form-horizontal" enctype="multipart/form-data" method="post" action="submitGood">

						<div class="form-group">
							<label class="col-md-2 control-label" for="profile_truename">Good Name：</label>
							<div class="col-md-7 controls">
								<input type="text" id="profile_truename"
									name="name" class="form-control" required="required"/>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label class="required">Category：</label>
							</div>
							<div class="col-md-7 controls radios">
								<div id="profile_gender">
									<select name="categoryId">
									 <c:if test="${categorys!=null }">
							          <c:forEach var="category" varStatus="status" items="${categorys}">
									     <option value="${category.id}">${category.name}</option>
									  </c:forEach>
							        </c:if>
							        </select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label class="required">Color：</label>
							</div>
							<div class="col-md-7 controls radios">
								<div id="profile_gender">
									<input type="radio" 
										name="level" required="required" value="1" />
										<label 
										 class="required">brand new</label>
										<input
										type="radio"  name="level"
										required="required" value="2" />
										<label class="required">barely used</label>
										<input
										type="radio"  name="level"
										required="required" value="3" />
										<label
										for="profile_gender_1" class="required"> used</label>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_company">Good Logo</label>
							</div>
							<div class="col-md-7 controls">
								<input type="file"  name="file"
									class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_company">IMG 1</label>
							</div>
							<div class="col-md-7 controls">
								<input type="file"  name="file1"
									class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_company">IMG2</label>
							</div>
							<div class="col-md-7 controls">
								<input type="file"  name="file2"
									class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_company">IMG 3</label>
							</div>
							<div class="col-md-7 controls">
								<input type="file"  name="file3"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_job">Price</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" name="price"
									class="form-control" required="required"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_job">Title:</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" name="title"
									class="form-control" required="required"/>
							</div>
						</div>

						

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_about">DES：</label>
							</div>
							<div class="col-md-7 controls">
								<textarea  name="description"
									class="form-control" rows="20" required="required"></textarea>
							</div>
						</div>

					



						<div class="row">
							<div class="col-md-7 col-md-offset-2">
								<button type="submit" class="btn btn-primary">Save</button>
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

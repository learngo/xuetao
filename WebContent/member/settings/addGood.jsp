<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />

<div class="breadcrumbrow">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href='<c:url value="/"></c:url>'>首页</a></li>
			<li class="active"><a href="#">添加商品</a></li>
		</ul>
	</div>
</div>
<div class="container">
	<div class="col-md-3">
		<div class="list-group">
			<a href="settings" class="list-group-item ">
			  <span class="glyphicon glyphicon-cog"></span>
			   基本信息
			</a> 
			
			<a href="password" class="list-group-item">
			  <span class="glyphicon glyphicon-lock"></span>
			   密码修改
			</a> 
			<a href="email" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			   邮箱设置
			</a> 
			<a href="addGood" class="list-group-item active">
			  <span class="glyphicon glyphicon-envelope"></span>
			   添加商品
			</a> 
			<a href="browseGood" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			   浏览商品
			</a> 
			<a href="party" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			   添加活动
			</a> 
			<a href="browseParty" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			   浏览活动
			</a> 
		</div>
	</div>
	<div class="col-md-9 content">
		<div class="row-fluid">
			<div class="panel panel-default panel-col">
			     <div class="panel-heading">添加商品信息</div>
			     <div class="panel-body">
					<form  class="form-horizontal" enctype="multipart/form-data" method="post" action="submitGood">

						<div class="form-group">
							<label class="col-md-2 control-label" for="profile_truename">商品名称：</label>
							<div class="col-md-7 controls">
								<input type="text" id="profile_truename"
									name="name" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label class="required">分类：</label>
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
								<label class="required">成色：</label>
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
								<label for="profile_company">首页图片</label>
							</div>
							<div class="col-md-7 controls">
								<input type="file"  name="file"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_job">价格</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" name="price"
									class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_job">标题</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" name="title"
									class="form-control" />
							</div>
						</div>

						

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_about">描述：</label>
							</div>
							<div class="col-md-7 controls">
								<textarea  name="description"
									class="form-control" rows="20"></textarea>
							</div>
						</div>

					



						<div class="row">
							<div class="col-md-7 col-md-offset-2">
								<button type="submit" class="btn btn-primary">保存</button>
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

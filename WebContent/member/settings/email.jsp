<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />

<div class="breadcrumbrow">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href='<c:url value="/"></c:url>'>首页</a></li>
			<li class="active"><a href="#">设置</a></li>
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
			<a href="email" class="list-group-item active">
			  <span class="glyphicon glyphicon-envelope"></span>
			   邮箱设置
			</a> 
			<a href="addGood" class="list-group-item">
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
				<div class="panel-heading">邮箱设置</div>
				<div class="panel-body">
					<form id="setting-email-form" class="form-horizontal" method="post" action="modifyEmail">


						<div class="form-group">
							<div class="col-md-2 control-label">
								<label>当前登录邮箱</label>
							</div>
							<div class="col-md-8 controls">
								<c:if test="${sessionScope.UserConstant_VISITOR != null}">
								  <input type="text"  class="form-control"  value="${sessionScope.UserConstant_VISITOR.email}" readonly="readonly"/>
				                 </c:if>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="form_password" class="required">网站登录密码</label>
							</div>
							<div class="col-md-8 controls">
								<input type="password" name="password"
									required="required" class="form-control" />
								<p class="help-block">设置新的登录邮箱，需要校验当前的网站登录密码</p>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="form_email" class="required">新登录邮箱</label>
							</div>
							<div class="col-md-8 controls">
								<input type="text"  name="newEmail"
									required="required" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label"></div>
							<div class="col-md-8 controls">
								<button type="submit" class="btn btn-primary">提交</button>
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

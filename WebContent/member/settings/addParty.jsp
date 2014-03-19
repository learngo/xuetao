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
			<a href="settings.jsp" class="list-group-item active">
			  <span class="glyphicon glyphicon-cog"></span>
			   基本信息
			</a> 
			
			<a href="password.jsp" class="list-group-item">
			  <span class="glyphicon glyphicon-lock"></span>
			   密码修改
			</a> 
			<a href="email.jsp" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			   邮箱设置
			</a> 
			<a href="addGood" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			   添加商品
			</a> 
			<a href="browseGood.jsp" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			   浏览商品
			</a> 
			<a href="addParty.jsp" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			   添加活动
			</a> 
			<a href="browseParty.jsp" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			   浏览活动
			</a> 
		</div>
	</div>
	<div class="col-md-9 content">
		<div class="row-fluid">
			<div class="panel panel-default panel-col">
			     <div class="panel-heading">添加活动</div>
			     <div class="panel-body">
					<form id="user-profile-form" class="form-horizontal" method="post">

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label class="required">学校：</label>
							</div>
							<div class="col-md-7 controls radios">
								<div id="profile_gender">
									<select>
									  <option>鼠标</option>
									  <option>计算机</option>
									  <option>图书</option>
									  <option>自行车</option>
									  <option>洗衣机</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label" for="profile_truename">活动标题：</label>
							<div class="col-md-7 controls">
								<input type="text" id="profile_truename"
									name="profile[truename]" class="form-control" />
							</div>
						</div>


						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_company">图片</label>
							</div>
							<div class="col-md-7 controls">
								<input type="file" id="file" name="logo"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_job">开始时间</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" id="profile_job" name="startTime"
									class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_job">结束时间</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" id="profile_job" name="endTime"
									class="form-control" />
							</div>
						</div>

						

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_about">描述：</label>
							</div>
							<div class="col-md-7 controls">
								<textarea id="profile_about" name="profile[about]"
									class="form-control"></textarea>
							</div>
						</div>

					


						<div class="row">
							<div class="col-md-7 col-md-offset-2">
								<input type="hidden" id="profile__token" name="profile[_token]"
									value="a038bb52643745355e903084ae4e70558d3761c7" />
								<button type="submit" class="btn btn-primary">保存</button>
							</div>
						</div>

						<input type="hidden" name="_csrf_token"
							value="5ecd77f7b2416b573faa519e6622362a87b0ecd8">
					</form>



				</div>
			</div>
		</div>
	</div>


</div>




<script>
	$('#tooltip-right').tooltip();
</script>

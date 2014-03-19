<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />

<div class="breadcrumbrow">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href='<c:url value="/"></c:url>'>首页</a></li>
			<li class="active"><a href="<c:url value="/member/settings/settings"/>">设置</a></li>
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
			     <div class="panel-heading">基础信息</div>
			     <div class="panel-body">
					<form id="user-profile-form" class="form-horizontal" method="post">

						<div class="form-group">
							<label class="col-md-2 control-label" for="profile_truename">头像</label>
							<div class="col-md-7 controls">
								<img src="<c:url value="${member.photo}"/>" alt="${party.title}" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label" for="profile_truename">姓名</label>
							<div class="col-md-7 controls">
								<input type="text" id="profile_truename"
									name="name" class="form-control" value="${member.name }"/>
							</div>
						</div>

			

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label class="required">性别</label>
							</div>
							<div class="col-md-7 controls radios">
								<div id="profile_gender">
									
								  <c:if test="${member.sex == '男' }">
								   <input type="radio" 
										name="sex"  value="男" checked="checked"/>
									<label>男</label>
								  <input
										type="radio"  name="sex" value="女" />
								  <label>女</label>
								  </c:if>
								  <c:if test="${member.sex == '女' }">
								   <input type="radio" 
										name="sex"  value="男" />
									<label>男</label>
								  <input
										type="radio"  name="sex" value="女" checked="checked"/>
								  <label>女</label>
								  </c:if>
								  
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_company">学校</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" id="profile_job" name="schoolName"
									class="form-control" value="${v.schoolName }" readonly="readonly"/>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_job">专业</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" id="profile_job" name="major"
									class="form-control" value="${member.major }"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_weixin">电话</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" id="profile_site" name="phone"
									class="form-control" value="${member.phone }"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_weixin">邮箱</label>
							</div>
							<div class="col-md-7 controls">
								<input type="text" id="profile_site" name="email"
									class="form-control" value="${member.email }"/>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_about">自我介绍</label>
							</div>
							<div class="col-md-7 controls">
								<textarea id="profile_about" name="description"
									class="form-control" rows="20">${member.description }</textarea>
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

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-datetimepicker.min.css"/>" />
<div class="breadcrumbrow">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href='<c:url value="/"></c:url>'>首页</a></li>
			<li class="active"><a href="<c:url value="/member/settings/addParty"/>">add party </a></li>
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
			<a href="addGood" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			   添加商品
			</a> 
			<a href="browseGood" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			   浏览商品
			</a> 
			<a href="party" class="list-group-item active">
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
			     <div class="panel-heading">添加活动</div>
			     <div class="panel-body">
					<form  class="form-horizontal" enctype="multipart/form-data" method="post" action="submitParty">

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label class="required">学校：</label>
							</div>
							<div class="col-md-7 controls radios">
								<div id="profile_gender">
								  <select name="schoolId">
									 <c:if test="${schooles!=null }">
							          <c:forEach var="school" varStatus="status" items="${schooles}">
									     <option value="${ school.id}">${school.name}</option>
									  </c:forEach>
							        </c:if>
							        </select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label" for="profile_truename">活动标题：</label>
							<div class="col-md-7 controls">
								<input type="text"
									name="title" class="form-control" />
							</div>
						</div>


						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_company">图片</label>
							</div>
							<div class="col-md-7 controls">
								<input type="file" id="file" name="file"
									class="form-control" />
							</div>
						</div>
				       <div class="form-group">
				              <label for="startTime" class="col-md-2 control-label">开始时间</label>
				              <div class="input-group date form_datetime col-md-5"  data-date="" data-date-format="yyyy-mm-dd hh:ii" data-link-field="startTime">
				                  <input class="form-control" size="16" type="text" value="" readonly>
				                  <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
							<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
				              </div>
						<input type="hidden" class="input-sm form-control" name="startTime" id="startTime" />
				       </div>
				       <div class="form-group">
				              <label for="dtp_input1" class="col-md-2 control-label">结束时间</label>
				              <div class="input-group date form_datetime col-md-5"  data-date="" data-date-format="yyyy-mm-dd hh:ii" data-link-field="endTime">
				                  <input class="form-control" size="16" type="text" value="" readonly>
				                  <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
							<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
				              </div>
						<input type="hidden" class="input-sm form-control" name="endTime" id="endTime" />
				       </div>
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_about">描述：</label>
							</div>
							<div class="col-md-7 controls">
								<textarea id="profile_about" name="description"
									class="form-control" rows="10"></textarea>
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
<script src="<c:url value="/resources/js/bootstrap-datetimepicker.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/locales/bootstrap-datetimepicker.zh-CN.js"/>" type="text/javascript"></script>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
        showMeridian: 1
    });
	$('#tooltip-right').tooltip();
</script> 


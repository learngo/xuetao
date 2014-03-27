<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-datetimepicker.min.css"/>" />
<div class="breadcrumbrow">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href='<c:url value="/"></c:url>'>Home</a></li>
			<li class="active"><a href="<c:url value="/member/settings/browseParty"/>">browse party </a></li>
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
			<a href="addGood" class="list-group-item">
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
			<a href="browseParty" class="list-group-item active">
			  <span class="glyphicon glyphicon-envelope"></span>
			     browse partys
			</a> 
		</div>
	</div>
	<div class="col-md-9 content">
		<div class="row-fluid">
			<div class="panel panel-default panel-col">
			     <div class="panel-heading">View Party</div>
			     <div class="panel-body">
					<form  class="form-horizontal" enctype="multipart/form-data" method="post" action="submitParty">

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label class="required">School：</label>
							</div>
							<div class="col-md-7 controls radios">
							<div class="col-md-7 controls">
								<input type="text" class="form-control" value="${school.name }" readonly="readonly">
							</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label" for="profile_truename">Title：</label>
							<div class="col-md-7 controls">
								<input type="text" class="form-control" value="${party.title }" readonly="readonly">
							</div>
						</div>


						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_company">Img:</label>
							</div>
							<div class="col-md-7 controls">
								<img alt="" src="<c:url value="${party.icon }"></c:url>">
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_company">Start Time</label>
							</div>
							<div class="col-md-7 controls">
                             <fmt:formatDate value="${party.startTime }" pattern="yyyy-MM-dd HH:mm"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_company">End Time</label>
							</div>
							<div class="col-md-7 controls">
                             <fmt:formatDate value="${party.endTime }" pattern="yyyy-MM-dd HH:mm"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_about">Description：</label>
							</div>
							<div class="col-md-7 controls">
								<textarea id="profile_about" name="description"
									class="form-control" rows="10">${party.description}</textarea>
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


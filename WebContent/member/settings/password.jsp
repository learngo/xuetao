<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />

<div class="breadcrumbrow">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href='<c:url value="/"></c:url>'>Home</a></li>
			<li class="active"><a href="password"> modify password</a></li>
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
			
			<a href="password" class="list-group-item active">
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
			<a href="browseParty" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			     browse partys
			</a> 
		</div>
	</div>
	<div class="col-md-9 content">
		<div class="row-fluid">
			<div class="panel panel-default panel-col">
			    <div class="panel-heading">modify password</div>
  <div class="panel-body">      
      <form id="settings-password-form" class="form-horizontal" method="post" action="modifyPassword">
        <div class="form-group">
          <div class="col-md-2 control-label"><label for="form_currentPassword" class="required">Current password</label></div>
          <div class="controls col-md-8 controls">
            <input type="password"  name="oldPassword" required="required"  class="form-control" />
          </div>
        </div>

        <div class="form-group">
          <div class="col-md-2 control-label"><label for="form_newPassword" class="required">New Password</label></div>
          <div class="controls col-md-8 controls">
            <input type="password"  name="newPassword" required="required" class="form-control" />
          </div>
        </div>

        <div class="form-group">
          <div class="col-md-2 control-label"><label for="form_confirmPassword" class="required">Confim Password</label></div>
          <div class="controls col-md-8 controls">
            <input type="password" name="newPassword2" required="required" class="form-control" />
          </div>
        </div>

        <div class="form-group">
          <div class="col-md-2 control-label"></div>
          <div class="controls col-md-8 controls">
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

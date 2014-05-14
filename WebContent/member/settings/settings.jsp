<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="col-md-9 content">
		<div class="row-fluid">
			<div class="panel panel-default panel-col">
			     <div class="panel-heading">Base infomation</div>
			     <div class="panel-body">
					<form id="user-profile-form" class="form-horizontal" method="post" action="modifyMemberInfo">

						<div class="form-group">
							<label class="col-md-2 control-label">photo</label>
							<div class="col-md-7 controls">
								<img src="<c:url value="${member.photo}"/>" alt="${party.title}"  width="180px" height="240px"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label" for="profile_truename">Nick Name</label>
							<div class="col-md-7 controls">
							<span>${member.name }</span>
							</div>
						</div>

			
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_company">School</label>
							</div>
							<div class="col-md-7 controls">
							<span>${v.schoolName }</span>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_job">Major</label>
							</div>
							<div class="col-md-7 controls">
							<span>${member.major }</span>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_weixin">phone</label>
							</div>
							<div class="col-md-7 controls">
							<span>${member.phone }</span>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_weixin">email</label>
							</div>
							<div class="col-md-7 controls">
									<span>${member.email }</span>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-2 control-label">
								<label for="profile_about">Introduce</label>
							</div>
							<div class="col-md-7 controls">
							<span>${member.description }</span>
							</div>
						</div>

						<div class="row">
							<div class="col-md-7 col-md-offset-2">
							    <a href="<c:url value="/member/settings/preSettings"/>">
									<button type="button" class="btn btn-primary">editor</button>
								</a>
							</div>
						</div>

					</form>



				</div>
			</div>
		</div>
	</div>

<script>
	$('#tooltip-right').tooltip();
</script>

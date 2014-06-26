<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/prettyPhoto.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/contact.css"/>" />
<div class="container">
  <div class="row  mt20">
	  <div class="fl">
       <form class="login-form" action="<c:url value="/memberLogin"/>" method="post">
			<h3 class="form-title">Login</h3>
			<div class="form-group">
				<div class="input-icon">
					<i class="fa fa-user"></i>
					<input class="form-control placeholder-no-fix" type="text" placeholder="email" name="email"/>
				</div>
			</div>
			<div class="form-group">
				<div class="input-icon">
					<i class="fa fa-lock"></i>
					<input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="Password" name="password"/>
				</div>
			</div>
			<div class="form-actions">
				<label class="checkbox">
				    <input type="checkbox" name="remember" value="1"/> Remember me
				</label>
                <a href="###" class="fpwd">Foget the password</a>
			</div>
            <div>
                <button type="submit" class="btn">
                Login <i class="m-icon-swapright m-icon-white"></i>
                </button>
            </div>
		</form>
    </div>
    <div class="middle-line"></div>
    <div class="fr">
         <form class="form-horizontal register-form" action="<c:url value="/register"/>" method="post" enctype="multipart/form-data">
          <div id="output" class="alert tc"> Register Member </div>
             <div class="form-meta clearfix">
          			<div class="form-group">
						<label class="col-lg-2 control-label">school：</label>
						<div class="col-lg-10">
							<select name="schoolId">
									 <c:if test="${schools!=null }">
							          <c:forEach var="school" varStatus="status" items="${schools}">
									     <option value="${ school.id}" style="max-width: 220px;">${school.name}</option>
									  </c:forEach>
							        </c:if>
							 </select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">nickName：</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" placeholder="user name"  name="username" required="required"/>
						</div>
					</div>
					<!-- 
                    <div class="form-group">
						<label class="col-lg-2 control-label">major：</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" placeholder="major"  name="major" required="required"/>
						</div>
					</div>
					 -->
                    <div class="form-group">
						<label class="col-lg-2 control-label">email：</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" placeholder="write your school mail address correctly "  name="email" required="required"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-lg-2 control-label">password：</label>
						<div class="col-lg-10">
							<input type="password" class="form-control"
								placeholder="password"  name="password" required="required"/>
						</div>
					</div>
					<!-- 
					<div class="form-group">
						<label class="col-lg-2 control-label">phone：</label>
						<div class="col-lg-10">
							<input type="text" class="form-control"
								placeholder="phone"  name="phone" required="required"/>
						</div>
					</div>
					 -->
					<div class="form-group">
						<label class="col-lg-2 control-label">photo：</label>
						<div class="col-lg-10">
                            <div class="form-file">
                                <a href="javascript:;" class="form-file-bg">PHOTO</a>
                                <input type="file"  placeholder="file"  name="file" />
                                <span class="fileName"></span>
                            </div>
						</div>
					</div>
					
					<div class="form-group">
			            <label class="col-lg-2 control-label"></label>
							<div class="checkbox">
                              <label>
                                <input type="checkbox" value="1" name="checkBox" checked="checked">
                                &nbsp;&nbsp;&nbsp;By clicking Sign up you agree to the Terms of Use and Privacy Policy.
                              </label>
                            </div>
			          </div>
					
				<div class="modal-footer">
	              <button type="submit" class="btn btn-primary" >OK</button>
            	</div>
            </div>
        </form>
    </div>
  </div>
</div>

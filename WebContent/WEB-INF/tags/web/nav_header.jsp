<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/nav-header.css"/>" />
<div id="header">
         <div class="container">
           <ul class="nav">
			  <li class="home"><a href="<c:url value="/"/>">
			   <span class="glyphicon homeIcon"></span>
			  </a></li>
			  <li class="party">
			  <a href="<c:url value="/web/partys"/>">
			  <span class="glyphicon photoIcon"></span>
			  <span class="glyphiconText">PARTY</span>
			  </a>
			  </li>
			  <li class="goods"><a href="<c:url value="/web/goods"/>">
			  <span class="glyphicon loveIcon"></span>
			  <span class="glyphiconText">SHOP</span>
			  </a>
			  </li>
			</ul>
			 <div class="top_about">
                 <ul >
                    <c:if test="${sessionScope.UserConstant_VISITOR == null}">
                     <li>
                       <a href="#loginModal" data-toggle="modal">
                        <span class="glyphiconText">Login /</span>
                       </a>
                       <a href="<c:url value="/preRegister"/>">
                       <span class="glyphiconText">Register</span>
                       </a>
                       </li>
                     </c:if>
                    <c:if test="${sessionScope.UserConstant_VISITOR != null}">
	                  <li class="nav_photo">
		                   <a href="<c:url value="/viewMemberInfo"/>?memberId=${sessionScope.UserConstant_VISITOR.userid }">
		                     <span class="phtoto"><img class="avatar" src="http://tp4.sinaimg.cn/2042952831/180/5648174935/1"></span>
		                   </a>
	                   </li>
                      <li>  
                      <a href="<c:url value="/member/settings/settings"/>" class="setting">
                         <span class="glyphiconText">${sessionScope.UserConstant_VISITOR.username }</span>
                      </a>
                      </li>
					   <li><a href="<c:url value="/logout"/>" title="logout ">
							 <span class="glyphicon logoutIcon"></span>		
									</a></li>
					   <li><a href="<c:url value="/member/settings/browseEvaluate"/>">
					    <span class="glyphicon messageIcon"></span>
					    <span class="badge messageSum">${sessionScope.UserConstant_VISITOR.messageSum}</span></a></li>
					</c:if>
				</ul>
             </div>
         </div>
 </div>
 
 
 
 <!-- Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModal" aria-hidden="true">
 		<div class="modal-dialog panel-primary login-panel">
          <div class="modal-content">
	         <div class="modal-body login-panel">
			          <form class="form-horizontal login-panel-left" action='<c:url value="/memberLogin"/>' method="post">
							<div class="form-group">
								<h3>Sign in</h3>
							</div>
							<div class="form-group">
								<label class="col-lg-2 control-label">email：</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" placeholder="email" name="email" required="required"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-2 control-label">password：</label>
								<div class="col-lg-10">
									<input type="password" class="form-control"
										placeholder="password"  name="password" required="required"/>
								</div>
							</div>
							<div class="form-group tc">
								<button type="submit" class="btn btn-info btn-lg"> Login </button>
							</div>
					   </form>
					   <div class="login-panel-middle"></div> 
			          <form class="form-horizontal login-panel-right" action='<c:url value="/memberLogin"/>' method="post">
							<div class="form-group">
							</div>
							<div class="form-group">
							</div>
							<div class="form-group">
							</div>
							<div class="form-group">
							</div>
							<div class="form-group">
								<button type="button" class="btn btn-info btn-lg" data-dismiss="modal">facebook Login </button>
							</div>
							<div class="form-group">
							
							</div>
							
					   </form> 
				 </div>
	<!-- 
		      <div class="modal-footer">
	              <button type="button" class="btn btn-default " data-dismiss="modal">cancel</button>
	              <button type="submit" class="btn btn-primary" >login</button>
            </div>
     -->
       </div><!-- /.modal-content //-->
    </div><!-- /.modal-dialog //-->
</div><!-- /.modal -->
			

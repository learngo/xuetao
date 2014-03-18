<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/nav-header.css"/>" />
<div id="header" class="header_color light_bg_color">
     <div id="header_main" class="container_wrap container_wrap_logo">
         <div class="container">
			<strong class="logo"> <a href="<c:url value="/index"/>""> <img
					src="<c:url value="/resources/web/images/Logo_youyika.png"/>" alt="Whoopes"></a></strong>
			<div class="top_nav">
                 <ul>
                     <li><a href="<c:url value="/web/partys"/>">活&nbsp;&nbsp;动</a></li>
                     <li><a href="<c:url value="/web/goods"/>">信&nbsp;&nbsp;息</a></li>
				</ul>
             </div>
             <div class="top_about">
                 <ul>
                 <c:if test="${sessionScope.UserConstant_VISITOR == null}">
                     <li><a href="#loginModal" data-toggle="modal">登&nbsp;&nbsp;陆</a></li>
                     <li><a href="#registerModal" data-toggle="modal">注&nbsp;&nbsp;册</a></li>
                 </c:if>
                    <c:if test="${sessionScope.UserConstant_VISITOR != null}">
                     <li class="color_f63">${sessionScope.UserConstant_VISITOR.username }</li>
					  <li><a href="<c:url value="/member/settings/settings.jsp"/>"><i
									class="glyphicon glyphicon-cog"></i> 帐号设置</a></li>
					 
					   <li><a href="<c:url value="/logout"/>"><i class="glyphicon glyphicon-off"></i>
									退出</a></li>
					</c:if>
                 </ul>
                 
             </div>
            
             <!-- end container-->
         </div>
         <!-- end container_wrap-->
     </div>
     <div class="header_bg">
     </div>
     <!-- end header -->
 </div>
 
 

 <!-- Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModal" aria-hidden="true">
 		<div class="modal-dialog panel-primary">
          <div class="modal-content">
            <div class="modal-header panel-heading">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
              <h4 class="modal-title">学淘登陆</h4>
            </div>
            <form class="form-horizontal" action='<c:url value="/memberLogin"/>' method="post">
				<div class="modal-body">


					<div class="form-group">
						<label class="col-lg-2 control-label">邮箱：</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" placeholder="邮箱" name="email"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">密码：</label>
						<div class="col-lg-10">
							<input type="password" class="form-control"
								placeholder="密码"  name="password"/>
						</div>
					</div>
				</div>
				<div class="modal-footer">
	              <button type="button" class="btn btn-default " data-dismiss="modal">取消</button>
	              <button type="submit" class="btn btn-primary" >登陆</button>
            	</div>
          </form>   
            
            
          </div><!-- /.modal-content //-->
        </div><!-- /.modal-dialog //-->
  
</div><!-- /.modal -->

 <!-- Modal -->
<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModal" aria-hidden="true">
 		<div class="modal-dialog panel-primary">
          <div class="modal-content">
            <div class="modal-header panel-heading">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
              <h4 class="modal-title">学淘注册</h4>
            </div>
            <form class="form-horizontal" action="<c:url value="/register"/>" method="post">
				<div class="modal-body">


					<div class="form-group">
						<label class="col-lg-2 control-label">邮箱：</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" placeholder="邮箱"  name="email"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">nickName：</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" placeholder="user name"  name="username"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">密码：</label>
						<div class="col-lg-10">
							<input type="password" class="form-control"
								placeholder="密码"  name="password"/>
						</div>
					</div>
				
				</div>
				<div class="modal-footer">
	              <button type="button" class="btn btn-default " data-dismiss="modal">取消</button>
	              <button type="submit" class="btn btn-primary" >确定</button>
            	</div>
          </form>   
            
            
          </div><!-- /.modal-content //-->
        </div><!-- /.modal-dialog //-->
 
 
  
</div><!-- /.modal -->

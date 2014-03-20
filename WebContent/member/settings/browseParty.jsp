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
			<a href="party" class="list-group-item">
			  <span class="glyphicon glyphicon-envelope"></span>
			   添加活动
			</a> 
			<a href="browseParty" class="list-group-item active">
			  <span class="glyphicon glyphicon-envelope"></span>
			   浏览活动
			</a> 
		</div>
		</div>
	</div>
	<div class="col-md-9 content">
		<div class="row">
			<div class="panel panel-default panel-col">
			     <div class="panel-heading">基础信息</div>
			     <div class="panel-body">
					<table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>id</th>
            <th>title</th>
            <th>startTime</th>
            <th>endTime</th>
            <th>join sum</th>
            <th>state</th>
            <th>manager</th>
          </tr>
        </thead>
        <tbody>
        <c:if test="${partys!=null }">
            <c:forEach var="party" varStatus="status" items="${partys}">
           <tr>
            <td>${party.id }</td>
            <td>${party.title }</td>
            <td>${party.joinSum }</td>
            <td>${party.state }</td>
            <td>${party.updateTime }</td>
            <td><a href="@">delte</a> <a href="#">view</a></td>
          </tr>
		   </c:forEach>
        </c:if>
         
         
        </tbody>
      </table>



				</div>
			</div>
		</div>
	</div>


</div>




<script>
	$('#tooltip-right').tooltip();
</script>

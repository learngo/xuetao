<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />

<div class="breadcrumbrow">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href='<c:url value="/"></c:url>'>Home</a></li>
			<li class="active"><a href="browseParty">browse Party</a></li>
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
			<a href="addGood" class="list-group-item ">
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
		<div class="row">
			<div class="panel panel-default panel-col">
			     <div class="panel-heading">Partys</div>
			     <div class="panel-body">
					<table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>id</th>
            <th>icon</th>
            <th>title</th>
            <th>startTime</th>
            <th>endTime</th>
            <th>join sum</th>
            <th>manager</th>
          </tr>
        </thead>
        <tbody>
        <c:if test="${partys!=null }">
            <c:forEach var="party" varStatus="status" items="${partys}">
           <tr>
            <td>${party.id }</td>
            <td>
             <img alt="${party.title }" src="<c:url value="${party.icon}"></c:url>" width="120px" height="60px">
            </td>
            <td>${party.title }</td>
            <td>
             <fmt:formatDate value="${party.startTime }" pattern="yyyy-MM-dd HH:mm"/>
            </td>
            <td><fmt:formatDate value="${party.endTime }" pattern="yyyy-MM-dd HH:mm"/></td>
            <td>${party.joinSum}</td>
            <td><a href="deleteParty?partyId=${party.id}">delete</a> 
            <a href="<c:url value="/web/partyDetail?partyId=${party.id}"/>">view</a>
		    <!-- <a href="party?partyId=${party.id}">view</a> -->
            </td>
            
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

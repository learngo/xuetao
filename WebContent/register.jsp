<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/prettyPhoto.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/web/css/contact.css"/>" />
<div class="container">
  <div class="row contact mt20">
	  <div class="col-lg-6">
        <a href="#" class="thumbnail">
         <img alt="" src="<c:url value="/resources/img/login.jpg"/>">
      </a>
    </div>
    <div class="col-lg-6 fr">
         <form class="form-horizontal" action="<c:url value="/register"/>" method="post" enctype="multipart/form-data">
          <div id="output" class="alert tc"> register member </div>
             <div class="form-meta clearfix">
          			<div class="form-group">
						<label class="col-lg-2 control-label">school：</label>
						<div class="col-lg-10">
							<select name="schoolId">
									 <c:if test="${schools!=null }">
							          <c:forEach var="school" varStatus="status" items="${schools}">
									     <option value="${ school.id}">${school.name}</option>
									  </c:forEach>
							        </c:if>
							 </select>
						</div>
					</div>
                    <div class="form-group">
						<label class="col-lg-2 control-label">major：</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" placeholder="major"  name="major"/>
						</div>
					</div>
                    <div class="form-group">
						<label class="col-lg-2 control-label">email：</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" placeholder="email"  name="email"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">nickName：</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" placeholder="user name"  name="username"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">password：</label>
						<div class="col-lg-10">
							<input type="password" class="form-control"
								placeholder="password"  name="password"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">phone：</label>
						<div class="col-lg-10">
							<input type="password" class="form-control"
								placeholder="phone"  name="phone"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">photo：</label>
						<div class="col-lg-10">
							<input type="file" class="form-control"
								placeholder="file"  name="file"/>
						</div>
					</div>
					
				<div class="modal-footer">
	              <button type="submit" class="btn btn-primary" >submit</button>
            	</div>
            </div>
        </form>
    </div>
  </div>
</div>

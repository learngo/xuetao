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
                       <a href="<c:url value="/preRegister"/>">
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
		                     <span class="phtoto"><img class="avatar" src="<c:url value="/"/>${sessionScope.UserConstant_VISITOR.photo}"></span>
		                   </a>
	                   </li>
                      <li>  
                      <!-- 
                         <a href="<c:url value="/member/settings/settings"/>" class="setting">
                       -->
                       <a href="<c:url value="/viewMemberInfo"/>?memberId=${sessionScope.UserConstant_VISITOR.userid }" class="setting">
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
        <div id="seachbar" class="seachbar">
            <input name="searchInput" type="text" placeholder="Search places"/>
        </div>
         </div>
 </div>
    <script>
    $(function(){
        $('#seachbar').click(function(){
            $(this).animate({width:255});
        });
    });
    </script>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/user.css"/>" />
<div class="user_page">
<div class="container">
	<div class="section user_base">
       <div class="col-md-12 ">
         <span class="photo"><img class="avatar bg_white" src="${acountInfos.photo }"></span>
         <span class="user_name">流量喜爱那</span>
         <span class="bg_line"></span>
         <span class="user_profile">
          <li>${acountInfos.schoolName }</li>
          <li>${acountInfos.major}</li>
         </span>
       </div>
    </div>
	<div class="clearfix"></div>
	<div class="section user_baseInfo">
	   <div class="col-md-12 section_title">
	    <span class="section_title_border_left bg_line"></span>
	    <span class="user_baseInfo_userName">${acountInfos.name }</span>
	  </div>
       <div class="col-md-7 user_baseInfo_left">
         <ul>
          <li><span class="user_base_info_name">Email:</span>   <span class="user_base_info_value">${acountInfos.email}</span></li>
          <li><span class="user_base_info_name">Product sum:</span>   <span class="user_base_info_value">${acountInfos.successSum}</span></li>
          <li><span class="user_base_info_name">Point :</span>   <span class="user_base_info_value">${acountInfos.points}</span></li>
          <li><span class="user_base_info_name">Introduce:</span>   <span class="user_base_info_value">${acountInfos.description }</span></li>
         </ul>
       </div>
       <div class="col-md-5 user_baseInfo_right">
         <ul>
          <li><span class="user_base_info_name">组织活动次数:</span>   <span class="user_base_info_value">${acountInfos.partyCreateSum}</span></li>
          <li><span class="user_base_info_name">参加组织活动次数：</span>   <span class="user_base_info_value">${acountInfos.partyJoinSum}</span></li>
         </ul>
       </div>
    </div>
    <div class="clearfix"></div>
    <div class="section user_work">
	   <div class="col-md-10 section_title">
	    <span class="section_title_border_left bg_line"></span>
	    <span class="user_baseInfo_userName">My organization's activities</span>
	    <span class="user_baseInfo_userName fr"><a class="btn button_color" href="#">
	    Organization Party 
	    </a>
	    </span>
	  </div>
       <div class="col-md-12 works">
      
         <ul>
           <c:if test="${partys!= null}">
					<c:forEach var="party" varStatus="status" items="${partys}">
					
		  <li class="work">
            <div class="work_image">
               <a href="<c:url value="/web/partyDetail?partyId=${party.id}"/>">
                <img alt="${party.title}" src="<c:url value="${party.icon}"/>">
             </a>
            </div>
            <div class="work_title">
              <span class="work_disc">
                <p class="work_disc_name">${party.title}</p>
              </span>
              
              <span class="work_price">
                <span class="work_price_icon"></span>
                <span class="work_price_sum">（${party.joinSum}）</span>
              </span>
            </div>
          </li>
          
					</c:forEach>
		  </c:if>
          
         </ul>
       </div>
      <div class="clearfix"></div>
      <div class="col-md-10 section_title">
	    <span class="section_title_border_left bg_line"></span>
	    <span class="user_baseInfo_userName"> Release goods </span>
	    <span class="user_baseInfo_userName fr"><a class="btn button_color" href="#">
	     Release goods 
	    </a></span>
	  </div>
        <div class="col-md-12 works">
      
         <ul>
			   <c:if test="${goods!= null}">
					<c:forEach var="good" varStatus="status" items="${goods}">
		<li class="work">
            <div class="work_image">
            <a href="<c:url value="/web/goodDetail?goodId=${good.goodId}"/>">
                <img alt="${good.name }" src="<c:url value="${good.logo}"/>">
             </a>
            </div>
            <div class="work_title">
              <span class="work_disc">
                <p class="work_disc_name">${good.name }</p>
                <p >${good.title}</p>
              </span>
              
              <span class="work_price">
                <span class="work_price_icon"></span>
                <span class="work_price_sum">（${good.price }）</span>
              </span>
            </div>
          </li>
					</c:forEach>
				</c:if>
          
         </ul>
       </div>
    </div>
</div>	
</div>

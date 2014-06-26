<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/common-content.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/web/css/user.css"/>" />
<div class="user_page">
<div class="container">
	<div class="section user_base">

         <c:if test="${acountInfos.id==sessionScope.UserConstant_VISITOR.userid}">
           <a href="#photoModal"  data-toggle="modal">
            <span class="photo"><img class="avatar bg_white" src="<c:url value="/${acountInfos.photo}"/>"></span>
          </a>
        </c:if>
        <c:if test="${acountInfos.id!=sessionScope.UserConstant_VISITOR.userid}">
            <span class="photo"><img class="avatar bg_white" src="<c:url value="/${acountInfos.photo}"/>"></span>
        </c:if>
         
         <span class="user_name">${acountInfos.name }</span>
         <span class="bg_line"></span>
         <span class="user_profile">
          <div>${acountInfos.schoolName }</div>
          <div>${acountInfos.major}</div>
         </span>

    </div>
	<div class="clearfix"></div>
	<div class="section user_baseInfo">
	   <div class="section_title">
	    <span class="section_title_border_left bg_line"></span>
	    <span class="user_baseInfo_userName">About ${acountInfos.name }</span>
	    <c:if test="${acountInfos.id==sessionScope.UserConstant_VISITOR.userid}">
           <a href="#pwdModal"  data-toggle="modal" class="icon-setting"></a>
        </c:if>
	  </div>
       <div class="col-md-7 user_baseInfo_left">
         <ul>
          <li><span class="user_base_info_name">Email:</span>   <span class="user_base_info_value">${acountInfos.email}</span></li>
          <li><span class="user_base_info_name">Product sum:</span>   <span class="user_base_info_value">${acountInfos.successSum}</span></li>
          <li><span class="user_base_info_name">Point :</span>   <span class="user_base_info_value">${acountInfos.points}</span></li>
          <li><span class="user_base_info_name">Introduce:</span>   <span class="user_base_info_value">${acountInfos.description }</span></li>
         </ul>
       </div>
       <div class="user_baseInfo_line"></div>
       <div class="col-md-5 user_baseInfo_right">
         <ul>
          <li><span class="user_base_info_name">组织活动次数:</span>   <span class="user_base_info_value">${acountInfos.partyCreateSum}</span></li>
          <li><span class="user_base_info_name">参加组织活动次数：</span>   <span class="user_base_info_value">${acountInfos.partyJoinSum}</span></li>
         </ul>
       </div>
    </div>
    <div class="clearfix"></div>
    <div class="section user_work">
	   <div class="section_title">
	    <span class="section_title_border_left bg_line"></span>
	    <span class="user_baseInfo_userName icon">My organization's activities</span>
	    <c:if test="${acountInfos.id==sessionScope.UserConstant_VISITOR.userid}">
	    <span class="user_baseInfo_userName fr"><a class="btn button_color"  href="#partyModal"  data-toggle="modal" >
	    Organization Party 
	    </a>
	    
	    </span>
	    </c:if>
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
                <p>
                <c:if test="${party.state==0 }">
                进行中
                </c:if>
                <c:if test="${party.state==1 }">已经结束
                </c:if>
                </p>
              </span>

                <span class="party_users">${party.joinSum}</span>

            </div>
          </li>
          
					</c:forEach>
		  </c:if>
          
         </ul>
       </div>
      <div class="clearfix"></div>
      <div class="section_title">
	    <span class="section_title_border_left bg_line"></span>
	    <span class="user_baseInfo_userName icon"> Release goods </span>
	     <c:if test="${acountInfos.id==sessionScope.UserConstant_VISITOR.userid}">
	    <span class="user_baseInfo_userName fr"><a class="btn button_color"  href="#goodsModal"  data-toggle="modal" >
	     Release goods 
	    </a></span>
	    </c:if>
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
                <span class="work_price_sum">$ ${good.price }</span>
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
    <!-- Party Modal -->
    <div class="modal fade" id="partyModal"  role="dialog">
        <div class="modal-dialog  user-modal">
            <div class="modal-content">
                <form class="form-horizontal register-form" action="<c:url value="/member/settings/submitParty"/>" method="post" enctype="multipart/form-data">
                    <div class="dialog-title">Add Party</div>
                    <div class="form-meta clearfix">
                        <div class="form-group">
                        <label class="col-lg-2 control-label">School:</label>
                        <div class="col-lg-10">
                        <div id="profile_gender">
                         <select name="schoolId">
						 <c:if test="${schooles!=null }">
				          <c:forEach var="school" varStatus="status" items="${schooles}">
						     <option value="${ school.id}" style="max-width: 220px;">${school.name}</option>
						  </c:forEach>
				        </c:if>
				        </select>
                        </div>
                        </div>
                        </div>

                        <div class="form-group">
                        <label for="profile_truename" class="col-lg-2 control-label">Title:</label>
                        <div class="col-lg-10">
                        <input type="text" class="form-control" name="title">
                        </div>
                        </div>

                        <div class="form-group">
                        <label class="col-lg-2 control-label">IMG</label>
                        <div class="col-lg-10">
                            <div class="form-file">
                            <a href="javascript:;" class="form-file-bg">PHOTO</a>
                            <input type="file"  placeholder="file"  name="file" />
                            <span class="fileName"></span>
                            </div>
                        </div>
                        </div>
                        <div class="form-group">
                        <label class="col-lg-2 control-label">Start Time:</label>
                            <div data-link-field="startTime" data-date-format="yyyy-mm-dd hh:ii" data-date="" class="input-group date form_datetime col-md-10 col-lg-10">
                            <input type="text" readonly="" value="" size="16" class="form-control">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                            </div>
                        <input type="hidden" id="startTime" name="startTime" class="input-sm form-control">
                        </div>
                        <div class="form-group">
                        <label class="col-lg-2 control-label" for="dtp_input1">End Time:</label>
                        <div data-link-field="endTime" data-date-format="yyyy-mm-dd hh:ii" data-date="" class="input-group date form_datetime col-lg-10">
                        <input type="text" readonly="" value="" size="16" class="form-control">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>
                        <input type="hidden" id="endTime" name="endTime" class="input-sm form-control">
                        </div>

                        <div class="form-group">
                        <label class="col-lg-2 control-label">Address:</label>
                        <div class="col-lg-10">
                        <input type="text" class="form-control" name="address">
                        </div>
                        </div>

                        <div class="form-group">
                        <label class="col-lg-2 control-label">DES:</label>
                        <div class="col-lg-10">
                        <textarea rows="5" class="form-control" name="description" id="profile_about"></textarea>
                        </div>
                        </div>

                        <div class="modal-footer">
                        <button type="submit" class="btn btn-primary" >Save</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- Password Modal -->
    <div class="modal fade" id="pwdModal" tabindex="-1" role="dialog" aria-labelledby="loginModal" aria-hidden="true">
        <div class="modal-dialog  user-modal">
            <div class="modal-content">
                <form  class="form-horizontal" enctype="multipart/form-data" method="post" action="<c:url value="/member/settings/modifyMemberInfo"/>">
            
                    <div class="dialog-title">Member Info</div>

                        <div class="form-meta clearfix">

                        <div class="form-group">
                        <label class="col-lg-2 control-label">school：</label>
                        <div class="col-lg-10">
				        <input type="text" class="form-control" value="${v.schoolName }" readonly="readonly"/>
                        </div>
                        </div>

                        <div class="form-group">
                        <label class="col-lg-2 control-label">nickName：</label>
	                        <div class="col-lg-10">
	                          <input type="text" name="username" class="form-control" value="${member.name }" required="required"/>
	                        </div>
                        </div>
                        <div class="form-group">
                        <label class="col-lg-2 control-label">major：</label>
	                        <div class="col-lg-10">
	                          <input type="text" name="major"
									class="form-control" value="${member.major }" required="required"/>
	                        </div>
                        </div>
                        <div class="form-group">
                        <label class="col-lg-2 control-label">Phone：</label>
	                        <div class="col-lg-10">
	                          <input type="text" name="phone"
									class="form-control" value="${member.phone }" required="required"/>
	                        </div>
                        </div>

                        <div class="form-group">
                        <label class="col-lg-2 control-label">email：</label>
                        <div class="col-lg-10">
                        <input type="text" 
									class="form-control" value="${member.email }" readonly="readonly"/>
                        </div>
                        </div>
                        <div class="form-group">
                        <label class="col-lg-2 control-label">Introduce：</label>
                        <div class="col-lg-10">
                        <textarea id="profile_about" name="description"
									class="form-control" rows="20" required="required">${member.description }</textarea>
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
    
    
    <!-- Password Modal -->
    <div class="modal fade" id="photoModal" tabindex="-1" role="dialog" aria-labelledby="loginModal" aria-hidden="true">
        <div class="modal-dialog  user-modal">
            <div class="modal-content">
                <form  class="form-horizontal" enctype="multipart/form-data" method="post" action="<c:url value="/member/settings/modifyPhoto"/>">
                    <div class="dialog-title">Member Photo</div>
                        <div class="form-meta clearfix">
                        <div class="form-group">
                        <label class="col-lg-2 control-label">photo：</label>
                        <div class="col-lg-10">
					     <img src="<c:url value="${member.photo}"/>" alt="${party.title}"  width="180px" height="240px"/>
                        <div class="form-file">
                        <a href="javascript:;" class="form-file-bg">PHOTO</a>
                        <input type="file"  placeholder="file"  name="file" />
                        <span class="fileName"></span>
                        </div>
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
    <!-- Goods Modal -->
    
    <div class="modal fade" id="goodsModal"  role="dialog">
        <div class="modal-dialog  user-modal">
            <div class="modal-content">
            <form  class="form-horizontal" enctype="multipart/form-data" method="post" action="<c:url value="/member/settings/submitGood"/>">
                   <div class="dialog-title">Release Goods</div>
                   <div class="form-meta clearfix">

                        <div class="form-group">
                        <label class="col-lg-2 control-label">Good Name：</label>
                        <div class="col-lg-10">
                        <input type="text" class="form-control"  name="name" required="required"/>
                        </div>
                        </div>


                        <div class="form-group">
                        <label class="col-lg-2 control-label">Category：</label>
                        <div class="col-lg-10">
                        <select name="categoryId" required="required" class="category" >
						 <c:if test="${categorys!=null }">
				          <c:forEach var="category" varStatus="status" items="${categorys}">
						     <option value="${category.id}">${category.name}</option>
						  </c:forEach>
				        </c:if>
				        </select>
                        </div>
                        </div>

                        <div class="form-group">
                        <label class="col-lg-2 control-label">Color：</label>
                        <div class="col-lg-10">
                            <label><input type="radio" name="level" value="1"  required="required"/>Brand new</label>
                            <label><input type="radio" name="level" value="2"/>Barely used</label>
                            <label><input type="radio" name="level" value="3"/>Used</label>
                        </div>
                        </div>

                        <div class="form-group">
                        <label class="col-lg-2 control-label">Good Logo：</label>
                        <div class="col-lg-10">
                            <div class="form-file">
                            <a href="javascript:;" class="form-file-bg">PHOTO</a>
                            <input type="file"  placeholder="file"  name="file" />
                            <span class="fileName"></span>
                            </div>
                        </div>
                        </div>

                        <div class="form-group">
                        <label class="col-lg-2 control-label">IMG 1：</label>
                        <div class="col-lg-10">
                            <div class="form-file">
                            <a href="javascript:;" class="form-file-bg">PHOTO</a>
                            <input type="file"  placeholder="file"  name="file1" />
                            <span class="fileName"></span>
                            </div>
                        </div>
                        </div>

                        <div class="form-group">
                        <label class="col-lg-2 control-label">IMG2：</label>
                        <div class="col-lg-10">
                            <div class="form-file">
                            <a href="javascript:;" class="form-file-bg">PHOTO</a>
                            <input type="file"  placeholder="file"  name="file2" />
                            <span class="fileName"></span>
                            </div>
                        </div>
                        </div>

                        <div class="form-group">
                        <label class="col-lg-2 control-label">IMG 3：</label>
                        <div class="col-lg-10">
                            <div class="form-file">
                            <a href="javascript:;" class="form-file-bg">PHOTO</a>
                            <input type="file"  placeholder="file"  name="file3" />
                            <span class="fileName"></span>
                            </div>
                        </div>
                        </div>

                        <div class="form-group">
                        <label class="col-lg-2 control-label">Price：</label>
                        <div class="col-lg-10">
                            <input type="text" required="required" name="price" placeholder="price" class="form-control"/>
                        </div>
                        </div>

                        <div class="form-group">
                        <label class="col-lg-2 control-label">Title：</label>
                        <div class="col-lg-10">
                            <input type="text" required="required" name="title" placeholder="title" class="form-control"/>
                        </div>
                        </div>

                        <div class="form-group">
                        <label class="col-lg-2 control-label">DES：</label>
                        <div class="col-lg-10">
                             <textarea required="required" rows="5"  class="form-control" name="description"></textarea>
                        </div>
                        </div>

                        <div class="modal-footer">
                        <button type="submit" class="btn btn-primary" >Save</button>
                        </div>
                   </div>
               </form>
            </div>
        </div>
    </div>
    <script src="<c:url value="/resources/js/bootstrap-datetimepicker.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/locales/bootstrap-datetimepicker.zh-CN.js"/>" type="text/javascript"></script>
    <script type="text/javascript">
    $('.form_datetime').datetimepicker({
    language:  'zh-CN',
    weekStart: 1,
    todayBtn:  1,
    autoclose: 1,
    todayHighlight: 1,
    startView: 2,
    forceParse: 0,
    showMeridian: 1
    });
    </script>
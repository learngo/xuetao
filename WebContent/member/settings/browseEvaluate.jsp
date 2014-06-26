<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<div class="col-md-12">
		<div class="row">
			<div class="panel panel-default panel-col">
			     <div class="panel-heading">Partys</div>
			     <div class="panel-body">
					<table class="table  table-hover">
        <thead>
          <tr>
            <th></th>
            <th>姓名</th>
            <th>内容</th>
            <th>类别</th>
            <th>时间</th>
             <th>查看详情</th>
          </tr>
        </thead>
        <tbody>
        <c:if test="${evaluates!=null }">
            <c:forEach var="evaluate" varStatus="status" items="${evaluates}">
            
           <tr <c:if test="${evaluate.statu==0 }">class="warning"</c:if> />
            <td>
              <span class="photo"><img class="avatar bg_white" src="<c:url value="/${evaluate.memberPhoto}"/>"></span>
            </td>
            <td>
            ${evaluate.memberName}
            </td>
            <td>
            ${evaluate.content }
            </td>
            <td>
            <c:if test="${evaluate.evaluateProductType==2}">
               <a href="<c:url value="/web/goodDetail?goodId=${evaluate.evaluateProductId}&evaluateId=${evaluate.id}"/>">Good</a>
              </c:if>
             
              <c:if test="${evaluate.evaluateProductType==1}">
              <a href="<c:url value="/web/partyDetail?partyId=${evaluate.evaluateProductId}"/>">Party</a>
              </c:if>
            </td>
            
            <td>
             <fmt:formatDate value="${evaluate.createTime }" pattern="yyyy-MM-dd HH:mm"/>
            </td>
            <td>
              <c:if test="${evaluate.evaluateProductType==2}">
               <a href="<c:url value="/web/goodDetail?goodId=${evaluate.evaluateProductId}&evaluateId=${evaluate.id}"/>">reply</a>
              </c:if>
             
              <c:if test="${evaluate.evaluateProductType==1}">
               <a href="<c:url value="/web/partyCommentDetail?partyId=${evaluate.evaluateProductId}&evaluateId=${evaluate.id } "/>">reply</a>
              </c:if>
             
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





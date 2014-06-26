<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<div class="col-md-9 content">
		<div class="row">
			<div class="panel panel-default panel-col">
			     <div class="panel-heading">Stand inside letter</div>
			     <div class="panel-body">
					<table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>The title content</th>
            <th>用户Id</th>
            <th>产品线</th>
            <th>时间</th>
             <th>查看详情</th>
          </tr>
        </thead>
        <tbody>
        <c:if test="${messages!=null }">
            <c:forEach var="message" varStatus="status" items="${messages}">
           <tr>
            <td>${message.messageId }</td>
            <td>
            ${message.messageMemberName }
            </td>
            <td>
            <c:if test="${message.messageType==2}">
            Good
              </c:if>
             
              <c:if test="${message.messageType==1}">
              Party
              </c:if>
            </td>
            
            <td>
             <fmt:formatDate value="${message.messageCreateTime }" pattern="yyyy-MM-dd HH:mm"/>
            </td>
            <td>
              <c:if test="${message.messageType==2}">
               <a href="<c:url value="/web/goodDetail?goodId=${message.messageProductId}"/>">view</a>
              </c:if>
             
              <c:if test="${message.messageType==1}">
               <a href="<c:url value="/web/partyDetail?partyId=${message.messageProductId}"/>">view</a>
              </c:if>
             
            </td>
            
          </tr>
		   </c:forEach>
        </c:if>
         
         
        </tbody>
      </table>
        <div class="pagenation">
            <a href="<c:url value="/web/goods"/>?curPage=${curPage-1}&pageSize=12&categoryId=${categoryId}" class="prev">&nbsp;</a>
            <a  href="javascript:;" class="active">1</a>
            <a  href="javascript:;">2</a>
            <a  href="javascript:;">3</a>
            <a  href="javascript:;">2</a>
            <span class="dot">...</span>
            <a  href="javascript:;">10</a>
            <a  href="javascript:;">20</a>
            <a  href="javascript:;">30</a>
            <a href="<c:url value="/web/goods"/>?curPage=${curPage+1}&pageSize=12&categoryId=${categoryId}" class="next">&nbsp;</a>
        </div>


				</div>
			</div>
		</div>
	</div>






<script>
	$('#tooltip-right').tooltip();
</script>

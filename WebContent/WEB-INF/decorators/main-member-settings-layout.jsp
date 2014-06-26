<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" class="fixed_header">
<head>
  <c:import url="/WEB-INF/tags/web/header_title.jsp"/> 	
  <c:import url="/WEB-INF/tags/web/jsPlugin.jsp"/>
  <link rel="stylesheet" href="<c:url value="/resources/web/css/common-content.css"/>" />
  <link rel="stylesheet" href="<c:url value="/resources/web/css/common-content-left.css"/>" />
</head>

<body>
  <c:import url="/WEB-INF/tags/web/nav_header.jsp" />
    <div class="youyika nav-common">
	</div>
<div class="breadcrumbrow">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href='<c:url value="/"/>'>Home</a></li>
			<li class="active"><a href="<c:url value="${path }"/>">${pathName }</a></li>
		</ul>
	</div>
</div>
<div class="container">
	<sitemesh:write property="body"/>
  </div>
 <c:import url="/WEB-INF/tags/web/main_footer.jsp"/>
</body>
</html>
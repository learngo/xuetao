<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Le javascript
    ================================================== --> 
<!-- Placed at the end of the document so the pages load faster --> 
<script src="<c:url value="/resources/js/jquery-1.8.3.min.js"/>" type="text/javascript"></script> 
<script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script> 
<script src="<c:url value="/resources/js/respond.js"/>" type="text/javascript"></script> 
<script src="<c:url value="/resources/js/initWeb.js"/>" type="text/javascript"></script> 
<script type="text/javascript">
        function getRootPath(){  
            //获取当前网址，如： http://localhost:8080/taotaoti/index.jsp
            var curWwwPath=window.document.location.href;  
            //获取主机地址之后的目录，如： taotaoti/index.jsp
            var pathName=window.document.location.pathname;  
            var pos=curWwwPath.indexOf(pathName);  
            //获取主机地址，如： http://localhost:8080  
            var localhostPaht=curWwwPath.substring(0,pos);  
            //获取带"/"的项目名，如：/taotaoti  
            var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);  
            return(localhostPaht+projectName);  
        }  
        Init.webUrl=getRootPath();
</script>





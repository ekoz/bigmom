<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<title>夏洛特·玲玲 BigMom</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/themes/buttons.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap.css">
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/resources/jquery.min.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/resources/layer/layer.js"></script>

<script type="text/javascript">
	var SystemKeys = {
		contextPath: '${pageContext.request.contextPath}',
		userid: '${sessionScope.CURRENTUSER.id}',
		username: '${sessionScope.CURRENTUSER.username}',
		usernameCN: '${sessionScope.CURRENTUSER.userinfo.username}'
	}
</script>
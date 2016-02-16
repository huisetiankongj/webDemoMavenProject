<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>jQuery的deferred对象详解</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="com/czx/plugin/jquery/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="com/czx/plugin/jquery/jquery.heart.js"></script>
	<script type="text/javascript" src="com/czx/jquery/self/js/deferredDemo.js"></script>
  </head>
  
  <body>
  
  </body>
</html>

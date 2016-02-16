<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>extjs学习</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="com/czx/plugin/jquery/jquery-1.10.2.js"></script>
	<!-- extjs -->
	<link rel="stylesheet" type="text/css" href="com/czx/plugin/ext-4.2.1/resources/css/ext-all.css">
	<script type="text/javascript" src="com/czx/plugin/ext-4.2.1/ext-all-dev.js"></script>
	<script type="text/javascript" src="com/czx/extjs/start001.js"></script>
  </head>
  
  <body>
    <div id="ExtComponent">
    </div>
  </body>
</html>

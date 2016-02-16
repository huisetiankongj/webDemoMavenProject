<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'base.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="com/czx/plugin/jquery/jquery-1.10.2.js"></script>
	<!-- jquery基础函数 -->
	<script type="text/javascript" src="com/czx/jquery/self/js/base.js"></script>
	<!-- jquery回调对象 -->
	<script type="text/javascript" src="com/czx/jquery/self/js/callbacks.js"></script>
	<!-- jquerySizzle选择器引擎 -->
	<script type="text/javascript" src="com/czx/jquery/self/js/sizzle.js"></script>
  </head>
  
  <body>
  	<input type="button" id="btn1" value="$.fn.extend" />
  </body>
</html>

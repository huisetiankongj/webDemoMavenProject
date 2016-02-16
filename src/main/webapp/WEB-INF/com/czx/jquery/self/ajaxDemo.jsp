<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ajax请求演示</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="com/czx/plugin/jquery/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="com/czx/plugin/jquery/jquery.heart.js"></script>
	<script type="text/javascript" src="com/czx/jquery/self/js/ajaxDemo.js"></script>
  </head>
  
  <body >
  	${requestScope.name }
 	 <div class="container" style="margin-top:20px;">
 	 	<div style="width:500px;height:100px;margin:0 auto;border:1px solid black">
	 	 	 <input type="button" name="btn1" value="ajax请求"/>
	 	 	 <input type="button" name="btn2" value="ajaxLoad"/>
	 	 	 <input type="button" name="btn3" value="ajaxGet"/>
	 	 	 <input type="button" name="btn4" value="ajaxPost"/>
		  	 <div id="content1">
		  	 </div>
	  	</div>
	    <form id="form1" style="width:500px;height:200px;margin:0 auto">
	    	<input type="text" name="name" />
	    	<input type="text" name="age" />
	    	<input type="file" name="fileName" />
	    	<input type="button" id="submit" value="提交" />
	    </form>
     </div>
  </body>
</html>

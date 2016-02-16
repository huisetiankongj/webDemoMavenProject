<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>简单的多文件上传</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <link rel="stylesheet" type="text/css" href="com/czx/baidu//webuploader/css/demo.css">
	<link rel="stylesheet" type="text/css" href="com/czx/plugin/webuploader/0.1.5/webuploader.css">
	<script type="text/javascript" src="com/czx/plugin/jquery/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="com/czx/plugin/jquery/jquery.heart.js"></script>
	<script src="com/czx/plugin/webuploader/0.1.5/webuploader.js"></script>
	<script type="text/javascript" src="com/czx/baidu/webuploader/js/simpleMulFile.js"></script>
  </head>
  
  <body>
  	<input type="button" id="btn1" value="点击" />
    <div id="uploader" class="wu-example">
	    <!--用来存放文件信息-->
	    <ul id="filelist" class="filelist" style="text-align: "></ul>
	    <div class="btns">
	        <div id="picker">选择文件</div>
	        <button id="ctlBtn" class="btn btn-default">开始上传</button>
	    </div>
	</div>
  </body>
</html>

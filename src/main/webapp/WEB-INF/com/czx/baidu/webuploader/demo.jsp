<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>百度上传图片插件</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
     <link rel="shortcut icon" href="/webuploader/images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="com/czx/baidu/webuploader/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="com/czx/baidu/webuploader/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="com/czx/baidu//webuploader/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="com/czx/baidu/webuploader/css/syntax.css">
    <link rel="stylesheet" type="text/css" href="com/czx/baidu/webuploader/css/style.css">
    <link rel="stylesheet" type="text/css" href="com/czx/plugin/webuploader/0.1.5/webuploader.css">
    <link rel="stylesheet" type="text/css" href="com/czx/baidu//webuploader/css/demo.css">
    <script type="text/javascript" src="com/czx/plugin/jquery/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="com/czx/plugin/jquery/jquery.heart.js"></script>
    <script type="text/javascript" src="com/czx/baidu/webuploader/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="com/czx/baidu/webuploader/js/global.js"></script>
    <script src="com/czx/plugin/webuploader/0.1.5/webuploader.js"></script>
    <script type="text/javascript" src="com/czx/baidu/webuploader/js/demo.js"></script>
  </head>
  
  <body>
    <div id="uploader" class="wu-example">
	    <div class="queueList">
	        <div id="dndArea" class="placeholder">
	            <div id="filePicker" class="webuploader-container">
	            	<div class="webuploader-pick">点击选择图片</div>
	            	<div id="rt_rt_1a2m5okdra2s1mm8q88g881uah1" style="position: absolute; top: 0px; left: 448px; width: 168px; height: 44px; overflow: hidden; bottom: auto; right: auto;">
	            		<input type="file" name="file" class="webuploader-element-invisible" multiple="multiple" accept="image/*">
	            		<label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255);">
	            		</label>
	            	</div>
	            </div>
	            <p>或将照片拖到这里，单次最多可选300张</p>
	        </div>
	    <ul class="filelist"></ul></div>
	    <div class="statusBar" style="display:none;">
	        <div class="progress" style="display: none;">
	            <span class="text">0%</span>
	            <span class="percentage" style="width: 0%;"></span>
	        </div><div class="info">共0张（0B），已上传0张</div>
	        <div class="btns">
	            <div id="filePicker2" class="webuploader-container"><div class="webuploader-pick">继续添加</div><div id="rt_rt_1a2m5oke51dvinde1t1naqm12de6" style="position: absolute; top: 0px; left: 0px; width: 1px; height: 1px; overflow: hidden;"><input type="file" name="file" class="webuploader-element-invisible" multiple="multiple" accept="image/*"><label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255);"></label></div></div><div class="uploadBtn state-pedding">开始上传</div>
	        </div>
	    </div>
	</div>
  </body>
</html>

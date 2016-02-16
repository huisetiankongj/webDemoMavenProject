<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <style>
	html,body{
		overflow:hidden;
	}
	
	html,div,h2,p{
		margin:0;
		padding:0;
	}
	
	body{
		color:#fff;
		background:#3399FF;
		font:12px/2 Arial;
	}
	
	p{
		padding:0 10px;
		margin-top:10px;
	}
	
	span{
		color:#ff0;
		margin-top:10px;
	}
	#box{
		position:absolute;
		width:300px;
		height::150px;
		background:#333;
		border:2px solid #ccc;
		top:150px;
		left:400px;
		margin:0px;
	}
	
	#box h2{
		height:25px;
		cursor:move;
		background:#222;
		border-bottom:2px solid #ccc;
		text-align:right;
		padding:0 10px;
	}
	
	#box h2 a{
		color:#fff;
		font:12px/25px Arial;
		text-decoration:none;
		outline:none;
	}
</style>
</head>

<body>
	<div id="box">
		<h2><a href="javascript:;">点击回放拖动轨迹</a></h2>
		<p>Drag:<span></span></p>
		<p>top:<span></span></p>
		<p>left:<span></span></p>
	</div>
</body>
</html>

<script>

	(function(){
		var bDrag = false;
		var _x,_y;
		var $box = $("#box");
		var aPos = [{x:$("#box").offset().left,y:$("#box").offset().top}];
		$("span:eq(1)").text(aPos[0].y);
		$("span:eq(2)").text(aPos[0].x);
		$("#box h2:first").mousedown(function(event){
			var e = event || window.event;
			bDrag = true;
			_x = e.pageX-$box.position().left;
			_y = e.pageY - $box.position().top();
			return false;
		});
		
		$(document).mousemove(function(event){
			if(!bDrag) return false;
			var e = event ||window.event;
			var x = e.pageX - _x;
			var y = e.pageY - _y;
			var maxL = $(document).width()-$box.outerWidth();
			var maxT = $(document).height()-$box.outerHeight();
			x = x<0?0:x;
			x = x>maxL ? maxL:x;
			y = y<0?0:y;
			y = y>maxT ? maxT:y;
			$box.css({left:x,top:y});
			aPos.push({
				x:x,
				y:y
			});
			status();
			return false;
		}).mouseup(function(){
			bDrag = false;
			status();
			return false;
		});
		
		$("#box h2:first a").click(function(){
			if(aPos.length == 1)return ;
			var timer = setInterval(function(){
				var oPos = aPos.pop();
				oPos? ($box.css({left:oPos.x_"px",top:oPos.y+"px"})):clearInterval(timer);
				status();
			},30);
		}).mousedown(function(){return false;})
		
		function status(){
			$("#box span:eq(0)").text(bDrag); 
			$("#box span:eq(1)").text($box.position().top); 
			$("#box span:eq(2)").text($box.position().left); 
		}
	
	})();
</script>
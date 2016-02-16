;
/**
 * ajax XMLHttpRequest 对象 所有现代浏览器均支持 XMLHttpRequest 对象（IE5 和 IE6 使用
 * ActiveXObject）。
 * 
 * open(method,url,async) method 请求的类型；GET 或 POST  
 * url：文件在服务器上的位置 
 * async：true（异步）或 false（同步）
 * 
 * onreadystatechange 存储函数（或函数名），每当 readyState 属性改变时，就会调用该函数。
 * readyState : 存有 XMLHttpRequest 的状态。从 0 到 4 发生变化。
		0: 请求未初始化
		1: 服务器连接已建立
		2: 请求已接收
		3: 请求处理中
		4: 请求已完成，且响应已就绪
 * status	
		200: "OK"
		404: 未找到页面
 * responseText	获得字符串形式的响应数据。
 * responseXML	获得 XML 形式的响应数据。
 * 
 * 
 * 
 */
$(function() {
	var rootPath = Svc.rootPath();
	function loadXMLDoc() {
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera,
			// Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				$("#content1").html(xmlhttp.responseText);
			}
			console.log(xmlhttp)
		}
		/**
		 * get请求
		 * 参数是放在 Query String Parameters
		 * 后台可以用request.getParameter("name")获取
		 * 后台可以用request.getQueryString获取
		 */
//		var url = rootPath + "/upload/test.jsp?name=mark&t=" + Math.random();
//		xmlhttp.open("GET", url, true);
//		xmlhttp.send();
		
		var url = rootPath + "/jquery/ajax/ajaxDemo.do";
		xmlhttp.open("POST", url, true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("name=zjj");
	}
	
	
	/**
	 * ajax封装的load方法
	 * load( url, [data], [callback] ) 
	 * 这个方法默认使用 GET 方式来传递的，如果[data]参数有传递数据进去，就会自动转换为POST方式的
	 */
	function ajaxLoad(){
		var url = rootPath + "/upload/test.jsp?name=mark&t=" + Math.random();
		$("#content1").load(url, {Action:"get",Name:"lulu"}, 
			function (responseText, textStatus, XMLHttpRequest){
				$(this).val(responseText);
				console.log(this);
			}
		);
	}
	
	/**
	 * ajax封装的get方法
	 * $.get( url, [data], [callback] )：
	 * 这个方法默认使用 GET 方式来传递的，如果[data]参数有传递数据进去，就会自动转换为POST方式的
	 */
	function ajaxGet(){
		var url = rootPath + "/upload/test.jsp";
		$.get(url, {Action:"get",Name:"lulu"}, 
			function (data, textStatus){
				console.log(this);
			}
		);
	}
	
	/**
	 * ajax封装的post方法
	 * $.post( url, [data], [callback], [type] ) 
	 * 这个方法默认使用 GET 方式来传递的，如果[data]参数有传递数据进去，就会自动转换为POST方式的
	 */
	function ajaxPost(){
		var url = rootPath + "/upload/test.jsp";
		$.post(url, {Action:"get",Name:"lulu"}, 
			function (data, textStatus){
				console.log(data);
			},"json"
		);
	}
	
	function regiterEvent(){
		$("input[name='btn1']").click(function(){
			loadXMLDoc();
		});
		$("input[name='btn2']").click(function(){
			ajaxLoad();
		});
		$("input[name='btn3']").click(function(){
			ajaxGet();
		});
		$("input[name='btn4']").click(function(){
			ajaxPost();
		});
		
		$("#submit").click(function(){
			var x1 = $("#form1").serializeArray();
			var x2 = $("#form1").serialize();
			console.log(x2);
		})
	}
	
	function initPage(){
		regiterEvent();
	}
	
	initPage();
})
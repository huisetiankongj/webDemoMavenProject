/**
 * jQuery的Deferred(延迟)对象
 * 
 */
$(function(){
	var rootPath = Svc.rootPath(),pluginPath=rootPath+"com/czx/plugin/";
	
	/**
	 * $.ajax()操作完成后，如果使用的是低于1.5.0版本的jQuery，返回的是XHR对象，你没法进行链式操作；
	 * 如果高于1.5.0版本，返回的是deferred对象，可以进行链式操作。
	 */
	
//	$.ajax(pluginPath+"jquery/jquery-1.10.2.js").done(function(){alert("成功了")}).fail(function(){
//		alert("失败了")
//	}).done(function(){ console.log("第二个回调函数！");} );
	
	
	/**
	 * 两个操作$.ajax(pluginPath+"jquery/jquery-1.10.2.js"), $.ajax("test2.html")都成功才能执行done
	 * 有一个失败就执行fail
	 */
	
//	　$.when($.ajax(pluginPath+"jquery/jquery-1.10.2.js"), $.ajax("test2.html"))
//	 .done(function(){ alert("哈哈，成功了！"); })
//	　.fail(function(){ alert("出错啦！"); });
	
	/**
	 * defeered扩展到对所有的操作进行延迟操作
	 */
	//1、如果没有对wait进行任何处理的话，会直接执行done，然后在进行延迟执行task
	//因为原因在于$.when()的参数只能是deferred对象
	
//	var wait1 = function(){
//		var task = function(){
//			alert("执行任务！");
//		}
//		setTimeout(task,5000);
//	}
//	
//	$.when(wait1()).done(function(){
//		alert("执行成功！")
//	}).fail(function(){
//		alert("执行失败！");
//	});
	
	//2、对wait函数进行改造，返回deferred对象
	//jquery中deferred对象有三个状态
	//未完成，已完成(resolved)和已失败(reject)
	
//	var dtd  = $.Deferred();//创建一个deferred对象
//	var wait2 = function(dtd ){
//		var tasks = function(){
//	　　　　　　alert("执行完毕！");
////	　　　　　　dtd.resolve(); // 改变deferred对象的执行状态(已完成)
//			dtd.reject(); // 改变deferred对象的执行状态(已失败)
//　　　　	};
//　　　　	setTimeout(tasks,5000);
//　　　	return dtd ;
//	} 
//	$.when(wait2(dtd)).done(function(){
//		alert("执行成功！")
//	}).fail(function(){
//		alert("执行失败！");
//	});
	
	/**
	 * dtd是一个全局对象，所以它的执行状态可以从外部改变。
	 * 未完成，已完成(resolved)和已失败(reject)
	 */
	var dtd  = $.Deferred();//创建一个deferred对象
	var wait2 = function(dtd ){
		var tasks = function(){
	　　　　　　alert("执行完毕！");
			dtd.reject(); // 改变deferred对象的执行状态(已失败)
　　　　	};
　　　　	setTimeout(tasks,5000);
　　　	return dtd ;
	} 
	$.when(wait2(dtd)).done(function(){
		alert("执行成功！")
	}).fail(function(){
		alert("执行失败！");
	});
	dtd.resolve();
	
	/**
	 * 进一步进行修改
	 */
	
	var dtd = $.Deferred(); // 新建一个Deferred对象
	var wait = function(dtd){

	　　　　var tasks = function(){

	　　　　　　alert("执行完毕！");

	　　　　　　dtd.resolve(); // 改变Deferred对象的执行状态

	　　　　};

	　　　　setTimeout(tasks,5000);

	　　　　return dtd;

	　　};

	　　$.when(wait(dtd))

	　　.done(function(){ alert("哈哈，成功了！"); })

	　　.fail(function(){ alert("出错啦！"); });

	　　dtd.resolve(); 

})
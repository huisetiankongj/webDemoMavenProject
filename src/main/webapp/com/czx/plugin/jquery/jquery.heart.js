(function(w,$){
	if(!w.Svc){
		w.Svc = {};
	}
	
	Svc.rootPath = function(){
		var obj = w.location;
		var projectName = obj.pathname.split("/")[1];
		var rootPath = obj.protocol+"//"+obj.host+"/"+projectName+"/";
		console.log(rootPath)
		return rootPath;
	}
})(window,jQuery);
//数组移除元素方法
Array.prototype.remove = function(val) {   
	var index = this.indexOf(val);   
	if (index > -1) {   
		this.splice(index, 1);   
	}   
};
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
//�����Ƴ�Ԫ�ط���
Array.prototype.remove = function(val) {   
	var index = this.indexOf(val);   
	if (index > -1) {   
		this.splice(index, 1);   
	}   
};
(function(){
	
	/**
	 * jQuery.Callbacks( flags ) 提供的回调函数队列管理
	 * flags 一个可选的空格分隔的列表表示,改变回调列表的行为
	 */
	//once: 确保这个回调列表只执行
	//设置once在执行第一次fire后会直接禁用该Callbacks(fire函数代码段else {self.disable();})
	var f1 = function(value) { console.log(value); };
	var callbacks = $.Callbacks('once');
	
	callbacks.add(f1);//无执行结果,添加一个回调
	callbacks.fire(1);//执行结果1。清除回调列表
	callbacks.add(f1);//没有添加回调直接返回
	callbacks.fire(2);//无执行结果
	callbacks.add(f1);//没有添加回调直接返回
	callbacks.fire(3);//无执行结果
	
	//memory
	//保持以前的值（参数），将函数添加到这个列表的后面，并使用先前保存的参数立即执行该函数。 内部变量会保存上次执行的场景。
	//他有一个特点，就是在第一次fire之前使用add添加的回调都不会马上执行，只有调用了一次fire之后使用add添加的回调会马上执行。该设置本身不会清除之前的回调列表。
	//需要注意的是每次add内部执行fire函数都会将firingStart置为0，只有下次add的时候会从新设置firingStart的值

	var fn2 = function(value) {    console.log(value); };
	var callbacks = $.Callbacks("memory");
	 
	callbacks.add( fn2 );//无执行结果
	callbacks.fire( "1" );//执行结果1。保存场景参数1
	 
	callbacks.add( fn2 );//执行结果1。使用上次保存的场景参数1
	callbacks.fire( "2" );//执行结果2,2。保存场景参数2
	 
	callbacks.add( fn2 );//执行结果2。使用上次保存的场景参数2
	callbacks.fire( "3" );//执行结果3,3,3。保存场景参数3
	 
	callbacks.add( fn2 );//执行结果3。使用上次保存的场景参数3
	callbacks.fire( "4" );//执行结果4,4,4,4。保存场景参数4
	
	//unique: 确保一次只能添加一个回调(所以在列表中没有重复的回调).
	var fn2 = function(value) {    console.log(value); };
	var callbacks = $.Callbacks("unique");
	
	//组合使用，组合使用中间使用空格隔开
	//设置“once memory”, options.once=options.memory=true。在执行第一次fire后会把回到列表清空，而且之后每次add马上执行后页同样会把回调列表清空（fire函数代码段else if ( memory ) {list = [];}）。
	
	var callbacks = $.Callbacks('once memory');

	callbacks.add(f1);//无执行结果,添加一个回调
	callbacks.fire(1);//执行结果1。清除回调列表，保存场景参数1
	callbacks.add(f1);//添加一个回调并执行结果1，使用上次保存的场景参数。清除回调列表
	callbacks.fire(2);//无执行结果
	callbacks.add(f1);//添加一个回调并执行结果1，使用上次保存的场景参数。清除回调列表
	callbacks.fire(3);//无执行结果
	
	
	
})();
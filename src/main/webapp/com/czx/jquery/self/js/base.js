/**
 * 1、jQuery.extend jQuery.fn.extend 区别
 * 2、正则表达式测试方法
 * 3、创建函数，直接在函数存值
 * 4、数组的一些常用方法
 * 5、写自己的选择器
 * 
 */

;(function(){
	/**
	 * ============1====================
	 * jQuery.extend jQuery.fn.extend 区别
	 * a)jQuery.extend :
	 * jQuery这个类看成是人类，能吃饭能喝水能跑能跳，
	 * 现在我们用jQuery.extend这个方法给这个类拓展一个能唱歌的技能
	 * jQuery这个类本身的方法（object）嘛。他现在能”唱歌“了。
	 * 但是吧，这个能力啊，只有代表全人类的 jQuery 这个类本身，才能用啊。你个人想用，你张三李四王五麻六，你个小草民能代表全人类嘛？
	 * 所以啊，这个扩展也就是所谓的静态方法。只跟这个 类 本身有关。跟你具体的实例化对象是没关系滴
	 * 【$.extend浅度拷贝的时候，拷贝对象的时候如果是直接拷贝该对象的引用地址，所以当该对象的值改变，则拷贝的内容也跟着改变】
	 * 
	 * b)jQuery.fn.extend
	 * jQuery.fn.extend拓展的是jQuery对象（原型的）的方法啊！
	 * 对象是啥？就是类的实例化嘛，例如
	 * $("#abc")这个玩意就是一个实例化的jQuery对象嘛
	 * 那就是说，jQuery.fn.extend拓展的方法，你得用在jQuery对象上面才行啊！他得是张三李四王五痳六这些实例化的对象才能用啊。
	 * 说白了就是得这么用（假设xyz()是拓展的方法）：
	 * $('selector').xyz();
	 */
	$.extend({
		min: function(a, b) { return a < b ? a : b; },
		max: function(a, b) { return a > b ? a : b; }
	});
	
	console.log($.min(3,4));  //3
	
	$.fn.tt = function(){
		return this;
	}
	
	console.log($("#btn1").tt())
	
	
	/**
	 * ============2==================
	 * 正则表达式测试方法
	 * a)RegExpObject.test(string)                    用于检测一个字符串是否匹配某个模式。
	 * 		返回值ture|false
	 * 
	 * b)stringObject.match(searchvalue | regexp)     可在字符串内检索指定的值，或找到一个或多个正则表达式的匹配
	 *      match() 方法将检索字符串 stringObject，
	 *      以找到一个或多个与 regexp 匹配的文本。这个方法的行为在很大程度上有赖于 regexp 是否具有标志 g
	 * 		如果 regexp 没有标志 g，
	 * 			那么 match() 方法就只能在 stringObject 中执行一次匹配。
	 * 			如果没有找到任何匹配的文本， match() 将返回 null。
	 * 			否则，它将返回一个数组，其中存放了与它找到的匹配文本有关的信息。【该数组的第 0 个元素存放的是匹配文本，而其余的元素存放的是与正则表达式的子表达式匹配的文本。除了这些常规的数组元素之外，返回的数组还含有两个对象属性。
	 * 			index 属性声明的是匹配文本的起始字符在 stringObject 中的位置，input 属性声明的是对 stringObject 的引用】
	 * 		如果 regexp 具有标志 g，
	 * 			则 match() 方法将执行全局检索，找到 stringObject 中的所有匹配子字符串。
	 * 			若没有找到任何匹配的子串，则返回 null。
	 * 			如果找到了一个或多个匹配子串，则返回一个数组。不过全局匹配返回的数组的内容与前者大不相同，它的数组元素中存放的是 stringObject 中所有的匹配子串，
	 * 			而且也没有 index 属性或 input 属性。
	 * 注意：在全局检索模式下，match() 即不提供与子表达式匹配的文本的信息，也不声明每个匹配子串的位置。如果您需要这些全局检索的信息，可以使用 RegExp.exec()。
	 * 
	 * c)RegExpObject.exec(string)  返回一个数组，其中存放匹配的结果。如果未找到匹配，则返回值为 null。
	 *      如果 regexp 没有标志 g，
	 *      	则 exec() 找到了匹配的文本，则返回一个结果数组。否则，返回 null。【此数组的第 0 个元素是与正则表达式相匹配的文本，第 1 个元素是与 RegExpObject 的第 1 个子表达式相匹配的文本（如果有的话），
	 *      	第 2 个元素是与 RegExpObject 的第 2 个子表达式相匹配的文本（如果有的话），以此类推。除了数组元素和 length 属性之外，exec() 方法还返回两个属性。
	 *      	index 属性声明的是匹配文本的第一个字符的位置。input 属性则存放的是被检索的字符串 string】。
	 *      	我们可以看得出，在调用非全局的 RegExp 对象的 exec() 方法时，返回的数组与调用方法 String.match() 返回的数组是相同的
	 *      如果 regexp 有标志 g，
	 *      	则 exec() 的行为就稍微复杂一些。
	 *      	它会在 RegExpObject 的 lastIndex 属性指定的字符处开始检索字符串 string。
	 *      	当 exec() 找到了与表达式相匹配的文本时，在匹配后，它将把 RegExpObject 的 lastIndex 属性设置为匹配文本的最后一个字符的下一个位置。
	 *      	这就是说，您可以通过反复调用 exec() 方法来遍历字符串中的所有匹配文本。
	 *      	当 exec() 再也找不到匹配的文本时，它将返回 null，并把 lastIndex 属性重置为 0
	 * 
	 */
	
	//RegExpObject.test(string)
	var regExpObject2 = /^\d{2}$/;
	console.log(regExpObject2.test("12")); //true
	
	//stringObject.match(searchvalue)
	var _str2="Hello world!"
	console.log(_str2.match("world"));  //true
	
	//stringObject.match(regexp)
	str2="1 plus 2 equal 3"
	console.log(str2.match(/\d+/g));    //["1", "2", "3"] 
	console.log(str2.match(/\d+/));     //["1", index: 0, input: "1 plus 2 equal 3"] 
	
	//RegExpObject.exec(string) 
	var str2="Visit W3School, W3School is a place to study web technology.";
	var patt2 = new RegExp("W3School","");
	console.log(patt2.exec(str2));   //["W3School", index: 6, input: "Visit W3School, W3School is a place to study web technology."]  
	console.log(patt2.lastIndex);    //0 
	console.log(patt2.exec(str2));   //["W3School", index: 6, input: "Visit W3School, W3School is a place to study web technology."]  
	console.log(patt2.lastIndex);    //0
	console.log(patt2.exec(str2));   //["W3School", index: 6, input: "Visit W3School, W3School is a place to study web technology."]  
	console.log(patt2.lastIndex);    //0
	var patt = new RegExp("W3School","g");
	console.log(patt.exec(str2));   //["W3School", index: 6, input: "Visit W3School, W3School is a place to study web technology."] 
	console.log(patt.lastIndex);    //14 
	console.log(patt.exec(str2));   //["W3School", index: 16, input: "Visit W3School, W3School is a place to study web technology."] 
	console.log(patt.lastIndex);    //24
	console.log(patt.exec(str2));   //null 
	console.log(patt.lastIndex);    //0
	
	var str = "Visit W3School sfsffs test W3School W3School";
　　 	var patt = new RegExp(/(W3)(School)/);
　　	var result = patt.exec(str);// ["W3School", "W3", "School", index: 6, input: "Visit W3School sfsffs test W3School W3School"] 
　　	result.index;//6
　　	result.input;// "Visit W3School sfsffs test W3School W3School" 

　　	patt = new RegExp(/(W3)(School)/g);
　　	result = patt.exec(str);// ["W3School", "W3", "School", index: 6, input: "Visit W3School sfsffs test W3School W3School"] 
　　	result.index;//6
　　	patt.lastIndex;//14
　　	result = patt.exec(str);// ["W3School", "W3", "School", index: 27, input: "Visit W3School sfsffs test W3School W3School"] 
　　	result.index;//27
　　	patt.lastIndex;//35
　　	
　　	/**
　　	 * ============3==================
　　	 * 创建函数，直接在函数存值
　　	 * 
　　	 */
　　	function createCache() {
		var keys = [];
		function cache( key, value ) {
			// Use (key + " ") to avoid collision with native prototype properties (see Issue #157)
			cache[ key ] = value;
			return cache;
		}
		return cache;
	}

	var tokeCache = createCache();
	console.log(tokeCache);        //function cache( key, value ) {...
	tokeCache("s","czx");
	console.log(tokeCache["s"])   //function cache( key, value ) {s:czx arguments: null caller: null  length: 2
	/**
	 * ============4==================
	 * 数组的一些常用方法
	 * a、slice(start,end) 方法可从已有的数组中返回选定的元素。
	 * 		arrayObject.slice(start,end) 
	 * 			start 必需  规定从何处开始选取。如果是负数，那么它规定从数组尾部开始算起的位置。也就是说，-1 指最后一个元素，-2 指倒数第二个元素，以此类推。
	 * 			end 可选。规定从何处结束选取。该参数是数组片断结束处的数组下标。如果没有指定该参数，那么切分的数组包含从 start 到数组结束的所有元素。如果这个参数是负数，那么它规定的是从数组尾部开始算起的元素。
	 * 			返回值：返回一个新的数组，包含从 start 到 end （不包括该元素）的 arrayObject 中的元素。 
	 * b、shift() 方法用于把数组的第一个元素从其中删除，并返回第一个元素的值。【会改变原来的数组】
	 * 		arrayObject.shift()
	 * 		返回值：数组原来的第一个元素的值。
	 * c、pop()  方法用于删除并返回数组的最后一个元素。   【会改变原来的数组】
	 * 		arrayObject.pop()
	 * 		返回值：arrayObject 的最后一个元素。
	 * d、splice() 方法向/从数组中添加/删除项目，然后返回被删除的项目。【会改变原来的数组】
	 * 		arrayObject.splice(index,howmany,item1,.....,itemX)
	 * 			index 必需。整数，规定添加/删除项目的位置，使用负数可从数组结尾处规定位置。 
	 * 			howmany 必需。要删除的项目数量。如果设置为 0，则不会删除项目。 
	 * 			item1, ..., itemX 可选。向数组添加的新项目。
	 * 			返回值：Array 【包含被删除项目的新数组】，如果有的话。 
	 * e、unshift() 方法可向数组的开头添加一个或更多元素，并返回新的长度。 
	 * 		arrayObject.unshift(newelement1,newelement2,....,newelementX)
	 * 			newelement1 必需。向数组添加的第一个元素。 
	 * 			newelement2 可选。向数组添加的第二个元素。 
	 * 			newelementX 可选。可添加若干个元素。 
	 * 			返回值：【arrayObject 的新长度】
	 */
	
	//slice()
	var arr41 = new Array(3)
	arr41[0] = "George"
	arr41[1] = "John"
	arr41[2] = "Thomas"
	 
	console.log(arr41)             //George,John,Thomas
	console.log(arr41.slice(1))    //John,Thomas
	console.log(arr41)             //["George", "John", "Thomas"] 
	
	//shift()
	var arr42 = new Array(3)
	arr42[0] = "George"
	arr42[1] = "John"
	arr42[2] = "Thomas"
	
	console.log(arr42)      	   //George,John,Thomas   
	console.log(arr42.shift())     //George
	console.log(arr42)             //["John", "Thomas"] 
	
	//pop()
	var arr43 = new Array(3)
	arr43[0] = "George"
	arr43[1] = "John"
	arr43[2] = "Thomas"
	
	console.log(arr43)      	   //George,John,Thomas   
	console.log(arr43.pop())    	//Thomas
	console.log(arr43)             //["George", "John"]
	
	
	var arr44 = new Array(6)
	arr44[0] = "George"
	arr44[1] = "John"
	arr44[2] = "Thomas"
	arr44[3] = "James"
	arr44[4] = "Adrew"
	arr44[5] = "Martin"

	console.log(arr44)			  //George,John,Thomas,James,Adrew,Martin
	arr44.splice(2,1,"William");
	console.log(arr44)            //George,John,William,Thomas,James,Adrew,Martin
	
	var arr45 = new Array()
	arr45[0] = "George"
	arr45[1] = "John"
	arr45[2] = "Thomas"
	
	console.log(arr45);						//George,John,Thomas
	console.log(arr45.unshift("William"));	//4
	console.log(arr45);						//William,George,John,Thomas

	
	/**
	 *  ============5==================
	 * 写自己的选择器
	 */
	 $.extend($.expr[':'], {
	       moreThen1000px: function(a) {
	           return $(a).width() > 1000;
	      }
	   });
	  $('.box:moreThen1000px').click(function() {
	      // creating a simple js alert box
	      alert('The element that you have clicked is over 1000 pixels wide');
	  });
	  /**
		 *  ============6==================
		 * 使用自己的 Bullets
		 */
	  $("ul").addClass("Replaced");
	   $("ul > li").prepend("‒ ");
	 // how to use
	 ul.Replaced { list-style : none;}
	 
	 
	 /**
	  * ============7==================
	  * call和apply的区别
	  * a.call:
	  * 	语法：call([thisObj[,arg1[, arg2[,   [,.argN]]]]]) 
	  * 	定义：调用一个对象的一个方法，以另一个对象替换当前对象。 
	  * 	说明： 
	  *			call 方法可以用来代替另一个对象调用一个方法。call 方法可将一个函数的对象上下文从初始的上下文改变为由 thisObj 指定的新对象。 
	  *			如果没有提供 thisObj 参数，那么 Global 对象被用作 thisObj
	  *	b.apply方法： 
	  *		语法：apply([thisObj[,argArray]]) 
	  *		定义：应用某一对象的一个方法，用另一个对象替换当前对象。 
	  *		说明： 
	  *		如果 argArray 不是一个有效的数组或者不是 arguments 对象，那么将导致一个 TypeError。 
	  *		如果没有提供 argArray 和 thisObj 任何一个参数，那么 Global 对象将被用作 thisObj， 并且无法被传递任何参数。
	  */
	 
	 function Animal(name){
		 this.name = name;
		 this.showName = function(){
			 console.log(this.name)
		 }
	 }
	 
	 function Cat(name){
		 this.name = name;
	 }
	 
	 var animal = new Animal("animal");
	 var cat = new Cat("kafei");
	 animal.showName.call(cat);//kafei
	//animal.showName.apply(cat,[]);  //kafei
	 
	 //还可以继承
	 function Mouse(name){
		 Animal.call(this,name);
	 }
	 var mouse = new Mouse("鸟迟工");
	 console.log(mouse.showName()) //"鸟迟工"
	 
	 
	 /**
	  * $.proxy(function,context)
	  * 	参数：function:将要被改变作用域的函数
	  * 		context:一个object，那个函数的作用域会被设置到这个object上来
	  * $.proxy(context,name)
	  * 	参数：context:一个object，那个函数的作用域会被设置到这个object上来
	  * 		name:改变上下文中的函数名（这个函数必须是前一个参数context对应的属性）
	  */
	 var obj = {
		 	name: "John",
		 	test: function() {
		 		alert( this.name );
		 		$("#test").unbind("click", obj.test);
		 	}
		};

	$("#test").click( jQuery.proxy( obj, "test" ) );

	// 以下代码跟上面那句是等价的:
	// $("#test").click( jQuery.proxy( obj.test, obj ) );  //name的值为空

	 
})();
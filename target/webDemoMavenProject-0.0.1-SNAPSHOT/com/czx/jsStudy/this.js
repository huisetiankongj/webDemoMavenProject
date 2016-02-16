/**
*	==========================this的学习===================================
*/
(function(){
	/**
	 * this(不是变量，不是属性，不能为其赋值，它【始终指向调用它的对象】)
	 *		
	 */
	//例1 该处调用该段代码的直接对象是全局对象
	console.log(this === window)//true;
	
	//例2 该处虽然是函数，但是调用其的仍然是"window"(不要弄混了，函数虽然是对象，但是调用它的是另一个对象)
	var test = function(){
        console.log(this === window);
	}
	test();  //true;
	
	//例3该处使用了"new" 这时其实已经发生变化了，这是一个构造函数，构造函数创建时创建了一个新的空的对象，
	//即"new test()"创建了一个新的对象，然后再由这个对象指向函数"test"中的代码，因此此时this不在是window对象，
	//而是该构造函数创建的新对象
	var test = function(){
        alert(this === window);
    }

	new test();//false;
	
	//例4
	var test ={
	        'a':1,
	        'b':function(){
	            console.log(this === test)
	        }
	    }

		test.b(); //true;
	//例5	虽然'test1'的值为'test'  但是'test1'不还是'test'对象么，它有新产生对象，你暂且理解为引用的了，两个都指向一个对象
	var test ={
        'a':1,
        'b':function(){
        	console.log(this === test)
        }
    }

	var test1 = test;
	test1.b(); //true;

	//例6
	var test ={
	        'a':1,
	        'b':{
	            'b1':function(){
	                console.log(this === test);
	            }
	        }
	    }
	test.b.b1();
	
	//例7
	var test ={
	        'a':1,
	        'b':{
	            'b1':function(){
	                alert(this === test.b);
	            }
	        }
	    }
	test.b.b1();//true 这时"this"不再直接被'test'调用了，而是被'test.b' 调用
	//例8
	var test = function(){
        var innerTest = function(){
            alert(this === test);
        }
        innerTest();
    }
	test();

	//例9
	var test = function(){
        var innerTest = function(){
            alert(this === test);
        }
        innerTest();
    }
	test();//false
	//你不会认为弹出"true"吧，不是按照上面的理论'innerTest'是被'test'调用的，然后'this'就指向'test'吗？
	//额，错就错在是谁调用的'innerTest', 其实这种函数都是'window'对象调用的，及时你嵌套一千层，调用各个函数的都是'window'对象,
	//奉上下面这段代码为证
	//例10
	var test = function(){
        var innerTest = function(){
            alert(this === window);

            var innerTest1 = function(){
                alert(this === window);
            }
            innerTest1();
        }
        innerTest();
    }
	test();
	
	//例11 该函数的作用就是”调用一个对象的一个方法，以另一个对象替换当前对象“ 所以了'window' 
	// 对象已经被替代为'test1'，自然为'false'了,奉上如下代码以为证明
	var test = function(){
        alert(this === test1);
    }
	var test1 = {
	}
	test.apply(test1);//true 
	
	//例12 原型的继承，区别于字面量的继承
	var test = function(){
    }

    var my = function(){
        this.a = function(){
            alert(this === mytest2);
        }
    }

    var mytest = new my();
    test.prototype = mytest;
    var mytest2 = new test();
    mytest2.a();//true
    
    //例13
	//可能就是'dom'对象了
	/*<script>
	    var mytest = function(context){
	        alert(context.getAttribute('id'));
	        alert(this === window);
	    }
	</script>
	<div id="test" onclick="mytest(this)">aaaa</div>*/

})();
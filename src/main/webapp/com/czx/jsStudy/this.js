/**
*	==========================this��ѧϰ===================================
*/
(function(){
	/**
	 * this(���Ǳ������������ԣ�����Ϊ�丳ֵ������ʼ��ָ��������Ķ���)
	 *		
	 */
	//��1 �ô����øöδ����ֱ�Ӷ�����ȫ�ֶ���
	console.log(this === window)//true;
	
	//��2 �ô���Ȼ�Ǻ��������ǵ��������Ȼ��"window"(��ҪŪ���ˣ�������Ȼ�Ƕ��󣬵��ǵ�����������һ������)
	var test = function(){
        console.log(this === window);
	}
	test();  //true;
	
	//��3�ô�ʹ����"new" ��ʱ��ʵ�Ѿ������仯�ˣ�����һ�����캯�������캯������ʱ������һ���µĿյĶ���
	//��"new test()"������һ���µĶ���Ȼ�������������ָ����"test"�еĴ��룬��˴�ʱthis������window����
	//���Ǹù��캯���������¶���
	var test = function(){
        alert(this === window);
    }

	new test();//false;
	
	//��4
	var test ={
	        'a':1,
	        'b':function(){
	            console.log(this === test)
	        }
	    }

		test.b(); //true;
	//��5	��Ȼ'test1'��ֵΪ'test'  ����'test1'������'test'����ô�������²����������������Ϊ���õ��ˣ�������ָ��һ������
	var test ={
        'a':1,
        'b':function(){
        	console.log(this === test)
        }
    }

	var test1 = test;
	test1.b(); //true;

	//��6
	var test ={
	        'a':1,
	        'b':{
	            'b1':function(){
	                console.log(this === test);
	            }
	        }
	    }
	test.b.b1();
	
	//��7
	var test ={
	        'a':1,
	        'b':{
	            'b1':function(){
	                alert(this === test.b);
	            }
	        }
	    }
	test.b.b1();//true ��ʱ"this"����ֱ�ӱ�'test'�����ˣ����Ǳ�'test.b' ����
	//��8
	var test = function(){
        var innerTest = function(){
            alert(this === test);
        }
        innerTest();
    }
	test();

	//��9
	var test = function(){
        var innerTest = function(){
            alert(this === test);
        }
        innerTest();
    }
	test();//false
	//�㲻����Ϊ����"true"�ɣ����ǰ������������'innerTest'�Ǳ�'test'���õģ�Ȼ��'this'��ָ��'test'��
	//���ʹ�����˭���õ�'innerTest', ��ʵ���ֺ�������'window'������õģ���ʱ��Ƕ��һǧ�㣬���ø��������Ķ���'window'����,
	//����������δ���Ϊ֤
	//��10
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
	
	//��11 �ú��������þ��ǡ�����һ�������һ������������һ�������滻��ǰ���� ������'window' 
	// �����Ѿ������Ϊ'test1'����ȻΪ'false'��,�������´�����Ϊ֤��
	var test = function(){
        alert(this === test1);
    }
	var test1 = {
	}
	test.apply(test1);//true 
	
	//��12 ԭ�͵ļ̳У��������������ļ̳�
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
    
    //��13
	//���ܾ���'dom'������
	/*<script>
	    var mytest = function(context){
	        alert(context.getAttribute('id'));
	        alert(this === window);
	    }
	</script>
	<div id="test" onclick="mytest(this)">aaaa</div>*/

})();
/**
 * 
 */
$(function(){
	 /**
	  * 1.EXT基本方法、属性（onReady、define、create） 
	  * 	onReady:只有在Ext框架全部加载完后才能在客户端的代码中使用Ext，
	  * 			而Ext的onReady正是用来注册在Ext框架及页面的html代码加载完后，所要执行的函数。
	  */
	
	/* function sayHellow() {
         alert("hi , everyone !");  //可执行
         Ext.Msg.alert("title", "hi , everyone !");  //报错，关于呈现Ext元素组件的都只能在onReady中执行。
     }
      sayHellow()
     // Ext.onReady(sayHellow);   
*/      
      Ext.onReady(function () {
            //创建一个类，类名：TextClass，具有两个属性：A、B
            Ext.define('TextClass', {
                A: 'a',
                B: 'b'
            });
            //实例化类
            var textClass = new TextClass();
            //输出属性名
            console.log(textClass);
        }); 
	 Ext.onReady(function () {
         //创建一个panel
         Ext.create("Ext.panel.Panel", {
             //id
             id: 'myPanel',
             //标题
             title: 'Ext的panel组件',
             //渲染到id为“ExtComponent”的<div>标签
             renderTo: 'ExtComponent',
             //宽
             width: 300,
             //高
             height: 300
         })
         setTimeout('Ext.getCmp("myPanel").setTitle("使用getCmp获取组件")', 5000);   //5秒后标题变为：“使用getCmp获取组件”            
     });
	
})
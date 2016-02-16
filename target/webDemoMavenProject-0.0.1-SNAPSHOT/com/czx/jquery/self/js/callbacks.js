(function(){
	
	/**
	 * jQuery.Callbacks( flags ) �ṩ�Ļص��������й���
	 * flags һ����ѡ�Ŀո�ָ����б��ʾ,�ı�ص��б����Ϊ
	 */
	//once: ȷ������ص��б�ִֻ��
	//����once��ִ�е�һ��fire���ֱ�ӽ��ø�Callbacks(fire���������else {self.disable();})
	var f1 = function(value) { console.log(value); };
	var callbacks = $.Callbacks('once');
	
	callbacks.add(f1);//��ִ�н��,���һ���ص�
	callbacks.fire(1);//ִ�н��1������ص��б�
	callbacks.add(f1);//û����ӻص�ֱ�ӷ���
	callbacks.fire(2);//��ִ�н��
	callbacks.add(f1);//û����ӻص�ֱ�ӷ���
	callbacks.fire(3);//��ִ�н��
	
	//memory
	//������ǰ��ֵ������������������ӵ�����б�ĺ��棬��ʹ����ǰ����Ĳ�������ִ�иú����� �ڲ������ᱣ���ϴ�ִ�еĳ�����
	//����һ���ص㣬�����ڵ�һ��fire֮ǰʹ��add��ӵĻص�����������ִ�У�ֻ�е�����һ��fire֮��ʹ��add��ӵĻص�������ִ�С������ñ��������֮ǰ�Ļص��б�
	//��Ҫע�����ÿ��add�ڲ�ִ��fire�������ὫfiringStart��Ϊ0��ֻ���´�add��ʱ����������firingStart��ֵ

	var fn2 = function(value) {    console.log(value); };
	var callbacks = $.Callbacks("memory");
	 
	callbacks.add( fn2 );//��ִ�н��
	callbacks.fire( "1" );//ִ�н��1�����泡������1
	 
	callbacks.add( fn2 );//ִ�н��1��ʹ���ϴα���ĳ�������1
	callbacks.fire( "2" );//ִ�н��2,2�����泡������2
	 
	callbacks.add( fn2 );//ִ�н��2��ʹ���ϴα���ĳ�������2
	callbacks.fire( "3" );//ִ�н��3,3,3�����泡������3
	 
	callbacks.add( fn2 );//ִ�н��3��ʹ���ϴα���ĳ�������3
	callbacks.fire( "4" );//ִ�н��4,4,4,4�����泡������4
	
	//unique: ȷ��һ��ֻ�����һ���ص�(�������б���û���ظ��Ļص�).
	var fn2 = function(value) {    console.log(value); };
	var callbacks = $.Callbacks("unique");
	
	//���ʹ�ã����ʹ���м�ʹ�ÿո����
	//���á�once memory��, options.once=options.memory=true����ִ�е�һ��fire���ѻص��б���գ�����֮��ÿ��add����ִ�к�ҳͬ����ѻص��б���գ�fire���������else if ( memory ) {list = [];}����
	
	var callbacks = $.Callbacks('once memory');

	callbacks.add(f1);//��ִ�н��,���һ���ص�
	callbacks.fire(1);//ִ�н��1������ص��б����泡������1
	callbacks.add(f1);//���һ���ص���ִ�н��1��ʹ���ϴα���ĳ�������������ص��б�
	callbacks.fire(2);//��ִ�н��
	callbacks.add(f1);//���һ���ص���ִ�н��1��ʹ���ϴα���ĳ�������������ص��б�
	callbacks.fire(3);//��ִ�н��
	
	
	
})();
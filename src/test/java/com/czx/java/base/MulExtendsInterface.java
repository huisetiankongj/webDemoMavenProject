package com.czx.java.base;

import com.czx.test.IRunableA;
import com.czx.test.ISingable;

/**
 * �ӿ��ǳ����ͷ�������ļ��ϣ���һ������ĳ�����
 * java���ǵ��̳С�ClassB extends ClassA
 * java�ӿ��ǿ��Զ�̳С� InterfaceA extends InterfaceB,InterfaceC,InterfaceD
 * ����������ؼ̳е���Ҫԭ���ǣ����Aͬʱ�̳�B��C����B��Cͬʱ����һ��D������A��ξ����̳���һ���أ�
 * ���ӿڲ��������������⣬�ӿ�ȫ���ǳ��󷽷�˭������ν�����Խӿڿ��Լ̳ж���ӿ�
 * 
 * MulExtendsInterface����ӿڼ̳���IRunableA,ISingable�������ӿ�
 * ���������ӿڶ���һ��test���󷽷�
 * @author admin
 *
 */
public interface MulExtendsInterface extends IRunableA,ISingable{

	public void mulExtends();
}

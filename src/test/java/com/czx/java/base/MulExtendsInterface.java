package com.czx.java.base;

import com.czx.test.IRunableA;
import com.czx.test.ISingable;

/**
 * 接口是常亮和方法定义的集合，是一种特殊的抽象类
 * java类是单继承。ClassB extends ClassA
 * java接口是可以多继承。 InterfaceA extends InterfaceB,InterfaceC,InterfaceD
 * 不允许类多重继承的主要原因是，如果A同时继承B和C，而B和C同时都有一个D方法，A如何决定继承哪一个呢？
 * 但接口不存在这样的问题，接口全都是抽象方法谁都无所谓，所以接口可以继承多个接口
 * 
 * MulExtendsInterface这个接口继承了IRunableA,ISingable这两个接口
 * 其中两个接口都有一个test抽象方法
 * @author admin
 *
 */
public interface MulExtendsInterface extends IRunableA,ISingable{

	public void mulExtends();
}

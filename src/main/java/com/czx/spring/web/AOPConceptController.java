package com.czx.spring.web;
/**
 * AOP ����
 * 1��in AOP the unit of modularity is the aspect
 * (aspect��AOP����Ҫ�ĵ�Ԫģ��)
 * 2��One of the key components of Spring is the AOP framework. While the Spring IoC container does not depend on AOP
 * ��AOP��spring�ؼ����֮һ����spring IOC����������AOP��
 * 3��AOP complements Spring IoC to provide a very capable middleware solution
 * ��AOP���Ϊspring IOC�ṩ���ʵ��м�����������
 * 4��Spring 2.0 introduces a simpler and more powerful way of writing custom aspects using either a schema-based approach or the @AspectJ annotation style
 * spring �ṩ�򵥶�ǿ��Ŀ��Զ����д���淽ʽ������schema��ʽ��ע�ⷽʽ��
 * 5��Aspect�����棩��
 * Aspect are implemented using regular classes (the schema-based approach) or regular classes annotated with the @Aspect annotation (the @AspectJ style).
 * �����������ͨ������ע�����ͨ����ʵ��
 * 6��Join point�����ӵ㣩��
 *  a point during the execution of a program, such as the execution of a method or the handling of an exception. In Spring AOP, a join point always represents a method execution
 *  ����ִ�е�һ���㣬�񷽷���ִ�л����쳣�Ĵ���
 * 7��Advice ��֪ͨ��
 * action taken by an aspect at a particular join point. Different types of advice include "around," "before" and "after" advice
 * ����һ���������ӵ����Ϊ������������around��before��������
 * 8��Pointcut������㣩
 *   1��Advice is associated with a pointcut expression and runs at any join point matched by the pointcut 
 * 		֪ͨͨ��һ���������ʽ�������ӵ�
 *	 2�� Spring uses the AspectJ pointcut expression language by default
 *		spring ��AspectJ�������ʽ����
 * 9�� AOP proxy will be a JDK dynamic proxy or a CGLIB proxy
 * AOP���������jdk��̬�����cglib����
 * 10 Weaving��֯�룩
 * This can be done at compile time (using the AspectJ compiler, for example), load time, or at runtime. Spring AOP, like other pure Java AOP frameworks, performs weaving at runtime
 * �����ڱ����ڣ������������������ڣ�spring AOP����������
 * 11 
 * 
 * 
 *@author admin
 */
public class AOPConceptController {

}

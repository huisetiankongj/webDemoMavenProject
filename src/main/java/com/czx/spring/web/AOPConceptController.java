package com.czx.spring.web;
/**
 * AOP 概念
 * 1、in AOP the unit of modularity is the aspect
 * (aspect是AOP最重要的单元模块)
 * 2、One of the key components of Spring is the AOP framework. While the Spring IoC container does not depend on AOP
 * （AOP是spring关键组成之一，但spring IOC容器不依赖AOP）
 * 3、AOP complements Spring IoC to provide a very capable middleware solution
 * （AOP组件为spring IOC提供合适的中间件解决方案）
 * 4、Spring 2.0 introduces a simpler and more powerful way of writing custom aspects using either a schema-based approach or the @AspectJ annotation style
 * spring 提供简单而强大的可自定义编写切面方式（基于schema方式和注解方式）
 * 5、Aspect（切面）：
 * Aspect are implemented using regular classes (the schema-based approach) or regular classes annotated with the @Aspect annotation (the @AspectJ style).
 * 切面可以用普通类或基于注解的普通类来实现
 * 6、Join point（连接点）：
 *  a point during the execution of a program, such as the execution of a method or the handling of an exception. In Spring AOP, a join point always represents a method execution
 *  程序执行的一个点，像方法的执行或者异常的处理
 * 7、Advice （通知）
 * action taken by an aspect at a particular join point. Different types of advice include "around," "before" and "after" advice
 * 切面一个特殊连接点的行为动作，（包括around，before。。。）
 * 8、Pointcut（切入点）
 *   1）Advice is associated with a pointcut expression and runs at any join point matched by the pointcut 
 * 		通知通过一个切入点表达式关联连接点
 *	 2） Spring uses the AspectJ pointcut expression language by default
 *		spring 用AspectJ切入点表达式语言
 * 9、 AOP proxy will be a JDK dynamic proxy or a CGLIB proxy
 * AOP代理可以是jdk动态代理或cglib代理
 * 10 Weaving（织入）
 * This can be done at compile time (using the AspectJ compiler, for example), load time, or at runtime. Spring AOP, like other pure Java AOP frameworks, performs weaving at runtime
 * 可以在编译期，加载器，或者运行期，spring AOP是在运行期
 * 11 
 * 
 * 
 *@author admin
 */
public class AOPConceptController {

}

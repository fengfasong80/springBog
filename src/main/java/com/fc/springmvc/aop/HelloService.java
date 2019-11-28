package com.fc.springmvc.aop;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class HelloService {

	
	/**
	 * 如果我们要在sayHello()执行之前，打印一段代码，该怎么做呢？
	 */
	public void sayHello() {
		System.out.println("hello world");
	}
	
	/**
	 * 如果我们要在sayHello()执行之前，打印一段代码，该怎么做呢？
	 */
	@Clear
	public void sayHelloHelloWorld() {
		System.out.println("hello world");
	}
	
	public static class BeforeMethod implements MethodInterceptor{

		@Override
		public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
			Object result = null;
			if (method.isAnnotationPresent(Clear.class)) {
				result = proxy.invokeSuper(obj, args);
			}
			else {
				System.out.println(method.getName() + "方法执行之前调用");
				result = proxy.invokeSuper(obj, args);
				System.out.println(method.getName() + "方法执行之后调用");
			}
			return result;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T proxy(Class<T> clazz, Callback callback) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(callback);
		Object create = enhancer.create();
		return (T) create;
	}
	
	
	
	public static void main(String[] args) {
		HelloService helloService = proxy(HelloService.class, new BeforeMethod());
		helloService.sayHello();
		helloService.sayHelloHelloWorld();
	}
	
}

package com.qs.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.qs.proxy.proxy.Car;
import com.qs.proxy.proxy.Moveable;

/**
 * @author Administrator
 * JDK 动态代理 测试
 */
public class Test {

	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		Car car = new Car();
		InvocationHandler h = new TimeHandler(car);
		Class<?> cls = car.getClass();
		/**
		 * loader		被代理类加载器
		 * interfaces	实现接口
		 * h			InvocationHandler
		 * 
		 * 动态代理实现思路
		 * 实现功能：通过Proxy的newProxyInstance返回代理对象
		 * 1、声明一段源码（动态产生代理）
		 * 2、编译源码（JDK Compiler API） ，产生新的类（代理类）
		 * 3、将这个类load带内存中，产生一个新的对象（代理对象）
		 * 4、return 代理对象
		 * 
		 */
		Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);
		System.out.println(m.getClass().getName());
		m.move();
	}
}

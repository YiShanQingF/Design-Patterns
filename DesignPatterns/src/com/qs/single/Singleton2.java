package com.qs.single;
/**
 * 
 * @author Administrator
 * 懒汉模式
 * 区别：饿汉模式的特点是加载类时比较慢，但运行获取对象的速度比较快，线程安全
 *      懒汉模式的特点是类加载时比较快，但运行时获取对象的速度比较慢，线程不安全
 */
public class Singleton2 {

	//构造方法私有化，不允许外部直接创建对象
	private Singleton2(){
	}
	
	//声明类的唯一实例
	private static Singleton2 singleton2 ;
	
	//提供一个用于获取实例的方法
	public static Singleton2 getSingleton2(){
		if(null == singleton2){
			singleton2 = new Singleton2();
		}
		return singleton2;
	}
}

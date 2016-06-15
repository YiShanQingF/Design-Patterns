package com.qs.single;
/**
 * 
 * @author Administrator
 * 单例模式：Singleton
 * 作用：保证整个应用程序中的某个实例有且只有一个
 * 类型：饿汉，懒汉 
 *
 */
public class Singleton {
	
	//饿汉模式
	
	//构造方法私有化，不允许外部直接创建对象
	private Singleton(){
		
	}
	
	//创建类的唯一实例
	//static 类在加载的时会创建实例
	private static Singleton singleton = new Singleton();
	
	//提供一个用于获取实例的方法
	public static Singleton getSingleton(){
		return singleton;
	}
	
}

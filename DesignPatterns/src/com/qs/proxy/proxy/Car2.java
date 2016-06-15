package com.qs.proxy.proxy;

/**
 * @author Administrator
 * 
 * 静态代理
 * 继承
 */
public class Car2 extends Car {

	public void move(){
		
		long starttime = System.currentTimeMillis();
		System.out.println("汽车开始行驶...");
		
		super.move();

		long endtime = System.currentTimeMillis();
		System.out.println("汽车行驶结束... 汽车行驶时间:" + (endtime-starttime) + "毫秒！");

	}
}

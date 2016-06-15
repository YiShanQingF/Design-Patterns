package com.qs.proxy.proxy;

/**
 * @author Administrator
 * 
 * 静态代理
 * 聚合？一个类中调用另一个对象
 * 
 */
public class CarTimeProxy implements Moveable {

	private Moveable moveable;
	public CarTimeProxy(Moveable moveable) {
		super();
		this.moveable = moveable;
	}
	@Override
	public void move() {
		long starttime = System.currentTimeMillis();
		System.out.println("汽车开始行驶...");
		
		moveable.move();
		
		long endtime = System.currentTimeMillis();
		System.out.println("汽车行驶结束... 汽车行驶时间:" + (endtime-starttime) + "毫秒！");

	}

}

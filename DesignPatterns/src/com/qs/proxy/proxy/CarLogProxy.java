package com.qs.proxy.proxy;

/**
 * @author Administrator
 * 
 * 静态代理
 * 聚合？一个类中调用另一个对象
 * 
 */
public class CarLogProxy implements Moveable {

	private Moveable moveable;
	public CarLogProxy(Moveable moveable) {
		super();
		this.moveable = moveable;
	}
	@Override
	public void move() {
		System.out.println("日志开始...");
		moveable.move();
		System.out.println("日志结束");

	}

}

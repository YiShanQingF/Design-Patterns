package com.qs.proxy.proxy;

/**
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args) {
/*		Car car = new Car();
		car.move();
*/		
		//使用继承方式
/*		
		Moveable moveable = new Car2();
		moveable.move();
*/		
		//使用聚合方式
/*		
		Car car = new Car();
		Moveable moveable = new CarTimeProxy(car);
		moveable.move();
*/		
		
		//先记录日志
/*		Car car = new Car();
		CarTimeProxy carTimeProxy = new CarTimeProxy(car);
		CarLogProxy carLogProxy = new CarLogProxy(carTimeProxy);
		carLogProxy.move();
*/		
		//先记录时间
		Car car = new Car();
		CarLogProxy carLogProxy = new CarLogProxy(car);
		CarTimeProxy carTimeProxy = new CarTimeProxy(carLogProxy);
		carTimeProxy.move();
	}
}

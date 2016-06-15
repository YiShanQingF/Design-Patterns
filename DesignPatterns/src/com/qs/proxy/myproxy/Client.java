package com.qs.proxy.myproxy;

import com.qs.proxy.proxy.Car;
import com.qs.proxy.proxy.Moveable;

public class Client {

	public static void main(String[] args) throws Exception {

		Car car = new Car();
		
		Moveable moveable = (Moveable) Proxy.newProxyInstance(Moveable.class);
		moveable.move();
	}

}

package com.qs.proxy.cglibproxy;

/**
 * @author Administrator
 *
 */
public class Client {

	
	public static void main(String[] args) {
		CglibProxy cglibProxy = new CglibProxy();
		Train train = (Train) cglibProxy.getProxy(Train.class);
		train.move();
	}

}

package com.qs.proxy.myproxy;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.sun.java.swing.plaf.motif.resources.motif;

public class TimeHandler implements InvocationHandler {

	private Object target;
	
	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public void invoke(Object object, Method method) {
		
		try {
			
			long starttime = System.currentTimeMillis();
			System.out.println("自定义汽车开始行驶...");
			method.invoke(target);
			long endtime = System.currentTimeMillis();
			System.out.println("自定义汽车行驶结束... 汽车行驶时间:" + (endtime-starttime) + "毫秒！");
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}

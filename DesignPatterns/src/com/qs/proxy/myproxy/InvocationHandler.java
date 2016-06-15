package com.qs.proxy.myproxy;

import java.lang.reflect.Method;

public interface InvocationHandler {

	public void invoke(Object object , Method method );
}

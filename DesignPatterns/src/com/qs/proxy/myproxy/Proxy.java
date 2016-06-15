package com.qs.proxy.myproxy;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.commons.io.FileUtils;

import com.qs.proxy.proxy.Car;

/**
 * @author Administrator
 * 
 * 动态代理实现思路
 * 实现功能：通过Proxy的newProxyInstance返回代理对象
 * 1、声明一段源码（动态产生代理）
 * 2、编译源码（JDK Compiler API） ，产生新的类（代理类）
 * 3、将这个类load带内存中，产生一个新的对象（代理对象）
 * 4、return 代理对象
 */
public class Proxy {

	/**
	 * @return
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static Object newProxyInstance(Class infce , InvocationHandler h) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		String rt = "\r\n";
		String methodStr = "";
		for(Method m:infce.getMethods()){
			methodStr = 
			"	@Override" + rt +
			"	public void "+ m.getName() +"() {" + rt +
			"   try{" + rt +
			"   Method md = " + infce.getName() + ".getClass().getMethod(\"" + m.getName() + "\");" + rt +
			"   h.invoke(this,md)" + rt +
			"		moveable."+ m.getName() +"();" + rt +
			"   }catch(Exception e){e.printStackTrance();}" + rt +
			"	}" ;
		}
		String str = 
				"package com.qs.proxy.myproxy;" + rt +
				"import java.lang.reflect.Method;" + rt +
				"import com.qs.proxy.myproxy.InvocationHanler;" + rt +
				"public class $Proxy0 implements " + infce.getName() + "{" + rt +
				"	private " + infce.getName() + " moveable;" + rt +
				"	private InvocationHandler h ;" + rt +
				"	public $Proxy0(InvocationHandler h) {" + rt +
				"		this.h = h;" + rt +
				"	}" + rt +
				methodStr + rt +
				"}";

		//产生代理类的Java文件
		String filename = System.getProperty("user.dir") + "/bin/com/qs/proxy/myproxy/$Proxy0.java";
		File file = new File(filename);
		FileUtils.writeStringToFile(file, str);

		//编译
		//拿到编译器
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		//文件管理者	
		StandardJavaFileManager fileManager	= compiler.getStandardFileManager(null, null, null);
		//获取文件
		Iterable units = fileManager.getJavaFileObjects(filename);
		//编译任务
		CompilationTask t = compiler.getTask(null, fileManager, null, null, null, units);
		//进行编译
		t.call();
		fileManager.close();
		
		//load到内存中
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		Class c = classLoader.loadClass("com.qs.proxy.myproxy.$Proxy0");
		
		Constructor constructor = c.getConstructor(InvocationHandler.class);
		return constructor.newInstance(h);
	}
}

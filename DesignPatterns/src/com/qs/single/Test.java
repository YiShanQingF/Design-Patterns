package com.qs.single;


public class Test {
	
	public static void main(String[] args) {
		Singleton s1 = Singleton.getSingleton();
		Singleton s2 = Singleton.getSingleton();
		if(s1 == s2){
			System.out.println("s1和s2是同一个实例");
		}else{
			System.out.println("s1和s2不是同一个实例");
		}
		
		
		Singleton2 s3 = Singleton2.getSingleton2();
		Singleton2 s4 = Singleton2.getSingleton2();
		if(s3 == s4){
			System.out.println("s3和s4是同一个实例");
		}else{
			System.out.println("s3和s4不是同一个实例");
		}
	}
}

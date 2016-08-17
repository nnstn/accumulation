package com.pursuit.designmodel.singleton;

import java.io.Serializable;
public class Singleton1 implements Serializable{
	private Singleton1 instance = null;
	private Singleton1(){
		System.out.println("singleton init  NO.1");
	}
	private static class Singleton1Holder{
		public static Singleton1 instance = new Singleton1();
	}
	public static Singleton1 getInstance(){
		return Singleton1Holder.instance;
	}
	public void test(){
		System.out.println("this is a test");
	}
	//解决序列化问题 [实现了序列化接口]
	private Object readResolve() {     
        return Singleton1Holder.instance;     
    }
	//解决反射问题
//	private static Class getClass(String classname)   throws ClassNotFoundException {
//		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();     
//		if(classLoader == null) 
//			classLoader = Singleton1.class.getClassLoader(); 
//		return (classLoader.loadClass(classname)); 
//   }
}

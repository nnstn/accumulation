package com.pursuit.designmodel.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SingletonMain {
	public static void main(String[] args) throws Exception {
		//test3();
		//测试序列化
		//test4();
		//测试反射
		test5();
	}
	//1.静态内部类
	public static void test1(){
		//Singleton1.test();
		Singleton1 instance = Singleton1.getInstance();
	}
	//2.枚举类型
	//枚举类型在初始化时会自动将所有 枚举初始化
	public static void test2(){
		Singleton2.instance.getConnection();
		Singleton2.instance1.getConnection();
		Singleton2.instance2.getConnection();
		Singleton2 instance =Singleton2.instance;
	}
	//3.双重校验锁
	public static void test3(){
		
		//多线程环境
		new Thread(new Runnable() {
			@Override
			public void run() {
				Singleton3 instance = Singleton3.getInstance();
				
			}
		}).start();;
		Singleton3 instance1 = Singleton3.getInstance();
	}
	//4.序列化环境验证
	public static void test4() throws Exception{
		Singleton1 instance = Singleton1.getInstance();
		System.out.println(instance);
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("d:/instance.txt"));
		output.writeObject(instance);
		output.flush();
		output.close();
		
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("d:/instance.txt"));
		Singleton1 readObject = (Singleton1) input.readObject();
		System.out.println(readObject);
		System.out.println(readObject==instance);
		System.out.println(readObject==null);
		readObject.test();
		instance.test();
	}
	//5.测试反射
	public static void test5() throws Exception{
		Class<?> clazz = Class.forName("com.pursuit.designmodel.singleton.Singleton1");
		Constructor<?> constructor = clazz.getDeclaredConstructor();
		constructor.setAccessible(true);
		Singleton1 instance = (Singleton1) Class.forName("com.pursuit.designmodel.singleton.Singleton1").newInstance();
	}
}

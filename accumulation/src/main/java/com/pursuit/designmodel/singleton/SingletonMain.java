package com.pursuit.designmodel.singleton;

public class SingletonMain {
	public static void main(String[] args) {
		test3();
	}
	//1.静态内部类
	public static void test1(){
		Singleton1.test();
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
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Singleton3 instance = Singleton3.getInstance();
				
			}
		}).start();;
		Singleton3 instance1 = Singleton3.getInstance();
	}
}

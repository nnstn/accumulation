package com.pursuit.designmodel.singleton;

public class Singleton1 {
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
	public static void test(){
		System.out.println("this is a test");
	}
}

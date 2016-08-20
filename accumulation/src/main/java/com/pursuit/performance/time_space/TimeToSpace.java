package com.pursuit.performance.time_space;

/**
 * 使用时间换空间
 */
public class TimeToSpace {
	
	public static void exchangeAB(){
		int a =10;
		int b =15;
		//正常交换算法
		int temp = a;
		a=b;
		b=temp;
		
		System.out.println("a:"+a+"   b:"+b);
	}
	public static void exchangeAB1(){
		int a =10;
		int b =15;
		//时间换空间算法
		a=a+b;
		b=a-b;
		a=a-b;
		
		System.out.println("a:"+a+"   b:"+b);
	}
	public static void main(String[] args) {
		exchangeAB();
		exchangeAB1();
		
	}
}

package com.pursuit.designmodel.simplefactory;

/**
 *	简单工厂不是一个标准的世界模式。但是非常常用
 *	
 *	定义：提供一个创建对象实例的功能，而无须关心其具体实现，
 *	被创建实例的类型可以是接口，抽象类，也可以是具体的类
 *	
 *	
 */
public class SimpleFactory {
	//简单工厂做单例使用
	private SimpleFactory(){}
	
	static int count =0;
	
	public static API createAPI(){
		 if(count>=3){
			 count++;
			 return new ImplA();
		 }else {
			 count++;
			 return  new ImplB();
		 }
	}
}

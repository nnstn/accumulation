package com.pursuit.designmodel.singleton;
public class Singleton3 {
	private static Singleton3 instance = null;
	private Singleton3() {
    	System.out.println("私有化构造函数。初始化  Singleton3 NO.3");
    }
	public static Singleton3 getInstance(){
		if(null==instance){
			synchronized (Singleton3.class) {
				if(null==instance){
					instance = new Singleton3();
				}
			}
		}
		return instance;
	}
	
    public String getConnection() {
        System.out.println("枚举类型单例方法调用");
    	return "单例方法调用";
    }

}

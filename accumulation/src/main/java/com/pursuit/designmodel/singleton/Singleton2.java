package com.pursuit.designmodel.singleton;
public enum Singleton2 {
	instance{
		public void test(){
			System.out.println("this is test");
		}
	} ,instance1,instance2;
	
	private Singleton2() {
    	System.out.println("私有化构造函数。初始化");
    }

    public String getConnection() {
        System.out.println("枚举类型单例方法调用");
    	return "单例方法调用";
    }

}

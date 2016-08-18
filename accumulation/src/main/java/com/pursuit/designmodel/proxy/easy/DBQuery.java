package com.pursuit.designmodel.proxy.easy;

public class DBQuery implements IDBQuery {
	
	/**
	 * 真实主体创建比较耗时
	 * 使用代理实现延时加载
	 */
	public DBQuery(){
		try {
			Thread.currentThread().sleep(3000);
			System.out.println("===========创建真实对象完成============");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void request() {
		System.out.println("implements real subject");
	}

}

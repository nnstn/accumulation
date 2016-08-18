package com.pursuit.designmodel.proxy.easy;

public class ProxyMain {
	public static void main(String[] args) {
		IDBQuery query = new DBQueryProxy();
		System.out.println("===========真实对象此刻还未创建============");
		query.request();
	}
}
